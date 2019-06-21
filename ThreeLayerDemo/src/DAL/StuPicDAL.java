package DAL;

import Model.Picture;
import Util.MySqlHelper;

public class StuPicDAL {
	public void addPic(Picture p) {
		String sql="insert into Photo (picname,pic) values (?,?)";
		MySqlHelper.executeUpdatePic(sql,p);
	}
}
