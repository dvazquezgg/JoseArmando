import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;

public class sport_selector_reader extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JTable table_all;


	/**
	 * Launch the application.
	 */
	Connection connection = null;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sport_selector_reader frame = new sport_selector_reader();
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
	public sport_selector_reader() {
		connection = Sqliteconnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton refresh_button = new JButton("Refresh");
		refresh_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT* FROM Articles";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet r = pst.executeQuery();
					table_all.setModel(DbUtils.resultSetToTableModel(r));
					pst.close();
					r.close();
				}
				catch(Exception e2) {
					
				}
			}
		});
		refresh_button.setBounds(250, 351, 148, 43);
		contentPane.add(refresh_button);
		
		table_all = new JTable();
		table_all.setBounds(83, 105, 474, 222);
		contentPane.add(table_all);
	}
}
