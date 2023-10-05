create table client
(
    active_register   boolean,
    birth_date        date,
    client_id         serial       not null,
    last_update_date  timestamp(6),
    registration_date timestamp(6),
    client_cpf        varchar(255) not null,
    name              varchar(255),
    second_name       varchar(255),
    CONSTRAINT client_pkey PRIMARY KEY (client_cpf)
);
CREATE TABLE wallet
(
    client_cpf          bigint                                         NOT NULL,
    wallet_id           character varying COLLATE pg_catalog."default" NOT NULL,
    total_account_value numeric(10, 2),
    registration_date   time without time zone,
    CONSTRAINT wallet_pkey PRIMARY KEY (client_cpf, wallet_id),
    CONSTRAINT "client_cpf_Fk" FOREIGN KEY (client_cpf)
        REFERENCES public.client (client_cpf) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

