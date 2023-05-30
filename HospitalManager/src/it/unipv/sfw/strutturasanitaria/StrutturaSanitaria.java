package it.unipv.sfw.strutturasanitaria;

import java.util.ArrayList;
import java.util.HashMap;
import it.unipv.sfw.persona.*;

public class StrutturaSanitaria implements HospitalManager {
	String struttura, indirizzo, cap, paese;
	HashMap <String, Medico> medici;
	HashMap <String, OperatoreSanitario> operatoriSanitari;
	HashMap <String, OperatoreUfficio> operatoriUfficio;
	HashMap <String, Paziente> pazienti;
	HashMap <String, Account> accounts;
	ArrayList <Reparto> reparti;

}
