package controllers
import play.api.db._
import java.sql.{Array =>_, _}
import play.api.Play.current

object JDBCTests {
  
  /**
   * Get a prepared statement that cleans itself up
   * 
   * @param conn Connection to use
   * @param query Query to run
   * @param f Callback
   * @return whatever the callback returns
   */
  
  def withPreparedStatement[A](conn: Connection, query: String)(f:(PreparedStatement) => A): A = {
    var statement: PreparedStatement = null
    try {
      statement = conn.prepareStatement(query)
      f(statement)
    }
    finally {
      if (statement != null) {
        statement.close()
      }
    }
  }

    
  
	

  def select1_int(nums:Seq[Int]) = {
      
      DB.withConnection { connection =>
        val queryBuilder = new StringBuilder((nums.size*2)+100,"SELECT `col14` FROM  `sel_50` WHERE `col44` IN (?" )
        var i = 1
        while (i < nums.size) {
          queryBuilder.append(",?")
          i += 1
        }
        queryBuilder.append(")")
      
            withPreparedStatement(connection,  queryBuilder.toString)
             { statement =>
                    var i = 1
                    while (i <= nums.size) {
                    statement.setInt(i, nums(i-1)) 
                    i += 1
                    }
             
                  statement.executeQuery()
            }
        }
        
    }

  def select1_long(nums:Seq[Long]) = {
      
      DB.withConnection { connection =>
        val queryBuilder = new StringBuilder((nums.size*2)+100,"SELECT `col14` FROM  `sel_50` WHERE `col44` IN (?" )
        var i = 1
        while (i < nums.size) {
          queryBuilder.append(",?")
          i += 1
        }
        queryBuilder.append(")")
      
            withPreparedStatement(connection,  queryBuilder.toString)
             { statement =>
                    var i = 1
                    while (i <= nums.size) {
                    statement.setLong(i, nums(i-1)) 
                    i += 1
                    }
             
                  statement.executeQuery()
            }
        }
        
    }  
  def select1_string(nums:Seq[String]) = {
      
      DB.withConnection { connection =>
        val queryBuilder = new StringBuilder((nums.size*2)+100,"SELECT `col14` FROM  `sel_50` WHERE `col44` IN (?" )
        var i = 1
        while (i < nums.size) {
          queryBuilder.append(",?")
          i += 1
        }
        queryBuilder.append(")")
      
            withPreparedStatement(connection,  queryBuilder.toString)
             { statement =>
                    var i = 1
                    while (i <= nums.size) {
                    statement.setString(i, nums(i-1)) 
                    i += 1
                    }
             
                  statement.executeQuery()
            }
        }
        
    }  

def select1_double(nums:Seq[Double]) = {
      
      DB.withConnection { connection =>
        val queryBuilder = new StringBuilder((nums.size*2)+100,"SELECT `col14` FROM  `sel_50` WHERE `col44` IN (?" )
        var i = 1
        while (i < nums.size) {
          queryBuilder.append(",?")
          i += 1
        }
        queryBuilder.append(")")
      
            withPreparedStatement(connection,  queryBuilder.toString)
             { statement =>
                    var i = 1
                    while (i <= nums.size) {
                    statement.setDouble(i, nums(i-1)) 
                    i += 1
                    }
             
                  statement.executeQuery()
            }
        }
        
    }

