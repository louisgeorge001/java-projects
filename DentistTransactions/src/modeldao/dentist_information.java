package modeldao;

public class dentist_information {
	private int id;
	private String date;
	private String ampaid;
	private String rubbercolor;
	private String patient_uname;
	
	public String getPatient_uname() {
		return patient_uname;
	}
	public void setPatient_uname(String patient_uname) {
		this.patient_uname = patient_uname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAmpaid() {
		return ampaid;
	}
	public void setAmpaid(String ampaid) {
		this.ampaid = ampaid;
	}
	public String getRubbercolor() {
		return rubbercolor;
	}
	public void setRubbercolor(String rubbercolor) {
		this.rubbercolor = rubbercolor;
	}
	
}
