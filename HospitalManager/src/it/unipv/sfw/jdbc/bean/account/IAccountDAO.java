package it.unipv.sfw.jdbc.bean.account;

import java.util.ArrayList;

import it.unipv.sfw.account.Account;

public interface IAccountDAO {
	public ArrayList<AccountDB> selectAllAccounts();
	public ArrayList<AccountDB> selectAllType(ArrayList<AccountDB> arraylist, String tipo);
	public boolean insertAccount(Account a);
}
