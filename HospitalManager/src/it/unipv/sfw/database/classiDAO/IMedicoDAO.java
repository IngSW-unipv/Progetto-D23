package it.unipv.sfw.database.classiDAO;

import java.util.ArrayList;

import it.unipv.sfw.persona.Medico;

public interface IMedicoDAO {

	public ArrayList<Medico> selectAll();

	public boolean insertMedico(Medico med);

	public Medico select_Medico_from_CF(String CF);
	
	public void deleteMedico(Medico med);

	public void updateMedico(Medico vet);
}
