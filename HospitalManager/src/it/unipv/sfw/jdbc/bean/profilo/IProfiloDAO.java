package it.unipv.sfw.jdbc.bean.profilo;

import java.util.ArrayList;

import it.unipv.sfw.model.TipoAccount;
import it.unipv.sfw.model.TipoPrestazione;
import it.unipv.sfw.model.persona.Account;
import it.unipv.sfw.model.persona.Medico;
import it.unipv.sfw.model.persona.OperatoreSanitario;

public interface IProfiloDAO {
	ArrayList<ProfiloDB> selectAllProfili();
	ArrayList<ProfiloDB> selectAllPazienti();
	ArrayList<ProfiloDB> selectAllMedici();
	ArrayList<ProfiloDB> selectAllOperatoriSanitari();
	ArrayList<ProfiloDB> selectAlloperatoriUfficio();
	ProfiloDB selectProfiloByCF(String cf, TipoAccount tipo);
	boolean insertProfilo(ProfiloDB a);
	boolean updatePw(String cf, TipoAccount tipo, String pw);
}
