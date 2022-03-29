#Aggregate Functions

#1. From the following table, write a SQL query to calculate total purchase amount of all orders. Return total purchase amount.   

#Sample table: orders
#ord_no      purch_amt   ord_date    customer_id  salesman_id
#----------  ----------  ----------  -----------  -----------
#70001       150.5       2012-10-05  3005         5002
#70009       270.65      2012-09-10  3001         5005
#70002       65.26       2012-10-05  3002         5001
#70004       110.5       2012-08-17  3009         5003
#70007       948.5       2012-09-10  3005         5002
#70005       2400.6      2012-07-27  3007         5001
#70008       5760        2012-09-10  3002         5001
#70010       1983.43     2012-10-10  3004         5006
#70003       2480.4      2012-10-10  3009         5003
#70012       250.45      2012-06-27  3008         5002
#70011       75.29       2012-08-17  3003         5007
#70013       3045.6      2012-04-25  3002         5001

#Sample Output: sum 17541.18
SELECT SUM(purch_amt) FROM orders;

#2. From the following table, write a SQL query to calculate average purchase amount of all orders. Return average purchase amount.   
#Sample table: orders
#ord_no      purch_amt   ord_date    customer_id  salesman_id
#----------  ----------  ----------  -----------  -----------
#70001       150.5       2012-10-05  3005         5002
#70009       270.65      2012-09-10  3001         5005
#70002       65.26       2012-10-05  3002         5001
#70004       110.5       2012-08-17  3009         5003
#70007       948.5       2012-09-10  3005         5002
#70005       2400.6      2012-07-27  3007         5001
#70008       5760        2012-09-10  3002         5001
#70010       1983.43     2012-10-10  3004         5006
#70003       2480.4      2012-10-10  3009         5003
#70012       250.45      2012-06-27  3008         5002
#70011       75.29       2012-08-17  3003         5007
#70013       3045.6      2012-04-25  3002         5001

#Sample Output: avg 1461.7650000000000000
SELECT AVG(purch_amt) FROM orders;

#3. From the following table, write a SQL query to count the number of unique salespeople. Return number of salespeople.   
#Sample table: orders
#ord_no      purch_amt   ord_date    customer_id  salesman_id
#----------  ----------  ----------  -----------  -----------
#70001       150.5       2012-10-05  3005         5002
#70009       270.65      2012-09-10  3001         5005
#70002       65.26       2012-10-05  3002         5001
#70004       110.5       2012-08-17  3009         5003
#70007       948.5       2012-09-10  3005         5002
#70005       2400.6      2012-07-27  3007         5001
#70008       5760        2012-09-10  3002         5001
#70010       1983.43     2012-10-10  3004         5006
#70003       2480.4      2012-10-10  3009         5003
#70012       250.45      2012-06-27  3008         5002
#70011       75.29       2012-08-17  3003         5007
#70013       3045.6      2012-04-25  3002         5001

#Sample Output: count 6
SELECT COUNT(salesman_id) FROM orders;

##4. From the following table, write a SQL query to count the number of customers. Return number of customers.   

##Sample table: customer
##customer_id |   cust_name    |    city    | grade | salesman_id 
##-------------+----------------+------------+-------+-------------
##        3002 | Nick Rimando   | New York   |   100 |        5001
##        3007 | Brad Davis     | New York   |   200 |        5001
##        3005 | Graham Zusi    | California |   200 |        5002
##        3008 | Julian Green   | London     |   300 |        5002
##        3004 | Fabian Johnson | Paris      |   300 |        5006
##        3009 | Geoff Cameron  | Berlin     |   100 |        5003
##        3003 | Jozy Altidor   | Moscow     |   200 |        5007
##        3001 | Brad Guzan     | London     |       |        5005

##Sample Output: count 8
SELECT COUNT(customer_id) FROM customer;

#5. From the following table, write a SQL query to find the number of customers who got at least a gradation for his/her activity.  

#Sample table: customer
#customer_id |   cust_name    |    city    | grade | salesman_id 
#-------------+----------------+------------+-------+-------------
#        3002 | Nick Rimando   | New York   |   100 |        5001
#        3007 | Brad Davis     | New York   |   200 |        5001
#        3005 | Graham Zusi    | California |   200 |        5002
#        3008 | Julian Green   | London     |   300 |        5002
#        3004 | Fabian Johnson | Paris      |   300 |        5006
#        3009 | Geoff Cameron  | Berlin     |   100 |        5003
#        3003 | Jozy Altidor   | Moscow     |   200 |        5007
#        3001 | Brad Guzan     | London     |       |        5005

