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
CREATE TABLE IF NOT EXISTS jobs( employee_id INT UNIQUE, start_date DATE, end_date DATE, JOB_ID VARCHAR(10) PRIMARY KEY, department_id INT); -- creates the PK table.
CREATE TABLE IF NOT EXISTS job_history2( employee_id INT UNIQUE, start_date DATE, end_date DATE, JOB_ID VARCHAR(10), department_id INT, 
FOREIGN KEY (JOB_ID) REFERENCES jobs(JOB_ID));  -- Creates the FK table.  FK -> PK


# 15. Write a SQL statement to create a table employees including columns employee_id, first_name, last_name, email, phone_number hire_date, job_id, salary, commission, 
-- manager_id and department_id and make sure that, the employee_id column does not contain any duplicate value at the time of 
-- insertion and the foreign key columns combined by department_id and manager_id columns contain only those unique combination values, which combinations are exists in the departments table.
 
# Assume the structure of departments table below.
 
# +-----------------+--------------+------+-----+---------+-------+
# | Field           | Type         | Null | Key | Default | Extra |
# +-----------------+--------------+------+-----+---------+-------+
# | DEPARTMENT_ID   | decimal(4,0) | NO   | PRI | 0       |       |
# | DEPARTMENT_NAME | varchar(30)  | NO   |     | NULL    |       |
# | MANAGER_ID      | decimal(6,0) | NO   | PRI | 0       |       |
# | LOCATION_ID     | decimal(4,0) | YES  |     | NULL    |       |
# +-----------------+--------------+------+-----+---------+-------+
 
 CREATE TABLE IF NOT EXISTS employees(employee_id Int Unique, first_name Varchar(30), last_name Varchar(30), email Varchar(30), phone_number Varchar(20),
 hire_date Varchar(10), job_id Int, salary Double, commission Double, manager_id DECIMAL(6,0), department_id DECIMAL(4,0), FOREIGN KEY (department_id, manager_id) REFERENCES departments2(DEPARTMENT_ID, MANAGER_ID))ENGINE=InnoDB;

-- *** com back to

# 16. Write a SQL statement to create a table employees including columns employee_id, first_name, last_name, email, phone_number hire_date, job_id, salary, 
-- commission, manager_id and department_id and make sure that, the employee_id column does not contain any duplicate value at the time of insertion, and the foreign key column department_id, 
-- reference by the column department_id of departments table, can contain only those values which are exists in the departments table and another foreign key column job_id, 
-- referenced by the column job_id of jobs table, can contain only those values which are exists in the jobs table. The InnoDB Engine have been used to create the tables.
 
# "A foreign key constraint is not required merely to join two tables. For storage engines other than InnoDB, it is possible when defining a column to use a REFERENCES tbl_name(col_name) clause, 
-- which has no actual effect, and serves only as a memo or comment to you that the column which you are currently defining is intended to refer to a column in another table." - Reference dev.mysql.com
 
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
 CREATE TABLE IF NOT EXISTS employees2(employee_id VARCHAR(10), first_name VARCHAR(20), 
 last_name VARCHAR(20), email VARCHAR(30), phone_number VARCHAR(10), hire_date VARCHAR(10), job_id VARCHAR(10), 
 salary decimal(20,2), commission decimal(20,2), manager_id INT, department_id INT,
 FOREIGN KEY(department_id) REFERENCES departments(DEPARTMENT_ID), FOREIGN KEY (job_id) REFERENCES jobs(JOB_ID)) ENGINE=InnoDB;
 
# 17. Write a SQL statement to create a table employees including columns employee_id, first_name, last_name, job_id, salary and make sure that,  the employee_id column does not contain any duplicate value at the time of insertion, and the foreign key column job_id, referenced by the column job_id of jobs table, can contain only those values which are exists in the jobs table. The InnoDB Engine have been used to create the tables. The specialty of the statement is that, The ON UPDATE CASCADE action allows you to  perform cross-table update and ON DELETE RESTRICT action reject the deletion. The default action is ON DELETE RESTRICT.
 
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
 CREATE TABLE IF NOT EXISTS employee(
 employee_id decimal(10,0), first_name varchar(20),
 last_name varchar(20), email varchar(25),
 phone_number varchar(20), hire_date date,
 job_id varchar(10) primary key, salary decimal(10,2),
 salary decimal(10,2), commission_pct decimal(6,2),
 manager_id decimal(5,0), department_id decimal(4,0),
 FOREIGN KEY (department_id) REFERENCES departments(DEPARTMENT_ID),
 FOREIGN KEY (job_id) REFERENCES jobs(JOB_ID)
 ) ENGINE = InnoDB;
 
