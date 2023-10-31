CREATE TABLE users
(
    id            TEXT PRIMARY KEY UNIQUE NOT NULL,
    email         TEXT                    NOT NULL UNIQUE,
    name          TEXT                    NOT NULL,
    surname       TEXT                    NOT NULL,
    user_password TEXT                    NOT NULL,
    role          TEXT                    NOT NULL
);