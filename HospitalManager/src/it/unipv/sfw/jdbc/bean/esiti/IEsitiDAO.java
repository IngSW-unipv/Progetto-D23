package it.unipv.sfw.jdbc.bean.esiti;

import java.util.ArrayList;

import it.unipv.sfw.model.Esito;

public interface IEsitiDAO {
	ArrayList<EsitiDB> SelectAllEsiti();
	boolean insertEsito(Esito e);

}
