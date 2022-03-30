Project 0: “THE A-LIST”

A Scala CLI (Command Line Interface) application. Data should be parsed from a CSV OR JSON file and persisted to MongoDB. The functionality of the application beyond that is up to you, but here are a few suggestions:
journal app
banking app
business management system
simple text-based game
productivity tool
ecommerce app (customers,products, categories, orders)
...?
 
Readme - Description of DB
DB - add the files
input - sql queries
output - snapshot of the o/p
 
INTRO: 
Hello everyone, thank you for joining me today, and welcome to my demonstration of this business management system for my employer, “The A-List”. “The A-List” is a social media platform designed for high-profile content creators and individuals on social media platforms which include: Twitter, YouTube, and TikTok. We are reaching out to you because you are a high profile content creator, and we would love to create an account for you on our platform, so that you may collaborate on projects with other high-profile content creators in order to further develop, and expand the media reach of your brand! With that being said, let us begin!
 
 
Application Requirements
Your application must perform basic CRUD (Create, Read, Update, Delete) functionality with data stored in a database.
CREATE:
YOUR “THE A-LIST” ACCOUNT
Screenshot(60) - Table Successfully Created: CREATE TABLE Query returned successfully in 98 msec.
 
CREATE TABLE account(
	account_id SERIAL PRIMARY KEY,
	account_name VARCHAR (25) UNIQUE NOT NULL,
	account_login VARCHAR (50) NOT NULL,
	account_verification BOOLEAN NOT NULL,
	email_address VARCHAR (50) UNIQUE NOT NULL,
	content_platform VARCHAR (50) NOT NULL, 
	content_url VARCHAR (150) NOT NULL,
	content_genre VARCHAR (50) NOT NULL, 
	contact_info VARCHAR (150) UNIQUE NOT NULL
)
 
Great, you have made your “The A-List” account! Welcome, and thank you for joining! We look forward to working with you in the future, and to help you make long-lasting professional connections. Our primary goal here at “The A-List” is ultimately to increase the internet traffic to your desired content platform!
 
INSERT
YOUR “THE A-LIST” ACCOUNT INFORMATION
Screenshot (61) - Empty Created Table, Before Insert
SELECT * FROM account
Screenshot (62) - Successful INSERT Query: INSERT 0 1 Query returned successfully in 33 msec.
INSERT INTO account(account_name, account_login, 
					account_verification, 
					email_address, content_platform,
				    	content_url, content_genre, 
				    	contact_info)
VALUES
					('Bran Bran Hanz','mypassword', 
					 'false','branbranhanz@gmail.com',
					 'YouTube', 
					 'www.youtube.com/branbranhanz',
					 'comedian', 'You used to call me 
					 on my cellphone: 8675309')
 
Screenshot (63) - Updated, Inserted Table
SELECT * FROM account		
 
 
 
UPDATE: 3-5 Business days later…
YOUR REAL IDENTITY HAS BEEN VERIFIED!!!
Screenshot (65) - Updated account_verification: UPDATE 1 Query returned successfully in 47 msec. We have verified that you, Bran Bran Hanz, are the official owner of this account. Your “The A-List” will now show that you are the real Bran Bran Hanz. 
UPDATE account
SET account_verification = true
Screenshot (66) - (Boolean) account_verification changed from = false, to = true. 
SELECT * FROM account
DELETE: 1 week later…
USER BRAN BRAN HANZ: My fans have been constantly spamming my e-mail, and calling me late-night saying they need my love! I can’t take it anymore! Remove my e-mail and my phone number from my profile!
On behalf of our company, “The A-List”, we sincerely apologize for any inconveniences you have had with fan interaction. We will go ahead and remove both your e-mail address and phone number from your profile. 
SELECT * FROM account
Screenshot (69) - Before deleting 2 rows: Row email_address, and Row contact_info
DELETE FROM account
WHERE email_address = ‘branbranhanz@gmail.com’, contact_info = ‘'You used to call me on my cellphone: 8675309'
→ delete from Servers - > Databases (3) - > The A list - > Schemas (1) - > Tables (1) - > account - > Columns (9) - > Right click and delete/drop: Row email_address and Row contact_info  
Screenshot (71) - After deleting Row email_address and Row contact_info
 
 
DROP: 2 weeks later…
USER BRAN BRAN HANZ: This social media platform sucks! It’s been two weeks, and no one else has joined “The A-List”. I’m done, delete my account!
Sure, no problem! We will continue to create, insert, update, and delete certain aspects of our social media platform in order to best serve our clients needs. We will go ahead and delete your account. We hope to see you again soon, here at “The A-List”, the social media platform designed for high-profile content creators and individuals.
social media platform designed for high-profile content creators and individuals.
Screenshot (71) - Before deleting entire Table
SELECT * FROM account
DROP TABLE account
Screenshot (72) - Dropping Table
Screenshot (73) - Table Successfully Dropped: DROP TABLE Query returned successfully in 40 msec.
Screenshot (74), (75) - Table No Longer Exists
Your application must be able to read JSON or CSV files, and store the data contained within those files in a database
Your application should have a CLI where users can interact with the application while it is running
Other than those requirements, the kind of application you have is up to you.
Tech Stack
Scala 2.13
File I/O
Collections
MongoDB
sbt
git SCM (+ GitHub)
POSTGRESQL 14 and pgADMIN 4v6
Presentation
5 minute live demo. Present the application, not the code.
Due Date
Project 0 will be presented Wednesday (Wednesday week 3)
Finishing your MVP (Minimum Viable Product) as early as possible before iterating new features upon the project is highly recommended. Plan ahead, and be sure to reach out to others when you need guidance (or offer your own to those in need). You are REQUIRED to be able to explain your project functionality and write your own code, but feel free to have in-depth discussions with others.
