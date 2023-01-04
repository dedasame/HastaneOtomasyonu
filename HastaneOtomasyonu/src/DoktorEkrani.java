import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class DoktorEkrani extends JFrame {

	VeriTabani vt = new VeriTabani();
	static Doktor doc = new Doktor();
	private JPanel contentPane;
	private JTable hastaliste;
	private DefaultTableModel hastamodel = null;
	private Object[] hastaData = null;
	private JTextField textField;
	Connection c = vt.baglan();
	Statement st = null;
	ResultSet rs = null;
	
	//Hasta bilgilerine erisim
	public Hasta hasta = new Hasta();
	public int hastaid;
	public String hastaname,hastasurname;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoktorEkrani frame = new DoktorEkrani(doc);
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
	public DoktorEkrani(Doktor doc) throws SQLException {
		
		hastamodel = new DefaultTableModel();
		Object[] satir = new Object[3];
		satir[0] = "ID";
		satir[1] = "Ad";
		satir[2] = "Soyad";
		
		hastamodel.setColumnIdentifiers(satir);
		hastaData = new Object[3];
		
		for(int i=0;i<doc.getHastaList().size();i++) {
			hastaData[0] = doc.getHastaList().get(i).getId();
			hastaData[1] = doc.getHastaList().get(i).getName();
			hastaData[2] = doc.getHastaList().get(i).getSurname();
			hastamodel.addRow(hastaData);
		}
		
		
		setTitle("Doktor Sistemi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 475);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbldoktoradi = new JLabel("DR. " + doc.getName());
		lbldoktoradi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbldoktoradi.setBounds(10, 10, 162, 39);
		contentPane.add(lbldoktoradi);
		
		
		JButton btnNewButton = new JButton("CIKIS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); //bu ekrani kapatti
				//giris ekranini geri acmak icin
				GirisEkrani ge = new GirisEkrani();
				ge.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(448, 395, 128, 29);
		contentPane.add(btnNewButton);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setBounds(10, 59, 566, 326);
		contentPane.add(tabbedPane);
		
		JPanel Hastalar = new JPanel();
		Hastalar.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Hastalar", null, Hastalar, null);
		Hastalar.setLayout(null);
		
		JScrollPane scrollHastalar = new JScrollPane();
		scrollHastalar.setBounds(10, 10, 541, 279);
		Hastalar.add(scrollHastalar);
		
		hastaliste = new JTable(hastamodel);
		scrollHastalar.setViewportView(hastaliste);
		
		
		//Hata var. Girilen kimlikteki hastayi cekemiyor
		
		/*
		JPanel Randevular = new JPanel();
		Randevular.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Hasta Bilgileri", null, Randevular, null);
		Randevular.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hasta T.C.");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(29, 10, 106, 31);
		Randevular.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(174, 10, 212, 31);
		Randevular.add(textField);
		textField.setColumns(10);
		*/
		
		
		JButton btnNewButton_1 = new JButton("GOSTER");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField.getText().length()==11) {

					try {
						st = c.createStatement();
						String query= "SELECT * FROM hasta WHERE tchasta="+textField.getText();
						ResultSet rs = st.executeQuery(query);
						while(rs.next()) {
							hastaid= rs.getInt("idhasta");
							hastaname = rs.getString("namehasta");
							hastasurname = rs.getString("surnamehasta");
							
							if(hastaid!=0) {
								break;
								}
							else {
								
							}
						}
						
						
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				}
				else {	
					JOptionPane.showMessageDialog(null,"Hatali Kimlik Numarasi!");	
				}

			}
		});
		
		/*
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(438, 10, 113, 31);
		Randevular.add(btnNewButton_1);
		
		JLabel lblbilgi1 = new JLabel("Adı:   "+hastaname);
		lblbilgi1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblbilgi1.setBounds(29, 72, 357, 42);
		Randevular.add(lblbilgi1);
		
		JLabel lblbilgi2 = new JLabel("Soyadı: "+hastasurname);
		lblbilgi2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblbilgi2.setBounds(28, 124, 358, 42);
		Randevular.add(lblbilgi2);
		
		JLabel lblid = new JLabel("HastaID: "+hastaid);
		lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblid.setBounds(29, 176, 357, 42);
		Randevular.add(lblid);
		*/
		SimpleDateFormat sekil = new SimpleDateFormat("d/M/y");	
        Date now = new Date();
		JLabel lbltarih = new JLabel(sekil.format(now).toString());
		lbltarih.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbltarih.setBounds(463, 10, 113, 39);
		contentPane.add(lbltarih);

		
	}
}
