import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RandevuAlmaEkrani extends JFrame {
	
	
	
	static Hasta hasta = new Hasta();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RandevuAlmaEkrani frame = new RandevuAlmaEkrani(null);
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
	public RandevuAlmaEkrani(Hasta hasta) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(hasta.getName()+" "+hasta.getSurname());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 10, 323, 36);
		contentPane.add(lblNewLabel);
		
		
		SimpleDateFormat sekil = new SimpleDateFormat("d/M/y");	
        Date now = new Date();
		JLabel lblNewLabel_1 = new JLabel(sekil.format(now).toString());
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(473, 10, 103, 36);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("ÇIKIŞ");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(426, 392, 150, 36);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("GERİ");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(10, 392, 169, 36);
		contentPane.add(btnNewButton_1);
		
		JComboBox bolumler = new JComboBox();
		bolumler.setBounds(10, 123, 214, 36);
		for(int i =0 ; i<3;i++) {
			bolumler.addItem(hasta.getBolumList().get(i).getNamebolum());
		}
		contentPane.add(bolumler);
		
		JComboBox doktorlar = new JComboBox();
		doktorlar.setBounds(10, 228, 214, 36);
		for(int i =0 ; i<3;i++) {
			doktorlar.addItem(hasta.getDoktorList().get(i).getName()+" "+hasta.getDoktorList().get(i).getSurname());
		}
		contentPane.add(doktorlar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(348, 228, 84, 36);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(459, 228, 84, 36);
		contentPane.add(comboBox_1);
		
		JButton btnNewButton_2 = new JButton("Randevu Al");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//secilen verilerden randevu verileck	
				int indexbolum = bolumler.getSelectedIndex(); //bolum index 0'dan basliyor!!
				int indexdoktor = doktorlar.getSelectedIndex(); //doktor index
				
				if(indexbolum>=0 && indexdoktor>=0) {
				
					
					
				}
				
				else {
					JOptionPane.showMessageDialog(null,"Lutfen tum alanlari doldurun!");	
				}		
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBounds(211, 328, 190, 45);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("Bolum Seciniz");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(10, 78, 135, 36);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Doktor Seçiniz");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(10, 182, 135, 36);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Saat Seçiniz");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(338, 181, 124, 38);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Tarih Seçiniz");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(338, 78, 124, 36);
		contentPane.add(lblNewLabel_5);
	}
}
