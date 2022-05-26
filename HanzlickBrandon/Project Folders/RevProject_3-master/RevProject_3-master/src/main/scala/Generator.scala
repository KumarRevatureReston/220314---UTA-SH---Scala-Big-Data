import java.util.Properties
import scala.io._
import scala.language.postfixOps
import scala.collection.mutable._
import java.time._
import scala.util.Random
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

object Generator {

  def main(args: Array[String]): Unit = {

    var presets = Map(
      "minNumSales" -> "25000", // minimum number of records allowed
      "startDate" -> "2020,1,1", // start date of sales
      "endDate" -> "2021,1,1", // end date of sales
      "minRecordsPerDay" -> "" // min records per day - result of days / numberSales -- Auto adjusted based on minNumSales and Dates
    )
    // set trends to be randomly picked from
    val trends = List(
      Map("trendSetter" -> "customer", "setterValue" -> "India", "trendEffect" -> "product", "effectValue" -> "Fruits", "percentModifier" -> "40"),
      Map("trendSetter" -> "product", "setterValue" -> "Meat", "trendEffect" -> "customer", "effectValue" -> "United States", "percentModifier" -> "30"),
      Map("trendSetter" -> "paymentType", "setterValue" -> "eWallet", "trendEffect" -> "customer", "effectValue" -> "India", "percentModifier" -> "60"),
      Map("trendSetter" -> "customer", "setterValue" -> "Mexico", "trendEffect" -> "paymentType", "effectValue" -> "eWallet", "percentModifier" -> "50"),
      Map("trendSetter" -> "paymentType", "setterValue" -> "eWallet", "trendEffect" -> "passFail", "effectValue" -> "fail", "percentModifier" -> "40"),
      Map("trendSetter" -> "customer", "setterValue" -> "Canada", "trendEffect" -> "product", "effectValue" -> "Baby Food", "percentModifier" -> "40"),
      Map("trendSetter" -> "product", "setterValue" -> "Clothes", "trendEffect" -> "customer", "effectValue" -> "China", "percentModifier" -> "70"),
      Map("trendSetter" -> "paymentType", "setterValue" -> "credit card", "trendEffect" -> "customer", "effectValue" -> "United States", "percentModifier" -> "85")
    )

    // List( List( "trend setter", "setter contains", "trend effect", "effect contains, "percent chance"))

    // some default values
    // default path to current csv file
    //val path = "C:\\Users\\samps\\IdeaProjects\\RevProject_3\\src\\resources\\" // path for windows, IntelliJ
    val path = "/mnt/c/Users/samps/IdeaProjects/RevProject_3/src/resources/"  // path for ubuntu in windows
    val path1 = path + "customer.csv"
    val path2 = path + "product.csv"

    // get the records from csv and save them in a variable, Also gets the column names from csv files
    val csvInfo = getCSVFiles(presets, path1, path2) // returns List[List[List[String]]]

    // if we are not passing any arguments in the command line, do the default action
    if (args.isEmpty ) {

      // set the start date to preset date if set, otherwise set date to current date
      val startDate = {
        if (presets("startDate") != "") {
          dateWorker(presets, "startDate")
        } else {
          LocalDate.now()
        }
      }
      // set end date value, ' need to make if equal to or greater than start iggy and keep running '
      val endDate = {
        if (presets("endDate") != "") {
          dateWorker(presets, "endDate")
        } else {
          LocalDate.now()
        }
      }
      // calculate number of days to run sales events
      // set a current pointer to update the date of each sale
      var currentDatePointer = startDate
      var salesPeriod = (endDate.toEpochDay - startDate.toEpochDay).toInt
      //  set min records per day to meet the criteria if minNumSales is set
      if (presets("minNumSales") != "") {
        presets("minRecordsPerDay") = math.ceil(presets("minNumSales").toFloat / salesPeriod.toFloat).toInt.toString
      }
      //  set up sales id variable to track sales Id number that is generated
      var orderId = 0
      // holds the count of records produces
      var count = 0

      // loop to generate sales per day as per presets
      for (x <- 0 to salesPeriod) {
        for (y <- 0 to presets("minRecordsPerDay").toInt) {

          // to text how many sales records are created
          count = count + 1

          // pass in the proper info in the correct format and run create sales event
          val sale = createSaleEvent(presets,trends, currentDatePointer,orderId, csvInfo.head, csvInfo(1),csvInfo(2).head,csvInfo(3).head)

          // use sleep to slow down the stream to kafka
          //Thread.sleep(50)
          //println("//-------------------------------------------------------------------------------------------------")
          //println(sale.toString)
          producerFunc(sale)

          // Update Necessary Items
          orderId += 1
          currentDatePointer = currentDatePointer.plusDays(1)
        }
      }
      val endTime = LocalDateTime.now()

      println(count)
      //println(startTime +" : " + endTime)
      //println(presets("minRecordsPerDay"))


    }

    // set a while run function here to run as long as it is true for continuous loop


  }

