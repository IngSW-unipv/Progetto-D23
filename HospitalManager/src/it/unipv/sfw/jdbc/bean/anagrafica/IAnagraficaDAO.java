package it.unipv.sfw.jdbc.bean.anagrafica;

import java.util.ArrayList;

import it.unipv.sfw.persona.Persona;

public interface IAnagraficaDAO {
	ArrayList<AnagraficaDB> selectAllAnagrafica();
	boolean insertAnagrafica(Persona p);
}
