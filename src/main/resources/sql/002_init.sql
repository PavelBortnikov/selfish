BEGIN TRANSACTION;

DROP TABLE IF EXISTS SENTENCES CASCADE;
DROP SEQUENCE IF EXISTS SENTENCES_SEQ CASCADE;

CREATE SEQUENCE SENTENCES_SEQ START 1;

CREATE TABLE SENTENCES(
  ID BIGINT PRIMARY KEY DEFAULT NEXTVAL('SENTENCES_SEQ'),
  SENTENCE TEXT NOT NULL
);

END TRANSACTION;