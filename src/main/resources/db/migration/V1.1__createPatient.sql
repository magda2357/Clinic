CREATE TABLE patient
(
    id            BIGSERIAL PRIMARY KEY,
    date_of_birth DATE NOT NULL,
    first_name    VARCHAR(25) NOT NULL,
    gender        VARCHAR(6) NOT NULL,
    last_name     VARCHAR(25) NOT NULL,
    pesel         VARCHAR(11) NOT NULL
);