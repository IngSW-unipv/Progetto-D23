package it.unipv.sfw.persona;

import java.sql.Date;
import it.unipv.sfw.cartellaclinica.CartellaClinica;
public class Paziente extends Persona{

	private int ID;
	private CartellaClinica cartellaClinica;
	
	public int getID() {
		return ID;
	}
	
	public CartellaClinica getCartellaClinica() {
		return cartellaClinica;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public void setCartellaClinica(CartellaClinica a) {
		this.cartellaClinica = a;
	}
	
	
	public Paziente(String nome, String cognome, String CF, String sesso, String email, String cellulare,
			String luogoNascita, String indirizzo, String cap, String paese, Date dataNascita,
			CartellaClinica cartellaClinica, int ID) {
		super(nome, cognome, CF, sesso, email, cellulare, luogoNascita, indirizzo, cap, paese, dataNascita);
		this.cartellaClinica = cartellaClinica;
		this.ID = ID;
	}
	

}
