ALTER TABLE visit
    ADD COLUMN visit_date_time TIMESTAMP NOT NULL,
    ADD COLUMN paid VARCHAR(3) NOT NULL,
    ADD COLUMN description VARCHAR(500) NOT NULL,
    ADD COLUMN payment VARCHAR(8) NOT NULL;

ALTER TABLE visit
    DROP COLUMN visit_date;