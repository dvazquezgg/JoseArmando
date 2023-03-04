import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class register_and_login_interface extends JFrame {

	private JPanel contentPane;
	private JTextField textField_3;
	private JTextField textField_1;
	private JTextField textField_4;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register_and_login_interface frame = new register_and_login_interface();
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
	public register_and_login_interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton writer_registration = new JButton("Register");
		writer_registration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register_interface object = new register_interface();
				register_interface.main(null);
			}
		});
		writer_registration.setBounds(24, 139, 101, 23);
		contentPane.add(writer_registration);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submission_list_interface object = new submission_list_interface();
				submission_list_interface.main(null);
			}
		});
		btnNewButton_1.setBounds(143, 463, 95, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Login");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writer_interface object = new writer_interface();
				writer_interface.main(null);
			}
		});
		btnNewButton_1_1.setBounds(313, 458, 96, 32);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Login");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sport_selector_reader object = new sport_selector_reader();
				sport_selector_reader.main(null);
			}
		});
		btnNewButton_1_1_1.setBounds(495, 458, 95, 31);
		contentPane.add(btnNewButton_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(495, 271, 95, 31);
		contentPane.add(textField_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(313, 271, 101, 31);
		contentPane.add(textField_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(143, 271, 95, 31);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel = new JLabel("column that has been filled in, or register!");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel.setBounds(196, 104, 308, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblEmailAddress = new JLabel("E-Mail Address");
		lblEmailAddress.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblEmailAddress.setBounds(6, 276, 119, 16);
		contentPane.add(lblEmailAddress);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(24, 369, 90, 16);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Writer Registration?");
		lblNewLabel_1_2.setBounds(16, 86, 122, 26);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblAdministrator = new JLabel("Administrator");
		lblAdministrator.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblAdministrator.setBounds(130, 197, 95, 16);
		contentPane.add(lblAdministrator);
		
		JLabel lblWriter = new JLabel("Writer");
		lblWriter.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblWriter.setBounds(341, 197, 48, 16);
		contentPane.add(lblWriter);
		
		JLabel lblReader = new JLabel("Reader");
		lblReader.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblReader.setBounds(516, 197, 61, 16);
		contentPane.add(lblReader);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("CLICK HERE!");
		lblNewLabel_1_2_1.setBounds(37, 111, 81, 26);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Welcome!");
		lblNewLabel_1_2_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_1_2_2.setBounds(313, 31, 81, 26);
		contentPane.add(lblNewLabel_1_2_2);
		
		JLabel lblonlyFillIn = new JLabel("(Only fill in one column, then login under");
		lblonlyFillIn.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblonlyFillIn.setBounds(196, 79, 308, 38);
		contentPane.add(lblonlyFillIn);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(143, 363, 95, 31);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(313, 363, 95, 31);
		contentPane.add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(495, 363, 95, 31);
		contentPane.add(passwordField_2);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Reader Registration?");
		lblNewLabel_1_2_3.setBounds(530, 86, 134, 26);
		contentPane.add(lblNewLabel_1_2_3);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("CLICK HERE!");
		lblNewLabel_1_2_1_1.setBounds(555, 111, 81, 26);
		contentPane.add(lblNewLabel_1_2_1_1);
		
		JButton reader_registration = new JButton("Register");
		reader_registration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register_interface_readers object = new register_interface_readers();
				register_interface_readers.main(null);
			}
		});
		reader_registration.setBounds(540, 136, 101, 23);
		contentPane.add(reader_registration);
	}
}
