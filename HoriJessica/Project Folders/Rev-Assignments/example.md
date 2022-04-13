/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
/*------------------------------Read in the data---------------------------------*/
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/

-- Create the table to house the data
CREATE TABLE movies_nd_ratings (movieId INT, title STRING, year INT, genres STRING, userID INT, rating FLOAT, time_stamp INT)
ROW FORMAT DELIMITED FIELDS TERMINATED BY '|';

-- Populate this table with the data
LOAD DATA INPATH 'hdfs://cluster-1-m/user/Owner/output/cleaned_movies_nd_ratings'
OVERWRITE INTO TABLE movies_nd_ratings;


SELECT * FROM movies_nd_ratings
LIMIT 10;

/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
/*-----------------------------Hive Simple Queries-------------------------------*/
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/

/*=====================Most_Rated_Movie==================*/

-- Get the movie with the most ratings given too it
SELECT movieId, title, COUNT(rating) AS num_ratings
FROM movies_nd_ratings
GROUP BY movieId, title
ORDER BY num_ratings DESC
LIMIT 5;


/*=====================Most_Liked_Movie==================*/

-- Return 5 movies with the highest number of ratings that also had an average rating of above 4 stars
SELECT movieId, title, COUNT(rating) AS num_ratings, AVG(rating) AS average_rating
FROM movies_nd_ratings
GROUP BY movieId, title
HAVING average_rating >= 4.0
ORDER BY num_ratings DESC
LIMIT 5;


/*=====================User_With_Highest_Average_Rating==================*/

-- Which user has the highest average rating of all the ratings they gave to the movies
SELECT userID, AVG(rating) as average_rating
FROM movies_nd_ratings
GROUP BY userID
ORDER BY average_rating DESC
LIMIT 5;



/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
/*-----------------------------Hive Complex Queries------------------------------*/
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/

/*=====================Distribution_Of_Ratings==================*/

-- See how many times each star rating was given to a movie
SELECT rating, COUNT(rating) as num_ratings
FROM movies_nd_ratings
GROUP BY rating
ORDER BY rating DESC;



/*=====================Most_Popular_Rating==================*/

-- Find the star rating that was most commonly given
SELECT rating, COUNT(rating) as num_ratings
FROM movies_nd_ratings
GROUP BY rating
ORDER BY num_ratings DESC
LIMIT 1;


/*=====================Distribution_Of_Ratings_Across_Genres==================*/

-- See the number of ratings each genre got
SELECT SUM(CASE WHEN genres LIKE '%Action%' THEN 1 ELSE 0 END) AS num_action_movies
      ,SUM(CASE WHEN genres LIKE '%Adventure%' THEN 1 ELSE 0 END) AS num_adventure_movies
      ,SUM(CASE WHEN genres LIKE '%Animation%' THEN 1 ELSE 0 END) AS num_animation_movies
      ,SUM(CASE WHEN genres LIKE '%Children%' THEN 1 ELSE 0 END) AS num_children_movies
      ,SUM(CASE WHEN genres LIKE '%Comedy%' THEN 1 ELSE 0 END) AS num_comedy_movies
      ,SUM(CASE WHEN genres LIKE '%Crime%' THEN 1 ELSE 0 END) AS num_crime_movies
      ,SUM(CASE WHEN genres LIKE '%Documentary%' THEN 1 ELSE 0  END) AS num_documentaries
      ,SUM(CASE WHEN genres LIKE '%Drama%' THEN 1 ELSE 0 END) AS num_drama_movies
      ,SUM(CASE WHEN genres LIKE '%Fantasy%' THEN 1 ELSE 0 END) AS num_fantasy_movies
      ,SUM(CASE WHEN genres LIKE '%Film-Noir%' THEN 1 ELSE 0 END) AS num_film_noir_movies
      ,SUM(CASE WHEN genres LIKE '%Horror%' THEN 1 ELSE 0 END) AS num_horror_movies
      ,SUM(CASE WHEN genres LIKE '%Musical%' THEN 1 ELSE 0 END) AS num_musical_movies
      ,SUM(CASE WHEN genres LIKE '%Mystery%' THEN 1 ELSE 0 END) AS num_mystery_movies
      ,SUM(CASE WHEN genres LIKE '%Romance%' THEN 1 ELSE 0 END) AS num_romance_movies
      ,SUM(CASE WHEN genres LIKE '%Sci-Fi%' THEN 1 ELSE 0 END) AS num_sci_fi_movies
      ,SUM(CASE WHEN genres LIKE '%Thriller%' THEN 1 ELSE 0 END) AS num_thriller_movies
      ,SUM(CASE WHEN genres LIKE '%War%' THEN 1 ELSE 0 END) AS num_war_movies
      ,SUM(CASE WHEN genres LIKE '%Western%' THEN 1 ELSE 0 END) AS num_western_movies
