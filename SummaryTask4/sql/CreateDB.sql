USE eshop;

SET foreign_key_checks = 0;
DROP TABLE roles;
DROP TABLE users;
DROP TABLE categories;
DROP TABLE products;
DROP TABLE orders;
DROP TABLE order_items;
SET foreign_key_checks = 1;

CREATE TABLE roles(
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(255) NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE users(
id INT NOT NULL AUTO_INCREMENT,
login VARCHAR(255) NOT NULL UNIQUE,
password VARCHAR(255) NOT NULL,
email VARCHAR(255) NOT NULL,
first_name VARCHAR(255) NOT NULL,
last_name VARCHAR(255) NOT NULL,
phone VARCHAR(255),
address VARCHAR(255),
gender VARCHAR(255),
status VARCHAR(255) NOT NULL DEFAULT 'OPEN',
role_id INT NOT NULL DEFAULT 2,
current_order_id INT UNIQUE,
PRIMARY KEY (id),
FOREIGN KEY (role_id) REFERENCES roles (id)
);

CREATE TABLE categories(
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(255),
PRIMARY KEY (id)
);

CREATE TABLE products(
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(255) NOT NULL,
price INT NOT NULL,
stock INT NOT NULL,
manufactoring_date DATE NOT NULL,
size VARCHAR(255),
color VARCHAR(255),
img_src TEXT,
description TEXT,
category_id INT NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (category_id) REFERENCES categories (id)
);

CREATE TABLE orders(
id INT NOT NULL AUTO_INCREMENT,
status VARCHAR(255) NOT NULL,
total_price INT NOT NULL,
user_id INT NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (user_id) REFERENCES users (id)
);

ALTER TABLE users
ADD FOREIGN KEY (current_order_id) REFERENCES orders (id);

CREATE TABLE order_items(
id INT NOT NULL AUTO_INCREMENT,
product_id INT NOT NULL,
products_count INT NOT NULL DEFAULT 1,
price INT NOT NULL,
order_id INT NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (product_id) REFERENCES products (id),
FOREIGN KEY (order_id) REFERENCES orders (id)
);
