-- 1 Write a SQL statement to create a simple table countries including cokumns country_id,country_name and region_id
CREATE TABLE countries (country_id INT,country_name VARCHAR(20),region_id INT);

-- 2 Write a SQL statement to create a simple table countries including cokumns country_id,country_name and region_id which is already exists
DROP TABLE IF EXISTS countries;
CREATE TABLE countries (country_id INT,country_name VARCHAR(20),region_id INT);

-- 3 Write a SQL statement to create the structure of a table dup_countries similar to cuntries
CREATE TABLE dup_countries (country_id INT,country_name VARCHAR(20),region_id INT);

-- 4 Write a SQL statement to create a duplicate copy of countries table including structure and data by name dup_countries.
CREATE TABLE dup_countries_copy LIKE dup_countries;

-- 5 Write a SQL statement to create a table countries set a constraint NULL
CREATE TABLE countries (country_id INT NOT NULL, country_name VARCHAR(20),region_id INT);

-- 6 Write a SQL statement to create a table named jobs including columns 
-- job_id, job_title, min_salary, max_salary and check whether the max_salary 
-- amount exceeding the upper limmit 2500
CREATE TABLE jobs (job_id INT NOT NULL, job_title VARCHAR(30), min_salary Decimal(5,2),max_salary Decimal(5,2),CHECK(max_salary<=25000));

-- 7 Write a SQL statement to create a table named countries including columns country_id, 
-- country_name and region_id and make sure that no countries except Italy, India and China 
-- will be entered in the table
CREATE TABLE countries (country_id INT NOT NULL, country_name VARCHAR(20), region_id INT,CHECK(country_name="Italy" OR country_name="India" OR country_name="China"));  

-- 8. Write a SQL statement to create a table named job_histry including columns 
-- employee_id, start_date, end_date, job_id and department_id and make sure that the 
-- value against column end_date will be entered at the time of insertion to the format like '--/--/----' 
CREATE TABLE job_history(
employee_id INT PRIMARY KEY,
start_date DATE,end_date DATE, 
job_id INT, dep_id INT, 
CHECK(start_date like "--/--/----"),
CHECK(end_date like "--/--/----"));

-- 9. Write a SQL statement to create a table named countries including columns 
-- country_id,country_name and region_id and make sure that no duplicate data against 
-- column country_id will be allowed at the time of insertion.
CREATE TABLE countries (
country_id INT PRIMARY KEY UNIQUE,
country_name VARCHAR(20), 
region_id INT);

-- 10. Write a SQL statement to create a table named jobs including columns 
-- job_id, job_title, min_salary and max_salary, and make sure that, the default value 
-- for job_title is blank and min_salary is 8000 and max_salary is NULL will be entered 
-- automatically at the time of insertion if no value assigned for the specified columns.
CREATE TABLE jobs(
job_id INT, 
job_title VARCHAR(20) DEFAULT ' ', 
min_salary DECIMAL(5,2)DEFAULT 8000,
max_salary DECIMAL(5,2) DEFAULT NULL
);

-- 11 Write a SQL statement to create a table named countries including columns 
-- country_id, country_name and region_id and make sure that the country_id column 
-- will be a key field which will not contain any duplicate data at the time of insertion.
CREATE TABLE countries(country_id INT PRIMARY KEY UNIQUE,country_name VARCHAR(20), region_id INT); 

-- 12. Write a SQL statement to create a table countries including columns 
-- country_id, country_name and region_id and make sure that the column country_id 
-- will be unique and store an auto incremented value.
CREATE TABLE countries (
country_id INT PRIMARY KEY UNIQUE,
country_name VARCHAR(20),
region_id INT
);

-- 13. Write a SQL statement to create a table countries including columns 
-- country_id, country_name and region_id and make sure that the combination of columns 
-- country_id and region_id will be unique.
CREATE TABLE countries(
country_id INT,
country_name VARCHAR(20),
region_id INT,
PRIMARY KEY(country_id,region_id)
);


-- 14. Write a SQL statement to create a table job_history including columns 
-- employee_id, start_date, end_date, job_id and department_id and make sure that, 
-- the employee_id column does not contain any duplicate value at the time of insertion 
-- and the foreign key column job_id contain only those values which are exists in the jobs table.

CREATE TABLE job_history(
employee_id VARCHAR(10) PRIMARY KEY UNIQUE NOT NULL,
start_date DATE,
end_date DATE,
job_id VARCHAR(10),
department_id VARCHAR(10),
FOREIGN KEY (job_id) REFERENCES jobs(job_id)
);

-- 15. Write a SQL statement to create a table employees including columns 
-- employee_id, first_name, last_name, email, phone_number hire_date, job_id, salary, 
-- commission, manager_id and department_id and make sure that, the employee_id column 
-- does not contain any duplicate value at the time of insertion and the foreign key columns 
-- combined by department_id and manager_id columns contain only those unique combination values, 
-- which combinations are exists in the departments table.

CREATE TABLE employees(
employee_id INT PRIMARY KEY UNIQUE NOT NULL,
first_name VARCHAR(20),
last_name VARCHAR(20),
email VARCHAR(20),
phone_number VARCHAR(20),
hire_date DATE,
job_id VARCHAR(10),
salary DECIMAL(6,0),
commission DECIMAL(6,0),
manager_id DECIMAL(6,0),
department_id DECIMAL(4,0),
FOREIGN KEY (department_id,manager_id) REFERENCES departments(department_id,manager_id)
)ENGINE=InnoDB;

