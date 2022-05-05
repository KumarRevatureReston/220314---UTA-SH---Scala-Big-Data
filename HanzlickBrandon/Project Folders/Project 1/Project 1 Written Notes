# Project 1 Notes (Our version with annotations)

## Notes from Jacob and Dan

### At the very start of the presentation
<font color="#5cb85c ">

- introduce ourselves and introduce the project
- state the purpose of our project
- talk briefly about the data, the fields that it has
- is all this data regarding movies (be very brief)
- mention in broad terms what the query is doing

</font>


#### Also we must
<font color="#5cb85c ">

- Demonstate all of the queries
- The things we say must not feel pointless
- When presenting the queries explain what it does and why it's important
- Get the output and make a prediction or statement regarding what this information is useful for

</font>


### Mr. Kumar's Questions

**How big is the data set?**

Movielens dataset background

> 943 users
> 1682 items
> 100000 ratings

**What are the business problems we are trying to solve?**

> Highest rated movies should be in the store
> Lowest rated movies should not be in the store
> We should provide our customers with the right product(s), in this case the most purchased movies
> Fulfill our customers interest by keeping in stock genre of movies are customers are most interested in

**What are the queries that you ran?**
(see blow)

***Interpretation of the output?***
(see below)


## Project Outline

```
Topic: Analyze MovieLens data
Dataset: http://grouplens.org/datasets/
	Use the ml-100k.zip file dataset.

Problem Statement:
Import csv data about movies and their ratings into HDFS, then create tables from the imported files in Hive.
Once imported, create queries to analyze and display data about the movies and their ratings. 

Example Queries to analyze:
1.Display first 5 entries from movies table

SELECT * FROM u_data LIMIT 10;

2.Count number of unique movies

SELECT COUNT(DISTINCT(u_data.movieid)) FROM u_data;

3.Which movie received the highest number of ratings

SELECT u_data.movieid, SUM(u_data.rating) AS rating FROM u_data GROUP BY u_data.movieid ORDER BY u_data.movieid DESC;

4.Top 25 most rated movies etc.

Step 1: Verify the Dataset [https://grouplens.org/datasets/movielens/]
Step 2: Load Data into HDFS [https://cloudxlab.com/assessment/displayslide/326/hive-movielens-assignment]
Step 3: Create tables in Apache Hive
Step 4: Load data into Hive table
Step 5: Query to analyze and display the result [https://github.com/Crone1/Pig-and-Hive-MovieLens-Analysis/blob/main/Hive_movieLens_analysis.hive]

Ref Links: https://www.youtube.com/watch?v=4tW9HY0Q460
https://github.com/Crone1/Pig-and-Hive-MovieLens-Analysis/blob/main/Hive_movieLens_analysis.hive
https://towardsdatascience.com/getting-started-with-hive-ad8a93862f1a
https://medium.com/@notesharsha/13-steps-to-import-data-into-hive-from-your-local-drive-using-ambari-sandbox-hiveql-bonus-a44bffae89d7

```

<div style="background-color: #EEE; padding: 10px; border-radius: 5px;">

First we asked ourselves sample questions by looking at the datasets and observing what information we could glean from it.

</div>

## Sample questions

- 5 top rated movies per genre?
- What are the highest grossing films per year?
- How does the highest rating change over time?
- What is the average rating over a given time period and how does that change?
- Top 10 of each genre?

<div style="background-color: #EEE; padding: 10px; border-radius: 5px;">

We then created tables in our Hive database by loading in the dataset into the database and using the `CREATE TABLE` command and including the table's schema.

</div>

Helpful link: https://cloudxlab.com/assessment/displayslide/326/hive-movielens-assignment

## Loading the Data table schema
```
# copy item table data to /user/hive
hadoop fs -cp /data/ml-100k/u.data /user/hive

# confirm data was copies
hdfs dfs -ls /user/hive

# run hive
hive

# use the hive database (in hive mode)
use hive;

# optional
# DROP TABLE IF EXISTS u_data;

# create the item table
CREATE TABLE IF NOT EXISTS u_data( 
    userid INT, 
    movieid INT, 
    rating INT, 
    unixtime TIMESTAMP
    )
ROW FORMAT DELIMITED
FIELDS TERMINATED BY '\t'
STORED AS TEXTFILE;

# load data into the table from u.item
LOAD DATA INPATH 'hdfs:///user/hive/u.data' overwrite into table u_data;
```

