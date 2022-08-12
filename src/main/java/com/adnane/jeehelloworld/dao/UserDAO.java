package com.adnane.jeehelloworld.dao;

import java.sql.*;

import com.adnane.jeehelloworld.model.User;

public class UserDAO extends DAOContext {

	public static User isValidLogin(String login, String password ) {
		try ( Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword ) ) {
			// Not safe
			// ??' or 1=1 -- in username
			// String strSql = "SELECT * FROM USER WHERE login='" + login + "' AND password='" + password + "'";
			String strSql = "SELECT * FROM USER WHERE login=? AND password=?";
			try ( PreparedStatement statement  = connection.prepareStatement(strSql) ) {
				statement.setString( 1, login );
				statement.setString( 2, password );
				try ( ResultSet resultSet = statement.executeQuery() ) {
					if ( resultSet.next() ) {
						return new User(
								resultSet.getInt( "idUser" ),
								resultSet.getString( "login" ),
								resultSet.getString( "password" ),
								resultSet.getInt( "connection_number" )
						);
					} else {
						return null;
					}
				}
			}
		} catch ( Exception exception ) {
			throw new RuntimeException( exception );
		}
	}
	
}
