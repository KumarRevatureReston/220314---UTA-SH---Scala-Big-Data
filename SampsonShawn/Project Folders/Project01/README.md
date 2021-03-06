Project 01

Purpose: To Demonstrate Data Retrieval and Usage

Sample Data: MovieLens Data Set

The data was collected through the MovieLens web site
(movielens.umn.edu) during the seven-month period from September 19th,
1997 through April 22nd, 1998. This data has been cleaned up - users
who had less than 20 ratings or did not have complete demographic
information were removed from this data set.

Queries Performed:

1. What are the Users with the highest average rating for a specific year (1993)?
SELECT user_id, avg_rating FROM ( SELECT user_id, CAST(AVG(rating) AS DECIMAL(10,2)) AS avg_rating FROM ratings INNER JOIN movies ON ratings.movie_id = movies.movie_id WHERE movies.release_date RLIKE '.*(1993).*' GROUP BY user_id) tmp ORDER BY avg_rating DESC LIMIT 25


2. Get top 25 ranking movies for the year (1993)?
   SELECT movie_title, CAST(AVG(rating) AS DECIMAL(10,2)) AS avg_rating FROM ratings INNER JOIN movies ON ratings.movie_id = movies.movie_id WHERE movies.release_date RLIKE '.*(1993).*' GROUP BY ratings.movie_id, movie_title ORDER BY avg_rating DESC LIMIT 25


3. Top 25 rated movies having at least 100 views?
   SELECT movie_title, avg_rating, views FROM (SELECT movie_title, CAST(AVG(rating) AS DECIMAL(10,2)) AS avg_rating, COUNT(rating) AS views FROM ratings INNER JOIN movies ON ratings.movie_id = movies.movie_id GROUP BY ratings.movie_id, movie_title ) tmp WHERE views >= 100 GROUP BY movie_title, avg_rating, views ORDER BY avg_rating DESC, views DESC LIMIT 25