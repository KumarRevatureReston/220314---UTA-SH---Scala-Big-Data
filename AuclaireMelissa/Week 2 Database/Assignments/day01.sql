-- Data Manipulation Language (DML) & Data Definition Language (DDL)


USE mysql;

-- 1. Write a SQL statement to create a simple table countries including columns country_id,
-- country_name and region_id.
/*
create table countries(
   country_id INT NOT NULL AUTO_INCREMENT,
   country_name VARCHAR(100) NOT NULL,
   region_id VARCHAR(40) NOT NULL,
   PRIMARY KEY (country_id)
);
*/


-- 2. Write a SQL statement to create a simple table countries including columns country_id, country_name and 
-- region_id which is already exists.
DROP TABLE if EXISTS countries;
create table countries(
   country_id INT NOT NULL AUTO_INCREMENT,
   country_name VARCHAR(100) NOT NULL,
   region_id VARCHAR(40) NOT NULL,
   PRIMARY KEY (country_id)
);

-- SELECT * FROM countries;

-- 3. Write a SQL statement to create the structure of a table dup_countries similar to countries.
CREATE TABLE IF NOT EXISTS dup_countries LIKE countries;

-- SELECT * FROM dup_countries;

-- 4. Write a SQL statement to create a duplicate copy of countries table including structure and 
-- data by name dup_countries.


CREATE TABLE IF NOT EXISTS dup_countries AS SELECT * FROM countries;

-- SELECT * FROM dup_countries;

-- 5. Write a SQL statement to create a table countries set a constraint NULL.

DROP TABLE if EXISTS countries;
create table countries(
   country_id INT NULL,
   country_name VARCHAR(100) NULL,
   region_id VARCHAR(40) NULL
);

-- SELECT * FROM countries;


-- 6. Write a SQL statement to create a table named jobs including columns job_id, job_title, min_salary, max_salary and 
-- check whether the max_salary amount exceeding the upper limit 25000.


CREATE TABLE IF NOT EXISTS jobs(
	job_id VARCHAR(10) NOT NULL,
	job_title VARCHAR(35) NOT NULL,
	min_salary DECIMAL(5,0),
	max_salary DECIMAL(5,0)
	CHECK(max_salary<=25000)	
);


-- 7. Write a SQL statement to create a table named countries including columns country_id, country_name and region_id and 
-- make sure that no countries except Italy, India and China will be entered in the table.



CREATE TABLE IF NOT EXISTS countries (
	country_id VARCHAR(2),
	country_name VARCHAR(40)
	CHECK(country_name IN('Italy','India','China')),
	region_id DECIMAL(0,0)
);

-- SELECT * FROM countries;


-- 8. Write a SQL statement to create a table named job_histry including columns employee_id, start_date, end_date, job_id and 
-- department_id and make sure that the value against column end_date will be entered at the time of insertion to the format like '--/--/----'.


CREATE TABLE IF NOT EXISTS job_histry(
	employee_id DECIMAL(6,0) NOT NULL,
	start_date DATE NOT NULL,
	end_date DATE NOT NULL
	CHECK(end_date LIKE '--/--/----'),
	job_id VARCHAR(10) NOT NULL,
	department_id DECIMAL(4,0) NOT NULL
);



-- SELECT * FROM job_histry;

-- 9. Write a SQL statement to create a table named countries including columns country_id,country_name and region_id and make sure that 
-- no duplicate data against column country_id will be allowed at the time of insertion.


CREATE TABLE IF NOT EXISTS countries ( 
	country_id VARCHAR(2) NOT NULL,
	country_name VARCHAR(40) NOT NULL,
	region_id DECIMAL(10,0) NOT NULL,
	UNIQUE(country_id)
);


-- SELECT * FROM countries;


-- 10. Write a SQL statement to create a table named jobs including columns job_id, job_title, min_salary and max_salary, and make sure that, 
-- the default value for job_title is blank and min_salary is 8000 and max_salary is NULL will be entered automatically at the time of insertion if no value assigned for the specified columns.

