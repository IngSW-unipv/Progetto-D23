-- DATABASE HOSPITALMANAGER 07-10-2023
-- ______________________________________________________________

-- CREATE SCHEMA hospitalmanager;
-- USE hospitalmanager;

-- CREAZIONE TABLE 

DROP TABLE IF EXISTS STRUTTURE_SANITARIE;
DROP TABLE IF EXISTS PROFILI;
DROP TABLE IF EXISTS ANAGRAFICA;
DROP TABLE IF EXISTS MEDICI;
DROP TABLE IF EXISTS OPERATORI_SANITARI;
DROP TABLE IF EXISTS OPERATORI_UFFICIO;
DROP TABLE IF EXISTS PAZIENTI;
DROP TABLE IF EXISTS CARTELLE_CLINICHE;
DROP TABLE IF EXISTS PRENOTAZIONI;
DROP TABLE IF EXISTS PRESTAZIONI_SANITARIE;
DROP TABLE IF EXISTS EROGAZIONI;
DROP TABLE IF EXISTS ESITI;
DROP TABLE IF EXISTS CALENDARI;
DROP TABLE IF EXISTS AGENDE;

CREATE TABLE STRUTTURE_SANITARIE (
ID_STR SMALLINT PRIMARY KEY,
NOME VARCHAR(100),
REGIONE CHAR(50),
PROVINCIA CHAR(2),
CITTA VARCHAR(50),
INDIRIZZO VARCHAR(100)
);

CREATE TABLE PROFILI (
ID_ACC SMALLINT PRIMARY KEY,
TIPO CHAR(3),
CF CHAR(16),
PW VARCHAR(20),
FOREIGN KEY(CF) REFERENCES ANAGRAFICA(CF)
);

CREATE TABLE ANAGRAFICA (
CF CHAR(16) PRIMARY KEY,
NOME VARCHAR(50),
COGNOME VARCHAR(50),
GENERE CHAR(1),
DATA_NASCITA DATE,
LUOGO_NASCITA DATE,
REGIONE CHAR(50),
PROVINCIA CHAR(2),
CITTA VARCHAR(50),
INDIRIZZO VARCHAR(100),
EMAIL VARCHAR(100),
CELLULARE CHAR(20)
);

CREATE TABLE MEDICI (
ID_ACC SMALLINT PRIMARY KEY,
COD_REGIONALE  SMALLINT,
SPECIALIZZAZIONE VARCHAR(50),
DATA_ASSUNZIONE DATE,
FOREIGN KEY(ID_ACC) REFERENCES PROFILI(ID_ACC)
);

CREATE TABLE OPERATORI_SANITARI (
ID_ACC SMALLINT PRIMARY KEY,
ID_STR SMALLINT, 
DATA_ASSUNZIONE DATE,
FOREIGN KEY(ID_STR) REFERENCES STRUTTURE_SANITARIE(ID_STR),
FOREIGN KEY(ID_ACC) REFERENCES PROFILI(ID_ACC)
);

CREATE TABLE OPERATORI_UFFICIO (
ID_ACC SMALLINT PRIMARY KEY,
ID_STR SMALLINT, 
DATA_ASSUNZIONE DATE,
FOREIGN KEY(ID_STR) REFERENCES STRUTTURE_SANITARIE(ID_STR),
FOREIGN KEY(ID_ACC) REFERENCES PROFILI(ID_ACC)
);

CREATE TABLE PAZIENTI (
ID_ACC SMALLINT PRIMARY KEY,
ID_STR SMALLINT, 
DATA_ASSUNZIONE DATE,
FOREIGN KEY(ID_STR) REFERENCES STRUTTURE_SANITARIE(ID_STR),
FOREIGN KEY(ID_ACC) REFERENCES PROFILI(ID_ACC)
);

CREATE TABLE PRESTAZIONI_SANITARIE (
ID_PREST SMALLINT PRIMARY KEY,
CATEGORIA VARCHAR(100), 
TIPO VARCHAR(100),
DURATA SMALLINT,   -- DA CONFERMARE
COSTO SMALLINT
);

