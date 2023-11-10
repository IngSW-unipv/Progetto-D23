-- DATABASE HOSPITALMANAGER
-- ______________________________________________________________
DROP SCHEMA hospitalmanager;
CREATE SCHEMA hospitalmanager;
USE hospitalmanager;

-- CREAZIONE TABLE 
-- DROP TABLE IF EXISTS STRUTTURE_SANITARIE;
DROP TABLE IF EXISTS PROFILI;
-- DROP TABLE IF EXISTS ANAGRAFICA;
-- DROP TABLE IF EXISTS MEDICI;
-- DROP TABLE IF EXISTS OPERATORI_SANITARI;
-- DROP TABLE IF EXISTS OPERATORI_UFFICIO;
-- DROP TABLE IF EXISTS PAZIENTI;
DROP TABLE IF EXISTS CARTELLE_CLINICHE;
DROP TABLE IF EXISTS PRENOTAZIONI;
DROP TABLE IF EXISTS PRESTAZIONI_SANITARIE;
-- DROP TABLE IF EXISTS EROGAZIONI;
-- DROP TABLE IF EXISTS ESITI;
DROP TABLE IF EXISTS CALENDARI;

-- CREATE TABLE STRUTTURE_SANITARIE (
-- ID_STR SMALLINT PRIMARY KEY,
-- NOME VARCHAR(100),
-- INDIRIZZO VARCHAR(100),
-- TELEFONO VARCHAR(20),
-- EMAIL VARCHAR(50)
-- );

-- CREATE TABLE ANAGRAFICA (
-- 	CF CHAR(16) PRIMARY KEY,
-- 	NOME VARCHAR(50),
-- 	COGNOME VARCHAR(50),
-- 	SESSO CHAR(7) CHECK (SESSO = 'MASCHIO' OR SESSO = 'FEMMINA'),
-- 	DATA_NASCITA DATE,
-- 	LUOGO_NASCITA VARCHAR(50),
-- 	PROVINCIA_NASCITA CHAR(2),
-- 	REGIONE_RESIDENZA CHAR(50),
-- 	PROVINCIA_RESIDENZA CHAR(2),
-- 	CITTA_RESIDENZA VARCHAR(50),
-- 	INDIRIZZO VARCHAR(100),
--     CAP CHAR(5),
-- 	EMAIL VARCHAR(100),
-- 	CELLULARE CHAR(20)
-- );

CREATE TABLE PROFILI (
	-- ID_ACC SMALLINT PRIMARY KEY,
    -- ID_STR SMALLINT,
    CF CHAR(16),
	TIPO CHAR(2) CHECK (TIPO = 'ME' OR TIPO = 'OS' OR TIPO = 'OU' OR TIPO = 'PA'),
	PW VARCHAR(20),
    SPECIALIZZAZIONE VARCHAR(50),
    
	NOME VARCHAR(50),
	COGNOME VARCHAR(50),
	GENERE CHAR(7) CHECK (GENERE = 'MASCHIO' OR GENERE = 'FEMMINA'),
	DATA_NASCITA DATE,
	LUOGO_NASCITA VARCHAR(50),
	PROVINCIA_NASCITA CHAR(2),
	REGIONE_RESIDENZA CHAR(50),
	PROVINCIA_RESIDENZA CHAR(2),
	CITTA_RESIDENZA VARCHAR(50),
	INDIRIZZO VARCHAR(100),
    CAP CHAR(5),
	EMAIL VARCHAR(100),
	CELLULARE CHAR(20),
    PRIMARY KEY(CF, TIPO)
   	-- FOREIGN KEY(ID_STR) REFERENCES STRUTTURE_SANITARIE(ID_STR),
	-- FOREIGN KEY(CF) REFERENCES ANAGRAFICA(CF)
);


-- CREATE TABLE MEDICI (
-- 	ID_ACC SMALLINT PRIMARY KEY,
-- 	COD_REGIONALE  SMALLINT,
-- 	SPECIALIZZAZIONE VARCHAR(50),
-- 	DATA_ASSUNZIONE DATE,
-- 	FOREIGN KEY(ID_ACC) REFERENCES PROFILI(ID_ACC)
-- );

