import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Doktor extends Kullanici{
	
	Connection c = vt.baglan();
	Statement st = null;
	ResultSet rs = null;
	
	public Doktor(int id, String name, String surname, String tc, String pass) {
		super(id, name, surname, tc, pass);
	}
	
	public Doktor() {}		
	
	//Hastalarin listesi
	public ArrayList<Kullanici> getHastaList(Doktor doc) throws SQLException{
		
		
		ArrayList<Kullanici> list = new ArrayList<>();
		
		Kullanici obj;
		try {
			st = c.createStatement();      //WHERE doktorid = 1
			rs = st.executeQuery("SELECT * FROM hasta WHERE doktorid ="+doc.getId());
			
			while(rs.next()) {
				obj = new Kullanici(rs.getInt("idhasta"),rs.getString("namehasta"),
						rs.getString("surnamehasta"),rs.getString("tchasta"),rs.getString("passhasta")
						
						);
				
				list.add(obj);			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
	
}
