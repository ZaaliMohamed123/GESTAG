package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Stagiaire;

public class StagiaireDaoImplOrcl implements StagiaireDao{

		Connection cnx;
		public StagiaireDaoImplOrcl(DataSource ds) {cnx=ds.getConnection();}
	
		public void insert(Stagiaire stagiaire) {
		    try {
		        String query = "INSERT INTO STAGIAIRE VALUES (?, ?, ?,? , TO_DATE(?, 'YYYY/MM/DD'), ?)";
		        PreparedStatement preparedStatement = cnx.prepareStatement(query);
		        
		        // Set values for parameters
		        preparedStatement.setString(1, stagiaire.getNum_stagiaire());
		        preparedStatement.setString(2, stagiaire.getNom());
		        preparedStatement.setString(3, stagiaire.getPrenom());
		        preparedStatement.setString(4, stagiaire.getSexe());
		        preparedStatement.setString(5, stagiaire.getDateNaiss());
		        preparedStatement.setString(6, stagiaire.getDiplome());

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
	

	@Override
	public Stagiaire selectByName(String name,String prenom) {
		String query = "SELECT * FROM STAGIAIRE WHERE NOM_STAGIAIRE = '" + name + "' and PRENOM_STAGIAIRE= '"+prenom+"'";
		Stagiaire stagiaire = null;
	    try {
	        Statement st = cnx.createStatement();
	        ResultSet rs = st.executeQuery(query);
	        if (rs.next()) {
	            // Print the contents of the ResultSet for debugging
	           

	            stagiaire = new Stagiaire(
	                rs.getString(1),
	                rs.getString(2),
	                rs.getString(3),
	                rs.getString(4),
	                rs.getString(5),
	                rs.getString(6)
	            );
	            
	       
	    }st.close();
        rs.close();
        cnx.commit();
       } catch (SQLException e) {
	        System.out.println("Error executing query: " + query);
	        e.printStackTrace();
	    }
	    return stagiaire;
	}

	@Override
	public List<Stagiaire> selectAll() {
		String query = "SELECT * FROM STAGIAIRE ORDER BY CAST(num_stagiaire AS int) ASC";
	    List<Stagiaire> stagiaires =new ArrayList<>();
	    try {
	        Statement st = cnx.createStatement();
	        ResultSet rs = st.executeQuery(query);
	        while (rs.next()) {
	            // Print the contents of the ResultSet for debugging
	           

	            Stagiaire stagiaire = new Stagiaire(
	                rs.getString(1),
	                rs.getString(2),
	                rs.getString(3),
	                rs.getString(4),
	                rs.getString(5),
	                rs.getString(6)
	            );
	           stagiaires.add(stagiaire);
	           
	    }
	        st.close();
            rs.close();
           cnx.commit();
       } catch (SQLException e) {
	        System.out.println("Error executing query: " + query);
	        e.printStackTrace();
	    }
	    return stagiaires;
	}

	public List<Stagiaire> selectStagiaireByCodeStage(String code_stage) {
		String query = "SELECT s.num_stagiaire,s.nom_stagiaire,s.prenom_stagiaire,s.sexe_stagiaire,s.dnaiss_stagiaire,s.diplo_stagiaire FROM STAGIAIRE s JOIN INSCRIPTION ins on ins.num_stagiaire=s.num_stagiaire WHERE ins.code_stage =" + code_stage+" order by cast(s.num_stagiaire AS int ) asc ";
    List<Stagiaire> stagiaires = new ArrayList<>();
	    try {
	        Statement st = cnx.createStatement();
	        ResultSet rs = st.executeQuery(query);
	        while (rs.next()) {
	            // Print the contents of the ResultSet for debugging
	           

	            Stagiaire stagiaire = new Stagiaire(
	                rs.getString(1),
	                rs.getString(2),
	                rs.getString(3),
	                rs.getString(4),
	                rs.getString(5),
	                rs.getString(6)
	            );
	            stagiaires.add(stagiaire);
	            
	       
	    }st.close();
        rs.close();
        cnx.commit();
       } catch (SQLException e) {
	        System.out.println("Error executing query: " + query);
	        e.printStackTrace();
	    }
	    return stagiaires;
	}

	}
