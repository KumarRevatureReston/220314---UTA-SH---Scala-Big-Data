
-- 1. Write a query to get Product name and quantity/unit. Go to the editor
SELECT name,quantity_in_stock FROM products;

-- 2. Write a query to get current Product list (Product ID and name). Go to the editor
SELECT product_id,name FROM products;

-- 3. Write a query to get discontinued Product list (Product ID and name). Go to the editor
SELECT product_id,name FROM products WHERE discontinued=TRUE;

-- 4. Write a query to get most expense and least expensive Product list (name and unit price).
SELECT name,MAX(unit_price) "Most Expensive",MIN(unit_price) "Least Expensive" FROM products; 

-- 5. Write a query to get Product list (id, name, unit price) where current products cost less than $20. 
SELECT product_id,name,unit_price WHERE unit_price<20;

-- 6. Write a query to get Product list (id, name, unit price) where products cost between $15 and $25.
SELECT product_id,name,unit_price WHERE unit_price>15 AND unit_price<25;

-- 7. Write a query to get Product list (name, unit price) of above average price.
SELECT name,unit_price FROM products WHERE unit_price>(SELECT AVG(unit_price) from products);

-- 8. Write a query to get Product list (name, unit price) of ten most expensive products. 
SELECT name,unit_price FROM products ORDER BY unit_price DESC LIMIT 10;

-- 9. Write a query to count current and discontinued products. 
SELECT COUNT(name) FROM products GROUP BY discontinued;

-- 10. Write a query to get Product list (name, units on order , units in stock) of stock is 
-- less than the quantity on order. 
SELECT name,units_on_order,units_in_stock FROM products WHERE(units_in_stock<units_on_order);