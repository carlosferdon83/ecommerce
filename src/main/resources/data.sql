DROP TABLE IF EXISTS producto;

CREATE TABLE products
(
    product_id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    sku VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL,
    stock INT NOT NULL,
    type VARCHAR(30)
);
CREATE TABLE cart
(
    cart_id VARCHAR(255) PRIMARY KEY,
    total_price DOUBLE NOT NULL,
    status VARCHAR(255) NOT NULL
);
CREATE TABLE cartitems
(
    cart_item_id VARCHAR(255) PRIMARY KEY,
    price_item DOUBLE NOT NULL,
    product_id VARCHAR(255) NOT NULL,
    quantity INT NOT NULL,
    cart_id VARCHAR(255) NOT NULL,
    FOREIGN KEY (cart_id) REFERENCES cart (cart_id),
    FOREIGN KEY (product_id) REFERENCES products (product_id)
);