-- CREATE TABLE OPERATORI_SANITARI (
-- 	ID_ACC SMALLINT PRIMARY KEY,
-- 	-- ID_STR SMALLINT, 
-- 	DATA_ASSUNZIONE DATE,
-- 	-- FOREIGN KEY(ID_STR) REFERENCES STRUTTURE_SANITARIE(ID_STR),
-- 	FOREIGN KEY(ID_ACC) REFERENCES PROFILI(ID_ACC)
-- );

-- CREATE TABLE OPERATORI_UFFICIO (
-- 	ID_ACC SMALLINT PRIMARY KEY,
-- 	-- ID_STR SMALLINT, 
-- 	DATA_ASSUNZIONE DATE,
-- 	-- FOREIGN KEY(ID_STR) REFERENCES STRUTTURE_SANITARIE(ID_STR),
-- 	FOREIGN KEY(ID_ACC) REFERENCES PROFILI(ID_ACC)
-- );

-- CREATE TABLE PAZIENTI (
-- 	ID_ACC SMALLINT PRIMARY KEY,
-- 	FOREIGN KEY(ID_ACC) REFERENCES PROFILI(ID_ACC)
-- );

CREATE TABLE PRESTAZIONI_SANITARIE (
	ID_PREST CHAR(7) PRIMARY KEY,
	TIPO VARCHAR(100),
	DURATA TIME CHECK(MINUTE(DURATA)%30 = 0 AND HOUR(DURATA) <= 12),
	COSTO DOUBLE
);

CREATE TABLE PRENOTAZIONI (
	ID_PREN SMALLINT PRIMARY KEY,
	-- ID_STR SMALLINT,  
	PAZIENTE CHAR(16),
	PERSONALE_SANITARIO CHAR(16),
	ID_PREST CHAR(7),
	DATA_PREN DATE,
	ORA_PREN TIME,
    ACCREDITAMENTO BOOLEAN,
    ESITO VARCHAR(100),
	-- FOREIGN KEY(ID_STR) REFERENCES STRUTTURE_SANITARIE(ID_STR),
	FOREIGN KEY(PAZIENTE) REFERENCES PROFILI(CF),
	FOREIGN KEY(PERSONALE_SANITARIO) REFERENCES PROFILI(CF),
	FOREIGN KEY(ID_PREST) REFERENCES PRESTAZIONI_SANITARIE(ID_PREST)
);

CREATE TABLE CARTELLE_CLINICHE (
	CF CHAR(16) PRIMARY KEY,
	ALTEZZA DOUBLE,
	PESO DOUBLE,
	GRUPPO_SANGUIGNO CHAR(13) CHECK (
			GRUPPO_SANGUIGNO = 'A_POSITIVO' OR
			GRUPPO_SANGUIGNO = 'A_NEGATIVO' OR
			GRUPPO_SANGUIGNO = 'B_POSITIVO' OR
			GRUPPO_SANGUIGNO = 'B_NEGATIVO' OR
			GRUPPO_SANGUIGNO = 'AB_POSITIVO' OR
			GRUPPO_SANGUIGNO = 'AB_NEGATIVO' OR
			GRUPPO_SANGUIGNO = 'ZERO_POSITIVO' OR
			GRUPPO_SANGUIGNO = 'ZERO_NEGATIVO'
        ),
	FOREIGN KEY(CF) REFERENCES PROFILI(CF)
);

-- N.B. posso ottenere gli esiti associati ai pazienti tramite cartelle_cliniche join prenotazioni join esiti

-- CREATE TABLE EROGAZIONI (
-- 	ID_PREN SMALLINT PRIMARY KEY,
-- 	DATA_EROG DATE,
-- 	ORA_EROG TIME,
-- 	ACCREDITAMENTO BOOLEAN,
-- 	FOREIGN KEY(ID_PREN) REFERENCES PRENOTAZIONI(ID_PREN)
-- );

-- CREATE TABLE ESITI (
-- 	ID_PREN SMALLINT PRIMARY KEY,
-- 	REFERTO TEXT,
-- 	TERAPIA TEXT,
-- 	FOREIGN KEY(ID_PREN) REFERENCES PRENOTAZIONI(ID_PREN)
-- );

