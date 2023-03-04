import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.TreeMap;
import java.awt.event.ActionEvent;

public class sport_league_team_selector_interface extends JFrame {

	private JPanel contentPane;
	JComboBox sport,league,team;
	Map<String, String[]> map = new TreeMap<String, String[]>();
	String sports[]= {"","Soccer", "Basketball", "Baseball", "Football", "Tennis", "Hockey", "Racing", "Golf", "Cricket", "Rugby", "Olympics"};
	String Soccer[]= {"Premier League", "Spanish La Liga", "French Ligue 1", "Italian Serie A", "German Bundesliga", "National Teams", "Liga MX", "MLS", "Womens Nations"};
	String Basketball[]= {"NBA", "WNBA", "Euro Basket", "NCAA"};
	String Baseball[]= {"MLB", "NCAA"};
	String Football[]= {"NFL", "NCAA"};
	String Tennis[]= {"Mens", "Womens"};
	String Hockey[]= {"NHL"};
	String Racing[]= {"F1", "Nascar"};
	String Golf[]= {"Mens", "Womens"};
	String Cricket[]= {"Mens National Teams", "Womens National Teams"};
	String Rugby[]= {"Mens National Teams", "Womens National Teams"};
	String Olympics[]= {"Track and Field", "Swimming", "Weightlifting",};

	sport_league_team_selector_interface() {
		setLayout(null);
		sport = new JComboBox(sports);
		sport.addActionListener(sport);
		add(sport);
		 
		league = new JComboBox(sports);
		league.addActionListener(league);
		add(league);
		
		map.put("Soccer", Soccer);
		map.put("Basketball", Basketball);
		map.put("Baseball", Baseball);
		map.put("Football", Football);
		map.put("Tennis", Tennis);
		map.put("Hockey", Hockey);
		map.put("Racing", Racing);
		map.put("Golf", Golf);
		map.put("Cricket", Cricket);
		map.put("Rugby", Rugby);
		map.put("Olympics", Olympics);
		
		setSize(500,300);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sport");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel.setBounds(87, 180, 43, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblLeague = new JLabel("League");
		lblLeague.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblLeague.setBounds(292, 180, 66, 17);
		contentPane.add(lblLeague);
		
		JLabel lblTeam = new JLabel("Team");
		lblTeam.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblTeam.setBounds(506, 162, 43, 16);
		contentPane.add(lblTeam);
		
		JLabel lblOptional = new JLabel("(Optional)");
		lblOptional.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblOptional.setBounds(496, 181, 66, 16);
		contentPane.add(lblOptional);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(234, 218, 179, 19);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(455, 209, 157, 37);
		contentPane.add(comboBox_2);
		
		JButton btnNewButton = new JButton("Advance");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(250, 337, 146, 62);
		contentPane.add(btnNewButton);

		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Football", "Basketball", "Baseball", "American Football", "Tennis", "Hockey", "Racing", "Golf", "Cricket", "Rugby", "Olympic Sports"}));
		comboBox.setBounds(25, 218, 170, 19);
		contentPane.add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				sports = (JCombBox)e.getSource();
				String value = (String)sports.getSelectedItem();
				
				if(map.containsKey(value)) {
					league.removeAllItems();
					
					for(String get:map.get(value)) {
						league.addItem(get);
					}
				}
				
			}	
			});
		
}

		public static void main(String[] args) {
			new sport_league_team_selector_interface();
		}}
