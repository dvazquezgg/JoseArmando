import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class reader_article_interface extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reader_article_interface frame = new reader_article_interface();
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
	public reader_article_interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(23, 43, 68, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("AID -");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(103, 43, 56, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Title:");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(23, 26, 56, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("-");
		lblNewLabel_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(103, 26, 40, 16);
		contentPane.add(lblNewLabel_2_1);
		
		JButton btnNewButton = new JButton("Add Comment");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comment_interface object = new comment_interface();
				comment_interface.main(null);
			}
		});
		btnNewButton.setBounds(436, 412, 117, 46);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2_2 = new JLabel("AID");
		lblNewLabel_2_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_2_2.setBounds(395, 26, 40, 16);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Comments");
		lblNewLabel_2_2_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_2_2_1_1.setBounds(529, 25, 88, 16);
		contentPane.add(lblNewLabel_2_2_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 71, 316, 404);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(395, 71, 40, 316);
		contentPane.add(scrollPane_1);
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(488, 71, 176, 316);
		contentPane.add(scrollPane_1_1);
	}
}
