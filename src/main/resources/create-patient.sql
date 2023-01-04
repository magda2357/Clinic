create table patient
(
    id            bigserial
        constraint patient_pkey
            primary key,
    date_of_birth date,
    first_name    varchar(255),
    gender        integer,
    last_name     varchar(255),
    pesel         varchar(11)
);

alter table patient
    owner to postgres;