package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.TextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import System.Tickets;
import System.Trip;
import Users.Driver;
import Users.Passenger;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Limousine {
	
	private static final long serialVersionUID = 1L;

	private JFrame frame;

	public static String source = null;
	public static String destination = null;
	public static int day, month, year;
	public static double price;
	
	
	public void main(String source, String destination, int day, int month, int year) {
		Limousine.source = source;
		Limousine.destination = destination;
		Limousine.day = day;
		Limousine.month = month;
		Limousine.year = year;		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Limousine window = new Limousine();
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
	public Limousine() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 477, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TripSearch.main(null);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnBack.setBounds(22, 215, 90, 25);
		frame.getContentPane().add(btnBack);
		
		JLabel lblMyTrips = new JLabel("Book Limousine");
		lblMyTrips.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMyTrips.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMyTrips.setBounds(130, 13, 315, 25);
		frame.getContentPane().add(lblMyTrips);
		
		JButton btnBookMyTrip = new JButton("Book My Trip");
		btnBookMyTrip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Trip trip = new Trip();
				trip.setPrice(price);
				trip.day = day;
				trip.month = month;
				trip.year = year;
				
				trip.busCode = 3001;
				trip.setTripCode(100 + Main.getTripList().get(Main.getTripList().size()-1).getTripCode());
				trip.setSource(source);
				trip.setDestination(destination);
				trip.setAvailableSeats(0);
				
				Tickets ticket = new Tickets();
				ticket.setClientName(Main.getPassengersList().get(Passenger.i).getUsername());
				ticket.setTripCode(trip.getTripCode());
				Main.getPassengersList().get(Passenger.i).numOfTrips++;
				
				Main.getTicketList().add(ticket);
				Main.getTripList().add(trip);
				JOptionPane.showMessageDialog(null, "Trip Booked Successfully For " + price);
				Main.save();
				
				CustomerPage.main(null);
				frame.setVisible(true);
				frame.dispose();
			}
		});
		btnBookMyTrip.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBookMyTrip.setBounds(326, 215, 119, 25);
		frame.getContentPane().add(btnBookMyTrip);
		
		JLabel sourceLabel = new JLabel(source);
		sourceLabel.setForeground(Color.WHITE);
		sourceLabel.setHorizontalAlignment(SwingConstants.LEFT);
		sourceLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		sourceLabel.setBounds(22, 51, 256, 45);
		frame.getContentPane().add(sourceLabel);
		
		JLabel destinationLabel = new JLabel(destination);
		destinationLabel.setForeground(Color.WHITE);
		destinationLabel.setHorizontalAlignment(SwingConstants.LEFT);
		destinationLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		destinationLabel.setBounds(22, 157, 256, 45);
		frame.getContentPane().add(destinationLabel);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTo.setBounds(12, 109, 130, 45);
		frame.getContentPane().add(lblTo);
		
		JLabel lblOn = new JLabel("On");
		lblOn.setHorizontalAlignment(SwingConstants.CENTER);
		lblOn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOn.setBounds(130, 109, 130, 45);
		frame.getContentPane().add(lblOn);
		
		JLabel dateLabel = new JLabel(day + " " + month + " " + year);
		dateLabel.setForeground(Color.WHITE);
		dateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		dateLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dateLabel.setBounds(315, 109, 130, 45);
		frame.getContentPane().add(dateLabel);
		
		int k;
		for(k=0 ; k<Main.getTripList().size() ; k++) {
			if (((Main.getTripList().get(k).getSource().equals(source) && Main.getTripList().get(k).getDestination().equals(destination)))){
				price = 2*Main.getTripList().get(k).getPrice();
				break;				
			}
		}
		
		JLabel priceLabel = new JLabel("$" + Double.toString(price));
		priceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		priceLabel.setBounds(350, 157, 97, 45);
		frame.getContentPane().add(priceLabel);
	}
}
