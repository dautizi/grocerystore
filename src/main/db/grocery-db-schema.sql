-- ######################################
-- ####### DB SCHEMA ####################
-- ######################################

-- Drop database if it exists
DROP DATABASE IF EXISTS grocery_store;

-- Database creation
CREATE DATABASE grocery_store CHARACTER SET utf8 COLLATE utf8_general_ci;

-- Database selection
USE grocery_store;

-- Table list
-- Item
DROP TABLE IF EXISTS item;
CREATE TABLE item (
id bigint AUTO_INCREMENT NOT NULL,
name varchar(50),
title varchar(20),
cover varchar(200),
nutritional_image varchar(200),
availability int DEFAULT '1',
next_availability datetime DEFAULT NULL,
full_price decimal(10,2),
created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
updated_at timestamp DEFAULT CURRENT_TIMESTAMP,
status int DEFAULT '1',
tag varchar(200),
PRIMARY KEY (id));

-- Customer
DROP TABLE IF EXISTS customer;
CREATE TABLE customer (
id bigint AUTO_INCREMENT NOT NULL,
email varchar(80) NOT NULL,
email_verification boolean DEFAULT FALSE,
username varchar(40),
password varchar(255),
name varchar(40),
surname varchar(50),
birthday int DEFAULT '0',
birthmonth int DEFAULT '0',
birthyear int DEFAULT '0',
age int DEFAULT '0',
birth_location varchar(50),
birth_country varchar(50),
mobile_phone varchar(20),
phone varchar(20),
fax varchar(20),
country varchar(50),
visits int DEFAULT '0',
transactions int DEFAULT '0',
signup_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
updated_at timestamp DEFAULT CURRENT_TIMESTAMP,
status int DEFAULT '1',
PRIMARY KEY (id));

-- Discount
DROP TABLE IF EXISTS discount;
CREATE TABLE discount (
id bigint AUTO_INCREMENT NOT NULL,
name varchar(50),
description varchar(20),
cover varchar(200),
discount_perc int,
min_money decimal(10,2),
max_saved_money decimal(10,2),
discount_from datetime DEFAULT NULL,
discount_to datetime DEFAULT NULL,
created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
updated_at timestamp DEFAULT CURRENT_TIMESTAMP,
status int DEFAULT '1',
PRIMARY KEY (id));

-- Item's discount
DROP TABLE IF EXISTS item_discount;
CREATE TABLE item_discount (
id_item bigint NOT NULL,
id_discount bigint NOT NULL,
status int DEFAULT '1',
PRIMARY KEY (id_item, id_discount),
FOREIGN KEY (id_item) REFERENCES item(id),
FOREIGN KEY (id_discount) REFERENCES discount(id));

-- Customer's discount
DROP TABLE IF EXISTS customer_discount;
CREATE TABLE customer_discount (
id_customer bigint NOT NULL,
id_discount bigint NOT NULL,
status int DEFAULT '1',
PRIMARY KEY (id_customer, id_discount),
FOREIGN KEY (id_customer) REFERENCES customer(id),
FOREIGN KEY (id_discount) REFERENCES discount(id));

-- Image
DROP TABLE IF EXISTS image;
CREATE TABLE image (
id bigint AUTO_INCREMENT NOT NULL,
title varchar(150),
media_type varchar(20),
abs_path varchar(200),
extension varchar(5),
created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
updated_at timestamp DEFAULT CURRENT_TIMESTAMP,
status int DEFAULT '1',
PRIMARY KEY (id));

-- Item's images
DROP TABLE IF EXISTS image_item;
CREATE TABLE image_item (
id bigint AUTO_INCREMENT NOT NULL,
id_item bigint NOT NULL,
id_image bigint NOT NULL,
title varchar(150),
alt varchar(100),
css_class varchar(100),
media_type varchar(20),
media_path varchar(100),
media_url varchar(200),
prg int DEFAULT '1',
status int DEFAULT '1',
PRIMARY KEY (id),
FOREIGN KEY (id_image) REFERENCES image(id),
FOREIGN KEY (id_item) REFERENCES item(id));