CREATE TABLE CALENDARI (
	-- ID_STR SMALLINT DEFAULT 00,
    CALENDARIO_DATA DATE DEFAULT '2000-01-01',
    GIORNO_SETTIMANA CHAR(10),
    NOME_VACANZE VARCHAR(50),
	ORARIO TIME DEFAULT '00:00:00.000000',
    PREST01 SMALLINT,		--  VISITA_ONCOLOGICA
    PREST02 SMALLINT,		-- 	VISITA_PSICOLOGICA
    PREST03 SMALLINT,		-- 	ESAME_SANGUE
    PREST04 SMALLINT,		-- 	TAC
    PREST05 SMALLINT,		-- 	RISONANZA_MAGNETICA
    PREST06 SMALLINT,		-- 	CHEMIOTERAPIA
    PREST07 SMALLINT,		-- 	RADIOTERAPIA
    PREST08 SMALLINT,		-- 	OPERAZIONE
	-- FOREIGN KEY(ID_STR) REFERENCES STRUTTURE_SANITARIE(ID_STR),
    -- PRIMARY KEY(ID_STR, CALENDARIO_DATA, ORARIO),
    PRIMARY KEY(CALENDARIO_DATA, ORARIO),
    FOREIGN KEY(PREST01) REFERENCES PRENOTAZIONI(ID_PREN),
	FOREIGN KEY(PREST02) REFERENCES PRENOTAZIONI(ID_PREN),
    FOREIGN KEY(PREST03) REFERENCES PRENOTAZIONI(ID_PREN),
    FOREIGN KEY(PREST04) REFERENCES PRENOTAZIONI(ID_PREN),
    FOREIGN KEY(PREST05) REFERENCES PRENOTAZIONI(ID_PREN),
    FOREIGN KEY(PREST06) REFERENCES PRENOTAZIONI(ID_PREN),
    FOREIGN KEY(PREST07) REFERENCES PRENOTAZIONI(ID_PREN),
    FOREIGN KEY(PREST08) REFERENCES PRENOTAZIONI(ID_PREN)
);

-- INSERT INTO STRUTTURE_SANITARIE VALUES (01, 'Clinica Oncologica', 'Lombardia', 'PV', 'Pavia', 'via Adolfo Ferrata 5');
-- SELECT * FROM STRUTTURE_SANITARIE;

mysql> delimiter //
CREATE PROCEDURE POPOLA_CALENDARIO()
BEGIN 
DECLARE StartDate DATE;
DECLARE EndDate DATE;
DECLARE StartSchedule TIME;
DECLARE EndSchedule TIME;
SET StartDate = DATE(NOW());
SET EndDate = DATE_ADD(StartDate, INTERVAL 12 MONTH);

WHILE StartDate <= EndDate DO
	SET StartSchedule = '07:00:00.000000';
	SET EndSchedule = ADDTIME(StartSchedule, '12:00:00.000000');
	WHILE StartSchedule <= EndSchedule DO
             INSERT INTO CALENDARI (
				  -- ID_STR,
				  CALENDARIO_DATA,
                  GIORNO_SETTIMANA,
                  NOME_VACANZE,
                  ORARIO,
				  PREST01, PREST02, PREST03, PREST04, PREST05, PREST06, PREST07, PREST08
             )
             SELECT
                   -- 01,
                   StartDate,
                   DAYNAME(StartDate),
                   NULL,
                   StartSchedule,
				   NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL;
							
				   SET StartSchedule = ADDTIME(StartSchedule, '00:30:00.000000');
			END WHILE;
            
			SET StartDate = DATE_ADD(StartDate, INTERVAL 1 DAY);
END WHILE;

UPDATE CALENDARI SET NOME_VACANZE = 'Natale' WHERE CALENDARIO_DATA LIKE '____-12-25';
UPDATE CALENDARI SET NOME_VACANZE = 'Capodanno' WHERE CALENDARIO_DATA LIKE '____-01-01';
UPDATE CALENDARI SET NOME_VACANZE = 'Festa Lavoro' WHERE CALENDARIO_DATA LIKE '____-05-01';
UPDATE CALENDARI SET NOME_VACANZE = 'World Cancer Day' WHERE CALENDARIO_DATA LIKE '____-02-04';
UPDATE CALENDARI SET NOME_VACANZE = 'Ferragosto' WHERE CALENDARIO_DATA LIKE '____-08-15';
UPDATE CALENDARI SET NOME_VACANZE = 'Festa Repubblica' WHERE CALENDARIO_DATA LIKE '____-06-02';
UPDATE CALENDARI SET NOME_VACANZE = 'Immacolata' WHERE CALENDARIO_DATA LIKE '____-12-08';
END//
mysql> delimiter ;

