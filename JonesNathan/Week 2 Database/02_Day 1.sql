# Data Manipulation Language (DML) & Data Definition Language (DDL):

# A. MySQL Create Table statement : #DROP TABLE countries;

# 1. Write a SQL statement to create a simple table countries including columns country_id,country_name and region_id.

CREATE TABLE countries(
country_id varchar(10),
country_name varchar(100),
region_id int(10),
PRIMARY KEY (country_id)
);		#hard to know how many characters needed for these, so tended towards higher values on all. DESC good for reviewing tables

# 2. Write a SQL statement to create a simple table countries including columns country_id,country_name and region_id which is already exists.
CREATE TABLE countries(
country_id VARCHAR(10),
country_name VARCHAR(100),
region_id INT(10),
PRIMARY KEY (country_id)
);
		#Error Code 1050. Table 'questionone'already exists, unless dropped first

# 3. Write a SQL statement to create the structure of a table dup_countries similar to countries.
CREATE TABLE dup_countries
LIKE countries;

# 4. Write a SQL statement to create a duplicate copy of countries table including structure and data by name dup_countries.
CREATE TABLE IF NOT EXISTS dup_countries
AS SELECT *
FROM countries;

# 5. Write a SQL statement to create a table countries set a constraint (NOT) NULL.  <---defining a permanently null function is not as helpful as creating one that Cannot be NULL
DROP TABLE countries;
CREATE TABLE countries ( 												#<---proceeding with assumption that the world NOT was left out of question 
country_id VARCHAR(10) NOT NULL,
country_name VARCHAR(100) NOT NULL,
region_id INT(10) NOT NULL,
PRIMARY KEY (country_id)
); #interestingly this still shows Null values when examined. Perhaps just means default empty storage until used

# 6. Write a SQL statement to create a table named jobs including columns job_id, job_title, min_salary, max_salary and check whether the max_salary amount exceeding the upper limit 25000.
CREATE TABLE jobs (
job_id VARCHAR(100),
job_title VARCHAR(100),
min_salary DOUBLE(7,2),			#to handle salaries of more than 1 million and change
max_salary DOUBLE(7,2)
CHECK(max_salary >= 25000) 		#should be true if exceed max of 25000
);

# 7. Write a SQL statement to create a table named countries including columns country_id, country_name and region_id and make sure that no countries except Italy, India and China will be entered in the table.
DROP TABLE countries; 
CREATE TABLE countries(
country_id VARCHAR(10),
country_name VARCHAR(100), CHECK(country_name IN('Italy|India|China')),  #check that country name is Italy OR India OR china
region_id VARCHAR(10)
 );
 
# 8. Write a SQL statement to create a table named job_history including columns employee_id, start_date, end_date, job_id and department_id and make sure that the value against column end_date will be entered at the time of insertion to the format like '--/--/----'.
 CREATE TABLE job_history(
 employee_id DOUBLE(10,0),
 start_date date CHECK (start_date LIKE '--/--/----'),
 end_date date CHECK (end_date LIKE '--/--/----'),
 job_id VARCHAR(15),
 department_id VARCHAR(15)
 );
 
# 9. Write a SQL statement to create a table named countries including columns country_id,country_name and region_id and make sure that no duplicate data against column country_id will be allowed at the time of insertion.
DROP TABLE countries;
CREATE TABLE countries(
country_id VARCHAR(10),  UNIQUE(country_id) ,  #primary key might work here since unique is built in
country_name VARCHAR(50),
region_id VARCHAR(10)
);

# 10. Write a SQL statement to create a table named jobs including columns job_id, job_title, min_salary and max_salary, and make sure that, the default value for job_title is blank and min_salary is 8000 and max_salary is NULL will be entered automatically at the time of insertion if no value assigned for the specified columns.
DROP Table jobs;
CREATE TABLE jobs(
job_id VARCHAR(10),
job_title VARCHAR(30) DEFAULT ' ',
min_salary DOUBLE(9,2), CHECK (min_salary >= 8000),
max_salary DOUBLE(9,2) DEFAULT NULL
);
 
# 11. Write a SQL statement to create a table named countries including columns country_id, country_name and region_id and make sure that the country_id column will be a key field which will not contain any duplicate data at the time of insertion.
 DROP TABLE countries;
 CREATE TABLE countries(
 country_id VARCHAR(10),
 country_name VARCHAR(50),
 region_id VARCHAR(10),
 PRIMARY KEY (country_id)
 );
 
# 12. Write a SQL statement to create a table countries including columns country_id, country_name and region_id and make sure that the column country_id will be unique and store an auto incremented value.
 DROP TABLE countries;
 CREATE TABLE countries(
 country_id INT UNIQUE AUTO_INCREMENT,
 country_name VARCHAR(50),
 region_id VARCHAR(10)
 );

