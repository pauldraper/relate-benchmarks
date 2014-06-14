package controllers
import play.api.db._
import anorm._
import anorm.SqlParser._
import play.api.Play.current
object AnormTests {
 
	def select1_int(strnums:String) = {

		DB.withConnection { implicit connection =>
  			SQL("SELECT `col14` FROM  `sel_50` WHERE `col44` IN ("+strnums+") ").as( int("col14")  * ) 
  			}

	}
   def select1_long(strnums:String) = {

    DB.withConnection { implicit connection =>
        SQL("SELECT `col14` FROM  `sel_50` WHERE `col44` IN ("+strnums+") ").as( long("col14")  * ) 
        }

  }  

  def select1_string(strnums:String) = {

    DB.withConnection { implicit connection =>
        SQL("SELECT `col14` FROM  `sel_50` WHERE `col44` IN ("+strnums+") ").as( str("col14")  * ) 
        }

  }
  def select1_double(strnums:String) = {

    DB.withConnection { implicit connection =>
        SQL("SELECT `col14` FROM  `sel_50` WHERE `col44` IN ("+strnums+") ").as( scalar[Double] * ) 
        }

  }

	def select2_int(strnums:String) = {
			DB.withConnection { implicit connection =>
  			SQL("SELECT `col45`,`col46`,`col47`,`col48`,`col49`,`col50`,`col1`,`col2`,`col3`,`col4`,`col5` FROM `sel_50` WHERE `col18` IN ("+strnums+")  ")
        .as( 
  				
  					   int("col45")~int("col46")~int("col47")~int("col48")~int("col49")~int("col50")~int("col1")~int("col2")~int("col3")~int("col4")~int("col5")  *
  				


  				)
  					
  								
  		}


	}

def select2_long(strnums:String) = {
      DB.withConnection { implicit connection =>
        SQL("SELECT `col45`,`col46`,`col47`,`col48`,`col49`,`col50`,`col1`,`col2`,`col3`,`col4`,`col5` FROM `sel_50` WHERE  `col18` IN ("+strnums+")  ")
        .as( 
          
            
            
               long("col45")~long("col46")~long("col47")~long("col48")~long("col49")~long("col50")~long("col1")~long("col2")~long("col3")~long("col4")~long("col5") *
             

          )
            
                  
      }


  }

def select2_string(strnums:String) = {
      DB.withConnection { implicit connection =>
        SQL("SELECT `col45`,`col46`,`col47`,`col48`,`col49`,`col50`,`col1`,`col2`,`col3`,`col4`,`col5` FROM `sel_50` WHERE  `col18` IN ("+strnums+")  ")
        .as( 
          
               str("col45")~str("col46")~str("col47")~str("col48")~str("col49")~str("col50")~str("col1")~str("col2")~str("col3")~str("col4")~str("col5")  *
       
        

          )
            
                  
      }


  }
//def select2_double() = {
//      DB.withConnection { implicit connection =>
//        SQL("SELECT `col45`,`col46`,`col47`,`col48`,`col49`,`col50`,`col1`,`col2`,`col3`,`col4`,`col5` FROM `sel_50` WHERE `col35`=224252 OR `col25`=14658 OR `col18` IN ("+strnums+")  ")
//        .as( 
//          
//               double("col45")~double("col46")~double("col47")~double("col48")~double("col49")~double("col50")~double("col1")~double("col2")~double("col3")~double("col4")~double("col5")  *
//
//          )
//            
//                  
//      }
//
//
//  }


	def select3_int(strnums:String) = {
		DB.withConnection { implicit connection =>
  			SQL("SELECT `col1`,`col2`,`col3`,`col4`,`col5`,`col6`,`col7`,`col8`,`col9`,`col10`,`col11`,`col12`,`col13`,`col14`,`col15`,`col16`,`col17`,`col18`,`col19`,`col20`,`col21`,`col22`,`col23`,`col24`,`col25` FROM `sel_50`  WHERE `col18` IN ("+strnums+") ")
  			 .as ( 
  					
  						int("col1")~int("col2")~int("col3")~int("col4")~int("col5")~int("col6")~int("col7")~int("col8")~int("col9")~int("col10")~int("col11")~int("col12")~int("col13")~int("col14")~int("col15")~int("col16")~int("col17")~int("col18")~int("col19")~int("col20")~int("col21")~int("col22")~int("col23")~int("col24")~int("col25") *
  						
  				
  			
  				)	
  			}



	}

