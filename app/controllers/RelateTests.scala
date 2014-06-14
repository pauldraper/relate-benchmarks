package controllers

import play.api.Play.current
import play.api.db._
import com.lucidchart.open.relate._
import com.lucidchart.open.relate.Query._
object RelateTests {
    val nums = (1 to 100)
    val numsLong = (1L to 100L)
    val numsInt = nums
    
    val numsDouble = numsLong.map { _.toDouble}
    val numsString = numsLong.map { _.toString}
    
    val numsInt_1 = (1 to 1000)
    val numsLong_1 = (1L to 1000L)
    val numsDouble_1 = numsInt_1.map{_.toDouble}
    val numsString_1 = numsInt_1.map{_.toString}

    val numsInt_2 = (1 to 10000)
    val numsLong_2 = (1L to 10000L)
    val numsDouble_2 = numsInt_2.map{_.toDouble}
    val numsString_2 = numsInt_2.map{_.toString}


    
    val rows = 250000
    val rowsString = (1 to rows).map{_.toString}
    val rowsDouble = (1 to rows).map{_.toDouble}
    


	def select1_int(nums:Seq[Int]) = {

		DB.withConnection { implicit connection =>
  			SQL("SELECT `col14` FROM  `sel_50` WHERE `col44` IN ({nums}) ").expand { implicit ex => 
  				commaSeparated("nums", nums.size)
  				}.on { implicit stmt => 
          	ints("nums",nums)
  					}.executeQuery().asList(RowParser {row => 
  						row.int("col14")
  					})
  			}

	}
  def select1_long(nums:Seq[Long]) = {

    DB.withConnection { implicit connection =>
        SQL("SELECT `col14` FROM  `sel_50` WHERE `col44` IN ({nums}) ").expand { implicit ex => 
          commaSeparated("nums", nums.size)
          }.on { implicit stmt => 
              longs("nums",nums)
            }.executeQuery().asList(RowParser { row => 
              row.long("col14")
            })
        }

  }

  def select1_string(nums:Seq[String]) = {

    DB.withConnection { implicit connection =>
        SQL("SELECT `col14` FROM  `sel_50` WHERE `col44` IN ({nums}) ").expand { implicit ex => 
          commaSeparated("nums", nums.size)
          }.on { implicit stmt => 
              strings("nums",nums)
             }.executeQuery().asList(RowParser { row => 
              row.string("col14")
            })
        }

  }
  def select1_double(nums:Seq[Double]) = {

    DB.withConnection { implicit connection =>
        SQL("SELECT `col14` FROM  `sel_50` WHERE `col44` IN ({nums}) ").expand { implicit ex => 
          commaSeparated("nums", nums.size)
          }.on { implicit stmt => 
            doubles("nums",nums)
            }.executeQuery().asList( RowParser {row =>  row.double("col14")
            } )
        }
  }

	def select2_long(nums :Seq[Long]) = {
			DB.withConnection { implicit connection =>
  			SQL("SELECT `col45`,`col46`,`col47`,`col48`,`col49`,`col50`,`col1`,`col2`,`col3`,`col4`,`col5` FROM `sel_50` WHERE  `col18` IN ({nums})  ").expand { implicit ex => 
  				commaSeparated("nums", nums.size)
  				}.on { implicit stmt => 
  						longs("nums",nums)
  					}
  				.executeQuery().asList( RowParser {row => 
  							                      row.long("col45")
                                      row.long("col46")
                                      row.long("col47")
                                      row.long("col48")
                                      row.long("col49")
                                      row.long("col50")
                                      row.long("col1")
                                      row.long("col2")
                                      row.long("col3")
                                      row.long("col4")
                                      row.long("col5")
  					
  				                        	}
  								              )
  			}


	}

  def select2_int(nums :Seq[Int]) = {
      DB.withConnection { implicit connection =>
        SQL("SELECT `col45`,`col46`,`col47`,`col48`,`col49`,`col50`,`col1`,`col2`,`col3`,`col4`,`col5` FROM `sel_50` WHERE  `col18` IN ({nums})  ").expand { implicit ex => 
          commaSeparated("nums", nums.size)
          }.on { implicit stmt => 
              ints("nums",nums)
            }
          .executeQuery().asList( RowParser {row => 
                                      row.int("col45")
                                      row.int("col46")
                                      row.int("col47")
                                      row.int("col48")
                                      row.int("col49")
                                      row.int("col50")
                                      row.int("col1")
                                      row.int("col2")
                                      row.int("col3")
                                      row.int("col4")
                                      row.int("col5")
            
                                    }
                                )
        }


  }

  def select2_string(nums :Seq[String]) = {
      DB.withConnection { implicit connection =>
        SQL("SELECT `col45`,`col46`,`col47`,`col48`,`col49`,`col50`,`col1`,`col2`,`col3`,`col4`,`col5` FROM `sel_50` WHERE `col18` IN ({nums})  ").expand { implicit ex => 
          commaSeparated("nums", nums.size)
          }.on { implicit stmt => 
              strings("nums",numsString)
            }
          .executeQuery().asList( RowParser {row => 
                                      row.string("col45")
                                      row.string("col46")
                                      row.string("col47")
                                      row.string("col48")
                                      row.string("col49")
                                      row.string("col50")
                                      row.string("col1")
                                      row.string("col2")
                                      row.string("col3")
                                      row.string("col4")
                                      row.string("col5")
            
                                    }
                                )
        }


  }

  def select2_double(nums :Seq[Double]) = {
      DB.withConnection { implicit connection =>
        SQL("SELECT `col45`,`col46`,`col47`,`col48`,`col49`,`col50`,`col1`,`col2`,`col3`,`col4`,`col5` FROM `sel_50` WHERE `col18` IN ({nums})  ").expand { implicit ex => 
          commaSeparated("nums", nums.size)
          }.on { implicit stmt => 
              doubles("nums",numsDouble)
            }
          .executeQuery().asList( RowParser {row => 
                                      row.long("col45")
                                      row.long("col46")
                                      row.long("col47")
                                      row.long("col48")
                                      row.long("col49")
                                      row.long("col50")
                                      row.long("col1")
                                      row.long("col2")
                                      row.long("col3")
                                      row.long("col4")
                                      row.long("col5")
            
                                    }
                                )
        }


  }

