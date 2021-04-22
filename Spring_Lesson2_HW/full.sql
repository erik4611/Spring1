BEGIN;

DROP TABLE IF EXISTS simple_products CASCADE;
CREATE TABLE simple_products (id bigserial PRIMARY KEY, title VARCHAR(255), price int);
INSERT INTO simple_products (title, price) VALUES
('brick', 210),
('concrete', 220),
('stairs', 200),
('door', 550),
('paint', 350),
('plastic', 400);

COMMIT;