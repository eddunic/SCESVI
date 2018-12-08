DROP DATABASE SCESVI;

CREATE DATABASE SCESVI;

-- DROP'S TABELAS
DROP TABLE SERVIDOR;
DROP TABLE TELEFONE;
DROP TABLE VEICULO;
DROP TABLE SOLICITACAO;
DROP TABLE REGISTRO;
DROP TABLE SOLICITVEICULO;
DROP TABLE DEPARTAMENTO;
DROP TABLE LOTADO;
DROP TABLE CARGO;
DROP TABLE CONTRATADO;

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
    
    insert into servidor values('32379365', '12345678901', 'Eduardo', '1133', '17082001', '09876543211', 'A', 'N');
    select * from servidor;

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
    
    select * from cargo;

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
    
drop table solicitacao;

INSERT INTO SOLICITACAO (dataInicio, dataFim, horaCriacao, dataCriacao, localViagem, horaAutorizado, dataAutorizado, qtdePassageiros,
tipo, finalidade, siapeServAutoriza, siapeServRealiza)
VALUES ('11121999', '12121999', '1020', '11101999', 'casa', '1030', '11111999', 10, 'A', 'Visita técnica', '32112312', '32714444'),
('11121999', '12121999', '1020', '11101999', 'casa', '1030', '11111999', 7, 'E', 'Visita técnica', '33113212', '3216666');

-- select count(numero) from solicitacao;

desc solicitacao;

