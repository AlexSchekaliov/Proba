package fishAppDBUtilit_demo_1_Models;


import java.util.ArrayList;

import fishAppSql.DBOperation;

public class CheckDBFrameModel {
	
	public ArrayList<String> getListDB(){
		
		return new DBOperation().getListDBOnServer();
	}

}
