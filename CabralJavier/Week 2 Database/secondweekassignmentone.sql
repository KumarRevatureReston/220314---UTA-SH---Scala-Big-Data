-- Data Manipulation Language (DML) & Data Definition Language (DDL):

-- A. MySQL Create Table statement :

-- 1. Write a SQL statement to create a simple table countries including columns country_id,country_name and region_id.
CREATE TABLE countries(
country_id varchar (2),  
country_name varchar(40),
region_id decimal(10,0)
);

-- 2. Write a SQL statement to create a simple table countries including columns country_id,country_name and region_id which is already exists.
-- (ANSWER) You can not create a table that already exist because SQL will create an error for it.


-- 3. Write a SQL statement to create the structure of a table dup_countries similar to countries.

CREATE TABLE IF NOT EXISTS dup_countries
LIKE countries;


-- 4. Write a SQL statement to create a duplicate copy of countries table including structure and data by name dup_countries.

CREATE TABLE IF NOT EXISTS dup_countries
AS SELECT * FROM countries;

-- 5. Write a SQL statement to create a table countries set a constraint NULL.

CREATE TABLE IF NOT EXISTS countries (
country_id varchar(2) NOT NULL,
COUNTRY_NAME varchar(40) NOT NULL,
REGION_ID decimal(10,0) NOT NULL
);

-- 6. Write a SQL statement to create a table named jobs including columns job_id, job_title, min_salary, max_salary and check whether the max_salary amount exceeding the upper limit 25000.
CREATE TABLE jobs(
job_id varchar(15) NOT NULL,
job_title varchar (50) NOT NULL, 
MIN_SALARY decimal (8,0),
MAX_SALARY decimal (8,0)
CHECK(MAX_SALARY<=25000)
);