	def select2_int(nums:Seq[Int]) = {
        DB.withConnection { connection =>
        val queryBuilder = new StringBuilder((nums.size*2)+100,"SELECT `col45`,`col46`,`col47`,`col48`,`col49`,`col50`,`col1`,`col2`,`col3`,`col4`,`col5` FROM `sel_50` WHERE  `col18` IN (?" )
        var i = 1
        while (i < nums.size) {
          queryBuilder.append(",?")
          i += 1
        }
        queryBuilder.append(")")
      
            withPreparedStatement(connection,  queryBuilder.toString)
             { statement =>
                  var i = 1
                  while (i <= nums.size) {
                    statement.setInt(i, nums(i-1)) 
                    i += 1
                  } 
               statement.executeQuery()
            }
          }
	}
 def select2_long(nums:Seq[Long]) = {
    DB.withConnection { connection =>
        val queryBuilder = new StringBuilder((nums.size*2)+100,"SELECT `col45`,`col46`,`col47`,`col48`,`col49`,`col50`,`col1`,`col2`,`col3`,`col4`,`col5` FROM `sel_50` WHERE `col18` IN (?" )
        var i = 1
        while (i < nums.size) {
          queryBuilder.append(",?")
          i += 1
        }
        queryBuilder.append(")")
      
        withPreparedStatement(connection,  queryBuilder.toString)
         { statement =>
              var i = 1
              while (i <= nums.size) {
                statement.setLong(i, nums(i-1)) 
                i += 1
              } 
           statement.executeQuery()
        }
     }
  }

 def select2_string(nums:Seq[String]) = {
    DB.withConnection { connection =>
        val queryBuilder = new StringBuilder((nums.size*2)+100,"SELECT `col45`,`col46`,`col47`,`col48`,`col49`,`col50`,`col1`,`col2`,`col3`,`col4`,`col5` FROM `sel_50` WHERE  `col18` IN (?" )
        var i = 1
        while (i < nums.size) {
          queryBuilder.append(",?")
          i += 1
        }
        queryBuilder.append(")")
      
        withPreparedStatement(connection,  queryBuilder.toString)
         { statement =>
              var i = 1
              while (i <= nums.size) {
                statement.setString(i, nums(i-1)) 
                i += 1
              } 
           statement.executeQuery()
        }
     }
  }

 def select2_double(nums:Seq[Double]) = {
    DB.withConnection { connection =>
        val queryBuilder = new StringBuilder((nums.size*2)+100,"SELECT `col45`,`col46`,`col47`,`col48`,`col49`,`col50`,`col1`,`col2`,`col3`,`col4`,`col5` FROM `sel_50` WHERE  `col18` IN (?" )
        var i = 1
        while (i < nums.size) {
          queryBuilder.append(",?")
          i += 1
        }
        queryBuilder.append(")")
      
        withPreparedStatement(connection,  queryBuilder.toString)
         { statement =>
              var i = 1
              while (i <= nums.size) {
                statement.setDouble(i, nums(i-1)) 
                i += 1
              } 
           statement.executeQuery()
        }
     }
  }





	def select3_int(nums:Seq[Int]) = {
		   DB.withConnection { connection =>
        val queryBuilder = new StringBuilder((nums.size*2)+100,"SELECT `col1`,`col2`,`col3`,`col4`,`col5`,`col6`,`col7`,`col8`,`col9`,`col10`,`col11`,`col12`,`col13`,`col14`,`col15`,`col16`,`col17`,`col18`,`col19`,`col20`,`col21`,`col22`,`col23`,`col24`,`col25` FROM `sel_50` WHERE  `col18` IN (?" )
        var i = 1
        while (i < nums.size) {
          queryBuilder.append(",?")
          i += 1
        }
        queryBuilder.append(")")
      
        withPreparedStatement(connection,  queryBuilder.toString)
         { statement =>
         
              var i = 1
              while (i <= nums.size) {
                statement.setInt(i, nums(i-1)) 
                i += 1
              }
              statement.executeQuery()
        }
      } 
	}


  def select3_long(nums:Seq[Long]) = {
       DB.withConnection { connection =>
        val queryBuilder = new StringBuilder((nums.size*2)+100,"SELECT `col1`,`col2`,`col3`,`col4`,`col5`,`col6`,`col7`,`col8`,`col9`,`col10`,`col11`,`col12`,`col13`,`col14`,`col15`,`col16`,`col17`,`col18`,`col19`,`col20`,`col21`,`col22`,`col23`,`col24`,`col25` FROM `sel_50` WHERE  `col18` IN (?" )
        var i = 1
        while (i < nums.size) {
          queryBuilder.append(",?")
          i += 1
        }
        queryBuilder.append(")")
      
        withPreparedStatement(connection,  queryBuilder.toString)
         { statement =>
         
              var i = 1
              while (i <= nums.size) {
                statement.setLong(i, nums(i-1)) 
                i += 1
              }
              statement.executeQuery()
        }
      } 
  }


