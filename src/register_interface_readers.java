import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class register_interface_readers extends JFrame{

	private JPanel contentPane;
	private JTextField reader_username;
	private JTextField reader_email;
	private JTextField reader_DOB;
	private JPasswordField passwordReader;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register_interface_readers frame = new register_interface_readers();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void doSomething() {

		String passwordcheck = passwordReader.getText();

		boolean allOk = true;
		if ((reader_email.getText().equals("")) || ((reader_username.getText().equals("")) || (reader_DOB.getText().equals(""))
				|| (passwordReader.getText().equals("")))) {
			JOptionPane.showMessageDialog(null, "Data missing in at least 1 field");
			allOk = false;
		}
		if (!reader_email.getText().contains("@")) {
			JOptionPane.showMessageDialog(null, "Your email is invalid");
			allOk = false;
		}
		if (!reader_DOB.getText().contains("/")) {
			JOptionPane.showMessageDialog(null, "Your date of birth is invalid");
			allOk = false;
		}
		if (passwordcheck.length() < 8) {
			JOptionPane.showMessageDialog(null, "Your password must contain at least 8 characters");
			allOk = false;
		}
		if (allOk == true) {

			String user_username = reader_username.getText();
			String user_email = reader_email.getText();
			String user_password = passwordReader.getText();
			String user_dob = reader_DOB.getText();


			System.out.println("My userid: ");

			String[] parameters = {user_username, user_email, user_password, user_dob};


			try {
				connection = Sqliteconnection.dbConnector();
				String query = "insert into Reader_Table(Username,Email,Password,DOB)values(?,?,?,?)";
				PreparedStatement pst = connection.prepareStatement(query);
				pst.setString(1, reader_username.getText());
				pst.setString(2, reader_email.getText());
				pst.setString(3, passwordReader.getText());
				pst.setString(4, reader_DOB.getText());
				pst.execute();

				JOptionPane.showMessageDialog(null, "Record has been saved");
				pst.close();
				System.out.println("My query: " + query);
			} catch (Exception e2) {

			}
		}

		/**
		 * Create the frame.
		 *
		 */
		Connection connection = null;

	}


	/**
	 * Create the frame.
	 */
	Connection connection = null;

	public register_interface_readers() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("This is the registration page! Provide your");
		lblNewLabel.setBounds(199, 61, 278, 16);
		contentPane.add(lblNewLabel);

		JLabel lblInformationAndYou = new JLabel("information and you will be set!");
		lblInformationAndYou.setBounds(230, 78, 209, 16);
		contentPane.add(lblInformationAndYou);

		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(53, 145, 83, 16);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(53, 283, 83, 16);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("E-Mail Address");
		lblNewLabel_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(53, 210, 152, 16);
		contentPane.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Date of Birth");
		lblNewLabel_1_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(53, 360, 109, 16);
		contentPane.add(lblNewLabel_1_1_1_1);

		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register_and_login_interface object = new register_and_login_interface();
				register_and_login_interface.main(null);
			}
		});
		btnNewButton_1.setBounds(44, 433, 117, 29);
		contentPane.add(btnNewButton_1);

		reader_username = new JTextField();
		reader_username.setBounds(231, 131, 192, 47);
		contentPane.add(reader_username);
		reader_username.setColumns(10);

		reader_email = new JTextField();
		reader_email.setColumns(10);
		reader_email.setBounds(230, 194, 192, 47);
		contentPane.add(reader_email);

		reader_DOB = new JTextField();
		reader_DOB.setColumns(10);
		reader_DOB.setBounds(231, 346, 192, 47);
		contentPane.add(reader_DOB);

		JLabel lblNewLabel_2 = new JLabel("LEAVE BLANK!");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(487, 400, 110, 70);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("D/M/Y");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(478, 361, 61, 16);
		contentPane.add(lblNewLabel_3);

		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doSomething();
				register_and_login_interface object = new register_and_login_interface();
				register_and_login_interface.main(null);
			}
		});
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnNewButton.setBounds(230, 405, 198, 57);
		contentPane.add(btnNewButton);

		passwordReader = new JPasswordField();
		passwordReader.setBounds(230, 269, 193, 47);
		contentPane.add(passwordReader);
	}
}
