import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class GirisEkrani extends JFrame{

	private JPanel contentPane;
	private JTextField tchasta;
	private JPasswordField passhasta;
	private JTextField tcdoktor;
	private JPasswordField passdoktor;
	private VeriTabani vt = new VeriTabani();

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GirisEkrani frame = new GirisEkrani();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GirisEkrani() {
		setResizable(false);
		setTitle("Hastane Otomasyonu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 475);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HASTANE OTOMASYONU");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(150, 10, 285, 60);
		contentPane.add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setBounds(10, 91, 576, 337);
		contentPane.add(tabbedPane);
		
		JPanel panelhasta = new JPanel();
		panelhasta.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("HASTA GIRIS", null, panelhasta, null);
		panelhasta.setLayout(null);
		
		JLabel lbltc = new JLabel("T.C. ");
		lbltc.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lbltc.setBounds(124, 46, 65, 37);
		panelhasta.add(lbltc);
		
		JLabel lblsifre = new JLabel("SIFRE");
		lblsifre.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblsifre.setBounds(100, 107, 89, 37);
		panelhasta.add(lblsifre);
		
		tchasta = new JTextField();
		tchasta.setFont(new Font("Tahoma", Font.PLAIN, 30));
		tchasta.setBounds(271, 46, 226, 37);
		panelhasta.add(tchasta);
		tchasta.setColumns(10);
		
		passhasta = new JPasswordField();
		passhasta.setFont(new Font("Tahoma", Font.PLAIN, 30));
		passhasta.setBounds(271, 107, 226, 37);
		panelhasta.add(passhasta);
		
		JButton btngiris = new JButton("GIRIS");
		btngiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tchasta.getText().length()==0 || passhasta.getText().length()==0) {
					JOptionPane.showMessageDialog(null,"Lutfen tum alanlari doldurun!");
					
				}
				else {
					
					
					
				}
		
			}
		});
		btngiris.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btngiris.setBounds(298, 200, 199, 75);
		panelhasta.add(btngiris);
		
		JButton btnkayitol = new JButton("KAYIT OL");
		btnkayitol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tchasta.getText().length()==0 || passhasta.getText().length()==0) {
					JOptionPane.showMessageDialog(null,"Lutfen tum alanlari doldurun!");
				}
				else {
					
					
					
				}
				
				
			}
		});
		btnkayitol.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnkayitol.setBounds(43, 200, 199, 75);
		panelhasta.add(btnkayitol);
		
		JPanel paneldoktor = new JPanel();
		paneldoktor.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("DOKTOR GIRIS", null, paneldoktor, null);
		paneldoktor.setLayout(null);
		
		JLabel lblsifre2 = new JLabel("SIFRE");
		lblsifre2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblsifre2.setBounds(87, 101, 89, 37);
		paneldoktor.add(lblsifre2);
		
		JLabel lbltc2 = new JLabel("T.C. ");
		lbltc2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lbltc2.setBounds(111, 40, 65, 37);
		paneldoktor.add(lbltc2);
		
		tcdoktor = new JTextField();
		tcdoktor.setFont(new Font("Tahoma", Font.PLAIN, 30));
		tcdoktor.setColumns(10);
		tcdoktor.setBounds(258, 40, 226, 37);
		paneldoktor.add(tcdoktor);
		
		passdoktor = new JPasswordField();
		passdoktor.setFont(new Font("Tahoma", Font.PLAIN, 30));
		passdoktor.setBounds(258, 101, 226, 37);
		paneldoktor.add(passdoktor);
		
		
		JButton btngiris2 = new JButton("GIRIS");
		btngiris2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Tc ve sifrenin tam girilmesi icin
				if(tcdoktor.getText().length()==0 || passdoktor.getText().length()==0) {
					JOptionPane.showMessageDialog(null,"Lutfen tum alanlari doldurun!");
				}
				else {
					
					//veritabanina baglaniyor
					try {
						Connection baglanti = vt.baglan();
						Statement st = baglanti.createStatement();
						ResultSet rs = st.executeQuery("SELECT * FROM doktor");
						
						 while(rs.next()) {
							 //bilgilerin veritabaniyla dogrulugu kontrol ediliyor
							 if(tcdoktor.getText().equals(rs.getString("tcdoktor"))&&passdoktor.getText().equals(rs.getString("passdoktor"))){
								
								 Doktor doc = new Doktor();
								 doc.setId(rs.getInt("iddoktor"));
								 doc.setTc(rs.getString("tcdoktor"));
								 doc.setPass(rs.getString("passdoktor"));
								 doc.setName(rs.getString("namedoktor"));
								 doc.setSurname(rs.getString("surnamedoktor"));
								 //giris basarili
								 
								 //doktor ekranini ac
								 DoktorEkrani de = new DoktorEkrani(doc);
								 de.setVisible(true);
								 
								 //giris ekranini kapat
								 dispose();	
								 
							 }
							 else {
								 JOptionPane.showMessageDialog(null,"T.C. ya da Sifre Hatali!");
							 } 
						 }
							
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
	
		btngiris2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btngiris2.setBounds(147, 194, 199, 75);
		paneldoktor.add(btngiris2);
	}
}
