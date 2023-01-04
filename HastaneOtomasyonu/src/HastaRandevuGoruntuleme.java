import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class HastaRandevuGoruntuleme extends JFrame {
	VeriTabani vt = new VeriTabani();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HastaRandevuGoruntuleme frame = new HastaRandevuGoruntuleme(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	
	
	
	
	public HastaRandevuGoruntuleme(Hasta hasta) throws SQLException {
		
		String query = "SELECT * FROM hasta WHERE tchasta="+hasta.getTc();
		Connection c = vt.baglan();
		Statement st = c.createStatement();
		ResultSet rs = st.executeQuery(query);
		if(rs.next()==true) {
			
		}
		int bolumid = rs.getInt("bolumid");
		int doktorid = rs.getInt("doktorid");
		
		String query1 = "SELECT * FROM bolumler WHERE idbolum="+bolumid;
		ResultSet rs1 = st.executeQuery(query1);
		String bolum = rs1.getString("nameBolum");
		if(rs1.next()==true) {
			
		}
		String query2 = "SELECT * FROM doktor WHERE iddoktor="+doktorid;
		ResultSet rs2 = st.executeQuery(query2);
		String doktor = rs2.getString("namedoktor");
		if(rs2.next()==true) {
			
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bölüm: "+bolum);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 44, 390, 62);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Doktor: "+doktor);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 129, 390, 62);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("GERİ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HastaEkrani a = new HastaEkrani(hasta);
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(10, 269, 180, 62);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ÇIKIŞ");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GirisEkrani a = new GirisEkrani();
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(315, 269, 180, 62);
		contentPane.add(btnNewButton_1);
	}

}
