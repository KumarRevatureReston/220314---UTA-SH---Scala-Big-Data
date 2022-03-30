## Project 1
- Project 1 will be a Scala console application that is retrieving data using Hive or MapReduce. Your job is to build a real-time news analyzer. This application should allow users to view the trending topics (e.g. all trending topics for news related to "politics", "tv shows", "movies", "video games", or "sports" only [choose one topic for project]).
- You must present a project proposal to trainer and be approved before proceeding with project. 

### MVP:
- ALL user interaction must come purely from the console application
- Hive/MapReduce must:
    - scrap data from datasets from an API based on your topic of choice
- Your console application must:
    - query data to answer at least 6 analysis questions of your choice
    - have a login system for all users with passwords
        - 2 types of users: BASIC and ADMIN
        - Users should also be able to update username and password
- implement all CRUD operations
- implement bucketing, and partitioning
- can use hive with screenshots but make as program in 
    IntelliJ (or VSCode) too with appropriate dependencies

### Stretch Goals:
- Passwords must be encrypted
- Export all results into a JSON file/ can optional because(changes done)
- find a trend

### Presentations
- You will be asked to run an analysis using the console application on the day of the presentation, so be prepared to do so.
- We'll have 5-10 minutes a piece, so make sure your presentation can be covered in that time, focusing on the parts of your analysis you find most interesting.

### Technologies
- Hadoop MapReduce
- YARN(by default) 
- HDFS
- Scala 2.11 (or 2.12)
- Hive
- Git + GitHub

### Due Date
- Presentations will take place on Thursday, 12/30.