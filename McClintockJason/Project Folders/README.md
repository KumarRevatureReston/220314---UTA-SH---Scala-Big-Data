/*
 
 created database using information from link below, folloing commands are for CRUD operations in PostgreSQL
 
 1)
// set num_sales to 26662500
update game_stats
set num_sales = 26662500
where game_rank = 15;

2)
// correct spelling error and set to Super Mario Bros
update game_stats
set game_name = 'Super Mario Bros'
where game_rank = 3;

3)
//correct release date to 2008 from 2080
update game_stats
set release_date = '2008-04-10'
where game_rank = 7;

https://en.wikipedia.org/wiki/List_of_best-selling_video_games*/
