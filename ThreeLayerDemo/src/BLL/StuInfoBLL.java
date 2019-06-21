package BLL;

import DAL.StuInfoDAL;
import Model.StuInfo;

public class StuInfoBLL {
	public void addStu(StuInfo s){		
			new StuInfoDAL().addStu(s);
	}
	public void deleteStu(StuInfo s) {
		new StuInfoDAL().deleteStu(s);
	}
	public void reciseNameStu(StuInfo s, String n) {
		new StuInfoDAL().reciseNameStu(s,n);
	}
	public void reciseIdStu(StuInfo s, String i) {
		new StuInfoDAL().reciseIDStu(s,i);
	}
	public void seenameStu(StuInfo s) {
		new StuInfoDAL().seeNameStu(s);
	}
	public void seeidStu(StuInfo s) {
		new StuInfoDAL().seeIdStu(s);
	}
	
}