  def getCSVFiles(presets: Map[String, String], filePath1: String = "", filePath2: String = ""):List[List[List[String]]] = {  //List[List[List[String]]]

    val customerFile = Source.fromFile(filePath1)
    val productFile = Source.fromFile(filePath2)
    // create column header for customers
    val customerColumnsSrc = customerFile.getLines.take(1).toList
    val customerColumns = customerColumnsSrc(0).split(",").toList // create list of customer columns
    val matchTypeCustomerColumns = List(customerColumns) // just matching type for return purposes
    // create column header for products
    val productColumnsSrc = productFile.getLines.take(1).toList
    val productColumns = productColumnsSrc(0).split(",").toList // create list of product columns
    val matchTypeProductColumns = List(productColumns) // just matching for return purposes
    // get remaining lines from csv to create data table
    val customerData = customerFile.getLines.toList
    val productData = productFile.getLines.toList
    // Build a list of lists as a table structure so I can randomly select information
    val customerValuesTable = buildList(customerData)
    val productValuesTable = buildList(productData)

    val returnValue = List(customerValuesTable,productValuesTable,matchTypeCustomerColumns,matchTypeProductColumns)
    // handoff to build sales event function to build the sales event and pass each built sale to the producer
    //createSaleEvent(presets, customerValuesTable, productValuesTable, customerColumns, productColumns) // may change order of this in the future, to send to producer then producer func calls create sales event?

    //println(returnValue)
    returnValue
  }

  def buildList(initList: List[String]): List[List[String]] = {

    val tempList = new ListBuffer[List[String]]

    for (x <- 0 until initList.length) {
      val tempSubList = initList(x).split(",").toList
      tempList.append(tempSubList)
    }
    return tempList.toList
  }

