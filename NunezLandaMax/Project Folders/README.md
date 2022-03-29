# Bank Account Project
## Max Julian Landa Nunez

> # 1. Bank Account Project

Application Bank Account created in Scala programming language connected to Postgres database with the help of Slick library.
The Database bankaccount is an internal database with no external links created in Postgresql and contains 9 columns

*CREATE TABLE bankacount(
acc_num SERIAL PRIMARY KEY UNIQUE NOT NULL,
cli_name VARCHAR(20) NOT NULL,
cli_lastname VARCHAR(20) NOT NULL,
acc_type VARCHAR(20) NOT NULL,
acc_montfee INT,
acc_pass VARCHAR(30),
acc_interest_rate FLOAT
acc_status VARCHAR(10)
acc_balance NUMERIC(10,2);
)*

- Acc_num is the primary key is unique and not null and represents the account number.
- Cli_name and last_name are used to save the name and last-named of the client that owns the bank account.
- Acc_type is the type of the account, Savings or Checking account
- Acc_montfee is the monthly fee charge depending on the type of the account, saving or checking account.
- Acc_pass save the password to access the account by the client.
- Acc_interest_rate specifies the interest paid depending on the type of the account.
- Acc_status specifies if the account is active or has been closed
- Acc_balance specifies the amount of money in the account.


# 2.	Basic functionality
The project Read from the data base to search an account, list all the accounts, open and add a new client to the account, close an account and erase an account. To do that the program uses the library slick in Scala with the options SELECT, UPDATE, DELETE and INSERT, with the option COUNT to count the number of the accounts.

The project searches the account for the client to make a transaction and ask for the password before. The options for the client are "Make a deposit", "Make a withdrawal" "View Balance". For all that the application uses SELECT and UPDATE, to make modifications to the table. 
 
