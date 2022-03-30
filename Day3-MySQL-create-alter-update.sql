#Create Table
#1
CREATE TABLE IF NOT EXISTS countries (
id varchar(2) PRIMARY KEY,
name varchar(2),
population integer  NULL,
region varchar(15)
);
#2
CREATE TABLE IF NOT EXISTS countries (
country_id varchar(2) PRIMARY KEY,
country_name varchar(2),
region_id varchar(15)
);

#Alter Table
#1
ALTER TABLE locations
ADD region_id integer;
#2
ALTER TABLE locations
DROP city;

#Update Table
#1
UPDATE employees set email = 'not availabe';
#2
UPDATE employees SET salary = CASE department_ID
	WHEN 40 THEN salary+(SALARY*0.25)
    WHEN 90 THEN salary+(SALARY*0.15)
    WHEN 110 THEN salary+(SALARY*0.10)
    ELSE salary
    END
WHERE department_ID IN (30,40,50,60,70,80,90,100,110);

#INSERT ROWS INTO THE TABLE
#1
INSERT INTO countries VALUES(
'CA', 'Canada', 5);
#2
INSERT INTO countries (country_id, country_name) VALUES(
'US','United States of America');

#SELECT
#1
SELECT first_name as "First Name", last_name as "Last Name"
FROM employees;
#2
SELECT DISTINCT DEPARTMENT_ID FROM employees;