  def select3_string(nums:Seq[String]) = {
       DB.withConnection { connection =>
        val queryBuilder = new StringBuilder((nums.size*2)+100,"SELECT `col1`,`col2`,`col3`,`col4`,`col5`,`col6`,`col7`,`col8`,`col9`,`col10`,`col11`,`col12`,`col13`,`col14`,`col15`,`col16`,`col17`,`col18`,`col19`,`col20`,`col21`,`col22`,`col23`,`col24`,`col25` FROM `sel_50` WHERE  `col18` IN (?" )
        var i = 1
        while (i < nums.size) {
          queryBuilder.append(",?")
          i += 1
        }
        queryBuilder.append(")")
      
        withPreparedStatement(connection,  queryBuilder.toString)
         { statement =>
         
              var i = 1
              while (i <= nums.size) {
                statement.setString(i, nums(i-1)) 
                i += 1
              }
              statement.executeQuery()
        }
      } 
  }
	

  def select3_double(nums:Seq[Double]) = {
       DB.withConnection { connection =>
        val queryBuilder = new StringBuilder((nums.size*2)+100,"SELECT `col1`,`col2`,`col3`,`col4`,`col5`,`col6`,`col7`,`col8`,`col9`,`col10`,`col11`,`col12`,`col13`,`col14`,`col15`,`col16`,`col17`,`col18`,`col19`,`col20`,`col21`,`col22`,`col23`,`col24`,`col25` FROM `sel_50` WHERE ``col18` IN (?" )
        var i = 1
        while (i < nums.size) {
          queryBuilder.append(",?")
          i += 1
        }
        queryBuilder.append(")")
      
        withPreparedStatement(connection,  queryBuilder.toString)
         { statement =>
         
              var i = 1
              while (i <= nums.size) {
                statement.setDouble(i, nums(i-1)) 
                i += 1
              }
              statement.executeQuery()
        }
      } 
  }

	def insert1_int(rows:Seq[Int]) = {
      val cols = 10
	      DB.withConnection { connection =>
        val queryBuilder = new StringBuilder((cols*2)+100,"INSERT INTO `ins_10` VALUES  (?" )
        var i = 1
        while (i < cols) {
          queryBuilder.append(",?")
          i += 1
        }
        queryBuilder.append(")")
       rows.foreach { row =>
            withPreparedStatement(connection,  queryBuilder.toString)
             { statement =>
                  var i = 1
                  while (i <= cols) {
                    statement.setInt(i, row) 
                    i += 1
                  }
                  statement.executeUpdate()
            }
        }
        }
    }
  
  def insert1_long(rows:Seq[Long]) = {
    val cols =10
        DB.withConnection { connection =>
        val queryBuilder = new StringBuilder((cols*2)+100,"INSERT INTO `ins_10` VALUES  (?" )
        var i = 1
        while (i < cols) {
          queryBuilder.append(",?")
          i += 1
        }
        queryBuilder.append(")")
       rows.foreach { row =>
            withPreparedStatement(connection,  queryBuilder.toString)
             { statement =>
                  var i = 1
                  while (i <= cols) {
                    statement.setLong(i, row) 
                    i += 1
                  }
                  statement.executeUpdate()
            }
        }
        }
    }
      
  def insert1_string(rows:Seq[String]) = {
    val cols=10
        DB.withConnection { connection =>
        val queryBuilder = new StringBuilder((cols*2)+100,"INSERT INTO `ins_10` VALUES (?" )
        var i = 1
        while (i < cols) {
          queryBuilder.append(",?")
          i += 1
        }
        queryBuilder.append(")")
       rows.foreach { row =>
            withPreparedStatement(connection,  queryBuilder.toString)
             { statement =>
                  var i = 1
                  while (i <= cols) {
                    statement.setString(i, row) 
                    i += 1
                  }
                  statement.executeUpdate()
             }
        }
        }
    }
 

