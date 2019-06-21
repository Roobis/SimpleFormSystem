package DAL;

import Model.Picture;
import Model.StuInfo;
import Util.MySqlHelper;

public class StuInfoDAL {
	
	public Boolean checkStu(String name,String id) {
		String sql = "select * from classc where name='"+name+"' and id='"+id+"'";
		Boolean flag=MySqlHelper.executeCheck(sql);
		return flag;
	}
	
	public void addStu(StuInfo s){
		String addsql="insert into classc (name,id,Email) values (?,?,?)";
		MySqlHelper.executeUpdate(addsql, s);
	}
	
	
	
	public void deleteStu(StuInfo s) {
		String name = s.getName();
		String id = s.getId();
		String delesql = "delete from classc where name='"+name+"' or id='"+id+"'";
		MySqlHelper.executeDelete(delesql);
	}
	
	public void reciseNameStu(StuInfo s,String n) {
		String name = s.getName();
		String recisql = "update classc set name='"+name+"' where name='"+n+"'";
		MySqlHelper.executeRevise(recisql);
	}
	public void reciseIDStu(StuInfo s,String i) {
		String id = s.getId();
		String recisql = "update classc set id='"+id+"' where id='"+i+"'";
		MySqlHelper.executeRevise(recisql);
	}
	public void seeNameStu(StuInfo s) {
		String name = s.getName();
		String seesql = "select * from classc where name = '"+name+"'";
		MySqlHelper.executeSeek(seesql);
	}
	public void seeIdStu(StuInfo s) {
		String id = s.getId();
		String seesql = "select * from classc where id = '"+id+"'";
		MySqlHelper.executeSeek(seesql);
	}
}
