DROP DATABASE SCESVI;

CREATE DATABASE SCESVI;

USE SCESVI;

CREATE TABLE SERVIDOR(
    siape CHAR(8) NOT NULL PRIMARY KEY,
    cpf CHAR(11) NOT NULL,
    nome VARCHAR(50) NOT NULL,
    senha VARCHAR(50) NOT NULL,
    dataNasc VARCHAR(8) NOT NULL,
    cnh CHAR(11),
    categoria CHAR,
    autorizadoVeicInstitucional CHAR NOT NULL);

CREATE TABLE TELEFONE(
	siapeServ CHAR(8) NOT NULL,
    telefone VARCHAR(11) NOT NULL,
    PRIMARY KEY(siapeServ, telefone),
    FOREIGN KEY(siapeServ) REFERENCES SERVIDOR(siape)
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
	siapeServ CHAR(8) NOT NULL,
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
	siapeServ CHAR(8) NOT NULL,
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
    
CREATE TABLE SOLICITACAO(
	numero INT(4) NOT NULL PRIMARY KEY,
    veiculoRequisitado VARCHAR(50) NOT NULL,
    dataVeiculoConfirmado VARCHAR(8),
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
    siapeServAutoriza CHAR(8) NOT NULL,
    siapeServRealiza CHAR(8) NOT NULL,
    FOREIGN KEY(siapeServAutoriza) REFERENCES SERVIDOR(siape)
	ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY(siapeServRealiza) REFERENCES SERVIDOR(siape)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
DROP TABLE SOLICITACAO;
    
INSERT INTO SOLICITACAO VALUES
(2412, 'iiAa', '112391', '321711', '124242', '1563', '637222', 'sdgif', '3411', '231020', 0, 'w', 'sla', '321', '371'),
(2112, 'Mua', '115191', '112711', '124282', '1163', '627222', 'sagia', '1411', '251020', 7, 'p', 'dla', '331', '321');

CREATE TABLE VEICULO(
    codigo VARCHAR(7) NOT NULL PRIMARY KEY,
    tipo VARCHAR(10) NOT NULL,
    placa VARCHAR(7) NOT NULL,
	renavam VARCHAR(30) NOT NULL UNIQUE,
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
    siapeServSupervisiona CHAR(8) NOT NULL,
    siapeServResponsavel CHAR(8) NOT NULL,
	FOREIGN KEY(siapeServSupervisiona) REFERENCES SERVIDOR(siape)
	ON DELETE CASCADE
    ON UPDATE CASCADE,
	FOREIGN KEY(siapeServResponsavel) REFERENCES SERVIDOR(siape)
	ON DELETE CASCADE
    ON UPDATE CASCADE);
    
INSERT INTO VEICULO VALUES
('1', 'a', 's', 'er', 'd', 'c', 'n', 'wer', 12, 'nda', '1234', 'g', 13, 'verde', 'eila', '1954', '2003', '1212', '123', '321');

CREATE TABLE REGISTRO(
	numero INT (4) NOT NULL PRIMARY KEY,
    observacao VARCHAR(150),
    codVeiculo VARCHAR(7) NOT NULL,
    siapeServInicia CHAR(8) NOT NULL,
    siapeServEncerra CHAR(8) NOT NULL,
    siapeServResponsavel CHAR(8) NOT NULL,
    horaInicia VARCHAR(4) NOT NULL,
    dataInicia VARCHAR(8) NOT NULL,
    horaSaida VARCHAR(4),
    dataSaida VARCHAR(8),
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
	FOREIGN KEY(siapeServInicia) REFERENCES SERVIDOR(siape)
	ON DELETE CASCADE
    ON UPDATE CASCADE,
	FOREIGN KEY(siapeServEncerra) REFERENCES SERVIDOR(siape)
	ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY(siapeServResponsavel) REFERENCES SERVIDOR(siape)
	ON DELETE CASCADE
    ON UPDATE CASCADE);
    
INSERT INTO REGISTRO VALUES
(2, 'sla', 'cod', '111', '222', '333', '1234', '123121', '1231', '131212', '121315', '1019', '0918', '463728', 'ndaq', 14, 12, 18, '131313');

SELECT * FROM REGISTRO;

SELECT * FROM VEICULO;

SELECT * FROM SOLICITACAO;
    
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

-- Servidor

DELIMITER $$
USE SCESVI $$
DROP PROCEDURE IF EXISTS sp_InsertServidor $$
CREATE PROCEDURE sp_InsertServidor (IN siape CHAR(8), IN cpf CHAR(11), IN nome VARCHAR(50), IN senha VARCHAR(50), IN dataNasc VARCHAR(8), IN cnh VARCHAR(11), IN categoria CHAR, IN autorizadoVeicInstitucional CHAR)
BEGIN
	INSERT INTO SERVIDOR VALUES(siape, cpf, nome, senha, dataNasc, cnh, categoria, autorizadoVeicInstitucional);
END $$
DELIMITER ;

DELIMITER $$
USE SCESVI $$
DROP PROCEDURE IF EXISTS sp_DeleteServidor $$
CREATE PROCEDURE sp_DeleteServidor (IN siape CHAR(11))
BEGIN
	DELETE FROM SERVIDOR WHERE SERVIDOR.siape = siape;
END $$
DELIMITER ;

DELIMITER $$
USE SCESVI $$
DROP PROCEDURE IF EXISTS sp_ConsultServidor $$
CREATE PROCEDURE sp_ConsultServidor (IN siape CHAR(11))
BEGIN
	SELECT * FROM SERVIDOR WHERE SERVIDOR.siape = siape;
END $$
DELIMITER ;

DELIMITER $$
USE SCESVI $$
DROP PROCEDURE IF EXISTS sp_ListServidor $$
CREATE PROCEDURE sp_ListServidor ()
BEGIN
	SELECT * FROM SERVIDOR;
END $$
DELIMITER ;

DELIMITER $$
USE SCESVI $$
DROP PROCEDURE IF EXISTS sp_ListNomeDepCargo $$
CREATE PROCEDURE sp_ListNomeDepCargo ()
BEGIN
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
END $$
DELIMITER ;

-- Cargo

DELIMITER $$
USE SCESVI $$
DROP PROCEDURE IF EXISTS sp_SearchCargo $$
CREATE PROCEDURE sp_SearchCargo (IN cargo VARCHAR(20))
BEGIN
    SELECT codigo FROM CARGO WHERE titulacao = + "'" + cargo + "'";
END $$
DELIMITER ;

-- Departamento

DELIMITER $$
USE SCESVI $$
DROP PROCEDURE IF EXISTS sp_SearchDepart $$
CREATE PROCEDURE sp_SearchDepart (IN departamento VARCHAR(50))
BEGIN
    SELECT codigo FROM DEPARTAMENTO WHERE sigla = + "'" + departamento + "'";
END $$
DELIMITER ;

-- Registro

DELIMITER $$
USE SCESVI $$
DROP PROCEDURE IF EXISTS sp_InsertRegistro $$
CREATE PROCEDURE sp_InsertRegistro (IN numero INT(4), IN observacao VARCHAR(150), 
IN codVeiculo VARCHAR(10), IN siapeServInicia VARCHAR(12), IN siapeServEncerra VARCHAR(12),
IN siapeServResponsavel VARCHAR(12), IN horaInicia VARCHAR(4), IN dataInicia VARCHAR(8), 
IN horaSaida VARCHAR(4), IN dataSaida VARCHAR(8), IN dataEntrada VARCHAR(8), 
IN horaEntrada VARCHAR(4), IN horaEncerra VARCHAR(4), IN dataEncerra VARCHAR(8), 
IN descricao VARCHAR(150), IN kmInicial SMALLINT(2), IN kmFinal SMALLINT(2), 
IN kmPercorridos SMALLINT(2), IN dataSupervisionado VARCHAR(8))
BEGIN
	INSERT INTO REGISTRO VALUES(numero, observacao, codVeiculo, siapeServInicia, siapeServEncerra, siapeServResponsavel, horaInicia, dataInicia, horaSaida, dataSaida, dataEntrada, horaEntrada, dataEncerra, horaEncerra, descricao, kmInicial, kmFinal, kmPercorridos, dataSupervisionado);
END $$
DELIMITER ;

-- Solicitação

DELIMITER $$
USE SCESVI $$
DROP PROCEDURE IF EXISTS sp_InsertSolicitacao $$
CREATE PROCEDURE sp_insertSolicitacao (IN numero INT, IN veiculoRequisitado VARCHAR(50), 
IN dataVeiculoConfirmado VARCHAR(8), IN dataInicio VARCHAR(8), IN dataFim VARCHAR(8),
IN horaCriacao VARCHAR(4), IN dataCriacao VARCHAR(8), IN localViagem VARCHAR(50), 
IN horaAutorizado VARCHAR(4), IN dataAutorizado VARCHAR(8), IN qtdePassageiros SMALLINT, 
IN tipo CHAR, IN finalidade VARCHAR(150), IN siapeServAutoriza VARCHAR(12), 
IN siapeServRealiza VARCHAR(12))
BEGIN
    INSERT INTO SOLICITACAO VALUES(numero, veiculoRequisitado, dataVeiculoConfirmado, 
    dataInicio, dataFim, horaCriacao, dataCriacao, localViagem, horaAutorizado, dataAutorizado, 
    qtdePassageiros, tipo, finalidade, siapeServAutoriza, siapeServRealiza);
END $$
DELIMITER ;

DELIMITER $$
USE SCESVI $$
DROP PROCEDURE IF EXISTS sp_ListSolicit $$
CREATE PROCEDURE sp_ListSolicit ()
BEGIN
    SELECT numero, tipo, veiculoRequisitado, dataCriacao, dataAutorizado FROM SOLICITACAO;
END $$
DELIMITER ;

DELIMITER $$
USE SCESVI $$
DROP PROCEDURE IF EXISTS sp_DeleteSolicit $$
CREATE PROCEDURE sp_DeleteSolicit (IN numero INT(4))
BEGIN
	DELETE FROM SOLICITACAO WHERE SOLICITACAO.numero = numero;
END $$
DELIMITER ;

DELIMITER $$
USE SCESVI $$
DROP PROCEDURE IF EXISTS sp_UpdateSolicit $$
CREATE PROCEDURE sp_UpdateSolicit (IN veiculoRequisitado VARCHAR(50), 
IN dataVeiculoConfirmado VARCHAR(8), IN dataInicio VARCHAR(8), IN dataFim VARCHAR(8),
IN horaCriacao VARCHAR(4), IN dataCriacao VARCHAR(8), IN localViagem VARCHAR(50), 
IN horaAutorizado VARCHAR(4), IN dataAutorizado VARCHAR(8), IN qtdePassageiros SMALLINT, 
IN tipo CHAR, IN finalidade VARCHAR(150), IN siapeServAutoriza VARCHAR(12), 
IN siapeServRealiza VARCHAR(12), IN numero INT(4))
BEGIN
    UPDATE SOLICITACAO SET SOLICITACAO.veiculoRequisitado = veiculoRequisitado, SOLICITACAO.dataVeiculoConfirmado = dataVeiculoConfirmado, 
    SOLICITACAO.dataInicio = dataInicio, SOLICITACAO.dataFim = dataFim, SOLICITACAO.horaCriacao = horaCriacao, SOLICITACAO.dataCriacao = dataCriacao,
    SOLICITACAO.localViagem = localViagem, SOLICITACAO.horaAutorizado = horaAutorizado, SOLICITACAO.dataAutorizado = dataAutorizado,
	SOLICITACAO.qtdePassageiros = qtdePassageiros, SOLICITACAO.tipo = tipo, SOLICITACAO.finalidade = finalidade, 
    SOLICITACAO.siapeServAutoriza = siapeServAutoriza, SOLICITACAO.siapeServRealiza = siapeServRealiza WHERE SOLICITACAO.numero = numero;
END $$
DELIMITER ;

-- Telefone

DELIMITER $$
USE SCESVI $$
DROP PROCEDURE IF EXISTS sp_InsertTelefone $$
CREATE PROCEDURE sp_InsertTelefone (IN siapeServ VARCHAR(12), IN telefone VARCHAR(11))
BEGIN
	INSERT INTO TELEFONE VALUES(siapeServ, telefone);
END $$
DELIMITER ;

-- Lotado

DELIMITER $$
USE SCESVI $$
DROP PROCEDURE IF EXISTS sp_InsertLotado $$
CREATE PROCEDURE sp_InsertLotado (IN siapeServ VARCHAR(12), IN codDep SMALLINT(2), IN dataInicio VARCHAR(8), IN dataFim VARCHAR(8))
BEGIN
	INSERT INTO LOTADO VALUES(siapeServ, codDep, dataInicio, dataFim);
END $$
DELIMITER ;

-- Contratado

DELIMITER $$
USE SCESVI $$
DROP PROCEDURE IF EXISTS sp_InsertContratado $$
CREATE PROCEDURE sp_InsertContratado (IN siapeServ VARCHAR(12), IN codCargo SMALLINT(2), IN dataInicio VARCHAR(8), IN dataFim VARCHAR(8))
BEGIN
	INSERT INTO CONTRATADO VALUES(siapeServ, codCargo, dataInicio, dataFim);
END $$
DELIMITER ;	

-- Veiculo

DELIMITER $$
USE SCESVI $$
DROP PROCEDURE IF EXISTS sp_InsertVeiculo $$
CREATE PROCEDURE sp_InsertVeiculo (IN codigo VARCHAR(7), IN tipo VARCHAR(10), 
IN placa VARCHAR(7), IN renavam VARCHAR(30), IN autorizado CHAR, IN categoria CHAR,
IN institucional CHAR, IN chassi VARCHAR(10), IN maxPassageiros SMALLINT(2), 
IN observacao VARCHAR(150), IN exercicio VARCHAR(4), IN tipoCombustivel CHAR, 
IN potencia FLOAT(8), IN cor VARCHAR(15), IN marcaModelo VARCHAR(10), 
IN anoFabricacao VARCHAR(4), IN anoModelo VARCHAR(4),IN dataSupervisionado VARCHAR(8), 
IN siapeServSupervisiona CHAR(8), IN siapeServResponsavel CHAR(8))
BEGIN
	INSERT INTO VEICULO VALUES(codigo, tipo, placa, renavam, autorizado, categoria,
    institucional, chassi, maxPassageiros, observacao, exercicio, tipoCombustivel,
    potencia, cor, marcaModelo, anoFabricacao, anoModelo, dataSupervisionado,
    siapeServSupervisiona, siapeServResponsavel);
END $$
DELIMITER 











