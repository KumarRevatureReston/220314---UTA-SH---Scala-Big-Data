-- 1. Write a SQL query to display all the documents in the collection restaurants.
SELECT * FROM restaurants;

-- 2. Write a SQL query to display the fields restaurant_id, name, borough 
-- and cuisine for all the documents in the collection restaurant.
SELECT restaurant_id, name, borough, cuisine FROM restaurants;

-- 3 Write a SQL query to display the fields restaurant_id, name, borough 
-- and cuisine, but exclude the field _id for all the documents in the 
-- collection restaurant.
SELECT restaurant_id,borough,cousine FROM restaurants;
-- 4 Write a SQL query to display the fields restaurant_id, name, borough 
-- and zip code, but exclude the field _id for all the documents in the 
-- collection restaurant.
SELECT restaurant_id,name,borough,address.zip FROM restaurants;

-- 5 Write a SQL query to display all the restaurant which is in the borough 
-- Bronx.
SELECT * FROM restaurants WHERE borough='Bronx';

-- 6. Write a SQL query to display the first 5 restaurant which is 
-- in the borough Bronx.
SELECT * FROM restaurants WHERE borough='Bronx' LIMIT 5;

-- 7.Write a SQL query to display the next 5 restaurants after skipping first 5 
-- which are in the borough Bronx.
SELECT * FROM restaurants WHERE borough='Bronx' LIMIT 5 offset 3;

-- 8. Write a SQL query to find the restaurants who achieved a 
-- score more than 90.
SELECT * FROM restaurants WHERE grades.score>90;

-- 9. Write a SQL query to find the restaurants that achieved a score, more 
-- than 80 but less than 100.
SELECT * FROM restaurants WHERE grades.score>80 AND grade.score<100;

-- 10. Write a SQL query to find the restaurants which locate in latitude 
-- value less than -95.754168
SELECT * FROM restaurants WHERE latitude<-95.754168;

-- 11. Write a SQL query to find the restaurants that do not prepare any cuisine 
-- of 'American' and their grade score more than 70 and latitude less 
-- than -65.754168.
SELECT * FROM restaurants WHERE cousine<>"American" AND grade.score>70 AND latitude<-95.754168;

-- 12. Write a SQL query to find the restaurants which do not prepare any 
-- cuisine of 'American' and achieved a score more than 70 and located in the 
-- longitude less than -65.754168.
-- Note : Do this query without using $and operator.
SELECT * FROM restaurants WHERE cousine<>"American" AND grade.score>70 AND longitude<-65.754168;

-- 13. Write a SQL query to find the restaurants which do not prepare any 
-- cuisine of 'American ' and achieved a grade point 'A' not belongs to the 
-- borough Brooklyn. The document must be displayed according to the cuisine 
-- in descending order.
SELECT * FROM restaurants 
WHERE cuisine<>"American" AND  score.grade="A" AND borough="Brooklyn" ORDER BY cuisine DESC;

-- 14. Write a SQL query to find the restaurant Id, name, borough and cuisine 
-- for those restaurants which contain 'Wil' as first three letters for its name.
SELECT restaurant_id,name,borough,cuisine FROM restaurants WHERE name LIKE "Wil%";

-- 15. Write a SQL query to find the restaurant Id, name, borough and cuisine 
-- for those restaurants which contain 'ces' as last three letters for its name.
SELECT restaurant_id,name,borough,cuisine FROM restarants WHERE name LIKE "%ces";

-- 16. Write a SQL query to find the restaurant Id, name, borough and cuisine 
-- for those restaurants which contain 'Reg' as three letters somewhere in its
-- name.
SELECT restaurant_id,name, borough,cuisine FROM restarants WHERE name LIKE "%Reg";

