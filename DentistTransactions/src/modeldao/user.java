package modeldao;

public class user {
	private int id;
	private String uname;
	private String pword;
	private String user_id;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPword() {
		return pword;
	}
	public void setPword(String pword) {
		this.pword = pword;
	}
	
//	public user(int id,String username,String password)
//	{
//		this.id = id;
//		this.username=username;
//		this.password=password;
//	}

	
}
