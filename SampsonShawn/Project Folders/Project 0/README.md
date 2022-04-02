Project 01

Purpose: To demonstrate CRUD capabilities with Scala and Postgresql.

Test Data Sample From: https://ourairports.com/data/
-- Note, data was shortened for faster testing

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
