-- DATABASE HOSPITALMANAGER
-- ______________________________________________________________
DROP SCHEMA hospitalmanager;
CREATE SCHEMA hospitalmanager;
USE hospitalmanager;

DROP TABLE IF EXISTS PROFILI;
DROP TABLE IF EXISTS CARTELLE_CLINICHE;
DROP TABLE IF EXISTS PRENOTAZIONI;
DROP TABLE IF EXISTS PRESTAZIONI_SANITARIE;
DROP TABLE IF EXISTS CALENDARI;

CREATE TABLE PRESTAZIONI_SANITARIE (
	TIPO_PRESTAZIONE VARCHAR(100) PRIMARY KEY,
	DURATA TIME CHECK(MINUTE(DURATA)%30 = 0 AND HOUR(DURATA) <= 12)
);

CREATE TABLE PROFILI (
    CF CHAR(16),
	TIPO CHAR(2) CHECK (TIPO = 'ME' OR TIPO = 'OS' OR TIPO = 'OU' OR TIPO = 'PA'),
	PW VARCHAR(20),
    SPECIALIZZAZIONE VARCHAR(100),
    
	NOME VARCHAR(50),
	COGNOME VARCHAR(50),
	SESSO CHAR(7) CHECK (SESSO = 'M' OR SESSO = 'F'),
	DATA_NASCITA CHAR(10),
	LUOGO_NASCITA VARCHAR(50),
	PROVINCIA_NASCITA CHAR(2),
	REGIONE_RESIDENZA CHAR(50),
	PROVINCIA_RESIDENZA CHAR(2),
	CITTA_RESIDENZA VARCHAR(50),
	INDIRIZZO VARCHAR(100),
    CAP CHAR(5),
	EMAIL VARCHAR(100),
	CELLULARE CHAR(20),
    PRIMARY KEY(CF, TIPO),
    FOREIGN KEY(SPECIALIZZAZIONE) REFERENCES PRESTAZIONI_SANITARIE(TIPO_PRESTAZIONE)
);

CREATE TABLE PRENOTAZIONI (
	ID_PREN SMALLINT PRIMARY KEY,
	PAZIENTE CHAR(16),
	PERSONALE_SANITARIO CHAR(16),
	TIPO_PRESTAZIONE VARCHAR(100),
	DATA_PREN DATE,
	ORA_PREN TIME,
	FOREIGN KEY(PAZIENTE) REFERENCES PROFILI(CF),
	FOREIGN KEY(PERSONALE_SANITARIO) REFERENCES PROFILI(CF),
	FOREIGN KEY(TIPO_PRESTAZIONE) REFERENCES PRESTAZIONI_SANITARIE(TIPO_PRESTAZIONE)
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

CREATE TABLE CALENDARI (
	-- ID_STR SMALLINT DEFAULT 00,
    CALENDARIO_DATA DATE DEFAULT '2000-01-01',
    GIORNO_SETTIMANA CHAR(10),
    NOME_VACANZE VARCHAR(50),
	ORARIO TIME DEFAULT '00:00:00.000000',
    VISITA_ONCOLOGICA SMALLINT,
    VISITA_PSICOLOGICA SMALLINT,
    ESAMI_SANGUE SMALLINT,
    TAC SMALLINT,
    RISONANZA_MAGNETICA SMALLINT,
    CHEMIOTERAPIA SMALLINT,
    RADIOTERAPIA SMALLINT,
    
    PRIMARY KEY(CALENDARIO_DATA, ORARIO),
    FOREIGN KEY(VISITA_ONCOLOGICA) REFERENCES PRENOTAZIONI(ID_PREN),
	FOREIGN KEY(VISITA_PSICOLOGICA) REFERENCES PRENOTAZIONI(ID_PREN),
    FOREIGN KEY(ESAMI_SANGUE) REFERENCES PRENOTAZIONI(ID_PREN),
    FOREIGN KEY(TAC) REFERENCES PRENOTAZIONI(ID_PREN),
    FOREIGN KEY(RISONANZA_MAGNETICA) REFERENCES PRENOTAZIONI(ID_PREN),
    FOREIGN KEY(CHEMIOTERAPIA) REFERENCES PRENOTAZIONI(ID_PREN),
    FOREIGN KEY(RADIOTERAPIA) REFERENCES PRENOTAZIONI(ID_PREN)
);

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
				  VISITA_ONCOLOGICA, VISITA_PSICOLOGICA, ESAMI_SANGUE, TAC, RISONANZA_MAGNETICA, CHEMIOTERAPIA, RADIOTERAPIA
             )
             SELECT
                   -- 01,
                   StartDate,
                   DAYNAME(StartDate),
                   NULL,
                   StartSchedule,
				   NULL, NULL, NULL, NULL, NULL, NULL, NULL;
							
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
INSERT INTO PRESTAZIONI_SANITARIE VALUES ('VISITA_ONCOLOGICA', '00:30:00.000000');
INSERT INTO PRESTAZIONI_SANITARIE VALUES ('VISITA_PSICOLOGICA', '00:30:00.000000');
INSERT INTO PRESTAZIONI_SANITARIE VALUES ('ESAMI_SANGUE', '00:30:00.000000');
INSERT INTO PRESTAZIONI_SANITARIE VALUES ('TAC', '00:30:00.000000');
INSERT INTO PRESTAZIONI_SANITARIE VALUES ('RISONANZA_MAGNETICA', '00:30:00.000000');
INSERT INTO PRESTAZIONI_SANITARIE VALUES ('CHEMIOTERAPIA', '00:30:00.000000');
INSERT INTO PRESTAZIONI_SANITARIE VALUES ('RADIOTERAPIA', '00:30:00.000000');
END//
mysql> delimiter ;
call POPOLA_PRESTAZIONI();
-- SELECT * FROM PRESTAZIONI_SANITARIE;

