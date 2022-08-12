package com.adnane.jeehelloworld.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.adnane.jeehelloworld.model.Article;

public class ArticleDAO extends DAOContext {

	public static int getArticleCount() {
		try ( Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword ) ){

			String strSql = "SELECT count(idArticle) FROM ARTICLE";
			try ( Statement statement  = connection.createStatement() ) {
				try ( ResultSet resultSet = statement.executeQuery( strSql ) ) {
					resultSet.next();
					return resultSet.getInt( 1 );
				}
			}
		} catch ( Exception exception ) {
			throw new RuntimeException( exception );
		}
	}
	
	public static Article getArticleById(int idArticle ) {
		try ( Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword ) ){
			System.out.println( "connection to the database" );
			String strSql = "SELECT * FROM ARTICLE WHERE idArticle=?";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				statement.setInt( 1, idArticle );
				try ( ResultSet resultSet = statement.executeQuery() ) {
					resultSet.next();
					return new Article(
							resultSet.getInt( "idArticle" ),
							resultSet.getString( "description" ),
							resultSet.getString( "brand" ),
							resultSet.getDouble( "unitary_price" )
					);
				}
			}
		} catch ( Exception exception ) {
			throw new RuntimeException( exception );
		}
	}


	public static void updateArticle( Article article ) {
		try ( Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword ) ){

			String strSql = "UPDATE ARTICLE SET description=?, brand=?, unitary_price=? WHERE idArticle=?";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				statement.setString( 1, article.getDescription() );
				statement.setString( 2, article.getBrand() );
				statement.setDouble( 3, article.getUnitaryPrice() );
				statement.setInt( 4, article.getIdArticle() );
				statement.executeUpdate();
			}
		} catch ( Exception exception ) {
			throw new RuntimeException( exception );
		}
	}
}
