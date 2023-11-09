package it.unipv.sfw.jdbc.bean.anagrafica;

import java.util.ArrayList;

import it.unipv.sfw.model.persona.Persona;

public interface IAnagraficaDAO {
	ArrayList<AnagraficaDB> selectAllAnagrafica();
	AnagraficaDB selectAnagraficaByCf(String cf);
	boolean insertAnagrafica(Persona p);
	ArrayList<AnagraficaDB> selectAnagraficaMedici();
}
