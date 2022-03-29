# Data Manipulation Language (DML) & Data Definition Language (DDL):

# A. MySQL Create Table statement :

# 1. Write a SQL statement to create a simple table countries including columns country_id,country_name and region_id.
Create Table countries (
country_id varchar(2), country_name varchar(50), region_id varchar(4) 
 ); #

# 2. Write a SQL statement to create a simple table countries including columns country_id,country_name and region_id which is already exists.
Create Table if not exists countries (
country_id varchar(2), country_name varchar(50), region_id varchar(4) 
 ); #

# 3. Write a SQL statement to create the structure of a table dup_countries similar to countries.
Create Table IF NOT EXISTS dup_countries
like countries; #

# 4. Write a SQL statement to create a duplicate copy of countries table including structure and data by name dup_countries.
Create Table If Not Exists dup_countries
As Select * From countries;

# 5. Write a SQL statement to create a table countries set a constraint NULL.
Create Table If Not Exists countries (
country_id varchar(2) NOT NULL, 
country_name varchar(50) NOT NULL,
region_id varchar(4) NOT NULL
);
#


# 6. Write a SQL statement to create a table named jobs including columns job_id, job_title, min_salary, max_salary and check whether the max_salary amount exceeding the upper limit 25000.
Create Table If Not Exists jobs(
job_ID varchar(5), job_Title varchar(20), min_salary integer(6),
max_salary integer(10)
Check(max_salary<=25000)
);
#



# 7. Write a SQL statement to create a table named countries including columns country_id, country_name and region_id and make sure that no countries except Italy, India and China will be entered in the table.
 Create Table If Not Exists countries(
 country_id varchar(2), country_name varchar(30)
 Check(country_name in('Italy', 'India', 'China')),
 region_id integer(3)
 );
 
# 8. Write a SQL statement to create a table named job_histry including columns employee_id, start_date, end_date, job_id and department_id and make sure that the value against column end_date will be entered at the time of insertion to the format like '--/--/----'.
 Create Table If Not Exists job_history(
 employee_id integer(5), start_date date,
 end_date date Check(end_date Like '--/--/----'),
 job_id integer(8),
 department_id integer(6)
 ); #
# 9. Write a SQL statement to create a table named countries including columns country_id,country_name and region_id and make sure that no duplicate data against column country_id will be allowed at the time of insertion.
 Create Table If Not Exists countries(
 country_id varchar(2),
 country_name varchar(30),
 region_id varchar(15),
 Unique(country_id)
 ); #
 
# 10. Write a SQL statement to create a table named jobs including columns job_id, job_title, min_salary and max_salary, and make sure that, the default value for job_title is blank and min_salary is 8000 and max_salary is NULL will be entered automatically at the time of insertion if no value assigned for the specified columns.
Create TABLE IF NOT EXISTS jobs(
job_ID varchar(5), 
job_Title varchar(20) DEFAULT ' ', 
min_salary integer(6) DEFAULT 8000,
max_salary integer(10) DEFAULT NULL
);
 
# 11. Write a SQL statement to create a table named countries including columns country_id, country_name and region_id and make sure that the country_id column will be a key field which will not contain any duplicate data at the time of insertion.
 Create Table If Not Exists countries(
 country_id varchar(2) AUTO_INCREMENT,
 country_name varchar(30),
 region_id varchar(15),
 UNIQUE (country_id)
 );
 
 
# 12. Write a SQL statement to create a table countries including columns country_id, country_name and region_id and make sure that the column country_id will be unique and store an auto incremented value.
 Create Table If Not Exists countries(
 country_id varchar(2),
 country_name varchar(30),
 region_id varchar(15),
 UNIQUE(country_id)
 );
# 13. Write a SQL statement to create a table countries including columns country_id, country_name and region_id and make sure that the combination of columns country_id and region_id will be unique.
Create Table If Not Exists countries(
 country_id varchar(2),
 country_name varchar(30),
 region_id varchar(15),
 UNIQUE(country_id, region_id)
 );
# 14. Write a SQL statement to create a table job_history including columns employee_id, start_date, end_date, job_id and department_id and make sure that, the employee_id column does not contain any duplicate value at the time of insertion and the foreign key column job_id contain only those values which are exists in the jobs table.
CREATE TABLE IF NOT EXISTS job_history(
employee_id integer(5), 
start_date date,
 end_date date,
 job_id integer(8),
 department_id integer(6),
 UNIQUE(employee_id),
 FOREIGN KEY(job_id) REFERENCES jobs(jobs_id)
);

# Here is the structure of the table jobs;
# +------------+--------------+------+-----+---------+-------+
# | Field      | Type         | Null | Key | Default | Extra |
# +------------+--------------+------+-----+---------+-------+
# | JOB_ID     | varchar(10)  | NO   | PRI |         |       |
# | JOB_TITLE  | varchar(35)  | NO   |     | NULL    |       |
# | MIN_SALARY | decimal(6,0) | YES  |     | NULL    |       |
# | MAX_SALARY | decimal(6,0) | YES  |     | NULL    |       |
# +------------+--------------+------+-----+---------+-------+
 
