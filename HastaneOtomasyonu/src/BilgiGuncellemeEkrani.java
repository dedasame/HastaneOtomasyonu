import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class BilgiGuncellemeEkrani extends JFrame {
	
	VeriTabani vt = new VeriTabani();
	private JPanel contentPane;
	private JTextField newName;
	private JTextField newSurname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BilgiGuncellemeEkrani frame = new BilgiGuncellemeEkrani(null);
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
	public BilgiGuncellemeEkrani(Hasta hasta) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblname = new JLabel("New label");
		lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblname.setBounds(10, 90, 276, 37);
		contentPane.add(lblname);
		
		JLabel lblsurname = new JLabel("New label");
		lblsurname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblsurname.setBounds(10, 142, 276, 37);
		contentPane.add(lblsurname);
		
		JButton degistirButonu = new JButton("DEĞİŞTİR");
		degistirButonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(lblname.getText().length()==0|| lblsurname.getText().length()==0){	
					JOptionPane.showMessageDialog(null,"Lutfen tum alanlari doldurun!");
				}
				
				else {
					String sql = "UPDATE hasta SET namehasta = ?, surnamehasta = ? WHERE tchasta = "+hasta.getTc();
					Connection c = vt.baglan();
					try {
						Statement st = c.createStatement();
						PreparedStatement ps = c.prepareStatement(sql);
						ps.setString(1, newName.getText());
						ps.setString(2, newSurname.getText());
						ps.executeUpdate();
						
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
				}

			}
		});
		degistirButonu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		degistirButonu.setBounds(75, 289, 170, 54);
		contentPane.add(degistirButonu);
		
		JButton cikisbutonu = new JButton("ÇIKIŞ");
		cikisbutonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				GirisEkrani a = new GirisEkrani();
				a.setVisible(true);
				dispose();
			}
		});
		cikisbutonu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cikisbutonu.setBounds(299, 289, 175, 54);
		contentPane.add(cikisbutonu);
		
		JButton geriButonu = new JButton("GERİ");
		geriButonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HastaEkrani a = new HastaEkrani(hasta);
				a.setVisible(true);
				dispose();		
			}
		});
		geriButonu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		geriButonu.setBounds(10, 10, 147, 37);
		contentPane.add(geriButonu);
		
		newName = new JTextField();
		newName.setBounds(317, 90, 242, 37);
		contentPane.add(newName);
		newName.setColumns(10);
		
		newSurname = new JTextField();
		newSurname.setBounds(317, 142, 242, 37);
		contentPane.add(newSurname);
		newSurname.setColumns(10);
	}
}
