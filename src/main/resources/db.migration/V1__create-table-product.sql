CREATE TABLE product
(
    id             TEXT PRIMARY KEY UNIQUE NOT NULL,
    name           TEXT                    NOT NULL,
    description    TEXT                    NOT NULL,
    price_in_cents INT                     NOT NULL,
    category_id    TEXT REFERENCES category (id),
    image          TEXT
)