# 13. Write a SQL statement to create a table countries including columns country_id, country_name and region_id and make sure that the combination of columns country_id and region_id will be unique.
 DROP TABLE countries;
 CREATE TABLE countries(
 country_id VARCHAR(10) UNIQUE,
 country_name VARCHAR(50),
 region_id VARCHAR(10) UNIQUE
 );
 
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
 DROP TABLE job_history;
 CREATE TABLE job_history(
 job_id VARCHAR(10) NOT NULL PRIMARY KEY DEFAULT ' ',
 job_title VARCHAR(35) NOT NULL,
 min_salary DECIMAL(6,0),
 max_salary DECIMAL(6,0)
 );
 DESC job_history;
 
# 15. Write a SQL statement to create a table employees including columns employee_id, first_name, last_name, email, phone_number hire_date, job_id, salary, 
# commission, manager_id and department_id and make sure that, the employee_id column does not contain any duplicate value 
# at the time of insertion and the foreign key columns combined by department_id and manager_id columns contain only those unique combination values, which combinations are exists in the departments table.
# Assume the structure of departments table below.
 
# +-----------------+--------------+------+-----+---------+-------+
# | Field           | Type         | Null | Key | Default | Extra |
# +-----------------+--------------+------+-----+---------+-------+
# | DEPARTMENT_ID   | decimal(4,0) | NO   | PRI | 0       |       |
# | DEPARTMENT_NAME | varchar(30)  | NO   |     | NULL    |       |
# | MANAGER_ID      | decimal(6,0) | NO   | PRI | 0       |       |
# | LOCATION_ID     | decimal(4,0) | YES  |     | NULL    |       |
# +-----------------+--------------+------+-----+---------+-------+
 
 DROP TABLE employees;
 CREATE TABLE employees(
 employee_id VARCHAR (10) UNIQUE,
 first_name VARCHAR(15),
 last_name VARCHAR(15),
 email VARCHAR(30),
 phone_number DOUBLE(11,0),   #assuming include country code
 hire_date date,
 job_id VARCHAR(10),
 salary DOUBLE(9,2),
 commission DOUBLE(9,2),
 manager_id DECIMAL(6,0),
 department_id DECIMAL(4,0),
 FOREIGN KEY(department_id, manager_id) REFERENCES departments(department_id, manager_id)   #cannot actually run this since no departments to reference
 );
 
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
 
 DROP TABLE employees;			#question format has some readability issues..
 CREATE TABLE employees(
 employee_id VARCHAR (10) UNIQUE,
 first_name VARCHAR(15),
 last_name VARCHAR(15),
 email VARCHAR(30),
 phone_number DOUBLE(11,0),   #assuming include country code
 hire_date date,
 job_id VARCHAR(10),
 salary DOUBLE(9,2),
 commission DOUBLE(9,2),
 manager_id DECIMAL(6,0),
 department_id DECIMAL(4,0),
 FOREIGN KEY(department_id) REFERENCES departments(department_id),    #cannot actually run this since no departments or jobs to reference
 FOREIGN KEY(job_id) REFERENCES jobs(job_id)							#question might be asking me to verify something with EXISTS but its hard to tell
 );
 
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
 
 DROP TABLE employees;
 CREATE TABLE employees(
 employee_id VARCHAR(10) UNIQUE,
 first_name VARCHAR(15),
 last_name VARCHAR(15),
 job_id INT(11),
 salary DECIMAL(6,0),
 FOREIGN KEY (job_id) REFERENCES jobs(job_id) 
 ON UPDATE CASCADE
 ON DELETE RESTRICT
 );
 
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
 
 DROP TABLE employees;
 CREATE TABLE employees(
 employee_id VARCHAR(10) UNIQUE,
 first_name VARCHAR(15),
 last_name VARCHAR(15),
 job_id INT(11),
 salary DECIMAL(6,0),
 FOREIGN KEY (job_id) REFERENCES jobs(job_id) 
 ON DELETE CASCADE 
 ON UPDATE RESTRICT
 );												
 
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
 DROP TABLE employees;
 CREATE TABLE employees(
 employee_id VARCHAR(10) UNIQUE,
 first_name VARCHAR(15),
 last_name VARCHAR(15),
 job_id INT(11),
 salary DECIMAL(6,0),
 FOREIGN KEY (job_id) REFERENCES jobs(job_id) 
 ON DELETE SET NULL 
 ON UPDATE SET NULL
 );	
 
# 20. Write a SQL statement to create a table employees including columns employee_id, first_name, last_name, job_id, salary and make sure that, the employee_id column does not contain any duplicate value at the time of insertion, and the foreign key column job_id, referenced by the column job_id of jobs table, can contain only those values which are exists in the jobs table. The InnoDB Engine have been used to create the tables. The specialty of the statement is that, The ON DELETE NO ACTION and the ON UPDATE NO ACTION actions will reject the deletion and any updates.

