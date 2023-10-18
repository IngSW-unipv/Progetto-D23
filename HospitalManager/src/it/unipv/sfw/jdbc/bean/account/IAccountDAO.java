package it.unipv.sfw.jdbc.bean.account;

import java.util.ArrayList;

import it.unipv.sfw.model.Account;

public interface IAccountDAO {
	ArrayList<AccountDB> selectAllAccounts();
	ArrayList<AccountDB> selectAllType(ArrayList<AccountDB> arraylist, String tipo);
	boolean insertAccount(Account a);
}