/*
CREATE TABLE IF NOT EXISTS jobs( 
	job_id VARCHAR(10) NOT NULL UNIQUE, 
	job_title VARCHAR(35) NOT NULL DEFAULT ' ', 
	min_salary DECIMAL(6,0) DEFAULT 8000, 
	max_salary DECIMAL(6,0) DEFAULT NULL
);
*/



-- 11. Write a SQL statement to create a table named countries including columns country_id, country_name and region_id and make sure that the 
-- country_id column will be a key field which will not contain any duplicate data at the time of insertion.


CREATE TABLE IF NOT EXISTS countries (
	country_id VARCHAR(2) NOT NULL UNIQUE PRIMARY KEY,
	country_name VARCHAR(40) NOT NULL,
	region_id DECIMAL(10,0) NOT NULL
);


-- 12. Write a SQL statement to create a table countries including columns country_id, country_name and region_id and make sure that the column 
-- country_id will be unique and store an auto incremented value.


CREATE TABLE IF NOT EXISTS countries (
	country_id INTEGER NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
	country_name VARCHAR(40) NOT NULL,
	region_id DECIMAL(10,0) NOT NULL
);
DESC countries;



-- 13. Write a SQL statement to create a table countries including columns 
-- country_id, country_name and region_id and make sure that the combination of columns country_id and region_id will be unique.

DROP TABLE if EXISTS countries;
CREATE TABLE IF NOT EXISTS countries (
country_id VARCHAR(2) NOT NULL UNIQUE DEFAULT '',
country_name VARCHAR(40) DEFAULT NULL,
region_id DECIMAL(10,0) NOT NULL,
PRIMARY KEY (country_id,region_id));


-- 14. Write a SQL statement to create a table job_history including columns employee_id, start_date, end_date, job_id and department_id
-- and make sure that, the employee_id column does not contain any duplicate value at the time of insertion and the foreign key column job_id contain only those values which are exists in the jobs table.


CREATE TABLE IF NOT EXISTS jobs ( 
	job_id VARCHAR(10) NOT NULL UNIQUE, 
	job_title VARCHAR(35) NOT NULL DEFAULT ' ', 
	min_salary DECIMAL(6,0) DEFAULT 8000, 
	max_salary DECIMAL(6,0) DEFAULT NULL
);

DROP TABLE IF EXISTS job_history;

CREATE TABLE job_history(
	employee_id DECIMAL(6,0) NOT NULL PRIMARY KEY,
	start_date DATE NOT NULL,
	end_date DATE NOT NULL,
	job_id VARCHAR(10) NOT NULL,
	department_id DECIMAL(4,0) DEFAULT NULL,
	FOREIGN KEY (job_id) REFERENCES jobs(job_id)
)ENGINE=InnoDB;

-- 15. Write a SQL statement to create a table employees including columns employee_id, first_name, last_name, email, phone_number hire_date, 
-- job_id, salary, commission, manager_id and department_id and make sure that, the employee_id column does not contain any duplicate value at 
-- the time of insertion and the foreign key columns combined by department_id and manager_id columns contain only those unique combination 
-- values, which combinations are exists in the departments table.

/*
DROP TABLE IF EXISTS departments;
CREATE TABLE IF NOT EXISTS departments ( 
	department_id DECIMAL(4,0) NOT NULL PRIMARY KEY DEFAULT 0, 
	department_name VARCHAR(30) NOT NULL DEFAULT ' ', 
	manager_id DECIMAL(6,0) NOT NULL DEFAULT 0, 
	location_id DECIMAL(4,0) NULL DEFAULT NULL
);
*/


DROP TABLE IF EXISTS employees;


CREATE TABLE IF NOT EXISTS employees (
	employee_id DECIMAL(6,0) NOT NULL PRIMARY KEY,
	first_name VARCHAR(20) DEFAULT NULL,
	last_name VARCHAR(25) NOT NULL,
	email VARCHAR(25) NOT NULL,
	phone_number VARCHAR(20) DEFAULT NULL,
	hire_date DATE NOT NULL,
	job_id VARCHAR(10) NOT NULL,
	salary DECIMAL(8,2) DEFAULT NULL,
	commission_pct DECIMAL(2,2) DEFAULT NULL,
	manager_id DECIMAL(6,0) DEFAULT NULL,
	department_id DECIMAL(4,0) DEFAULT NULL,
	FOREIGN KEY(department_id,manager_id)
	REFERENCES departments(department_id,manager_id)
)ENGINE=InnoDB;
DESC employees;


