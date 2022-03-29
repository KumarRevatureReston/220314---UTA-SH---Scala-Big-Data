#1
SELECT SUM(purch_amt) FROM orders; 
#2
SELECT AVG(purch_amt) FROM orders; 
#3
SELECT COUNT(DISTINCT salesman_id) FROM orders;
#4
SELECT COUNT(cust_name) FROM customer;
#5 - under the assumption that graduation was intended to mean grade for this question
SELECT COUNT(grade) FROM customers;
#6
SELECT MAX(purch_amt) FROM orders;
#7
SELECT MIN(purch_amt) FROM orders;
#8
SELECT city,MAX(grade) FROM customers
GROUP BY city;
#9
SELECT customer_id, MAX(purch_amt) FROM orders
GROUP BY customer_id;
#10
SELECT customer_id, ord_date, MAX(purch_amt) FROM orders
GROUP BY ord_date;
#11
SELECT salesman_id, MAX(purch_amt) FROM orders
WHERE ord_date = '2012-08-17'
GROUP BY salesman_id;
#12
SELECT customer_id, MAX(purch_amt),ord_date FROM orders
WHERE MAX(purch_amt) >2000
GROUP BY ord_date,customer_id;
#13
SELECT customer_id,ord_date, MAX(purch_amt) FROM orders
GROUP BY customer_id, ord_date
HAVING MAX(purch_amt) BETWEEN 2000 AND 6000;
#14
SELECT customer_id,ord_date, MAX(purch_amt) FROM orders
GROUP BY customer_id, ord_date
HAVING MAX(purch_amt) IN (2000, 3000, 5760, 6000);
#15
SELECT customer_id,MAX(purch_amt) FROM orders
WHERE customer_id BETWEEN 3002 AND 3007
GROUP BY customer_id;
#16
SELECT customer_id,MAX(purch_amt) FROM orders
WHERE customer_id BETWEEN 3002 AND 3007
GROUP BY customer_id
HAVING MAX(purch_amt) >1000;
#17
SELECT salesman_id,MAX(purch_amt) FROM orders
GROUP BY salesman_Id
HAVING salesman_id BETWEEN 5003 AND 5008;
#18
SELECT COUNT(ord_no) FROM orders
WHERE ord_date = '2012-08-17';
#19
SELECT COUNT(*) FROM salesman
WHERE city IS NOT NULL;
#20
SELECT salesman_id,ord_date,COUNT(*) FROM orders
GROUP BY salesman_id, ord_date;
#21
SELECT AVG(PRO_PRICE) as average_product_price FROM item_mast;
#22
SELECT COUNT(*) AS Number_of_Products FROM item_mast
WHERE PRO_PRICE >= 350;
#23
SELECT AVG(PRO_PRICE),PRO_COM FROM item_mast
GROUP BY PRO_COM;
#24
SELECT SUM(DPT_ALLOTMENT) as 'Total Departmental Allotment' FROM emp_department;
#25
SELECT emp_dept, COUNT(*) FROM emp_details
GROUP BY emp_dept;













