package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import System.Trip;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class TripSearch {
	
	private static final long serialVersionUID = 1L;

	private JFrame frame;
	private ButtonGroup roundGp = new ButtonGroup();
	private ButtonGroup typeGp= new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TripSearch window = new TripSearch();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * @wbp.parser.entryPoint
	 */
	public TripSearch() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 549, 338);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Source");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(52, 52, 49, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblTo = new JLabel("Destination");
		lblTo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTo.setBounds(52, 87, 76, 14);
		frame.getContentPane().add(lblTo);
		
		JComboBox intDestinationCombo = new JComboBox();
		intDestinationCombo.setModel(new DefaultComboBoxModel(new String[] {"Roushdy", "Shatby", "Miami", "Mostafa Kamel", "Smouha", "Sidi Beshr", "Sporting"}));
		intDestinationCombo.setBounds(127, 83, 116, 22);
		frame.getContentPane().add(intDestinationCombo);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CustomerPage.main(null);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(22, 247, 100, 30);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSearch = new JButton("Search ");
		btnSearch.setBounds(411, 247, 100, 30);
		frame.getContentPane().add(btnSearch);
		
		JRadioButton oneWayButton = new JRadioButton("One way trip");
		oneWayButton.setBackground(SystemColor.activeCaption);
		oneWayButton.setBounds(381, 48, 109, 23);
		frame.getContentPane().add(oneWayButton);
		
		JRadioButton roundButton = new JRadioButton("Round Trip");
		roundButton.setBackground(SystemColor.activeCaption);
		roundButton.setBounds(381, 83, 109, 23);
		frame.getContentPane().add(roundButton);
		
		JLabel lblTravelDate = new JLabel("Travel Date");
		lblTravelDate.setForeground(SystemColor.text);
		lblTravelDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTravelDate.setBounds(52, 132, 124, 22);
		frame.getContentPane().add(lblTravelDate);
		
		JComboBox year1 = new JComboBox();
		year1.setModel(new DefaultComboBoxModel(new String[] {"2019", "2020"}));
		year1.setBounds(447, 132, 63, 22);
		frame.getContentPane().add(year1);
		
		JComboBox month1 = new JComboBox();
		month1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		month1.setBounds(355, 132, 49, 22);
		frame.getContentPane().add(month1);
		
		JComboBox day1 = new JComboBox();
		day1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		day1.setBounds(258, 132, 49, 22);
		frame.getContentPane().add(day1);
		
		JLabel lblNewLabel_2 = new JLabel("Return Date\r\n");
		lblNewLabel_2.setForeground(SystemColor.text);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(52, 165, 124, 22);
		frame.getContentPane().add(lblNewLabel_2);
		
		JComboBox day2 = new JComboBox();
		day2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		day2.setBounds(258, 165, 49, 22);
		frame.getContentPane().add(day2);
		
		JComboBox month2 = new JComboBox();
		month2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		month2.setBounds(355, 165, 49, 22);
		frame.getContentPane().add(month2);
		
		JComboBox year2 = new JComboBox();
		year2.setModel(new DefaultComboBoxModel(new String[] {"2019", "2020"}));
		year2.setBounds(447, 165, 63, 22);
		frame.getContentPane().add(year2);
		
		JLabel lblNewLabel_3 = new JLabel("DD");
		lblNewLabel_3.setBounds(242, 137, 19, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel label = new JLabel("DD");
		label.setBounds(242, 169, 19, 14);
		frame.getContentPane().add(label);
		
		JLabel lblMm_1 = new JLabel("MM");
		lblMm_1.setBounds(326, 136, 31, 14);
		frame.getContentPane().add(lblMm_1);
		
		JLabel lblMm = new JLabel("MM\r\n\r\n");
		lblMm.setBounds(326, 169, 31, 14);
		frame.getContentPane().add(lblMm);
		
		JLabel lblYy_1 = new JLabel("YY");
		lblYy_1.setBounds(419, 137, 19, 14);
		frame.getContentPane().add(lblYy_1);
		
		JLabel lblYy = new JLabel("YY\r\n");
		lblYy.setBounds(419, 169, 19, 14);
		frame.getContentPane().add(lblYy);
		
		JRadioButton externalButton = new JRadioButton("External");
		externalButton.setBackground(SystemColor.activeCaption);
		externalButton.setBounds(268, 82, 109, 23);
		frame.getContentPane().add(externalButton);
		
		JRadioButton internalButton = new JRadioButton("Internal");
		internalButton.setBackground(SystemColor.activeCaption);
		internalButton.setBounds(268, 47, 109, 23);
		frame.getContentPane().add(internalButton);
		
		JComboBox intSourceCombo = new JComboBox();
		intSourceCombo.setModel(new DefaultComboBoxModel(new String[] {"Shatbi", "Roushdy", "Miami", "Mostafa Kamel", "Smouha", "Sidi Beshr", "Sporting"}));
		intSourceCombo.setBounds(127, 48, 116, 22);
		frame.getContentPane().add(intSourceCombo);
		
		JComboBox extSourceCombo = new JComboBox();
		extSourceCombo.setModel(new DefaultComboBoxModel(new String[] {"Alexandria", "Cairo", "Sharm El Sheikh", "Luxor", "Dahab", "Aswan", "Matrouh"}));
		extSourceCombo.setBounds(127, 48, 116, 22);
		frame.getContentPane().add(extSourceCombo);
		
		JComboBox extDestinationCombo = new JComboBox();
		extDestinationCombo.setModel(new DefaultComboBoxModel(new String[] {"Cairo", "Alexandria", "Sharm El Sheikh", "Luxor", "Dahab", "Aswan", "Matrouh"}));
		extDestinationCombo.setBounds(127, 83, 116, 22);
		frame.getContentPane().add(extDestinationCombo);
		
		roundGp.add(oneWayButton);
		roundGp.add(roundButton);
		
		typeGp.add(internalButton);
		typeGp.add(externalButton);
		internalButton.setSelected(true);
		oneWayButton.setSelected(true);
		
		internalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				extSourceCombo.setVisible(false);
				extDestinationCombo.setVisible(false);
				intSourceCombo.setVisible(true);
				intDestinationCombo.setVisible(true);
			}
		});
		
		externalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				intSourceCombo.setVisible(false);
				intDestinationCombo.setVisible(false);
				extSourceCombo.setVisible(true);
				extDestinationCombo.setVisible(true);
			}
		});
		
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				
				int yearDate1 = Integer.parseInt(year1.getSelectedItem().toString());
				int yearDate2 = Integer.parseInt(year2.getSelectedItem().toString());
				int monthDate1 = Integer.parseInt(month1.getSelectedItem().toString());
				int monthDate2 = Integer.parseInt(month2.getSelectedItem().toString());
				int dayDate1 = Integer.parseInt(day1.getSelectedItem().toString());
				int dayDate2 = Integer.parseInt(day2.getSelectedItem().toString());
				String source = null;
				String destination = null;
				boolean round;
				
				if(oneWayButton.isSelected())
					round = false;
				else
					round = true;				
				
				if (yearDate1 > yearDate2) {
					JOptionPane.showMessageDialog(null, "Unavailable Date");
					return;
				}
				
				else if (yearDate1 == yearDate2 && monthDate1 > monthDate2) {
					JOptionPane.showMessageDialog(null, "Unavailable Date");
					return;
				}
				
				else if (yearDate1 == yearDate2 && monthDate1 == monthDate2 && dayDate1 > dayDate2) {
					JOptionPane.showMessageDialog(null, "Unavailable Date");
					return;
				}
				
				if(internalButton.isSelected()) {
					source = intSourceCombo.getSelectedItem().toString();
					destination = intDestinationCombo.getSelectedItem().toString();
				}
				
				else if(externalButton.isSelected()) {
					source = extSourceCombo.getSelectedItem().toString();
					destination = extDestinationCombo.getSelectedItem().toString();
				}
				
				Ticket ticket = new Ticket();
				ticket.main(source, destination, dayDate1, dayDate2, monthDate1, monthDate2, yearDate1, yearDate2, round);
				frame.setVisible(false);
			}
		});
	}
}
