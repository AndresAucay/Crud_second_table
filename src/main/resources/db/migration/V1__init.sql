CREATE TABLE IF NOT EXISTS plane (
    id SERIAL,
    modelo VARCHAR(100) NOT NULL,
    motores VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS motor (
    id SERIAL,
    brand VARCHAR(100) NOT NULL,
    description VARCHAR(100) NOT NULL,
    plane_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (plane_id ) REFERENCES plane(id)
);