  def select3_long(strnums:String) = {
    DB.withConnection { implicit connection =>
        SQL("SELECT `col1`,`col2`,`col3`,`col4`,`col5`,`col6`,`col7`,`col8`,`col9`,`col10`,`col11`,`col12`,`col13`,`col14`,`col15`,`col16`,`col17`,`col18`,`col19`,`col20`,`col21`,`col22`,`col23`,`col24`,`col25` FROM `sel_50` WHERE  `col18` IN ("+strnums+") ")
         .as ( 
              long("col1")~long("col2")~long("col3")~long("col4")~long("col5")~long("col6")~long("col7")~long("col8")~long("col9")~long("col10")~long("col11")~long("col12")~long("col13")~long("col14")~long("col15")~long("col16")~long("col17")~long("col18")~long("col19")~long("col20")~long("col21")~long("col22")~long("col23")~long("col24")~long("col25") *
          ) 
        }



  }
    def select3_string(strnums:String) = {
    DB.withConnection { implicit connection =>
        SQL("SELECT `col1`,`col2`,`col3`,`col4`,`col5`,`col6`,`col7`,`col8`,`col9`,`col10`,`col11`,`col12`,`col13`,`col14`,`col15`,`col16`,`col17`,`col18`,`col19`,`col20`,`col21`,`col22`,`col23`,`col24`,`col25` FROM `sel_50` WHERE  `col18` IN ("+strnums+") ")
         .as ( 
              
           
              str("col1")~str("col2")~str("col3")~str("col4")~str("col5")~str("col6")~str("col7")~str("col8")~str("col9")~str("col10")~str("col11")~str("col12")~str("col13")~str("col14")~str("col15")~str("col16")~str("col17")~str("col18")~str("col19")~str("col20")~str("col21")~str("col22")~str("col23")~str("col24")~str("col25") *

            //  double("col1")~double("col2")~double("col3")~double("col4")~double("col5")~double("col6")~double("col7")~double("col8")~double("col9")~double("col10")~double("col11")~double("col12")~double("col13")~double("col14")~double("col15")~double("col16")~double("col17")~double("col18")~double("col19")~double("col20")~double("col21")~double("col22")~double("col23")~double("col24")~double("col25")~double("col26")~double("col27")~double("col28")~double("col29")~double("col30")~double("col31")~double("col32")~double("col33")~double("col34")~double("col35")~double("col36")~double("col37")~double("col38")~double("col39")~double("col40")~double("col41")~double("col42")~double("col43")~double("col44")~double("col45")~double("col46")~double("col47")~double("col48")~double("col49")~double("col50") *
          
          ) 
        }



  }
    
//  def select3_double() = {
//    DB.withConnection { implicit connection =>
//        SQL("SELECT `col1`,`col2`,`col3`,`col4`,`col5`,`col6`,`col7`,`col8`,`col9`,`col10`,`col11`,`col12`,`col13`,`col14`,`col15`,`col16`,`col17`,`col18`,`col19`,`col20`,`col21`,`col22`,`col23`,`col24`,`col25`,`col26`,`col27`,`col28`,`col29`,`col30`,`col31`,`col32`,`col33`,`col34`,`col35`,`col36`,`col37`,`col38`,`col39`,`col40`,`col41`,`col42`,`col43`,`col44`,`col45`,`col46`,`col47`,`col48`,`col49`,`col50` FROM `sel_50` WHERE `col35`=4235 OR `col25`=45357 OR `col18` IN ("+strnums+") ")
//         .as ( 
//                           double("col1")~double("col2")~double("col3")~double("col4")~double("col5")~double("col6")~double("col7")~double("col8")~double("col9")~double("col10")~double("col11")~double("col12")~double("col13")~double("col14")~double("col15")~double("col16")~double("col17")~double("col18")~double("col19")~double("col20")~double("col21")~double("col22")~double("col23")~double("col24")~double("col25")~double("col26")~double("col27")~double("col28")~double("col29")~double("col30")~double("col31")~double("col32")~double("col33")~double("col34")~double("col35")~double("col36")~double("col37")~double("col38")~double("col39")~double("col40")~double("col41")~double("col42")~double("col43")~double("col44")~double("col45")~double("col46")~double("col47")~double("col48")~double("col49")~double("col50") *
//
//            )
//        }
//
//  }




	

	def insert1_int(rows:Seq[Int]) = {
	DB.withConnection { connection =>
  			rows.foreach  { i =>
  				
	  			SQL("""INSERT INTO `ins_10` VALUES ({a1},{a2},{a3},{a4},{a5},{a6},{a7},{a8},{a9},{a10})""")
	  			.on (
	  				"a1" -> i,
            "a2" -> i,
            "a3" -> i,
            "a4" -> i,
            "a5" -> i,
            "a6" -> i,
            "a7" -> i,
            "a8" -> i,
            "a9" -> i,
            "a10" -> i
            
	  			).executeUpdate()(connection)
	  	 	}
	  	 }
  		}
 
 def insert1_long(rows:Seq[Long]) = {
  DB.withConnection { connection =>
        rows.foreach  { i =>
          
          SQL("""INSERT INTO `ins_10` VALUES ({a1},{a2},{a3},{a4},{a5},{a6},{a7},{a8},{a9},{a10})""")
          .on (
            "a1" -> i,
            "a2" -> i,
            "a3" -> i,
            "a4" -> i,
            "a5" -> i,
            "a6" -> i,
            "a7" -> i,
            "a8" -> i,
            "a9" -> i,
            "a10" -> i
            
          ).executeUpdate()(connection)
        }
       }
      }

def insert1_string(rows:Seq[String]) = {
  DB.withConnection { connection =>
        rows.foreach  { i =>
          
          SQL("""INSERT INTO `ins_10` VALUES ({a1},{a2},{a3},{a4},{a5},{a6},{a7},{a8},{a9},{a10})""")
          .on (
            "a1" -> i,
            "a2" -> i,
            "a3" -> i,
            "a4" -> i,
            "a5" -> i,
            "a6" -> i,
            "a7" -> i,
            "a8" -> i,
            "a9" -> i,
            "a10" -> i
           
          ).executeUpdate()(connection)
        }
       }
      }


  

