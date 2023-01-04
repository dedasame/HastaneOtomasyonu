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
	
		

