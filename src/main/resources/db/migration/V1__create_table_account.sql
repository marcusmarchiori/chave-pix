CREATE TABLE account (
  id_account BIGSERIAL NOT NULL,
  bank TEXT NOT NULL,
  type_account TEXT NOT NULL,
  num_account NUMERIC(15,2) NOT NULL,
  balance_account NUMERIC(15,2) NOT NULL,
  type_key TEXT NOT NULL,
  key_enum TEXT NOT NULL,
  CONSTRAINT account_pk PRIMARY KEY (id_account)
);

