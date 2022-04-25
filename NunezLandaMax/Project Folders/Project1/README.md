# Analyze MovieLens data-P1
## Max Julian Landa Nunez
## Mohammad Aydin

> # 1. Analyze Movielens Project

Application movielens created in Scala programming language connected to Hive with the help of JDBC library.
We are creating this project for Revature movies company who needs an evaluation on their movies rating system, so they provided us  a dataset  :

1-What is the Title of the Top-rated Action and Comedy movie?
*SELECT movieid,title,COUNT(rating) count_rat FROM (SELECT r.movieid as movieid,userid,rating,title,genres FROM ratings r INNER JOIN movies m ON r.movieid=m.movieid WHERE array_contains(genres,'Comedy') AND array_contains(genres,'Action')) m GROUP BY movieid,title ORDER BY count_rat DESC LIMIT 1;*

2-What is the User with the highest average rating for a specific year?
*SELECT u.userid, u.age, x.avg from users u join (SELECT r.userid,avg(rating) avg FROM (SELECT r.movieid,userid,rating,title FROM ratings r INNER JOIN movies m ON r.movieid=m.movieid WHERE title LIKE "%1995%") r GROUP BY (r.userid) ORDER BY avg DESC LIMIT 1)x WHERE u.userid = x.userid;*

3-Get top 10 ranking movies for the year ?
*SELECT title,avg_rat FROM(SELECT movieid,AVG(rating) as avg_rat FROM ratings GROUP BY movieid) AS avg_mov INNER JOIN movies ON avg_mov.movieid=movies.movieid WHERE title LIKE('%(2000)%') ORDER BY avg_rat DESC LIMIT 10;*

4-Top 25 rated movies having at least 50 views
*SELECT title FROM(SELECT t.movieid,avg(rating) as avg_rat FROM(SELECT COUNT(*) as count,movieid FROM ratings GROUP BY movieid HAVING count>50)t INNER JOIN ratings ON ratings.movieid=t.movieid GROUP BY t.movieid ORDER BY avg_rat DESC)q INNER JOIN movies ON movies.movieid=q.movieid LIMIT 25;*

# 2.	Basic functionality
After investing a lot in action and comedy movies the company needs an accurate evaluation based on customers rating. Based on the projects results the company would have a better idea about what customers highest rating  so the company can focus more on producing movies with the same concept.

The company working on a bonus program for loyal customers. Based on the results of this question the company would reward customers with highest rating and work more on advertising for customers who show less interest

Its very important for the company to specify the top 10 movies so they would suggest it for new customers , keep it on the top of the list and show them in advertisements

Rating would be not accurate in case of few ratings. our aim is to find top rated movies with specific number of views . That way they can make statistics about what movies made more profit 


 