  def createSaleEvent(presets: Map[String, String],trends:List[Map[String,String]], currentDatePointer:LocalDate,orderId:Int, customerData: List[List[String]], productData: List[List[String]], customerColumnHeader: List[String], productColumnHeader: List[String]):String = {

    // setup default payment types
    val paymentTypes = List("debit card", "credit card", "internet banking", "upi", "eWallet")
    // setup payment data to allow to be passed to percentfunctions
    val paymentTypeData = for { paymentType <- paymentTypes } yield List(paymentType)
    // setup default failure reasons
    val failureReasons = List("Insufficient Funds", "Invalid Input", "Connection Error")
    // setup failure data to be passed to failure functions
    val failureData = for { failureReason <- failureReasons } yield List(failureReason)
    // setup default websites
    val websites = Map(
      "gogogrocery.com" -> List("Fruits", "Beverages", "Baby Food", "Vegetables", "Cereal", "Meat", "Snacks"),
      "thehardstore.net" -> List("Hardware", "Household", "Office Supplies", "Clothes"),
      "EGad-get.com" -> List("Tech Hardware"),
      "NailsNNails.com" -> List("Hardware", "Cosmetics", "Personal Care", "Clothes"),
      "allgoods.net" -> List("Fruits", "Beverages", "Baby Food", "Vegetables", "Clothes", "Cereal", "Cosmetics", "Meat", "Office Supplies", "Household", "Snacks", "Personal Care", "Hardware", "Tech Hardware"),
      "memawmall.net" -> List("Clothes", "Cosmetics", "Household", "Snacks", "Personal Care"),
      "onfice.com" -> List("Tech Hardware", "Office Supplies"),
      "discodiscount.com" -> List("Cosmetics", "Clothes", "Tech Hardware"),
      "petesbigbutcher.net" -> List("Meat", "Clothes", "Snacks"),
      "vis4vegan.com" -> List("Fruits", "Beverages", "Baby Food", "Vegetables", "Snacks")
    )
    val websiteNames = websites.keys.toList
    // testing pulling the sites that contains specific types of goods.
    //val test = websites.collect{ case x if x._2.contains("Clothes") => x._1 }.toList
    //println(test)
    // setup default string variable to
    var thisSale = new StringBuilder("")
    // set a time and count for records to see how long and how many records produced.
    val startTime = LocalDateTime.now()

    //------- Other Preset Variables that are modified in the if else statement --------//

    // generate random customer
    var customer = customerData(Random.nextInt(customerData.length))
    // generate random product
    var product = productData(Random.nextInt(productData.length))
    // payment_type
    var paymentType = paymentTypes(Random.nextInt(paymentTypes.length))
    // select quantity between 1 and 100 - default 1-30, 50% - 31-65, 35% - 66-100, 15%
    var qty = selectQty() // can add logic to update or change the range later format List(List(percentChance Int, highestValueWithThisPercent Int))
    // set price of product to price of product plus generated qty
    //var price = (product(3) * qty).toString.replaceAll("(?<=\\d\\.\\d{2}).*", "")
    var price = product(3).toString.replaceAll("(?<=\\d\\.\\d{2}).*", "")
    // set current dateTime
    var dateTime = currentDatePointer
    // generate website ordered from at random
    var website = websiteNames(Random.nextInt(websiteNames.length)).toString // store as string so can be used to call other info
    // setup transaction Id -- to be unique, used orderId and Date
    var paymentTxnId = s"${orderId}${currentDatePointer.toEpochDay}"
    // generate random failure rate - set failure rate to 20% in this example
    var paymentTxnSuccess = if (Random.nextInt(100) > 5) {
      "pass"
    } else {
      "fail"
    }
    // set dataset to run percent on success/fail
    var paymentTxnSuccessData = List(List("pass"), List("fail"))

    // ------------------------------------------------------------------------------//
    // randomly select trend from trend list
    val trendItem = trends(Random.nextInt(trends.length))


    if( trendItem("trendSetter") == "customer"){

      customer = customerTrend(trendItem("setterValue"),customerData)

      trendItem("trendEffect") match {
        case "product" => product = productTrend(trendItem("effectValue"), productData, trendItem("percentModifier"))
        case "paymentType" => paymentType = pmtTypeTrend(trendItem("effectValue"), paymentTypeData, trendItem("percentModifier")).head
        case "passFail" => paymentTxnSuccess = pmtSuccessTrend(trendItem("effectValue"), paymentTxnSuccessData, trendItem("percentModifier")).head
      }


    }else if( trendItem("trendSetter") == "product"){

      product = productTrend(trendItem("setterValue"),productData)

      trendItem("trendEffect") match {
        case "customer" => customer = customerTrend(trendItem("effectValue"), customerData, trendItem("percentModifier"))
        case "paymentType" => paymentType = pmtTypeTrend(trendItem("effectValue"), paymentTypeData, trendItem("percentModifier")).head
        case "passFail" => paymentTxnSuccess = pmtSuccessTrend(trendItem("effectValue"), paymentTxnSuccessData, trendItem("percentModifier")).head
      }
    }else if( trendItem("trendSetter") == "paymentType"){
      paymentType = pmtTypeTrend(trendItem("setterValue"), paymentTypeData).head

      trendItem("trendEffect") match {
        case "customer" => customer = customerTrend(trendItem("effectValue"), customerData, trendItem("percentModifier"))
        case "product" => product = productTrend(trendItem("effectValue"), productData, trendItem("percentModifier"))
        case "passFail" => paymentTxnSuccess = pmtSuccessTrend(trendItem("effectValue"), paymentTxnSuccessData, trendItem("percentModifier")).head
      }
    }else if( trendItem("trendSetter") == "passFail"){

      paymentTxnSuccess = pmtTypeTrend(trendItem("setterValue"), paymentTypeData).head

      trendItem("trendEffect") match {
        case "customer" => customer = customerTrend(trendItem("effectValue"), customerData, trendItem("percentModifier"))
        case "product" => product = productTrend(trendItem("effectValue"), productData, trendItem("percentModifier"))
        case "paymentType" => paymentType = pmtTypeTrend(trendItem("effectValue"), paymentTypeData, trendItem("percentModifier")).head
      }

    }else{}


    // set final product price after final product generation
    price = product(3).toString.replaceAll("(?<=\\d\\.\\d{2}).*", "")

    // set failure reason after trends are generated
    // setup basic failure reason
    var failureReason = if (paymentTxnSuccess == "fail") {
      failureReasons(Random.nextInt(failureReasons.length))
    } else {
      ""
    }
    // set website after product has been picked
    val validWebsites = websites.collect{ case x if x._2.contains(product(2)) => x._1 }.toList
    website = validWebsites(Random.nextInt(validWebsites.length))

    // modify txn to boolean
    var modifiedTxn = ""
    if(paymentTxnSuccess == "pass"){
      modifiedTxn = "true"
    }else{ modifiedTxn = "false"}

    // set 5% chance at bad data
    val bdata = Random.nextInt(100)
    var modifiedData = new ListBuffer[String]
    modifiedData.append(paymentTxnId)
    modifiedData.append(customer.head)
    modifiedData.append(paymentType)
    modifiedData.append(qty.toString)
    modifiedData.append(product(1))
    if (bdata < 6 ){
      //if( bdata == 5 ){ modifiedData(0) = "11111.11" } // txnId
      //if( bdata == 4 ){ modifiedData(1) = "000.00" } // customer id Int
      if( bdata == 3 || bdata == 4){ modifiedData(2) = "@!#?@!" } // payment type
      if( bdata == 2 || bdata == 5 ){ modifiedData(3) = "0" } // qty
      if( bdata == 1 ){ modifiedData(4) = "@!#?@!" } // product name
    }

    // ---------- Build JSON Section -----------//
    thisSale ++= "{\"order_id\":" + orderId + ", "
    thisSale ++= "\"" + customerColumnHeader(0) + "\":" + modifiedData(1) + ", "
    thisSale ++= "\"" + customerColumnHeader(1) + "\":\"" + customer(1) + "\", "
    thisSale ++= "\"" + productColumnHeader(0) + "\":" + product(0) + ", "
    thisSale ++= "\"" + productColumnHeader(1) + "\":\"" + modifiedData(4) + "\", "
    thisSale ++= "\"" + productColumnHeader(2) + "\":\"" + product(2) + "\", "
    thisSale ++= "\"payment_type\":\"" + modifiedData(2) + "\", "
    thisSale ++= "\"qty\":" + modifiedData(3) + ", "
    thisSale ++= "\"price\":" + price + ", "
    thisSale ++= "\"time\":\"" + dateTime.toString + "\", "
    thisSale ++= "\"" + customerColumnHeader(2) + "\":\"" + customer(2) + "\", "
    thisSale ++= "\"" + customerColumnHeader(3) + "\":\"" + customer(3) + "\", "
    thisSale ++= "\"ecommerce_website_name\":\"" + website + "\", "
    thisSale ++= "\"payment_txn_id\":\"" + modifiedData(0) + "\", "
    thisSale ++= "\"payment_txn_success\":" + modifiedTxn + ", "
    thisSale ++= "\"failure_reason\":\"" + failureReason + "\"}"

    thisSale.toString

  }

