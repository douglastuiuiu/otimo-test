DROP DATABASE IF EXISTS otimo_empresas;
CREATE DATABASE otimo_empresas;
\connect otimo_empresas;

DROP SCHEMA IF EXISTS cademp CASCADE;
CREATE SCHEMA cademp AUTHORIZATION postgres;

CREATE TYPE cademp.tipo_empresa AS ENUM ('FILIAL', 'MATRIZ');

CREATE TABLE cademp.empresa (
	"id" serial NOT NULL,
	"cnpj" varchar(14) NOT NULL UNIQUE,
	"nome" varchar(50) NOT NULL,
	"tipo" cademp.tipo_empresa NOT NULL,
  "empresa_matriz" bigint NULL,
	"razao_social" varchar(40) NOT NULL,
	"contato" varchar(40) NOT NULL,
	"email" varchar(40) NOT NULL,
	"cep" varchar(8) NOT NULL,
	"estado" varchar(40) NOT NULL,
	"bairro" varchar(40) NOT NULL,
	"cidade" varchar(40) NOT NULL,
	"logradouro" varchar(40) NOT NULL,
	"complemento" varchar(40) NULL,
	CONSTRAINT "empresa_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);

ALTER TABLE cademp.empresa ADD CONSTRAINT empresa_matriz_fk FOREIGN KEY (empresa_matriz) REFERENCES cademp.empresa(id) ON DELETE RESTRICT;
