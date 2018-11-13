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





