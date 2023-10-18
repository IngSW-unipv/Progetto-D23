package it.unipv.sfw.jdbc.bean.prestazionesanitaria;

import java.util.ArrayList;

public interface IPrestazioneSanitariaDAO {
	ArrayList<PrestazioneSanitariaDB> selectAllPrestazioniSanitarie();
	PrestazioneSanitariaDB selectPrestazioneByIdPrest(int idPrest);

}
