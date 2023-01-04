import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class HastaEkrani extends JFrame {
	
	static Hasta hasta = new Hasta();
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HastaEkrani frame = new HastaEkrani(null);
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
	public HastaEkrani(Hasta hasta) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Merhaba " + hasta.getName()+" "+hasta.getSurname());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 10, 400, 36);
		contentPane.add(lblNewLabel);
		
		
		SimpleDateFormat sekil = new SimpleDateFormat("d/M/y");	
        Date now = new Date();
		JLabel lblNewLabel_1 = new JLabel(sekil.format(now).toString());
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(473, 10, 103, 36);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Randevu Al");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					RandevuAlmaEkrani rae = new RandevuAlmaEkrani(hasta);
					rae.setVisible(true);
					dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} 
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(188, 116, 209, 46);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ÇIKIŞ");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(408, 369, 168, 46);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Bilgilerimi Güncelle");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BilgiGuncellemeEkrani bge = new BilgiGuncellemeEkrani(hasta);
				bge.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setBounds(188, 196, 209, 46);
		contentPane.add(btnNewButton_2);
		
		/*
		JButton btnNewButton_3 = new JButton("Randevularım");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				HastaRandevuGoruntuleme a;
				try {
					a = new HastaRandevuGoruntuleme(hasta);
					a.setVisible(true);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_3.setBounds(188, 271, 209, 46);
		contentPane.add(btnNewButton_3);
		
		
		*/
		
		
	}
}