  def insert1_double(rows:Seq[Double]) = {
        val cols = 10
        DB.withConnection { connection =>
        val queryBuilder = new StringBuilder((cols*2)+100,"INSERT INTO `ins_10` VALUES  (?" )
        var i = 1
        while (i < cols) {
          queryBuilder.append(",?")
          i += 1
        }
        queryBuilder.append(")")
       rows.foreach { row =>
            withPreparedStatement(connection,  queryBuilder.toString)
             { statement =>
                  var i = 1
                  while (i <= cols) {
                    statement.setDouble(i, row) 
                    i += 1
                  }
                  statement.executeUpdate()
             }
        }
        }
    }
 


  def insert2_int(rows:Seq[Int]) = {
      val cols = 50
        DB.withConnection { connection =>
        val queryBuilder = new StringBuilder((cols*2)+100,"INSERT INTO `ins_50` VALUES  (?" )
        var i = 1
        while (i < cols) {
          queryBuilder.append(",?")
          i += 1
        }
        queryBuilder.append(")")
       rows.foreach { row =>
            withPreparedStatement(connection,  queryBuilder.toString)
             { statement =>
                  var i = 1
                  while (i <= cols) {
                    statement.setInt(i, row) 
                    i += 1
                  }
                  statement.executeUpdate()
            }
        }
        }
    }
  
  def insert2_long(rows:Seq[Long]) = {
    val cols =50
        DB.withConnection { connection =>
        val queryBuilder = new StringBuilder((cols*2)+100,"INSERT INTO `ins_50` VALUES  (?" )
        var i = 1
        while (i < cols) {
          queryBuilder.append(",?")
          i += 1
        }
        queryBuilder.append(")")
       rows.foreach { row =>
            withPreparedStatement(connection,  queryBuilder.toString)
             { statement =>
                  var i = 1
                  while (i <= cols) {
                    statement.setLong(i, row) 
                    i += 1
                  }
                  statement.executeUpdate()
            }
        }
        }
    }
      
  def insert2_string(rows:Seq[String]) = {
    val cols = 50
        DB.withConnection { connection =>
        val queryBuilder = new StringBuilder((cols*2)+100,"INSERT INTO `ins_50` VALUES  (?" )
        var i = 1
        while (i < cols) {
          queryBuilder.append(",?")
          i += 1
        }
        queryBuilder.append(")")
       rows.foreach { row =>
            withPreparedStatement(connection,  queryBuilder.toString)
             { statement =>
                  var i = 1
                  while (i <= cols) {
                    statement.setString(i, row) 
                    i += 1
                  }
                  statement.executeUpdate()
             }
        }
        }
    }
 

  def insert2_double(rows:Seq[Double]) = {
    val cols =50
        DB.withConnection { connection =>
        val queryBuilder = new StringBuilder((cols*2)+100,"INSERT INTO `ins_50` VALUES  (?" )
        var i = 1
        while (i < cols) {
          queryBuilder.append(",?")
          i += 1
        }
        queryBuilder.append(")")
       rows.foreach { row =>
            withPreparedStatement(connection,  queryBuilder.toString)
             { statement =>
                  var i = 1
                  while (i <= cols) {
                    statement.setDouble(i, row) 
                    i += 1
                  }
                  statement.executeUpdate()
             }
        }
        }
    }


  def insert3_int(rows:Seq[Int]) = {
      val cols = 100
        DB.withConnection { connection =>
        val queryBuilder = new StringBuilder((cols*2)+100,"INSERT INTO `ins_100` VALUES  (?" )
        var i = 1
        while (i < cols) {
          queryBuilder.append(",?")
          i += 1
        }
        queryBuilder.append(")")
       rows.foreach { row =>
            withPreparedStatement(connection,  queryBuilder.toString)
             { statement =>
                  var i = 1
                  while (i <= cols) {
                    statement.setInt(i, row) 
                    i += 1
                  }
                  statement.executeUpdate()
            }
        }
        }
    }
  
