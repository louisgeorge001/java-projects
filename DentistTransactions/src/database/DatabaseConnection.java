package database;

import java.sql.DriverManager;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

public class DatabaseConnection {

	private Connection conn;
	private String url;
	private String username;
	private String password;
	
	public DatabaseConnection()
	{
		url = "jdbc:mysql://localhost:3306/dentistmanagement?characterEncoding=UTF-8&useSSL=false";
		//url = "jdbc:mysql://localhost:3306/emp_info?characterEncoding=UTF-8&useSSL=false"
		username = "gates";
		password = "g@tes2009";
	}
	public Connection getConnection()
	{
		try
		{
			conn = (Connection) DriverManager.getConnection(url,username,password);
		}catch(Exception err)
		{
			err.printStackTrace();
			JOptionPane.showMessageDialog(null, "Connection error! Please contact your administrator");
		}
		return conn;
	}

}