  def insert2_int(rows:Seq[Int]) = {
  DB.withConnection { connection =>
        rows.foreach  { i =>
          
          SQL("""INSERT INTO `ins_50` VALUES ({a1},{a2},{a3},{a4},{a5},{a6},{a7},{a8},{a9},{a10},{a11},{a12},{a13},{a14},{a15},{a16},{a17},{a18},{a19},{a20},{a21},{a22},{a23},{a24},{a25},{a26},{a27},{a28},{a29},{a30},{a31},{a32},{a33},{a34},{a35},{a36},{a37},{a38},{a39},{a40},{a41},{a42},{a43},{a44},{a45},{a46},{a47},{a48},{a49},{a50})""")
          .on (
            "a1" -> i,
            "a2" -> i,
            "a3" -> i,
            "a4" -> i,
            "a5" -> i,
            "a6" -> i,
            "a7" -> i,
            "a8" -> i,
            "a9" -> i,
            "a10" -> i,
            "a11" -> i,
            "a12" -> i,
            "a13" -> i,
            "a14" -> i,
            "a15" -> i,
            "a16" -> i,
            "a17" -> i,
            "a18" -> i,
            "a19" -> i,
            "a20" -> i,
            "a21" -> i,
            "a22" -> i,
            "a23" -> i,
            "a24" -> i,
            "a25" -> i,
            "a26" -> i,
            "a27" -> i,
            "a28" -> i,
            "a29" -> i,
            "a30" -> i,
            "a31" -> i,
            "a32" -> i,
            "a33" -> i,
            "a34" -> i,
            "a35" -> i,
            "a36" -> i,
            "a37" -> i,
            "a38" -> i,
            "a39" -> i,
            "a40" -> i,
            "a41" -> i,
            "a42" -> i,
            "a43" -> i,
            "a44" -> i,
            "a45" -> i,
            "a46" -> i,
            "a47" -> i,
            "a48" -> i,
            "a49" -> i,
            "a50" -> i
          ).executeUpdate()(connection)
        }
       }
      }
 
 def insert2_long(rows:Seq[Long]) = {
  DB.withConnection { connection =>
        rows.foreach  { i =>
          
          SQL("""INSERT INTO `ins_50` VALUES ({a1},{a2},{a3},{a4},{a5},{a6},{a7},{a8},{a9},{a10},{a11},{a12},{a13},{a14},{a15},{a16},{a17},{a18},{a19},{a20},{a21},{a22},{a23},{a24},{a25},{a26},{a27},{a28},{a29},{a30},{a31},{a32},{a33},{a34},{a35},{a36},{a37},{a38},{a39},{a40},{a41},{a42},{a43},{a44},{a45},{a46},{a47},{a48},{a49},{a50})""")
          .on (
            "a1" -> i,
            "a2" -> i,
            "a3" -> i,
            "a4" -> i,
            "a5" -> i,
            "a6" -> i,
            "a7" -> i,
            "a8" -> i,
            "a9" -> i,
            "a10" -> i,
            "a11" -> i,
            "a12" -> i,
            "a13" -> i,
            "a14" -> i,
            "a15" -> i,
            "a16" -> i,
            "a17" -> i,
            "a18" -> i,
            "a19" -> i,
            "a20" -> i,
            "a21" -> i,
            "a22" -> i,
            "a23" -> i,
            "a24" -> i,
            "a25" -> i,
            "a26" -> i,
            "a27" -> i,
            "a28" -> i,
            "a29" -> i,
            "a30" -> i,
            "a31" -> i,
            "a32" -> i,
            "a33" -> i,
            "a34" -> i,
            "a35" -> i,
            "a36" -> i,
            "a37" -> i,
            "a38" -> i,
            "a39" -> i,
            "a40" -> i,
            "a41" -> i,
            "a42" -> i,
            "a43" -> i,
            "a44" -> i,
            "a45" -> i,
            "a46" -> i,
            "a47" -> i,
            "a48" -> i,
            "a49" -> i,
            "a50" -> i
          ).executeUpdate()(connection)
        }
       }
      }

def insert2_string(rows:Seq[String]) = {
  DB.withConnection { connection =>
        rows.foreach  { i =>
          
          SQL("""INSERT INTO `ins_50` VALUES ({a1},{a2},{a3},{a4},{a5},{a6},{a7},{a8},{a9},{a10},{a11},{a12},{a13},{a14},{a15},{a16},{a17},{a18},{a19},{a20},{a21},{a22},{a23},{a24},{a25},{a26},{a27},{a28},{a29},{a30},{a31},{a32},{a33},{a34},{a35},{a36},{a37},{a38},{a39},{a40},{a41},{a42},{a43},{a44},{a45},{a46},{a47},{a48},{a49},{a50})""")
          .on (
            "a1" -> i,
            "a2" -> i,
            "a3" -> i,
            "a4" -> i,
            "a5" -> i,
            "a6" -> i,
            "a7" -> i,
            "a8" -> i,
            "a9" -> i,
            "a10" -> i,
            "a11" -> i,
            "a12" -> i,
            "a13" -> i,
            "a14" -> i,
            "a15" -> i,
            "a16" -> i,
            "a17" -> i,
            "a18" -> i,
            "a19" -> i,
            "a20" -> i,
            "a21" -> i,
            "a22" -> i,
            "a23" -> i,
            "a24" -> i,
            "a25" -> i,
            "a26" -> i,
            "a27" -> i,
            "a28" -> i,
            "a29" -> i,
            "a30" -> i,
            "a31" -> i,
            "a32" -> i,
            "a33" -> i,
            "a34" -> i,
            "a35" -> i,
            "a36" -> i,
            "a37" -> i,
            "a38" -> i,
            "a39" -> i,
            "a40" -> i,
            "a41" -> i,
            "a42" -> i,
            "a43" -> i,
            "a44" -> i,
            "a45" -> i,
            "a46" -> i,
            "a47" -> i,
            "a48" -> i,
            "a49" -> i,
            "a50" -> i
          ).executeUpdate()(connection)
        }
       }
      }


  

