CREATE TABLE SERVIDOR(
    siape VARCHAR(11) NOT NULL PRIMARY KEY,
    cpf CHAR(11) NOT NULL,
    nome VARCHAR(50) NOT NULL,
    senha VARCHAR(50) NOT NULL,
    dataNasc VARCHAR(8) NOT NULL,
    cnh VARCHAR(11),
    categoria CHAR,
    autorizadoVeicInstitucional CHAR NOT NULL);

