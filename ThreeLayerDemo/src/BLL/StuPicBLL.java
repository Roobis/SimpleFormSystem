package BLL;

import DAL.StuPicDAL;
import Model.Picture;

public class StuPicBLL {
	public void addStuPic(Picture p) {
		new StuPicDAL().addPic(p);
	}
}
