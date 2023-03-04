import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class administrator_article_approval extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					administrator_article_approval frame = new administrator_article_approval();
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
	public administrator_article_approval() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Approve");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submission_list_interface object = new submission_list_interface();
				submission_list_interface.main(null);
			}
		});
		btnNewButton.setBounds(121, 438, 151, 43);
		contentPane.add(btnNewButton);
		
		JButton btnReject = new JButton("Reject");
		btnReject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submission_list_interface object = new submission_list_interface();
				submission_list_interface.main(null);
			}
		});
		btnReject.setBounds(394, 438, 151, 43);
		contentPane.add(btnReject);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(51, 93, 82, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblTitle.setBounds(51, 54, 82, 16);
		contentPane.add(lblTitle);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(72, 134, 519, 271);
		contentPane.add(editorPane);
	}

}
