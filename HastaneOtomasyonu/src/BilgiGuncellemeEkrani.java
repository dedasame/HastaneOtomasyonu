import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class BilgiGuncellemeEkrani extends JFrame {

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
		degistirButonu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		degistirButonu.setBounds(75, 289, 170, 54);
		contentPane.add(degistirButonu);
		
		JButton cikisbutonu = new JButton("ÇIKIŞ");
		cikisbutonu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cikisbutonu.setBounds(299, 289, 175, 54);
		contentPane.add(cikisbutonu);
		
		JButton geriButonu = new JButton("New button");
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
