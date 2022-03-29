SELECT * FROM countries WHERE REGION_ID IN (2, 3) ORDER BY REGION_ID DESC;
SELECT AVG(REGION_ID) avg_region_id
FROM countries WHERE REGION_ID in (2,3 ); -- returns 2.5 in a new column: avg_region_id

SELECT MIN(REGION_ID) min_region_id
FROM countries WHERE REGION_ID in (2,3 ); -- Returns 2 in a new column: min_region_id

SELECT MAX(REGION_ID) max_region_id
FROM countries WHERE REGION_ID in (2,3); -- returns 3

SELECT COUNT(REGION_ID) count_region_id
FROM countries WHERE REGION_ID in (2,3); -- returns the number of fields that were selected.  

-- foreign key links one table to another
