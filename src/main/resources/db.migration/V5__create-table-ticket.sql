CREATE TABLE ticket
(
    id             TEXT PRIMARY KEY UNIQUE NOT NULL,
    profile_id     TEXT REFERENCES users (id),
    total_in_cents INT                     NOT NULL,
    order_status   TEXT                    NOT NULL,
    created_at     DATE                    NOT NULL,
    updated_at     DATE
);

CREATE TABLE order_products
(
    id         TEXT PRIMARY KEY UNIQUE NOT NULL,
    order_id   TEXT REFERENCES ticket (id),
    product_id TEXT REFERENCES product (id),
    quantity   INT                     NOT NULL
)