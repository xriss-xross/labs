DROP DATABASE IF EXISTS Supermarket;
CREATE DATABASE Supermarket;
USE Supermarket;

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
    PRIMARY KEY (name, t_id),
    FOREIGN KEY (name) REFERENCES Stock(name),
    FOREIGN KEY (t_id) REFERENCES Transactions(t_id)
);