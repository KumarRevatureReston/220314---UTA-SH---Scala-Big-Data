# Analyze Movielens Data

## Project Description

MovieLens data sets were collected by the GroupLens Research Project at the University of Minnesota. This data set consists of:
* 100,000 ratings (1-5) from 943 users on 1682 movies.
* Each user has rated at least 20 movies.
* Simple demographic info for the users (age, gender, occupation, zip)

## Technologies Used

* Scala
* Hive
* Postgres
* Git

## Features

Queries Performed:

1. What are the Users with the highest average rating for a specific year (1993)?
SELECT user_id, avg_rating FROM ( SELECT user_id, CAST(AVG(rating) AS DECIMAL(10,2)) AS avg_rating FROM ratings INNER JOIN movies ON ratings.movie_id = movies.movie_id WHERE movies.release_date RLIKE '.*(1993).*' GROUP BY user_id) tmp ORDER BY avg_rating DESC LIMIT 25


2. Get top 25 ranking movies for the year (1993)?
   SELECT movie_title, CAST(AVG(rating) AS DECIMAL(10,2)) AS avg_rating FROM ratings INNER JOIN movies ON ratings.movie_id = movies.movie_id WHERE movies.release_date RLIKE '.*(1993).*' GROUP BY ratings.movie_id, movie_title ORDER BY avg_rating DESC LIMIT 25


3. Top 25 rated movies having at least 100 views?
   SELECT movie_title, avg_rating, views FROM (SELECT movie_title, CAST(AVG(rating) AS DECIMAL(10,2)) AS avg_rating, COUNT(rating) AS views FROM ratings INNER JOIN movies ON ratings.movie_id = movies.movie_id GROUP BY ratings.movie_id, movie_title ) tmp WHERE views >= 100 GROUP BY movie_title, avg_rating, views ORDER BY avg_rating DESC, views DESC LIMIT 25


## Getting Started

Clone repo and edit the name of your path for download location and database login.

## Usage

run (SQL command)

## Contributors

Jason McClintock
Jessica Hori
Shawn Sampson

## License

This project uses the following license: GNU General Public License v3.0. https://www.gnu.org/licenses/gpl-3.0.en.html