-- Shopping cart
DROP TABLE IF EXISTS shopping_cart;
CREATE TABLE shopping_cart (
id bigint AUTO_INCREMENT NOT NULL,
cart_number varchar(20),
jsession_id varchar(50),
created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
expire_at timestamp DEFAULT CURRENT_TIMESTAMP,
status int DEFAULT '1',
customer_id bigint DEFAULT NULL,
customer_ip varchar(20),
customer_proxy varchar(20),
PRIMARY KEY (id));

-- Shopping cart - Item (Relation)
DROP TABLE IF EXISTS shopping_cart_item;
CREATE TABLE shopping_cart_item (
id_shopping_cart bigint NOT NULL,
cart_number varchar(20),
id_item bigint NOT NULL,
quantity int DEFAULT 1,
created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
updated_at timestamp DEFAULT CURRENT_TIMESTAMP,
expire_at timestamp DEFAULT CURRENT_TIMESTAMP,
status int DEFAULT '1',
user_id bigint DEFAULT NULL,
PRIMARY KEY (id_shopping_cart, id_item),
UNIQUE INDEX (id_item, id_shopping_cart),
FOREIGN KEY (id_shopping_cart) REFERENCES shopping_cart(id),
FOREIGN KEY (id_item) REFERENCES item(id));

-- Customer Order
DROP TABLE IF EXISTS customer_order;
CREATE TABLE customer_order (
id bigint AUTO_INCREMENT NOT NULL,
id_shopping_cart bigint NOT NULL,
total_items integer DEFAULT 0,
full_price decimal(10,2),
paid_price decimal(10,2),
created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
updated_at timestamp DEFAULT CURRENT_TIMESTAMP,
status int DEFAULT '1',
customer_ip varchar(20),
customer_proxy varchar(20),
customer_id bigint DEFAULT NULL,
PRIMARY KEY (id),
FOREIGN KEY (id_shopping_cart) REFERENCES shopping_cart(id));

-- User order - Item (Relation)
DROP TABLE IF EXISTS customer_order_item;
CREATE TABLE customer_order_item (
id_customer_order bigint NOT NULL,
id_item bigint NOT NULL,
quantity integer DEFAULT 1,
full_price decimal(10,2),
discount boolean DEFAULT FALSE,
discount_perc int DEFAULT '0',
discount_price decimal(10,2),
paid_price decimal(10,2),
status int DEFAULT '1',
PRIMARY KEY (id_customer_order, id_item),
UNIQUE INDEX (id_item, id_customer_order),
FOREIGN KEY (id_customer_order) REFERENCES customer_order(id),
FOREIGN KEY (id_item) REFERENCES item(id));

-- Address
DROP TABLE IF EXISTS address;
CREATE TABLE address (
id bigint AUTO_INCREMENT NOT NULL,
id_customer bigint NOT NULL,
address_type int DEFAULT '1',
same_address boolean DEFAULT FALSE,
customer_default boolean DEFAULT FALSE,
address_1 varchar(80),
address_2 varchar(60),
locality varchar(80),
province varchar(50),
postcode varchar(10),
country varchar(50),
prg int DEFAULT '1',
created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
updated_at timestamp DEFAULT CURRENT_TIMESTAMP,
status int DEFAULT '1',
PRIMARY KEY (id),
KEY fk_customer (id_customer),
CONSTRAINT fk_customer FOREIGN KEY (id_customer) REFERENCES customer (id));

-- Shipping Company
DROP TABLE IF EXISTS shipping_company;
CREATE TABLE shipping_company (
id bigint AUTO_INCREMENT NOT NULL,
name varchar(50) NOT NULL,
address_1 varchar(80),
address_2 varchar(60),
locality varchar(80),
province varchar(50),
postcode varchar(10),
country varchar(50),
prg int DEFAULT '1',
created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
updated_at timestamp DEFAULT CURRENT_TIMESTAMP,
status int DEFAULT '1',
PRIMARY KEY (id));

-- Shipping
DROP TABLE IF EXISTS shipping;
CREATE TABLE shipping (
id bigint AUTO_INCREMENT NOT NULL,
id_address bigint NOT NULL,
id_customer bigint NOT NULL,
id_shipping_company bigint DEFAULT NULL,
code varchar(30) NOT NULL,
email varchar(80) NOT NULL,
phone varchar(20) NOT NULL,
notes varchar(255) DEFAULT NULL,
method int DEFAULT '0',
full_price decimal(10,2),
final_price decimal(10,2),
delivery_begin timestamp DEFAULT CURRENT_TIMESTAMP,
delivery_end timestamp DEFAULT CURRENT_TIMESTAMP,
delivery_status int DEFAULT '1',
created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
updated_at timestamp DEFAULT CURRENT_TIMESTAMP,
status int DEFAULT '1',
PRIMARY KEY (id),
FOREIGN KEY (id_address) REFERENCES address(id),
FOREIGN KEY (id_customer) REFERENCES customer(id));