## Loading the Item table schema
```
# copy item table data to /user/hive
hadoop fs -cp /data/ml-100k/u.item /user/hive

# confirm data was copies
hdfs dfs -ls /user/hive

# run hive
hive

# use the hive database (in hive mode)
use hive;

# optional if you made a mistake creating it
# DROP TABLE IF EXISTS u_item;

# create the item table
CREATE TABLE IF NOT EXISTS u_item(movieid INT, movietitle STRING, releasedate STRING, videoreleasedate STRING, imdburl STRING,
genre_unknown INT,
genre_action INT,
genre_adventure INT,
genre_animation INT,
genre_childrens INT,
genre_comedy INT,
genre_crime INT,
genre_documentary INT,
genre_drama INT,
genre_fantasy INT,
genre_filmnoir INT,
genre_horror INT,
genre_musical INT,
genre_mystery INT,
genre_romance INT,
genre_scifi INT,
genre_thriller INT,
genre_war INT,
genre_western INT)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY '|'
STORED AS TEXTFILE;

# load data into the table from u.item
LOAD DATA INPATH 'hdfs:///user/hive/u.item' overwrite into table u_item;
```


## Queries

### Query 1 which Brandon be presenting: 

**What are the queries that you ran?**

```
SELECT u_data.movieid, SUM(u_data.rating) AS rating, u_item.movietitle FROM u_data INNER JOIN u_item ON u_data.movieid=u_item.movieid GROUP BY u_data.movieid, u_item.movietitle ORDER BY rating DESC LIMIT 30;
```

**Highest rated movies accoring to our database**
| Total Rated  | Movie title |
| ------------- | ------------- |
| 2541  | Star Wars (1977)  |
| 2111  | Fargo (1986)  |
| 2032  | Return of the Jedi (1986)  |
| 1936  | Contact (1997)  |
| 1786  | Raiders of the Lost Ark (1981)  |
| 1769  | Godfather, The (1972)  |
| 1759  | English Patient, The (1996)  |
| 1753  | Toy Story (1995)  |
| 1673  | Silence of the Lambs, The (1991)  |
| 1645  | Scream (1996)  |

**Interpretation of the output?**

Here is a list of the highest rated movies listed, so it would be good to have these in stock with their various editions and remakes to appeal to fans and new audiences alike. There are more listings in the query but the first 10 are listed here.

**Improvements?**

The highest number of reviews doesn't necessarily mean the highest rated in this case. If more people review a movie then it will have more ratings and thus a higher score. I would in the future figure out a way to average those values so that I could figure out the highest average rating instead of the highest total rating.

### Query 2 which Brandon be presenting: 

```
SELECT u_data.movieid, SUM(u_data.rating) AS rating, u_item.movietitle FROM u_data INNER JOIN u_item ON u_data.movieid=u_item.movieid GROUP BY u_data.movieid, u_item.movietitle ORDER BY rating ASC LIMIT 30;
```

