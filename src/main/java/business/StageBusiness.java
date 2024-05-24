package business;

import java.util.List;

import beans.Stage;

public interface StageBusiness {
	public List<Stage>getAllByDate();
	public List<Stage>getAllByType();
	public Stage getById( int code_stage);
}