-- 16. Write a SQL statement to create a table employees including columns employee_id, first_name, last_name, email, phone_number hire_date, 
-- job_id, salary, commission, manager_id and department_id and make sure that, the employee_id column does not contain any duplicate value at 
-- the time of insertion, and the foreign key column department_id, reference by the column department_id of departments table, can contain only 
-- those values which are exists in the departments table and another foreign key column job_id, referenced by the column job_id of jobs table, 
-- can contain only those values which are exists in the jobs table. The InnoDB Engine have been used to create the tables.

CREATE TABLE IF NOT EXISTS employees ( 
	employee_id decimal(6,0) NOT NULL PRIMARY KEY, 
	first_name VARCHAR(20) DEFAULT NULL, 
	last_name VARCHAR(25) NOT NULL, 
	email VARCHAR(25) NOT NULL, 
	phone_number VARCHAR(20) DEFAULT NULL, 
	hire_date DATE NOT NULL, 
	job_id VARCHAR(10) NOT NULL, 
	salary DECIMAL(8,2) DEFAULT NULL, 
	commission_pct DECIMAL(2,2) DEFAULT NULL, 
	manager_id DECIMAL(6,0) DEFAULT NULL, 
	department_id DECIMAL(4,0) DEFAULT NULL, 
	FOREIGN KEY(department_id) 
	REFERENCES  departments(department_id),
	FOREIGN KEY(job_id) 
	REFERENCES  jobs(job_id)
)ENGINE=InnoDB;


-- 17. Write a SQL statement to create a table employees including columns employee_id, first_name, last_name, job_id, salary and make sure that,
-- the employee_id column does not contain any duplicate value at the time of insertion, and the foreign key column job_id, referenced by the 
-- column job_id of jobs table, can contain only those values which are exists in the jobs table. The InnoDB Engine have been used to create the tables. The specialty of the statement is that, The ON UPDATE CASCADE action allows you to perform cross-table update and ON DELETE RESTRICT action reject the deletion. The default action is ON DELETE RESTRICT.x

DROP TABLE IF EXISTS employees;
CREATE TABLE IF NOT EXISTS employees ( 
	employee_id DECIMAL(6,0) NOT NULL PRIMARY KEY, 
	first_name VARCHAR(20) DEFAULT NULL, 
	last_name VARCHAR(25) NOT NULL, 
	email VARCHAR(25) NOT NULL, 
	phone_number VARCHAR(20) DEFAULT NULL, 
	hire_date DATE NOT NULL, 
	job_id VARCHAR(10) NOT NULL, 
	salary DECIMAL(8,2) DEFAULT NULL, 
	commission_pct DECIMAL(2,2) DEFAULT NULL, 
	manager_id DECIMAL(6,0) DEFAULT NULL, 
	department_id DECIMAL(4,0) DEFAULT NULL, 
	FOREIGN KEY(department_id) 
	REFERENCES  departments(department_id),
	FOREIGN KEY(job_id) 
	REFERENCES  jobs(job_id)
)ENGINE=InnoDB;


-- 18. Write a SQL statement to create a table employees including columns employee_id, first_name, last_name, job_id, salary and make sure that, 
-- the employee_id column does not contain any duplicate value at the time of insertion, and the foreign key column job_id, referenced by the 
-- column job_id of jobs table, can contain only those values which are exists in the jobs table. The InnoDB Engine have been used to create the 
-- tables. The specialty of the statement is that, The ON DELETE CASCADE that lets you allow to delete records in the employees(child) table that 
-- refer to a record in the jobs(parent) table when the record in the parent table is deleted and the ON UPDATE RESTRICT actions reject any 
-- updates.

DROP TABLE IF EXISTS employees;