# 18. Write a SQL statement to create a table employees including columns employee_id, first_name, last_name, job_id, salary and make sure that,
-- the employee_id column does not contain any duplicate value at the time of insertion, and the foreign key column job_id, referenced by the column job_id of jobs table,
-- can contain only those values which are exists in the jobs table. The InnoDB Engine have been used to create the tables. The specialty of the statement is that, The ON DELETE CASCADE 
-- that lets you allow to delete records in the employees(child) table that refer to a record in the jobs(parent) table when the record in the 
-- parent table is deleted and the ON UPDATE RESTRICT actions reject any updates.
 
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
 CREATE TABLE IF NOT EXISTS jobs ( 
 JOB_ID integer NOT NULL UNIQUE PRIMARY KEY, 
 JOB_TITLE varchar(35) NOT NULL DEFAULT ' ', 
 MIN_SALARY decimal(6,0) DEFAULT 8000, 
 MAX_SALARY decimal(6,0) DEFAULT NULL
 )ENGINE=InnoDB;
CREATE TABLE IF NOT EXISTS employees(
employee_id decimal(6,0) PRIMARY KEY,
first_name varchar(20), last_name varchar(25),
job_id Int, salary decimal(8,2),
foreign key(job_id) references jobs(JOB_ID)
ON DELETE CASCADE ON UPDATE RESTRICT
)ENGINE=InnoDB; 
 
# 19. Write a SQL statement to create a table employees including columns employee_id, first_name, last_name, job_id, salary and make sure that, 
-- the employee_id column does not contain any duplicate value at the time of insertion, and the foreign key column job_id, referenced by the column job_id of jobs table,
-- can contain only those values which are exists in the jobs table. The InnoDB Engine have been used to create the tables. The specialty of the statement is that, 
-- The ON DELETE SET NULL action will set the foreign key column values in the child table(employees) to NULL when the record in the parent table(jobs) is deleted, with a condition that the 
-- foreign key column in the child table must accept NULL values and the ON UPDATE SET NULL action resets the values in the rows in the child table(employees) to NULL values when the rows in the parent table(jobs) are updated.
 
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
CREATE TABLE IF NOT EXISTS employees(
employee_id decimal(6,0) PRIMARY KEY,
first_name varchar(20) default null , last_name varchar(25),
job_id Int, salary decimal(8,2) default null,
foreign key(job_id) references jobs(JOB_ID)
ON DELETE SET NULL ON UPDATE SET NULL
)ENGINE=InnoDB; 

# 20. Write a SQL statement to create a table employees including columns employee_id, first_name, last_name, job_id, salary and make sure that, 
-- the employee_id column does not contain any duplicate value at the time of insertion, and the foreign key column job_id, referenced by the column job_id of jobs table, 
-- can contain only those values which are exists in the jobs table. The InnoDB Engine have been used to create the tables. The specialty of the statement is that, 
-- The ON DELETE NO ACTION and the ON UPDATE NO ACTION actions will reject the deletion and any updates.

# Assume that the structure of two table jobs and InnoDB Engine have been used to create the table jobs.
 
 CREATE TABLE IF NOT EXISTS employees(
 eemployee_id decimal(6,0) PRIMARY KEY,
 first_name varchar(20), last_name varchar(25),
 job_id Int, salary decimal(8,2) ,
 foreign key(job_id) references jobs(JOB_ID)
 ON DELETE NO ACTION ON UPDATE NO ACTION
 );

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
INSERT INTO countries VALUES ('AL', 'Alabama', 137);
SELECT * FROM countries;
# 2. Write a SQL statement to insert one row into the table countries against the column country_id and country_name.
 
# Here in the following is the structure of the table countries.
 
# +--------------+---------------+------+-----+---------+-------+
# | Field        | Type          | Null | Key | Default | Extra |
# +--------------+---------------+------+-----+---------+-------+
# | COUNTRY_ID   | varchar(2)    | YES  |     | NULL    |       |
# | COUNTRY_NAME | varchar(40)   | YES  |     | NULL    |       |
# | REGION_ID    | decimal(10,0) | YES  |     | NULL    |       |
# +--------------+---------------+------+-----+---------+-------+	
INSERT INTO countries(COUNTRY_ID, COUNTRY_NAME) VALUES ('TX', 'Texas');
 
# 3. Write a SQL statement to create duplicate of countries table named country_new with all structure and data.
 
# Here in the following is the structure of the table countries.
 
# +--------------+---------------+------+-----+---------+-------+
# | Field        | Type          | Null | Key | Default | Extra |
# +--------------+---------------+------+-----+---------+-------+
# | COUNTRY_ID   | varchar(2)    | YES  |     | NULL    |       |
# | COUNTRY_NAME | varchar(40)   | YES  |     | NULL    |       |
# | REGION_ID    | decimal(10,0) | YES  |     | NULL    |       |
# +--------------+---------------+------+-----+---------+-------+	
CREATE TABLE country_new AS SELECT * FROM countries; -- move all the data and struct from one table to another.
 
# 4. Write a SQL statement to insert NULL values against region_id column for a row of countries table.
 INSERT INTO countries (country_id,country_name,region_id) VALUES('US','United States',NULL);

# 5. Write a SQL statement to insert 3 rows by a single insert statement.
 INSERT INTO countries VALUES ('US', 'United states', 10) , ('c2', 'country 2', 11), ('c3', 'country 3', 12);

# 6. Write a SQL statement insert rows from country_new table to countries table.
 