  def insert3_long(rows:Seq[Long]) = {
    val cols = 100
        DB.withConnection { connection =>
        val queryBuilder = new StringBuilder((cols*2)+100,"INSERT INTO `ins_100` VALUES (?" )
        var i = 1
        while (i < cols) {
          queryBuilder.append(",?")
          i += 1
        }
        queryBuilder.append(")")
       rows.foreach { row =>
            withPreparedStatement(connection,  queryBuilder.toString)
             { statement =>
                  var i = 1
                  while (i <= cols) {
                    statement.setLong(i, row) 
                    i += 1
                  }
                  statement.executeUpdate()
            }
        }
        }
    }
      
  def insert3_string(rows:Seq[String]) = {
    val cols = 100
        DB.withConnection { connection =>
        val queryBuilder = new StringBuilder((cols*2)+100,"INSERT INTO `ins_100` VALUES  (?" )
        var i = 1
        while (i < cols) {
          queryBuilder.append(",?")
          i += 1
        }
        queryBuilder.append(")")
       rows.foreach { row =>
            withPreparedStatement(connection,  queryBuilder.toString)
             { statement =>
                  var i = 1
                  while (i <= cols) {
                    statement.setString(i, row) 
                    i += 1
                  }
                  statement.executeUpdate()
             }
        }
        }
    }
 

  def insert3_double(rows:Seq[Double]) = {
    val cols = 100
        DB.withConnection { connection =>
        val queryBuilder = new StringBuilder((cols*2)+100,"INSERT INTO `ins_100` VALUES  (?" )
        var i = 1
        while (i < cols) {
          queryBuilder.append(",?")
          i += 1
        }
        queryBuilder.append(")")
       rows.foreach { row =>
            withPreparedStatement(connection,  queryBuilder.toString)
             { statement =>
                  var i = 1
                  while (i <= cols) {
                    statement.setDouble(i, row) 
                    i += 1
                  }
                  statement.executeUpdate()
             }
        }
        }
    }



	def update1_int(nums:Seq[Int]) = {
        
        DB.withConnection { connection =>
        val queryBuilder = new StringBuilder((nums.size*2)+100,"UPDATE `sel_50` SET `col13`=16 ,`col33`=19 where `col22` IN (?" )
        var i = 1
        while (i < nums.size) {
          queryBuilder.append(",?")
          i += 1
        }
        queryBuilder.append(")")
       
        withPreparedStatement(connection,  queryBuilder.toString)
             { statement =>
                  var i = 1
                  while (i <= nums.size) {
                    statement.setInt(i, nums(i-1)) 
                    i += 1
                  }
                  statement.executeUpdate()
            }
          }
        
      }

  def update1_long(nums:Seq[Long]) = {

        DB.withConnection { connection =>
        val queryBuilder = new StringBuilder((nums.size*2)+100,"UPDATE `sel_50` SET `col13`=16 ,`col33`=19 where `col22` IN (?" )
        var i = 1
        while (i < nums.size) {
          queryBuilder.append(",?")
          i += 1
        }
        queryBuilder.append(")")
       
        withPreparedStatement(connection,  queryBuilder.toString)
             { statement =>
                  var i = 1
                  while (i <= nums.size) {
                    statement.setLong(i, nums(i-1)) 
                    i += 1
                  }
                  statement.executeUpdate()
            }
          }
        
      }

  def update1_string(nums:Seq[String]) = {
     
        DB.withConnection { connection =>
        val queryBuilder = new StringBuilder((nums.size*2)+100,"UPDATE `sel_50` SET `col13`='16' ,`col33`='19' where `col22` IN (?" )
        var i = 1
        while (i < nums.size) {
          queryBuilder.append(",?")
          i += 1
        }
        queryBuilder.append(")")
       
        withPreparedStatement(connection,  queryBuilder.toString)
             { statement =>
                  var i = 1
                  while (i <= nums.size) {
                    statement.setString(i, nums(i-1)) 
                    i += 1
                  }
                  statement.executeUpdate()
            }
          }
        
      }

def update1_double(nums:Seq[Double]) = {
      
        DB.withConnection { connection =>
        val queryBuilder = new StringBuilder((nums.size*2)+100,"UPDATE `sel_50` SET `col13`=16 ,`col33`=19 where `col22` IN (?" )
        var i = 1
        while (i < nums.size) {
          queryBuilder.append(",?")
          i += 1
        }
        queryBuilder.append(")")
       
        withPreparedStatement(connection,  queryBuilder.toString)
             { statement =>
                  var i = 1
                  while (i <= nums.size) {
                    statement.setDouble(i, nums(i-1)) 
                    i += 1
                  }
                  statement.executeUpdate()
            }
          }
        
      }