/*
CREATE TABLE IF NOT EXISTS employees ( 
	EMPLOYEE_ID decimal(6,0) NOT NULL PRIMARY KEY, 
	FIRST_NAME varchar(20) DEFAULT NULL, 
	LAST_NAME varchar(25) NOT NULL, 
	JOB_ID INTEGER NOT NULL, 
	SALARY decimal(8,2) DEFAULT NULL, 
	FOREIGN KEY(JOB_ID) 
	REFERENCES  jobs(JOB_ID) 
	ON DELETE CASCADE ON UPDATE RESTRICT
)ENGINE=InnoDB;
*/

-- 19. Write a SQL statement to create a table employees including columns employee_id, first_name, last_name, job_id, salary and make sure that, 
-- the employee_id column does not contain any duplicate value at the time of insertion, and the foreign key column job_id, referenced by the 
-- column job_id of jobs table, can contain only those values which are exists in the jobs table. The InnoDB Engine have been used to create the 
-- tables. The specialty of the statement is that, The ON DELETE SET NULL action will set the foreign key column values in the child 
-- table(employees) to NULL when the record in the parent table(jobs) is deleted, with a condition that the foreign key column in the child table 
-- must accept NULL values and the ON UPDATE SET NULL action resets the values in the rows in the child table(employees) to NULL values when the 
-- rows in the parent table(jobs) are updated.

/*
DROP TABLE IF EXISTS jobs;
CREATE TABLE IF NOT EXISTS jobs ( 
	job_id INTEGER NOT NULL UNIQUE PRIMARY KEY, 
	job_title VARCHAR(35) NOT NULL DEFAULT ' ', 
	min_salary DECIMAL(6,0) DEFAULT 8000, 
	max_salary DECIMAL(6,0) DEFAULT NULL
)ENGINE=InnoDB;
*/

/*
DROP TABLE IF EXISTS employees;
CREATE TABLE IF NOT EXISTS employees ( 
    employee_id DECIMAL(6,0) NOT NULL PRIMARY KEY, 
    first_name VARCHAR(20) DEFAULT NULL, 
    last_name VARCHAR(25) NOT NULL, 
    job_id INTEGER, 
    salary DECIMAL(8,2) DEFAULT NULL, 
    FOREIGN KEY(job_id) 
    REFERENCES  jobs(job_id)
    ON DELETE SET NULL 
    ON UPDATE SET NULL
)ENGINE=InnoDB;
*/


-- 20. Write a SQL statement to create a table employees including columns employee_id, first_name, last_name, job_id, salary and make sure 
-- that, the employee_id column does not contain any duplicate value at the time of insertion, and the foreign key column job_id, referenced by 
-- the column job_id of jobs table, can contain only those values which are exists in the jobs table. The InnoDB Engine have been used to create 
-- the tables. The specialty of the statement is that, The ON DELETE NO ACTION and the ON UPDATE NO ACTION actions will reject the deletion and 
-- any updates.

DROP TABLE IF EXISTS employees;

/*
DROP TABLE IF EXISTS job_history;
DROP TABLE IF EXISTS jobs;

CREATE TABLE IF NOT EXISTS jobs(
	job_id INTEGER NOT NULL UNIQUE PRIMARY KEY,
	job_title VARCHAR(35) NOT NULL DEFAULT ' ',
	min_salary DECIMAL(6,0) DEFAULT 8000,
	max_salary DECIMAL(6,0) DEFAULT NULL
)ENGINE=InnoDB;


CREATE TABLE IF NOT EXISTS employees ( 
	employee_id DECIMAL(6,0) NOT NULL PRIMARY KEY, 
	first_name VARCHAR(20) DEFAULT NULL, 
	last_name VARCHAR(25) NOT NULL, 
	job_id INTEGER NOT NULL, 
	salary DECIMAL(8,2) DEFAULT NULL, 
	FOREIGN KEY(job_id) 
	REFERENCES  jobs(job_id)
	ON DELETE NO ACTION 
	ON UPDATE NO ACTION
)ENGINE=InnoDB;
*/