#Sample Output: count 7
SELECT COUNT(customer_id) FROM customer WHERE grade is NOT NULL;

#6. From the following table, write a SQL query to find the maximum purchase amount.    
#Sample table: orders
#ord_no      purch_amt   ord_date    customer_id  salesman_id
#----------  ----------  ----------  -----------  -----------
#70001       150.5       2012-10-05  3005         5002
#70009       270.65      2012-09-10  3001         5005
#70002       65.26       2012-10-05  3002         5001
#70004       110.5       2012-08-17  3009         5003
#70007       948.5       2012-09-10  3005         5002
#70005       2400.6      2012-07-27  3007         5001
#70008       5760        2012-09-10  3002         5001
#70010       1983.43     2012-10-10  3004         5006
#70003       2480.4      2012-10-10  3009         5003
#70012       250.45      2012-06-27  3008         5002
#70011       75.29       2012-08-17  3003         5007
#70013       3045.6      2012-04-25  3002         5001

#Sample Output:  max
#5760.00
SELECT MAX(purch_amt) FROM orders;

#7. From the following table, write a SQL query to find the minimum purchase amount. 
#ord_no      purch_amt   ord_date    customer_id  salesman_id
#----------  ----------  ----------  -----------  -----------
#70001       150.5       2012-10-05  3005         5002
#70009       270.65      2012-09-10  3001         5005
#70002       65.26       2012-10-05  3002         5001
#70004       110.5       2012-08-17  3009         5003
#70007       948.5       2012-09-10  3005         5002
#70005       2400.6      2012-07-27  3007         5001
#70008       5760        2012-09-10  3002         5001
#70010       1983.43     2012-10-10  3004         5006
#70003       2480.4      2012-10-10  3009         5003
#70012       250.45      2012-06-27  3008         5002
#70011       75.29       2012-08-17  3003         5007
#70013       3045.6      2012-04-25  3002         5001

#Sample Output: min 65.26
SELECT MIN(purch_amt) FROM orders;

#8. From the following table, write a SQL query to find the highest grade of the customers for each of the city. Return city, maximum grade.    
#Sample table: customer
#customer_id |   cust_name    |    city    | grade | salesman_id 
#-------------+----------------+------------+-------+-------------
#        3002 | Nick Rimando   | New York   |   100 |        5001
#        3007 | Brad Davis     | New York   |   200 |        5001
#        3005 | Graham Zusi    | California |   200 |        5002
#        3008 | Julian Green   | London     |   300 |        5002
#        3004 | Fabian Johnson | Paris      |   300 |        5006
#        3009 | Geoff Cameron  | Berlin     |   100 |        5003
#        3003 | Jozy Altidor   | Moscow     |   200 |        5007
#        3001 | Brad Guzan     | London     |       |        5005

#Sample Output:

#city		max
#London		300
#Paris		300
#New York	200
#California	200
#Berlin		100
#Moscow		200
SELECT CITY, MAX(grade) FROM customer GROUP BY city;
CREATE TABLE customer(customer_id int, cust_name varchar(255), city varchar(255), grade int, salesman_id int);
INSERT INTO customer VALUES (3002, "Nick Rimando", "New York", 100, 5001);
INSERT INTO customer VALUES (3003, "Brad Davis", "New York", 200, 5001);
INSERT INTO customer VALUES (3003, "Julian Green", "London", 300, 5002);


#9. From the following table, write a SQL query to find the highest purchase amount ordered by each customer. Return customer ID, maximum purchase amount.  

#Sample table: orders
#ord_no      purch_amt   ord_date    customer_id  salesman_id
#----------  ----------  ----------  -----------  -----------
#70001       150.5       2012-10-05  3005         5002
#70009       270.65      2012-09-10  3001         5005
#70002       65.26       2012-10-05  3002         5001
#70004       110.5       2012-08-17  3009         5003
#70007       948.5       2012-09-10  3005         5002
#70005       2400.6      2012-07-27  3007         5001
#70008       5760        2012-09-10  3002         5001
#70010       1983.43     2012-10-10  3004         5006
#70003       2480.4      2012-10-10  3009         5003
#70012       250.45      2012-06-27  3008         5002
#70011       75.29       2012-08-17  3003         5007
#70013       3045.6      2012-04-25  3002         5001

