package it.unipv.sfw.jdbc.bean;

import java.util.ArrayList;

public interface IAccountDAO {
	public ArrayList<AccountDB> selectAllAccounts();
	public ArrayList<AccountDB> selectAllType(ArrayList<AccountDB> arraylist, String tipo);
}
