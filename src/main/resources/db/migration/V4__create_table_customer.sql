CREATE TABLE customer (
  id_customer BIGSERIAL NOT NULL,
  id_address BIGSERIAL NOT NULL,
  id_account BIGSERIAL NOT NULL,
  name TEXT NOT NULL,
  document TEXT NOT NULL,
  birth_date DATE NOT NULL,
  email TEXT NOT NULL,
  telephone TEXT NOT NULL,
  CONSTRAINT customer_pk PRIMARY KEY (id_customer)
);

ALTER TABLE customer ADD CONSTRAINT id_address_fk FOREIGN KEY (id_address) REFERENCES address (id_address);
ALTER TABLE customer ADD CONSTRAINT id_account_fk FOREIGN KEY (id_account) REFERENCES account (id_account);