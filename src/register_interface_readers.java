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

public class register_interface_readers extends JFrame {

	private JPanel contentPane;
	private JTextField reader_username;
	private JTextField reader_email;
	private JTextField reader_DOB;
	private JPasswordField passwordReader;
	private JFrame frame;
	static ArrayList<String> AdminIDsR = new ArrayList<String>();
	private JTextField reader_aid;

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
	static String getAlphanumericString() {
		// Creating a string of all characters
		String gen = "abcdefghijklmnopqrstuvxyz1234567890!@#$%^&*-+"; 
		// Creating a random string builder
		StringBuilder code = new StringBuilder();
		// Create an object of the random class
		Random random = new Random();
		// Create a variable to specify the length of the randomly generated characters
		int length = 1;
		for(int i = 0; i<length; i++) {
			// Generate random index number
			int index = random.nextInt(gen.length());
			// Generating character from string by specified
			char randomChar = gen.charAt(index);
			// Append the characters to a string builder
			code.append("ADMIN" + randomChar);
			
			
		}
		String randomString = code.toString();
		return randomString;
	}

	
	private void doSomething() {
		
		try  {
			Connection connection = null;
			connection = Sqliteconnection.dbConnector();
			
			System.out.println("hi");
		
							String passwordcheck1 = passwordReader.getText();
							
							
							if((reader_email.getText().equals("")) || (reader_DOB.getText().equals(""))
							|| (passwordReader.getText().equals("")))
							{
								JOptionPane.showMessageDialog(null, "Data missing in at least 1 field");
							}
							if(!reader_email.getText().contains("@")) {
								JOptionPane.showMessageDialog(null, "Your email is invalid");
							}
							if(!reader_DOB.getText().contains("/")) {
								JOptionPane.showMessageDialog(null, "Your date of birth is invalid");
							}
							if(passwordcheck1.length()< 8) {
								JOptionPane.showMessageDialog(null, "Your password must contain at least 8 characters");
							}
							else {
							String query = "insert into Reader_Table(AID,Email,Password,DOB,Username) values(?,?,?,?,?)";
							PreparedStatement pst = connection.prepareStatement(query);
							String AdminIDR = register_interface.getAlphanumericString();
							// for loop
							AdminIDsR.add(AdminIDR);
							reader_aid.setText(AdminIDR);
							pst.setString(1, reader_aid.getText());
							pst.setString(2, reader_email.getText());
							pst.setString(3, passwordReader.getText());
							pst.setString(4, reader_DOB.getText());
							pst.setString(1, reader_username.getText());
							pst.execute();
							JOptionPane.showMessageDialog(null, "Record has been saved");
							reader_aid.setText("");
							frame.dispose();
							pst.close();
							}
						}
						catch(Exception  e1) {
							System.out.println(e1.toString());
							System.out.println(e1.getStackTrace());
							e1.printStackTrace();
						}
					
		
	}
	

	/**
	 * Create the frame.
	 */
	Connection connection = null;
			
	public register_interface_readers() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 514);
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
		lblNewLabel_2.setBounds(53, 419, 109, 16);
		contentPane.add(lblNewLabel_2);
		
		reader_aid = new JTextField();
		reader_aid.setBounds(41, 438, 130, 26);
		contentPane.add(reader_aid);
		reader_aid.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("D/M/Y");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(478, 361, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register_and_login_interface object = new register_and_login_interface();
				register_and_login_interface.main(null);
				
				try {
					String generate_ID = register_interface.getAlphanumericString();
					reader_aid.setText(generate_ID);
					String query1 = "select * from Writer_Table where AID=?";
					PreparedStatement pstt2 = connection.prepareStatement(query1);
					pstt2.setString(1, reader_aid.getText());
					ResultSet r2 = pstt2.executeQuery();
					int counting = 0;
					while(r2.next()) {
						counting = counting + 1;
					}
					if(counting == 1) {
						JOptionPane.showMessageDialog(null, "ID already exists!");
						btnNewButton.setEnabled(true);
					}
					else if(counting == 0) {
						JOptionPane.showMessageDialog(null, "ID is available!");
						btnNewButton.setEnabled(false);
					}
					r2.close();
					pstt2.close();
					}
				catch(Exception e1) {
					e1.printStackTrace();
				}
				
		
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
