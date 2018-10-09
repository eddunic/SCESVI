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
    