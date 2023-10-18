package it.unipv.sfw.jdbc.bean.anagrafica;

import java.util.ArrayList;

import it.unipv.sfw.account.Persona;

public interface IAnagraficaDAO {
	ArrayList<AnagraficaDB> selectAllAnagrafica();
	boolean insertAnagrafica(Persona p);
}