mysql> delimiter //
CREATE PROCEDURE POPOLA_PROFILI()
BEGIN 
INSERT INTO PROFILI VALUES ('ABCD123456789012', 'ME', 'P4ssw0rd!', 'VISITA_ONCOLOGICA', 'Giulia', 'Bianchi', 'F', '1995-09-23', 'Milano', 'MI', 'Lombardia', 'MI', 'Milano', 'Via Roma 12', '20121', 'giulia.bianchi@email.com', '1234567890');
INSERT INTO PROFILI VALUES ('EFGH789012345678', 'ME', 'SecurePW123', 'VISITA_PSICOLOGICA', 'Luca', 'Verdi', 'M', '1988-04-12', 'Napoli', 'NA', 'Campania', 'NA', 'Napoli', 'Via Napoli 5', '80100', 'luca.verdi@email.com', '9876543210');
INSERT INTO PROFILI VALUES ('IJKL567890123456', 'OS', 'SecretPass', 'ESAMI_SANGUE', 'Chiara', 'Russo', 'F', '1990-11-30', 'Palermo', 'PA', 'Sicilia', 'PA', 'Palermo', 'Via Palermo 9', '90100', 'chiara.russo@email.com', '8765432109');
INSERT INTO PROFILI VALUES ('MNOP234567890123', 'OS', 'HiddenPass', 'TAC', 'Alessandro', 'Ferrari', 'M', '1982-07-17', 'Torino', 'TO', 'Piemonte', 'TO', 'Torino', 'Via Torino 3', '10100', 'alessandro.ferrari@email.com', '7654321098');
INSERT INTO PROFILI VALUES ('QRST890123456789', 'OS', 'SafePassword', 'RISONANZA_MAGNETICA', 'Sofia', 'Martini', 'F', '1990-02-05', 'Firenze', 'FI', 'Toscana', 'FI', 'Firenze', 'Via Firenze 7', '50100', 'sofia.martini@email.com', '6543210987');
INSERT INTO PROFILI VALUES ('UVWX123456789012', 'OS', 'Protected123', 'CHEMIOTERAPIA', 'Lorenzo', 'Moretti', 'M', '1976-12-28', 'Bologna', 'BO', 'Emilia-Romagna', 'BO', 'Bologna', 'Via Bologna 10', '40100', 'lorenzo.moretti@email.com', '5432109876');
INSERT INTO PROFILI VALUES ('YZAB567890123456', 'OS', 'SafeAndSound', 'RADIOTERAPIA', 'Anna', 'Conti', 'F', '1985-06-14', 'Genova', 'GE', 'Liguria', 'GE', 'Genova', 'Via Genova 15', '16100', 'anna.conti@email.com', '4321098765');
INSERT INTO PROFILI VALUES ('CDEF901234567890', 'OU', 'HiddenSafePW', NULL, 'Matteo', 'Romano', 'M', '1998-10-20', 'Bari', 'BA', 'Puglia', 'BA', 'Bari', 'Via Bari 18', '70100', 'matteo.romano@email.com', '3210987654');
INSERT INTO PROFILI VALUES ('GHIJ345678901234', 'PA', 'StrongPW1234', NULL, 'Elisa', 'Gallo', 'F', '1979-03-10', 'Catania', 'CT', 'Sicilia', 'CT', 'Catania', 'Via Catania 21', '95100', 'elisa.gallo@email.com', '2109876543');
INSERT INTO PROFILI VALUES ('KLMN678901234567', 'PA', 'PW123Safe!', NULL, 'Giovanni', 'Esposito', 'M', '1987-08-25', 'Venezia', 'VE', 'Veneto', 'VE', 'Venezia', 'Via Venezia 25', '30100', 'giovanni.esposito@email.com', '1098765432');
INSERT INTO PROFILI VALUES ('ABCD567890123456', 'PA', 'Secure123PW!', NULL, 'Laura', 'Marchetti', 'F', '1993-12-08', 'Roma', 'RM', 'Lazio', 'RM', 'Roma', 'Via Roma 23', '00100', 'laura.marchetti@email.com', '2345678901');
INSERT INTO PROFILI VALUES ('EFGH901234567890', 'PA', 'MySafePass', NULL, 'Marco', 'Galli', 'M', '1984-05-17', 'Milano', 'MI', 'Lombardia', 'MI', 'Milano', 'Via Milano 34', '20100', 'marco.galli@email.com', '3456789012');
INSERT INTO PROFILI VALUES ('IJKL123456789012', 'PA', 'PasswordSafe1', NULL, 'Federica', 'Ricci', 'F', '1996-10-25', 'Napoli', 'NA', 'Campania', 'NA', 'Napoli', 'Via Napoli 45', '80100', 'federica.ricci@email.com', '4567890123');
INSERT INTO PROFILI VALUES ('MNOP567890123456', 'PA', 'StrongPass123', NULL, 'Andrea', 'Barbieri', 'M', '1981-02-18', 'Torino', 'TO', 'Piemonte', 'TO', 'Torino', 'Via Torino 56', '10100', 'andrea.barbieri@email.com', '5678901234');
INSERT INTO PROFILI VALUES ('QRST901234567890', 'PA', 'SafeAndStrong', NULL, 'Valentina', 'Morello', 'F', '1989-07-15', 'Firenze', 'FI', 'Toscana', 'FI', 'Firenze', 'Via Firenze 67', '50100', 'valentina.morello@email.com', '6789012345');
INSERT INTO PROFILI VALUES ('UVWX123456789012', 'PA', 'ProtectedPW!', NULL, 'Davide', 'Rossini', 'M', '1977-11-28', 'Bologna', 'BO', 'Emilia-Romagna', 'BO', 'Bologna', 'Via Bologna 78', '40100', 'davide.rossini@email.com', '7890123456');
INSERT INTO PROFILI VALUES ('YZAB567890123456', 'PA', 'SafePass987', NULL, 'Elena', 'Ferrara', 'F', '1986-06-14', 'Genova', 'GE', 'Liguria', 'GE', 'Genova', 'Via Genova 89', '16100', 'elena.ferrara@email.com', '8901234567');
INSERT INTO PROFILI VALUES ('CDEF901234567890', 'PA', 'TopSecretPW', NULL, 'Roberto', 'Sanna', 'M', '1999-11-20', 'Bari', 'BA', 'Puglia', 'BA', 'Bari', 'Via Bari 90', '70100', 'roberto.sanna@email.com', '9012345678');
INSERT INTO PROFILI VALUES ('GHIJ567890123456', 'PA', 'MySecurePass', NULL, 'Sara', 'Lombardi', 'F', '1980-04-10', 'Catania', 'CT', 'Sicilia', 'CT', 'Catania', 'Via Catania 12', '95100', 'sara.lombardi@email.com', '0123456789');
INSERT INTO PROFILI VALUES ('KLMN901234567890', 'PA', 'Password123Safe', NULL, 'Giacomo', 'Riva', 'M', '1988-08-25', 'Venezia', 'VE', 'Veneto', 'VE', 'Venezia', 'Via Venezia 56', '30100', 'giacomo.riva@email.com', '1234567890');
END//
mysql> delimiter ;
call POPOLA_PROFILI();
-- SELECT * FROM PROFILI;

