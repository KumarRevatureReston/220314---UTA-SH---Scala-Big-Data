-- Create table
-- 1. Write a SQL statement to create a table countries set a constraint NULL.
CREATE TABLE IF NOT EXISTS country(
	location_id NUMERIC(4,0) PRIMARY KEY UNIQUE NOT NULL,
    street_address VARCHAR(40) NOT NULL,
    postal_code VARCHAR(12) NULL,
    city VARCHAR(30) NOT NULL,
    state_province VARCHAR(25) NOT NULL,
    country_id VARCHAR(2) NOT NULL
);

-- 2. Write a SQL statement to create a simple table countries including 
-- columns country_id,country_name and region_id.
CREATE TABLE IF NOT EXISTS countries(
	location_id NUMERIC(4,0) PRIMARY KEY UNIQUE NOT NULL,
    street_address VARCHAR(40) NOT NULL,
    postal_code VARCHAR(12) NULL,
    city VARCHAR(30) NOT NULL,
    state_province VARCHAR(25) NOT NULL,
    country_id VARCHAR(2) NOT NULL,
    country_name VARCHAR(25),
    region_id TEXT NOT NULL
);

-- Alter table
-- 1. Write a SQL statement to add a column region_id to the table locations.
ALTER TABLE locations  ADD (region_id TEXT);

-- 2. Write a SQL statement to drop the column city from the table locations.
ALTER TABLE locations DROP city;

-- Update table
-- 1.  Write a SQL statement to change the email column of the employees 
-- table with 'not available' for all employees.
UPDATE employees SET email="not available";

-- 2. Write a SQL statement to increase the salary of employees under 
-- the department 40, 90 and 110 according to the company rules that, 
-- the salary will be increased by 25% of the department 40, 15% for 
-- department 90 and 10% of the department 110 and the rest of the 
-- department will remain same.
UPDATE employees SET salary = CASE department_id
								WHEN 40 THEN salary+salary*0.25
                                WHEN 90 THEN salary+salay*0.15
                                WHEN 110 THEN salary+salary*0.10
							  END
				WHERE department_id IN(40,90,110);



-- Insert Rows into table
-- 1. Write a SQL statement to insert a record with your own value into 
-- the table countries against each column.
INSERT INTO countries(country_id,country_name,region_id) VALUES("190","France",10);


-- 2.Write a SQL statement to insert one row into the table countries 
-- against the column country_id and country_name.
INSERT INTO countries(country_id,country_named) VALUES("290","Italy");
-- SELECT
-- 1. Write a query to display the names (first_name, last_name) using an 
-- alias name “First Name", "Last Name".
SELECT first_name AS "first name", last_name AS "last name" FROM employees;

-- 2. Write a query to get a unique department ID from employee table.
SELECT DISTINCT(employee_id) FROM employee
