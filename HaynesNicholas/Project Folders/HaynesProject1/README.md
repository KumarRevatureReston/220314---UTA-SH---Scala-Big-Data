
# PROJECT ONE

## Getting started

1. First clone the repo. `git clone https://github.com/Lonestar137/scsv.git`

2. Import the build using metals. `sbt bloopInstall`

3. Then: `sbt run`

### Logging in

If everything installed correctly, a `query` prompt should appear.

To perform any database operations, type `login`.  You will then be prompted to connect to a database. If you want to connect to Hive, or another server refer to the remote server section. 
Provide your `database name`, `user`, and `pass`. 
You can swap databases at anytime via the same method.

### Logging into remote servers and/or Hive

When you type login, you will first be asked to input the server you would like to connect to, by default it will look for a locally hosted PSQL session but you can also use other servers and Hive.  
To do so, you can log into a remote server with the following syntax `jdbc:<driver>://<ipofserver>:<port>/`.

### Selecting

You can select from a database by using the `SELECT` keyword.  Just type your query as you would in SQL to get the output.

NOTE: the `outputGovernor` limits the number of lines returned by the `SELECT` keyword.  You can change this like so: `set outputGovernor 100`, the governor will now return 100 lines of text instead of the default 10. 
Be aware that increasing this number will lower performance, especially on large queries.

### INSERTING, DELETING, UPDATING, etc. . .

These commands will work the same as they do in PSQL. Enter them however you like to perform these commands.

### Importing

#### Importing a single CSV

In the console type:  
`import /absolute/path/to/file.csv`

If the path is correct, you will be prompted to enter the CSV file column datatypes.  You can also define columns to have `DEFAULT` values, `NOT NULL`, etc . . .  The default column datatype is `VARCHAR`.  So, if you just hit enter on a column without typing 
anything, the column will be created as `VARCHAR`.

#### Bulk imports

It is possible to import multiple csv files at once.
1. First, store all your .CSV files in the `scsv/src/main/scala/csv` folder.  The program looks here by default for bulk imports, this value can be changed via set in future versions.  
2. To do so, type `import all`.   
3. You will then be prompted to enter the column datatypes.  The first column value is provided for quick reference.




SELECT DISTINCT ratings.movieid, ratings.rating, movies.title, movies.genres FROM ratings INNER JOIN movies ON ratings.movieid=movies.movieid WHERE ratings.rating >= 5 AND movies.genres = 'Action|Comedy' order by ratings.movieid
