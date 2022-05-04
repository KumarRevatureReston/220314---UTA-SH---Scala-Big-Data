# Description  
This project is a demonstration of Apache Spark, Scala, JDBC and Hive
automatic database configuraton.  The scripts inside this project are intended to be used individually inside the spark-shell (spark-shell -i [script.scala]).

Custom Scala scripts can easily be written and loaded into Spark-shell.  Inside there is also an example of a .SQL file which is loaded into the dbsetup.scala file and used to create a 
database from a set of csv files automatically.

### Getting started  
1. Clone this repo to your Hive server or start the spark shell. `git clone https://github.com/Lonestar137/spark-scripts.git`  
2. Run the command: `./start.sh`. You will need to provide your Hive credentials and the IP+port for a JDBC connection you can do so by editing the load.scala script or writing your own. 
3. If you want to load a different script or write your own you can use this format in the CLI: `spark-shell -i <script>.scala`  
Example: `spark-shell -i load.scala`  

### Technologies  
- Apache Spark
- Spark SQL
- HDFS 
- Yarn
- JDBC
- SBT
- Scala
- Git + GitHub
- Linear (Project management tool)

### Collaborators  
* Andre Xie
* Mohammad Aydin
* Ed Osmulski
* Garrett Jones
* Max Landa

### License  
This project uses the following [License](<https://github.com/Lonestar137/spark-scripts/blob/main/LICENSE>).

 
