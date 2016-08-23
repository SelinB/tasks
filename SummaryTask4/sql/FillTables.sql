USE eshop;

INSERT INTO roles (name) 
VALUES ('ADMIN');
INSERT INTO roles (name) 
VALUES ('CLIENT');

INSERT INTO users (login, password, email, first_name, last_name, role_id)
VALUES ('Neo', 'adminpass', 'TomasAndersen@matrix.com', 'Tomas', 'Andersen', 1);
INSERT INTO users (login, password, email, first_name, last_name, role_id)
VALUES ('Mary', 'marypass', 'Mary@somemail.com', 'Maria', 'Kyrichenko', 2);
INSERT INTO users (login, password, email, first_name, last_name, role_id)
VALUES ('Captain', 'johnnypass', 'JohhnyDepp@somemail.com', 'Johnny', 'Depp', 2);
INSERT INTO users (login, password, email, first_name, last_name, role_id)
VALUES ('Petrov', 'petrovpass', 'Petrow@mail.com', 'Alexandr', 'Petrov', 2);

INSERT INTO categories (name)
VALUES ('Food');
INSERT INTO categories (name)
VALUES ('Drinks');

INSERT INTO products (name, price, stock, manufactoring_date, category_id)
VALUES ('Chocolate', 20, 50, '2016-08-20', 1);
INSERT INTO products (name, price, stock, manufactoring_date, category_id)
VALUES ('Cookies', 20, 50, '2016-08-20', 1);
INSERT INTO products (name, price, stock, manufactoring_date, category_id)
VALUES ('Apple Juice', 30, 50, '2016-08-20', 2);
INSERT INTO products (name, price, stock, manufactoring_date, category_id)
VALUES ('Water', 10, 50, '2016-08-20', 2);
