-- =========================================================
-- PostgreSQL version of your MySQL script
-- Author: felipe
-- Created: 2017-10-28
-- =========================================================

-- 1) Create the database (PostgreSQL doesn't need IF NOT EXISTS here in older versions).
--    If it already exists, this will error; run conditionally if you prefer.
CREATE DATABASE bd_autenticacao;

-- 2) Create a login role (user) and set its password.
--    There is no host qualifier like 'root'@'%' in Postgres.
--    Avoid double quotes around identifiers unless you want case-sensitivity.
CREATE USER root WITH PASSWORD 'felipe@mota#';

-- 3) Give this user rights on the database and make them the owner if desired.
GRANT ALL PRIVILEGES ON DATABASE bd_autenticacao TO root;

-- (Optional but common) make root the owner of the database:
-- ALTER DATABASE bd_autenticacao OWNER TO root;

-- 4) Connect to the database to create objects.
\connect bd_autenticacao

-- 5) Create the table. Use GENERATED AS IDENTITY instead of AUTO_INCREMENT,
--    and single quotes for string literals.
CREATE TABLE public.autenticacao_usuario (
    id_autenticacao_usuario INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    usuario                 VARCHAR(15)  NOT NULL,
    senha                   VARCHAR(20)  NOT NULL,
    status_de_previlegio    INTEGER      NOT NULL,
    nome_usuario            VARCHAR(45)  NOT NULL
);

-- 6) (Optional) Ensure the new user has privileges on the schema and future tables.
GRANT USAGE ON SCHEMA public TO root;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO root;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO root;

-- For tables/sequences created later, set default privileges:
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON TABLES TO root;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON SEQUENCES TO root;

-- 7) Inserts (use single quotes in Postgres).
INSERT INTO public.autenticacao_usuario (usuario, senha, status_de_previlegio, nome_usuario)
VALUES ('adm', 'adm', 1, 'FELIPE VIEIRA MOTA');

INSERT INTO public.autenticacao_usuario (usuario, senha, status_de_previlegio, nome_usuario)
VALUES ('caio', '789', 1, 'CAIO VINICIUS');

-- 8) Query the data.
SELECT * FROM public.autenticacao_usuario;

-- Notes (MySQL → PostgreSQL):
-- - ENGINE=innodb is MySQL-only; removed.
-- - DESC/SHOW are MySQL commands. In psql, use:
--     \d public.autenticacao_usuario   -- describe table
--     \dt                              -- list tables
-- - Double quotes are for identifiers; single quotes are for strings.
