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