-- 7. Write a SQL statement to create a table named countries including columns country_id, country_name and region_id and make sure that no countries except Italy, India and China will be entered in the table.
CREATE TABLE countriess(
country_id VARCHAR (4),
country_name VARCHAR (30),
CHECK (country_name IN('Italy', 'India', 'China'),
region_id DECIMAL(11,0)
);

-- 8. Write a SQL statement to create a table named job_histry including columns employee_id, start_date, end_date, job_id and department_id and make sure that the value against column end_date will be entered at the time of insertion to the format like '--/--/----'.
CREATE TABLE job_histry(
employee_id DECIMAL (6,0) NOT NULL,
start_date DATE NOT NULL,
end_date DATE NOT NULL,
CHECK (end_date LIKE '--/--/----')
job_id VARCHAR (20) NOT NULL,
department_id DECIMAL (6,0)
);
-- 9. Write a SQL statement to create a table named countries including columns country_id,country_name and region_id and make sure that no duplicate data against column country_id will be allowed at the time of insertion.

CREATE TABLE ccountries(
country_id DECIMAL (10,0) NOT NULL,
country_name VARCHAR (60) NOT NULL,
region_id decimal(10,0) NOT NULL,
UNIQUE (country_id)
);

-- 10. Write a SQL statement to create a table named jobs including columns job_id, job_title, min_salary and max_salary, and make sure that, the default value for job_title is blank and min_salary is 8000 and max_salary is NULL will be entered automatically at the time of insertion if no value assigned for the specified columns.

CREATE TABLE jobs(
job_id VARCHAR(10) NOT NULL UNIQUE,
job_title VARCHAR(35) NOT NULL DEFAULT '',
min_salary DECIMAL(10,0) DEFAULT 8000,
max_salary DECIMAL (10,0) DEFAULT NULL 
);


-- 11. Write a SQL statement to create a table named countries including columns country_id, country_name and region_id and make sure that the country_id column will be a key field which will not contain any duplicate data at the time of insertion.
CREATE TABLE countries(
country_id varchar (20) NOT NULL UNIQUE PRIMARY KEY,
country_name varchar (40) NOT NULL,
region_id varchar(40)
);

-- 12. Write a SQL statement to create a table countries including columns country_id, country_name and region_id and make sure that the column country_id will be unique and store an auto incremented value.
CREATE TABLE countries(
country_id varchar (40) NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY ,
country_name varchar (10) NOT NULL,
region_id varchar (10) NOT NULL
);

-- 13. Write a SQL statement to create a table countries including columns country_id, country_name and region_id and make sure that the combination of columns country_id and region_id will be unique.
CREATE TABLE countries (
country_id varchar (40) NOT NULL UNIQUE, 
country_name varchar (40) NOT NULL, 
region_id varchar (10) NOT NULL,
PRIMARY KEY ((country_id, region_id));


-- 14. Write a SQL statement to create a table job_history including columns employee_id, start_date, end_date, job_id and department_id and make sure that, the employee_id column does not contain any duplicate value at the time of insertion and the foreign key column job_id contain only those values which are exists in the jobs table.
CREATE TABLE job_history(
employee_id VARCHAR (40) NOT NULL UNIQUE,
start_date DATE NOT NULL,
end_date DATE NOT NULL, 
job_id varchar (40) NOT NULL,
department_id varchar (40) NOT NULL, 
FOREIGN KEY (jobs_id) REFERENCES jobs(jobs_id)
)ENGINE=InnoDB;




-- Here is the structure of the table jobs;

+------------+--------------+------+-----+---------+-------+
| Field      | Type         | Null | Key | Default | Extra |
+------------+--------------+------+-----+---------+-------+
| JOB_ID     | varchar(10)  | NO   | PRI |         |       |
| JOB_TITLE  | varchar(35)  | NO   |     | NULL    |       |
| MIN_SALARY | decimal(6,0) | YES  |     | NULL    |       |
| MAX_SALARY | decimal(6,0) | YES  |     | NULL    |       |
+------------+--------------+------+-----+---------+-------+


-- 15. Write a SQL statement to create a table employees including columns employee_id, first_name, last_name, email, phone_number hire_date, 
-- job_id, salary, commission, manager_id and department_id and make sure that, the employee_id column does not contain any duplicate value at the time of insertion
-- and the foreign key columns combined by department_id and manager_id columns contain only those unique combination values, which combinations are exists in the departments table.
CREATE TABLE employees(
employee_id varchar (40) NOT NULL PRIMARY KEY,
first_name varchar(40) NOT NULL,
last_name varchar (40) NOT NULL,
email varchar (40) NOT NULL ,
phone_number varchar (40),
hire_date DATE NOT NULL,
job_id varchar(10) NOT NULL,
salary decimal (10,0), 
commission decimal (10,0),
manager_id varchar (40) NOT NULL,
department_id varchar (40) NOT NULL,
FOREIGN KEYS (department_id, manager_id) reference department(department_id, manager_id)
)Engine=InnoDB;

-- Assume the structure of departments table below.

+-----------------+--------------+------+-----+---------+-------+
| Field           | Type         | Null | Key | Default | Extra |
+-----------------+--------------+------+-----+---------+-------+
| DEPARTMENT_ID   | decimal(4,0) | NO   | PRI | 0       |       |
| DEPARTMENT_NAME | varchar(30)  | NO   |     | NULL    |       |
| MANAGER_ID      | decimal(6,0) | NO   | PRI | 0       |       |
| LOCATION_ID     | decimal(4,0) | YES  |     | NULL    |       |
+-----------------+--------------+------+-----+---------+-------+


-- 16. Write a SQL statement to create a table employees including columns employee_id, first_name, last_name, email, phone_number hire_date, job_id, salary, commission, manager_id and department_id and make 
-- sure that, the employee_id column does not contain any duplicate value at the time of insertion, 
-- and the foreign key column department_id, reference by the column department_id of departments table, can contain only those values 
-- which are exists in the departments table and another foreign key column job_id, referenced by the column job_id of jobs table, can contain only those values which are exists in the jobs table. The InnoDB Engine have been used to create the tables.
CREATE TABLE employees(
employee_id varchar (40) NOT NULL PRIMARY KEY, 
first_name varchar (40) NOT NULL, 
last_name varchar (40) NOT NULL, 
email varchar (40) NOT NULL, 
phone_number varchar (40) NOT NULL, 
hire_date DATE NOT NULL,
job_id varchar NOT NULL, 
salary decimal (10,0),
commission decimal (10,0),
manager_id varchar (40) NOT NULL,
department_id varchar (40) NOT NULL, 
FOREIGN KEY (department_id) reference department(deparment_id)
FOREIGN KEY column_id reference jobs(job_id)
) Engine=InnoDB;
 
-- "A foreign key constraint is not required merely to join two tables. For storage engines other than InnoDB, 
-- it is possible when defining a column to use a REFERENCES tbl_name(col_name) clause, which has no actual effect, 
-- and serves only as a memo or comment to you that the column which you are currently defining is intended to refer to a column 
-- in another table." - Reference dev.mysql.com

-- Assume that the structure of two tables departments and jobs.

+-----------------+--------------+------+-----+---------+-------+
| Field           | Type         | Null | Key | Default | Extra |
+-----------------+--------------+------+-----+---------+-------+
| DEPARTMENT_ID   | decimal(4,0) | NO   | PRI | 0       |       |
| DEPARTMENT_NAME | varchar(30)  | NO   |     | NULL    |       |
| MANAGER_ID      | decimal(6,0) | YES  |     | NULL    |       |

| LOCATION_ID     | decimal(4,0) | YES  |     | NULL    |       |
+-----------------+--------------+------+-----+---------+-------+


+------------+--------------+------+-----+---------+-------+
| Field      | Type         | Null | Key | Default | Extra |
+------------+--------------+------+-----+---------+-------+
| JOB_ID     | varchar(10)  | NO   | PRI |         |       |
| JOB_TITLE  | varchar(35)  | NO   |     | NULL    |       |
| MIN_SALARY | decimal(6,0) | YES  |     | NULL    |       |
| MAX_SALARY | decimal(6,0) | YES  |     | NULL    |       |
+------------+--------------+------+-----+---------+-------+


-- 17. Write a SQL statement to create a table employees including columns employee_id, first_name, last_name, job_id, salary and 
-- make sure that, the employee_id column does not contain any duplicate value at the time of insertion, and 
-- the foreign key column job_id, referenced by the column job_id of jobs table, can contain only those 
-- values which are exists in the jobs table. The InnoDB Engine have been used to create the tables. 
-- The specialty of the statement is that, The ON UPDATE CASCADE action allows you to perform cross-table update and 
-- ON DELETE RESTRICT action reject the deletion. The default action is ON DELETE RESTRICT.

CREATE TABLE IF NOT EXISTS employees ( 
employee_id decimal(6,0) NOT NULL PRIMARY KEY, 
first_name varchar(20) DEFAULT NULL, 
last_name varchar(25) NOT NULL, 
email varchar(25) NOT NULL, 
phone_number varchar(20) DEFAULT NULL, 
hire_date date NOT NULL, 
job_id varchar(10) NOT NULL, 
salary varchar (40) DEFAULT NULL, 
commission_pct decimal(2,2) DEFAULT NULL, 
manager_id decimal(6,0) DEFAULT NULL, 
department_id varchar (40) DEFAULT NULL, 
FOREIGN KEY(department_id) 
REFERENCES  departments(department_id),
FOREIGN KEY(job_id) 
REFERENCES  jobs(job_id)
)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS jobs ( 
JOB_ID integer NOT NULL UNIQUE PRIMARY KEY, 
JOB_TITLE varchar(35) NOT NULL DEFAULT ' ', 
MIN_SALARY decimal(6,0) DEFAULT 8000, 
MAX_SALARY decimal(6,0) DEFAULT NULL
)ENGINE=InnoDB;


+------------+--------------+------+-----+---------+-------+
| Field      | Type         | Null | Key | Default | Extra |
+------------+--------------+------+-----+---------+-------+
| JOB_ID     | int(11)      | NO   | PRI | NULL    |       |
| JOB_TITLE  | varchar(35)  | NO   |     |         |       |
| MIN_SALARY | decimal(6,0) | YES  |     | 8000    |       |
| MAX_SALARY | decimal(6,0) | YES  |     | NULL    |       |
+------------+--------------+------+-----+---------+-------+


-- 18. Write a SQL statement to create a table employees including columns employee_id, first_name, last_name, job_id, 
-- salary and make sure that, the employee_id column does not contain any duplicate value at the time of insertion, and 
-- the foreign key column job_id, referenced by the column job_id of jobs table, can contain only those values 
-- which are exists in the jobs table. The InnoDB Engine have been used to create the tables. 
-- The specialty of the statement is that, The ON DELETE CASCADE that lets you allow to delete records in the employees(child) table 
-- that refer to a record in the jobs(parent) table when the record in the parent table is deleted and the ON UPDATE RESTRICT actions 
-- reject any updates. Assume that the structure of the table jobs and InnoDB Engine have been used to create the table jobs.


CREATE TABLE IF NOT EXISTS employees ( 
employees_id decimal(6,0) NOT NULL PRIMARY KEY, 
first_name varchar(20) DEFAULT NULL, 
last_name varchar(25) NOT NULL, 
job_id INTEGER NOT NULL, 
salary decimal(8,2) DEFAULT NULL, 
FOREIGN KEY(job_id) 
REFERENCES  jobs(job_Id) 
ON DELETE CASCADE ON UPDATE RESTRICT
)ENGINE=InnoDB;



CREATE TABLE IF NOT EXISTS jobs ( 
JOB_ID integer NOT NULL UNIQUE PRIMARY KEY, 
JOB_TITLE varchar(35) NOT NULL DEFAULT ' ', 
MIN_SALARY decimal(6,0) DEFAULT 8000, 
MAX_SALARY decimal(6,0) DEFAULT NULL
)ENGINE=InnoDB;


+------------+--------------+------+-----+---------+-------+
| Field      | Type         | Null | Key | Default | Extra |
+------------+--------------+------+-----+---------+-------+
| JOB_ID     | int(11)      | NO   | PRI | NULL    |       |
| JOB_TITLE  | varchar(35)  | NO   |     |         |       |
| MIN_SALARY | decimal(6,0) | YES  |     | 8000    |       |
| MAX_SALARY | decimal(6,0) | YES  |     | NULL    |       |
+------------+--------------+------+-----+---------+-------+


-- 19. Write a SQL statement to create a table employees including columns employee_id, first_name, last_name, job_id, salary and make sure 
-- that, the employee_id column does not contain any duplicate value at the time of insertion, and the foreign key column job_id, 
-- referenced by the column job_id of jobs table, can contain only those values which are exists in the jobs table.
--  The InnoDB Engine have been used to create the tables. The specialty of the statement is that, 
-- The ON DELETE SET NULL action will set the foreign key column values in the child table(employees) to NULL when the record in the 
-- parent table(jobs) is deleted, with a condition that the foreign key column in the child table must accept NULL values and the 
-- ON UPDATE SET NULL action resets the values in the rows in the child table(employees) to NULL values when the rows in the 
-- parent table(jobs) are updated.

CREATE TABLE IF NOT EXISTS employees ( 
employee_id decimal(6,0) NOT NULL PRIMARY KEY, 
first_name varchar(20) DEFAULT NULL, 
last_name varchar(25) NOT NULL, 
job_id INTEGER, 
salary decimal(8,2) DEFAULT NULL, 
FOREIGN KEY(job_id) 
REFERENCES  jobs(job_id)
ON DELETE SET NULL 
ON UPDATE SET NULL
)ENGINE=InnoDB;

Assume that the structure of two table jobs and InnoDB Engine have been used to create the table jobs.

CREATE TABLE IF NOT EXISTS jobs ( 
JOB_ID integer NOT NULL UNIQUE PRIMARY KEY, 
JOB_TITLE varchar(35) NOT NULL DEFAULT ' ', 
MIN_SALARY decimal(6,0) DEFAULT 8000, 
MAX_SALARY decimal(6,0) DEFAULT NULL
)ENGINE=InnoDB;


+------------+--------------+------+-----+---------+-------+
| Field      | Type         | Null | Key | Default | Extra |
+------------+--------------+------+-----+---------+-------+
| JOB_ID     | int(11)      | NO   | PRI | NULL    |       |
| JOB_TITLE  | varchar(35)  | NO   |     |         |       |
| MIN_SALARY | decimal(6,0) | YES  |     | 8000    |       |
| MAX_SALARY | decimal(6,0) | YES  |     | NULL    |       |
+------------+--------------+------+-----+---------+-------+


-- 20. Write a SQL statement to create a table employees including columns employee_id, first_name, last_name, job_id, salary and make sure that, 
-- the employee_id column does not contain any duplicate value at the time of insertion, and the foreign key column job_id, referenced by the 
-- column job_id of jobs table, can contain only those values which are exists in the jobs table. 
-- The InnoDB Engine have been used to create the tables. The specialty of the statement is that, The ON DELETE NO ACTION and the ON UPDATE 
-- NO ACTION actions will reject the deletion and any updates.

CREATE TABLE IF NOT EXISTS employees ( 
employee_id varchar (40) NOT NULL PRIMARY KEY, 
first_name varchar(20) DEFAULT NULL, 
last_name varchar(25) NOT NULL, 
JOB_ID INTEGER NOT NULL, 
SALARY decimal(8,2) DEFAULT NULL, 
FOREIGN KEY(JOB_ID) REFERENCES  jobs(job_if)
ON DELETE NO ACTION 
ON UPDATE NO ACTION
)ENGINE=InnoDB;


-- Assume that the structure of two table jobs and InnoDB Engine have been used to create the table jobs.


-- B. MySQL Insert Rows into the Table

-- Write a SQL statement to insert a record with your own value into the table countries against each columns.

INSERT INTO countries VALUES('C2','India',1001);

-- Here in the following is the structure of the table countries.

+--------------+---------------+------+-----+---------+-------+
| Field        | Type          | Null | Key | Default | Extra |
+--------------+---------------+------+-----+---------+-------+
| COUNTRY_ID   | varchar(2)    | YES  |     | NULL    |       |
| COUNTRY_NAME | varchar(40)   | YES  |     | NULL    |       |
| REGION_ID    | decimal(10,0) | YES  |     | NULL    |       |
+--------------+---------------+------+-----+---------+-------+	


-- 2. Write a SQL statement to insert one row into the table countries against the column country_id and country_name.

INSERT INTO countries (country_id,country_name) VALUES('C2','India');

Here in the following is the structure of the table countries.

+--------------+---------------+------+-----+---------+-------+
| Field        | Type          | Null | Key | Default | Extra |
+--------------+---------------+------+-----+---------+-------+
| COUNTRY_ID   | varchar(2)    | YES  |     | NULL    |       |
| COUNTRY_NAME | varchar(40)   | YES  |     | NULL    |       |
| REGION_ID    | decimal(10,0) | YES  |     | NULL    |       |
+--------------+---------------+------+-----+---------+-------+	

-- 3. Write a SQL statement to create duplicate of countries table named country_new with all structure and data.

CREATE TABLE IF NOT EXISTS country_new
AS SELECT * FROM countries;


Here in the following is the structure of the table countries.

+--------------+---------------+------+-----+---------+-------+
| Field        | Type          | Null | Key | Default | Extra |
+--------------+---------------+------+-----+---------+-------+
| COUNTRY_ID   | varchar(2)    | YES  |     | NULL    |       |
| COUNTRY_NAME | varchar(40)   | YES  |     | NULL    |       |
| REGION_ID    | decimal(10,0) | YES  |     | NULL    |       |
+--------------+---------------+------+-----+---------+-------+	


-- 4. Write a SQL statement to insert NULL values against region_id column for a row of countries table.

INSERT INTO countries (country_id,country_name,region_id) VALUES('C2','India',NULL);

-- 5. Write a SQL statement to insert 3 rows by a single insert statement.
INSERT INTO countries VALUES('DOO2','India',1001),
('C0002','USA', 1007),('C0003','UK',1003);

-- 6. Write a SQL statement insert rows from country_new table to countries table.

INSERT INTO countries
SELECT * FROM country_new;

Here is the rows for country_new table. Assume that, the countries table is empty.

+------------+--------------+-----------+
| COUNTRY_ID | COUNTRY_NAME | REGION_ID |
+------------+--------------+-----------+
| C0001      | India        |      1001 |
| C0002      | USA          |      1007 |
| C0003      | UK           |      1003 |
+------------+--------------+-----------+


-- 7. Write a SQL statement to insert one row in jobs table to ensure that no duplicate value will be entered in the job_id column.

INSERT INTO jobs VALUES(8001,'OFFICER',8000);

-- C.MySQL Update Table 

-- 1. Write a SQL statement to change the email column of employees table with 'not available' for all employees.
	
UPDATE employees 
SET email='not available',



-- 2. Write a SQL statement to change the email and commission_pct column of employees table with 'not available' and 0.10 for all employees.
UPDATE employees 
SET email='not available',
commission_pct=0.10 
WHERE department_id=110;

-- 3. Write a SQL statement to change the email column of employees table with 'not available' for those employees whose department_id is 80 and gets a commission is less than .20%

UPDATE employees 
SET email='not available'
WHERE department_id=80 AND commission_pct<.20;


-- 4.Write a SQL statement to increase the salary of employees under the department 40, 90 and 110 according to the company rules that, salary will be increased by 25% for the department 40, 15% for department 90 and 10% for the department 110 and the rest of the departments will remain same.
UPDATE employees SET salary= CASE department_id 
                          WHEN 40 THEN salary+(salary*.25) 
                          WHEN 90 THEN salary+(salary*.15)
                          WHEN 110 THEN salary+(salary*.10)
                          ELSE salary
                        END
             WHERE department_id IN (40,50,50,60,70,80,90,110);


-- D.MySQL basic SELECT statement (HR DB)

-- 1.Write a query to display the names (first_name, last_name) using alias name “First Name", "Last Name"
SELECT first_name "First Name",  last_name "Last Name" FROM employees;

-- 2.Write a query to get unique department ID from employee table.

SELECT DISTINCT department_id FROM employees;

-- 3.Write a query to get the names (first_name, last_name), salary, PF of all the employees (PF is calculated as 15% of salary)
SELECT first_name, last_name, salary, salary*.15 PF 
	FROM employees;


-- E. Aggregate Functions and Group by (HR DB)
-- 1.Write a query to list the number of jobs available in the employees table.

SELECT COUNT(DISTINCT job_id) 
FROM employees;

-- 2.Write a query to get the total salaries payable to employees.
SELECT SUM(salary) 
     FROM employees;


-- 3. Write a query to get the maximum salary of an employee working as a Programmer. 
SELECT MAX(salary) 
FROM employees 
WHERE job_id = 'Programmer';
-- f. Northwind db
-- Queries on Products table

-- 1. Write a query to get Product name and quantity/unit. Go to the editor
SELECT ProductName, QuantityPerUnit 
FROM Products;

-- 2. Write a query to get current Product list (Product ID and name). Go to the editor
SELECT ProductID, ProductName
FROM Products
WHERE Discontinued = "False"
ORDER BY ProductName;


-- 3. Write a query to get discontinued Product list (Product ID and name). Go to the editor

SELECT ProductID, ProductName
FROM Products
WHERE Discontinued = 1 
ORDER BY ProductName;

-- 4. Write a query to get most expense and least expensive Product list (name and unit price). Go to the editor

SELECT ProductName, UnitPrice 
FROM Products 
ORDER BY UnitPrice DESC;

-- 5. Write a query to get Product list (id, name, unit price) where current products cost less than $20. Go to the editor
SELECT ProductID, ProductName, UnitPrice
FROM Products
WHERE (((UnitPrice)<20) AND ((Discontinued)=False))
ORDER BY UnitPrice DESC;


-- 6. Write a query to get Product list (id, name, unit price) where products cost between $15 and $25. Go to the editor

SELECT ProductName, UnitPrice
FROM Products
WHERE (((UnitPrice)>=15 And (UnitPrice)<=25) 
AND ((Products.Discontinued)=False))
ORDER BY Products.UnitPrice DESC;

-- 7. Write a query to get Product list (name, unit price) of above average price. Go to the editor

SELECT DISTINCT ProductName, UnitPrice
FROM Products
WHERE UnitPrice > (SELECT avg(UnitPrice) FROM Products)
ORDER BY UnitPrice;

-- 8. Write a query to get Product list (name, unit price) of ten most expensive products. Go to the editor

SELECT DISTINCT ProductName as Twenty_Most_Expensive_Products, UnitPrice
FROM Products AS a
WHERE 20 >= (SELECT COUNT(DISTINCT UnitPrice)
                    FROM Products AS b
                    WHERE b.UnitPrice >= a.UnitPrice)
ORDER BY UnitPrice desc;



-- 9. Write a query to count current and discontinued products. Go to the editor

SELECT Count(ProductName)
FROM Products
GROUP BY Discontinued;

-- 10. Write a query to get Product list (name, units on order , units in stock) of stock is less than the quantity on order. Go to the editor

SELECT ProductName,  UnitsOnOrder , UnitsInStock
FROM Products
WHERE (((Discontinued)=False) AND ((UnitsInStock)<UnitsOnOrder));