**Lowest rated movies accoring to our database**
| Total Rated  | Movie title |
| ------------- | ------------- |
| 1  | Bloody Child, The (1996)  |
| 1  | Further Gesture, A (1996)  |
| 1  | T-Men (1947)  |
| 1  | August (1996)  |
| 1  | Homage (1995)  |
| 1  | Hedd Wyn (1992)  |
| 1  | Very Natural Thing, A (1974)  |
| 1  | Mat' i syn (1997)  |
| 1  | Wend Kuuni (God's Gift) (1982)  |
| 1  | Liebelei (1933)  |

**Interpretation of the output?**

Here is a list of the lowest rated movies listed, so it would be good to avoid stocking these. There are more listings in the query but the first 10 are listed here.

**Improvements?**

Similar to the above, the lowest total rating and the lowest average rating are different, so a low rating could mean that people rated it low, or not a lot of people rated it, so finding the average might provide us with more insight about customer preferences than the total.


### Query 3 which Melissa will be presenting

**What are the queries that you ran?**

```
SELECT * FROM u_item ORDER BY SUBSTRING(u_item.releasedate,-4) DESC LIMIT 30;
```


**The most recent movies are listed below**

| Release Year  | Movie title |
| ------------- | ------------- |
| 1998  | Apt Pupil  |
| 1998  | B. Monkey  |
| 1998  | Truman Show, The  |
| 1998  | Wag the Dog  |
| 1998  | Sphere  |
| 1998  | Nil By Mouth  |
| 1998  | Desperate Measures  |
| 1998  | Sliding Doors |
| 1998  | Wedding Singer, The  |
| 1998  | Replacement Killers, The  |
| 1998  | Half Baked  |
| 1998  | Newton Boys  |
| 1998  | Lost in Space  |
| 1998  | Four Days in September  |
| 1998  | Lost in Space  |
| 1998  | Four Days in September  |
| 1998  | Love and Death on Long Island  |
| 1998  | Hard Rain |
| 1998  | Prophecy II, The  |
| 1998  | Deep Rising  |
| 1998  | Blues Brothers 2000 |
| 1998  | Dark City |
| 1998  | Phantoms |
| 1998  | Great Expectations |
| 1998  | Twilight  |
| 1998  | U.S. Marshalls  |
| 1998  | Wild Things  |
| 1998  | Primary Colors  |
| 1998  | Mercury Rising  |
| 1998  | City of Angels  |
| 1998  | Firestorm  |

**Interpretation of the output?**

Here is a list of movies for the most current year 1998. At store #3775 there is a "New Releases" section and it would be good to carry all of the most recent releases here, making sure that they are in stock and available to customers.

**Improvements?**

I noticed that there was a duplicate entry (Desperate Measures) here which I omitted, so I would find a way to remove the duplicate entries and ensure the integrity of my data from within the query if given more time, considering that this might affect something like order quantity (like twice as much product being ordered).

### Query 4 which Melissa be presenting: 

**What are the queries that you ran?**

```
SELECT SUM(u_item.genre_unknown) AS unknown, 
SUM(u_item.genre_action) AS action,
SUM(u_item.genre_adventure) AS adventure,
SUM(u_item.genre_animation) AS animation,
SUM(u_item.genre_childrens) AS childrens,
SUM(u_item.genre_comedy) AS comedy,
SUM(u_item.genre_crime) AS crime,
SUM(u_item.genre_documentary) AS documentary,
SUM(u_item.genre_drama) AS drama,
SUM(u_item.genre_fantasy) AS fantasy,
SUM(u_item.genre_filmnoir) AS filmnoir,
SUM(u_item.genre_horror) AS horror,
SUM(u_item.genre_musical) AS musical,
SUM(u_item.genre_mystery) AS mystery,
SUM(u_item.genre_romance) AS romance,
SUM(u_item.genre_scifi) AS scifi,
SUM(u_item.genre_thriller) AS thriller,
SUM(u_item.genre_war) AS war,
SUM(u_item.genre_western) AS western FROM u_item;
```


**Movie Totals are listed below in tabular format**

| Genre  | Number of Movies |
| ------------- | ------------- |
| Unknown  | 2  |
| Action  | 251  |
| Adventure  | 135  |
| Animation  | 42  |
| Childrens  | 122  |
| Comedy  | 505  |
| Crime  | 109  |
| Documentary  | 50  |
| Drama  | 725  |
| Fantasy  | 22  |
| Film Noir  | 24  |
| Horror  | 92 |
| Musical  | 56  |
| Mystery  | 61  |
| Romance  | 247  |
| Scifi  | 101  |
| Thriller  | 251  |
| War  | 71  |
| Western  | 27  |


**Interpretation of the output?**

The top genres are Drama (725), Comedy (505), and Action and Thriller (tied at 251). The least most popular genres are Unknown (2), Fantasy (22) and Film Noir (27). Films that are customers are most likely to purchase are probably tied to the Drama, Comedy and Action/Thriller genres.

**Improvements?**

I would like to find a way to incorporate the top rated results per genre into my query, so that I can find the top 10 results in each genre by changing the field of my query. This would provide additional insight into what movies within the genres are more popular than other movies in that same genre.

## Additional Notes

We attempted to use the hive-jdbc connector package with Scala but were not able to get it to work, and are thus omiting that portion of the project and code.

### At the very end of the presentation - 
<font color="#5cb85c ">

- mention improvements that we would add if we had extra time (it we will be asked if it is not stated)

- If we can't do a live demonstration have snapshots of our output as a backup

</font>

## CITATION

```
CITATION
==============================================

To acknowledge use of the dataset in publications, please cite the
following paper:

F. Maxwell Harper and Joseph A. Konstan. 2015. The MovieLens Datasets:
History and Context. ACM Transactions on Interactive Intelligent
Systems (TiiS) 5, 4, Article 19 (December 2015), 19 pages.
DOI=http://dx.doi.org/10.1145/2827872

ACKNOWLEDGEMENTS
==============================================

Thanks to Al Borchers for cleaning up this data and writing the
accompanying scripts.

PUBLISHED WORK THAT HAS USED THIS DATASET
==============================================

Herlocker, J., Konstan, J., Borchers, A., Riedl, J.. An Algorithmic
Framework for Performing Collaborative Filtering. Proceedings of the
1999 Conference on Research and Development in Information
Retrieval. Aug. 1999.

FURTHER INFORMATION ABOUT THE GROUPLENS RESEARCH PROJECT
==============================================

The GroupLens Research Project is a research group in the Department
of Computer Science and Engineering at the University of Minnesota.
Members of the GroupLens Research Project are involved in many
research projects related to the fields of information filtering,
collaborative filtering, and recommender systems. The project is lead
by professors John Riedl and Joseph Konstan. The project began to
explore automated collaborative filtering in 1992, but is most well
known for its world wide trial of an automated collaborative filtering
system for Usenet news in 1996.  The technology developed in the
Usenet trial formed the base for the formation of Net Perceptions,
Inc., which was founded by members of GroupLens Research. Since then
the project has expanded its scope to research overall information
filtering solutions, integrating in content-based methods as well as
improving current collaborative filtering technology.

Further information on the GroupLens Research project, including
research publications, can be found at the following web site:
        
        http://www.grouplens.org/

GroupLens Research currently operates a movie recommender based on
collaborative filtering:

        http://www.movielens.org/

```
