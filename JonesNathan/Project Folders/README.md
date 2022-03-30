Database location: C:/Users/natha/databases/airports4.csv               
//Will need to change path and password in Scala for others to utilize

Sample fields: id,ident,type,name,latitude_deg,longitude_deg,elevation_ft,continent,iso_country,iso_region,municipality,scheduled_service,gps_code,iata_code,local_code,home_link,wikipedia_link,keywords

Sample record: 6523,00A,heliport,Total Rf Heliport,40.07080078,-74.93360138,11,NA,US,US-PA,Bensalem,no,00A,,00A,,,

What queries to address: Will be set up to import/reset the original database if the user chooses, and will be arranged to allow for CRUD operations of Insert, Select, Update, and Delete.

How to execute: ProjectZero.scala will be imported into VS Code and will be run through the Terminal. After typing Run -> projectZero, the program will prompt the user to provide inputs. Program will use println to indicate what the program is looking for as far as inputs.

How to interpret results: Results will be displayed to the user when possible, println in code will give feedback and updates and database itself can be accessed in PostgreSQL.


Query lines for presentation.

CREATE\
id, ident, type, name - '7777', 'NJNJ', 'closed', 'Nathans Airfeld'

READ\
id, ident, type, name - WHERE id = '7777' //see that typo made

UPDATE\
name = 'Nathans Airfield' WHERE id = '7777' //fix typo

READ\
id, ident, type, name - WHERE id = '7777' //show that typo fixed .* - WHERE id = '6566' //introduce new data

UPDATE\
name = 'Big Data Heliport', type = 'heliport' WHERE id = '6566' //multiple field update

READ\
.* - WHERE id = '6566' //show they changed

DELETE\
iso_region = 'US-TX' //remove TX records

READ\
.* - WHERE id = '6566' //show that it is gone

CREATE\ id,ident,type,name,latitude_deg,longitude_deg,elevation_ft,continent,iso_country,iso_region,municipality,scheduled_service,gps_code,iata_code,local_code,home_link,wikipedia_link,keywords

'6562','00TA','closed','SW Region FAA Heliport','32.8269','-97.305801','598','NA','US','US-TX','Fort Worth','no','','','','','','00TA'

READ\
.* - WHERE id = '6562' //show full data set
