package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import Users.Passenger;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;

public class CustomerPage {
	
	private static final long serialVersionUID = 1L;

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerPage window = new CustomerPage();
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
	public CustomerPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 557, 347);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Sign out");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login Login = new login();
				Login.frame.setVisible(true);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(421, 252, 106, 35);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCurrentTrip = new JButton("View Booked Trips");
		btnCurrentTrip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CurrentTrips.main(null);
				frame.setVisible(false);
			}
		});
		btnCurrentTrip.setBounds(326, 13, 201, 226);
		frame.getContentPane().add(btnCurrentTrip);
		
		JButton btnBookATrip = new JButton("Book A Trip");
		btnBookATrip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TripSearch.main(null);
				frame.setVisible(false);
			}
		});
		btnBookATrip.setBounds(113, 13, 201, 226);
		frame.getContentPane().add(btnBookATrip);
		
		JLabel firstNameLabel = new JLabel(Main.getPassengersList().get(Passenger.i).fName);
		firstNameLabel.setForeground(SystemColor.text);
		firstNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		firstNameLabel.setBounds(12, 40, 106, 26);
		frame.getContentPane().add(firstNameLabel);
		
		JLabel numTripsLabel = new JLabel(Integer.toString(Main.getPassengersList().get(Passenger.i).numOfTrips) + " trips");
		numTripsLabel.setForeground(SystemColor.text);
		numTripsLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		numTripsLabel.setBounds(12, 118, 106, 26);
		frame.getContentPane().add(numTripsLabel);
		
		JLabel lastNameLabel = new JLabel(Main.getPassengersList().get(Passenger.i).lName);
		lastNameLabel.setForeground(Color.WHITE);
		lastNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lastNameLabel.setBounds(12, 79, 106, 26);
		frame.getContentPane().add(lastNameLabel);
	}
}