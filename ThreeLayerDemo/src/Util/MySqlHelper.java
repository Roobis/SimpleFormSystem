package Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import Model.Picture;
import Model.StuInfo;

public class MySqlHelper {
	static String DBDriver="org.gjt.mm.mysql.Driver";
	static String url="jdbc:mysql://localhost:3306/test?characterEncoding=utf-8";
	static String user="root";
	static String password="root";
	
	public static Boolean executeCheck (String sql) {
		boolean flag = false;
		try {
			Class.forName(DBDriver);
			Connection con=DriverManager.getConnection(url, user, password);
			Statement sta=con.createStatement();
			ResultSet rs=sta.executeQuery(sql);
			if(rs.next()){
				JOptionPane.showMessageDialog(null, "欢迎使用");
				flag=true;
			}
			if(flag==false) {
				JOptionPane.showMessageDialog(null, "用户名或密码错误！", "错误！", JOptionPane.ERROR_MESSAGE); 
			}
				con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	public static void executeDelete (String sql) {
		boolean flag = false;
		try {
			Class.forName(DBDriver);
			Connection con=DriverManager.getConnection(url, user, password);
			Statement sta=con.createStatement();
			sta.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "成功删除");
			flag=true;
			if(flag==false) {
				JOptionPane.showMessageDialog(null, "用户名或密码错误！", "错误！", JOptionPane.ERROR_MESSAGE); 
			}
				con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void executeUpdate(String sql,StuInfo s){
		try {
			Class.forName(DBDriver);
			Connection con=DriverManager.getConnection(url, user, password);
			PreparedStatement psta=con.prepareStatement(sql);
			psta.setObject(1, s.getName());
			psta.setObject(2, s.getId());
			psta.setObject(3, s.getEmail());
			
			psta.executeUpdate();
			psta.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void executeRevise(String sql) {
		try {
			Class.forName(DBDriver);
			Connection con=DriverManager.getConnection(url, user, password);
			 Statement sta=con.createStatement();
			 sta.executeUpdate(sql);
			 JOptionPane.showMessageDialog(null, "修改成功");
			 con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void executeSeek(String sql) {
		try {
			Class.forName(DBDriver);
			Connection con=DriverManager.getConnection(url, user, password);
			 PreparedStatement ps = con.prepareStatement(sql);
			 ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				 System.out.println(rs.getString("name")+"\t"+rs.getString("id"));
			}
			 con.close();
			 ps.close();
	          con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static boolean checkEmail(String email) {
		boolean flag = false;
		String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(email);
        if(matcher.matches())
        {
        	flag = true;
        }else {
        	JOptionPane.showMessageDialog(null, "请输入正确的邮箱！");
        }
		return flag;
	}
	
	public static void executeUpdatePic(String sql,Picture p) {
		try {
			Class.forName(DBDriver);
			Connection con=DriverManager.getConnection(url, user, password);
			PreparedStatement psta=con.prepareStatement(sql);
			FileInputStream str = new FileInputStream(p.getPic());
			psta.setObject(1, p.getPicname());
			try {
				psta.setBinaryStream(2, str,str.available());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			psta.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}