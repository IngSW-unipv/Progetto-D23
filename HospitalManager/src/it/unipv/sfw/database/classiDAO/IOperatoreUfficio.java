package it.unipv.sfw.database.classiDAO;

import java.util.ArrayList;

import it.unipv.sfw.persona.OperatoreUfficio;

public interface IOperatoreUfficio {

	public ArrayList<OperatoreUfficio> selectAll();

	public boolean insertOpUfficio(OperatoreUfficio OpUff);
	
	public OperatoreUfficio selectOpUfficiofromID(int ID);
	
	public void deleteOpUfficio(int id);
	
	public void updateOpUfficio(OperatoreUfficio OpUff);
}