	def select3_int(nums:Seq[Int]) = {
		DB.withConnection { implicit connection =>
  			SQL("SELECT `col1`,`col2`,`col3`,`col4`,`col5`,`col6`,`col7`,`col8`,`col9`,`col10`,`col11`,`col12`,`col13`,`col14`,`col15`,`col16`,`col17`,`col18`,`col19`,`col20`,`col21`,`col22`,`col23`,`col24`,`col25` FROM `sel_50` WHERE  `col18` IN ({nums}) ").expand { implicit ex => 
  				commaSeparated("nums", nums.size)
  				}.on { implicit stmt => 
  						ints("nums",nums)
  					}.executeQuery().asList( RowParser {row => 
  						row.int("col1")
              row.int("col2")
              row.int("col3")
              row.int("col4")
              row.int("col5")
              row.int("col6")
              row.int("col7")
              row.int("col8")
              row.int("col9")
              row.int("col10")
              row.int("col11")
              row.int("col12")
              row.int("col13")
              row.int("col14")
              row.int("col15")
              row.int("col16")
              row.int("col17")
              row.int("col18")
              row.int("col19")
              row.int("col20")
              row.int("col21")
              row.int("col22")
              row.int("col23")
              row.int("col24")
              row.int("col25")
              
  					})
  			}



	}

    def select3_long(nums:Seq[Long]) = {
    DB.withConnection { implicit connection =>
        SQL("SELECT `col1`,`col2`,`col3`,`col4`,`col5`,`col6`,`col7`,`col8`,`col9`,`col10`,`col11`,`col12`,`col13`,`col14`,`col15`,`col16`,`col17`,`col18`,`col19`,`col20`,`col21`,`col22`,`col23`,`col24`,`col25` FROM `sel_50` WHERE  `col18` IN ({nums}) ").expand { implicit ex => 
          commaSeparated("nums", nums.size)
          }.on { implicit stmt => 
              longs("nums",numsLong)
            }.executeQuery().asList( RowParser {row => 
              row.long("col1")
              row.long("col2")
              row.long("col3")
              row.long("col4")
              row.long("col5")
              row.long("col6")
              row.long("col7")
              row.long("col8")
              row.long("col9")
              row.long("col10")
              row.long("col11")
              row.long("col12")
              row.long("col13")
              row.long("col14")
              row.long("col15")
              row.long("col16")
              row.long("col17")
              row.long("col18")
              row.long("col19")
              row.long("col20")
              row.long("col21")
              row.long("col22")
              row.long("col23")
              row.long("col24")
              row.long("col25")
              
            })
        }



  }
    def select3_string(nums:Seq[String]) = {
    DB.withConnection { implicit connection =>
        SQL("SELECT `col1`,`col2`,`col3`,`col4`,`col5`,`col6`,`col7`,`col8`,`col9`,`col10`,`col11`,`col12`,`col13`,`col14`,`col15`,`col16`,`col17`,`col18`,`col19`,`col20`,`col21`,`col22`,`col23`,`col24`,`col25` FROM `sel_50` WHERE `col18` IN ({nums}) ").expand { implicit ex => 
          commaSeparated("nums", nums.size)
          }.on { implicit stmt => 
              strings("nums",nums)
            }.executeQuery().asList( RowParser {row => 
              row.string("col1")
              row.string("col2")
              row.string("col3")
              row.string("col4")
              row.string("col5")
              row.string("col6")
              row.string("col7")
              row.string("col8")
              row.string("col9")
              row.string("col10")
              row.string("col11")
              row.string("col12")
              row.string("col13")
              row.string("col14")
              row.string("col15")
              row.string("col16")
              row.string("col17")
              row.string("col18")
              row.string("col19")
              row.string("col20")
              row.string("col21")
              row.string("col22")
              row.string("col23")
              row.string("col24")
              row.string("col25")
              
            })
        }



  }

    def select3_double(nums:Seq[Double]) = {
    DB.withConnection { implicit connection =>
        SQL("SELECT `col1`,`col2`,`col3`,`col4`,`col5`,`col6`,`col7`,`col8`,`col9`,`col10`,`col11`,`col12`,`col13`,`col14`,`col15`,`col16`,`col17`,`col18`,`col19`,`col20`,`col21`,`col22`,`col23`,`col24`,`col25` FROM `sel_50` WHERE `col18` IN ({nums}) ").expand { implicit ex => 
          commaSeparated("nums", nums.size)
          }.on { implicit stmt => 
              doubles("nums",nums)
            }.executeQuery().asList( RowParser {row => 
              row.double("col1")
              row.double("col2")
              row.double("col3")
              row.double("col4")
              row.double("col5")
              row.double("col6")
              row.double("col7")
              row.double("col8")
              row.double("col9")
              row.double("col10")
              row.double("col11")
              row.double("col12")
              row.double("col13")
              row.double("col14")
              row.double("col15")
              row.double("col16")
              row.double("col17")
              row.double("col18")
              row.double("col19")
              row.double("col20")
              row.double("col21")
              row.double("col22")
              row.double("col23")
              row.double("col24")
              row.double("col25")
              
            })
        }



  }
    def insert1_int(rows:Seq[Int]) = {
      DB.withConnection { connection =>
        rows.foreach  { row =>
          
          SQL("""INSERT INTO `ins_10` VALUES ({a1},{a2},{a3},{a4},{a5},{a6},{a7},{a8},{a9},{a10})""")
          .on { implicit query =>
            
              int("a1",row)
              int("a2",row)
              int("a3",row)
              int("a4",row)
              int("a5",row)
              int("a6",row)
              int("a7",row)
              int("a8",row)
              int("a9",row)
              int("a10",row)
              
  
        }.executeUpdate()(connection)
       }
      
    }

  }

    def insert1_long(rows:Seq[Long]) = {
      DB.withConnection { connection =>
       rows.foreach  { row =>
          
          SQL("""INSERT INTO `ins_50` VALUES ({a1},{a2},{a3},{a4},{a5},{a6},{a7},{a8},{a9},{a10})""")
          .on { implicit query =>
            
              long("a1",row)
              long("a2",row)
              long("a3",row)
              long("a4",row)
              long("a5",row)
              long("a6",row)
              long("a7",row)
              long("a8",row)
              long("a9",row)
              long("a10",row)
              
  
        }.executeUpdate()(connection)
       }
      
    }

  }

def insert1_double(rows:Seq[Double]) = {
      DB.withConnection { connection =>
        rows.foreach  { row =>
          
          SQL("""INSERT INTO `ins_10` VALUES ({a1},{a2},{a3},{a4},{a5},{a6},{a7},{a8},{a9},{a10})""")
          .on { implicit query =>
            
              double("a1",row)
              double("a2",row)
              double("a3",row)
              double("a4",row)
              double("a5",row)
              double("a6",row)
              double("a7",row)
              double("a8",row)
              double("a9",row)
              double("a10",row)
              
  
        }.executeUpdate()(connection)
       }
      
    }

  }

def insert1_string(rows:Seq[String]) = {

      DB.withConnection { connection =>
        rows.foreach  { row =>
          
          SQL("""INSERT INTO `ins_50` VALUES ({a1},{a2},{a3},{a4},{a5},{a6},{a7},{a8},{a9},{a10})""")
          .on { implicit query =>
            
              string("a1",row)
              string("a2",row)
              string("a3",row)
              string("a4",row)
              string("a5",row)
              string("a6",row)
              string("a7",row)
              string("a8",row)
              string("a9",row)
              string("a10",row)
             
  
        }.executeUpdate()(connection)
       }
      
    }

  }

