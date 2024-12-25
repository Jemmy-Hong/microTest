DROP TABLE IF EXISTS book;
CREATE TABLE book(
    id INT PRIMARY KEY  AUTO_INCREMENT COMMENT 'id',
    title VARCHAR(200) COMMENT 'title',
    author varchar(100) COMMENT 'author',
    price DECIMAL(10,2) COMMENT 'price',
    category varchar(100) COMMENT 'category');