mysql> delimiter //
CREATE PROCEDURE POPOLA_CARTELLE_CLINICHE()
BEGIN 
INSERT INTO CARTELLE_CLINICHE VALUES ('GHIJ345678901234', '165', '60', 'A_POSITIVO');
INSERT INTO CARTELLE_CLINICHE VALUES ('KLMN678901234567', '175', '72', 'A_NEGATIVO');
INSERT INTO CARTELLE_CLINICHE VALUES ('ABCD567890123456', '160', '55', 'B_POSITIVO');
INSERT INTO CARTELLE_CLINICHE VALUES ('EFGH901234567890', '180', '75', 'B_NEGATIVO');
INSERT INTO CARTELLE_CLINICHE VALUES ('IJKL123456789012', '168', '64', 'AB_POSITIVO');
INSERT INTO CARTELLE_CLINICHE VALUES ('MNOP567890123456', '172', '70', 'AB_NEGATIVO');
INSERT INTO CARTELLE_CLINICHE VALUES ('QRST901234567890', '158', '50', 'ZERO_POSITIVO');
INSERT INTO CARTELLE_CLINICHE VALUES ('UVWX123456789012', '182', '78', 'ZERO_NEGATIVO');
INSERT INTO CARTELLE_CLINICHE VALUES ('YZAB567890123456', '163', '58', 'A_NEGATIVO');
INSERT INTO CARTELLE_CLINICHE VALUES ('CDEF901234567890', '170', '68', 'A_POSITIVO');
INSERT INTO CARTELLE_CLINICHE VALUES ('GHIJ567890123456', '172', '70', 'B_NEGATIVO');
INSERT INTO CARTELLE_CLINICHE VALUES ('KLMN901234567890', '190', '90', 'B_POSITIVO');
END//
mysql> delimiter ;
call POPOLA_CARTELLE_CLINICHE();
-- SELECT * FROM CARTELLE_CLINICHE;

