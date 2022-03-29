DROP DATABASE IF EXISTS normalizationForm1;
CREATE DATABASE normalizationForm1;
USE normalizationForm1;
CREATE TABLE Projects(
ID INT PRIMARY KEY,
Name VARCHAR(100),
Val DECIMAL(5,2),
StartDate DATE,
EndDate DATE
);

CREATE TABLE Employees(
ID INT PRIMARY KEY ,
FirstName VARCHAR(50),
LastName VARCHAR(50),
HourlyWage DECIMAL(5,2),
HireDate DATE
);

CREATE TABLE ProjectEmployees(
ID INT PRIMARY KEY,
ProjectID INT,
EmployeeID INT,
Hours DECIMAL(5,2),
CONSTRAINT FK_ProjectEmployees_Projects FOREIGN KEY (ProjectID) REFERENCES  Projects (ID),
CONSTRAINT FK_ProjectEmployees_Employees FOREIGN KEY (EmployeeID) REFERENCES  Employees (ID)
);

CREATE TABLE JobOrders(
ID INT PRIMARY KEY,
EmployeeID INT,
ProjectID INT,
Description TEXT,
OrderDateTime DATETIME,
Quantity INT,
Price DECIMAL(5,2),
CONSTRAINT FK_JobOrders_Projects FOREIGN KEY (ProjectID) REFERENCES  Projects (ID),
CONSTRAINT FK_JobOrders_Employees FOREIGN KEY (EmployeeID) REFERENCES  Employees (ID)
);


CREATE TABLE Customers (
    Name VARCHAR(100),
    Industry VARCHAR(100),
    Project1_ID INT,
    Project1_Feedback TEXT,
    Project2_ID INT,
    Project2_Feedback TEXT,
    ContactPersonID INT,
    ContactPersonAndRole VARCHAR(255),
    PhoneNumber VARCHAR(12),
    Address VARCHAR(255),
    City VARCHAR(255),
    Zip VARCHAR(5)
  );
 