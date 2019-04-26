package sef.module13.activity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {

	@SuppressWarnings("unused")
	private Connection conn;
	private PreparedStatement prepStatement;
	private List<Account> accountList = new ArrayList<>();

	public AccountDAOImpl(Connection conn) {
		this.conn = conn;
	}

	public List<Account> findAccount(String firstName, String lastName)
			throws AccountDAOException {
		 List<Account> accountList = new ArrayList<>();

		try{
			prepStatement = conn.prepareStatement("select * from ACCOUNT where FIRST_NAME LIKE ? AND LAST_NAME LIKE ? order by ID ASC");
			prepStatement.setString(1, "%"+firstName+"%");
			prepStatement.setString(2,"%"+lastName+"%");
			ResultSet res = prepStatement.executeQuery();
			while(res.next()){
				int id = res.getInt(1);
				String firstN = res.getString(2);
				String lastN = res.getString(3);
				String email = res.getString(4);
				accountList.add(new AccountImpl(id, firstN, lastN, email));
			}
			conn.close();
			//return accountList;

		}catch (SQLException e ){
			throw new AccountDAOException(AccountDAOException.ERROR_FIND_NAME,e);
		}
		return accountList;
	}

	public Account findAccount(int id) throws AccountDAOException {
		Account account= null;
		try{
			prepStatement = conn.prepareStatement("select * from Account where id = ?");
			prepStatement.setInt(1,id);
			ResultSet res = prepStatement.executeQuery();
			while(res.next()){
				int id_ = res.getInt(1);
				String firstN = res.getString(2);
				String lastN = res.getString(3);
				String email = res.getString(4);
				account = new AccountImpl(id_,firstN,lastN,email);
			}
			conn.close();
			//return account;
		}catch (SQLException e){
			throw new AccountDAOException(AccountDAOException.ERROR_FIND_ID,e);
		}
		return account;
	}


	public boolean insertAccount(String firstName, String lastName, String email)
			throws AccountDAOException {
		try{
			prepStatement = conn.prepareStatement("insert into Account(ID, FIRST_NAME,LAST_NAME,E_MAIL) values (ACCOUNT_SEQ.NEXTVAL,?,?,?)");
			prepStatement.setString(1,firstName);
			prepStatement.setString(2,lastName);
			prepStatement.setString(3,email);
			prepStatement.execute();
		}catch (SQLException e){
			throw new AccountDAOException(AccountDAOException.ERROR_INSERT_ACCOUNT,e);
		}
		return true;
	}

}