# 15. Write a SQL statement to create a table employees including columns employee_id, first_name, last_name, email, phone_number hire_date, job_id, salary, commission, manager_id and department_id and make sure that, the employee_id column does not contain any duplicate value at the time of insertion and the foreign key columns combined by department_id and manager_id columns contain only those unique combination values, which combinations are exists in the departments table.
 CREATE TABLE IF NOT EXISTS employees(
 employee_id integer(5) UNIQUE,
 first_name varchar(10), last_name varchar(10),
 email varchar(30), phone_number integer(9),
 hire_date date, job_id integer(8),
 salary integer(8), commission integer(8),
 manager_id integer(3), department_id integer(4),
 FOREIGN KEY(department_id, manager_id) REFERENCES departments(department_id, manager_id)
 );
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
 CREATE TABLE IF NOT EXISTS employees(
 employee_id integer(5) UNIQUE,
 first_name varchar(10), last_name varchar(10),
 email varchar(30), phone_number integer(9),
 hire_date date, job_id integer(8),
 salary integer(8), commission integer(8),
 manager_id integer(3), department_id integer(4),
 FOREIGN KEY(department_id) REFERENCES departments(department_id),
 FOREIGN KEY(job_id) REFERENCES jobs(job_id)
 )ENGINE=InnoDB;
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
 CREATE TABLE IF NOT EXISTS employees(
 employee_id integer(5) UNIQUE,
 first_name varchar(10), last_name varchar(10),
 job_id integer(8), salary integer(8),
 FOREIGN KEY(job_id) REFERENCES jobs(job_id)
 ON UPDATE CASCADE ON DELETE RESTRICT
 )ENGINE=InnoDB;
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
 CREATE TABLE IF NOT EXISTS employees(
 employee_id integer(5) UNIQUE,
 first_name varchar(10), last_name varchar(10),
 job_id integer(8), salary integer(8),
 FOREIGN KEY(job_id) REFERENCES jobs(job_id)
 ON DELETE CASCADE ON UPDATE RESTRICT
 )ENGINE=InnoDB;
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
 CREATE TABLE IF NOT EXISTS employees(
 employee_id integer(5) UNIQUE,
 first_name varchar(10), last_name varchar(10),
 job_id integer(8), salary integer(8),
 FOREIGN KEY(job_id) REFERENCES jobs(job_id)
 ON DELETE SET NULL ON UPDATE SET NULL
 )ENGINE=InnoDB;
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
 CREATE TABLE IF NOT EXISTS employees(
 employee_id integer(5) UNIQUE,
 first_name varchar(10), last_name varchar(10),
 job_id integer(8), salary integer(8),
 FOREIGN KEY(job_id) REFERENCES jobs(job_id)
 ON DELETE NO ACTION ON UPDATE NO ACTION
 )ENGINE=InnoDB;
# Assume that the structure of two table jobs and InnoDB Engine have been used to create the table jobs.
 




# B. MySQL Insert Rows into the Table
 
# Write a SQL statement to insert a record with your own value into the table countries against each columns.
insert into countries values('US','United States of America',01);
# Here in the following is the structure of the table countries.
 
# +--------------+---------------+------+-----+---------+-------+
# | Field        | Type          | Null | Key | Default | Extra |
# +--------------+---------------+------+-----+---------+-------+
# | COUNTRY_ID   | varchar(2)    | YES  |     | NULL    |       |
# | COUNTRY_NAME | varchar(40)   | YES  |     | NULL    |       |
# | REGION_ID    | decimal(10,0) | YES  |     | NULL    |       |
# +--------------+---------------+------+-----+---------+-------+	

 
# 2. Write a SQL statement to insert one row into the table countries against the column country_id and country_name.
 insert into countries (COUNTRY_ID, COUNTRY_NAME) values('US','United States of America');
# Here in the following is the structure of the table countries.
 
# +--------------+---------------+------+-----+---------+-------+
# | Field        | Type          | Null | Key | Default | Extra |
# +--------------+---------------+------+-----+---------+-------+
# | COUNTRY_ID   | varchar(2)    | YES  |     | NULL    |       |
# | COUNTRY_NAME | varchar(40)   | YES  |     | NULL    |       |
# | REGION_ID    | decimal(10,0) | YES  |     | NULL    |       |
# +--------------+---------------+------+-----+---------+-------+	
 
# 3. Write a SQL statement to create duplicate of countries table named country_new with all structure and data.
Create Table If Not Exists country_new
As Select * From countries;
# Here in the following is the structure of the table countries.
 
# +--------------+---------------+------+-----+---------+-------+
# | Field        | Type          | Null | Key | Default | Extra |
# +--------------+---------------+------+-----+---------+-------+
# | COUNTRY_ID   | varchar(2)    | YES  |     | NULL    |       |
# | COUNTRY_NAME | varchar(40)   | YES  |     | NULL    |       |
# | REGION_ID    | decimal(10,0) | YES  |     | NULL    |       |
# +--------------+---------------+------+-----+---------+-------+	

 
# 4. Write a SQL statement to insert NULL values against region_id column for a row of countries table.
 insert into countries(REGION_ID) VALUE(null);

 
