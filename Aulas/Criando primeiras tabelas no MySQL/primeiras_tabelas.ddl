CREATE TABLE cliente (
  codigo BIGINT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  idade INTEGER,
  sexo VARCHAR(1) NOT NULL,
  profissao VARCHAR(30),
  PRIMARY KEY (codigo)
);

CREATE TABLE conta_corrente (
  codigo BIGINT NOT NULL AUTO_INCREMENT,
  numero VARCHAR(12) NOT NULL,
  saldo DECIMAL,
  codigo_cliente BIGINT NOT NULL,
  PRIMARY KEY (codigo),
  FOREIGN KEY (codigo_cliente) REFERENCES cliente (codigo)
);