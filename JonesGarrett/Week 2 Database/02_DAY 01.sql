# Data Manipulation Language (DML) & Data Definition Language (DDL):

# A. MySQL Create Table statement :

# 1. Write a SQL statement to create a simple table countries including columns country_id,country_name and region_id.
SELECT * FROM class.countries   -- NOTE: for me countries is under a class database.
; -- The countries table only has three rows country_id, country_name, and region_id.  So we can use * to grab all available fields.

# 2. Write a SQL statement to create a simple table countries including columns country_id,country_name and region_id which is already exists.
CREATE TABLE class.countries(COUNTRY_ID VARCHAR(2) PRIMARY KEY, COUNTRY_NAME VARCHAR(40), REGION_ID DECIMAL(10,0)) ; 
-- Fails because the country already exists.

# 3. Write a SQL statement to create the structure of a table dup_countries similar to countries.
CREATE TABLE dup_countries LIKE countries
;

# 4. Write a SQL statement to create a duplicate copy of countries table including structure and data by name dup_countries.
INSERT INTO dup_countries SELECT * FROM countries ORDER BY COUNTRY_ID ;


# 5. Write a SQL statement to create a table countries set a constraint NULL.
CREATE TABLE class.countries(COUNTRY_ID VARCHAR(2) PRIMARY KEY, COUNTRY_NAME VARCHAR(40), REGION_ID DECIMAL(10,0) NOT NULL, CHECK(REGION_ID > 0)) ; 
-- Creates a table that checks if REGION is NOT NULL and > 0. 
-- Also the PK field is a combination of UNIQUE and NOT NULL constraints by default.

# 6. Write a SQL statement to create a table named jobs including columns job_id, job_title, min_salary, max_salary and check whether the max_salary amount exceeding the upper limit 25000.
CREATE TABLE jobs(job_id INT, job_title VARCHAR(20), min_salary INT, max_salary INT, CHECK( max_salary < 25000 )) ;


# 7. Write a SQL statement to create a table named countries including columns country_id, country_name and region_id and make sure that no countries except Italy, India and China will be entered in the table.
 CREATE TABLE countriesTEST(country_id VARCHAR(2) PRIMARY KEY, country_name VARCHAR(40), region_id decimal(10,0), CHECK(country_name IN ('Italy', 'India', 'China'))) ;
 -- Unit test
 INSERT INTO countriesTEST SELECT * FROM countries ORDER BY COUNTRY_ID ; -- Fails to import data because country constraint is violated.
 INSERT INTO countriesTEST SELECT * FROM countries WHERE COUNTRY_NAME IN ('Italy', 'India', 'China') 
	AND COUNTRY_NAME NOT IN (SELECT COUNTRY_NAME FROM countriesTEST) ORDER BY COUNTRY_ID ;  -- Succeeds because constraints are met.
 SELECT * FROM countriesTEST;  -- Check result
 
# 8. Write a SQL statement to create a table named job_histry including columns employee_id, start_date, end_date, job_id and department_id and make sure that the value against column end_date will be entered at the time of insertion to the format like '--/--/----'.
CREATE TABLE IF NOT EXISTS job_history2( employee_id INT PRIMARY KEY, start_date DATE, end_date DATE, job_id INT, department_id INT );  -- OR, to match specifically --/--/----
CREATE TABLE IF NOT EXISTS job_history2( employee_id INT PRIMARY KEY, start_date VARCHAR(10), end_date VARCHAR(10), job_id VARCHAR(20), department_id INT, CHECK(start_date regexp '..\/..\/....' AND end_date regexp '..\/..\/....'));
-- Unit test
INSERT INTO job_history2 SELECT * FROM job_history; -- Fails because check is violated, will not take date format xxxx-xx-xx.
INSERT INTO job_history2(employee_id, start_date, end_date, job_id, department_id) VALUES (102, '01/13/1993', '12/13/2000', 'IT_PROG', 60); -- Succeeds, because regex CHECK is matched.
SELECT * FROM job_history2; -- Check result
DROP TABLE job_history2;

  
# 9. Write a SQL statement to create a table named countries including columns country_id,country_name and region_id and make sure that no duplicate data against column country_id will be allowed at the time of insertion.
 CREATE TABLE IF NOT EXISTS countries2( country_id VARCHAR(2) UNIQUE, country_name VARCHAR(30), region_id DECIMAL(10, 0));
 
 -- Unit tests
 INSERT INTO countries2(country_id, country_name, region_id) VALUES ('US', 'United States', '1111');  -- Fails if run twice
 SELECT * FROM countries;
 