# 5. Write a SQL statement to insert 3 rows by a single insert statement.
 insert into countries VALUES('CA','Canada',02),('IN','India',03),('CU','Cuba',07);

# 6. Write a SQL statement insert rows from country_new table to countries table.
 INSERT INTO countries SELECT * FROM country_new;
# Here is the rows for country_new table. Assume that, the countries table is empty.
 
# +------------+--------------+-----------+
# | COUNTRY_ID | COUNTRY_NAME | REGION_ID |
# +------------+--------------+-----------+
# | C0001      | India        |      1001 |
# | C0002      | USA          |      1007 |
# | C0003      | UK           |      1003 |
# +------------+--------------+-----------+
 
 
# 7. Write a SQL statement to insert one row in jobs table to ensure that no duplicate value will be entered in the job_id column.
create TABLE IF NOT EXISTS jobs(
job_ID varchar(5) UNIQUE, 
job_Title varchar(20) DEFAULT ' ', 
min_salary integer(6) DEFAULT 8000,
max_salary integer(10) DEFAULT NULL
);

INSERT INTO jobs VALUES('8675','Associate',50000,80000);
# C.MySQL Update Table 
 
# 1. Write a SQL statement to change the email column of employees table with 'not available' for all employees.	
 UPDATE employees SET email = 'not available';
# 2. Write a SQL statement to change the email and commission_pct column of employees table with 'not available' and 0.10 for all employees.
  UPDATE employees SET email = 'not available', commission_pct =0.10;
# 3. Write a SQL statement to change the email column of employees table with 'not available' for those employees whose department_id is 80 and gets a commission is less than .20%
UPDATE employees SET email = 'not available' WHERE department_id = 80 and  comission_pct < 0.20;
# 4.Write a SQL statement to increase the salary of employees under the department 40, 90 and 110 according to the company rules that, salary will be increased by 25% for the department 40, 15% for department 90 and 10% for the department 110 and the rest of the departments will remain same.
 UPDATE employees SET salary = CASE department_id
 WHEN 40 THEN salary+(salary*0.25)
 WHEN 90 THEN salary+(salary*0.15)
 WHEN 110 THEN salary+(salray*0.10) 
 WHEN NOT(40,90,110) THEN salary END;
# D.MySQL basic SELECT statement (HR DB)
 
# 1.Write a query to display the names (first_name, last_name) using alias name “First Name", "Last Name"
SELECT first_name as 'Fist Name', last_name as 'Last Name'FROM employee; 
# 2.Write a query to get unique department ID from employee table.
SELECT DISTINCT department_id from employee;
# 3.Write a query to get the names (first_name, last_name), salary, PF of all the employees (PF is calculated as 15% of salary)
 SELECT first_name,last_name,salary,(salary*0.15) as PF FROM employee;
# E. Aggregate Functions and Group by (HR DB)
# 1.Write a query to list the number of jobs available in the employees table.
SELECT COUNT(jobs) from employees;
# 2.Write a query to get the total salaries payable to employees.
SELECT  SUM(salaries) from employees;
# 3. Write a query to get the maximum salary of an employee working as a Programmer. 
 SELECT MAX(salries) from employees
 Order by salries DESC
 LIMIT 1;
# f. Northwind db
# Queries on Products table
 
# 1. Write a query to get Product name and quantity/unit. Go to the editor
 Select name,quantity_in_stock from products;
 
# 2. Write a query to get current Product list (Product ID and name). Go to the editor
 Select product_id,name from products where quantity_in_stock > 0;
 
 
# 3. Write a query to get discontinued Product list (Product ID and name). Go to the editor
 Select product_id,name from products where quantity_in_stock < 0;
 
 
# 4. Write a query to get most expense and least expensive Product list (name and unit price). Go to the editor
 Select name,unit_price from products
 ORDER BY unit_price DESC;
 
 
# 5. Write a query to get Product list (id, name, unit price) where current products cost less than $20. Go to the editor
 Select product_id, name, unit_price from products where unit_price < 20;
 
 
# 6. Write a query to get Product list (id, name, unit price) where products cost between $15 and $25. Go to the editor
  Select product_id, name, unit_price from products where unit_price > 15 and unit_price < 25;

 
 
# 7. Write a query to get Product list (name, unit price) of above average price. Go to the editor
   Select name, unit_price from products where unit_price >(SELECT AVG(unit_price) FROM products);

 
# 8. Write a query to get Product list (name, unit price) of ten most expensive products. Go to the editor
 Select name, unit_price from products
 ORDER BY unit_price DESC
 LIMIT 10;
 
# 9. Write a query to count current and discontinued products. Go to the editor
 select Count(*) FROM products where quantity_in_stock = 0 or quantity_in_stock > 0;
 
# 10. Write a query to get Product list (name, units on order , units in stock) of stock is less than the quantity on order.
