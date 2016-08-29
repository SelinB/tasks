USE eshop;

INSERT INTO roles (name) 
VALUES ('ADMIN');
INSERT INTO roles (name) 
VALUES ('CLIENT');

INSERT INTO users (login, password, email, first_name, last_name, role_id)
VALUES ('Neo', '74913f5cd5f61ec0bcfdb775414c2fb3d161b620', 'TomasAndersen@matrix.com', 'Tomas', 'Andersen', 1);
INSERT INTO users (login, password, email, first_name, last_name, role_id)
VALUES ('Mary', 'c8bee024996aed0a40477bdfdbb973d51e39ce2a', 'Mary@somemail.com', 'Maria', 'Kyrichenko', 2);
INSERT INTO users (login, password, email, first_name, last_name, role_id)
VALUES ('Captain', '3015d329cb60baff90ff2d0c7d62826b1b478e61', 'JohhnyDepp@somemail.com', 'Johnny', 'Depp', 2);
INSERT INTO users (login, password, email, first_name, last_name, role_id)
VALUES ('Petrov', 'ab91f79e02771e5bebc581c9c5922e06019bf4b1', 'Petrow@mail.com', 'Alexandr', 'Petrov', 2);

INSERT INTO categories (name)
VALUES ('Food');
INSERT INTO categories (name)
VALUES ('Drinks');

INSERT INTO products (name, price, stock, manufactoring_date, category_id, img_src)
VALUES ('Chocolate', 20, 50, '2016-08-20', 1, 'img/chocolate.jpg');
INSERT INTO products (name, price, stock, manufactoring_date, category_id)
VALUES ('Cookies', 20, 50, '2016-08-20', 1);
INSERT INTO products (name, price, stock, manufactoring_date, category_id)
VALUES ('Apple Juice', 30, 50, '2016-08-20', 2);
INSERT INTO products (name, price, stock, manufactoring_date, category_id)
VALUES ('Water', 10, 50, '2016-08-20', 2);
