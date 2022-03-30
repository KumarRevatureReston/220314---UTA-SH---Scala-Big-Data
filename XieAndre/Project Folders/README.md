USING JDBC WITH SCALA

ORIGINAL TABLE SOURCE: https://ourairports.com/data/

Table was made smaller with fewer columns to improve readability for this project. 


How to use program:
1. run sbt once in the project folder's directory.
2. type 'run' in the sbt console.
3. select input for the example (1-5).
4. after each selection, use the 'run' command in the sbt console to reinitialize the program. 
5. press any input other than the numbers 1 through 5 in order to exit the program and sbt server. 

-------------------------------------------------
QUERIES

1. CREATE TABLE airports_test (id INT, name TEXT, continent TEXT)

2. INSERT INTO airports_test (id, name, continent) VALUES ("+arg._1+", '"+arg._2+"', '"+arg._3+"');

3. SELECT * FROM airports_test;

4. DELETE FROM airports_test WHERE continent = 'NA';

5. SELECT * FROM airports_test;

6. DROP TABLE airports_test;

--------------------------------------------------
OUTPUTS

C:\Users\Andre Xie\Desktop\Week 3>cd project0

C:\Users\Andre Xie\Desktop\Week 3\project0>sbt
[info] welcome to sbt 1.6.2 (Oracle Corporation Java 11.0.13)
[info] loading settings for project project0-build-build from metals.sbt ...
[info] loading project definition from C:\Users\Andre Xie\Desktop\Week 3\project0\project\project
[info] loading settings for project project0-build from metals.sbt ...
[info] loading project definition from C:\Users\Andre Xie\Desktop\Week 3\project0\project
[success] Generated .bloop\project0-build.json
[success] Total time: 1 s, completed Mar 30, 2022, 4:25:47 PM
[info] loading settings for project root from build.sbt ...
[info] set current project to project0 (in build file:/C:/Users/Andre%20Xie/Desktop/Week%203/project0/)
[info] sbt server started at local:sbt-server-a56434009d06d817d7bf
[info] started sbt server
sbt:project0> run
[info] running Project0
Scala Postgre Examples
1. Create Table
2. Insert to Table
3. Delete from Table
4. Show Table
5. Drop Table
Input any other number to exit
1
Trying input...
   id   name    continent
[success] Total time: 11 s, completed Mar 30, 2022, 4:26:08 PM
sbt:project0> run
[info] running Project0
Scala Postgre Examples
1. Create Table
2. Insert to Table
3. Delete from Table
4. Show Table
5. Drop Table
Input any other number to exit
2
Trying input...
   id   name    continent
   1   Dummy_1   NA
   2   Dummy_2   NA
   3   Dummy_3   CN
   4   Dummy_4   JP
[success] Total time: 2 s, completed Mar 30, 2022, 4:26:19 PM
sbt:project0> run
[info] running Project0
Scala Postgre Examples
1. Create Table
2. Insert to Table
3. Delete from Table
4. Show Table
5. Drop Table
Input any other number to exit
3
Trying input...
   id   name    continent
   3   Dummy_3   CN
   4   Dummy_4   JP
[success] Total time: 5 s, completed Mar 30, 2022, 4:26:36 PM
sbt:project0> run
[info] running Project0
Scala Postgre Examples
1. Create Table
2. Insert to Table
3. Delete from Table
4. Show Table
5. Drop Table
Input any other number to exit
4
Trying input...
   id   name    continent
   3   Dummy_3   CN
   4   Dummy_4   JP
[success] Total time: 3 s, completed Mar 30, 2022, 4:26:44 PM
sbt:project0> run
[info] running Project0
Scala Postgre Examples
1. Create Table
2. Insert to Table
3. Delete from Table
4. Show Table
5. Drop Table
Input any other number to exit
5
Trying input...
Table has been deleted
[success] Total time: 3 s, completed Mar 30, 2022, 4:26:52 PM
sbt:project0>