CREATE TABLE SOLICITACAO(
	numero INT PRIMARY KEY auto_increment,
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

    
CREATE TABLE SOLICITVEICULO(
	numSolicit INT NOT NULL,
	codVeic INT NOT NULL,
    situacao CHAR NOT NULL,
	PRIMARY KEY(numSolicit, codVeic),
	FOREIGN KEY(numSolicit) REFERENCES SOLICITACAO(numero)
	ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY(codVeic) REFERENCES VEICULO(codigo)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
DROP TABLE SOLICITACAO;

INSERT INTO VEICULO (tipo, placa, renavam, autorizado, categoria, institucional, chassi, maxPassageiros, observacao, exercicio,
	tipoCombustivel, potencia, cor, marcaModelo, anoFabricacao, anoModelo, dataSupervisionado, siapeServSupervisiona,
    siapeServResponsavel, situacao) VALUES
('comum', 'phw1234', 'renvai8765', 'S', 'D', 'N', 'chassi2a', 11, 'nenhuma obs', '2010', 'A', 
12, 'azul', 'che gueva', '1999', '1999', '12112011', '122', '322', 'L');

select * from veiculo;

drop table veiculo;

-- SELECT veiculoRequisitado FROM SOLICITACAO WHERE dataFim is not null AND veiculoRequisitado = 'eila';

CREATE TABLE VEICULO(
    codigo INT PRIMARY KEY auto_increment,
    placa VARCHAR(7) NOT NULL,
	renavam VARCHAR(30) NOT NULL UNIQUE,
    autorizado CHAR,
    categoria CHAR,
    institucional CHAR,
    maxPassageiros SMALLINT(2) NOT NULL,
    observacao VARCHAR(150),
    cor VARCHAR(15) NOT NULL,
    marcaModelo VARCHAR(10) NOT NULL,
    dataSupervisionado VARCHAR(8),
    siapeServSupervisiona CHAR(8) NOT NULL,
    siapeServResponsavel CHAR(8) NOT NULL,
    situacao CHAR NOT NULL,
	FOREIGN KEY(siapeServSupervisiona) REFERENCES SERVIDOR(siape)
	ON DELETE CASCADE
    ON UPDATE CASCADE,
	FOREIGN KEY(siapeServResponsavel) REFERENCES SERVIDOR(siape)
	ON DELETE CASCADE
    ON UPDATE CASCADE);
    
INSERT INTO VEICULO (placa, renavam, autorizado, categoria, institucional, maxPassageiros, observacao, cor, marcaModelo, dataSupervisionado, siapeServSupervisiona, siapeServResponsavel, situacao) VALUES
('adm-123', '837846', 's', 'D', 'n', 12, 'nda', 'azul', 'chevrolet', '12082018', '32379365', '32379365', 'L');


select * from veiculo;

select * from servidor;
INSERT INTO SolicitVeiculo VALUES (1, 1, 'A');

INSERT INTO REGISTRO (observacao, codVeiculo, siapeServInicia, siapeServEncerra, siapeServResponsavel, dataInicia,
    horaSaida, dataSaida, dataEntrada, horaEntrada, dataEncerra, descricao, kmInicial, kmFinal, dataSupervisionado) VALUES
    ('nda', '3', '12', '32', '23', '2', '2', '1', '12', '23', '2', 'd', '23', '12', 'n');

CREATE TABLE REGISTRO(
	numero INT PRIMARY KEY auto_increment,
    observacao VARCHAR(150),
    codVeiculo VARCHAR(7) NOT NULL,
    siapeServInicia CHAR(8) NOT NULL,
    siapeServEncerra CHAR(8) NOT NULL,
    siapeServResponsavel CHAR(8) NOT NULL,
 --   horaInicia VARCHAR(4) NOT NULL,
    dataInicia VARCHAR(8) NOT NULL,
    horaSaida VARCHAR(4),
    dataSaida VARCHAR(8),
    dataEntrada VARCHAR(8),
    horaEntrada VARCHAR(4),
--    horaEncerra VARCHAR(4),
    dataEncerra VARCHAR(8),
    descricao VARCHAR(150) NOT NULL,
    kmInicial SMALLINT(2),
    kmFinal SMALLINT(2),
 --   kmPercorridos SMALLINT(2),
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
    


drop table registro;

SELECT * FROM REGISTRO;

SELECT * FROM VEICULO;

SELECT * FROM SOLICITACAO;
    
SELECT * FROM SERVIDOR;
    
SELECT * FROM DEPARTAMENTO;

SELECT * FROM LOTADO;

SELECT * FROM CONTRATADO;

SELECT * FROM SOLICITVEICULO;

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
CREATE PROCEDURE sp_DeleteServidor (IN siape CHAR(8))
BEGIN
	DELETE FROM SERVIDOR WHERE SERVIDOR.siape = siape;
END $$
DELIMITER ;

DELIMITER $$
USE SCESVI $$
DROP PROCEDURE IF EXISTS sp_ConsultServidor $$
CREATE PROCEDURE sp_ConsultServidor (IN siape CHAR(8))
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
DROP PROCEDURE IF EXISTS sp_InsertCargo $$
CREATE PROCEDURE sp_InsertCargo ()
BEGIN
	INSERT INTO CARGO
	VALUES
	(1, 'Coordenador'),
	(2, 'Guarda'),
	(3, 'Motorista'),
	(4, 'Servidor comum');
END $$
DELIMITER ;

DELIMITER $$
USE SCESVI $$
DROP PROCEDURE IF EXISTS sp_InsertDep $$
CREATE PROCEDURE sp_InsertDep ()
BEGIN
	INSERT INTO DEPARTAMENTO 
	VALUES
	(1, 'Departamento AcadÃªmico de InformaÃ§Ã£o e ComunicaÃ§Ã£o', 'DAIC'),
	(2, 'Departamento AcadÃªmico de Infraestrutura', 'DAINFRA'),
	(3, 'Departamento de QuÃ­mica e Alimentos', 'DQA'),
	(4, 'Departamento de alguma coisa que eu nÃ£o sei', 'DGP'),
	(5, 'Departamento de Processos Industriais','DPI'),
	(6, 'Departamento de Tecnologia da InformaÃ§Ã£o', 'DTI');
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

DELIMITER $$
USE SCESVI $$
DROP PROCEDURE IF EXISTS sp_NomeCargo $$
CREATE PROCEDURE sp_NomeCargo (IN siape CHAR(8), OUT titul VARCHAR(20))
BEGIN
	-- DECLARE CONTINUE HANDLER FOR NOT FOUND SET titul = 1;
    SELECT titulacao INTO titul FROM CARGO, CONTRATADO, SERVIDOR WHERE codigo = codCargo AND siapeServ = siape = SERVIDOR.siape AND dataFim is null;
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
IN codVeiculo VARCHAR(10), IN siapeServInicia CHAR(8), IN siapeServEncerra CHAR(8),
IN siapeServResponsavel CHAR(8), IN horaInicia VARCHAR(4), IN dataInicia VARCHAR(8), 
IN horaSaida VARCHAR(4), IN dataSaida VARCHAR(8), IN dataEntrada VARCHAR(8), 
IN horaEntrada VARCHAR(4), IN horaEncerra VARCHAR(4), IN dataEncerra VARCHAR(8), 
IN descricao VARCHAR(150), IN kmInicial SMALLINT(2), IN kmFinal SMALLINT(2), 
IN kmPercorridos SMALLINT(2), IN dataSupervisionado VARCHAR(8))
BEGIN
	INSERT INTO REGISTRO VALUES(numero, observacao, codVeiculo, siapeServInicia, siapeServEncerra, siapeServResponsavel, horaInicia, dataInicia, horaSaida, dataSaida, dataEntrada, horaEntrada, dataEncerra, horaEncerra, descricao, kmInicial, kmFinal, kmPercorridos, dataSupervisionado);
END $$
DELIMITER ;

-- SolicitaÃ§Ã£o

DELIMITER $$
USE SCESVI $$
DROP PROCEDURE IF EXISTS sp_InsertSolicitacao $$
CREATE PROCEDURE sp_insertSolicitacao (IN numero INT, IN veiculoRequisitado VARCHAR(50), 
IN dataVeiculoConfirmado VARCHAR(8), IN dataInicio VARCHAR(8), IN dataFim VARCHAR(8),
IN horaCriacao VARCHAR(4), IN dataCriacao VARCHAR(8), IN localViagem VARCHAR(50), 
IN horaAutorizado VARCHAR(4), IN dataAutorizado VARCHAR(8), IN qtdePassageiros SMALLINT, 
IN tipo CHAR, IN finalidade VARCHAR(150), IN siapeServAutoriza CHAR(8), 
IN siapeServRealiza CHAR(8))
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
IN tipo CHAR, IN finalidade VARCHAR(150), IN siapeServAutoriza CHAR(8), 
IN siapeServRealiza CHAR(8), IN numero INT(4))
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
CREATE PROCEDURE sp_InsertTelefone (IN siapeServ CHAR(8), IN telefone VARCHAR(11))
BEGIN
	INSERT INTO TELEFONE VALUES(siapeServ, telefone);
END $$
DELIMITER ;

DELIMITER $$
USE SCESVI $$
DROP PROCEDURE IF EXISTS sp_ListTelefone$$
CREATE PROCEDURE sp_ListTelefone (IN siape CHAR(8), OUT telefoneList VARCHAR(11))
BEGIN
    SELECT telefone INTO telefoneList FROM TELEFONE WHERE siape =  siapeServ;
END $$
DELIMITER ;

INSERT INTO TELEFONE VALUES(12345678, '99999999');

-- Lotado

DELIMITER $$
USE SCESVI $$
DROP PROCEDURE IF EXISTS sp_InsertLotado $$
CREATE PROCEDURE sp_InsertLotado (IN siapeServ CHAR(8), IN codDep SMALLINT(2), IN dataInicio VARCHAR(8), IN dataFim VARCHAR(8))
BEGIN
	INSERT INTO LOTADO VALUES(siapeServ, codDep, dataInicio, dataFim);
END $$
DELIMITER ;

-- Contratado

DELIMITER $$
USE SCESVI $$
DROP PROCEDURE IF EXISTS sp_InsertContratado $$
CREATE PROCEDURE sp_InsertContratado (IN siapeServ CHAR(8), IN codCargo SMALLINT(2), IN dataInicio VARCHAR(8), IN dataFim VARCHAR(8))
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











