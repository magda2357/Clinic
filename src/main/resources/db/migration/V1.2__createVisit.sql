CREATE TABLE visit
(
    id         BIGSERIAL PRIMARY KEY,
    visit_date DATE NOT NULL,
    patient_id BIGSERIAL,
    FOREIGN KEY (patient_id) REFERENCES patient (id)
);