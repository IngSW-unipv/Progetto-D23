package it.unipv.sfw.jdbc.bean.anagrafica;

import java.util.ArrayList;

import it.unipv.sfw.model.Persona;

public interface IAnagraficaDAO {
	ArrayList<AnagraficaDB> selectAllAnagrafica();
	AnagraficaDB selectAnagraficaByCf(String cf);
	boolean insertAnagrafica(Persona p);
}