#Sample Output:

#customer_id	max
#3007		2400.60
#3008		250.45
#3002		5760.00
#3001		270.65
#3009		2480.40
#3004		1983.43
#3003		75.29
#3005		948.50
SELECT customer_id, MAX(purch_amt) FROM orders GROUP BY customer_id;

#10. From the following table, write a SQL query to find the highest purchase amount ordered by each customer on a particular date. Return, order date and highest purchase amount.   

#Sample table: orders
#ord_no      purch_amt   ord_date    customer_id  salesman_id
#----------  ----------  ----------  -----------  -----------
#70001       150.5       2012-10-05  3005         5002
#70009       270.65      2012-09-10  3001         5005
#70002       65.26       2012-10-05  3002         5001
#70004       110.5       2012-08-17  3009         5003
#70007       948.5       2012-09-10  3005         5002
#70005       2400.6      2012-07-27  3007         5001
#70008       5760        2012-09-10  3002         5001
#70010       1983.43     2012-10-10  3004         5006
#70003       2480.4      2012-10-10  3009         5003
#70012       250.45      2012-06-27  3008         5002
#70011       75.29       2012-08-17  3003         5007
#70013       3045.6      2012-04-25  3002         5001

#Sample Output:

#customer_id	ord_date	max
#3002		2012-10-05	65.26
#3003		2012-08-17	75.29
#3005		2012-10-05	150.50
#3007		2012-07-27	2400.60
#3009		2012-08-17	110.50
#3001		2012-09-10	270.65
#3002		2012-09-10	5760.00
#3005		2012-09-10	948.50
#3009		2012-10-10	2480.40
#3008		2012-06-27	250.45
#3004		2012-10-10	1983.43
#3002		2012-04-25	3045.60
SELECT ord_date, MAX(purch_amt) FROM orders GROUP BY ord_date;

#11. From the following table, write a SQL query to find the highest purchase amount on '2012-08-17' by each salesperson. Return salesperson ID, purchase amount.   
#Sample table: orders
#ord_no      purch_amt   ord_date    customer_id  salesman_id
#----------  ----------  ----------  -----------  -----------
#70001       150.5       2012-10-05  3005         5002
#70009       270.65      2012-09-10  3001         5005
#70002       65.26       2012-10-05  3002         5001
#70004       110.5       2012-08-17  3009         5003
#70007       948.5       2012-09-10  3005         5002
#70005       2400.6      2012-07-27  3007         5001
#70008       5760        2012-09-10  3002         5001
#70010       1983.43     2012-10-10  3004         5006
#70003       2480.4      2012-10-10  3009         5003
#70012       250.45      2012-06-27  3008         5002
#70011       75.29       2012-08-17  3003         5007
#70013       3045.6      2012-04-25  3002         5001

#Sample Output:

#salesman_id	max
#5003		110.50
#5007		75.29
SELECT salesman_id, MAX(purch_amt) FROM orders GROUP BY salesman_id;


#12. From the following table, write a SQL query to find highest order (purchase) amount by each customer in a particular order date. Filter the result by highest order (purchase) amount above 2000.00. Return customer id, order date and maximum purchase amount.

#Sample table: orders
#ord_no      purch_amt   ord_date    customer_id  salesman_id
#----------  ----------  ----------  -----------  -----------
#70001       150.5       2012-10-05  3005         5002
#70009       270.65      2012-09-10  3001         5005
#70002       65.26       2012-10-05  3002         5001
#70004       110.5       2012-08-17  3009         5003
#70007       948.5       2012-09-10  3005         5002
#70005       2400.6      2012-07-27  3007         5001
#70008       5760        2012-09-10  3002         5001
#70010       1983.43     2012-10-10  3004         5006
#70003       2480.4      2012-10-10  3009         5003
#70012       250.45      2012-06-27  3008         5002
#70011       75.29       2012-08-17  3003         5007
#70013       3045.6      2012-04-25  3002         5001

#Sample Output:

#customer_id	ord_date	max
#3007		2012-07-27	2400.60
#3002		2012-09-10	5760.00
#3009		2012-10-10	2480.40
#3002		2012-04-25	3045.60	
SELECT order_date, customer_id, MAX(purch_amt) FROM orders WHERE purch_amt > 2000 GROUP BY customer_id ORDER BY order_date;


