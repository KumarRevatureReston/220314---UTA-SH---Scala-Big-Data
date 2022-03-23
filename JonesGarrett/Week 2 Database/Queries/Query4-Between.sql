SELECT *
FROM sql_store.customers
WHERE birth_date BETWEEN  '1986-01-01' and '1996-01-01'
ORDER BY birth_date