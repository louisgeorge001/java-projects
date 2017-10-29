package controllerdao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

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
	public void showoptionpane(String op_message)
	{
		JOptionPane.showMessageDialog(null, op_message);
	}
	public int createUserAccount(user u)
	{
		int res = 0;
		String sql = "";
		try
		{
			String searchforaccount = "SELECT uname,pword FROM tbl_users WHERE uname='"+u.getUname()+"' AND pword = '"+u.getPword()+"' ";
			ps = conn.prepareStatement(searchforaccount);
			rs = ps.executeQuery();
			if(rs.next())
			{
				showoptionpane("User Exists!");
			}
			else
			{
				String searhforxisting = "SELECT user_id,uname,pword FROM tbl_users ORDER BY user_id DESC LIMIT 1 ";
				ps = conn.prepareStatement(searhforxisting);
				rs = ps.executeQuery();
				if(rs.next())
				{
					String userid = rs.getString("user_id");
					
					String finaluserid = autoincremID(userid,"USER");
					sql = "INSERT INTO tbl_users(user_id,uname,pword)VALUES(?,?,?)";
					ps = conn.prepareStatement(sql);
					ps.setString(1, finaluserid);
					ps.setString(2, u.getUname());
					ps.setString(3, u.getPword());
					ps.execute();
					res = 1;
					
				}
				else
				{
					sql = "INSERT INTO tbl_users(user_id,uname,pword)VALUES(?,?,?)";
					ps = conn.prepareStatement(sql);
					ps.setString(1, generateID("USER"));
					ps.setString(2, u.getUname());
					ps.setString(3, u.getPword());
					ps.execute();
					res = 1;
					
					
				}
				
			}
			
			
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
			sql = "SELECT uname,pword FROM tbl_users WHERE uname = '"+u.getUname()+"' AND pword = '"+u.getPword()+"' ";
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
	public String generateID(String id_type)
	{
		String maxid = "";
		String fullid = id_type+"-00000000";
		return fullid;
	}
	public String autoincremID(String columnname,String idype)
	{
		String word = "";
		String word2 = "";
		int loop = 0;		
		while(!(columnname.charAt(loop)+"").equals("-"))
		{
			word+=columnname.charAt(loop);
			loop++;
		}
		loop++;
		word2 = columnname.substring(loop,columnname.length());//0000000
		String str = word2;
		int convertword2 = Integer.parseInt(str);
		convertword2++;
		String convertwordletter = Integer.toString(convertword2);
		String formatted = idype+"-"+("00000000" + convertwordletter).substring(convertwordletter.length());
		return formatted;
	}

}
