package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import System.Trip;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class addTrip {
	
	private static final long serialVersionUID = 1L;

	private JFrame frame;
	private ButtonGroup typeGp= new ButtonGroup();
	private ButtonGroup stopsGp= new ButtonGroup();
	private JTextField busCodeField;
	private JTextField priceField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addTrip window = new addTrip();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public addTrip() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 549, 367);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Source");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(52, 52, 49, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblTo = new JLabel("Destination");
		lblTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTo.setBounds(52, 87, 63, 14);
		frame.getContentPane().add(lblTo);
		
		JComboBox intSourceCombo = new JComboBox();
		intSourceCombo.setModel(new DefaultComboBoxModel(new String[] {"Shatbi", "Roushdy", "Miami", "Mostafa Kamel", "Smouha", "Sidi Beshr", "Sporting"}));
		intSourceCombo.setBounds(127, 48, 116, 22);
		frame.getContentPane().add(intSourceCombo);
		
		JComboBox extSourceCombo = new JComboBox();
		extSourceCombo.setModel(new DefaultComboBoxModel(new String[] {"Alexandria", "Cairo", "Sharm El Sheikh", "Luxor", "Dahab", "Aswan", "Matrouh"}));
		extSourceCombo.setBounds(127, 48, 116, 22);
		frame.getContentPane().add(extSourceCombo);
		
		JComboBox intDestinationCombo = new JComboBox();
		intDestinationCombo.setModel(new DefaultComboBoxModel(new String[] {"Roushdy", "Shatby", "Miami", "Mostafa Kamel", "Smouha", "Sidi Beshr", "Sporting"}));
		intDestinationCombo.setBounds(127, 83, 116, 22);
		frame.getContentPane().add(intDestinationCombo);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManagerPage.main(null);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		backButton.setBounds(22, 267, 100, 30);
		frame.getContentPane().add(backButton);
		
		JButton confirmButton = new JButton("Confirm");
		confirmButton.setBounds(411, 267, 100, 30);
		frame.getContentPane().add(confirmButton);
		
		JLabel lblTravelDate = new JLabel("Travel Date");
		lblTravelDate.setForeground(SystemColor.text);
		lblTravelDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTravelDate.setBounds(22, 194, 124, 22);
		frame.getContentPane().add(lblTravelDate);
		
		JComboBox year1 = new JComboBox();
		year1.setModel(new DefaultComboBoxModel(new String[] {"2019", "2020"}));
		year1.setBounds(448, 195, 63, 22);
		frame.getContentPane().add(year1);
		
		JComboBox month1 = new JComboBox();
		month1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		month1.setBounds(355, 195, 49, 22);
		frame.getContentPane().add(month1);
		
		JComboBox day1 = new JComboBox();
		day1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		day1.setBounds(265, 195, 49, 22);
		frame.getContentPane().add(day1);
		
		JLabel lblNewLabel_3 = new JLabel("DD");
		lblNewLabel_3.setBounds(242, 199, 19, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblMm_1 = new JLabel("MM");
		lblMm_1.setBounds(326, 198, 31, 14);
		frame.getContentPane().add(lblMm_1);
		
		JLabel lblYy_1 = new JLabel("YY");
		lblYy_1.setBounds(426, 199, 19, 14);
		frame.getContentPane().add(lblYy_1);
		
		JRadioButton externalButton = new JRadioButton("External");
		externalButton.setBackground(SystemColor.activeCaption);
		externalButton.setBounds(258, 87, 90, 23);
		frame.getContentPane().add(externalButton);
		
		JRadioButton internalButton = new JRadioButton("Internal");
		internalButton.setBackground(SystemColor.activeCaption);
		internalButton.setBounds(258, 52, 90, 23);
		frame.getContentPane().add(internalButton);
		
		JComboBox extDestinationCombo = new JComboBox();
		extDestinationCombo.setModel(new DefaultComboBoxModel(new String[] {"Cairo", "Alexandria", "Sharm El Sheikh", "Luxor", "Dahab", "Aswan", "Matrouh"}));
		extDestinationCombo.setBounds(127, 83, 116, 22);
		frame.getContentPane().add(extDestinationCombo);
		
		typeGp.add(internalButton);
		typeGp.add(externalButton);
		internalButton.setSelected(true);
		
		JLabel codeLabel = new JLabel("Bus Code");
		codeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		codeLabel.setBounds(52, 124, 63, 14);
		frame.getContentPane().add(codeLabel);
		
		busCodeField = new JTextField();
		busCodeField.setBounds(127, 118, 116, 22);
		frame.getContentPane().add(busCodeField);
		busCodeField.setColumns(10);
		
		JRadioButton stop1 = new JRadioButton("One Stop");
		stop1.setBackground(SystemColor.activeCaption);
		stop1.setBounds(355, 87, 109, 23);
		frame.getContentPane().add(stop1);
		
		JRadioButton stop0 = new JRadioButton("No Stops");
		stop0.setSelected(true);
		stop0.setBackground(SystemColor.activeCaption);
		stop0.setBounds(355, 52, 109, 23);
		frame.getContentPane().add(stop0);
		
		JRadioButton stop2 = new JRadioButton("Multiple Stops");
		stop2.setBackground(SystemColor.activeCaption);
		stop2.setBounds(355, 120, 156, 23);
		frame.getContentPane().add(stop2);
		
		stopsGp.add(stop0);
		stopsGp.add(stop1);
		stopsGp.add(stop2);
		
		priceField = new JTextField();
		priceField.setColumns(10);
		priceField.setBounds(127, 151, 116, 22);
		frame.getContentPane().add(priceField);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrice.setBounds(52, 157, 63, 14);
		frame.getContentPane().add(lblPrice);
		
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
		
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(busCodeField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Empty Bus Code");
					return;
				}
				
				if(priceField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Empty Price");
					return;
				}
				
				int yearDate = Integer.parseInt(year1.getSelectedItem().toString());
				int monthDate = Integer.parseInt(month1.getSelectedItem().toString());
				int dayDate = Integer.parseInt(day1.getSelectedItem().toString());
				int price = Integer.parseInt(priceField.getText());
				int busCode = Integer.parseInt(busCodeField.getText());
				int seats = 0;
				
				
				int k;
				
				for(k=0 ; k<Main.getBusList().size() ; k++) {
					if(Main.getBusList().get(k).getBusCode() == busCode) {
						seats = Main.getBusList().get(k).getNumOfSeats();
						break;
					}
				}
				
				if(k == Main.getBusList().size()) {
					JOptionPane.showMessageDialog(null, "Inavailable Bus Code");
					return;
				}
				
				
				if(internalButton.isSelected()) {
					Trip trip = new Trip();
					trip.setPrice(price);
					trip.day = dayDate;
					trip.month = monthDate;
					trip.year = yearDate;
					trip.busCode = busCode;
					trip.setTripCode(100 + Main.getTripList().get(Main.getTripList().size()-1).getTripCode());
					trip.setSource(intSourceCombo.getSelectedItem().toString());
					trip.setDestination(intDestinationCombo.getSelectedItem().toString());
					trip.setAvailableSeats(seats);
					
					if(stop0.isSelected())
						trip.setTripFlavor(0);
					else if (stop1.isSelected())
						trip.setTripFlavor(1);
					else if (stop2.isSelected())
						trip.setTripFlavor(2);
					
					Main.getTripList().add(trip);
				}
				
				else if(externalButton.isSelected()) {
					Trip trip = new Trip();
					trip.setPrice(price);
					trip.day = dayDate;
					trip.month = monthDate;
					trip.year = yearDate;
					trip.busCode = busCode;
					trip.setTripCode(100 + Main.getTripList().get(Main.getTripList().size()-1).getTripCode());
					trip.setSource(extSourceCombo.getSelectedItem().toString());
					trip.setDestination(extDestinationCombo.getSelectedItem().toString());
					trip.setAvailableSeats(seats);

					
					if(stop0.isSelected())
						trip.setTripFlavor(0);
					else if (stop1.isSelected())
						trip.setTripFlavor(1);
					else if (stop2.isSelected())
						trip.setTripFlavor(2);
					
					Main.getTripList().add(trip);
				}
				
				Main.writeToTripList();
				ManagerPage.main(null);
				frame.setVisible(false);
				frame.dispose();
			}
		});
	}
}