# 10. Write a SQL statement to create a table named jobs including columns job_id, job_title, min_salary and max_salary, and make sure that, the default value for job_title is blank and min_salary is 8000 and max_salary is NULL will be entered automatically at the time of insertion if no value assigned for the specified columns.
CREATE TABLE IF NOT EXISTS jobs2(job_id VARCHAR(20) NOT NULL DEFAULT '', job_title VARCHAR(50), min_salary INT, max_salary INT);
-- Unit tests
INSERT INTO jobs2(job_title, min_salary, max_salary) VALUES ('Programmer', 100000, 150000);
SELECT * FROM jobs2;
 
# 11. Write a SQL statement to create a table named countries including columns country_id, country_name and region_id and make sure that the country_id column will be a key field which will not contain any duplicate data at the time of insertion.
 CREATE TABLE IF NOT EXISTS countries2(country_id INT PRIMARY KEY, country_name VARCHAR(50), region_id INT);
 
# 12. Write a SQL statement to create a table countries including columns country_id, country_name and region_id and make sure that the column country_id will be unique and store an auto incremented value.
CREATE TABLE IF NOT EXISTS countries2(country_id INT UNIQUE AUTO_INCREMENT, country_name VARCHAR(50), region_id INT);
-- Unit tests
INSERT INTO countries2 SELECT * FROM countries; -- fails because duplicate values
INSERT INTO countries2(country_name, region_id) SELECT country_name, region_id FROM countries;
SELECT * FROM countries2;
DROP TABLE countries2;


# 13. Write a SQL statement to create a table countries including columns country_id, country_name and region_id and make sure that the combination of columns country_id and region_id will be unique.
CREATE TABLE IF NOT EXISTS countries2(country_id VARCHAR(2), country_name VARCHAR(50), region_id INT, UNIQUE (country_id, region_id));
-- Unit tests
INSERT INTO countries2(country_id, country_name, region_id) SELECT country_id, country_name, region_id FROM countries; -- Filler data
INSERT INTO countries2(country_id, country_name, region_id) VALUES ('AR', 'TEST', '2'); -- Fails because AR and 2 combination already exist in the table.
INSERT INTO countries2(country_id, country_name, region_id) VALUES ('AR', 'TEST', '3'); -- Succeeds because AR and 3 combination doesn't exist.
SELECT * FROM countries2;



# 14. Write a SQL statement to create a table job_history including columns employee_id, start_date, end_date, job_id and department_id and make sure that, the employee_id column does not contain any duplicate value at the time of insertion and the foreign key column job_id contain only those values which are exists in the jobs table.
# Here is the structure of the table jobs;
# +------------+--------------+------+-----+---------+-------+
# | Field      | Type         | Null | Key | Default | Extra |
# +------------+--------------+------+-----+---------+-------+
# | JOB_ID     | varchar(10)  | NO   | PRI |         |       |
# | JOB_TITLE  | varchar(35)  | NO   |     | NULL    |       |
# | MIN_SALARY | decimal(6,0) | YES  |     | NULL    |       |
# | MAX_SALARY | decimal(6,0) | YES  |     | NULL    |       |
# +------------+--------------+------+-----+---------+-------+
CREATE TABLE IF NOT EXISTS job_history2(employee_id UNIQUE, start_date, end_date, job_id, department_id)

# 15. Write a SQL statement to create a table employees including columns employee_id, first_name, last_name, email, phone_number hire_date, job_id, salary, commission, manager_id and department_id and make sure that, the employee_id column does not contain any duplicate value at the time of insertion and the foreign key columns combined by department_id and manager_id columns contain only those unique combination values, which combinations are exists in the departments table.
 
# Assume the structure of departments table below.
 
