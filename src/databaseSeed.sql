DROP DATABASE if exists ClubHubDevTeam;

CREATE DATABASE ClubHubDevTeam;

USE ClubHubDevTeam;

CREATE TABLE Members (
	memberID int(11) UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT,
    fname VARCHAR(40) NOT NULL,
    lname VARCHAR(40) NOT NULL,
    dues_paid BOOL NOT NULL,
    join_date TIMESTAMP NOT NULL
);

INSERT INTO Members (fname, lname, dues_paid, join_date) VALUES ('Kevin', 'Geeting', FALSE, NOW());
INSERT INTO Members (fname, lname, dues_paid, join_date) VALUES ('Jeremy', 'Aftem', TRUE, NOW());
INSERT INTO Members (fname, lname, dues_paid, join_date) VALUES ('Shabina', 'Rayan', TRUE, NOW());
INSERT INTO Members (fname, lname, dues_paid, join_date) VALUES ('Priya', 'Bhatnagar', FALSE, NOW());
INSERT INTO Members (fname, lname, dues_paid, join_date) VALUES ('Jacqueline', 'Faye', TRUE, NOW());

CREATE TABLE Finances (
	id int(10) UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT,
    reason VARCHAR(100) NOT NULL,
    price DECIMAL(9,2) NOT NULL,
    date TIMESTAMP NOT NULL,
    vendor VARCHAR(100),
    buyer VARCHAR(100)
);

CREATE TABLE Posts (
	id int(10) UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT,
    content TEXT NOT NULL,
    date TIMESTAMP NOT NULL,
    author INT(11) NOT NULL,
    FOREIGN KEY fk(author) REFERENCES Members(memberID)
);