#13. From the following table, write a SQL query to find the maximum order (purchase) amount in the range 2000, 6000 (Begin and end values are included.) by combination of each customer and order date. Return customer id, order date and maximum purchase amount.

#Sample table: orders
#ord_no      purch_amt   ord_date    customer_id  salesman_id
#----------  ----------  ----------  -----------  -----------
#70001       150.5       2012-10-05  3005         5002
#70009       270.65      2012-09-10  3001         5005
#70002       65.26       2012-10-05  3002         5001
#70004       110.5       2012-08-17  3009         5003
#70007       948.5       2012-09-10  3005         5002
#70005       2400.6      2012-07-27  3007         5001
#70008       5760        2012-09-10  3002         5001
#70010       1983.43     2012-10-10  3004         5006
#70003       2480.4      2012-10-10  3009         5003
#70012       250.45      2012-06-27  3008         5002
#70011       75.29       2012-08-17  3003         5007
#70013       3045.6      2012-04-25  3002         5001

#Sample Output:

#customer_id	ord_date	max
#3007		2012-07-27	2400.60
#3002		2012-09-10	5760.00
#3009		2012-10-10	2480.40
#3002		2012-04-25	3045.60

SELECT customer_id, ord_date, MAX(purch_amt) "max" FROM orders WHERE purch_amt BETWEEN 2000 and 6000 GROUP BY customer_id ORDER BY ord_date;

#14. From the following table, write a SQL query to find the maximum order (purchase) amount by the combination of each customer and order date. 
-- Filter the rows for maximum order (purchase) amount is either 2000, 3000, 5760, 6000. Return customer id, order date and maximum purchase amount.

#Sample table: orders
#ord_no      purch_amt   ord_date    customer_id  salesman_id
#----------  ----------  ----------  -----------  -----------
#70001       150.5       2012-10-05  3005         5002
#70009       270.65      2012-09-10  3001         5005
#70002       65.26       2012-10-05  3002         5001
#70004       110.5       2012-08-17  3009         5003
#70007       948.5       2012-09-10  3005         5002
#70005       2400.6      2012-07-27  3007         5001
#70008       5760        2012-09-10  3002         5001
#70010       1983.43     2012-10-10  3004         5006
#70003       2480.4      2012-10-10  3009         5003
#70012       250.45      2012-06-27  3008         5002
#70011       75.29       2012-08-17  3003         5007
#70013       3045.6      2012-04-25  3002         5001

#Sample Output:

#customer_id	ord_date	max
#3002		2012-09-10	5760.00
SELECT customer_id,ord_date,MAX(purch_amt) FROM orders GROUP BY customer_id,ord_date HAVING MAX(purch_amt) IN(2000 ,3000,5760, 6000);

#15. From the following table, write a SQL query to find the maximum order (purchase) amount by each customer. The customer ID should be in the range 3002 and 3007(Begin and end values are included.). Return customer id and maximum purchase amount.
#Sample table: orders
#ord_no      purch_amt   ord_date    customer_id  salesman_id
#----------  ----------  ----------  -----------  -----------
#70001       150.5       2012-10-05  3005         5002
#70009       270.65      2012-09-10  3001         5005
#70002       65.26       2012-10-05  3002         5001
#70004       110.5       2012-08-17  3009         5003
#70007       948.5       2012-09-10  3005         5002
#70005       2400.6      2012-07-27  3007         5001
#70008       5760        2012-09-10  3002         5001
#70010       1983.43     2012-10-10  3004         5006
#70003       2480.4      2012-10-10  3009         5003
#70012       250.45      2012-06-27  3008         5002
#70011       75.29       2012-08-17  3003         5007
#70013       3045.6      2012-04-25  3002         5001

#Sample Output:

#customer_id	max
#3002		5760.00
#3007		2400.60
#3004		1983.43
#3003		75.29
#3005		948.50
SELECT customer_id,MAX(purch_amt) FROM orders WHERE customer_id BETWEEN 3002 and 3007 GROUP BY customer_id;

#16. From the following table, write a SQL query to find the maximum order (purchase) amount for each customer. The customer ID should be in the range 3002 and 3007(Begin and end values are included.). Filter the rows for maximum order (purchase) amount is higher than 1000. Return customer id and maximum purchase amount.

