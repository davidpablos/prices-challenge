CREATE TABLE brand
(
    id   bigint      NOT NULL AUTO_INCREMENT,
    name varchar(16) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO brand (id, name) VALUES (1, 'ZARA');