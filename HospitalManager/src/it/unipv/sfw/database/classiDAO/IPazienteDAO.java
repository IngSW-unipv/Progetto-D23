package it.unipv.sfw.database.classiDAO;

import java.util.ArrayList;

import it.unipv.sfw.persona.Paziente;

public interface IPazienteDAO {

	public ArrayList<Paziente> selectAll();

	public boolean insertPaziente(Paziente f);
	
	public Paziente selectPazientefromID(int ID);
	
	public void deletePazienti(int id);
	
	public void updatePaziente(Paziente p);
}