-- 17. Write a SQL query to find the restaurants which belong to the borough 
-- Bronx and prepared either American or Chinese dish.
SELECT * FROM restaurants WHERE  borough="Bronx" AND (cusine="American" OR cuisine="Chinese"; 

-- 18. Write a SQL query to find the restaurant Id, name, borough and cuisine 
-- for those restaurants which belong to the borough Staten Island or Queens or 
-- Bronx or Brooklyn.
SELECT restaurant_id,name, boroug,cuisine FROM resturants WHERE borough IN("Staten Island","Queens","Bronx","Brooklyn");
    
-- 19. Write a SQL query to find the restaurant Id, name, borough and cuisine 
-- for those restaurants which are not belonging to the borough Staten Island 
-- or Queens or Bronxor Brooklyn.
	SELECT restaurant_id,name,borough,cuisine FROM restaurants WHERE borough not IN("Staten Island","Queens","Bronx","Brooklyn");

-- 20. Write a SQL query to find the restaurant Id, name, borough and cuisine 
-- for those restaurants which achieved a score which is not more than 10.
SELECT restaurant_id,name,borough,cuisine FROM restaurants WHERE grades.score<=10;

-- 21. Write a SQL query to find the restaurant Id, name, borough and cuisine 
-- for those restaurants which prepared dish except 'American' and 'Chinees' or 
-- restaurant's name begins with letter 'Wil'.
SELECT restaurant_id,name,borough,cuisine FROM restaurants 
WHERE (cuisine<>"American" AND cuisine<>"Chinese") OR
name LIKE "Wil%";

-- 22. Write a SQL query to find the restaurant Id, name, and grades for those 
-- restaurants which achieved a grade of "A" and scored 11 on an ISODate 
-- "2014-08-11T00:00:00Z" among many of survey dates..
SELECT restaurant_id,name,grades FROM restaurants WHERE grades.grade='A' AND grades.score=11 AND ISODate="2014-08-11T00:00:00Z";


-- 23. Write a SQL query to find the restaurant Id, name and grades for those 
-- restaurants where the 2nd element of grades array contains a grade of "A" and 
-- score 9 on an ISODate "2014-08-11T00:00:00Z".
SELECT restaurant_id,name,grades FROM restaurants WHERE grade='A' AND ISODate="2014-08-11T00:00:00Z";

-- 24. Write a SQL query to find the restaurant Id, name, address and geographical
-- location for those restaurants where 2nd element of coord array contains a 
-- value which is more than 42 and upto 52..
SELECT restaurant_id,name,address,address.cord FROM restarants WHERE address.cord.latitude>42 AND address.cord.latitude<52;

-- 25. Write a SQL query to arrange the name of the restaurants in ascending 
-- order along with all the columns.
SELECT * FROM restaurants ORDER BY name ASC;
SELECT * FROM restaurants;
-- 26. Write a SQL query to arrange the name of the restaurants in descending 
-- along with all the columns.
SELECT * FROM restaurants ORDER BY name DESC;

-- 27. Write a SQL query to arranged the name of the cuisine in ascending 
-- order and for that same cuisine borough should be in descending order.
SELECT * FROM restaurants ORDER BY cuisine ASC,borough DESC;

-- 28. Write a SQL query to know whether all the addresses contains the 
-- street or not.
SELECT addresses FROM restaurants WHERE address<>NULL;

-- 29. Write a SQL query which will select all documents in the restaurants 
-- collection where the coord field value is Double.


-- 30. Write a SQL query which will select the restaurant Id, name and grades 
-- for those restaurants which returns 0 as a remainder after dividing the score
-- by 7.
SELECT restaurant_id,name,grades FROM restaurants WHERE SCORE%7=0;

-- 31. Write a SQL query to find the restaurant name, borough, longitude and 
-- attitude and cuisine for those restaurants which contains 'mon' as three 
-- letters somewhere in its name.
SELECT name,borough,address.coord FROM restaurants WHERE name LIKE "%mon%";

-- 32. Write a SQL query to find the restaurant name, borough, longitude and 
-- latitude and cuisine for those restaurants which contain 'Mad' as first three 
-- letters of its name.
SELECT name, borough,address.coord,cuisine FROM restaurants WHERE name LIKE "Mad%";


