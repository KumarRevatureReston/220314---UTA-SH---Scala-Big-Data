

## Getting started

1. First clone the repo. `git clone https://github.com/Lonestar137/scsv.git`

2. Import the build using metals. `sbt bloopInstall`

3. Then: `sbt run`

### Logging in

If everything installed correctly, a `query` prompt should appear.

IMAGE

To perform any database operations, type `login`.  You will then be prompted to connect to a database. Provide your `database name`, `psql user`, and `psql pass`. 
You can swap databases at anytime via the same method.

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





