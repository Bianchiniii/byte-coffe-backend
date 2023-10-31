CREATE TABLE address
(
    id             TEXT PRIMARY KEY UNIQUE NOT NULL,
    street         TEXT                    NOT NULL,
    neighborhood   TEXT                    NOT NULL,
    number         TEXT                    NOT NULL,
    city_and_state TEXT                    NOT NULL,
    profile_id     TEXT REFERENCES users (id)
)