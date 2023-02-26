CREATE TABLE address (
  id_address BIGSERIAL NOT NULL,
  street TEXT NOT NULL,
  number TEXT NOT NULL,
  complement TEXT NOT NULL,
  neighborhood TEXT NOT NULL,
  city TEXT NOT NULL,
  state TEXT NOT NULL,
  CONSTRAINT address_pk PRIMARY KEY (id_address)
);