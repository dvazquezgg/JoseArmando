import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class comment_interface extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					comment_interface frame = new comment_interface();
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
	public comment_interface() {
		Connection connection = null;
		connection = Sqliteconnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(74, 94, 572, 313);
		contentPane.add(editorPane);

		btnNewButton.setBounds(277, 431, 174, 43);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("AID");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(74, 61, 46, 16);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(128, 56, 140, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit Comment");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reader_article_interface object = new reader_article_interface();
				reader_article_interface.main(null);
			}
		});
		
		String query2 = "insert into Comments(AID) values(?)";
		PreparedStatement pst = connection.prepareStatement(query2);
		// for loop
		pst.setString(1, editorPane.getText());
		pst.execute();
		JOptionPane.showMessageDialog(null, "Record has been saved");
		frame.dispose();
		pst.close();
		
	}}
	catch(Exception  e1) {
		
		
	}
	
	