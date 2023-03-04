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
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class writing_page_interface extends JFrame {

	private JPanel contentPane;
	private JTextField aid_text;
	private JTextField title_text;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					writing_page_interface frame = new writing_page_interface();
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
	
	Connection connection = null;
	public writing_page_interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(91, 58, 263, 141);
		contentPane.add(scrollPane);
		
		JEditorPane actual_article = new JEditorPane();
		scrollPane.setViewportView(actual_article);
		
		JButton submit_article = new JButton("Submit");
		submit_article.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					try {

					if((aid_text.getText().equals("")) || (title_text.getText().equals("")) ||	(submit_article.getText().equals(""))) {

					JOptionPane.showMessageDialog(null,"You have left one of the fields empty"); }

					else {

					// INSERTING DATA INTO DATABASE
					connection = Sqliteconnection.dbConnector();
					String query = "insert into Articles(AID,Title,Article) values(?,?,?)";
					PreparedStatement pst3 = connection.prepareStatement(query);
					pst3.setString(1, aid_text.getText());
					pst3.setString(2, title_text.getText());
					pst3.setString(3, actual_article.getText());
					pst3.execute();
					JOptionPane.showMessageDialog(null, "Record has been saved!");

					pst3.close();
					}

					}
					catch(Exception e1) {
					e1.printStackTrace();

					}
			
				writer_interface object = new writer_interface();
				writer_interface.main(null);
		
			}});
		submit_article.setBounds(162, 211, 117, 40);
		contentPane.add(submit_article);
		
		aid_text = new JTextField();
		aid_text.setBounds(149, 29, 130, 26);
		contentPane.add(aid_text);
		aid_text.setColumns(10);
		
		title_text = new JTextField();
		title_text.setColumns(10);
		title_text.setBounds(149, 6, 130, 26);
		contentPane.add(title_text);
		
		JLabel lblNewLabel = new JLabel("Title:");
		lblNewLabel.setBounds(91, 11, 61, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("AID:");
		lblName.setBounds(91, 34, 61, 16);
		contentPane.add(lblName);
		
		JLabel lblNewLabel_1 = new JLabel("(Will be sent for verification before publishing)");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(109, 256, 232, 16);
		contentPane.add(lblNewLabel_1);
		
		
		}
}