	def update2_int(nums:Seq[Int]) = {

        
        DB.withConnection { connection =>
        val queryBuilder = new StringBuilder((nums.size*2)+100,"UPDATE `sel_50` SET `col1`=16 ,`col43`=19, `col45`=14, `col32`=45, `col26`=254,`col3`=34, `col5`=235, `col12`=5, `col29`=234, `col17`=34 where `col12` IN  (?" )
        var i = 1
        while (i < nums.size) {
          queryBuilder.append(",?")
          i += 1
        }
        queryBuilder.append(")")
       
        withPreparedStatement(connection,  queryBuilder.toString)
             { statement =>
                  
                  var i = 1
                  while (i <= nums.size) {
                    statement.setInt(i, nums(i-1)) 
                    i += 1
                  }
         
                  statement.executeUpdate()
            }
          }  
		

	     }
  

  def update2_long(nums:Seq[Long]) = {

        
        DB.withConnection { connection =>
        val queryBuilder = new StringBuilder((nums.size*2)+100,"UPDATE `sel_50` SET `col1`=16 ,`col43`=19, `col45`=14, `col32`=45, `col26`=254,`col3`=34, `col5`=235, `col12`=5, `col29`=234, `col17`=34 where `col12` IN  (?" )
        var i = 1
        while (i < nums.size) {
          queryBuilder.append(",?")
          i += 1
        }
        queryBuilder.append(")")
       
        withPreparedStatement(connection,  queryBuilder.toString)
             { statement =>
                  
                  var i = 1
                  while (i <= nums.size) {
                    statement.setLong(i, nums(i-1)) 
                    i += 1
                  }
         
                  statement.executeUpdate()
            }
          }  
    

       }
  
  def update2_string(nums:Seq[String]) = {

        
        DB.withConnection { connection =>
        val queryBuilder = new StringBuilder((nums.size*2)+100,"UPDATE `sel_50` SET `col1`='16' ,`col43`='19', `col45`='14', `col32`='45', `col26`='254',`col3`='34', `col5`='235', `col12`='5', `col29`='234', `col17`='34' where `col12` IN  (?" )
        var i = 1
        while (i < nums.size) {
          queryBuilder.append(",?")
          i += 1
        }
        queryBuilder.append(")")
       
        withPreparedStatement(connection,  queryBuilder.toString)
             { statement =>
                  
                  var i = 1
                  while (i <= nums.size) {
                    statement.setString(i, nums(i-1)) 
                    i += 1
                  }
         
                  statement.executeUpdate()
            }
          }  
    

       }
  
  def update2_double(nums:Seq[Double]) = {

        
        DB.withConnection { connection =>
        val queryBuilder = new StringBuilder((nums.size*2)+100,"UPDATE `sel_50` SET `col1`=16 ,`col43`=19, `col45`=14, `col32`=45, `col26`=254,`col3`=34, `col5`=235, `col12`=5, `col29`=234, `col17`=34 where `col12` IN  (?" )
        var i = 1
        while (i < nums.size) {
          queryBuilder.append(",?")
          i += 1
        }
        queryBuilder.append(")")
       
        withPreparedStatement(connection,  queryBuilder.toString)
             { statement =>
                  
                  var i = 1
                  while (i <= nums.size) {
                    statement.setDouble(i, nums(i-1)) 
                    i += 1
                  }
         
                  statement.executeUpdate()
            }
          }  
    

       }
   def update3_int(nums:Seq[Int]) = {

 
        DB.withConnection { connection =>
        val queryBuilder = new StringBuilder((nums.size*2)+100,"UPDATE `sel_50` SET `col1`=16 ,`col43`=19, `col45`=14, `col32`=45, `col26`=254,`col3`=34, `col5`=235, `col12`=5, `col29`=234, `col17`=34,`col18`=423, `col19`=341, `col27`=3243, `col28`=2315, `col25`=1234, `col33` = 34126, `col34` = 23425, `col35`=342 ,`col1`=234, `col49`=3576 where `col12` IN  (?" )
        var i = 1
        while (i < nums.size) {
          queryBuilder.append(",?")
          i += 1
        }
        queryBuilder.append(")")
       
        withPreparedStatement(connection,  queryBuilder.toString)
             { statement =>
                  
                  var i = 1
                  while (i <= nums.size) {
                    statement.setInt(i, nums(i-1)) 
                    i += 1
                  }
         
                  statement.executeUpdate()
            }
          }  
    

       }

