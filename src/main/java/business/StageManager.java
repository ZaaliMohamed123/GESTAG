package business;

import java.util.List;

import beans.Stage;
import dao.OracleDataSource;
import dao.StageDao;
import dao.StageDaoImplOrcl;

public class StageManager implements StageBusiness{
	
	private StageDao sd ;
	
	

	public StageManager() {
	}
	
	

	public StageManager(StageDao sd) {
		this.sd = sd;
	}

	

	public StageDao getSd() {
		return sd;
	}



	public void setSd(StageDao sd) {
		this.sd = sd;
	}



	
	public List<Stage> getAllByDate() {
		return sd.selectAllByDate();
	}

	
	public List<Stage> getAllByType() {
		return sd.selectAllByType();
	}

	
	public Stage getById(int code_stage) {
		return sd.selectById(code_stage);
	}

}
