CREATE TABLE imagem (
    id BIGSERIAL PRIMARY KEY,
    image VARCHAR(255),
    created_at TIMESTAMP NOT NULL,
    car_id BIGINT NOT NULL,
    CONSTRAINT fk_car FOREIGN KEY (car_id) REFERENCES car(id)
);
