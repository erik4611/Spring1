BEGIN;

DROP TABLE IF EXISTS categories CASCADE;
CREATE TABLE categories (id bigserial PRIMARY KEY, title VARCHAR(255));
INSERT INTO categories (title) VALUES
('automobiles'),
('motorbikes');

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id bigserial PRIMARY KEY, title VARCHAR(255), price int, categories_id bigint REFERENCES categories (id));
INSERT INTO products (title, price, categories_id) VALUES
('Yamaha_XVS', 250, 2),
('Honda_VTX', 280, 2),
('Honda_CBR', 380, 2),
('Kawasaki_H2R', 480, 2),
('Honda_S2000', 580, 1),
('Mitsubishi_Lancer', 580, 1),
('Mitsubishi_Outlander', 680, 1);

COMMIT;