	def insert2_int(rows:Seq[Int]) = {
    	DB.withConnection { connection =>
  			rows.foreach  { row =>
  				
	  			SQL("""INSERT INTO `ins_50` VALUES ({a1},{a2},{a3},{a4},{a5},{a6},{a7},{a8},{a9},{a10},{a11},{a12},{a13},{a14},{a15},{a16},{a17},{a18},{a19},{a20},{a21},{a22},{a23},{a24},{a25},{a26},{a27},{a28},{a29},{a30},{a31},{a32},{a33},{a34},{a35},{a36},{a37},{a38},{a39},{a40},{a41},{a42},{a43},{a44},{a45},{a46},{a47},{a48},{a49},{a50})""")
	  			.on { implicit query =>
	  				
              int("a1",row)
              int("a2",row)
              int("a3",row)
              int("a4",row)
              int("a5",row)
              int("a6",row)
              int("a7",row)
              int("a8",row)
              int("a9",row)
              int("a10",row)
              int("a11",row)
              int("a12",row)
              int("a13",row)
              int("a14",row)
              int("a15",row)
              int("a16",row)
              int("a17",row)
              int("a18",row)
              int("a19",row)
              int("a20",row)
              int("a21",row)
              int("a22",row)
              int("a23",row)
              int("a24",row)
              int("a25",row)
              int("a26",row)
              int("a27",row)
              int("a28",row)
              int("a29",row)
              int("a30",row)
              int("a31",row)
              int("a32",row)
              int("a33",row)
              int("a34",row)
              int("a35",row)
              int("a36",row)
              int("a37",row)
              int("a38",row)
              int("a39",row)
              int("a40",row)
              int("a41",row)
              int("a42",row)
              int("a43",row)
              int("a44",row)
              int("a45",row)
              int("a46",row)
              int("a47",row)
              int("a48",row)
              int("a49",row)
              int("a50",row)
	
	  	 	}.executeUpdate()(connection)
	  	 }
  		
  	}

  }

    def insert2_long(rows:Seq[Long]) = {
      DB.withConnection { connection =>
       rows.foreach  { row =>
          
          SQL("""INSERT INTO `ins_50` VALUES ({a1},{a2},{a3},{a4},{a5},{a6},{a7},{a8},{a9},{a10},{a11},{a12},{a13},{a14},{a15},{a16},{a17},{a18},{a19},{a20},{a21},{a22},{a23},{a24},{a25},{a26},{a27},{a28},{a29},{a30},{a31},{a32},{a33},{a34},{a35},{a36},{a37},{a38},{a39},{a40},{a41},{a42},{a43},{a44},{a45},{a46},{a47},{a48},{a49},{a50})""")
          .on { implicit query =>
            
              long("a1",row)
              long("a2",row)
              long("a3",row)
              long("a4",row)
              long("a5",row)
              long("a6",row)
              long("a7",row)
              long("a8",row)
              long("a9",row)
              long("a10",row)
              long("a11",row)
              long("a12",row)
              long("a13",row)
              long("a14",row)
              long("a15",row)
              long("a16",row)
              long("a17",row)
              long("a18",row)
              long("a19",row)
              long("a20",row)
              long("a21",row)
              long("a22",row)
              long("a23",row)
              long("a24",row)
              long("a25",row)
              long("a26",row)
              long("a27",row)
              long("a28",row)
              long("a29",row)
              long("a30",row)
              long("a31",row)
              long("a32",row)
              long("a33",row)
              long("a34",row)
              long("a35",row)
              long("a36",row)
              long("a37",row)
              long("a38",row)
              long("a39",row)
              long("a40",row)
              long("a41",row)
              long("a42",row)
              long("a43",row)
              long("a44",row)
              long("a45",row)
              long("a46",row)
              long("a47",row)
              long("a48",row)
              long("a49",row)
              long("a50",row)
  
        }.executeUpdate()(connection)
       }
      
    }

  }

def insert2_double(rows:Seq[Double]) = {
      DB.withConnection { connection =>
        rows.foreach  { row =>
          
          SQL("""INSERT INTO `ins_50` VALUES ({a1},{a2},{a3},{a4},{a5},{a6},{a7},{a8},{a9},{a10},{a11},{a12},{a13},{a14},{a15},{a16},{a17},{a18},{a19},{a20},{a21},{a22},{a23},{a24},{a25},{a26},{a27},{a28},{a29},{a30},{a31},{a32},{a33},{a34},{a35},{a36},{a37},{a38},{a39},{a40},{a41},{a42},{a43},{a44},{a45},{a46},{a47},{a48},{a49},{a50})""")
          .on { implicit query =>
            
              double("a1",row)
              double("a2",row)
              double("a3",row)
              double("a4",row)
              double("a5",row)
              double("a6",row)
              double("a7",row)
              double("a8",row)
              double("a9",row)
              double("a10",row)
              double("a11",row)
              double("a12",row)
              double("a13",row)
              double("a14",row)
              double("a15",row)
              double("a16",row)
              double("a17",row)
              double("a18",row)
              double("a19",row)
              double("a20",row)
              double("a21",row)
              double("a22",row)
              double("a23",row)
              double("a24",row)
              double("a25",row)
              double("a26",row)
              double("a27",row)
              double("a28",row)
              double("a29",row)
              double("a30",row)
              double("a31",row)
              double("a32",row)
              double("a33",row)
              double("a34",row)
              double("a35",row)
              double("a36",row)
              double("a37",row)
              double("a38",row)
              double("a39",row)
              double("a40",row)
              double("a41",row)
              double("a42",row)
              double("a43",row)
              double("a44",row)
              double("a45",row)
              double("a46",row)
              double("a47",row)
              double("a48",row)
              double("a49",row)
              double("a50",row)
  
        }.executeUpdate()(connection)
       }
      
    }

  }

def insert2_string(rows:Seq[String]) = {

      DB.withConnection { connection =>
        rows.foreach  { row =>
          
          SQL("""INSERT INTO `ins_50` VALUES ({a1},{a2},{a3},{a4},{a5},{a6},{a7},{a8},{a9},{a10},{a11},{a12},{a13},{a14},{a15},{a16},{a17},{a18},{a19},{a20},{a21},{a22},{a23},{a24},{a25},{a26},{a27},{a28},{a29},{a30},{a31},{a32},{a33},{a34},{a35},{a36},{a37},{a38},{a39},{a40},{a41},{a42},{a43},{a44},{a45},{a46},{a47},{a48},{a49},{a50})""")
          .on { implicit query =>
            
              string("a1",row)
              string("a2",row)
              string("a3",row)
              string("a4",row)
              string("a5",row)
              string("a6",row)
              string("a7",row)
              string("a8",row)
              string("a9",row)
              string("a10",row)
              string("a11",row)
              string("a12",row)
              string("a13",row)
              string("a14",row)
              string("a15",row)
              string("a16",row)
              string("a17",row)
              string("a18",row)
              string("a19",row)
              string("a20",row)
              string("a21",row)
              string("a22",row)
              string("a23",row)
              string("a24",row)
              string("a25",row)
              string("a26",row)
              string("a27",row)
              string("a28",row)
              string("a29",row)
              string("a30",row)
              string("a31",row)
              string("a32",row)
              string("a33",row)
              string("a34",row)
              string("a35",row)
              string("a36",row)
              string("a37",row)
              string("a38",row)
              string("a39",row)
              string("a40",row)
              string("a41",row)
              string("a42",row)
              string("a43",row)
              string("a44",row)
              string("a45",row)
              string("a46",row)
              string("a47",row)
              string("a48",row)
              string("a49",row)
              string("a50",row)
  
        }.executeUpdate()(connection)
       }
      
    }

  }

