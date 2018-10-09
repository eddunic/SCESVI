-- BANCO DE DADOS
DROP DATABASE SCESVI;

CREATE DATABASE SCESVI;

USE SCESVI;

-- COMANDO ESPECIAL
SET SQL_SAFE_UPDATES = 0; -- TIRA PROTECAO PARA COMANDO FUNCIONAR

-- Estruturas das tabelas
DESCRIBE SERVIDOR;
DESCRIBE TELEFONE;
DESCRIBE VEICULO;
DESCRIBE SOLICITACAO;
DESCRIBE REGISTRO;
DESCRIBE HISTORICOPERCURSO;
DESCRIBE DEPARTAMENTO;
DESCRIBE LOTADO;
DESCRIBE CARGO;
DESCRIBE CONTRATADO;

-- SELECT'S * TABELAS
SELECT * FROM SERVIDOR;
SELECT * FROM TELEFONE;
SELECT * FROM VEICULO;
SELECT * FROM SOLICITACAO;
SELECT * FROM REGISTRO;
SELECT * FROM HISTORICOPERCURSO;
SELECT * FROM DEPARTAMENTO;
SELECT * FROM LOTADO;
SELECT * FROM CARGO;
SELECT * FROM CONTRATADO;

-- DROP'S TABELAS
DROP TABLE SERVIDOR;
DROP TABLE TELEFONE;
DROP TABLE VEICULO;
DROP TABLE SOLICITACAO;
DROP TABLE REGISTRO;
DROP TABLE HISTORICOPERCURSO;
DROP TABLE DEPARTAMENTO;
DROP TABLE LOTADO;
DROP TABLE CARGO;
DROP TABLE CONTRATADO;

