SELECT * 
FROM sql_store.customers
WHERE (address LIKE '%AVENUE%' OR address LIKE '%TRAIL%') AND phone regexp '^80*'
-- Using LIKE and regexp Returns only customers who have avenue or trail in their address   AND that have a phone number that starts with 80.
;

SELECT * 
FROM sql_store.customers
WHERE birth_date regexp '^1986|^1974|.+30'
-- Returns only customers who match a regex expression.  They have a birth_date beginning in 1986, or 1974 or ending in 30.
;

SELECT * 
FROM sql_store.customers
;