  def insert3_int(rows:Seq[Int]) = {
      DB.withConnection { connection =>
        rows.foreach  { row =>
          
          SQL("""INSERT INTO `ins_200` VALUES ({a1},{a2},{a3},{a4},{a5},{a6},{a7},{a8},{a9},{a10},{a11},{a12},{a13},{a14},{a15},{a16},{a17},{a18},{a19},{a20},{a21},{a22},{a23},{a24},{a25},{a26},{a27},{a28},{a29},{a30},{a31},{a32},{a33},{a34},{a35},{a36},{a37},{a38},{a39},{a40},{a41},{a42},{a43},{a44},{a45},{a46},{a47},{a48},{a49},{a50},{a51},{a52},{a53},{a54},{a55},{a56},{a57},{a58},{a59},{a60},{a61},{a62},{a63},{a64},{a65},{a66},{a67},{a68},{a69},{a70},{a71},{a72},{a73},{a74},{a75},{a76},{a77},{a78},{a79},{a80},{a81},{a82},{a83},{a84},{a85},{a86},{a87},{a88},{a89},{a90},{a91},{a92},{a93},{a94},{a95},{a96},{a97},{a98},{a99},{a100},{a101},{a102},{a103},{a104},{a105},{a106},{a107},{a108},{a109},{a110},{a111},{a112},{a113},{a114},{a115},{a116},{a117},{a118},{a119},{a120},{a121},{a122},{a123},{a124},{a125},{a126},{a127},{a128},{a129},{a130},{a131},{a132},{a133},{a134},{a135},{a136},{a137},{a138},{a139},{a140},{a141},{a142},{a143},{a144},{a145},{a146},{a147},{a148},{a149},{a150},{a151},{a152},{a153},{a154},{a155},{a156},{a157},{a158},{a159},{a160},{a161},{a162},{a163},{a164},{a165},{a166},{a167},{a168},{a169},{a170},{a171},{a172},{a173},{a174},{a175},{a176},{a177},{a178},{a179},{a180},{a181},{a182},{a183},{a184},{a185},{a186},{a187},{a188},{a189},{a190},{a191},{a192},{a193},{a194},{a195},{a196},{a197},{a198},{a199},{a200})""")
          .on { implicit query =>
            
              int("a1",row)
              int("a2",row)
              int("a3",row)
              int("a4",row)
              int("a5",row)
              int("a6",row)
              int("a7",row)
              int("a8",row)
              int("a9",row)
              int("a10",row)
              int("a11",row)
              int("a12",row)
              int("a13",row)
              int("a14",row)
              int("a15",row)
              int("a16",row)
              int("a17",row)
              int("a18",row)
              int("a19",row)
              int("a20",row)
              int("a21",row)
              int("a22",row)
              int("a23",row)
              int("a24",row)
              int("a25",row)
              int("a26",row)
              int("a27",row)
              int("a28",row)
              int("a29",row)
              int("a30",row)
              int("a31",row)
              int("a32",row)
              int("a33",row)
              int("a34",row)
              int("a35",row)
              int("a36",row)
              int("a37",row)
              int("a38",row)
              int("a39",row)
              int("a40",row)
              int("a41",row)
              int("a42",row)
              int("a43",row)
              int("a44",row)
              int("a45",row)
              int("a46",row)
              int("a47",row)
              int("a48",row)
              int("a49",row)
              int("a50",row)
              int("a51",row)
int("a52",row)
int("a53",row)
int("a54",row)
int("a55",row)
int("a56",row)
int("a57",row)
int("a58",row)
int("a59",row)
int("a60",row)
int("a61",row)
int("a62",row)
int("a63",row)
int("a64",row)
int("a65",row)
int("a66",row)
int("a67",row)
int("a68",row)
int("a69",row)
int("a70",row)
int("a71",row)
int("a72",row)
int("a73",row)
int("a74",row)
int("a75",row)
int("a76",row)
int("a77",row)
int("a78",row)
int("a79",row)
int("a80",row)
int("a81",row)
int("a82",row)
int("a83",row)
int("a84",row)
int("a85",row)
int("a86",row)
int("a87",row)
int("a88",row)
int("a89",row)
int("a90",row)
int("a91",row)
int("a92",row)
int("a93",row)
int("a94",row)
int("a95",row)
int("a96",row)
int("a97",row)
int("a98",row)
int("a99",row)
int("a100",row)
int("a101",row)
int("a102",row)
int("a103",row)
int("a104",row)
int("a105",row)
int("a106",row)
int("a107",row)
int("a108",row)
int("a109",row)
int("a110",row)
int("a111",row)
int("a112",row)
int("a113",row)
int("a114",row)
int("a115",row)
int("a116",row)
int("a117",row)
int("a118",row)
int("a119",row)
int("a120",row)
int("a121",row)
int("a122",row)
int("a123",row)
int("a124",row)
int("a125",row)
int("a126",row)
int("a127",row)
int("a128",row)
int("a129",row)
int("a130",row)
int("a131",row)
int("a132",row)
int("a133",row)
int("a134",row)
int("a135",row)
int("a136",row)
int("a137",row)
int("a138",row)
int("a139",row)
int("a140",row)
int("a141",row)
int("a142",row)
int("a143",row)
int("a144",row)
int("a145",row)
int("a146",row)
int("a147",row)
int("a148",row)
int("a149",row)
int("a150",row)
int("a151",row)
int("a152",row)
int("a153",row)
int("a154",row)
int("a155",row)
int("a156",row)
int("a157",row)
int("a158",row)
int("a159",row)
int("a160",row)
int("a161",row)
int("a162",row)
int("a163",row)
int("a164",row)
int("a165",row)
int("a166",row)
int("a167",row)
int("a168",row)
int("a169",row)
int("a170",row)
int("a171",row)
int("a172",row)
int("a173",row)
int("a174",row)
int("a175",row)
int("a176",row)
int("a177",row)
int("a178",row)
int("a179",row)
int("a180",row)
int("a181",row)
int("a182",row)
int("a183",row)
int("a184",row)
int("a185",row)
int("a186",row)
int("a187",row)
int("a188",row)
int("a189",row)
int("a190",row)
int("a191",row)
int("a192",row)
int("a193",row)
int("a194",row)
int("a195",row)
int("a196",row)
int("a197",row)
int("a198",row)
int("a199",row)
int("a200",row)
  
        }.executeUpdate()(connection)
       }
      
    }

  }

