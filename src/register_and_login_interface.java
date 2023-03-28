import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class register_and_login_interface extends JFrame {

	private JPanel contentPane;
	private JTextField readerusername;
	private JTextField writerusername;
	private JPasswordField writerpassword;
	private JPasswordField readerpassword;

	Connection connection = null;
	int value;
	int valuee;
	int count;

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

	public int Login_Correct(String query) {
		connection = Sqliteconnection.dbConnector();
		System.out.println("My query" + query);
		try {
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet r = pst.executeQuery();
			while (r.next()) {
				count = count + 1;
			}
			if (count == 1) {
				return 1;
			} else if (count == 0) {
				return 0;
			}
			pst.close();
			r.close();
		} catch (Exception e5) {
			e5.printStackTrace();
		}
		return 0;
	}

	/**
	 * Create the frame.
	 */
	public register_and_login_interface() {
		JFrame frame = new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton writer_registration = new JButton("Register");
		writer_registration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register_interface_writers object = new register_interface_writers();
				register_interface_writers.main(null);
			}
		});
		writer_registration.setBounds(24, 139, 101, 23);
		contentPane.add(writer_registration);

		JButton writerloginbtn = new JButton("Login");
		writerloginbtn.setBounds(218, 457, 96, 32);
		contentPane.add(writerloginbtn);

		writerloginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (writerusername.getText().equals("") || writerpassword.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Data missing in at least one field");
					} else {
						register_and_login_interface obj = new register_and_login_interface();
						value = obj.Login_Correct("select * from Writer_Table where Username = '" + writerusername.getText() + "' and Password = '" + writerpassword.getText() + "'");
						if (value == 0) {
							JOptionPane.showMessageDialog(null, "Invalid Login Credentials");
						} else if (value == 1) {
							JOptionPane.showMessageDialog(null, "Valid Login Credentials");
							frame.dispose();
							writer_interface object = new writer_interface();
							writer_interface.main(null);

						}
					}
				} catch(Exception e4) {

				}
			}
		});

		JButton readerloginbtn = new JButton("Login");
		readerloginbtn.setBounds(415, 458, 95, 31);
		contentPane.add(readerloginbtn);

		readerloginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (readerusername.getText().equals("") || readerpassword.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Data missing in at least one field");
					} else {
						register_and_login_interface obj = new register_and_login_interface();
						valuee = obj.Login_Correct("select * from Reader_Table where Username = '" + readerusername.getText() + "' and Password = '" + readerpassword.getText() + "'");
						if (valuee == 0) {
							JOptionPane.showMessageDialog(null, "Invalid Login Credentials");
						} else if (valuee == 1) {
							JOptionPane.showMessageDialog(null, "Valid Login Credentials");
							frame.dispose();
							reader_interface object = new reader_interface();
							reader_interface.main(null);

						}
					}
				} catch(Exception e4) {

				}
			}
		});


		readerusername = new JTextField();
		readerusername.setColumns(10);
		readerusername.setBounds(415, 271, 95, 31);
		contentPane.add(readerusername);

		writerusername = new JTextField();
		writerusername.setColumns(10);
		writerusername.setBounds(213, 271, 101, 31);
		contentPane.add(writerusername);

		JLabel intromsg2 = new JLabel("column that has been filled in, or register!");
		intromsg2.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		intromsg2.setBounds(196, 104, 308, 38);
		contentPane.add(intromsg2);

		JLabel lblEmailAddress = new JLabel("Username");
		lblEmailAddress.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblEmailAddress.setBounds(33, 277, 81, 16);
		contentPane.add(lblEmailAddress);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblPassword.setBounds(35, 369, 90, 16);
		contentPane.add(lblPassword);

		JLabel writerq = new JLabel("Writer Registration?");
		writerq.setBounds(16, 86, 122, 26);
		contentPane.add(writerq);

		JLabel lblWriter = new JLabel("Writer");
		lblWriter.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblWriter.setBounds(244, 197, 48, 16);
		contentPane.add(lblWriter);

		JLabel lblReader = new JLabel("Reader");
		lblReader.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblReader.setBounds(435, 197, 61, 16);
		contentPane.add(lblReader);

		JLabel writerclick = new JLabel("CLICK HERE!");
		writerclick.setBounds(37, 111, 81, 26);
		contentPane.add(writerclick);

		JLabel Welcomelabel = new JLabel("Welcome!");
		Welcomelabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		Welcomelabel.setBounds(313, 31, 81, 26);
		contentPane.add(Welcomelabel);

		JLabel intromsg1 = new JLabel("(Only fill in one column, then login under");
		intromsg1.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		intromsg1.setBounds(196, 79, 308, 38);
		contentPane.add(intromsg1);

		writerpassword = new JPasswordField();
		writerpassword.setBounds(213, 363, 101, 31);
		contentPane.add(writerpassword);

		readerpassword = new JPasswordField();
		readerpassword.setBounds(415, 363, 95, 31);
		contentPane.add(readerpassword);

		JLabel readerq = new JLabel("Reader Registration?");
		readerq.setBounds(530, 86, 134, 26);
		contentPane.add(readerq);

		JLabel readerclick = new JLabel("CLICK HERE!");
		readerclick.setBounds(555, 111, 81, 26);
		contentPane.add(readerclick);

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