CREATE TABLE SERVIDOR(
	matricula VARCHAR(12) NOT NULL PRIMARY KEY,
    login VARCHAR(50) NOT NULL,
    senha VARCHAR(50) NOT NULL,
    CNH VARCHAR(11) NOT NULL,
    categoria CHAR NOT NULL,
    SIAPE VARCHAR(11) NOT NULL,
    autorizadoVeicInstitucional CHAR,
    CPF VARCHAR(11) NOT NULL,
    nome VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    matSupervisor VARCHAR(12) NOT NULL,
    FOREIGN KEY(matSupervisor) REFERENCES SERVIDOR(matricula)
	ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE TELEFONE(
	matServ VARCHAR(12) NOT NULL,
    telefone VARCHAR(11) NOT NULL,
    PRIMARY KEY(matServ, telefone),
    FOREIGN KEY(matServ) REFERENCES SERVIDOR(matricula)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE VEICULO(
    codigo VARCHAR(7) NOT NULL PRIMARY KEY,
    tipo VARCHAR(10) NOT NULL,
    placa VARCHAR(7) NOT NULL,
	RENAVAM VARCHAR(30) NOT NULL UNIQUE,
    autorizado CHAR,
    categoria CHAR,
    institucional CHAR,
    chassi VARCHAR(10) NOT NULL,
    maxPassageiros SMALLINT(2) NOT NULL,
    observacao VARCHAR(150),
    exercicio VARCHAR(4) NOT NULL,
    tipoCombustivel CHAR NOT NULL,
    potencia FLOAT(8) NOT NULL,
    cor VARCHAR(15) NOT NULL,
    marcaModelo VARCHAR(10) NOT NULL,
    anoFabricacao VARCHAR(4) NOT NULL,
    anoModelo VARCHAR(4) NOT NULL,
    dataSupervisionado VARCHAR(8),
    matServSupervisiona VARCHAR(12) NOT NULL,
    matServResponsavel VARCHAR(12) NOT NULL,
	FOREIGN KEY(matServSupervisiona) REFERENCES SERVIDOR(matricula)
	ON DELETE CASCADE
    ON UPDATE CASCADE,
	FOREIGN KEY(matServResponsavel) REFERENCES SERVIDOR(matricula)
	ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE SOLICITACAO(
	numero INT(4) NOT NULL PRIMARY KEY,
    veiculoRequisitado VARCHAR(50) NOT NULL,
    dataVeiculoConfirmado VARCHAR(8) NULL,
    dataInicio VARCHAR(8) NOT NULL,
    dataFim VARCHAR(8) NOT NULL,
    horaCriacao VARCHAR(4) NOT NULL,
    dataCriacao VARCHAR(8) NOT NULL,
    localViagem VARCHAR(50) NOT NULL,
    horaAutorizado VARCHAR(4),
    dataAutorizado VARCHAR(8),
    qtdePassageiros SMALLINT(2) NOT NULL,
    tipo CHAR NOT NULL,
    finalidade VARCHAR(150) NOT NULL,
    matServAutoriza VARCHAR(12) NOT NULL,
    matServRealiza VARCHAR(12) NOT NULL,
    codVeiculoAtende VARCHAR(12) NOT NULL,
    FOREIGN KEY(matServAutoriza) REFERENCES SERVIDOR(matricula)
	ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY(matServRealiza) REFERENCES SERVIDOR(matricula)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
CREATE TABLE REGISTRO(
	numero INT (4) NOT NULL PRIMARY KEY,
    observacao VARCHAR(150),
    codVeiculo VARCHAR(10) NOT NULL,
    matServInicia VARCHAR(12) NOT NULL,
    matServEncerra VARCHAR(12) NOT NULL,
    matServGerencia VARCHAR(12) NOT NULL,
    matServConsulta VARCHAR(12) NOT NULL,
    horaInicia VARCHAR(4) NOT NULL,
    dataInicia VARCHAR(8) NOT NULL,
    horaSaida VARCHAR(4),
    dataSaida VARCHAR(4),
    dataEntrada VARCHAR(8),
    horaEntrada VARCHAR(4),
    horaEncerra VARCHAR(4),
    dataEncerra VARCHAR(8),
    descricao VARCHAR(150) NOT NULL,
    kmInicial SMALLINT(2),
    kmFinal SMALLINT(2),
    kmPercorridos SMALLINT(2),
    dataSupervisionado VARCHAR(8),
    FOREIGN KEY(codVeiculo) REFERENCES VEICULO(codigo)
	ON DELETE CASCADE
    ON UPDATE CASCADE,
	FOREIGN KEY(matServInicia) REFERENCES SERVIDOR(matricula)
	ON DELETE CASCADE
    ON UPDATE CASCADE,
	FOREIGN KEY(matServEncerra) REFERENCES SERVIDOR(matricula)
	ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY(matServGerencia) REFERENCES SERVIDOR(matricula)
	ON DELETE CASCADE
    ON UPDATE CASCADE,
	FOREIGN KEY(matSerbConsulta) REFERENCES SERVIDOR(matricula)
	ON DELETE CASCADE
    ON UPDATE CASCADE);
    
CREATE TABLE HISTORICOPERCURSO(
	numeroRegistro INT(4) NOT NULL,
    histPerc VARCHAR(300) NOT NULL,
    PRIMARY KEY(numeroRegistro, histPerc),
    FOREIGN KEY(numeroRegistro) REFERENCES REGISTRO(numero)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
CREATE TABLE DEPARTAMENTO(
	codigo SMALLINT(2) NOT NULL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    sigla VARCHAR(10) NOT NULL);
    
CREATE TABLE LOTADO(
	matServ VARCHAR(12) NOT NULL,
    codDep SMALLINT(2) NOT NULL,
    dataInicio VARCHAR(8) NOT NULL,
    dataFim VARCHAR(8),
    PRIMARY KEY(matServidor, codDep, dataInicio),
    FOREIGN KEY (matServ) REFERENCES SERVIDOR(matricula)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY(codDep) REFERENCES DEPARTAMENTO(codigo)
	ON DELETE CASCADE
    ON UPDATE CASCADE);
    
CREATE TABLE CARGO(
	codigo SMALLINT(2) NOT NULL PRIMARY KEY,
    titulacao VARCHAR(20) NOT NULL);
    
CREATE TABLE CONTRATADO(
	matServ VARCHAR(12) NOT NULL,
    codCargo SMALLINT(2) NOT NULL,
    dataInicio VARCHAR(8) NOT NULL,
    dataFim VARCHAR(8),
    PRIMARY KEY(matServ, codCargo),
    FOREIGN KEY(matServ) REFERENCES SERVIDOR(matricula)
	ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY(codCargo) REFERENCES CARGO(codigo)
	ON DELETE CASCADE
    ON UPDATE CASCADE);
    
-- Consultas
-- 1) Listar a quantidade, o codigo, a placa e o tipo de todos os veiculos institucionais
SELECT count(*), codigo, placa, tipo
FROM VEICULO
WHERE institucional IS NOT NULL;

-- 2) Listar a categoria e a CNH de todos os servidores que possuem o sobrenome Silva e que estão autorizados a conduzir veiculo institucional
SELECT categoria, CNH
FROM SERVIDOR
WHERE nome LIKE '%Silva%' AND autorizadoVeicInstitucional IS NOT NULL;

-- 3) Listar o numero e a finalidade das Solicitacoes autorizadas no mes de agosto de 2017 em que o veiculo que atendeu tinha capacidade maz=xima de 20 pessoas 
SELECT numero, finalidade
FROM VEICULO, SOLICITACAO 
WHERE dataAutoriza = '__082017' AND codVeiculo = codVeiculoAtende AND maxPassageiros = 20;

-- 4) Listar a matricula e o nome de todos os proprietarios de veiculos, bem como o codigo e a placa dos veiculos

SELECT matricula, nome, codigo, placa
FROM SERVIDOR, VEICULO
WHERE matServResponsavel = matricula;