    def insert3_long(rows:Seq[Long]) = {
      DB.withConnection { connection =>
       rows.foreach  { row =>
          
          SQL("""INSERT INTO `ins_200` VALUES ({a1},{a2},{a3},{a4},{a5},{a6},{a7},{a8},{a9},{a10},{a11},{a12},{a13},{a14},{a15},{a16},{a17},{a18},{a19},{a20},{a21},{a22},{a23},{a24},{a25},{a26},{a27},{a28},{a29},{a30},{a31},{a32},{a33},{a34},{a35},{a36},{a37},{a38},{a39},{a40},{a41},{a42},{a43},{a44},{a45},{a46},{a47},{a48},{a49},{a50},{a51},{a52},{a53},{a54},{a55},{a56},{a57},{a58},{a59},{a60},{a61},{a62},{a63},{a64},{a65},{a66},{a67},{a68},{a69},{a70},{a71},{a72},{a73},{a74},{a75},{a76},{a77},{a78},{a79},{a80},{a81},{a82},{a83},{a84},{a85},{a86},{a87},{a88},{a89},{a90},{a91},{a92},{a93},{a94},{a95},{a96},{a97},{a98},{a99},{a100},{a101},{a102},{a103},{a104},{a105},{a106},{a107},{a108},{a109},{a110},{a111},{a112},{a113},{a114},{a115},{a116},{a117},{a118},{a119},{a120},{a121},{a122},{a123},{a124},{a125},{a126},{a127},{a128},{a129},{a130},{a131},{a132},{a133},{a134},{a135},{a136},{a137},{a138},{a139},{a140},{a141},{a142},{a143},{a144},{a145},{a146},{a147},{a148},{a149},{a150},{a151},{a152},{a153},{a154},{a155},{a156},{a157},{a158},{a159},{a160},{a161},{a162},{a163},{a164},{a165},{a166},{a167},{a168},{a169},{a170},{a171},{a172},{a173},{a174},{a175},{a176},{a177},{a178},{a179},{a180},{a181},{a182},{a183},{a184},{a185},{a186},{a187},{a188},{a189},{a190},{a191},{a192},{a193},{a194},{a195},{a196},{a197},{a198},{a199},{a200})""")
          .on { implicit query =>
            
              long("a1",row)
              long("a2",row)
              long("a3",row)
              long("a4",row)
              long("a5",row)
              long("a6",row)
              long("a7",row)
              long("a8",row)
              long("a9",row)
              long("a10",row)
              long("a11",row)
              long("a12",row)
              long("a13",row)
              long("a14",row)
              long("a15",row)
              long("a16",row)
              long("a17",row)
              long("a18",row)
              long("a19",row)
              long("a20",row)
              long("a21",row)
              long("a22",row)
              long("a23",row)
              long("a24",row)
              long("a25",row)
              long("a26",row)
              long("a27",row)
              long("a28",row)
              long("a29",row)
              long("a30",row)
              long("a31",row)
              long("a32",row)
              long("a33",row)
              long("a34",row)
              long("a35",row)
              long("a36",row)
              long("a37",row)
              long("a38",row)
              long("a39",row)
              long("a40",row)
              long("a41",row)
              long("a42",row)
              long("a43",row)
              long("a44",row)
              long("a45",row)
              long("a46",row)
              long("a47",row)
              long("a48",row)
              long("a49",row)
              long("a50",row)
              long("a51",row)
              long("a52",row)
              long("a53",row)
              long("a54",row)
              long("a55",row)
              long("a56",row)
              long("a57",row)
              long("a58",row)
              long("a59",row)
              long("a60",row)
              long("a61",row)
              long("a62",row)
              long("a63",row)
              long("a64",row)
              long("a65",row)
              long("a66",row)
              long("a67",row)
              long("a68",row)
              long("a69",row)
              long("a70",row)
              long("a71",row)
              long("a72",row)
              long("a73",row)
              long("a74",row)
              long("a75",row)
              long("a76",row)
              long("a77",row)
              long("a78",row)
              long("a79",row)
              long("a80",row)
              long("a81",row)
              long("a82",row)
              long("a83",row)
              long("a84",row)
              long("a85",row)
              long("a86",row)
              long("a87",row)
              long("a88",row)
              long("a89",row)
              long("a90",row)
              long("a91",row)
              long("a92",row)
              long("a93",row)
              long("a94",row)
              long("a95",row)
              long("a96",row)
              long("a97",row)
              long("a98",row)
              long("a99",row)
              long("a100",row)
              long("a101",row)
              long("a102",row)
              long("a103",row)
              long("a104",row)
              long("a105",row)
              long("a106",row)
              long("a107",row)
              long("a108",row)
              long("a109",row)
              long("a110",row)
              long("a111",row)
              long("a112",row)
              long("a113",row)
              long("a114",row)
              long("a115",row)
              long("a116",row)
              long("a117",row)
              long("a118",row)
              long("a119",row)
              long("a120",row)
              long("a121",row)
              long("a122",row)
              long("a123",row)
              long("a124",row)
              long("a125",row)
              long("a126",row)
              long("a127",row)
              long("a128",row)
              long("a129",row)
              long("a130",row)
              long("a131",row)
              long("a132",row)
              long("a133",row)
              long("a134",row)
              long("a135",row)
              long("a136",row)
              long("a137",row)
              long("a138",row)
              long("a139",row)
              long("a140",row)
              long("a141",row)
              long("a142",row)
              long("a143",row)
              long("a144",row)
              long("a145",row)
              long("a146",row)
              long("a147",row)
              long("a148",row)
              long("a149",row)
              long("a150",row)
              long("a151",row)
              long("a152",row)
              long("a153",row)
              long("a154",row)
              long("a155",row)
              long("a156",row)
              long("a157",row)
              long("a158",row)
              long("a159",row)
              long("a160",row)
              long("a161",row)
              long("a162",row)
              long("a163",row)
              long("a164",row)
              long("a165",row)
              long("a166",row)
              long("a167",row)
              long("a168",row)
              long("a169",row)
              long("a170",row)
              long("a171",row)
              long("a172",row)
              long("a173",row)
              long("a174",row)
              long("a175",row)
              long("a176",row)
              long("a177",row)
              long("a178",row)
              long("a179",row)
              long("a180",row)
              long("a181",row)
              long("a182",row)
              long("a183",row)
              long("a184",row)
              long("a185",row)
              long("a186",row)
              long("a187",row)
              long("a188",row)
              long("a189",row)
              long("a190",row)
              long("a191",row)
              long("a192",row)
              long("a193",row)
              long("a194",row)
              long("a195",row)
              long("a196",row)
              long("a197",row)
              long("a198",row)
              long("a199",row)
              long("a200",row)
        }.executeUpdate()(connection)
       }
      
    }

  }

def insert3_double(rows:Seq[Double]) = {
      DB.withConnection { connection =>
        rows.foreach  { row =>
          
          SQL("""INSERT INTO `ins_200` VALUES ({a1},{a2},{a3},{a4},{a5},{a6},{a7},{a8},{a9},{a10},{a11},{a12},{a13},{a14},{a15},{a16},{a17},{a18},{a19},{a20},{a21},{a22},{a23},{a24},{a25},{a26},{a27},{a28},{a29},{a30},{a31},{a32},{a33},{a34},{a35},{a36},{a37},{a38},{a39},{a40},{a41},{a42},{a43},{a44},{a45},{a46},{a47},{a48},{a49},{a50},{a51},{a52},{a53},{a54},{a55},{a56},{a57},{a58},{a59},{a60},{a61},{a62},{a63},{a64},{a65},{a66},{a67},{a68},{a69},{a70},{a71},{a72},{a73},{a74},{a75},{a76},{a77},{a78},{a79},{a80},{a81},{a82},{a83},{a84},{a85},{a86},{a87},{a88},{a89},{a90},{a91},{a92},{a93},{a94},{a95},{a96},{a97},{a98},{a99},{a100},{a101},{a102},{a103},{a104},{a105},{a106},{a107},{a108},{a109},{a110},{a111},{a112},{a113},{a114},{a115},{a116},{a117},{a118},{a119},{a120},{a121},{a122},{a123},{a124},{a125},{a126},{a127},{a128},{a129},{a130},{a131},{a132},{a133},{a134},{a135},{a136},{a137},{a138},{a139},{a140},{a141},{a142},{a143},{a144},{a145},{a146},{a147},{a148},{a149},{a150},{a151},{a152},{a153},{a154},{a155},{a156},{a157},{a158},{a159},{a160},{a161},{a162},{a163},{a164},{a165},{a166},{a167},{a168},{a169},{a170},{a171},{a172},{a173},{a174},{a175},{a176},{a177},{a178},{a179},{a180},{a181},{a182},{a183},{a184},{a185},{a186},{a187},{a188},{a189},{a190},{a191},{a192},{a193},{a194},{a195},{a196},{a197},{a198},{a199},{a200})""")
          .on { implicit query =>
            
              double("a1",row)
              double("a2",row)
              double("a3",row)
              double("a4",row)
              double("a5",row)
              double("a6",row)
              double("a7",row)
              double("a8",row)
              double("a9",row)
              double("a10",row)
              double("a11",row)
              double("a12",row)
              double("a13",row)
              double("a14",row)
              double("a15",row)
              double("a16",row)
              double("a17",row)
              double("a18",row)
              double("a19",row)
              double("a20",row)
              double("a21",row)
              double("a22",row)
              double("a23",row)
              double("a24",row)
              double("a25",row)
              double("a26",row)
              double("a27",row)
              double("a28",row)
              double("a29",row)
              double("a30",row)
              double("a31",row)
              double("a32",row)
              double("a33",row)
              double("a34",row)
              double("a35",row)
              double("a36",row)
              double("a37",row)
              double("a38",row)
              double("a39",row)
              double("a40",row)
              double("a41",row)
              double("a42",row)
              double("a43",row)
              double("a44",row)
              double("a45",row)
              double("a46",row)
              double("a47",row)
              double("a48",row)
              double("a49",row)
              double("a50",row)
              double("a51",row)
double("a52",row)
double("a53",row)
double("a54",row)
double("a55",row)
double("a56",row)
double("a57",row)
double("a58",row)
double("a59",row)
double("a60",row)
double("a61",row)
double("a62",row)
double("a63",row)
double("a64",row)
double("a65",row)
double("a66",row)
double("a67",row)
double("a68",row)
double("a69",row)
double("a70",row)
double("a71",row)
double("a72",row)
double("a73",row)
double("a74",row)
double("a75",row)
double("a76",row)
double("a77",row)
double("a78",row)
double("a79",row)
double("a80",row)
double("a81",row)
double("a82",row)
double("a83",row)
double("a84",row)
double("a85",row)
double("a86",row)
double("a87",row)
double("a88",row)
double("a89",row)
double("a90",row)
double("a91",row)
double("a92",row)
double("a93",row)
double("a94",row)
double("a95",row)
double("a96",row)
double("a97",row)
double("a98",row)
double("a99",row)
double("a100",row)
double("a101",row)
double("a102",row)
double("a103",row)
double("a104",row)
double("a105",row)
double("a106",row)
double("a107",row)
double("a108",row)
double("a109",row)
double("a110",row)
double("a111",row)
double("a112",row)
double("a113",row)
double("a114",row)
double("a115",row)
double("a116",row)
double("a117",row)
double("a118",row)
double("a119",row)
double("a120",row)
double("a121",row)
double("a122",row)
double("a123",row)
double("a124",row)
double("a125",row)
double("a126",row)
double("a127",row)
double("a128",row)
double("a129",row)
double("a130",row)
double("a131",row)
double("a132",row)
double("a133",row)
double("a134",row)
double("a135",row)
double("a136",row)
double("a137",row)
double("a138",row)
double("a139",row)
double("a140",row)
double("a141",row)
double("a142",row)
double("a143",row)
double("a144",row)
double("a145",row)
double("a146",row)
double("a147",row)
double("a148",row)
double("a149",row)
double("a150",row)
double("a151",row)
double("a152",row)
double("a153",row)
double("a154",row)
double("a155",row)
double("a156",row)
double("a157",row)
double("a158",row)
double("a159",row)
double("a160",row)
double("a161",row)
double("a162",row)
double("a163",row)
double("a164",row)
double("a165",row)
double("a166",row)
double("a167",row)
double("a168",row)
double("a169",row)
double("a170",row)
double("a171",row)
double("a172",row)
double("a173",row)
double("a174",row)
double("a175",row)
double("a176",row)
double("a177",row)
double("a178",row)
double("a179",row)
double("a180",row)
double("a181",row)
double("a182",row)
double("a183",row)
double("a184",row)
double("a185",row)
double("a186",row)
double("a187",row)
double("a188",row)
double("a189",row)
double("a190",row)
double("a191",row)
double("a192",row)
double("a193",row)
double("a194",row)
double("a195",row)
double("a196",row)
double("a197",row)
double("a198",row)
double("a199",row)
double("a200",row)
        }.executeUpdate()(connection)
       }
      
    }

  }

def insert3_string(rows:Seq[String]) = {

      DB.withConnection { connection =>
        rows.foreach  { row =>
          
          SQL("""INSERT INTO `ins_200` VALUES ({a1},{a2},{a3},{a4},{a5},{a6},{a7},{a8},{a9},{a10},{a11},{a12},{a13},{a14},{a15},{a16},{a17},{a18},{a19},{a20},{a21},{a22},{a23},{a24},{a25},{a26},{a27},{a28},{a29},{a30},{a31},{a32},{a33},{a34},{a35},{a36},{a37},{a38},{a39},{a40},{a41},{a42},{a43},{a44},{a45},{a46},{a47},{a48},{a49},{a50},{a51},{a52},{a53},{a54},{a55},{a56},{a57},{a58},{a59},{a60},{a61},{a62},{a63},{a64},{a65},{a66},{a67},{a68},{a69},{a70},{a71},{a72},{a73},{a74},{a75},{a76},{a77},{a78},{a79},{a80},{a81},{a82},{a83},{a84},{a85},{a86},{a87},{a88},{a89},{a90},{a91},{a92},{a93},{a94},{a95},{a96},{a97},{a98},{a99},{a100},{a101},{a102},{a103},{a104},{a105},{a106},{a107},{a108},{a109},{a110},{a111},{a112},{a113},{a114},{a115},{a116},{a117},{a118},{a119},{a120},{a121},{a122},{a123},{a124},{a125},{a126},{a127},{a128},{a129},{a130},{a131},{a132},{a133},{a134},{a135},{a136},{a137},{a138},{a139},{a140},{a141},{a142},{a143},{a144},{a145},{a146},{a147},{a148},{a149},{a150},{a151},{a152},{a153},{a154},{a155},{a156},{a157},{a158},{a159},{a160},{a161},{a162},{a163},{a164},{a165},{a166},{a167},{a168},{a169},{a170},{a171},{a172},{a173},{a174},{a175},{a176},{a177},{a178},{a179},{a180},{a181},{a182},{a183},{a184},{a185},{a186},{a187},{a188},{a189},{a190},{a191},{a192},{a193},{a194},{a195},{a196},{a197},{a198},{a199},{a200})""")
          .on { implicit query =>
            
              string("a1",row)
              string("a2",row)
              string("a3",row)
              string("a4",row)
              string("a5",row)
              string("a6",row)
              string("a7",row)
              string("a8",row)
              string("a9",row)
              string("a10",row)
              string("a11",row)
              string("a12",row)
              string("a13",row)
              string("a14",row)
              string("a15",row)
              string("a16",row)
              string("a17",row)
              string("a18",row)
              string("a19",row)
              string("a20",row)
              string("a21",row)
              string("a22",row)
              string("a23",row)
              string("a24",row)
              string("a25",row)
              string("a26",row)
              string("a27",row)
              string("a28",row)
              string("a29",row)
              string("a30",row)
              string("a31",row)
              string("a32",row)
              string("a33",row)
              string("a34",row)
              string("a35",row)
              string("a36",row)
              string("a37",row)
              string("a38",row)
              string("a39",row)
              string("a40",row)
              string("a41",row)
              string("a42",row)
              string("a43",row)
              string("a44",row)
              string("a45",row)
              string("a46",row)
              string("a47",row)
              string("a48",row)
              string("a49",row)
              string("a50",row)
              string("a51",row)
string("a52",row)
string("a53",row)
string("a54",row)
string("a55",row)
string("a56",row)
string("a57",row)
string("a58",row)
string("a59",row)
string("a60",row)
string("a61",row)
string("a62",row)
string("a63",row)
string("a64",row)
string("a65",row)
string("a66",row)
string("a67",row)
string("a68",row)
string("a69",row)
string("a70",row)
string("a71",row)
string("a72",row)
string("a73",row)
string("a74",row)
string("a75",row)
string("a76",row)
string("a77",row)
string("a78",row)
string("a79",row)
string("a80",row)
string("a81",row)
string("a82",row)
string("a83",row)
string("a84",row)
string("a85",row)
string("a86",row)
string("a87",row)
string("a88",row)
string("a89",row)
string("a90",row)
string("a91",row)
string("a92",row)
string("a93",row)
string("a94",row)
string("a95",row)
string("a96",row)
string("a97",row)
string("a98",row)
string("a99",row)
string("a100",row)
string("a101",row)
string("a102",row)
string("a103",row)
string("a104",row)
string("a105",row)
string("a106",row)
string("a107",row)
string("a108",row)
string("a109",row)
string("a110",row)
string("a111",row)
string("a112",row)
string("a113",row)
string("a114",row)
string("a115",row)
string("a116",row)
string("a117",row)
string("a118",row)
string("a119",row)
string("a120",row)
string("a121",row)
string("a122",row)
string("a123",row)
string("a124",row)
string("a125",row)
string("a126",row)
string("a127",row)
string("a128",row)
string("a129",row)
string("a130",row)
string("a131",row)
string("a132",row)
string("a133",row)
string("a134",row)
string("a135",row)
string("a136",row)
string("a137",row)
string("a138",row)
string("a139",row)
string("a140",row)
string("a141",row)
string("a142",row)
string("a143",row)
string("a144",row)
string("a145",row)
string("a146",row)
string("a147",row)
string("a148",row)
string("a149",row)
string("a150",row)
string("a151",row)
string("a152",row)
string("a153",row)
string("a154",row)
string("a155",row)
string("a156",row)
string("a157",row)
string("a158",row)
string("a159",row)
string("a160",row)
string("a161",row)
string("a162",row)
string("a163",row)
string("a164",row)
string("a165",row)
string("a166",row)
string("a167",row)
string("a168",row)
string("a169",row)
string("a170",row)
string("a171",row)
string("a172",row)
string("a173",row)
string("a174",row)
string("a175",row)
string("a176",row)
string("a177",row)
string("a178",row)
string("a179",row)
string("a180",row)
string("a181",row)
string("a182",row)
string("a183",row)
string("a184",row)
string("a185",row)
string("a186",row)
string("a187",row)
string("a188",row)
string("a189",row)
string("a190",row)
string("a191",row)
string("a192",row)
string("a193",row)
string("a194",row)
string("a195",row)
string("a196",row)
string("a197",row)
string("a198",row)
string("a199",row)
string("a200",row)

  
        }.executeUpdate()(connection)
       }
      
    }

  }

