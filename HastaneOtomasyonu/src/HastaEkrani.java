import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;

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
					HastaEkrani frame = new HastaEkrani();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//Randevu alma ve silme islemleri yapilacak??
	
	
	
	/**
	 * Create the frame.
	 */
	public HastaEkrani() {
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
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(188, 116, 209, 46);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ÇIKIŞ");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(408, 369, 168, 46);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Bilgilerimi Güncelle");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setBounds(188, 196, 209, 46);
		contentPane.add(btnNewButton_2);
	}
}


