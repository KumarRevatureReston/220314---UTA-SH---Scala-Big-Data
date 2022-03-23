SELECT * FROM sql_store.customers
WHERE ( birth_date >= '1991-01-01' OR points > 1000 ) AND NOT state = 'MA'

;