  // purchase quantity selector
  def selectQty( rangeList: List[List[Int]] = List(List(50, 30), List(35, 65), List(15, 100))): Int = {

    // set a top temp range to account for someone adding more than 100% in the list
    var topTmpRng = 0
    for(x <- 0 until rangeList.length){ topTmpRng = topTmpRng + rangeList(x)(0) }
    topTmpRng = topTmpRng + 1

    val tmpRng = Random.between(1,topTmpRng)
    var lowQty = 0
    var highQty = 0
    var rngStep = 0

    //println("//----------BREAK--------------//")

    for (x <- 0 until rangeList.length) {

      // preset range to initial value
      if ( x == 0 ) { rngStep = rangeList(x)(0)}

      //println(x + " : " + tmpRng + " : " + rangeList(x)(0) + " : " + highQty + " : " + rngStep )
      if ( x == 0 && tmpRng <= rangeList(x)(0) ) {
        lowQty = 1
        highQty = rangeList(x)(1) + 1  // add one on high qty to make it include the top number
        //println(lowQty + " : " + highQty)
      }
      if ( x != 0 && tmpRng <= rngStep && highQty == 0 ) {
        lowQty = rangeList(x-1)(1) + 1  // inclusive add one to step 1 past previous top number
        highQty = rangeList(x)(1) + 1 // exclusive top range, add one to include final top number
        //println(lowQty + " : " + highQty)
      }

      // if not the end of the list add next rngStep to previous
      if ( x != rangeList.length -1 ){ rngStep = rngStep + rangeList(x+1)(0) }

    }

    //println(Random.between(lowQty,highQty))
    return Random.between(lowQty,highQty)

  }


