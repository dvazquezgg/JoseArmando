import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;

public class register_interface extends JFrame {

	private JPanel contentPane;
	private JTextField writer_email;
	private JTextField writer_DOB;
	private JTextField writer_username;
	private JPasswordField passwordWriter;
	private JFrame frame;
	static ArrayList<String> AdminIDs = new ArrayList<String>();
	private JTextField writer_aid;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register_interface frame = new register_interface();
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

	private void insertIntoDb(String query, String[] parameters){
		try {
		Connection connection = null;
		connection = Sqliteconnection.dbConnector();
		PreparedStatement pst = connection.prepareStatement(query);
		String AdminID = register_interface.getAlphanumericString();
		// for loop
		AdminIDs.add(AdminID);
		writer_aid.setText(AdminID);
		
		for(int i = 0; i < parameters.length; i++) {
			pst.setString(i+1 , parameters[i]);	
		}
		
	
		pst.execute();
		JOptionPane.showMessageDialog(null, "Record has been saved");
		writer_aid.setText("");
		//frame.dispose();
		pst.close();
		
	
}
catch(Exception  e1) {
	System.out.println(e1.toString());
	System.out.println(e1.getStackTrace());
	e1.printStackTrace();
}
		
	}
	
	private void doSomething() {

			String passwordcheck = passwordWriter.getText();
				
			boolean allOk = true;	
			if((writer_email.getText().equals("")) || (writer_DOB.getText().equals(""))
			|| (passwordWriter.getText().equals("")))
			{
				JOptionPane.showMessageDialog(null, "Data missing in at least 1 field");
				allOk = false;
				}
			if(!writer_email.getText().contains("@")) {
					JOptionPane.showMessageDialog(null, "Your email is invalid");
					allOk = false;
				}
			if(!writer_DOB.getText().contains("/")) {
					JOptionPane.showMessageDialog(null, "Your date of birth is invalid");
					allOk = false;
				}
			if(passwordcheck.length()< 8) {
					JOptionPane.showMessageDialog(null, "Your password must contain at least 8 characters");
					allOk = false;
				}
			if(allOk == true) {
				
					String user_id = writer_aid.getText();
					String user_email = writer_email.getText();
					String user_dob = writer_DOB.getText();
					String user_password = passwordWriter.getText();
					
					
					// Establishing parameters for the Query
					String[] parameters = {writer_aid.getText(), writer_email.getText(), writer_DOB.getText(), passwordWriter.getText()};
					
					//parameters[0];
					//parameters[1];
					//parameters[2];
					//parameters[3];
					
					
					
					String query = "insert into Writer_Table(AID,Email,DOB,Password) values(?,?,?,?,?)";
					
					insertIntoDb(query, parameters);
				}
		}
	
	/**
	 * Create the frame.
	 * 
	 */
	Connection connection = null;
		
    /**		
	finally {
		Connection connection = null;
	
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
	**/
	
	public register_interface() {
	    //connection = Sqliteconnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 559);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doSomething();
				register_and_login_interface object = new register_and_login_interface();
				register_and_login_interface.main(null);
					System.out.println("gettinghere");
				
				try {
					String generate_ID = register_interface.getAlphanumericString();
					writer_aid.setText(generate_ID);
					String query1 = "select * from Writer_Table where AID=?";
					PreparedStatement pstt2 = connection.prepareStatement(query1);
					pstt2.setString(1, writer_aid.getText());
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
		btnNewButton.setBounds(260, 415, 180, 65);
		contentPane.add(btnNewButton);
		
		writer_email = new JTextField();
		writer_email.setBounds(273, 212, 167, 48);
		contentPane.add(writer_email);
		writer_email.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("E-Mail Address");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(52, 227, 123, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblPassword.setBounds(52, 299, 97, 16);
		contentPane.add(lblPassword);
		
		JLabel lblNewLabel_1_1 = new JLabel("Date of Birth");
		lblNewLabel_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(52, 366, 123, 16);
		contentPane.add(lblNewLabel_1_1);
		
		writer_DOB = new JTextField();
		writer_DOB.setColumns(10);
		writer_DOB.setBounds(273, 351, 167, 48);
		contentPane.add(writer_DOB);
		
		JLabel lblNewLabel_1 = new JLabel("D/M/Y");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(514, 366, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		passwordWriter = new JPasswordField();
		passwordWriter.setBounds(273, 284, 167, 48);
		contentPane.add(passwordWriter);
		
		JLabel lblNewLabel_2 = new JLabel("This is the registration page! Provide your");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(200, 57, 307, 29);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("information and you will be set!");
		lblNewLabel_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(239, 80, 224, 29);
		contentPane.add(lblNewLabel_2_1);
		
		writer_aid = new JTextField();
		writer_aid.setBounds(79, 459, 107, 42);
		contentPane.add(writer_aid);
		writer_aid.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("LEAVE");
		lblNewLabel_5.setBounds(6, 464, 61, 16);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("BLANK!");
		lblNewLabel_5_1.setBounds(6, 485, 61, 16);
		contentPane.add(lblNewLabel_5_1);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblUsername.setBounds(52, 149, 123, 16);
		contentPane.add(lblUsername);
		
		writer_username = new JTextField();
		writer_username.setColumns(10);
		writer_username.setBounds(273, 134, 167, 48);
		contentPane.add(writer_username);
	}
}