# +-----------------+--------------+------+-----+---------+-------+
# | Field           | Type         | Null | Key | Default | Extra |
# +-----------------+--------------+------+-----+---------+-------+
# | DEPARTMENT_ID   | decimal(4,0) | NO   | PRI | 0       |       |
# | DEPARTMENT_NAME | varchar(30)  | NO   |     | NULL    |       |
# | MANAGER_ID      | decimal(6,0) | NO   | PRI | 0       |       |
# | LOCATION_ID     | decimal(4,0) | YES  |     | NULL    |       |
# +-----------------+--------------+------+-----+---------+-------+
 
 
# 16. Write a SQL statement to create a table employees including columns employee_id, first_name, last_name, email, phone_number hire_date, job_id, salary, commission, manager_id and department_id and make sure that, the employee_id column does not contain any duplicate value at the time of insertion, and the foreign key column department_id, reference by the column department_id of departments table, can contain only those values which are exists in the departments table and another foreign key column job_id, referenced by the column job_id of jobs table, can contain only those values which are exists in the jobs table. The InnoDB Engine have been used to create the tables.
 
# "A foreign key constraint is not required merely to join two tables. For storage engines other than InnoDB, it is possible when defining a column to use a REFERENCES tbl_name(col_name) clause, which has no actual effect, and serves only as a memo or comment to you that the column which you are currently defining is intended to refer to a column in another table." - Reference dev.mysql.com
 
# Assume that the structure of two tables departments and jobs.
 
# +-----------------+--------------+------+-----+---------+-------+
# | Field           | Type         | Null | Key | Default | Extra |
# +-----------------+--------------+------+-----+---------+-------+
# | DEPARTMENT_ID   | decimal(4,0) | NO   | PRI | 0       |       |
# | DEPARTMENT_NAME | varchar(30)  | NO   |     | NULL    |       |
# | MANAGER_ID      | decimal(6,0) | YES  |     | NULL    |       |
 
# | LOCATION_ID     | decimal(4,0) | YES  |     | NULL    |       |
# +-----------------+--------------+------+-----+---------+-------+
 
 
# +------------+--------------+------+-----+---------+-------+
# | Field      | Type         | Null | Key | Default | Extra |
# +------------+--------------+------+-----+---------+-------+
# | JOB_ID     | varchar(10)  | NO   | PRI |         |       |
# | JOB_TITLE  | varchar(35)  | NO   |     | NULL    |       |
# | MIN_SALARY | decimal(6,0) | YES  |     | NULL    |       |
# | MAX_SALARY | decimal(6,0) | YES  |     | NULL    |       |
# +------------+--------------+------+-----+---------+-------+
 
 
# 17. Write a SQL statement to create a table employees including columns employee_id, first_name, last_name, job_id, salary and make sure that, the employee_id column does not contain any duplicate value at the time of insertion, and the foreign key column job_id, referenced by the column job_id of jobs table, can contain only those values which are exists in the jobs table. The InnoDB Engine have been used to create the tables. The specialty of the statement is that, The ON UPDATE CASCADE action allows you to perform cross-table update and ON DELETE RESTRICT action reject the deletion. The default action is ON DELETE RESTRICT.
 
# Assume that the structure of the table jobs and InnoDB Engine have been used to create the table jobs.
 
# CREATE TABLE IF NOT EXISTS jobs ( 
# JOB_ID integer NOT NULL UNIQUE PRIMARY KEY, 
# JOB_TITLE varchar(35) NOT NULL DEFAULT ' ', 
# MIN_SALARY decimal(6,0) DEFAULT 8000, 
# MAX_SALARY decimal(6,0) DEFAULT NULL
# )ENGINE=InnoDB;
 
 
# +------------+--------------+------+-----+---------+-------+
# | Field      | Type         | Null | Key | Default | Extra |
# +------------+--------------+------+-----+---------+-------+
# | JOB_ID     | int(11)      | NO   | PRI | NULL    |       |
# | JOB_TITLE  | varchar(35)  | NO   |     |         |       |
# | MIN_SALARY | decimal(6,0) | YES  |     | 8000    |       |
# | MAX_SALARY | decimal(6,0) | YES  |     | NULL    |       |
# +------------+--------------+------+-----+---------+-------+
 
 
# 18. Write a SQL statement to create a table employees including columns employee_id, first_name, last_name, job_id, salary and make sure that, the employee_id column does not contain any duplicate value at the time of insertion, and the foreign key column job_id, referenced by the column job_id of jobs table, can contain only those values which are exists in the jobs table. The InnoDB Engine have been used to create the tables. The specialty of the statement is that, The ON DELETE CASCADE that lets you allow to delete records in the employees(child) table that refer to a record in the jobs(parent) table when the record in the parent table is deleted and the ON UPDATE RESTRICT actions reject any updates.
 
