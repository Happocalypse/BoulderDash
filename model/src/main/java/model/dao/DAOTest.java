package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.IDAOTest;

public class DAOTest implements IDAOTest {
	private String URL = "jdbc:mysql://178.62.12.146:3306/boulderdash";
	private String LOGIN = "Senuin";
	private String PASSWORD = "Senuin";
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet result;
	private char tab[][] = new char[22][40];

	/**
	 * Connection to the remote database
	 */

	public void connection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
			statement = connection.createStatement();
		} catch (final ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Execute a static SQL request
	 * 
	 */

	public void executeQuery() {
		try {
			result = statement.executeQuery("select * from LV1");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Take the data of the executed request and put character of the map in a
	 * character table
	 */

	public void setQueryIntoTable() {
		try {
			int ligne = 0;
			while (result.next()) {
				for (int colonne = 0; colonne < result.getObject(2).toString().length(); colonne++) {
					tab[ligne][colonne] = result.getObject(2).toString().charAt(colonne);
				}
				ligne++;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * Show the map in the console in the form of characters
		 * 
		 */

		// for (char sousTab[] : tab){
		// for(char str : sousTab){
		// System.out.print(str);
		// }
		// System.out.println("");
		// }

	}

	/**
	 * @return tab
	 * 				the table which contains the result of the executed query
	 * 
	 */

	public char[][] getTab() {
		return tab;
	}
}

// ResultSetMetaData resultMeta;
// resultMeta = (ResultSetMetaData) result.getMetaData();

// On affiche le nom des colonnes

// for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
// // resultMeta r�cup�re les m�tadonn�es de la requ�te
// System.out.print("*" + "\t" +
// resultMeta.getColumnName(i).toUpperCase() + "\t *");
// }