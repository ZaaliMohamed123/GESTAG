package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Inscription;
import beans.Stagiaire;

public class InscriptionDaoImplOrcl implements InscriptionDao {
	Connection cnx;
	
	public InscriptionDaoImplOrcl(DataSource ds) {
		
		this.cnx = ds.getConnection();
	}

	
	//updated method 
	
	public void insertInscription(Inscription inscription) {
        // Handle SQLException
		try {
			// the '0' is  a dummy value that will be updated in the db automatically ,
			String query = "INSERT INTO INSCRIPTION VALUES (?, ? , SYSDATE,?, '0')";
			PreparedStatement preparedStatement = cnx.prepareStatement(query);
			
			// Set values for parameters
			preparedStatement.setString(1, inscription.getCode_stage());
			preparedStatement.setString(2, inscription.getNum_stagiaire());
			//preparedStatement.setString(3, inscription.getDate_inscription());
			preparedStatement.setString(3, inscription.getStatus_insc());       
			
			// Execute the PreparedStatement
			preparedStatement.executeUpdate();
			
			// Commit the transaction
			cnx.commit();
			
			// Close the PreparedStatement (optional, as it will be closed automatically when the method ends)
			preparedStatement.close();
		} catch (SQLException e) {
		        e.printStackTrace();
		    }

}
	
	
	/*
	//old method
	@Override
	public void insertInscription(Inscription inscription) {
		 try {
		        String query = "INSERT INTO INSCRPITION VALUES (?, ? , TO_DATE(?, 'YYYY/MM/DD'),?, ?)";
		        PreparedStatement preparedStatement = cnx.prepareStatement(query);
		        
		        // Set values for parameters
		        preparedStatement.setString(1, inscription.getCode_stage());
		        preparedStatement.setString(2, inscription.getNum_stagiaire());
		        preparedStatement.setString(3, inscription.getDate_inscription());
		        preparedStatement.setString(4, inscription.getStatus_insc());
		        preparedStatement.setString(5, inscription.getCode_position());
		        
		        // Execute the PreparedStatement
		        preparedStatement.executeUpdate();

		        // Commit the transaction
		        cnx.commit();
		        
		        // Close the PreparedStatement (optional, as it will be closed automatically when the method ends)
		        preparedStatement.close();
		    } catch (SQLException e) {
		        // Handle SQLException
		        e.printStackTrace();
		    }
		
	}
	*/

	@Override
	public List<Inscription> selectInscriptionByCode(String codeInscription) {
		String query = "SELECT * FROM INSCRIPTION WHERE CODE_STAGE="+codeInscription;
	    List<Inscription> inscriptions=new ArrayList<>();
	    try {
	        Statement st = cnx.createStatement();
	        ResultSet rs = st.executeQuery(query);
	        while (rs.next()) {
	            // Print the contents of the ResultSet for debugging
	           

	            Inscription inscription = new Inscription(
	                rs.getString(1),
	                rs.getString(2),
	                rs.getString(3),
	                rs.getString(4),
	                rs.getString(5)
	            );
	           inscriptions.add(inscription);
	           
	    }
	        st.close();
            rs.close();
           cnx.commit();
       } catch (SQLException e) {
	        System.out.println("Error executing query: " + query);
	        e.printStackTrace();
	    }
	    return inscriptions;
	
	}
	/*
	public void updateInscription(Inscription inscription) {
	    try {
	        // Check if the inscription exists before updating
	        if (!inscriptionExists(inscription.getCode_stage(), inscription.getNum_stagiaire())) {
	            System.out.println("No inscription found for the given CODE_STAGE and NUM_STAGIAIRE.");
	            return;
	        }

	        // Construct the SQL update query with parameters embedded directly in the string
	        String query = "UPDATE INSCRIPTION SET DATE_INSCRIP = TO_DATE('" + inscription.getDate_inscription() + "', 'YYYY-MM-DD'), STATUT_INSCRIP = '" + inscription.getStatus_insc() + "' WHERE CODE_STAGE = '" + inscription.getCode_stage() + "' AND NUM_STAGIAIRE = '" + inscription.getNum_stagiaire() + "'";

	        // Create a Statement object for executing the SQL update query
	        Statement statement = cnx.createStatement();

	        // Print the SQL update query and parameter values for debugging
	        System.out.println("Executing SQL query: " + query);

	        // Execute the update operation
	        int rowsAffected = statement.executeUpdate(query);

	        // Check if any rows were updated
	        if (rowsAffected > 0) {
	            System.out.println("Inscription updated successfully.");
	        } else {
	            System.out.println("No inscription found for the given criteria.");
	        }

	        // Commit the transaction (assuming autocommit is off)
	        cnx.commit();
	    } catch (SQLException e) {
	        // Handle SQL exceptions
	        e.printStackTrace();
	        try {
	            // Rollback the transaction if an error occurs
	            cnx.rollback();
	        } catch (SQLException ex) {
	            System.err.println("Error occurred while rolling back transaction: " + ex.getMessage());
	        }
	    }
	}


	private boolean inscriptionExists(String codeStage, String numStagiaire) throws SQLException {
	    boolean exists = false;
	    Statement statement = null;
	    ResultSet resultSet = null;

	    try {
	        // Construct the SQL query with parameters embedded directly in the string
	        String query = "SELECT 1 FROM INSCRIPTION WHERE CODE_STAGE = '" + codeStage + "' AND NUM_STAGIAIRE = '" + numStagiaire + "'";

	        // Create a Statement object for executing the SQL query
	        statement = cnx.createStatement();

	        // Execute the query and obtain a ResultSet
	        resultSet = statement.executeQuery(query);

	        // Check if the ResultSet contains any rows
	        exists = resultSet.next();
	    } finally {
	        // Close the ResultSet and Statement in a finally block to ensure resources are released
	        if (resultSet != null) {
	            resultSet.close();
	        }
	        if (statement != null) {
	            statement.close();
	        }
	    }
	    System.out.println(exists);
	    return exists;
	}

	 */
	 
