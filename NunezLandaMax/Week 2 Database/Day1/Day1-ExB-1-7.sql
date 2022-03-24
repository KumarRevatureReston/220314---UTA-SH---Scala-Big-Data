USE REVATURE;
-- 1 Write a SQL statement to insert a record with your own value into the table countries 
-- against each columns.
INSERT INTO countries VALUES(1,'Ukraine',5);

-- 2. Write a SQL statement to insert one row into the table countries against the column country_id 
-- and country_name.
INSERT INTO countries(country_id,country_name) VALUES(2,'Israel');


-- 3. Write a SQL statement to create duplicate of countries table named country_new with all 
-- structure and data.
CREATE TABLE countries_dup AS SELECT * FROM countries;

-- 4 Write a SQL statement to insert NULL values against region_id column for a row of countries table.
INSERT INTO countries values(3,"Puerto Rico", NULL);

-- 5. Write a SQL statement to insert 3 rows by a single insert statement.
INSERT INTO countries VALUES(4,"France",NULL),(5,"Italy",NULL),(6,"Colombia",NULL);

-- 6. Write a SQL statement insert rows from country_new table to countries table.
INSERT INTO countries SELECT * FROM country_new;

-- 7. Write a SQL statement to insert one row in jobs table to ensure that no duplicate value 
-- will be entered in the job_id column.
INSERT INTO jobs VALUES(1,"Manager",8000,20000);
INSERT INTO jobs VALUES(1,"Manager",8000,20000); -- Get an error primary key already exist;

