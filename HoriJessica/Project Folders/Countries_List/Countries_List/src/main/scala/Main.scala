object Main {

  def main(args: Array[String]): Unit = {
    //create
    val count=CrudUtil.createQuery()
    println(count)
    //read
    CrudUtil.readQuery()
    println(count)

    //insert
    CrudUtil.insertQuery()
    println(count)

    // update
    CrudUtil.updateQuery()
    println(count)

    //delete
    CrudUtil.deleteQuery()
    println(count)
  }


}