	public void updateInscription(Inscription inscription) {
	    try {
	        // Check if the inscription exists before updating
	        if (!inscriptionExists(inscription.getCode_stage(), inscription.getNum_stagiaire())) {
	            System.out.println("No inscription found for the given CODE_STAGE and NUM_STAGIAIRE.");
	            return;
	        }

	        // Construct the SQL update query with parameters embedded directly in the string
	        String query = "UPDATE INSCRIPTION SET date_inscrip = SYSDATE, STATUT_INSCRIP = '" + inscription.getStatus_insc() + "' WHERE CODE_STAGE = '" + inscription.getCode_stage() + "' AND NUM_STAGIAIRE = '" + inscription.getNum_stagiaire() + "'";

	        // Create a Statement object for executing the SQL update query
	        Statement statement = cnx.createStatement();

	        // Print the SQL update query and parameter values for debugging
	        System.out.println("Executing SQL query: " + query);

	        // Execute the update operation
	        int rowsAffected = statement.executeUpdate(query);

	        // Check if any rows were updated
	        if (rowsAffected > 0) {
	            System.out.println("Inscription updated successfully.");
	        } else {
	            System.out.println("No inscription found for the given criteria.");
	        }

	        // Commit the transaction (assuming autocommit is off)
	        cnx.commit();
	    } catch (SQLException e) {
	        // Handle SQL exceptions
	        e.printStackTrace();
	        try {
	            // Rollback the transaction if an error occurs
	            cnx.rollback();
	        } catch (SQLException ex) {
	            System.err.println("Error occurred while rolling back transaction: " + ex.getMessage());
	        }
	    }
	}


	private boolean inscriptionExists(String codeStage, String numStagiaire) throws SQLException {
	    boolean exists = false;
	    Statement statement = null;
	    ResultSet resultSet = null;

	    try {
	        // Construct the SQL query with parameters embedded directly in the string
	        String query = "SELECT 1 FROM INSCRIPTION WHERE CODE_STAGE = '" + codeStage + "' AND NUM_STAGIAIRE = '" + numStagiaire + "'";

	        // Create a Statement object for executing the SQL query
	        statement = cnx.createStatement();

	        // Execute the query and obtain a ResultSet
	        resultSet = statement.executeQuery(query);

	        // Check if the ResultSet contains any rows
	        exists = resultSet.next();
	    } finally {
	        // Close the ResultSet and Statement in a finally block to ensure resources are released
	        if (resultSet != null) {
	            resultSet.close();
	        }
	        if (statement != null) {
	            statement.close();
	        }
	    }
	    System.out.println(exists);
	    return exists;
	}
	
	public void deleteInscription(String codeStage, String numStagiaire) {
	    try {
	        // Construct the SQL query for deleting an inscription based on CODE_STAGE and NUM_STAGIAIRE
	        String query = "DELETE FROM INSCRIPTION WHERE CODE_STAGE = '" + codeStage + "' AND NUM_STAGIAIRE = '" + numStagiaire + "'";

	        // Create a Statement object for executing the SQL query
	        Statement statement = cnx.createStatement();

	        // Print the SQL query for debugging
	        System.out.println("Executing SQL query: " + query);

	        // Execute the delete operation
	        int rowsAffected = statement.executeUpdate(query);

	        // Check if any rows were deleted
	        if (rowsAffected > 0) {
	            System.out.println("Inscription deleted successfully.");
	        } else {
	            System.out.println("No inscription found for the given criteria.");
	        }

	        // Commit the transaction (assuming autocommit is off)
	        cnx.commit();

	        // Close the Statement
	        statement.close();
	    } catch (SQLException e) {
	        // Handle SQL exceptions
	        e.printStackTrace();
	    }
	}

	 
	 

	


}