SET SQL_SAFE_UPDATES = 0;
call POPOLA_CALENDARIO();
SET SQL_SAFE_UPDATES = 1;

-- SELECT * FROM CALENDARI;

mysql> delimiter //
CREATE PROCEDURE POPOLA_PRESTAZIONI()
BEGIN 
INSERT INTO PRESTAZIONI_SANITARIE VALUES ('PREST01', 'Visita Oncologica', '00:30:00.000000', 80);
INSERT INTO PRESTAZIONI_SANITARIE VALUES ('PREST02', 'Visita Psicologica', '01:00:00.000000', 80);
INSERT INTO PRESTAZIONI_SANITARIE VALUES ('PREST03', 'Esami Sangue', NULL, 30);
INSERT INTO PRESTAZIONI_SANITARIE VALUES ('PREST04', 'Tac', '00:30:00.000000', 100);
INSERT INTO PRESTAZIONI_SANITARIE VALUES ('PREST05', 'Risonanza Magnetica', '00:30:00.000000', 100);
INSERT INTO PRESTAZIONI_SANITARIE VALUES ('PREST06', 'Chemioterapia', '02:00:00.000000', NULL);
INSERT INTO PRESTAZIONI_SANITARIE VALUES ('PREST07', 'Radioterapia', '00:30:00.000000', NULL);
INSERT INTO PRESTAZIONI_SANITARIE VALUES ('PREST08', 'Operazione', NULL, NULL);
END//
mysql> delimiter ;
call POPOLA_PRESTAZIONI();
-- SELECT * FROM PRESTAZIONI_SANITARIE;

-- mysql> delimiter //
-- CREATE PROCEDURE POPOLA_ANAGRAFICA()
-- BEGIN 
-- INSERT INTO ANAGRAFICA VALUES ('LNRVNC0000000000', 'LEONARDO', 'DA VINCI', 'M', '1952-04-15', 'Vinci', 'FI', 'Sicilia', 'AG', 'Palma Di Montechiaro', 'Via L. Da Vinci', '12345', 'leonardodavinci@gmail.com', '0123456789');
-- INSERT INTO ANAGRAFICA VALUES ('MCHBNR0000000000', 'MICHELANGELO', 'BUONARROTI', 'M', '1975-03-06', 'Roma', 'RM', 'Lazio', 'RM', 'Roma', 'Via M.Buonarroti', '12345', 'michelangelobuonarroti@gmail.com', '0123456789');
-- INSERT INTO ANAGRAFICA VALUES ('DNTBRD0000000000', 'DONATELLO', 'BARDI', 'M', '1986-12-13', 'Roma', 'RM', 'Lazio', 'RM', 'Roma', 'Via Donatello', '12345', 'donatellobardi@gmail.com', '0123456789');
-- INSERT INTO ANAGRAFICA VALUES ('RFFSNZ0000000000', 'RAFFAELLO', 'SANZIO', 'M', '1983-04-06', 'Urbino', 'PU', 'Marche', 'PU', 'Urbino', 'Via R. Sanzio', '12345', 'raffaellosanzio@gmail.com', '0123456789');
-- INSERT INTO ANAGRAFICA VALUES ('LSMRNT0000000000', 'ELSA', 'MORANTE', 'F', '1985-08-18', 'Roma', 'RM', 'Lazio', 'RM', 'Roma', 'Via E. Morante', '12345', 'elsamorante@gmail.com', '0123456789');
-- INSERT INTO ANAGRAFICA VALUES ('LDMRN00000000000', 'ALDA', 'MERINI', 'F', '1965-03-21', 'Milano', 'MI', 'Lombardia', 'MI', 'Milano', 'Via A. Merini', '12345', 'aldamerini@gmail.com', '0123456789');
-- END//
-- mysql> delimiter ;
-- call POPOLA_ANAGRAFICA();
-- SELECT * FROM ANAGRAFICA;

-- imposto null le specializzazioni per profili che non sono di tipo medico
SET SQL_SAFE_UPDATES = 0;
UPDATE PROFILI 
SET SPECIALIZZAZIONE = NULL
WHERE TIPO != 'ME';
SET SQL_SAFE_UPDATES = 1;

