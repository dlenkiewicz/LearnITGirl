DROP TABLE users CASCADE;
DROP TABLE books CASCADE;
DROP TABLE books_out_on_loan CASCADE;
DROP TABLE author CASCADE;
DROP TABLE authorship CASCADE;
DROP TABLE categories CASCADE;
DROP TABLE book_category CASCADE;
DROP TABLE copies CASCADE;

CREATE TABLE users(
 id SERIAL PRIMARY KEY NOT NULL,
 name VARCHAR(50) NOT NULL,
 surname VARCHAR(50) NOT NULL,
 street_address VARCHAR(50),
 city VARCHAR(50),
 phone_number VARCHAR(50) UNIQUE,
 email VARCHAR(50) NOT NULL UNIQUE,
 password VARCHAR(50) NOT NULL
);

CREATE TABLE books(
 isbn VARCHAR(50) PRIMARY KEY NOT NULL,
 title VARCHAR(50) NOT NULL,
 date_of_publication INT NOT NULL,
 publisher VARCHAR(50) NOT NULL
);

CREATE TABLE author(
 id SERIAL PRIMARY KEY NOT NULL,
 name VARCHAR(50) NOT NULL,
 surname VARCHAR(50) NOT NULL
);

CREATE TABLE authorship(
 id SERIAL PRIMARY KEY NOT NULL,
 auth_id INT NOT NULL REFERENCES author(id) ON UPDATE CASCADE ON DELETE RESTRICT,
 isbn VARCHAR(50) NOT NULL REFERENCES books(isbn) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE categories(
 id SERIAL PRIMARY KEY NOT NULL,
 name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE book_category(
 id SERIAL PRIMARY KEY NOT NULL,
 cat_id INT NOT NULL REFERENCES categories(id) ON UPDATE CASCADE ON DELETE RESTRICT,
 isbn VARCHAR(50) NOT NULL REFERENCES books(isbn) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE copies(
 id SERIAL NOT NULL PRIMARY KEY,
 isbn VARCHAR(50) NOT NULL REFERENCES books(isbn) ON UPDATE CASCADE ON DELETE CASCADE,
 copy_number INT NOT NULL
);

CREATE TABLE books_out_on_loan(
 id SERIAL NOT NULL PRIMARY KEY,
 u_id INT NOT NULL REFERENCES users(id) ON UPDATE CASCADE ON DELETE RESTRICT,
 copy_id INT NOT NULL REFERENCES copies(id) ON UPDATE CASCADE ON DELETE RESTRICT,
 date_issued DATE NOT NULL,
 date_due_for_return DATE NOT NULL,
 date_returned DATE,
 amount_of_fine DECIMAL(6,2) NOT NULL DEFAULT(0)
);

-----

INSERT INTO users (name, surname, email, password) VALUES 
('John', 'Smith', 'john.smith@gmail.com', 'qwerty123');

INSERT INTO books VALUES 
('978-83-7839-409-9', 'Dluga ziemia', 2013, 'Proszynski i S-ka'), 
('978-83-7574-905-2', 'Carska manierka', 2013, 'Fabryka Slow'),
('978-83-7574-509-2', 'Kroniki Jakuba Wedrowycza', 2009, 'Fabryka Slow'),
('978-83-7512-285-5', 'Pierwszy klucz', 2007, 'Firma Ksiegarska Jacek i Krzysztof Olesiejuk'),
('83-7327-866-4', 'Lalka', 2006, 'Wydawnictwo GREG');

INSERT INTO author (name, surname) VALUES
('Boleslaw', 'Prus'),
('Andrzej', 'Pilipiuk'),
('Ulysses', 'Moore'),
('Terry', 'Pratchet'),
('Stephen', 'Baxter');

INSERT INTO authorship (auth_id, isbn) VALUES
(1, '83-7327-866-4'),
(2, '978-83-7839-409-9'),
(2, '978-83-7574-509-2'),
(3, '978-83-7512-285-5'),
(4, '978-83-7839-409-9'),
(5, '978-83-7839-409-9');

INSERT INTO categories (name) VALUES
('science-fiction'),
('fantasy'),
('novel of manners'),
('detective story');

INSERT INTO book_category (cat_id, isbn) VALUES
(1, '978-83-7839-409-9'),
(2, '978-83-7574-905-2'),
(2, '978-83-7574-509-2'),
(3, '83-7327-866-4'),
(4, '978-83-7512-285-5');

INSERT INTO copies (isbn, copy_number) VALUES
('978-83-7839-409-9', 1),
('978-83-7839-409-9', 2),
('978-83-7839-409-9', 3),
('978-83-7574-905-2', 1),
('978-83-7574-905-2', 2),
('978-83-7574-509-2', 1),
('978-83-7512-285-5', 1),
('83-7327-866-4', 1),
('83-7327-866-4', 2),
('83-7327-866-4', 3),
('83-7327-866-4', 4),
('83-7327-866-4', 5);
