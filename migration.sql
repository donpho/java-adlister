USE adlister_db;


DROP TABLE ads;
DROP TABLE users;


CREATE TABLE IF NOT EXISTS users  (
id int unsigned not null auto_increment,
username varchar(20) not null,
email varchar(50) not null,
password varchar(50) not null,
primary key(id),
unique (username,email)
);

CREATE TABLE IF NOT EXISTS ads (
id INT UNSIGNED NOT NULL AUTO_INCREMENT,
user_id int UNSIGNED,
title VARCHAR(200) NOT NULL,
description VARCHAR(200),
PRIMARY KEY(id),
FOREIGN KEY (user_id) REFERENCES users(id));

SHOW TABLES;

describe users;

INSERT INTO users(username,email,password)
VALUE ('tableflip','tableflip@tableflip.com','tableflip');

SHOW CREATE TABLE users\G


