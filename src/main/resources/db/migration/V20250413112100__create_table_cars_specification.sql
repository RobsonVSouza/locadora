CREATE TABLE cars_specification (
    id BIGSERIAL PRIMARY KEY,
    car_id BIGINT NOT NULL,
    specification_id BIGINT NOT NULL,
    CONSTRAINT fk_car FOREIGN KEY (car_id) REFERENCES car (id) ON DELETE CASCADE,
    CONSTRAINT fk_specification FOREIGN KEY (specification_id) REFERENCES specification (id) ON DELETE CASCADE
);
