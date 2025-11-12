-- Question 1
CREATE TABLE Customers (
first_name VARCHAR(20),
last_name  VARCHAR(20),
birthday   DATE,
c_id       INT,
PRIMARY KEY (c_id)
);

CREATE TABLE Employees (
first_name VARCHAR(20),
last_name  VARCHAR(20),
birthday   DATE,
e_id       INT,
PRIMARY KEY (e_id)
);

CREATE TABLE Deals (
value INT,
d_id  INT,
PRIMARY KEY (d_id)
);

CREATE TABLE TypesInDeals (
d_id INT,
type VARCHAR(20),
PRIMARY KEY (type),
FOREIGN KEY (d_id) REFERENCES Deals(d_id)
);

CREATE TABLE Stock (
amount INT,
type   VARCHAR(20),
name   VARCHAR(20),
PRIMARY KEY (name),
FOREIGN KEY (type) REFERENCES TypesInDeals(type)
);

CREATE TABLE Transactions (
date      DATE,
challenge BOOL,
c_id      INT,
e_id      INT,
t_id      INT,
PRIMARY KEY (t_id),
FOREIGN KEY (c_id) REFERENCES Customers(c_id),
FOREIGN KEY (e_id) REFERENCES Employees(e_id)
);

CREATE TABLE ItemsInTransactions (
name VARCHAR(20),
cost INT,
t_id INT,
FOREIGN KEY (name) REFERENCES Stock(name),
FOREIGN KEY (t_id) REFERENCES Transactions(t_id)
);

-- Question 2
INSERT INTO Customers VALUES (
	"Ben",        -- first name
	"Thompson",   -- last name
	"1992-07-21", -- date of birth
	6             -- customer ID
);
INSERT INTO Employees VALUES (
	"Rita",
	"Davies",
	"2000-10-07",
	5             -- employee ID
);
INSERT INTO Transactions VALUES (
	"2025-09-07", -- transaction date
	false,        -- whether transaction was challenged
	6,            -- customer ID
	5,            -- employee ID
	18            -- transcation ID
);
INSERT INTO Stock VALUES (
	7,            -- number of items
	null,         -- type of item (whether there is a deal on them)
	"Newspaper"   -- name of item
);
INSERT INTO Stock VALUES (
	4,
	null,
	"Pen"
);
INSERT INTO ItemsInTransactions VALUES (
	'Newspaper',
	149,          -- cost of item
	18            -- transaction ID
);
INSERT INTO ItemsInTransactions VALUES (
	'Pen',
	99,
	18
);

-- Question 3
CREATE VIEW August2025SalesByDavid AS
SELECT COUNT(*) AS number_of_sales
FROM Transactions
WHERE e_id = 4
AND date BETWEEN "2025-08-1" AND "2025-08-31";

-- Question 4
CREATE VIEW Above25 AS
SELECT Transactions.t_id, Transactions.challenge,
CASE
	WHEN DATEDIFF(Transactions.date, Customers.birthday) >= 9132 THEN 1
	ELSE 0
END AS above_25
FROM Transactions
JOIN Customers ON Transactions.c_id = Customers.c_id
WHERE Transactions.t_id IN (
	SELECT DISTINCT ItemsInTransactions.t_id
	FROM ItemsInTransactions
	JOIN Stock ON ItemsInTransactions.name = Stock.name
	WHERE Stock.type = 'Alcohol'
)
ORDER BY Transactions.t_id;

-- Question 5
CREATE VIEW ItemsSold AS
SELECT name, COUNT(*) AS total_sold
FROM ItemsInTransactions
GROUP BY name;

CREATE VIEW StockLeft AS
SELECT Stock.name, (Stock.amount - ItemsSold.total_sold)
AS stock_left
FROM Stock
LEFT JOIN ItemsSold ON Stock.name = ItemsSold.name
ORDER BY Stock.name;