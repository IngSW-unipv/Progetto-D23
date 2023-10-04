package it.unipv.sfw.database.classiDAO;

import java.util.ArrayList;

import it.unipv.sfw.persona.OperatoreSanitario;

public interface IOperatoreSanitarioDAO {

	public ArrayList<OperatoreSanitario> selectAll();

	public boolean insertOpSanitario(OperatoreSanitario OpSan);
	
	public OperatoreSanitario selectOpSanitariofromID(int ID);
	
	public void deleteOpSanitario(int id);
	
	public void updateOpSanitario(OperatoreSanitario OpSan);
}
