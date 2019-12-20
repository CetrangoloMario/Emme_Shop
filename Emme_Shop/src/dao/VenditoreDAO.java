package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import manageraccouting.Utente;
import manageraccouting.Venditore;

public class VenditoreDAO {
	
	private static DataSource ds;
	
	private static final String TABLE_CLIENTE = "cliente";
	private static final String TABLE_VENDITORE = "venditore";
	private static final String TABLE_AMMINISTRATORE = "amministratore";
	private static final String TABLE_PRODOTTO="prodotto";
	private static final String TABLE_CATEGORIA="categoria";
	private static final String TABLE_NEGOZIO="negozio";
	private static final String TABLE_FATTURA="fattura";
	private static final String TABLE_RIFERIMENTO="riferimento";
	
	
	
	static {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			
			System.out.println(envCtx.INITIAL_CONTEXT_FACTORY);

			ds = (DataSource) envCtx.lookup("jdbc/emmeshop_db");

		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public synchronized Utente checkLoginSeller(String username,String password) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		Utente bean = new Venditore();

		String selectSQL = "SELECT username,password FROM " + VenditoreDAO.TABLE_VENDITORE + " WHERE username = ? AND password = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setUsername(rs.getString("username"));
				bean.setPassword(rs.getString("password"));
			}

		} 
		finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		

		if(bean.getUsername().trim().equalsIgnoreCase("") || bean==null)
			return null;
		else
			return bean;
	}
	

}
