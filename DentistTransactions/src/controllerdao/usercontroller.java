package controllerdao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import database.DatabaseConnection;
import modeldao.user;

public class usercontroller extends user{
	DatabaseConnection db;
	java.sql.PreparedStatement ps;
	Connection conn;
	ResultSet rs;
	public usercontroller() {
		super();
		// TODO Auto-generated constructor stub
		db = new DatabaseConnection();
		conn = db.getConnection();
	}
	
	public int createUserAccount(user u)
	{
		int res = 0;
		String sql = "";
		try
		{
			sql = "INSERT INTO tbl_users(username,password)VALUES(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.execute();
			res = 1;
			
		}catch(Exception err)
		{
			err.printStackTrace();
			res = 0;
		}
		return res;
	}
	public boolean checkLogin(user u)
	{
		String sql = "";
		try
		{
			sql = "SELECT username,password FROM tbl_users WHERE username = '"+u.getUsername()+"' AND password = '"+u.getPassword()+"' ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next())
			{
				return true;
			}
			else
			{
				return false;	
			}
		
		}catch(Exception err)
		{
			err.printStackTrace();
		}
		return false;
	}

}
