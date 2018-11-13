CREATE TABLE SOLICITACAO(
	numero INT(4) NOT NULL PRIMARY KEY,
    veiculoRequisitado VARCHAR(50) NOT NULL,
    dataVeiculoConfirmado VARCHAR(8) NOT NULL,
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
    