  def insert3_int(rows:Seq[Int]) = {
  DB.withConnection { connection =>
        rows.foreach  { i =>
          
          SQL("""INSERT INTO `ins_200` VALUES ({a1},{a2},{a3},{a4},{a5},{a6},{a7},{a8},{a9},{a10},{a11},{a12},{a13},{a14},{a15},{a16},{a17},{a18},{a19},{a20},{a21},{a22},{a23},{a24},{a25},{a26},{a27},{a28},{a29},{a30},{a31},{a32},{a33},{a34},{a35},{a36},{a37},{a38},{a39},{a40},{a41},{a42},{a43},{a44},{a45},{a46},{a47},{a48},{a49},{a50},{a51},{a52},{a53},{a54},{a55},{a56},{a57},{a58},{a59},{a60},{a61},{a62},{a63},{a64},{a65},{a66},{a67},{a68},{a69},{a70},{a71},{a72},{a73},{a74},{a75},{a76},{a77},{a78},{a79},{a80},{a81},{a82},{a83},{a84},{a85},{a86},{a87},{a88},{a89},{a90},{a91},{a92},{a93},{a94},{a95},{a96},{a97},{a98},{a99},{a100},{a101},{a102},{a103},{a104},{a105},{a106},{a107},{a108},{a109},{a110},{a111},{a112},{a113},{a114},{a115},{a116},{a117},{a118},{a119},{a120},{a121},{a122},{a123},{a124},{a125},{a126},{a127},{a128},{a129},{a130},{a131},{a132},{a133},{a134},{a135},{a136},{a137},{a138},{a139},{a140},{a141},{a142},{a143},{a144},{a145},{a146},{a147},{a148},{a149},{a150},{a151},{a152},{a153},{a154},{a155},{a156},{a157},{a158},{a159},{a160},{a161},{a162},{a163},{a164},{a165},{a166},{a167},{a168},{a169},{a170},{a171},{a172},{a173},{a174},{a175},{a176},{a177},{a178},{a179},{a180},{a181},{a182},{a183},{a184},{a185},{a186},{a187},{a188},{a189},{a190},{a191},{a192},{a193},{a194},{a195},{a196},{a197},{a198},{a199},{a200})""")
          .on (
            "a1" -> i,
            "a2" -> i,
            "a3" -> i,
            "a4" -> i,
            "a5" -> i,
            "a6" -> i,
            "a7" -> i,
            "a8" -> i,
            "a9" -> i,
            "a10" -> i,
            "a11" -> i,
            "a12" -> i,
            "a13" -> i,
            "a14" -> i,
            "a15" -> i,
            "a16" -> i,
            "a17" -> i,
            "a18" -> i,
            "a19" -> i,
            "a20" -> i,
            "a21" -> i,
            "a22" -> i,
            "a23" -> i,
            "a24" -> i,
            "a25" -> i,
            "a26" -> i,
            "a27" -> i,
            "a28" -> i,
            "a29" -> i,
            "a30" -> i,
            "a31" -> i,
            "a32" -> i,
            "a33" -> i,
            "a34" -> i,
            "a35" -> i,
            "a36" -> i,
            "a37" -> i,
            "a38" -> i,
            "a39" -> i,
            "a40" -> i,
            "a41" -> i,
            "a42" -> i,
            "a43" -> i,
            "a44" -> i,
            "a45" -> i,
            "a46" -> i,
            "a47" -> i,
            "a48" -> i,
            "a49" -> i,
            "a50" -> i,
            "a51" -> i,
"a52" -> i,
"a53" -> i,
"a54" -> i,
"a55" -> i,
"a56" -> i,
"a57" -> i,
"a58" -> i,
"a59" -> i,
"a60" -> i,
"a61" -> i,
"a62" -> i,
"a63" -> i,
"a64" -> i,
"a65" -> i,
"a66" -> i,
"a67" -> i,
"a68" -> i,
"a69" -> i,
"a70" -> i,
"a71" -> i,
"a72" -> i,
"a73" -> i,
"a74" -> i,
"a75" -> i,
"a76" -> i,
"a77" -> i,
"a78" -> i,
"a79" -> i,
"a80" -> i,
"a81" -> i,
"a82" -> i,
"a83" -> i,
"a84" -> i,
"a85" -> i,
"a86" -> i,
"a87" -> i,
"a88" -> i,
"a89" -> i,
"a90" -> i,
"a91" -> i,
"a92" -> i,
"a93" -> i,
"a94" -> i,
"a95" -> i,
"a96" -> i,
"a97" -> i,
"a98" -> i,
"a99" -> i,
"a100" -> i,
"a101" -> i,
"a102" -> i,
"a103" -> i,
"a104" -> i,
"a105" -> i,
"a106" -> i,
"a107" -> i,
"a108" -> i,
"a109" -> i,
"a110" -> i,
"a111" -> i,
"a112" -> i,
"a113" -> i,
"a114" -> i,
"a115" -> i,
"a116" -> i,
"a117" -> i,
"a118" -> i,
"a119" -> i,
"a120" -> i,
"a121" -> i,
"a122" -> i,
"a123" -> i,
"a124" -> i,
"a125" -> i,
"a126" -> i,
"a127" -> i,
"a128" -> i,
"a129" -> i,
"a130" -> i,
"a131" -> i,
"a132" -> i,
"a133" -> i,
"a134" -> i,
"a135" -> i,
"a136" -> i,
"a137" -> i,
"a138" -> i,
"a139" -> i,
"a140" -> i,
"a141" -> i,
"a142" -> i,
"a143" -> i,
"a144" -> i,
"a145" -> i,
"a146" -> i,
"a147" -> i,
"a148" -> i,
"a149" -> i,
"a150" -> i,
"a151" -> i,
"a152" -> i,
"a153" -> i,
"a154" -> i,
"a155" -> i,
"a156" -> i,
"a157" -> i,
"a158" -> i,
"a159" -> i,
"a160" -> i,
"a161" -> i,
"a162" -> i,
"a163" -> i,
"a164" -> i,
"a165" -> i,
"a166" -> i,
"a167" -> i,
"a168" -> i,
"a169" -> i,
"a170" -> i,
"a171" -> i,
"a172" -> i,
"a173" -> i,
"a174" -> i,
"a175" -> i,
"a176" -> i,
"a177" -> i,
"a178" -> i,
"a179" -> i,
"a180" -> i,
"a181" -> i,
"a182" -> i,
"a183" -> i,
"a184" -> i,
"a185" -> i,
"a186" -> i,
"a187" -> i,
"a188" -> i,
"a189" -> i,
"a190" -> i,
"a191" -> i,
"a192" -> i,
"a193" -> i,
"a194" -> i,
"a195" -> i,
"a196" -> i,
"a197" -> i,
"a198" -> i,
"a199" -> i,
"a200" -> i
          ).executeUpdate()(connection)
        }
       }
      }
 
