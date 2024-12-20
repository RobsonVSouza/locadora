CREATE TABLE specification (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    created_at TIMESTAMP NOT NULL,
);
