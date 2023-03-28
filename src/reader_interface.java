import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.TreeMap;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class reader_interface extends JFrame implements ListSelectionListener {

	private JPanel contentPane;
	private JTable PreviousArticlesList;
	private JTable Comments;
	static JLabel lblDetail, lblSelected;
	static JLabel lblInstruction, lblMessage;
	JComboBox sportCombo, leagueCombo, teamCombo;
	String sportValue;
	String leagueValue;
	String teamValue;
	private JTable table;
	private JTable articleslist;
	private JScrollPane article;
	Map<String, String[]> map = new TreeMap<String, String[]>();
	Map<String, String[]> map1 = new TreeMap<String, String[]>();
	// writer_interface form = new writer_interface();

	String sports[] = {"", "Soccer", "Basketball", "Baseball", "Football", "Olympics"};
	String Soccer[] = {"", "Premier League", "La Liga", "Ligue 1", "Serie A", "Bundesliga"};
	String Basketball[] = {"", "NBA", "WNBA", "Euro Basket", "NCAA"};
	String Baseball[] = {"", "MLB", "NCAA"};
	String Football[] = {"", "NFL", "NCAA"};
	String Olympics[] = {"", "Track and Field", "Swimming", "Weightlifting",};
	String premierleagueteams[] = {"", "Chelsea", "Arsenal", "Tottenham",};
	String laligateams[] = {"", "FC Barcelona", "Real Madrid", "Atletico de Madrid"};
	String ligue1teams[] = {"", "PSG", "Lyon", "Marseille"};
	String serieateams[] = {"", "AC Milan", "Juventus", "Napoli"};
	String bundesligateams[] = {"", "FC Bayern", "Dortmund", "RB Leipzig"};
	String nbateams[] = {"", "Chicago Bulls", "Miami Heat", "Detroit Pistons"};
	String wnbateams[] = {"", "Chicago Sky", "Las Vegas Aces", "New York Liberty"};
	String eurobasketteams[] = {"", "Olimpia Milano", "Real Madrid", "Maccabi Tel Aviv"};
	String ncaabteams[] = {"", "Duke", "Kentucky", "Gonzaga"};
	String nflteams[] = {"", "Chicago Bears", "Pittsburgh Steelers", "Carolina Panthers"};
	String ncaafteams[] = {"", "Alabama", "Clemson", "Ohio State"};
	String mlbteams[] = {"", "Chicago Cubs", "Texas Rangers", "Minesotta Twins"};
	String collegebaseballteams[] = {"", "Texas", "LSU", "Texas A&M"};
	String trackandfield[] = {"", "Jamaica", "USA", "Canada"};
	String swimming[] = {"", "USA", "China", "Great Britain"};
	Connection connection = null;

	public void createOptionsMap() {

		map.put("Soccer", Soccer);
		map.put("Basketball", Basketball);
		map.put("Baseball", Baseball);
		map.put("Football", Football);
		map.put("Olympics", Olympics);

		map1.put("Premier League", premierleagueteams);
		map1.put("La Liga", laligateams);
		map1.put("Ligue 1", ligue1teams);
		map1.put("Serie A", serieateams);
		map1.put("Bundesliga", bundesligateams);
		map1.put("NBA", nbateams);
		map1.put("WNBA", wnbateams);
		map1.put("Euro Basket", eurobasketteams);
		map1.put("NCAAB", ncaabteams);
		map1.put("MLB", mlbteams);
		map1.put("College Baseball", collegebaseballteams);
		map1.put("NFL", nflteams);
		map1.put("NCAAF", ncaafteams);
		map1.put("Track and Field", trackandfield);
		map1.put("Swimming", swimming);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reader_interface frame = new reader_interface();
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
	public reader_interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 850);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		DefaultTableModel model = new DefaultTableModel();

		JLabel WelcomeReader = new JLabel("Welcome Reader!");
		WelcomeReader.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		WelcomeReader.setBounds(23, 26, 152, 16);
		contentPane.add(WelcomeReader);

		JEditorPane commenteditor = new JEditorPane();
		commenteditor.setBounds(760, 172, 218, 267);
		contentPane.add(commenteditor);

		JButton addcomment = new JButton("Add Comment");
		addcomment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					connection = Sqliteconnection.dbConnector();
					String query = "insert into Comments(Comment)values(?)";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, commenteditor.getText());
					pst.execute();

					JOptionPane.showMessageDialog(null, "Comment has been saved");
					pst.close();


				} catch (Exception e1) {

				}
			}
		});
		;
		addcomment.setBounds(813, 495, 117, 46);
		contentPane.add(addcomment);

		JLabel comments = new JLabel("General Comment (Opinion)");
		comments.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		comments.setBounds(760, 126, 218, 16);
		contentPane.add(comments);

		JScrollPane article = new JScrollPane();
		JLabel articlelabel = new JLabel(new ImageIcon("A.jpg"));
		article.setBounds(400, 164, 284, 404);
		contentPane.add(article);

		table = new JTable();
		article.setViewportView(table);

		articleslist = new JTable();
		articleslist.setBounds(28, 234, 335, 267);
		contentPane.add(articleslist);

		JLabel lblNewLabel_2_1 = new JLabel("What would you like to read?");
		lblNewLabel_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(23, 84, 245, 16);
		contentPane.add(lblNewLabel_2_1);


		JComboBox sportscombo = new JComboBox();
		sportscombo.setModel(new DefaultComboBoxModel(new String[]{"Soccer", "Basketball", "Baseball", "Football", "Olympics"}));
		sportscombo.setBounds(69, 161, 146, 27);
		contentPane.add(sportscombo);


		JLabel articletitle = new JLabel("Article");
		articletitle.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		articletitle.setBounds(508, 84, 61, 16);
		contentPane.add(articletitle);

		JButton BackButtonReaders = new JButton("Back");
		BackButtonReaders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register_and_login_interface object = new register_and_login_interface();
				register_and_login_interface.main(null);
			}
		});
		BackButtonReaders.setBounds(23, 553, 117, 29);
		contentPane.add(BackButtonReaders);

		JButton showarticles = new JButton("Show");
		showarticles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection = Sqliteconnection.dbConnector();
				try {
					String query2 = "select * from Articles where Sport='" + sportscombo.getSelectedItem() + "'";
					;
					PreparedStatement pstt = connection.prepareStatement(query2);
					ResultSet rs = pstt.executeQuery();
							articleslist.setModel(DbUtils.resultSetToTableModel(rs));

					pstt.close();
					rs.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}

			;


		});
		showarticles.setBounds(82, 193, 117, 29);
		contentPane.add(showarticles);

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) { // Return true if the selection is still changing. Many list selection listeners are interested only in the final state of the selection and can ignore list selection events when this method returns true.
			int selectedRow = articleslist.getSelectedRow(); // getSelectedRow() Returns the index of the first selected row, -1 if no row is selected.
			if (selectedRow >= 0) {
				TableModel model = table.getModel();
				Object obj = model.getValueAt(selectedRow, 3);
				article.setToolTipText(obj == null ? "" : obj.toString());
			}
		}
	}
}