 def insert3_long(rows:Seq[Long]) = {
  DB.withConnection { connection =>
        rows.foreach  { i =>
          
          SQL("""INSERT INTO `ins_200` VALUES ({a1},{a2},{a3},{a4},{a5},{a6},{a7},{a8},{a9},{a10},{a11},{a12},{a13},{a14},{a15},{a16},{a17},{a18},{a19},{a20},{a21},{a22},{a23},{a24},{a25},{a26},{a27},{a28},{a29},{a30},{a31},{a32},{a33},{a34},{a35},{a36},{a37},{a38},{a39},{a40},{a41},{a42},{a43},{a44},{a45},{a46},{a47},{a48},{a49},{a50},{a51},{a52},{a53},{a54},{a55},{a56},{a57},{a58},{a59},{a60},{a61},{a62},{a63},{a64},{a65},{a66},{a67},{a68},{a69},{a70},{a71},{a72},{a73},{a74},{a75},{a76},{a77},{a78},{a79},{a80},{a81},{a82},{a83},{a84},{a85},{a86},{a87},{a88},{a89},{a90},{a91},{a92},{a93},{a94},{a95},{a96},{a97},{a98},{a99},{a100},{a101},{a102},{a103},{a104},{a105},{a106},{a107},{a108},{a109},{a110},{a111},{a112},{a113},{a114},{a115},{a116},{a117},{a118},{a119},{a120},{a121},{a122},{a123},{a124},{a125},{a126},{a127},{a128},{a129},{a130},{a131},{a132},{a133},{a134},{a135},{a136},{a137},{a138},{a139},{a140},{a141},{a142},{a143},{a144},{a145},{a146},{a147},{a148},{a149},{a150},{a151},{a152},{a153},{a154},{a155},{a156},{a157},{a158},{a159},{a160},{a161},{a162},{a163},{a164},{a165},{a166},{a167},{a168},{a169},{a170},{a171},{a172},{a173},{a174},{a175},{a176},{a177},{a178},{a179},{a180},{a181},{a182},{a183},{a184},{a185},{a186},{a187},{a188},{a189},{a190},{a191},{a192},{a193},{a194},{a195},{a196},{a197},{a198},{a199},{a200})""")
          .on (
            "a1" -> i,
            "a2" -> i,
            "a3" -> i,
            "a4" -> i,
            "a5" -> i,
            "a6" -> i,
            "a7" -> i,
            "a8" -> i,
            "a9" -> i,
            "a10" -> i,
            "a11" -> i,
            "a12" -> i,
            "a13" -> i,
            "a14" -> i,
            "a15" -> i,
            "a16" -> i,
            "a17" -> i,
            "a18" -> i,
            "a19" -> i,
            "a20" -> i,
            "a21" -> i,
            "a22" -> i,
            "a23" -> i,
            "a24" -> i,
            "a25" -> i,
            "a26" -> i,
            "a27" -> i,
            "a28" -> i,
            "a29" -> i,
            "a30" -> i,
            "a31" -> i,
            "a32" -> i,
            "a33" -> i,
            "a34" -> i,
            "a35" -> i,
            "a36" -> i,
            "a37" -> i,
            "a38" -> i,
            "a39" -> i,
            "a40" -> i,
            "a41" -> i,
            "a42" -> i,
            "a43" -> i,
            "a44" -> i,
            "a45" -> i,
            "a46" -> i,
            "a47" -> i,
            "a48" -> i,
            "a49" -> i,
            "a50" -> i,
            "a51" -> i,
"a52" -> i,
"a53" -> i,
"a54" -> i,
"a55" -> i,
"a56" -> i,
"a57" -> i,
"a58" -> i,
"a59" -> i,
"a60" -> i,
"a61" -> i,
"a62" -> i,
"a63" -> i,
"a64" -> i,
"a65" -> i,
"a66" -> i,
"a67" -> i,
"a68" -> i,
"a69" -> i,
"a70" -> i,
"a71" -> i,
"a72" -> i,
"a73" -> i,
"a74" -> i,
"a75" -> i,
"a76" -> i,
"a77" -> i,
"a78" -> i,
"a79" -> i,
"a80" -> i,
"a81" -> i,
"a82" -> i,
"a83" -> i,
"a84" -> i,
"a85" -> i,
"a86" -> i,
"a87" -> i,
"a88" -> i,
"a89" -> i,
"a90" -> i,
"a91" -> i,
"a92" -> i,
"a93" -> i,
"a94" -> i,
"a95" -> i,
"a96" -> i,
"a97" -> i,
"a98" -> i,
"a99" -> i,
"a100" -> i,
"a101" -> i,
"a102" -> i,
"a103" -> i,
"a104" -> i,
"a105" -> i,
"a106" -> i,
"a107" -> i,
"a108" -> i,
"a109" -> i,
"a110" -> i,
"a111" -> i,
"a112" -> i,
"a113" -> i,
"a114" -> i,
"a115" -> i,
"a116" -> i,
"a117" -> i,
"a118" -> i,
"a119" -> i,
"a120" -> i,
"a121" -> i,
"a122" -> i,
"a123" -> i,
"a124" -> i,
"a125" -> i,
"a126" -> i,
"a127" -> i,
"a128" -> i,
"a129" -> i,
"a130" -> i,
"a131" -> i,
"a132" -> i,
"a133" -> i,
"a134" -> i,
"a135" -> i,
"a136" -> i,
"a137" -> i,
"a138" -> i,
"a139" -> i,
"a140" -> i,
"a141" -> i,
"a142" -> i,
"a143" -> i,
"a144" -> i,
"a145" -> i,
"a146" -> i,
"a147" -> i,
"a148" -> i,
"a149" -> i,
"a150" -> i,
"a151" -> i,
"a152" -> i,
"a153" -> i,
"a154" -> i,
"a155" -> i,
"a156" -> i,
"a157" -> i,
"a158" -> i,
"a159" -> i,
"a160" -> i,
"a161" -> i,
"a162" -> i,
"a163" -> i,
"a164" -> i,
"a165" -> i,
"a166" -> i,
"a167" -> i,
"a168" -> i,
"a169" -> i,
"a170" -> i,
"a171" -> i,
"a172" -> i,
"a173" -> i,
"a174" -> i,
"a175" -> i,
"a176" -> i,
"a177" -> i,
"a178" -> i,
"a179" -> i,
"a180" -> i,
"a181" -> i,
"a182" -> i,
"a183" -> i,
"a184" -> i,
"a185" -> i,
"a186" -> i,
"a187" -> i,
"a188" -> i,
"a189" -> i,
"a190" -> i,
"a191" -> i,
"a192" -> i,
"a193" -> i,
"a194" -> i,
"a195" -> i,
"a196" -> i,
"a197" -> i,
"a198" -> i,
"a199" -> i,
"a200" -> i
          ).executeUpdate()(connection)
        }
       }
      }

def insert3_string(rows:Seq[String]) = {
  DB.withConnection { connection =>
        rows.foreach  { i =>
          
          SQL("""INSERT INTO `ins_200` VALUES ({a1},{a2},{a3},{a4},{a5},{a6},{a7},{a8},{a9},{a10},{a11},{a12},{a13},{a14},{a15},{a16},{a17},{a18},{a19},{a20},{a21},{a22},{a23},{a24},{a25},{a26},{a27},{a28},{a29},{a30},{a31},{a32},{a33},{a34},{a35},{a36},{a37},{a38},{a39},{a40},{a41},{a42},{a43},{a44},{a45},{a46},{a47},{a48},{a49},{a50},{a51},{a52},{a53},{a54},{a55},{a56},{a57},{a58},{a59},{a60},{a61},{a62},{a63},{a64},{a65},{a66},{a67},{a68},{a69},{a70},{a71},{a72},{a73},{a74},{a75},{a76},{a77},{a78},{a79},{a80},{a81},{a82},{a83},{a84},{a85},{a86},{a87},{a88},{a89},{a90},{a91},{a92},{a93},{a94},{a95},{a96},{a97},{a98},{a99},{a100},{a101},{a102},{a103},{a104},{a105},{a106},{a107},{a108},{a109},{a110},{a111},{a112},{a113},{a114},{a115},{a116},{a117},{a118},{a119},{a120},{a121},{a122},{a123},{a124},{a125},{a126},{a127},{a128},{a129},{a130},{a131},{a132},{a133},{a134},{a135},{a136},{a137},{a138},{a139},{a140},{a141},{a142},{a143},{a144},{a145},{a146},{a147},{a148},{a149},{a150},{a151},{a152},{a153},{a154},{a155},{a156},{a157},{a158},{a159},{a160},{a161},{a162},{a163},{a164},{a165},{a166},{a167},{a168},{a169},{a170},{a171},{a172},{a173},{a174},{a175},{a176},{a177},{a178},{a179},{a180},{a181},{a182},{a183},{a184},{a185},{a186},{a187},{a188},{a189},{a190},{a191},{a192},{a193},{a194},{a195},{a196},{a197},{a198},{a199},{a200})""")
          .on (
            "a1" -> i,
            "a2" -> i,
            "a3" -> i,
            "a4" -> i,
            "a5" -> i,
            "a6" -> i,
            "a7" -> i,
            "a8" -> i,
            "a9" -> i,
            "a10" -> i,
            "a11" -> i,
            "a12" -> i,
            "a13" -> i,
            "a14" -> i,
            "a15" -> i,
            "a16" -> i,
            "a17" -> i,
            "a18" -> i,
            "a19" -> i,
            "a20" -> i,
            "a21" -> i,
            "a22" -> i,
            "a23" -> i,
            "a24" -> i,
            "a25" -> i,
            "a26" -> i,
            "a27" -> i,
            "a28" -> i,
            "a29" -> i,
            "a30" -> i,
            "a31" -> i,
            "a32" -> i,
            "a33" -> i,
            "a34" -> i,
            "a35" -> i,
            "a36" -> i,
            "a37" -> i,
            "a38" -> i,
            "a39" -> i,
            "a40" -> i,
            "a41" -> i,
            "a42" -> i,
            "a43" -> i,
            "a44" -> i,
            "a45" -> i,
            "a46" -> i,
            "a47" -> i,
            "a48" -> i,
            "a49" -> i,
            "a50" -> i,
            "a51" -> i,
"a52" -> i,
"a53" -> i,
"a54" -> i,
"a55" -> i,
"a56" -> i,
"a57" -> i,
"a58" -> i,
"a59" -> i,
"a60" -> i,
"a61" -> i,
"a62" -> i,
"a63" -> i,
"a64" -> i,
"a65" -> i,
"a66" -> i,
"a67" -> i,
"a68" -> i,
"a69" -> i,
"a70" -> i,
"a71" -> i,
"a72" -> i,
"a73" -> i,
"a74" -> i,
"a75" -> i,
"a76" -> i,
"a77" -> i,
"a78" -> i,
"a79" -> i,
"a80" -> i,
"a81" -> i,
"a82" -> i,
"a83" -> i,
"a84" -> i,
"a85" -> i,
"a86" -> i,
"a87" -> i,
"a88" -> i,
"a89" -> i,
"a90" -> i,
"a91" -> i,
"a92" -> i,
"a93" -> i,
"a94" -> i,
"a95" -> i,
"a96" -> i,
"a97" -> i,
"a98" -> i,
"a99" -> i,
"a100" -> i,
"a101" -> i,
"a102" -> i,
"a103" -> i,
"a104" -> i,
"a105" -> i,
"a106" -> i,
"a107" -> i,
"a108" -> i,
"a109" -> i,
"a110" -> i,
"a111" -> i,
"a112" -> i,
"a113" -> i,
"a114" -> i,
"a115" -> i,
"a116" -> i,
"a117" -> i,
"a118" -> i,
"a119" -> i,
"a120" -> i,
"a121" -> i,
"a122" -> i,
"a123" -> i,
"a124" -> i,
"a125" -> i,
"a126" -> i,
"a127" -> i,
"a128" -> i,
"a129" -> i,
"a130" -> i,
"a131" -> i,
"a132" -> i,
"a133" -> i,
"a134" -> i,
"a135" -> i,
"a136" -> i,
"a137" -> i,
"a138" -> i,
"a139" -> i,
"a140" -> i,
"a141" -> i,
"a142" -> i,
"a143" -> i,
"a144" -> i,
"a145" -> i,
"a146" -> i,
"a147" -> i,
"a148" -> i,
"a149" -> i,
"a150" -> i,
"a151" -> i,
"a152" -> i,
"a153" -> i,
"a154" -> i,
"a155" -> i,
"a156" -> i,
"a157" -> i,
"a158" -> i,
"a159" -> i,
"a160" -> i,
"a161" -> i,
"a162" -> i,
"a163" -> i,
"a164" -> i,
"a165" -> i,
"a166" -> i,
"a167" -> i,
"a168" -> i,
"a169" -> i,
"a170" -> i,
"a171" -> i,
"a172" -> i,
"a173" -> i,
"a174" -> i,
"a175" -> i,
"a176" -> i,
"a177" -> i,
"a178" -> i,
"a179" -> i,
"a180" -> i,
"a181" -> i,
"a182" -> i,
"a183" -> i,
"a184" -> i,
"a185" -> i,
"a186" -> i,
"a187" -> i,
"a188" -> i,
"a189" -> i,
"a190" -> i,
"a191" -> i,
"a192" -> i,
"a193" -> i,
"a194" -> i,
"a195" -> i,
"a196" -> i,
"a197" -> i,
"a198" -> i,
"a199" -> i,
"a200" -> i
          ).executeUpdate()(connection)
        }
       }
      }