     def update3_long(nums:Seq[Long]) = {

        DB.withConnection { connection =>
        val queryBuilder = new StringBuilder((nums.size*2)+100,"UPDATE `sel_50` SET `col1`=16 ,`col43`=19, `col45`=14, `col32`=45, `col26`=254,`col3`=34, `col5`=235, `col12`=5, `col29`=234, `col17`=34 ,`col18`=423, `col19`=341, `col27`=3243, `col28`=2315, `col25`=1234, `col33` = 34126, `col34` = 23425 ,`col35`=342 ,`col1`=234, `col49`=3576 WHERE `col12` IN  (?" )
        var i = 1
        while (i < nums.size) {
          queryBuilder.append(",?")
          i += 1
        }
        queryBuilder.append(")")
       
        withPreparedStatement(connection,  queryBuilder.toString)
             { statement =>
                  
                  var i = 1
                  while (i <= nums.size) {
                    statement.setLong(i, nums(i-1)) 
                    i += 1
                  }
         
                  statement.executeUpdate()
            }
          }  
    

       }
  
  def update3_string(nums:Seq[String]) = {

        DB.withConnection { connection =>
        val queryBuilder = new StringBuilder((nums.size*2)+100,"UPDATE `sel_50` SET `col1`='16' ,`col43`='19', `col45`='14', `col32`='45', `col26`='254',`col3`='34', `col5`='235', `col12`='5', `col29`='234', `col17`='34' ,`col18`=423, `col19`=341, `col27`=3243, `col28`=2315, `col25`=1234, `col33` = 34126, `col34` = 23425, `col35`=342 ,`col1`=234, `col49`=3576 WHERE `col12` IN  (?" )
        var i = 1
        while (i < nums.size) {
          queryBuilder.append(",?")
          i += 1
        }
        queryBuilder.append(")")
       
        withPreparedStatement(connection,  queryBuilder.toString)
             { statement =>
                  
                  var i = 1
                  while (i <= nums.size) {
                    statement.setString(i, nums(i-1)) 
                    i += 1
                  }
         
                  statement.executeUpdate()
            }
          }  
    

       }
  
  def update3_double(nums:Seq[Double]) = {

       
        DB.withConnection { connection =>
        val queryBuilder = new StringBuilder((nums.size*2)+100,"UPDATE `sel_50` SET `col1`=16 ,`col43`=19, `col45`=14, `col32`=45, `col26`=254,`col3`=34, `col5`=235, `col12`=5, `col29`=234, `col17`=34 ,`col18`=423, `col19`=341. `col27`=3243, `col28`=2315, `col25`=1234, `col33` = 34126, `col34` = 23425, `col35`=342 ,`col1`=234, `col49`=3576 WHERE `col12` IN  (?" )
        var i = 1
        while (i < nums.size) {
          queryBuilder.append(",?")
          i += 1
        }
        queryBuilder.append(")")
       
        withPreparedStatement(connection,  queryBuilder.toString)
             { statement =>
                  
                  var i = 1
                  while (i <= nums.size) {
                    statement.setDouble(i, nums(i-1)) 
                    i += 1
                  }
         
                  statement.executeUpdate()
            }
          }  
    

       }  
  

  }