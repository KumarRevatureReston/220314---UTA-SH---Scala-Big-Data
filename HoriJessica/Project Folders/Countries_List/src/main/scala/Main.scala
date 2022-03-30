//import java.io.{BufferedReader, File, FileReader}
//import org.postgresql.copy.CopyManager
//import org.postgresql.core.BaseConnection
//import org.slf4j.LoggerFactory
//import java.nio.charset.Charset
//import java.sql.Connection


object Main {

  def main(args: Array[String]): Unit = {
    //create
   // val count=CrudUtil.createQuery()
    //println(count)

  // CrudUtil.copyCSVQuery

    //read
   // CrudUtil.readQuery()

//    //insert
//    CrudUtil.insertQuery()

    // update
//    CrudUtil.updateQuery()
    println("-----------------------------------")
    println("-----------------------------------")

//    //delete
   CrudUtil.deleteQuery()

    //read
    CrudUtil.readQuery()

  }


}
