# Project 1 Presentation

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



First we asked ourselves **sample questions** by looking at the datasets and observing what information we could glean from it.

## Sample questions

- 5 top rated movies per genre?
- What are the highest grossing films per year?
- How does the highest rating change over time?
- What is the average rating over a given time period and how does that change?
- Top 10 of each genre?


We then created tables in our Hive database by loading in the dataset into the database and using the `CREATE TABLE` command and including the table's schema.

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
SELECT u_data.movieid, SUM (u_data.rating) AS rating FROM u_data GROUP BY u_data.movieid ORDER BY u_data.movieid DESC;
```

### Query 2 which Brandon be presenting: 

```
SELECT u_data.movieid, SUM (u_data.rating) AS rating FROM u_data GROUP BY u_data.movieid ORDER BY u_data.movieid ASC;
```

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
SUM(u_item.genre_western) AS western FROM u_item ORDER BY DESC;
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

The top genres are Drama (725), Comedy (505), and Action and Thriller (tied at 251). The least most popular genres are Unknown (2), Fantasy (22) and Film Noir (27). Films that are customers are most likly to purchase are probably tied to the Drama, Comedy and Action/Thriller genres..



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
