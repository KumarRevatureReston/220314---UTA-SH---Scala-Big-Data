
-- 1.Write a query to list the number of jobs available in the employees table.
SELECT COUNT(DISTINCT(job_id)) FROM employees;
    
-- 2.Write a query to get the total salaries payable to employees.
SELECT SUM(salary) FROM employees;

-- 3. Write a query to get the maximum salary of an employee working as a Programmer. 
SELECT MAX(salary) FROM employees WHERE job_title="PROGRAMMER";
