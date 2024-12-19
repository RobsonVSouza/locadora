
CREATE TABLE brand (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    created_at timestamp NOT NULL,
);