# Assume that the structure of two table jobs and InnoDB Engine have been used to create the table jobs.
  
 DROP TABLE employees;
 CREATE TABLE employees(
 employee_id VARCHAR(10) UNIQUE,
 first_name VARCHAR(15),
 last_name VARCHAR(15),
 job_id INT(11),
 salary DECIMAL(6,0),
 FOREIGN KEY (job_id) REFERENCES jobs(job_id) 
 ON DELETE NO ACTION 
 ON UPDATE NO ACTION
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
 
 USE world;							#needed to repath since took a break here
 DROP TABLE countries;
 CREATE TABLE countries(
 country_id VARCHAR(2) UNIQUE, 
 country_name VARCHAR(40), 
 region_id DECIMAL(10,0) 
 );
 INSERT INTO countries (country_id, country_name, region_id) VALUES ('US', 'United_States', 12345);
 
# 2. Write a SQL statement to insert one row into the table countries against the column country_id and country_name.
# Here in the following is the structure of the table countries.
# +--------------+---------------+------+-----+---------+-------+
# | Field        | Type          | Null | Key | Default | Extra |
# +--------------+---------------+------+-----+---------+-------+
# | COUNTRY_ID   | varchar(2)    | YES  |     | NULL    |       |
# | COUNTRY_NAME | varchar(40)   | YES  |     | NULL    |       |
# | REGION_ID    | decimal(10,0) | YES  |     | NULL    |       |
# +--------------+---------------+------+-----+---------+-------+	
 DROP TABLE countries;
 CREATE TABLE countries(
 country_id VARCHAR(2) UNIQUE, 
 country_name VARCHAR(40), 
 region_id DECIMAL(10,0) 
 );
 INSERT INTO countries (country_id, country_name) VALUES ('US', 'United_States');
 
# 3. Write a SQL statement to create duplicate of countries table named country_new with all structure and data.
# Here in the following is the structure of the table countries.
# +--------------+---------------+------+-----+---------+-------+
# | Field        | Type          | Null | Key | Default | Extra |
# +--------------+---------------+------+-----+---------+-------+
# | COUNTRY_ID   | varchar(2)    | YES  |     | NULL    |       |
# | COUNTRY_NAME | varchar(40)   | YES  |     | NULL    |       |
# | REGION_ID    | decimal(10,0) | YES  |     | NULL    |       |
# +--------------+---------------+------+-----+---------+-------+	
CREATE TABLE country_new LIKE countries;	#do not drop previous countries for this one
DESC country_new;					#easiest way to confirm that i can think of
 
# 4. Write a SQL statement to insert NULL values against region_id column for a row of countries table.
 DROP TABLE countries;
 CREATE TABLE countries(
 country_id VARCHAR(2) UNIQUE, 
 country_name VARCHAR(40), 
 region_id DECIMAL(10,0)
 );
INSERT INTO countries (country_id, country_name, region_id) VALUES ('US', 'United_States', NULL); #grabbing from previous since seems to be intent of question. Defaults to Null anyway

# 5. Write a SQL statement to insert 3 rows by a single insert statement.
 DROP TABLE multiRow;
 CREATE TABLE multiRow(
 rowA VARCHAR(7), rowB VARCHAR(7), rowC VARCHAR(7)
 );
INSERT INTO multirow (rowA, rowB, rowC) VALUES ('oneA', 'oneB', 'oneC'), ('twoA', 'twoB', 'twoC'), ('threeA', 'threeB', 'threeC');

# 6. Write a SQL statement insert rows from country_new table to countries table.
# Here is the rows for country_new table. Assume that, the countries table is empty.
# +------------+--------------+-----------+
# | COUNTRY_ID | COUNTRY_NAME | REGION_ID |
# +------------+--------------+-----------+
# | C0001      | India        |      1001 |
# | C0002      | USA          |      1007 |
# | C0003      | UK           |      1003 |
# +------------+--------------+-----------+
 DROP TABLE country_new; DROP TABLE countries;
 CREATE TABLE country_new(
 country_id VARCHAR(5),
 country_name VARCHAR(30),
 region_id DOUBLE(5,0)
 );
 CREATE TABLE countries(
 country_id VARCHAR(5),
 country_name VARCHAR(30),
 region_id DOUBLE(5,0)
 );
INSERT INTO country_new (country_id, country_name, region_id) VALUES ('C0001', 'India', '1001'), ('C0002', 'USA', '1007'), ('C0003', 'UK', '1003');
INSERT INTO countries SELECT * FROM country_new;  
 
# 7. Write a SQL statement to insert one row in jobs table to ensure that no duplicate value will be entered in the job_id column.
DROP Table jobs;
CREATE TABLE jobs(			#reusing a table
job_id VARCHAR(10),
job_title VARCHAR(30) DEFAULT ' ',
min_salary DOUBLE(9,2), CHECK (min_salary >= 8000),
max_salary DOUBLE(9,2) DEFAULT NULL
);
INSERT INTO jobs (job_id) VALUE (0);  #a few ideas but none of them work properly yet to handle uniqueness
 #************************************
 
# C.MySQL Update Table 
# 1. Write a SQL statement to change the email column of employees table with 'not available' for all employees.	
 UPDATE employees
 SET email = 'not available';
 
# 2. Write a SQL statement to change the email and commission_pct column of employees table with 'not available' and 0.10 for all employees.
 UPDATE employees
 SET email = 'not available'; SET commission_pct = 0.10; 
 
# 3. Write a SQL statement to change the email column of employees table with 'not available' for those employees whose department_id is 80 and gets a commission is less than .20%
 UPDATE employees
 SET email = 'not available' 
 WHERE department_id = 80 AND commission_pct <= 0.20;
 
# 4.Write a SQL statement to increase the salary of employees under the department 40, 90 and 110 according to the company rules that, 
#salary will be increased by 25% for the department 40, 15% for department 90 and 10% for the department 110 and the rest of the departments will remain same.
 UPDATE employees
 SET salary=salary*1.25 WHERE department_id =40; 
 UPDATE employees
 SET salary=salary*1.15 WHERE department_id =90;
 UPDATE employees
 SET salary=salary*1.10 WHERE department_id =110;  #would love to have done this without individual updates
 
# D.MySQL basic SELECT statement (HR DB)
 
# 1.Write a query to display the names (first_name, last_name) using alias name “First Name", "Last Name"
USE sql_hr;
SELECT first_name AS "First Name", last_name AS "Last Name" FROM employees;

# 2.Write a query to get unique department ID from employee table.
SELECT DISTINCT office_id FROM employees;

# 3.Write a query to get the names (first_name, last_name), salary, PF of all the employees (PF is calculated as 15% of salary)
 SELECT first_name, last_name, salary, salary*.15 AS PF FROM employees;
 
# E. Aggregate Functions and Group by (HR DB)
# 1.Write a query to list the number of jobs available in the employees table.
SELECT COUNT(job_title) FROM employees;

# 2.Write a query to get the total salaries payable to employees.
SELECT SUM(salary) FROM employees;

# 3. Write a query to get the maximum salary of an employee working as a Programmer. 
 SELECT MAX(salary) FROM employees;  #none of them are explicitly programmers, or named in a convention that would allow a reasonable search

# f. Northwind db
# Queries on Products table
 
# 1. Write a query to get Product name and quantity/unit. Go to the editor
 USE sakila;			#download issues forced me to install it here
 Select ProductName, quantityperunit
 FROM products;			
 
# 2. Write a query to get current Product list (Product ID and name). Go to the editor
 SELECT ProductId, ProductName
 From products WHERE discontinued=0;
 
# 3. Write a query to get discontinued Product list (Product ID and name). Go to the editor
 SELECT ProductId, ProductName
 From products WHERE discontinued=1;   #well that worked out
 
# 4. Write a query to get most expensive and least expensive Product list (name and unit price). Go to the editor
 SELECT ProductId, ProductName
 FROM products WHERE unitprice = (SELECT MAX(unitprice) FROM products) OR unitprice = (SELECT MIN(unitprice) FROM products);

# 5. Write a query to get Product list (id, name, unit price) where current products cost less than $20. Go to the editor
 SELECT ProductId, ProductName, unitprice
 FROM products WHERE unitprice <= 20;
 
# 6. Write a query to get Product list (id, name, unit price) where products cost between $15 and $25. Go to the editor
SELECT ProductId, ProductName, unitprice
 FROM products WHERE unitprice < 25 AND unitprice > 15 ;  #not inclusive since "between"
 
# 7. Write a query to get Product list (name, unit price) of above average price. Go to the editor
 SELECT ProductName, unitprice
 FROM products WHERE unitprice > (SELECT AVG(unitprice) FROM products);
 
# 8. Write a query to get Product list (name, unit price) of ten most expensive products. Go to the editor
 SELECT ProductName, unitprice
 FROM products ORDER BY unitprice DESC LIMIT 10; 
 
# 9. Write a query to count current and discontinued products. Go to the editor
 SELECT COUNT(*)
 FROM products GROUP BY discontinued;
 
# 10. Write a query to get Product list (name, units on order , units in stock) of stock is less than the quantity on order.
 SELECT ProductName, unitsinstock, unitsonorder
 FROM products WHERE (unitsinstock < unitsonorder);