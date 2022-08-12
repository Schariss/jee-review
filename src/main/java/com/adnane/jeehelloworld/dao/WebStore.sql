-- - DATABASE CREATION
DROP DATABASE IF EXISTS WebStore;
CREATE DATABASE WebStore;
USE WebStore;

-- - CREATE USER FOR THE DB
GRANT ALL ON WebStore.* TO 'username'@'localhost' IDENTIFIED BY 'WebStore135';

-- - USERS TABLE
CREATE TABLE USER (
    IdUser              int(4)          PRIMARY KEY AUTO_INCREMENT,
    login               varchar(20)     NOT NULL,
    password            varchar(20)     NOT NULL,
    connection_number   int(4)          NOT NULL DEFAULT 0
) ENGINE = InnoDB;

INSERT INTO USER (login, password) VALUES ('Adnane', '1234');
INSERT INTO USER (login, password) VALUES ('Ali', '1234');
INSERT INTO USER (login, password) VALUES ('Nadir', '1234');
INSERT INTO USER (login, password) VALUES ('Walid', '1234');

-- - ADMINS TABLE
CREATE TABLE ADMINS (
    IdUser int(4)       NOT NULL REFERENCES USER(IdUser),
    rights varchar(10)  NOT NULL
) ENGINE = InnoDB;

INSERT INTO ADMINS (IdUser, rights) VALUES ( 1, '-RWX------' );
INSERT INTO ADMINS (IdUser, rights) VALUES ( 2, '-RWK------' );

-- - ARTICLES TABLE
CREATE TABLE ARTICLE (
    IdArticle       int(4)      PRIMARY KEY AUTO_INCREMENT,
    description     text        NOT NULL,
    brand           text        NOT NULL,
    unitary_price   float(8)    NOT NULL
) ENGINE = InnoDB;

INSERT INTO ARTICLE (description, brand, unitary_price) VALUES ('mouse', 'Logitech', 65);
INSERT INTO ARTICLE (description, brand, unitary_price) VALUES ('keyboard', 'MicroHard', 49.5);
INSERT INTO ARTICLE (description, brand, unitary_price) VALUES ('Operation system', 'Mac OS', 200);
INSERT INTO ARTICLE (description, brand, unitary_price) VALUES ('Laptop', 'Asus', 2100);
INSERT INTO ARTICLE (description, brand, unitary_price) VALUES ('usb', 'Syno', 8);
INSERT INTO ARTICLE (description, brand, unitary_price) VALUES ('Webcam', 'Logitech', 75);
INSERT INTO ARTICLE (description, brand, unitary_price) VALUES ('Remote', 'Samsung', 40);

-- - ORDERS TABLE
CREATE TABLE ORDERS (
    IdOrder		int(4)		PRIMARY KEY AUTO_INCREMENT,
    IdUser		int(4)		NOT NULL REFERENCES USER(IdUser),
    orderDate   datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE = InnoDB;

-- - ORDERS TABLE
CREATE TABLE ORDER_LINES (
    IdOrderLine int(4)      PRIMARY KEY AUTO_INCREMENT,
    IdOrder     int(4)      NOT NULL REFERENCES ORDERS(IdOrder),
    IdArticle   int(4)      NOT NULL REFERENCES ARTICLE(IdArticle),
    quantity    int(4)      NOT NULL
) ENGINE = InnoDB;

-- FIRST ORDER
INSERT INTO ORDERS (IdUser, orderDate) VALUES ( 3, now() );
INSERT INTO ORDER_LINES (IdOrder, IdArticle, quantity) VALUES (1, 1, 5);
INSERT INTO ORDER_LINES (IdOrder, IdArticle, quantity) VALUES (1, 3, 3);

-- SECOND ORDER FOR ADMIN
INSERT INTO ORDERS (IdUser, orderDate) VALUES ( 1, now() );
INSERT INTO ORDER_LINES (IdOrder, IdArticle, quantity) VALUES (2, 2, 4);
INSERT INTO ORDER_LINES (IdOrder, IdArticle, quantity) VALUES (2, 3, 1);
INSERT INTO ORDER_LINES (IdOrder, IdArticle, quantity) VALUES (2, 4, 1);