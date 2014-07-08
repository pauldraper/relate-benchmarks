package controllers.streaming

import models.streaming._
import play.api._
import play.api.db._
import play.api.mvc._
import play.api.Play.current

/**
 * A controller that will run the streaming benchmarks.
 *
 * To run these benchmarks, create a database named 'temp', and then execute the commands found in
 * conf/setup/streaming-setup.sql and conf/setup/streaming-insert.sql
 */
object StreamingController extends Controller {

  def runStream() = Action {
    val results = List(
      StreamingModel.stream(1000, 1000),
      StreamingModel.stream(10000, 1000),
      StreamingModel.stream(100000, 1000),
      StreamingModel.stream(1000000, 1000)
    )
    Ok(views.html.streaming.streaming(results))
  }

}