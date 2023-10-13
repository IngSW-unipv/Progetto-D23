package it.unipv.sfw.jdbc.bean;

import java.util.ArrayList;

public interface IAccountDAO {
	public ArrayList<AccountDB> selectAllAccounts();
	public ArrayList<AccountDB> selectAllType(ArrayList<AccountDB> arraylist, String tipo);
	public boolean insertAccount(int idAcc, String tipoAcc, String cf, String pw, String specializzazione);
}