FROM movies_nd_ratings;

-- See the average rating that each genre got
SELECT SUM(CASE WHEN genres LIKE '%Action%' THEN rating ELSE 0 END) / SUM(CASE WHEN genres LIKE '%Action%' THEN 1 ELSE 0 END) AS avg_rating_in_action_movies
      ,SUM(CASE WHEN genres LIKE '%Adventure%' THEN rating ELSE 0 END) / SUM(CASE WHEN genres LIKE '%Adventure%' THEN 1 ELSE 0 END) AS avg_rating_in_adventure_movies
      ,SUM(CASE WHEN genres LIKE '%Animation%' THEN rating ELSE 0 END) / SUM(CASE WHEN genres LIKE '%Animation%' THEN 1 ELSE 0 END) AS avg_rating_in_animation_movies
      ,SUM(CASE WHEN genres LIKE '%Children%' THEN rating ELSE 0 END) / SUM(CASE WHEN genres LIKE '%Children%' THEN 1 ELSE 0 END) AS avg_rating_in_children_movies
      ,SUM(CASE WHEN genres LIKE '%Comedy%' THEN rating ELSE 0 END) / SUM(CASE WHEN genres LIKE '%Comedy%' THEN 1 ELSE 0 END) AS avg_rating_in_comedy_movies
      ,SUM(CASE WHEN genres LIKE '%Crime%' THEN rating ELSE 0 END) / SUM(CASE WHEN genres LIKE '%Crime%' THEN 1 ELSE 0 END) AS avg_rating_in_crime_movies
      ,SUM(CASE WHEN genres LIKE '%Documentary%' THEN rating ELSE 0  END) / SUM(CASE WHEN genres LIKE '%Documentary%' THEN 1 ELSE 0  END) AS avg_rating_in_documentaries
      ,SUM(CASE WHEN genres LIKE '%Drama%' THEN rating ELSE 0 END) / SUM(CASE WHEN genres LIKE '%Drama%' THEN 1 ELSE 0 END) AS avg_rating_in_drama_movies
      ,SUM(CASE WHEN genres LIKE '%Fantasy%' THEN rating ELSE 0 END) / SUM(CASE WHEN genres LIKE '%Fantasy%' THEN 1 ELSE 0 END) AS avg_rating_in_fantasy_movies
      ,SUM(CASE WHEN genres LIKE '%Film-Noir%' THEN rating ELSE 0 END) / SUM(CASE WHEN genres LIKE '%Film-Noir%' THEN 1 ELSE 0 END) AS avg_rating_in_film_noir_movies
      ,SUM(CASE WHEN genres LIKE '%Horror%' THEN rating ELSE 0 END) / SUM(CASE WHEN genres LIKE '%Horror%' THEN 1 ELSE 0 END) AS avg_rating_in_horror_movies
      ,SUM(CASE WHEN genres LIKE '%Musical%' THEN rating ELSE 0 END) / SUM(CASE WHEN genres LIKE '%Musical%' THEN 1 ELSE 0 END) AS avg_rating_in_musical_movies
      ,SUM(CASE WHEN genres LIKE '%Mystery%' THEN rating ELSE 0 END) / SUM(CASE WHEN genres LIKE '%Mystery%' THEN 1 ELSE 0 END) AS avg_rating_in_mystery_movies
      ,SUM(CASE WHEN genres LIKE '%Romance%' THEN rating ELSE 0 END) / SUM(CASE WHEN genres LIKE '%Romance%' THEN 1 ELSE 0 END) AS avg_rating_in_romance_movies
      ,SUM(CASE WHEN genres LIKE '%Sci-Fi%' THEN rating ELSE 0 END) / SUM(CASE WHEN genres LIKE '%Sci-Fi%' THEN 1 ELSE 0 END) AS avg_rating_in_sci_fi_movies
      ,SUM(CASE WHEN genres LIKE '%Thriller%' THEN rating ELSE 0 END) / SUM(CASE WHEN genres LIKE '%Thriller%' THEN 1 ELSE 0 END) AS avg_rating_in_thriller_movies
      ,SUM(CASE WHEN genres LIKE '%War%' THEN rating ELSE 0 END) / SUM(CASE WHEN genres LIKE '%War%' THEN 1 ELSE 0 END) AS avg_rating_in_war_movies
      ,SUM(CASE WHEN genres LIKE '%Western%' THEN rating ELSE 0 END) / SUM(CASE WHEN genres LIKE '%Western%' THEN 1 ELSE 0 END) AS avg_rating_in_western_movies
FROM movies_nd_ratings;
