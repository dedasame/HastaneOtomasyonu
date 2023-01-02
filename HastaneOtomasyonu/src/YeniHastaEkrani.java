import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class YeniHastaEkrani extends JFrame {

	private JPanel contentPane;
	private JTextField hastaisim;
	private JTextField hastasoyisim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YeniHastaEkrani frame = new YeniHastaEkrani();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	//Yapilacaklar 
	//hastadan gerekli olan isim ve soyisim alinacak
	//hastaekranina aktaracak
	
	
	
	/**
	 * Create the frame.
	 */
	public YeniHastaEkrani() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hoşgeldiniz!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 10, 115, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("İlk girşiniz olduğundan lütfen adınızı girin!");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(123, 10, 410, 39);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Adınız: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(10, 108, 98, 39);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Soyadınız:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(10, 157, 98, 39);
		contentPane.add(lblNewLabel_3);
		
		hastaisim = new JTextField();
		hastaisim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		hastaisim.setBounds(137, 108, 223, 39);
		contentPane.add(hastaisim);
		hastaisim.setColumns(10);
		
		hastasoyisim = new JTextField();
		hastasoyisim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		hastasoyisim.setBounds(137, 157, 223, 39);
		contentPane.add(hastasoyisim);
		hastasoyisim.setColumns(10);
		
		JButton btnNewButton = new JButton("Onayla");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//bos olup olmadigi kontrol edilecek 
				//veri tabanina gonderilecek
				
				
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(95, 226, 115, 39);
		contentPane.add(btnNewButton);
	}
}
