-- Question 1
CREATE TABLE Customers (
first_name VARCHAR(20),
last_name VARCHAR(20),
birthday DATE,
c_id INT,
PRIMARY KEY (c_id)
);

CREATE TABLE Employees (
first_name VARCHAR(20),
last_name VARCHAR(20),
birthday DATE,
e_id INT,
PRIMARY KEY (e_id)
);

CREATE TABLE Deals (
value INT,
d_id INT,
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
type VARCHAR(20),
name VARCHAR(20),
PRIMARY KEY (name),
FOREIGN KEY (type) REFERENCES TypesInDeals(type)
);

CREATE TABLE Transactions (
date DATE,
challenge BOOL,
c_id INT,
e_id INT,
t_id INT,
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
INSERT INTO Customers VALUES ("Ben", "Thompson", "1992-07-21", 6);
INSERT INTO Employees VALUES ("Rita", "Davies", "2000-10-07", 5);

INSERT INTO Transactions VALUES ("2025-09-07", false, 6, 5, 18);

INSERT INTO Stock VALUES (7, null, "Newspaper");
INSERT INTO Stock VALUES (4, null, "Pen");

INSERT INTO ItemsInTransactions VALUES ('Newspaper', 149, 18);
INSERT INTO ItemsInTransactions VALUES ('Pen', 99, 18);

-- Question 3
CREATE VIEW August2025SalesByDavid AS
SELECT COUNT(*) AS number_of_sales
FROM Transactions
WHERE e_id = 4
AND date BETWEEN "2025-08-1" AND "2025-08-31";

-- Question 4
