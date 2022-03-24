-- 1. Write a SQL statement to change the email column of employees table with 'not available' 
-- for all employees.	
UPDATE employees SET email='not available';
-- 2. Write a SQL statement to change the email and commission_pct column of employees table 
-- with 'not available' and 0.10 for all employees.
UPDATE employees SET email='not available', commission_pct=0.10;
-- 3. Write a SQL statement to change the email column of employees table with 'not available' 
-- for those employees whose department_id is 80 and gets a commission is less than .20%
UPDATE employees SET email='not available' WHERE department_id=80 AND commission_pct<0.20;
-- 4.Write a SQL statement to increase the salary of employees under the department 40, 90 and 110 
-- according to the company rules that, salary will be increased by 25% for the department 40, 15% 
-- for department 90 and 10% for the department 110 and the rest of the departments will remain same.
UPDATE employees SET salary=CASE department_id
					WHEN 40 THEN salary+(salary*0.25)
                    WHEN 90 THEN salary+(salary*0.15)
                    WHEN 110 THEN salary+(salary*0.10)
                    END
WHERE department_id IN(40,90,110);

