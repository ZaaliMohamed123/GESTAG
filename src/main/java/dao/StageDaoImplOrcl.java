package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;
import java.util.Date;



import beans.Stage;

public class StageDaoImplOrcl implements StageDao {
	Connection cnx ;
	public StageDaoImplOrcl(DataSource ds) {
		
			cnx=ds.getConnection();
		
	}
	
	public List<Stage> selectAllByDate() {
        String query ="select * from STAGE order by DEBUT_STAGE asc ";
        List<Stage> stages = new ArrayList<>();

        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);

            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yy");

            while(rs.next()) {
                String debutStageStr = rs.getString(3); // Assuming rs.getString(3) is the debut_stage date string
                String finStageStr = rs.getString(4);   // Assuming rs.getString(4) is the fin_stage date string

                Date debutStage = inputFormat.parse(debutStageStr);
                Date finStage = inputFormat.parse(finStageStr);

                String debutStageFormatted = outputFormat.format(debutStage);
                String finStageFormatted = outputFormat.format(finStage);

                Stage stage = new Stage(
                        rs.getString(1),
                        rs.getString(2),
                        debutStageFormatted,
                        finStageFormatted,
                        rs.getInt(5),
                        rs.getInt(6)
                );
                stages.add(stage);
            }

            st.close();
            rs.close();
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return stages;
    

	
	
	}

	public List<Stage> selectAllByType() {
        String query = "select * from STAGE order by TYPE_STAGE asc ";
        List<Stage> stages = new ArrayList<>();

        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);

            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yy");

            while (rs.next()) {
                String debutStageStr = rs.getString(3); // Assuming rs.getString(3) is the debut_stage date string
                String finStageStr = rs.getString(4);   // Assuming rs.getString(4) is the fin_stage date string

                Date debutStage = inputFormat.parse(debutStageStr);
                Date finStage = inputFormat.parse(finStageStr);

                String debutStageFormatted = outputFormat.format(debutStage);
                String finStageFormatted = outputFormat.format(finStage);

                Stage stage = new Stage(
                        rs.getString(1),
                        rs.getString(2),
                        debutStageFormatted,
                        finStageFormatted,
                        rs.getInt(5),
                        rs.getInt(6)
                );
                stages.add(stage);
            }

            st.close();
            rs.close();

        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return stages;
    }
	

	public Stage selectById(int code_stage){
	    String query = "SELECT * FROM STAGE WHERE CODE_STAGE =" + code_stage;
	    Stage stage = null;
	    try {
	        Statement st = cnx.createStatement();
	        ResultSet rs = st.executeQuery(query);
	        
	        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yy");
            
            
	        if (rs.next()) {
	            // Print the contents of the ResultSet for debugging
	        	
	        	String debutStageStr = rs.getString(3); // Assuming rs.getString(3) is the debut_stage date string
                String finStageStr = rs.getString(4);   // Assuming rs.getString(4) is the fin_stage date string

                Date debutStage = inputFormat.parse(debutStageStr);
                Date finStage = inputFormat.parse(finStageStr);

                String debutStageFormatted = outputFormat.format(debutStage);
                String finStageFormatted = outputFormat.format(finStage);
	           

                stage = new Stage(
                        rs.getString(1),
                        rs.getString(2),
                        debutStageFormatted,
                        finStageFormatted,
                        rs.getInt(5),
                        rs.getInt(6)
                );
	            st.close();
	            rs.close();
	            System.out.println("Stage object created: " + stage);
	        } else {
	            System.out.println("No rows found for CODE_STAGE: " + code_stage);
	        }
	    } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
	    return stage;
	}


}
