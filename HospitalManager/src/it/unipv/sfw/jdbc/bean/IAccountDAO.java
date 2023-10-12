package it.unipv.sfw.jdbc.bean;

import java.util.ArrayList;

public interface IAccountDAO {
	public ArrayList<AccountDB> selectAllAccounts();
	public ArrayList<AccountDB> selectAllMedici();
	public ArrayList<AccountDB> selectAllOperatoriSanitari();
	public ArrayList<AccountDB> selectAllOperatoriUfficio();
	public ArrayList<AccountDB> selectAllPazienti();
}
