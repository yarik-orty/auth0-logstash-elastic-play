CREATE TABLE users(
  id                    INTEGER         PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  email                 TEXT            NOT NULL,
  password              TEXT            NOT NULL,
  name                  TEXT            NOT NULL,
  role                  TEXT            NOT NULL,
  created_at            TIMESTAMPTZ     NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE devices(
  id                       INTEGER          PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  user_id                  INTEGER          NOT NULL,
  name                     TEXT             NOT NULL,
  imei                     TEXT             NOT NULL,
  serial_number            TEXT             NOT NULL,
  updated_at               TIMESTAMPTZ      ,
  created_at               TIMESTAMPTZ      NOT NULL DEFAULT CURRENT_TIMESTAMP
);
