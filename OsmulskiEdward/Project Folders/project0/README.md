Project 0

Demonstrate CRUD operations with Scala and PostgreSQL using JDBC

Data imported from file found here: https://ourairports.com/data/

How to run this app:

1. create a scala project in any IDE

2. copy the scala and build files to project directory

3. update connection to PostgreSQL by changing username, password, and database to upload to

4. find out the absolute path to the data file you are uploading

5. run the scala file through command line or IDE terminal

The command line interface will handle the rest and direct you to the application that has been created.

The program will prompt you for the absolute path to the file. Then it will introduce you to a flight scheduler using the data
from the uploaded table to the database.

The program enables you to update the flight schedule by either creating a record, updating a record, or deleting a record.
It also enables you to view either a single record or the entire table.

Improper inputs will in most cases be handled through custom exception handling and will prompt you with proper inputs.

sample output will be posted in sample_output folder.
