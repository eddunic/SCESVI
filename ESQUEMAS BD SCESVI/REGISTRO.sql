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