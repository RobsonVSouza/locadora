CREATE TABLE rentals (
    id BIGSERIAL PRIMARY KEY,
    start_date TIMESTAMP,
    end_date TIMESTAMP,
    total NUMERIC(19, 2),
    created_at TIMESTAMP NOT NULL DEFAULT now(),
    updated_at TIMESTAMP NOT NULL DEFAULT now()
);
