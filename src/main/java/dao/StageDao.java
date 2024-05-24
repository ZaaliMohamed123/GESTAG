package dao;

import java.text.ParseException;
import java.util.List;
import beans.Stage;
public interface StageDao {
		public List<Stage>selectAllByDate();
		public List<Stage>selectAllByType();
		public Stage selectById( int code_stage);
}
