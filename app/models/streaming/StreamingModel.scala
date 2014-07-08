package models.streaming

import com.lucidchart.open.relate._
import com.lucidchart.open.relate.Query._
import play.api.db._
import play.api.Play.current

case class Benchmark(
  numRecords: Long,
  relate: Result,
  asIterator: Result,
  limitOffset: Result,
  userSupplied: Result
)

case class Result(
  time: Long,
  query: String,
  error: Option[String] = None
)

class OutOfTimeException extends Exception

object StreamingModel {
  val milliCutoff = 10000

  case class Streaming(
    id: Long,
    string: String
  )

  val streamingParser = RowParser { row =>
    Streaming(
      row.long("id"),
      row.string("string")
    )
  }

  /**
   * Run a test of streaming with a result set of a specific size
   * @param limit the number of records to search
   * @param pageSize the size of pages for paginated queries
   * @return the results of the test case
   */
  def stream(limit: Long, pageSize: Int): Benchmark = {
    val relateResult = relate(limit)
    println("done with relate, rows: " + limit + "\n\t" + relateResult)
    val asIteratorResult = asIterator(limit)
    println("done with asIterator, rows: " + limit + "\n\t" + asIteratorResult)
    val limitOffsetResult = limitOffset(limit, pageSize)
    println("done with limitOffset, rows: " + limit + "\n\t" + limitOffsetResult)
    val userSuppliedResult = userSupplied(limit, pageSize)
    println("done with userSupplied, rows: " + limit + "\n\t" + userSuppliedResult)

    Benchmark(
      limit,
      relateResult,
      asIteratorResult,
      limitOffsetResult,
      userSuppliedResult
    )
  }

  /**
   * Use Relate as baseline for streaming
   * @param limit the number of records to search
   * @return the result of the query
   */
  def relate(limit: Long): Result = {
    DB.withConnection { implicit connection =>
      try {
        val (ignored, ms) = time {
          (0 until 20).foreach { i =>
            withCutoff {
              SQL("""
                SELECT id, string
                FROM streaming
                WHERE id < {limit}
              """).on { implicit query =>
                long("limit", limit)
              }.asList(streamingParser).size
            }
          }
        }
        
        Result(
          ms,
          "SELECT id, string FROM streaming, WHERE id < " + limit
        )
      }
      catch {
        case e: OutOfTimeException => Result(-1L, "SELECT id, string FROM streaming, WHERE id < " + limit)
        case e: Exception => Result(-2L, "SELECT id, string FROM streaming, WHERE id < " + limit, Some(e.getMessage))
      }
    }
  }

  /**
   * Get results for asIterator
   * @param limit the number of records to search
   * @return the result of the query
   */
  def asIterator(limit: Long): Result = {
    DB.withConnection { implicit connection =>
      try {
        val (ignored, ms) = time {
          (0 until 20).foreach { i =>
            withCutoff {
              val iterator = SQL("""
                SELECT id, string
                FROM streaming
                WHERE id < {limit}
              """).on { implicit query =>
                long("limit", limit)
              }.asIterator(streamingParser)

              var count = 0
              while (iterator.hasNext) {
                val record = iterator.next()
                count += 1
              }
              count
            }
          }
        }

        Result(
          ms,
          "SELECT id, string FROM streaming WHERE id < " + limit
        )
      }
      catch {
        case e: OutOfTimeException => Result(-1L, "SELECT id, string FROM streaming, WHERE id < " + limit)
        case e: Exception => Result(-2L, "SELECT id, string FROM streaming WHERE id < " + limit, Some(e.getMessage))
      }
    }
  }

  /**
   * Get results for pagination with LIMIT/OFFSET
   * @param limit the number of records to search
   * @param pageSize the size of each page
   * @return the result of the query
   */
  def limitOffset(limit: Long, pageSize: Int): Result = {
    DB.withConnection { implicit connection =>
      try {
        val (ignored, ms) = time {
          (0 until 20).foreach { i =>
            withCutoff {
              val stream = PaginatedQuery(streamingParser, pageSize, 0) {
                SQL("""
                  SELECT id, string
                  FROM streaming
                  WHERE id < {limit}
                """).on { implicit query =>
                  long("limit", limit)
                }
              }

              val count = stream.foldLeft(0) { case (result, current) =>
                result + 1
              }
            }
          }
        }

        Result(
          ms,
          "SELECT id, string FROM streaming WHERE id < " + limit + " LIMIT " + pageSize + " OFFSET {offset}"
        )
      }
      catch {
        case e: OutOfTimeException => Result(-1L, "SELECT id, string FROM streaming WHERE id < " + limit + " LIMIT " + pageSize + " OFFSET {offset}")
        case e: Exception => Result(-2L, "SELECT id, string FROM streaming WHERE id < " + limit + " LIMIT " + pageSize + " OFFSET {offset}", Some(e.getMessage))
      }
    }
  }

  /**
   * Get results for pagination with user supplied queries
   * @param limit the number of records to search
   * @param pageSize the size of each page
   * @return the result of the query
   */
  def userSupplied(limit: Long, pageSize: Int): Result = {
    DB.withConnection { implicit connection =>
      try {
        val (ignored, ms) = time {
          (0 until 20).foreach { i =>
            withCutoff {
              val stream = PaginatedQuery(streamingParser) { lastRecordOption =>
                SQL("""
                  SELECT id, string
                  FROM streaming
                  WHERE id > {offset} AND id < {upperLimit} LIMIT {limit}
                """).on { implicit query =>
                  long("offset", lastRecordOption.map(_.id).getOrElse(-1L))
                  long("upperLimit", limit)
                  int("limit", pageSize)
                }
              }

              val count = stream.foldLeft(0) { case (result, current) =>
                result + 1
              }
            }
          }
        }

        Result(
          ms,
          "SELECT id, string FROM streaming WHERE id > {offset} AND id < " + limit + " LIMIT " + pageSize
        )
      }
      catch {
        case e: OutOfTimeException => Result(-1L, "SELECT id, string FROM streaming WHERE id > {offset} AND id < " + limit + " LIMIT " + pageSize)
        case e: Exception => Result(-2L, "SELECT id, string FROM streaming WHERE id > {offset} AND id < " + limit + " LIMIT " + pageSize, Some(e.getMessage))
      }
    }
  }

  /**
   * Do an operation and throw an exception if it takes more than the cutoff to do
   * @param callback the function to do
   * @return whatever the function returns
   */
  def withCutoff[A](callback: => A): A = {
    val start = System.currentTimeMillis
    val ret = callback
    val end = System.currentTimeMillis

    if (end - start > milliCutoff) {
      throw new OutOfTimeException
    }
    ret
  }

  /**
   * Time an operation
   * @param callback the function to time
   * @return a tuple of whatever the callback returns and the time it took
   */
  def time[A](callback: => A): (A, Long) = {
    val start = System.currentTimeMillis
    val ret = callback
    val end = System.currentTimeMillis
    (ret, end - start)
  }

}