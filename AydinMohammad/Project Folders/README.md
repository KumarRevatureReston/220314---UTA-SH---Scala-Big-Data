my project is nothing but a CRUD operations on an airport database table using slick.
slick is a modern database query and access library for Scala. 
you will find my database in new_schema_myairport.sql file.
my data set is around 1400 records.
the data been provided by external source.
my table structure is like:

= `myairport` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ident` text,
  `_type` text,
  `name` text,
  `latitude_deg` double DEFAULT NULL,
  `longitude_deg` double DEFAULT NULL,
  `elevation_ft` int DEFAULT NULL,
  `continent` text,
  `scheduled_service` text,
  `gps_code` text,
  UNIQUE KEY `id_UNIQUE` (`id`)
)

my code has 7 queries.
1-insert 
2-select 
3-check if exist
4-sort by
5-count 
6-update 
7-delete

conclusion:
slick enabeled me to write my database queries in Scala instead of SQL, that helped me with static checking, less compile time, and more safety. I can use my Slick code in different backends.