mysql> delimiter //
CREATE PROCEDURE POPOLA_PRENOTAZIONI()
BEGIN 
-- INSERT INTO PRENOTAZIONI VALUES ('ID_PREN', 'PAZIENTE', 'PERSONALE_SANITARIO', 'ID_PREST', 'DATA_PREN', 'ORA_PREN', 'ACCREDITAMENTO', 'ESITO');
INSERT INTO PRENOTAZIONI VALUES ('1000', 'GHIJ345678901234', 'ABCD123456789012', 'VISITA_ONCOLOGICA', '2023-12-01', '07:00:00.000000');
INSERT INTO PRENOTAZIONI VALUES ('1001', 'KLMN678901234567', 'EFGH789012345678', 'VISITA_PSICOLOGICA', '2023-12-01', '08:00:00.000000');
INSERT INTO PRENOTAZIONI VALUES ('1002', 'ABCD567890123456', 'IJKL567890123456', 'ESAMI_SANGUE', '2023-12-01', '08:00:00.000000');
INSERT INTO PRENOTAZIONI VALUES ('1003', 'EFGH901234567890', 'MNOP234567890123', 'TAC', '2023-12-01', '10:00:00.000000');
INSERT INTO PRENOTAZIONI VALUES ('1004', 'IJKL123456789012', 'QRST890123456789', 'RISONANZA_MAGNETICA', '2023-12-01', '10:00:00.000000');
INSERT INTO PRENOTAZIONI VALUES ('1005', 'MNOP567890123456', 'UVWX123456789012', 'CHEMIOTERAPIA', '2023-12-01', '11:00:00.000000');
INSERT INTO PRENOTAZIONI VALUES ('1006', 'QRST901234567890', 'YZAB567890123456', 'RADIOTERAPIA', '2023-12-01', '11:00:00.000000');
INSERT INTO PRENOTAZIONI VALUES ('1007', 'UVWX123456789012', 'ABCD123456789012', 'VISITA_ONCOLOGICA', '2023-12-01', '09:00:00.000000');
INSERT INTO PRENOTAZIONI VALUES ('1008', 'YZAB567890123456', 'EFGH789012345678', 'VISITA_PSICOLOGICA', '2023-12-01', '09:00:00.000000');
INSERT INTO PRENOTAZIONI VALUES ('1009', 'CDEF901234567890', 'IJKL567890123456', 'ESAMI_SANGUE', '2023-12-01', '16:00:00.000000');

