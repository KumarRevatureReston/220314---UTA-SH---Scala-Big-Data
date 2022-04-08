# Revature Training 4/5/2022

Providing questions would be able to give us more options

Kumar's question 

Quiz Friday 11-12 Eastern
Basics of Hadoop and Linux Commands

Data Types

In the numeric types we have integers

**Tiny** int takes 1 byte
**Small** int takes 2 bytes
**Regular** int 4 bytes
**Big** int 8 bytes

Column Types

**Float** - 4 byte
**Double** - 8 byte

Arrays - in HIVE are used the same as Java

`Syntax: ARRAY<data_type>`

Maps - in Hive are similar to Java maps

`Syntax: MAP<primitive_type, data_type>`

Maps are primarily used in MapReduce

Most of the time we deal with integers, strings and floats

```
show tables;

CREATE TABLE test(id INT, Name STRING) ROW FROM AT DELIMITED FIELDS TERMINATED BY '.';

SELECT * FROM test;

describe extended test;

TRUNCATE table test;

DROP table test;

create external table test(id int, name string) row format delimited fields terminated by '.';

SELECT * FROM test;

TRUNCATE table test; -- SemanticException

show databases;


CREATE TABLE state(num int, state string, city string, zipcode int) PARTITIONED BY (city string) ROW FORMAT DELIMITED FIELDS TERMINATED BY '.'; --X

CREATE TABLE AllStates(State string, Abbrev string, Code string, Zipcode int) row format delimited fields terminated by '.';


```

## Indexing

Indexes are pointers to a particular column of a table

- The user has to manually define the index
- Whenever we are creating an index, it means we are *creating a pointer* to a particular column name of table
- Any changes made to the column present in tables are stored using the index value created on the column name

`CREATE INDEX <INDEX_NAME> ON TABLE < TABLE_NAME(column names)>`

e.g.

`CREATE INDEX sample_Index ON TABLE guruhive_internaltable(id)`

We can use `DROP INDEX` when we are done with the index

## Review: DDL | DML | DCL

**DDL - Data Definition Language**
**`CREATE`**, `TRUNCATE`, `ALTER`, `DROP`...

**DML - Data Manipulation Language**
**`UPDATE`** and **`DELETE`** operations

**DCL - Data Control Language**
`GRANT`, `REVOKE`

![SQL Query Types](https://media.geeksforgeeks.org/wp-content/uploads/20210920153429/new.png)

**Specific scenarios for indexing**

- You don't do indexing at the beginning of queries
- Whenever the query execution time is more than you expected you use indexing
- Indexing is used for very large datasets

Whenever we have a quiz the quiz will be on the previous week

**Note:** When ever you do something in HQL make sure it is done properly with show and describe

**Bucketing and Hash Functions**

Work on Project 1