	def update1_int(strnums:String) = {
		DB.withConnection { connection =>
			SQL("""UPDATE `sel_50` SET `col13`=16 ,`col33`=19 where `col22` IN ("""+strnums+""")""")
			.executeUpdate()(connection)

 	}
 }
  def update1_long(strnums:String) = {
    DB.withConnection { connection =>
      SQL("""UPDATE `sel_50` SET `col13`=16 ,`col33`=19 where `col22` IN ("""+strnums+""")""")
      .executeUpdate()(connection)

  }
}
  def update1_string(strnums:String) = {
    DB.withConnection { connection =>
      SQL("""UPDATE `sel_50` SET `col13`='16' ,`col33`='19' where `col22` IN ("""+strnums+""")""")
      .executeUpdate()(connection)

  }
}

	def update2_int(strnums:String) = {

		DB.withConnection { connection =>	
			SQL("""UPDATE `sel_50` SET `col1`=16 ,`col43`=19, `col45`=14, `col32`=45, `col26`=254,`col3`=34, `col5`=235, `col12`=5, `col29`=234, `col17`=34 WHERE `col12` IN  ("""+strnums+""")""")
			.executeUpdate()(connection)

	}

}


  def update2_long(strnums:String) = {

    DB.withConnection { connection => 
      SQL("""UPDATE `sel_50` SET `col1`=16 ,`col43`=19, `col45`=14, `col32`=45, `col26`=254,`col3`=34, `col5`=235, `col12`=5, `col29`=234, `col17`=34 WHERE `col12` IN  ("""+strnums+""")""")
      .executeUpdate()(connection)

  }

}