INSERT INTO PRENOTAZIONI VALUES ('1010', 'UVWX123456789012', 'ABCD123456789012', 'VISITA_ONCOLOGICA', '2023-12-12', '07:00:00.000000');
INSERT INTO PRENOTAZIONI VALUES ('1011', 'YZAB567890123456', 'EFGH789012345678', 'VISITA_PSICOLOGICA', '2023-12-12', '08:00:00.000000');
INSERT INTO PRENOTAZIONI VALUES ('1012', 'CDEF901234567890', 'IJKL567890123456', 'ESAMI_SANGUE', '2023-12-13', '16:00:00.000000');
INSERT INTO PRENOTAZIONI VALUES ('1013', 'GHIJ567890123456', 'MNOP234567890123', 'TAC', '2023-12-13', '14:00:00.000000');
INSERT INTO PRENOTAZIONI VALUES ('1014', 'KLMN901234567890', 'QRST890123456789', 'RISONANZA_MAGNETICA', '2023-12-13', '11:00:00.000000');
INSERT INTO PRENOTAZIONI VALUES ('1015', 'GHIJ345678901234', 'UVWX123456789012', 'CHEMIOTERAPIA', '2023-12-13', '18:00:00.000000');
INSERT INTO PRENOTAZIONI VALUES ('1016', 'KLMN678901234567', 'YZAB567890123456', 'RADIOTERAPIA', '2023-12-14', '18:00:00.000000');

INSERT INTO PRENOTAZIONI VALUES ('1017', 'ABCD567890123456', 'ABCD123456789012', 'VISITA_ONCOLOGICA', '2023-12-15', '15:00:00.000000');
INSERT INTO PRENOTAZIONI VALUES ('1018', 'EFGH901234567890', 'EFGH789012345678', 'VISITA_PSICOLOGICA', '2023-12-15', '08:00:00.000000');
INSERT INTO PRENOTAZIONI VALUES ('1019', 'IJKL123456789012', 'IJKL567890123456', 'ESAMI_SANGUE', '2023-12-15', '09:00:00.000000');
INSERT INTO PRENOTAZIONI VALUES ('1020', 'MNOP567890123456', 'MNOP234567890123', 'TAC', '2023-12-15', '17:00:00.000000');
INSERT INTO PRENOTAZIONI VALUES ('1021', 'QRST901234567890', 'QRST890123456789', 'RISONANZA_MAGNETICA', '2023-12-15', '07:00:00.000000');
INSERT INTO PRENOTAZIONI VALUES ('1022', 'UVWX123456789012', 'UVWX123456789012', 'CHEMIOTERAPIA', '2023-12-15', '18:00:00.000000');
INSERT INTO PRENOTAZIONI VALUES ('1023', 'YZAB567890123456', 'YZAB567890123456', 'RADIOTERAPIA', '2023-12-15', '18:00:00.000000');
END//
mysql> delimiter ;
call POPOLA_PRENOTAZIONI();
-- SELECT * FROM PRENOTAZIONI;