# Here is the rows for country_new table. Assume that, the countries table is empty.
 
# +------------+--------------+-----------+
# | COUNTRY_ID | COUNTRY_NAME | REGION_ID |
# +------------+--------------+-----------+
# | C0001      | India        |      1001 |
# | C0002      | USA          |      1007 |
# | C0003      | UK           |      1003 |
# +------------+--------------+-----------+
 INSERT INTO countries SELECT * FROM country_new;
 
# 7. Write a SQL statement to insert one row in jobs table to ensure that no duplicate value will be entered in the job_id column.
 CREATE TABLE IF NOT EXISTS jobs ( 
JOB_ID integer NOT NULL UNIQUE , 
JOB_TITLE varchar(20) NOT NULL, 
MIN_SALARY decimal(10,0)
);  # create table with UNIQUE identifier on the column.
# C.MySQL Update Table 
INSERT INTO jobs VALUES(1,'SE',80000);
 
# 1. Write a SQL statement to change the email column of employees table with 'not available' for all employees.	
UPDATE employees SET email='not available';

# 2. Write a SQL statement to change the email and commission_pct column of employees table with 'not available' and 0.10 for all employees.
 UPDATE employees SET email='not available', commission_pct=0.10;
# 3. Write a SQL statement to change the email column of employees table with 'not available' for those employees whose department_id is 80 and gets a commission is less than .20%
UPDATE employees SET email='not available' WHERE department_id=80 AND commission_pct<0.20;

# 4.Write a SQL statement to increase the salary of employees under the department 40, 90 and 110 according to the company rules that, salary will be increased by 25% for the department 40, 15% for department 90 and 10% for the department 110 and the rest of the departments will remain same.
 SELECT * FROM employees WHERE department_id IN (40, 90, 110) ORDER BY salary;
 UPDATE employees SET salary=CASE department_id 
 WHEN 40 THEN salary+(salary*0.25)
 WHEN 90 THEN salary+(salary*0.15)
 WHEN 110 THEN salary+(salary*0.10)
 END
 WHERE department_id IN (40,90,110) ORDER BY salary;
 
# 1.Write a query to display the names (first_name, last_name) using alias name “First Name", "Last Name"
SELECT first_name "First Name", last_name "Last Name" FROM employees;

# 2.Write a query to get unique department ID from employee table.
SELECT DISTINCT(department_id) FROM employee;

# 3.Write a query to get the names (first_name, last_name), salary, PF of all the employees (PF is calculated as 15% of salary)
 SELECT first_name, last_name, salary, salary*0.15 "PF" FROM employees;
# 1.Write a query to list the number of jobs available in the employees table.
 SELECT * FROM employees ORDER BY salary;
 SELECT count(DISTINCT(JOB_ID)) "Number of jobs" FROM employees;
# 2.Write a query to get the total salaries payable to employees.
SELECT count(salary)"Number of salaries", SUM(salary) "Total" FROM employees;
# 3. Write a query to get the maximum salary of an employee working as a Programmer. 
SELECT MAX(salary) FROM employees WHERE job_id = "PROGRAMMER";
# 1. Write a query to get Product name and quantity/unit. Go to the editor
USE sql_store;
SELECT name, quantity_in_stock FROM products;

 
# 2. Write a query to get current Product list (Product ID and name). Go to the editor
 SELECT product_id,name FROM products;

 
 
# 3. Write a query to get discontinued Product list (Product ID and name). Go to the editor
ALTER TABLE products ADD discontinued bool DEFAULT false; -- create discontinued column
UPDATE products SET discontinued = TRUE WHERE product_id = 9; -- Discontinue an item
SELECT product_id, name, discontinued FROM products WHERE discontinued = 1; -- get discontinued.

 
 
# 4. Write a query to get most expense and least expensive Product list (name and unit price). Go to the editor
 SELECT * FROM products;
 SELECT min(unit_price) "Min price", max(unit_price) "Max Price" FROM products;
 
 
# 5. Write a query to get Product list (id, name, unit price) where current products cost less than $20. Go to the editor
 SELECT product_id, name, unit_price FROM products WHERE unit_price<20;

 
 
# 6. Write a query to get Product list (id, name, unit price) where products cost between $15 and $25. Go to the editor
 SELECT product_id, name, unit_price FROM products WHERE unit_price BETWEEN 15 and 25;
 
# 7. Write a query to get Product list (name, unit price) of above average price. Go to the editor
 SELECT name, unit_price FROM products WHERE unit_price>(SELECT AVG(unit_price) from products);

 
# 8. Write a query to get Product list (name, unit price) of ten most expensive products. Go to the editor
 SELECT name, unit_price FROM products ORDER BY unit_price DESC LIMIT 10;
 
# 9. Write a query to count current and discontinued products. Go to the editor
 SELECT COUNT(product_id) FROM products WHERE discontinued = true;
 
# 10. Write a query to get Product list (name, units on order , units in stock) of stock is less than the quantity on order.
SELECT name, unitsonorder, unitsinstock FROM products WHERE (units_in_stock < units_on_order);