-- Customer order - Shipping (Relation)
DROP TABLE IF EXISTS customer_order_shipping;
CREATE TABLE customer_order_shipping (
id_customer_order bigint NOT NULL,
id_shipping bigint NOT NULL,
status int DEFAULT '1',
PRIMARY KEY (id_customer_order, id_shipping),
UNIQUE INDEX (id_shipping, id_customer_order),
FOREIGN KEY (id_customer_order) REFERENCES customer_order(id),
FOREIGN KEY (id_shipping) REFERENCES shipping(id));

-- Credit Card
DROP TABLE IF EXISTS credit_card;
CREATE TABLE credit_card (
id bigint AUTO_INCREMENT NOT NULL,
id_customer bigint NOT NULL,
brand varchar(50) NOT NULL,
description varchar(50),
prg int DEFAULT '1',
cc_code varchar(30),
security_code int DEFAULT '0',
holder_name varchar(50),
expire_date varchar(10),
expire_month int DEFAULT '0',
expire_year int DEFAULT '0',
expired boolean DEFAULT FALSE,
validated boolean DEFAULT TRUE,
created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
updated_at timestamp DEFAULT CURRENT_TIMESTAMP,
status int DEFAULT '1',
PRIMARY KEY (id),
FOREIGN KEY (id_customer) REFERENCES customer(id));

-- Payment
DROP TABLE IF EXISTS payment;
CREATE TABLE payment (
id bigint AUTO_INCREMENT NOT NULL,
id_customer_order bigint NOT NULL,
id_customer bigint NOT NULL,
code varchar(30),
name varchar(50) NOT NULL,
description varchar(50),
sum decimal(10,2),
payment_percentage int DEFAULT '0',
payment_extra decimal(10,2),
id_credit_card bigint DEFAULT NULL,
prg int DEFAULT '1',
paid boolean DEFAULT FALSE,
transaction_status int DEFAULT '1',
created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
updated_at timestamp DEFAULT CURRENT_TIMESTAMP,
status int DEFAULT '1',
PRIMARY KEY (id),
FOREIGN KEY (id_customer_order) REFERENCES customer_order(id),
FOREIGN KEY (id_customer) REFERENCES customer(id),
FOREIGN KEY (id_credit_card) REFERENCES credit_card(id));

-- Invoice
DROP TABLE IF EXISTS invoice;
CREATE TABLE invoice (
id bigint AUTO_INCREMENT NOT NULL,
id_customer bigint NOT NULL,
id_customer_order bigint NOT NULL,
id_shipping bigint NOT NULL,
id_address bigint NOT NULL,
id_payment bigint NOT NULL,
created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
updated_at timestamp DEFAULT CURRENT_TIMESTAMP,
status int DEFAULT '1',
PRIMARY KEY (id),
FOREIGN KEY (id_customer) REFERENCES customer(id),
FOREIGN KEY (id_customer_order) REFERENCES customer_order(id),
FOREIGN KEY (id_shipping) REFERENCES shipping(id),
FOREIGN KEY (id_address) REFERENCES address(id),
FOREIGN KEY (id_payment) REFERENCES payment(id));

-- user_admin
DROP TABLE IF EXISTS user_admin;
CREATE TABLE user_admin (
id bigint AUTO_INCREMENT NOT NULL,
role varchar(50),
username varchar(40),
password varchar(255),
name varchar(40),
surname varchar(50),
birthday int DEFAULT '0',
birthmonth int DEFAULT '0',
birthyear int DEFAULT '0',
age int DEFAULT '0',
birth_location varchar(50),
birth_country varchar(50),
mobile_phone varchar(20),
phone varchar(20),
fax varchar(20),
country varchar(50),
signup_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
updated_at timestamp DEFAULT CURRENT_TIMESTAMP,
status int DEFAULT '1',
PRIMARY KEY (id));