  // worker to set dates if defined
  def dateWorker(presets:Map[String,String], varName:String ):LocalDate ={
    if ( varName == "startDate" ) {
      val startDateList = presets("startDate").split(",").toList
      val startDate = LocalDate.of(startDateList(0).toInt, startDateList(1).toInt, startDateList(2).toInt)
      startDate
    }else if ( varName == "endDate"){
      val endDateList = presets("endDate").split(",").toList
      val endDate = LocalDate.of(endDateList(0).toInt, endDateList(1).toInt, endDateList(2).toInt)
      endDate
    }else {
      val startDateList = presets("startDate").split(",").toList
      val startDate = LocalDate.of(startDateList(0).toInt, startDateList(1).toInt, startDateList(2).toInt)
      val currentDate = startDate
      currentDate
    }
  }


  //-------------   Trend Functions  ----------------//



  def customerTrend(trendValue:String, customerData:List[List[String]], percentChance:String = "" ):List[String] = {

    var customerListBuilder = new ListBuffer[List[String]]

    // if customer is the trend setter percent will be null, select customers with trendValue into list and randomly select the customer from that list
    if ( percentChance == "" ){
      for( x <- 0 until customerData.length ){
        if( customerData(x).contains(trendValue)){
          customerListBuilder.append(customerData(x))
        }
      }
    }else{
      // if percent exists run the percent generator
      customerListBuilder = percentGenerator(trendValue,customerData,percentChance)
    }

    val customerList = customerListBuilder.toList
    val customer = customerList(Random.nextInt(customerList.length))

    customer
  }

  def productTrend( trendValue:String, productData:List[List[String]], percentChance:String = "" ):List[String] = {

    var productListBuilder = new ListBuffer[List[String]]

    // if product is the trend setter percent will be null, select product with trendValue into list and randomly select the product from that list
    if ( percentChance == "" ){
      for( x <- 0 until productData.length ){
        // println(customerData(x))
        if( productData(x).contains(trendValue)){
          productListBuilder.append(productData(x))
        }
      }
    }else{
      productListBuilder = percentGenerator(trendValue,productData,percentChance)
    }

    //println(productListBuilder)

    val productList = productListBuilder.toList
    val product = productList(Random.nextInt(productList.length))

    product

  }

  def pmtTypeTrend( trendValue:String, paymentData:List[List[String]], percentChance:String = "" ):List[String] = {

    var paymentListBuilder = new ListBuffer[List[String]]
    // if customer is the trend setter percent will be null, select customers with trendValue into list and randomly select the customer from that list
    if ( percentChance == "" ){
      for( x <- 0 until paymentData.length ){
        if( paymentData(x).contains(trendValue)){
          paymentListBuilder.append(paymentData(x))
        }
      }
    }else{
      // if percent exists run the percent generator
      paymentListBuilder = percentGenerator(trendValue,paymentData,percentChance)
    }

    val paymentList = paymentListBuilder.toList
    val payment = paymentList(Random.nextInt(paymentList.length))

    payment

  }