	def update1_int(nums:Seq[Int]) = {
		DB.withConnection { connection =>
			SQL("""UPDATE `sel_50` SET `col13`=16 ,`col33`=19 where `col22` IN ({nums})""")
			.expand { implicit ex => commaSeparated("nums",nums.size)}
			.on {  implicit query =>
  					ints("nums",nums)
  				
          }.executeUpdate()(connection)
	  }
  }


  def update1_long(nums:Seq[Long]) = {
    DB.withConnection { connection =>
      SQL("""UPDATE `sel_50` SET `col13`=16 ,`col33`=19 where `col22` IN ({nums})""")
      .expand { implicit ex => commaSeparated("nums",nums.size)}
      .on {  implicit query =>
            longs("nums",nums)
          
          }.executeUpdate()(connection)
    }
  }


  def update1_string(nums:Seq[String]) = {
    DB.withConnection { connection =>
      SQL("""UPDATE `sel_50` SET `col13`='16' ,`col33`='19' where `col22` IN ({nums})""")
      .expand { implicit ex => commaSeparated("nums",nums.size)}
      .on {  implicit query =>
            strings("nums",nums)
          
          }.executeUpdate()(connection)
    }
  }



  def update1_double(nums:Seq[Double]) = {
    DB.withConnection { connection =>
      SQL("""UPDATE `sel_50` SET `col13`=16 ,`col33`=19 where `col22` IN ({nums})""")
      .expand { implicit ex => commaSeparated("nums",nums.size)}
      .on {  implicit query =>
            doubles("nums",nums)
          
          }.executeUpdate()(connection)
    }
  }