  def update2_string(strnums:String) = {

    DB.withConnection { connection => 
      SQL("""UPDATE `sel_50` SET `col1`='116' ,`col43`='19', `col45`='14', `col32`='45', `col26`='254',`col3`='34', `col5`='235', `col12`='5', `col29`='234', `col17`='34' WHERE `col12` IN  ("""+strnums+""")""")
      .executeUpdate()(connection)

  }

}

  def update3_int(strnums:String) = {

    DB.withConnection { connection => 
      SQL("""UPDATE `sel_50` SET `col1`=16 ,`col43`=19, `col45`=14, `col32`=45, `col26`=254,`col3`=34, `col5`=235, `col12`=5, `col29`=234, `col17`=34,`col18`=423, `col19`=341, `col27`=3243, `col28`=2315, `col25`=1234, `col33` = 34126, `col34` = 23425 ,`col35`=342 ,`col1`=234, `col49`=3576 WHERE `col12` IN  ("""+strnums+""")""")
      .executeUpdate()(connection)

  }

}


  def update3_long(strnums:String) = {

    DB.withConnection { connection => 
      SQL("""UPDATE `sel_50` SET `col1`=16 ,`col43`=19, `col45`=14, `col32`=45, `col26`=254,`col3`=34, `col5`=235, `col12`=5, `col29`=234, `col17`=34,`col18`=423, `col19`=341, `col27`=3243, `col28`=2315, `col25`=1234, `col33` = 34126, `col34` = 23425 ,`col35`=342 ,`col1`=234, `col49`=3576 WHERE `col12` IN  ("""+strnums+""")""")
      .executeUpdate()(connection)

  }

}

  def update3_string(strnums:String) = {

    DB.withConnection { connection => 
      SQL("""UPDATE `sel_50` SET `col1`='116' ,`col43`='19', `col45`='14', `col32`='45', `col26`='254',`col3`='34', `col5`='235', `col12`='5', `col29`='234', `col17`='34',`col18`=423, `col19`=341, `col27`=3243, `col28`=2315, `col25`=1234, `col33` = 34126, `col34` = 23425, `col35`=342 ,`col1`=234, `col49`=3576 WHERE `col12` IN  ("""+strnums+""")""")
      .executeUpdate()(connection)

  }

}

}