CREATE TABLE PRENOTAZIONI (
ID_PREN SMALLINT PRIMARY KEY,
ID_STR SMALLINT,  
ID_PAZIENTE SMALLINT,
ID_MEDICO SMALLINT,
ID_OSS SMALLINT,
ID_PREST SMALLINT,
DATA_PREN DATE,
ORA_PREN TIME,
FOREIGN KEY(ID_STR) REFERENCES STRUTTURE_SANITARIE(ID_STR),
FOREIGN KEY(ID_PAZIENTE) REFERENCES PROFILI(ID_ACC),
FOREIGN KEY(ID_MEDICO) REFERENCES PROFILI(ID_ACC),
FOREIGN KEY(ID_OSS) REFERENCES PROFILI(ID_ACC),
FOREIGN KEY(ID_PREST) REFERENCES PRESTAZIONE_SANITARIA(ID_PREST)
);

CREATE TABLE CARTELLE_CLINICHE (
CF CHAR(16) PRIMARY KEY,
ALTEZZA SMALLINT,
PESO SMALLINT,
GRUPPO_SANGUIGNO CHAR(5),
ID_PREN SMALLINT,
FOREIGN KEY(CF) REFERENCES ANAGRAFICA(CF),
FOREIGN KEY(ID_PREN) REFERENCES PRENOTAZIONE(ID_PREST)
);

CREATE TABLE EROGAZIONI (
ID_PREN SMALLINT PRIMARY KEY,
DATA_EROG DATETIME,   -- DA CONFERMARE
ORA_EROG DATETIME,  -- DA CONFERMARE
ACCREDITAMENTO BOOLEAN,
FOREIGN KEY(ID_PREN) REFERENCES PRENOTAZIONE(ID_PREST)
);

CREATE TABLE ESITI (
ID_PREN SMALLINT PRIMARY KEY,
REFERTO TEXT,
TERAPIA TEXT
);

-- CREATE TABLE CALENDARI (
-- CALENDARIO_DATA,
-- CALENDARIO ORA,
-- ID_PREN SMALLINT,
-- PRIMARY KEY(CALENDARIO_DATA, CALENDARIO_ORA)
-- FOREIGN KEY(ID_PREN) REFERENCES PRENOTAZIONE(ID_PREST)
-- );

CREATE TABLE CALENDARI (
    CALENDARIO_DATA DATETIME PRIMARY KEY,
	GIORNO  VARCHAR(10),
	MESE VARCHAR(10),
	ANNO VARCHAR(10),
	NOME_GIORNO VARCHAR(10),
	NOME_MESE VARCHAR(10),
	NOME_VACANZE VARCHAR(50),
	FLAG_VACANZE VARCHAR(10)
);

CREATE TABLE AGENDE (
	SLOT TIMESTAMP PRIMARY KEY,
	CALENDARIO_DATA DATETIME,
    ID_PREN SMALLINT,
    FOREIGN KEY(ID_PREN) REFERENCES PRENOTAZIONE(ID_PREST),
	FOREIGN KEY(CALENDARIO_DATA) REFERENCES CALENDARI(CALENDARIO_DATA)
);

GO -- DA SISTEMARE

DECLARE @StartDate DATETIME
DECLARE @EndDate DATETIME
SET @StartDate = GETDATE()
SET @EndDate = DATEADD(d, 365, @StartDate)

WHILE @StartDate <= @EndDate
	BEGIN
             INSERT INTO CALENDARI (
				  CALENDARIO_DATA DATETIME,
				  GIORNO  VARCHAR(10),
				  MESE VARCHAR(10),
				  ANNO VARCHAR(10),
				  NOME_GIORNO VARCHAR(10),
				  NOME_MESE VARCHAR(10),
				  NOME_VACANZE VARCHAR(50),
				  FLAG_VACANZE VARCHAR(10)
             )
             SELECT
                   @StartDate,
				   DAY(@StartDate),
				   MONTH(@StartDate),
				   YEAR(@StartDate),
   				   DATENAME(WEEKDAY, (@StartDate)),
				   DATENAME(MONTH, (@StartDate)),
				   NULL,
				   'N'
                   
			DECLARE @StartSchedule DATETIME
			DECLARE @EndSchedule DATETIME
			SET @StartSchedule = HOUR(7)
			SET @EndSchedule = DATEADD(h, 12, @StartSchedule)

			WHILE @StartSchedule <= @EndSchedule
				  BEGIN
						 INSERT INTO AGENDE (
							  CALENDARIO_DATA DATETIME,
							  SLOT TIMESTAMP,
							  ORARIO DATETIME,
							  ID_PREN SMALLINT,
						 )
						 SELECT
							   @StartDate,
							   TIMESTAMP,
							   HOUR(@StartSchedule)
							   NULL,
							
						SET @StartSchedule = ADD(h, 1, @StartSchedule)
			END
                   
			SET @StartDate = DATEADD(d, 1, @StartDate)
END