	def update2_int(nums:Seq[Int]) = {

		DB.withConnection { connection =>	
			SQL("""UPDATE `sel_50` SET `col1`=16 ,`col43`=19, `col45`=14, `col32`=45, `col26`=254,`col3`=34, `col5`=235, `col12`=5, `col29`=234, `col17`=34 where `col12` IN  ({nums})""")
			.expand { implicit ex => commaSeparated("nums",nums.size)}
			.on {  implicit query =>
  						ints("nums",nums)
  					
  				}.executeUpdate()(connection)
	 }
  }  


  def update2_long(nums:Seq[Long]) = {

    DB.withConnection { connection => 
      SQL("""UPDATE `sel_50` SET `col1`=16 ,`col43`=19, `col45`=14, `col32`=45, `col26`=254,`col3`=34, `col5`=235, `col12`=5, `col29`=234, `col17`=34 where `col12` IN  ({nums})""")
      .expand { implicit ex => commaSeparated("nums",nums.size)}
      .on { 
              implicit query =>
              longs("nums",nums)
            
          }.executeUpdate()(connection)
   }
  }  


  def update2_string(nums:Seq[String]) = {

    DB.withConnection { connection => 
      SQL("""UPDATE `sel_50` SET `col1`='16' ,`col43`='19', `col45`='14', `col32`='45', `col26`='254',`col3`='34', `col5`='235', `col12`='5', `col29`='234', `col17`='34' where `col12` IN  ({nums})""")
      .expand { implicit ex => commaSeparated("nums",nums.size)}
      .on { implicit query =>
              strings("nums",nums)
            
          }.executeUpdate()(connection)
   }
  }  