#Sample table: orders
#ord_no      purch_amt   ord_date    customer_id  salesman_id
#----------  ----------  ----------  -----------  -----------
#70001       150.5       2012-10-05  3005         5002
#70009       270.65      2012-09-10  3001         5005
#70002       65.26       2012-10-05  3002         5001
#70004       110.5       2012-08-17  3009         5003
#70007       948.5       2012-09-10  3005         5002
#70005       2400.6      2012-07-27  3007         5001
#70008       5760        2012-09-10  3002         5001
#70010       1983.43     2012-10-10  3004         5006
#70003       2480.4      2012-10-10  3009         5003
#70012       250.45      2012-06-27  3008         5002
#70011       75.29       2012-08-17  3003         5007
#70013       3045.6      2012-04-25  3002         5001

#Sample Output:

#customer_id	max
#3002		5760.00
#3007		2400.60
#3004		1983.43
SELECT customer_id,MAX(purch_amt) FROM orders WHERE customer_id BETWEEN 3002 and 3007 GROUP BY customer_id;

#17. From the following table, write a SQL query to find the maximum order (purchase) amount generated by each salesperson. Filter the rows for the salesperson ID is in the range 5003 and 5008 (Begin and end values are included.). Return salesperson id and maximum purchase amount.

#Sample table: orders
#ord_no      purch_amt   ord_date    customer_id  salesman_id
#----------  ----------  ----------  -----------  -----------
#70001       150.5       2012-10-05  3005         5002
#70009       270.65      2012-09-10  3001         5005
#70002       65.26       2012-10-05  3002         5001
#70004       110.5       2012-08-17  3009         5003
#70007       948.5       2012-09-10  3005         5002
#70005       2400.6      2012-07-27  3007         5001
#70008       5760        2012-09-10  3002         5001
#70010       1983.43     2012-10-10  3004         5006
#70003       2480.4      2012-10-10  3009         5003
#70012       250.45      2012-06-27  3008         5002
#70011       75.29       2012-08-17  3003         5007
#70013       3045.6      2012-04-25  3002         5001

#Sample Output:

#salesman_id	max
#5005		270.65
#5003		2480.40
#5007		75.29
#5006		1983.43

SELECT customer_id,MAX(purch_amt) FROM orders WHERE customer_id BETWEEN 5003 and 5008 GROUP BY customer_id;

#18. From the following table, write a SQL query to count all the orders generated on '2012-08-17'. Return number of orders.

#Sample table: orders
#ord_no      purch_amt   ord_date    customer_id  salesman_id
#----------  ----------  ----------  -----------  -----------
#70001       150.5       2012-10-05  3005         5002
#70009       270.65      2012-09-10  3001         5005
#70002       65.26       2012-10-05  3002         5001
#70004       110.5       2012-08-17  3009         5003
#70007       948.5       2012-09-10  3005         5002
#70005       2400.6      2012-07-27  3007         5001
#70008       5760        2012-09-10  3002         5001
#70010       1983.43     2012-10-10  3004         5006
#70003       2480.4      2012-10-10  3009         5003
#70012       250.45      2012-06-27  3008         5002
#70011       75.29       2012-08-17  3003         5007
#70013       3045.6      2012-04-25  3002         5001

#Sample Output:

#count
#2

SELECT COUNT(*) FROM orders WHERE ord_date='2012-08-17';

#19. From the following table, write a SQL query to count number of salespeople who belongs to a city. Return number of salespeople.


#Sample table: salesman
#salesman_id |    name    |   city   | commission 
#-------------+------------+----------+------------
#        5001 | James Hoog | New York |       0.15
#        5002 | Nail Knite | Paris    |       0.13
#        5005 | Pit Alex   | London   |       0.11
#        5006 | Mc Lyon    | Paris    |       0.14
#        5007 | Paul Adam  | Rome     |       0.13
#        5003 | Lauson Hen | San Jose |       0.12

#Sample Output:

#count
#6
SELECT COUNT(*) FROM salesman WHERE city IS NOT NULL;

#20. From the following table, write a SQL query to count number of orders by the combination of each order date and salesperson. Return order date, salesperson id.  Go to the editor

#Sample table: orders


#Sample Output:

#ord_date	salesman_id	count
#2012-07-27	5001		1
#2012-08-17	5007		1
#2012-04-25	5001		1
#2012-09-10	5002		1
#2012-10-05	5002		1
#2012-10-10	5003		1
#2012-09-10	5005		1
#2012-08-17	5003		1
#2012-06-27	5002		1
#2012-09-10	5001		1
#2012-10-05	5001		1
#2012-10-10	5006		1
SELECT ord_date,salesman_id,COUNT(*) FROM orders GROUP BY ord_date,salesman_id;

