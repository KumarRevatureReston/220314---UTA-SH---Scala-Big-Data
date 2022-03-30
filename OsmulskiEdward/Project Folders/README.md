The data was uploaded from the airports csv file from https://ourairports.com/data/. The file can be found in the data folder.
The original csv file was unable to be uploaded directly to PostgreSQL, so the only way to upload it was to format each argument that came from it through the scala program.

I wasn't able to create a command line interface that worked properly in the time allotted.
The program should be able to create tables, insert data, read from the PostgreSQL table with constraints, Update table values, and Delete table records.

proof the table uploaded, queries that were processed, and sample outputs will be put in the folder screenshots.

UPDATE since I last posted this project:
I have create a progam that take in the same data and uploads it to a database. the link to the file can be found above and in the data folder.

I have created a command line interface that takes in basic inputs. The program now creates a new table, flights, within the database and populates it with records created from user input that amount to a flight scheduler. The inputs return the scheduled flights id, origin, longitudes, and latitudes, departure time, journey time, and estimated time of arrival.