SET SQL_SAFE_UPDATES = 0;
UPDATE CALENDARI SET VISITA_ONCOLOGICA = 1000 WHERE CALENDARIO_DATA = '2023-12-01' AND ORARIO = '07:00:00.000000';
UPDATE CALENDARI SET VISITA_PSICOLOGICA = 1001 WHERE CALENDARIO_DATA = '2023-12-01' AND ORARIO = '08:00:00.000000';
UPDATE CALENDARI SET ESAMI_SANGUE = 1002 WHERE CALENDARIO_DATA = '2023-12-01' AND ORARIO = '08:00:00.000000';
UPDATE CALENDARI SET TAC = 1003 WHERE CALENDARIO_DATA = '2023-12-01' AND ORARIO = '10:00:00.000000';
UPDATE CALENDARI SET RISONANZA_MAGNETICA = 1004 WHERE CALENDARIO_DATA = '2023-12-01' AND ORARIO = '10:00:00.000000';
UPDATE CALENDARI SET CHEMIOTERAPIA = 1005 WHERE CALENDARIO_DATA = '2023-12-01' AND ORARIO = '11:00:00.000000';
UPDATE CALENDARI SET RADIOTERAPIA = 1006 WHERE CALENDARIO_DATA = '2023-12-01' AND ORARIO = '11:00:00.000000';
UPDATE CALENDARI SET VISITA_ONCOLOGICA = 1007 WHERE CALENDARIO_DATA = '2023-12-01' AND ORARIO = '09:00:00.000000';
UPDATE CALENDARI SET VISITA_PSICOLOGICA = 1008 WHERE CALENDARIO_DATA = '2023-12-01' AND ORARIO = '09:00:00.000000';
UPDATE CALENDARI SET ESAMI_SANGUE = 1009 WHERE CALENDARIO_DATA = '2023-12-01' AND ORARIO = '16:00:00.000000';

UPDATE CALENDARI SET VISITA_ONCOLOGICA = 1010 WHERE CALENDARIO_DATA = '2023-12-12' AND ORARIO = '07:00:00.000000';
UPDATE CALENDARI SET VISITA_PSICOLOGICA = 1011 WHERE CALENDARIO_DATA = '2023-12-12' AND ORARIO = '08:00:00.000000';
UPDATE CALENDARI SET ESAMI_SANGUE = 1012 WHERE CALENDARIO_DATA = '2023-12-13' AND ORARIO = '16:00:00.000000';
UPDATE CALENDARI SET TAC = 1013 WHERE CALENDARIO_DATA = '2023-12-13' AND ORARIO = '14:00:00.000000';
UPDATE CALENDARI SET RISONANZA_MAGNETICA = 1014 WHERE CALENDARIO_DATA = '2023-12-13' AND ORARIO = '11:00:00.000000';
UPDATE CALENDARI SET CHEMIOTERAPIA = 1015 WHERE CALENDARIO_DATA = '2023-12-13' AND ORARIO = '18:00:00.000000';
UPDATE CALENDARI SET RADIOTERAPIA = 1016 WHERE CALENDARIO_DATA = '2023-12-14' AND ORARIO = '18:00:00.000000';

UPDATE CALENDARI SET VISITA_ONCOLOGICA = 1017 WHERE CALENDARIO_DATA = '2023-12-15' AND ORARIO = '15:00:00.000000';
UPDATE CALENDARI SET VISITA_PSICOLOGICA = 1018 WHERE CALENDARIO_DATA = '2023-12-15' AND ORARIO = '08:00:00.000000';
UPDATE CALENDARI SET ESAMI_SANGUE = 1019 WHERE CALENDARIO_DATA = '2023-12-15' AND ORARIO = '09:00:00.000000';
UPDATE CALENDARI SET TAC = 1020 WHERE CALENDARIO_DATA = '2023-12-15' AND ORARIO = '17:00:00.000000';
UPDATE CALENDARI SET RISONANZA_MAGNETICA = 1021 WHERE CALENDARIO_DATA = '2023-12-15' AND ORARIO = '07:00:00.000000';
UPDATE CALENDARI SET CHEMIOTERAPIA = 1022 WHERE CALENDARIO_DATA = '2023-12-15' AND ORARIO = '18:00:00.000000';
UPDATE CALENDARI SET RADIOTERAPIA = 1023 WHERE CALENDARIO_DATA = '2023-12-15' AND ORARIO = '18:00:00.000000';
SET SQL_SAFE_UPDATES = 1;
SELECT * FROM CALENDARI;


-- imposto null le specializzazioni per profili che non sono di tipo medico
-- SET SQL_SAFE_UPDATES = 0;
-- UPDATE PROFILI 
-- SET SPECIALIZZAZIONE = NULL
-- WHERE TIPO = 'PA' AND TIPO = 'OU';
-- SET SQL_SAFE_UPDATES = 1;
