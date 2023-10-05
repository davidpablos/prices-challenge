CREATE TABLE price
(
    id         bigint      NOT NULL AUTO_INCREMENT,
    brand_id   bigint      NOT NULL,
    start_date datetime    NOT NULL,
    end_date   datetime    NOT NULL,
    price_list bigint      NOT NULL,
    product_id bigint      NOT NULL,
    priority   int         NOT NULL,
    price      double      NOT NULL,
    currency   varchar(4)  NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT price_brand_id_fk FOREIGN KEY (brand_id) REFERENCES brand (id)
);

INSERT INTO price (id, brand_id, start_date, end_date, price_list, product_id, priority, price, currency)
VALUES (1, 1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 1, 35455, 0, 35.50, 'EUR');

INSERT INTO price (id, brand_id, start_date, end_date, price_list, product_id, priority, price, currency)
VALUES (2, 1, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 2, 35455, 1, 25.45, 'EUR');

INSERT INTO price (id, brand_id, start_date, end_date, price_list, product_id, priority, price, currency)
VALUES (3, 1, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 3, 35455, 1, 30.50, 'EUR');

INSERT INTO price (id, brand_id, start_date, end_date, price_list, product_id, priority, price, currency)
VALUES (4, 1, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 4, 35455, 1, 38.95, 'EUR');