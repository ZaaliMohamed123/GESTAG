package dao;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;


public class OracleDataSource implements DataSource{
	
	private Connection cnx;
	public OracleDataSource() {
		Connect();
	}
	public void Connect() {
		/*
		String url = "jdbc:oracle:thin:@localhost:1521:orcl1"; // JDBC URL for Oracle
        String user = "c##mesos1";
        String password = "mehdi";
        */
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl"; // JDBC URL for Oracle
        String user = "C##SYNTAXERROR";
        String password = "mohamed";
		/*
		String url = "jdbc:oracle:thin:@localhost:1521:orcl"; // JDBC URL for Oracle
        String user = "C##douaa";
        String password = "douaa";*/
        try {
            // Load the Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establish the connection
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to Oracle database.");

           cnx =  connection;
           cnx.setAutoCommit(false);
        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC driver not found.");
            e.printStackTrace();
            
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
           
        }
	}
	public Connection getConnection() {
		return cnx;}
	}
	

