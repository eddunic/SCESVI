DROP DATABASE SCESVI;

CREATE DATABASE SCESVI;

USE SCESVI;

CREATE TABLE SERVIDOR(
    siape VARCHAR(11) NOT NULL PRIMARY KEY,
    cpf CHAR(11) NOT NULL,
    nome VARCHAR(50) NOT NULL,
    senha VARCHAR(50) NOT NULL,
    dataNasc VARCHAR(8) NOT NULL,
    cnh VARCHAR(11),
    categoria CHAR,
    autorizadoVeicInstitucional CHAR NOT NULL);

CREATE TABLE TELEFONE(
	siapeServ VARCHAR(12) NOT NULL,
    telefone VARCHAR(11) NOT NULL,
    PRIMARY KEY(siapeServ, telefone),
    FOREIGN KEY(siapeServ) REFERENCES SERVIDOR(matricula)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
CREATE TABLE DEPARTAMENTO(
	codigo SMALLINT NOT NULL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    sigla VARCHAR(10) NOT NULL);
    
INSERT INTO DEPARTAMENTO 
VALUES
(1, 'Departamento Acadêmico de Informação e Comunicação', 'DAIC'),
(2, 'Departamento Acadêmico de Infraestrutura', 'DAINFRA'),
(3, 'Departamento de Química e Alimentos', 'DQA'),
(4, 'Departamento de alguma coisa que eu não sei', 'DGP'),
(5, 'Departamento de Processos Industriais','DPI'),
(6, 'Departamento de Tecnologia da Informação', 'DTI');

CREATE TABLE LOTADO(
	siapeServ VARCHAR(12) NOT NULL,
    codDep SMALLINT(2) NOT NULL,
    dataInicio VARCHAR(8) NOT NULL,
    dataFim VARCHAR(8),
    PRIMARY KEY(siapeServ, codDep, dataInicio),
    FOREIGN KEY (siapeServ) REFERENCES SERVIDOR(siape)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY(codDep) REFERENCES DEPARTAMENTO(codigo)
	ON DELETE CASCADE
    ON UPDATE CASCADE);
    
CREATE TABLE CARGO(
	codigo SMALLINT(2) NOT NULL PRIMARY KEY,
    titulacao VARCHAR(20) NOT NULL);
    
INSERT INTO CARGO
VALUES
(1, 'Coordenador'),
(2, 'Guarda'),
(3, 'Motorista'),
(4, 'Servidor comum');

CREATE TABLE CONTRATADO(
	siapeServ VARCHAR(12) NOT NULL,
    codCargo SMALLINT(2) NOT NULL,
    dataInicio VARCHAR(8) NOT NULL,
    dataFim VARCHAR(8),
    PRIMARY KEY(siapeServ, codCargo),
    FOREIGN KEY(siapeServ) REFERENCES SERVIDOR(siape)
	ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY(codCargo) REFERENCES CARGO(codigo)
	ON DELETE CASCADE
    ON UPDATE CASCADE);
    
SELECT * FROM SERVIDOR;
    
SELECT * FROM DEPARTAMENTO;

SELECT * FROM LOTADO;

SELECT * FROM CONTRATADO;

SELECT siapeServ, codDep
FROM LOTADO;

SELECT siapeServ, codCargo, dataInicio
FROM CONTRATADO;

SELECT SERVIDOR.nome, DEPARTAMENTO.sigla, CARGO.titulacao
FROM SERVIDOR INNER JOIN LOTADO
ON SERVIDOR.siape = LOTADO.siapeServ
INNER JOIN DEPARTAMENTO
ON DEPARTAMENTO.codigo = LOTADO.codDep
INNER JOIN CONTRATADO
ON SERVIDOR.siape = CONTRATADO.siapeServ
INNER JOIN CARGO
ON CARGO.codigo = CONTRATADO.codCargo
GROUP BY SERVIDOR.nome;