-- 16. Write a SQL statement to create a table employees including columns employee_id, 
-- first_name, last_name, email, phone_number hire_date, job_id, salary, commission, manager_id 
-- and department_id and make sure that, the employee_id column does not contain any duplicate 
-- value at the time of insertion, and the foreign key column department_id, reference by the 
-- column department_id of departments table, can contain only those values which are exists in 
-- the departments table and another foreign key column job_id, referenced by the column job_id 
-- of jobs table, can contain only those values which are exists in the jobs table. The InnoDB 
-- Engine have been used to create the tables.
CREATE TABLE employees(
employee_id DECIMAL(4,0) PRIMARY KEY UNIQUE NOT NULL,
first_name VARCHAR(20),
last_name VARCHAR(20),
email VARCHAR(20),
phone_number VARCHAR(12),
hire_date DATE,
job_id VARCHAR(10),
salary DECIMAL(6,0),
commission DECIMAL(6,0),
manager_id DECIMAL(6,0),
department_id DECIMAL(4,0),
FOREIGN KEY (department_id) REFERENCES departments(department_id),
FOREIGN KEY (job_id) REFERENCES jobs(job_id)
)ENGINE=InnoDB;

-- 17. Write a SQL statement to create a table employees including columns employee_id, first_name, 
-- last_name, job_id, salary and make sure that, the employee_id column does not contain any 
-- duplicate value at the time of insertion, and the foreign key column job_id, referenced by the 
-- column job_id of jobs table, can contain only those values which are exists in the jobs table. 
-- The InnoDB Engine have been used to create the tables. The specialty of the statement is that, 
-- The ON UPDATE CASCADE action allows you to perform cross-table update and ON DELETE RESTRICT 
-- action reject the deletion. The default action is ON DELETE RESTRICT.
CREATE TABLE employees(
employee_id DECIMAL(4,0) PRIMARY KEY UNIQUE NOT NULL,
first_name VARCHAR(20),
last_name VARCHAR(20),
job_id VARCHAR(10),
salary DECIMAL(6,0),
FOREIGN KEY (job_id) REFERENCES jobs(job_id)
ON UPDATE CASCADE
ON DELETE RESTRICT
)ENGINE=InnoDB;


-- 18. Write a SQL statement to create a table employees including columns employee_id, 
-- first_name, last_name, job_id, salary and make sure that, the employee_id column does not 
-- contain any duplicate value at the time of insertion, and the foreign key column job_id, 
-- referenced by the column job_id of jobs table, can contain only those values which are exists in 
-- the jobs table. The InnoDB Engine have been used to create the tables. The specialty of 
-- the statement is that, The ON DELETE CASCADE that lets you allow to delete records in 
-- the employees(child) table that refer to a record in the jobs(parent) table when the record 
-- in the parent table is deleted and the ON UPDATE RESTRICT actions reject any updates.

CREATE TABLE employees (
employee_id DECIMAL(4,0) PRIMARY KEY UNIQUE NOT NULL,
first_name VARCHAR(20),
last_name VARCHAR(20),
job_id VARCHAR(10),
salary DECIMAL(6,2),
FOREIGN KEY (job_id) REFERENCES jobs(job_id)
ON DELETE CASCADE
ON UPDATE RESTRICT
)ENGINE=InnoDB;

-- 19. Write a SQL statement to create a table employees including columns employee_id, 
-- first_name, last_name, job_id, salary and make sure that, the employee_id column does not 
-- contain any duplicate value at the time of insertion, and the foreign key column job_id, 
-- referenced by the column job_id of jobs table, can contain only those values which are exists 
-- in the jobs table. The InnoDB Engine have been used to create the tables. The specialty of 
-- the statement is that, The ON DELETE SET NULL action will set the foreign key column values in 
-- the child table(employees) to NULL when the record in the parent table(jobs) is deleted, with 
-- a condition that the foreign key column in the child table must accept NULL values and 
-- the ON UPDATE SET NULL action resets the values in the rows in the child table(employees) 
-- to NULL values when the rows in the parent table(jobs) are updated.

CREATE TABLE employees (
employee_id DECIMAL(4,0) PRIMARY KEY UNIQUE NOT NULL,
first_name VARCHAR(20),
last_name VARCHAR(20),
job_id VARCHAR(20),
salary decimal(6,2),
FOREIGN KEY (job_id) REFERENCES jobs(job_id)
ON UPDATE SET NULL
ON DELETE SET NULL
)ENGINE=InnoDB;

-- 20 Write a SQL statement to create a table employees including columns employee_id, 
-- first_name, last_name, job_id, salary and make sure that, the employee_id column does not 
-- contain any duplicate value at the time of insertion, and the foreign key column job_id, 
-- referenced by the column job_id of jobs table, can contain only those values which are exists 
-- in the jobs table. The InnoDB Engine have been used to create the tables. The specialty of 
-- the statement is that, The ON DELETE NO ACTION and the ON UPDATE NO ACTION actions will 
-- reject the deletion and any updates.

CREATE TABLE employees(
employee_id DECIMAL(4,0) PRIMARY KEY UNIQUE NOT NULL,
first_name VARCHAR(20),
last_name VARCHAR(20),
job_id VARCHAR(20),
salary decimal(6,2),
FOREIGN KEY (job_id) REFERENCES jobs(job_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
)ENGINE=InnoDB;



