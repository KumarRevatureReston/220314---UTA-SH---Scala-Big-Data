RevProject 0

Purpose: To demonstrate CRUD capabilities with Scala and Postgresql using JDBC.

Test Data Sample From: https://ourairports.com/data/

------------------------------------------------------------

How to run:

if cloned from: https://github.com/KumarRevatureReston/220314---UTA-SH---Scala-Big-Data/tree/master/SampsonShawn/Project%20Folders/Project%200

1. Create new project in IDE
2. Copy contents of src directory into project src directory
3. Copy sbt into project directory
4. Update settings in src/main/scala/UserSettings.scala

    a. driver: should be the proper driver for your database for javascript/scala

    b. baseURL: should be the url to connect to your database

    c. username: should be the username for your database

    d. password: should be the password to your database

    e. path: should be the default path to the .csv file to import into your database
5. After Setup is complete, navigate to project folder that contains the .sbt file in Console
6. type: sbt and hit enter
7. After sbt runs you can type run "command to run" in the console

The available commands are in the format as follows:

Note: All SQL statements must be in double quotes so CLI considers it one string.

To copy a csv file into the database and have a default table setup for it three inputs are required, must be seperated with a space:

copy filename.csv nameOfTable

It is possible to force use JDBC connection types using key letters
1. "E" (execute)
2. "U" (update)
3. "Q" (query) - select statements

Example Command: run q "select * from airports"

It is also possible to just let the Scala program determine which type to use by just running an sql command.

It is setup to filter to the following:
1. DDL,DCL,TCL Commands filter to "E" and use .execute()
2. SELECT, DML + Keyword RETURNING in a statement filters to "Q" and uses .executeQuery()
3. DML - INSERT, UPDATE, DELETE without RETURNING keyword filters to "U" and uses .executeUpdate()

Exe: run "select * from airports"

------------------------------------------------------------
Data set usability

find the number and type of airports within approximately 100 miles of major metropolitan areas

Dallas, Tx   32.779167, -96.808891
select count(*) from airports where (type = 'small_airport') and (latitude_deg between 31 and 34) and (longitude_deg between -98 and -96 )

-- return --

421

Huston, TX    29.749907, -95.358421
select count(*) from airports where (type = 'small_airport') and (latitude_deg between 28 and 31) and (longitude_deg between -96 and -94 )

-- return --

126

The average number of small airports between these two major metropolitan areas is 273.5


With enough data sets you can determine on average how many airports of each type exist around metropolitan areas.
This can be further analysed to determine the average based on location, such as the possibility that Metropolitan
areas on the West coast may have more heliports than metropolitan areas on the East coast.  Further assumptions can
be made based on the existence of types of airports per region which may indicate that one region may be less accessible
by certain types of air travel.

-------------------------------------------------------------
MIT License

Copyright (c) 2022 Shawn Sampson

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
