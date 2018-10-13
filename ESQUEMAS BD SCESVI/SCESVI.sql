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
DESCRIBE SOLICITVEICULO;
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
SELECT * FROM SOLICITVEICULO;
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
DROP TABLE SOLICITVEICULO;
DROP TABLE DEPARTAMENTO;
DROP TABLE LOTADO;
DROP TABLE CARGO;
DROP TABLE CONTRATADO;
    
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