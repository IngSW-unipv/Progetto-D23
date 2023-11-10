package it.unipv.sfw.jdbc.bean.profilo;

import java.util.ArrayList;

import it.unipv.sfw.model.TipoAccount;
import it.unipv.sfw.model.persona.Account;

public interface IProfiloDAO {
	ArrayList<ProfiloDB> selectAllProfili();
	ArrayList<ProfiloDB> selectAllPazienti();
	ArrayList<ProfiloDB> selectAllMedici();
	ArrayList<ProfiloDB> selectAllOperatoriSanitari();
	ArrayList<ProfiloDB> selectAlloperatoriUfficio();
	ProfiloDB selectProfiloByCF(String CF, TipoAccount tipo);
	boolean insertProfilo(Account a);
	boolean updatePw(String CF, TipoAccount tipo, String pw);
}