  def update2_double(nums:Seq[Double]) = {

    DB.withConnection { connection => 
      SQL("""UPDATE `sel_50` SET `col1`=16 ,`col43`=19, `col45`=14, `col32`=45, `col26`=254,`col3`=34, `col5`=235, `col12`=5, `col29`=234, `col17`=34 where `col12` IN  ({nums})""")
      .expand { implicit ex => commaSeparated("nums",nums.size)}
      .on { 
            implicit query =>
              doubles("nums",nums)
            
          }.executeUpdate()(connection)
      }
   }

  


def update3_int(nums:Seq[Int]) = {

    DB.withConnection { connection => 
      SQL("""UPDATE `sel_50` SET `col1`=16 ,`col43`=19, `col45`=14, `col32`=45, `col26`=254,`col3`=34, `col5`=235, `col12`=5, `col29`=234,`col17`=34 ,`col18`=423, `col19`=341, `col27`=3243, `col28`=2315, `col25`=1234, `col33` = 34126, `col34` = 23425 ,`col35`=342 ,`col1`=234, `col49`=3576 where `col12` IN  ({nums})""")
      .expand { implicit ex => commaSeparated("nums",nums.size)}
      .on {  implicit query =>
              ints("nums",nums)
            
          }.executeUpdate()(connection)
   }
  }  


  def update3_long(nums:Seq[Long]) = {

    DB.withConnection { connection => 
      SQL("""UPDATE `sel_50` SET `col1`=16 ,`col43`=19, `col45`=14, `col32`=45, `col26`=254,`col3`=34, `col5`=235, `col12`=5, `col29`=234, `col17`=34,,`col18`=423, `col19`=341, `col27`=3243, `col28`=2315, `col25`=1234, `col33` = 34126, `col34` = 23425 ,`col35`=342 ,`col1`=234, `col49`=3576 where `col12` IN  ({nums})""")
      .expand { implicit ex => commaSeparated("nums",nums.size)}
      .on { 
              implicit query =>
              longs("nums",nums)
            
          }.executeUpdate()(connection)
   }
  }  


  def update3_string(nums:Seq[String]) = {

    DB.withConnection { connection => 
      SQL("""UPDATE `sel_50` SET `col1`='16' ,`col43`='19', `col45`='14', `col32`='45', `col26`='254',`col3`='34', `col5`='235', `col12`='5', `col29`='234', `col17`='34',`col18`=423, `col19`=341, `col27`=3243, `col28`=2315, `col25`=1234, `col33` = 34126, `col34` = 23425, `col35`=342 ,`col1`=234, `col49`=3576 where `col12` IN  ({nums})""")
      .expand { implicit ex => commaSeparated("nums",nums.size)}
      .on { implicit query =>
              strings("nums",nums)
            
          }.executeUpdate()(connection)
   }
  }  



  def update3_double(nums:Seq[Double]) = {

    DB.withConnection { connection => 
      SQL("""UPDATE `sel_50` SET `col1`=16 ,`col43`=19, `col45`=14, `col32`=45, `col26`=254,`col3`=34, `col5`=235, `col12`=5, `col29`=234, `col17`=34,,`col18`=423, `col19`=341. `col27`=3243, `col28`=2315, `col25`=1234, `col33` = 34126, `col34` = 23425 ,`col35`=342 ,`col1`=234, `col49`=3576 where `col12` IN  ({nums})""")
      .expand { implicit ex => commaSeparated("nums",nums.size)}
      .on { 
            implicit query =>
              doubles("nums",nums)
            
          }.executeUpdate()(connection)
      }
   }

}  
