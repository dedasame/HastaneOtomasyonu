
public class Bolum {
	
	VeriTabani vt = new VeriTabani();
	
	private int idbolum;
	private String namebolum;

	public Bolum(int idbolum, String namebolum) {
		this.idbolum = idbolum;
		this.namebolum = namebolum;
		
	}
	public int getIdbolum() {
		return idbolum;
	}
	public void setIdbolum(int idbolum) {
		this.idbolum = idbolum;
	}
	public String getNamebolum() {
		return namebolum;
	}
	public void setNamebolum(String namebolum) {
		this.namebolum = namebolum;
	}

	
}
