package controllerdao;

import java.sql.ResultSet;

import com.mysql.jdbc.Connection;

import database.DatabaseConnection;
import modeldao.dentist_information;

public class dentist_informationcontroller extends dentist_information {
	DatabaseConnection db;
	java.sql.PreparedStatement ps;
	Connection conn;
	ResultSet rs;
	
	public dentist_informationcontroller()
	{
		super();
		db = new DatabaseConnection();
		conn = db.getConnection();
	}
	public int add_dentist_information(dentist_information d)
	{
		int res = 0;
		try
		{
			String sql = "INSERT INTO dentist_information(date,amountpaid,rubbercolor,patient_uname)VALUES('"+d.getDate()+"','"+d.getAmpaid()+"','"+d.getRubbercolor()+"',"
					+ "'"+d.getPatient_uname()+"')";
			ps = conn.prepareStatement(sql);
			ps.execute();
			res = 1;
		}catch(Exception err)
		{
			err.printStackTrace();
			res = 0;
		}
		return res;
	}
	public boolean retrievedentist_information(dentist_information d)
	{
		try
		{
			String get_information = "SELECT * FROM dentist_information WHERE patient_uname = '"+d.getPatient_uname()+"' ";
			ps = conn.prepareStatement(get_information);
			rs = ps.executeQuery();
			while(rs.next())
			{
				return true;
			}
		}catch(Exception err)
		{
			err.printStackTrace();
		}
		return false;
	}

}