  def pmtSuccessTrend( trendValue:String, successData:List[List[String]], percentChance:String = "" ):List[String] = {

    var successListBuilder = new ListBuffer[List[String]]
    // if customer is the trend setter percent will be null, select customers with trendValue into list and randomly select the customer from that list
    if ( percentChance == "" ){
      for( x <- 0 until successData.length ){
        if( successData(x).contains(trendValue)){
          successListBuilder.append(successData(x))
        }
      }
    }else{
      // if percent exists run the percent generator
      successListBuilder = percentGenerator(trendValue,successData,percentChance)
    }

    val successList = successListBuilder.toList
    val success = successList(Random.nextInt(successList.length))

    success

  }

  // ---- Trend Utilities
  def percentGenerator(trendValue:String,data:List[List[String]], percentChance:String): ListBuffer[List[String]] = {

    // If percent exists use the percent
    var selectedListItems = new ListBuffer[List[String]]
    var nonSelectedListItems = new ListBuffer[List[String]]
    // seperate out items that meet the effect and dont
    for( x <- 0 until data.length ) {
      if( data(x).contains(trendValue)){
        selectedListItems.append(data(x))
      }else{ nonSelectedListItems.append(data(x)) }
    }
    // if list is shorter than percent chance
    val rng = percentChance.toInt - selectedListItems.length
    if( selectedListItems.length < percentChance.toInt && selectedListItems.nonEmpty ){

      // if there is less list items that meet the criteria add repeat items until percent is met
      for( x <- 0 until rng ){
        val rndItem = selectedListItems(Random.nextInt(selectedListItems.length))
        selectedListItems.append(rndItem)
      }
      // else it is percent chance is equal or greater just take the number you need
    }else{
      var tmpSelectedBuffer = new ListBuffer[List[String]]
      for( x <- 0 until rng ){
        val rndItem = selectedListItems(Random.nextInt(selectedListItems.length))
        tmpSelectedBuffer.append(rndItem)
      }
      selectedListItems = tmpSelectedBuffer
      //selectedListItems = selectedListItems.take(percentChance.toInt)
    }
    // do the same for nonSelectedItems to make sure the size is proper
    //Set a difference to get just the number of items that will add up to 100 for percent purposes
    val percentDiff = 100 - percentChance.toInt
    if( nonSelectedListItems.length < percentDiff && nonSelectedListItems.nonEmpty ){

      for( x <- 0 until percentDiff ){
        val rndItem = nonSelectedListItems(Random.nextInt(nonSelectedListItems.length))
        nonSelectedListItems.append(rndItem)
      }

    }else{
      // If csv is organizes by a field then we need to make sure we are not grabbing just one data type, randomize diff items
      var tmpNonSelectedBuffer = new ListBuffer[List[String]]
      for( x <- 0 until percentDiff ){
        val rndItem = nonSelectedListItems(Random.nextInt(nonSelectedListItems.length))
        tmpNonSelectedBuffer.append(rndItem)
      }
      nonSelectedListItems = tmpNonSelectedBuffer
    }

    val combinedLists = selectedListItems ++ nonSelectedListItems
    //println(combinedLists.length)
    combinedLists

  }
// ---------- PRODUCER FUNCTION --------------//
  def producerFunc(stringToSend:String) {

    val kafkaIpPort = "localhost:9092"
    //val kafkaIpPort = "3.94.111.218:9092"
    val topic = "test_topic"

    println("producer Ran")
    val props:Properties = new Properties()
    props.put("bootstrap.servers", kafkaIpPort )
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("acks","all")
    val producer = new KafkaProducer[String, String](props)

    try {
      val record1 = new ProducerRecord[String, String](topic,stringToSend)
      val metadata1 = producer.send(record1)
    }catch{
      case e:Exception => e.printStackTrace()
    }finally {
      producer.close()
    }
  }

}




