
public class Kullanici {
	
	private int id;
	private String name,surname,tc,pass;
	VeriTabani vt = new VeriTabani();
	
	
	public Kullanici(int id, String name, String surname, String tc, String pass) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.tc = tc;
		this.pass = pass;
	}
	
	public Kullanici() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getTc() {
		return tc;
	}
	public void setTc(String tc) {
		this.tc = tc;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
