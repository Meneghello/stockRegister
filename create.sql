
    create table client (
        active_register boolean,
        birth_date date,
        client_id serial not null,
        last_update_date timestamp(6),
        registration_date timestamp(6),
        client_cpf varchar(255) not null,
        name varchar(255),
        second_name varchar(255),
        primary key (client_cpf)
    );
