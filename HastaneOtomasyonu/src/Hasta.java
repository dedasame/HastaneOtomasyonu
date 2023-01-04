import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JOptionPane;

public class Hasta extends Kullanici{
	
	Connection c = vt.baglan();
	Statement st = null;
	ResultSet rs = null;

	public Hasta(int id, String name, String surname, String tc, String pass) {
		super(id, name, surname, tc, pass);
	}

	public Hasta() {}
	
		//Hastaya bolumlerin listesini gosterir
		public ArrayList<Bolum> getBolumList() throws SQLException{
		
		
		ArrayList<Bolum> list = new ArrayList<>();
		
		Bolum obj;
		try {
			st = c.createStatement();
			rs = st.executeQuery("SELECT * FROM bolumler");
			
			while(rs.next()) {
				obj = new Bolum(rs.getInt("idbolum"),rs.getString("namebolum"));
				list.add(obj);			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

		//Hastaya doktorun listesini gosterir
		public ArrayList<DoktorList> getDoktorList() throws SQLException{			
			ArrayList<DoktorList> list = new ArrayList<>();

			DoktorList obj;
			try {
				st = c.createStatement();
				rs = st.executeQuery("SELECT * FROM doktor");
				
				while(rs.next()) {
					obj = new DoktorList(rs.getInt("iddoktor"),rs.getString("namedoktor"),rs.getString("surnamedoktor"));
					list.add(obj);			
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
		
		
		
		
		
		public boolean  randevuEkle(int idbolum, int iddoktor){
			String query = "INSERT INTO hasta" + "(idbolum,iddoktor) VALUES" + "?,?";
			boolean key = false;
			int count = 0;
			
			try {
				st = c.createStatement();
				
				rs = st.executeQuery("SELECT * FROM WHERE idbolum!="+null+"AND iddoktor!="+null);
				while(rs.next()) {
					count++;
					//ayni anda sadece 1 tane randevu alinabilir
				}
				if(count==0) {
					PreparedStatement ps = c.prepareStatement(query);
					ps.setInt(1,iddoktor);
					ps.setInt(2, idbolum);
					ps.executeUpdate();
					key = true;
				}
				else {
					JOptionPane.showMessageDialog(null,"Birden fazla randevu alamazsiniz!");
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return key;
		}
	
	
	
	
}
