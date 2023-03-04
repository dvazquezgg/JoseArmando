import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class writer_interface extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					writer_interface frame = new writer_interface();
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
	public writer_interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Advance");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				previous_articles_interface object = new previous_articles_interface();
				previous_articles_interface.main(null);
			}
			
		});
		btnNewButton.setBounds(89, 169, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnAdvance = new JButton("Advance");
		btnAdvance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sport_league_team_selector_interface object = new sport_league_team_selector_interface();
				sport_league_team_selector_interface.main(null);
			}
			
		});
		btnAdvance.setBounds(260, 169, 117, 29);
		contentPane.add(btnAdvance);
		
		JLabel lblNewLabel = new JLabel("Welcome Writer!");
		lblNewLabel.setBounds(183, 85, 103, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("I would like to view");
		lblNewLabel_1.setBounds(89, 125, 131, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("my previous articles!");
		lblNewLabel_1_1.setBounds(89, 141, 131, 16);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("I would like to write");
		lblNewLabel_1_2.setBounds(260, 125, 131, 16);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("a new article!");
		lblNewLabel_1_3.setBounds(280, 141, 88, 16);
		contentPane.add(lblNewLabel_1_3);
	}

}