#21. From the following table, write a SQL query to calculate the average product price. Return average product price.

#Sample table: item_mast
# PRO_ID PRO_NAME                       PRO_PRICE    PRO_COM
#------- ------------------------- -------------- ----------
#    101 Mother Board                    3200.00         15
#    102 Key Board                        450.00         16
#    103 ZIP drive                        250.00         14
#    104 Speaker                          550.00         16
#    105 Monitor                         5000.00         11
#    106 DVD drive                        900.00         12
#    107 CD drive                         800.00         12
#    108 Printer                         2600.00         13
#    109 Refill cartridge                 350.00         13
#    110 Mouse                            250.00         12

#Sample Output:

#Average Price
#1435.0000000000000000
SELECT AVG(pro_price) AS "Average Price" FROM item_mast;

#22. From the following table, write a SQL query to count number of products where product price is higher than or equal to 350. Return number of products.

#Sample table: item_mast
#PRO_ID PRO_NAME                       PRO_PRICE    PRO_COM
#------- ------------------------- -------------- ----------
#    101 Mother Board                    3200.00         15
#    102 Key Board                        450.00         16
#    103 ZIP drive                        250.00         14
#    104 Speaker                          550.00         16
#    105 Monitor                         5000.00         11
#    106 DVD drive                        900.00         12
#    107 CD drive                         800.00         12
#    108 Printer                         2600.00         13
#    109 Refill cartridge                 350.00         13
#    110 Mouse                            250.00         12

#Sample Output:

#Number of Products
#8
SELECT COUNT(*) AS "Number of Products" FROM item_mast WHERE pro_price >= 350;

#23. From the following table, write a SQL query to compute the average price for unique companies. Return average price and company id.  
#Sample table: item_mast
#PRO_ID PRO_NAME                       PRO_PRICE    PRO_COM
#------- ------------------------- -------------- ----------
#    101 Mother Board                    3200.00         15
#    102 Key Board                        450.00         16
#    103 ZIP drive                        250.00         14
#    104 Speaker                          550.00         16
#    105 Monitor                         5000.00         11
#    106 DVD drive                        900.00         12
#    107 CD drive                         800.00         12
#    108 Printer                         2600.00         13
#    109 Refill cartridge                 350.00         13
#    110 Mouse                            250.00         12

#Sample Output:

#Average Price			Company ID
#250.0000000000000000		14
#650.0000000000000000		12
#3200.0000000000000000		15
#5000.0000000000000000		11
#1475.0000000000000000		13
#500.0000000000000000		16
SELECT AVG(pro_price) AS "Average Price", pro_com AS "Company ID" FROM item_mas GROUP BY pro_com;

#24. From the following table, write a SQL query to compute the sum of the allotment amount of all departments. Return sum of the allotment amount.   

#Sample table: emp_department
#DPT_CODE DPT_NAME        DPT_ALLOTMENT
#-------- --------------- -------------
#      57 IT                      65000
#      63 Finance                 15000
#      47 HR                     240000
#      27 RD                      55000
#      89 QC                      75000

#Sample Output:

#sum
#450000
SELECT SUM(dpt_allotment) FROM emp_department;

#25. From the following table, write a SQL query to find the number of employees in each department. Return department code and number of employees. 
#Sample table: emp_details
#EMP_IDNO EMP_FNAME       EMP_LNAME         EMP_DEPT
#--------- --------------- --------------- ----------
#   127323 Michale         Robbin                  57
#   526689 Carlos          Snares                  63
#   843795 Enric           Dosio                   57
#   328717 Jhon            Snares                  63
#   444527 Joseph          Dosni                   47
#   659831 Zanifer         Emily                   47
#   847674 Kuleswar        Sitaraman               57
#   748681 Henrey          Gabriel                 47
#   555935 Alex            Manuel                  57
#   539569 George          Mardy                   27
#   733843 Mario           Saule                   63
#   631548 Alan            Snappy                  27
#   839139 Maria           Foster                  57 
#Sample Output:

#emp_dept		count
#27			2
#57			5
#47			3
#63			3

SELECT emp_dept, COUNT(*) FROM emp_details GROUP BY emp_dept;


