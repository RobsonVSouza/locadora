CREATE TABLE car (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    daily_rate NUMERIC(38, 2),
    avaliable INTEGER NOT NULL CHECK (avaliable >= 1 AND avaliable <= 5),
    license_plate VARCHAR(255),
    created_at TIMESTAMP NOT NULL,
    color VARCHAR(255),
    brand_id BIGINT,
    category_id BIGINT, -- Adiciona a coluna category_id
    CONSTRAINT fk_brand FOREIGN KEY (brand_id) REFERENCES brand(id),
    CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES categories(id) -- Define a chave estrangeira
);