# Assume that the structure of the table jobs and InnoDB Engine have been used to create the table jobs.
 
# CREATE TABLE IF NOT EXISTS jobs ( 
# JOB_ID integer NOT NULL UNIQUE PRIMARY KEY, 
# JOB_TITLE varchar(35) NOT NULL DEFAULT ' ', 
# MIN_SALARY decimal(6,0) DEFAULT 8000, 
# MAX_SALARY decimal(6,0) DEFAULT NULL
# )ENGINE=InnoDB;
 
 
# +------------+--------------+------+-----+---------+-------+
# | Field      | Type         | Null | Key | Default | Extra |
# +------------+--------------+------+-----+---------+-------+
# | JOB_ID     | int(11)      | NO   | PRI | NULL    |       |
# | JOB_TITLE  | varchar(35)  | NO   |     |         |       |
# | MIN_SALARY | decimal(6,0) | YES  |     | 8000    |       |
# | MAX_SALARY | decimal(6,0) | YES  |     | NULL    |       |
# +------------+--------------+------+-----+---------+-------+
 
 
# 19. Write a SQL statement to create a table employees including columns employee_id, first_name, last_name, job_id, salary and make sure that, the employee_id column does not contain any duplicate value at the time of insertion, and the foreign key column job_id, referenced by the column job_id of jobs table, can contain only those values which are exists in the jobs table. The InnoDB Engine have been used to create the tables. The specialty of the statement is that, The ON DELETE SET NULL action will set the foreign key column values in the child table(employees) to NULL when the record in the parent table(jobs) is deleted, with a condition that the foreign key column in the child table must accept NULL values and the ON UPDATE SET NULL action resets the values in the rows in the child table(employees) to NULL values when the rows in the parent table(jobs) are updated.
 
# Assume that the structure of two table jobs and InnoDB Engine have been used to create the table jobs.
 
# CREATE TABLE IF NOT EXISTS jobs ( 
# JOB_ID integer NOT NULL UNIQUE PRIMARY KEY, 
# JOB_TITLE varchar(35) NOT NULL DEFAULT ' ', 
# MIN_SALARY decimal(6,0) DEFAULT 8000, 
# MAX_SALARY decimal(6,0) DEFAULT NULL
# )ENGINE=InnoDB;

 
# +------------+--------------+------+-----+---------+-------+
# | Field      | Type         | Null | Key | Default | Extra |
# +------------+--------------+------+-----+---------+-------+
# | JOB_ID     | int(11)      | NO   | PRI | NULL    |       |
# | JOB_TITLE  | varchar(35)  | NO   |     |         |       |
# | MIN_SALARY | decimal(6,0) | YES  |     | 8000    |       |
# | MAX_SALARY | decimal(6,0) | YES  |     | NULL    |       |
# +------------+--------------+------+-----+---------+-------+
 
 
# 20. Write a SQL statement to create a table employees including columns employee_id, first_name, last_name, job_id, salary and make sure that, the employee_id column does not contain any duplicate value at the time of insertion, and the foreign key column job_id, referenced by the column job_id of jobs table, can contain only those values which are exists in the jobs table. The InnoDB Engine have been used to create the tables. The specialty of the statement is that, The ON DELETE NO ACTION and the ON UPDATE NO ACTION actions will reject the deletion and any updates.

# Assume that the structure of two table jobs and InnoDB Engine have been used to create the table jobs.
 

# B. MySQL Insert Rows into the Table
 
# Write a SQL statement to insert a record with your own value into the table countries against each columns.

# Here in the following is the structure of the table countries.
 
# +--------------+---------------+------+-----+---------+-------+
# | Field        | Type          | Null | Key | Default | Extra |
# +--------------+---------------+------+-----+---------+-------+
# | COUNTRY_ID   | varchar(2)    | YES  |     | NULL    |       |
# | COUNTRY_NAME | varchar(40)   | YES  |     | NULL    |       |
# | REGION_ID    | decimal(10,0) | YES  |     | NULL    |       |
# +--------------+---------------+------+-----+---------+-------+	

 
# 2. Write a SQL statement to insert one row into the table countries against the column country_id and country_name.
 
