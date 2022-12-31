import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VeriTabani {
	
	static final String DB="jdbc:mysql://localhost:3306/hastaneotomasyonu";
	static final String USER="root";
	static final String PASS="123456";
	
	Connection c = null;
	
	public VeriTabani() {
	}
	
	public Connection baglan() {
		
		try {
			this.c = DriverManager.getConnection(DB,USER,PASS);
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
		
}
		
		//Connection con = DriverManager.getConnection(DB,USER,PASS);
		//Statement st = con.createStatement();
		
		//hasta listesi
		/*
		ResultSet rs = st.executeQuery(" select * from hasta");
		
		while(rs.next()) {
			System.out.println(rs.getString("idhasta")+" "+rs.getString("namehasta")+" "+rs.getString("surnamehasta"));
			
		}
		*/
		
		//Baglandi
		
		
		//tabloya ekleme
		/*
		String name = "";
		String sql = "SELECT * FROM kayit"+" WHERE adi='"+name+"'";
		ResultSet rs = ((java.sql.Statement) st).executeQuery(sql);
		*/
		
		//HastaBilgi Tablosu
		
		/*
		while(rs.next()) {
			System.out.print(" ID : "+rs.getInt("id"));
			System.out.println(" TC : "+rs.getString("soyadi"));	
		}
		*/
	

