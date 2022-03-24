-- 1.Write a query to display the names (first_name, last_name) using alias 
-- name “First Name", "Last Name"
SELECT first_name "First Name", last_name "Last Name" FROM employees; 


-- 2.Write a query to get unique department ID from employee table.
SELECT DISTINCT(department_id) FROM employee;

-- 3.Write a query to get the names (first_name, last_name), salary, 
-- PF of all the employees (PF is calculated as 15% of salary)
SELECT first_name,last_name,salary*0.15 PF FROM employees;