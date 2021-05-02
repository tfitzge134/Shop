-- SCHEMA: shop

-- DROP SCHEMA shop ;

CREATE SCHEMA shop
    AUTHORIZATION postgres;
    
-- Table: shop.user

-- DROP TABLE shop."user";

CREATE TABLE shop."user"
(
    firstname character varying(20) COLLATE pg_catalog."default",
    lastname character varying(20) COLLATE pg_catalog."default",
    email character varying(50) COLLATE pg_catalog."default" NOT NULL,
    phonenumber character varying(14) COLLATE pg_catalog."default",
    customersince date,
    password character varying(20) COLLATE pg_catalog."default" NOT NULL,
    "accountNumber" integer,
    id integer NOT NULL DEFAULT nextval('shop.customer_id_seq'::regclass),
    role character varying COLLATE pg_catalog."default",
    CONSTRAINT customer_pkey PRIMARY KEY (id),
    CONSTRAINT email_unique UNIQUE (email)
)

TABLESPACE pg_default;

ALTER TABLE shop."user"
    OWNER to postgres;

-- Table: shop.items

-- DROP TABLE shop.items;

CREATE TABLE shop.items
(
    itemname character varying(20) COLLATE pg_catalog."default",
    itemprice numeric,
    item_promotion_discount numeric,
    item_quantity integer,
    promotion_start_date date,
    promotion_end_date date,
    itemid integer NOT NULL DEFAULT nextval('shop.item_itemid_seq'::regclass),
    CONSTRAINT item_pkey PRIMARY KEY (itemid)
)

TABLESPACE pg_default;

ALTER TABLE shop.items
    OWNER to postgres;
    
-- Table: shop.itemoffer

-- DROP TABLE shop.itemoffer;

CREATE TABLE shop.itemoffer
(
    id integer NOT NULL DEFAULT nextval('shop."itemPurchase_id_seq"'::regclass),
    item_id integer NOT NULL,
    customer_id integer NOT NULL,
    offer_price double precision NOT NULL,
    offer_date date NOT NULL,
    quantity integer NOT NULL,
    is_accepted boolean,
    plan_weeks_count integer NOT NULL,
    is_paid boolean,
    paid_weeks_count integer DEFAULT 0,
    CONSTRAINT "itemPurchase_pkey" PRIMARY KEY (id),
    CONSTRAINT itemoffer_fk FOREIGN KEY (item_id)
        REFERENCES shop.items (itemid) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT itemoffer_fk_1 FOREIGN KEY (customer_id)
        REFERENCES shop."user" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE shop.itemoffer
    OWNER to postgres;
    
-- Table: shop.payment

-- DROP TABLE shop.payment;

CREATE TABLE shop.payment
(
    id integer NOT NULL DEFAULT nextval('shop.payment_id_seq'::regclass),
    itemoffer_id integer NOT NULL,
    amount double precision NOT NULL,
    paid_date date NOT NULL,
    user_id smallint NOT NULL DEFAULT nextval('shop.payment_user_id_seq'::regclass),
    CONSTRAINT payment_pkey PRIMARY KEY (id),
    CONSTRAINT payment_fk FOREIGN KEY (itemoffer_id)
        REFERENCES shop.itemoffer (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE shop.payment
    OWNER to postgres;
-- Index: fki_fk_user_id

-- DROP INDEX shop.fki_fk_user_id;

CREATE INDEX fki_fk_user_id
    ON shop.payment USING btree
    (user_id ASC NULLS LAST)
    TABLESPACE pg_default;
    