# Here in the following is the structure of the table countries.
 
# +--------------+---------------+------+-----+---------+-------+
# | Field        | Type          | Null | Key | Default | Extra |
# +--------------+---------------+------+-----+---------+-------+
# | COUNTRY_ID   | varchar(2)    | YES  |     | NULL    |       |
# | COUNTRY_NAME | varchar(40)   | YES  |     | NULL    |       |
# | REGION_ID    | decimal(10,0) | YES  |     | NULL    |       |
# +--------------+---------------+------+-----+---------+-------+	
 
# 3. Write a SQL statement to create duplicate of countries table named country_new with all structure and data.
 
# Here in the following is the structure of the table countries.
 
# +--------------+---------------+------+-----+---------+-------+
# | Field        | Type          | Null | Key | Default | Extra |
# +--------------+---------------+------+-----+---------+-------+
# | COUNTRY_ID   | varchar(2)    | YES  |     | NULL    |       |
# | COUNTRY_NAME | varchar(40)   | YES  |     | NULL    |       |
# | REGION_ID    | decimal(10,0) | YES  |     | NULL    |       |
# +--------------+---------------+------+-----+---------+-------+	

 
# 4. Write a SQL statement to insert NULL values against region_id column for a row of countries table.
 

 
# 5. Write a SQL statement to insert 3 rows by a single insert statement.
 

# 6. Write a SQL statement insert rows from country_new table to countries table.
 
# Here is the rows for country_new table. Assume that, the countries table is empty.
 
# +------------+--------------+-----------+
# | COUNTRY_ID | COUNTRY_NAME | REGION_ID |
# +------------+--------------+-----------+
# | C0001      | India        |      1001 |
# | C0002      | USA          |      1007 |
# | C0003      | UK           |      1003 |
# +------------+--------------+-----------+
 
 
# 7. Write a SQL statement to insert one row in jobs table to ensure that no duplicate value will be entered in the job_id column.
 
# C.MySQL Update Table 
 
# 1. Write a SQL statement to change the email column of employees table with 'not available' for all employees.	
 
# 2. Write a SQL statement to change the email and commission_pct column of employees table with 'not available' and 0.10 for all employees.
 
# 3. Write a SQL statement to change the email column of employees table with 'not available' for those employees whose department_id is 80 and gets a commission is less than .20%

# 4.Write a SQL statement to increase the salary of employees under the department 40, 90 and 110 according to the company rules that, salary will be increased by 25% for the department 40, 15% for department 90 and 10% for the department 110 and the rest of the departments will remain same.
 
# D.MySQL basic SELECT statement (HR DB)
 
# 1.Write a query to display the names (first_name, last_name) using alias name “First Name", "Last Name"
# 2.Write a query to get unique department ID from employee table.
# 3.Write a query to get the names (first_name, last_name), salary, PF of all the employees (PF is calculated as 15% of salary)
 
# E. Aggregate Functions and Group by (HR DB)
# 1.Write a query to list the number of jobs available in the employees table.
# 2.Write a query to get the total salaries payable to employees.
# 3. Write a query to get the maximum salary of an employee working as a Programmer. 
 
# f. Northwind db
# Queries on Products table
 
# 1. Write a query to get Product name and quantity/unit. Go to the editor
 
 
# 2. Write a query to get current Product list (Product ID and name). Go to the editor
 
 
 
# 3. Write a query to get discontinued Product list (Product ID and name). Go to the editor
 
 
 
# 4. Write a query to get most expense and least expensive Product list (name and unit price). Go to the editor
 
 
 
# 5. Write a query to get Product list (id, name, unit price) where current products cost less than $20. Go to the editor
 
 
 
# 6. Write a query to get Product list (id, name, unit price) where products cost between $15 and $25. Go to the editor
 
 
 
# 7. Write a query to get Product list (name, unit price) of above average price. Go to the editor
 
 
# 8. Write a query to get Product list (name, unit price) of ten most expensive products. Go to the editor
 
 
# 9. Write a query to count current and discontinued products. Go to the editor
 
 
# 10. Write a query to get Product list (name, units on order , units in stock) of stock is less than the quantity on order.
