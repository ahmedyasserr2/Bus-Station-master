package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import System.Tickets;
import Users.Passenger;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.TextArea;
import java.awt.Color;

public class Ticket {
	
	private static final long serialVersionUID = 1L;

	private JFrame frame;
	public static String source, Destination;
	public static int dayDate1, dayDate2, monthDate1, monthDate2, yearDate1, yearDate2;
	public static boolean round;
	/**
	 * Launch the application.
	 */
	public void main(String source, String destination, int dayDate1, int dayDate2, int monthDate1, int monthDate2, int yearDate1, int yearDate2, boolean round) {
		Ticket.source = source;
		Ticket.Destination = destination;
		Ticket.dayDate1 = dayDate1;
		Ticket.dayDate2 = dayDate2;
		Ticket.monthDate1 = monthDate1;
		Ticket.monthDate2 = monthDate2;
		Ticket.yearDate1 = yearDate1;
		Ticket.yearDate2 = yearDate2;
		Ticket.round = round;
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ticket window = new Ticket();
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
	public Ticket() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 649, 369);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TripSearch.main(null);
				frame.setVisible(false);
				frame.dispose();
				
			}
		});
		backButton.setBounds(12, 264, 141, 30);
		frame.getContentPane().add(backButton);
		
		JButton limoButton = new JButton("Book A Limousine");
		limoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Limousine limousine = new Limousine();
				limousine.main(source, Destination, dayDate1, monthDate1, yearDate1);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		limoButton.setBounds(12, 101, 141, 30);
		frame.getContentPane().add(limoButton);
		
		TextArea textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setBackground(Color.WHITE);
		textArea.setBounds(167, 58, 454, 236);
		frame.getContentPane().add(textArea);
		
		JButton bookButton = new JButton("Book My Trip");
		bookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code = JOptionPane.showInputDialog("Please enter trip Code");
				if(code == null)
					return;
				
				int k;
				for (k=0 ; k < Main.getTripList().size(); k++) {
					if (Main.getTripList().get(k).getTripCode() == Integer.parseInt(code)) {
						
						if(Main.getTripList().get(k).availableSeats == 0) {
							JOptionPane.showMessageDialog(null, "No available seats");
							return;
						}
						
						Tickets ticket = new Tickets();
						ticket.setClientName(Main.getPassengersList().get(Passenger.i).getUsername());
						ticket.setTripCode(Main.getTripList().get(k).getTripCode());
						Main.getPassengersList().get(Passenger.i).numOfTrips++;
						Main.getTripList().get(k).availableSeats--;
						
						Main.getTicketList().add(ticket);
						JOptionPane.showMessageDialog(null, "Trip Booked Successfully");
						Main.save();
						return;
					}
				}
				JOptionPane.showMessageDialog(null, "Invalid Trip Code");
			}
		});
		bookButton.setBounds(12, 58, 141, 30);
		frame.getContentPane().add(bookButton);
		
		JLabel lblBookATrip = new JLabel("Book A Trip");
		lblBookATrip.setForeground(Color.WHITE);
		lblBookATrip.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBookATrip.setBounds(35, 8, 106, 39);
		frame.getContentPane().add(lblBookATrip);
		
		int k;
		for(k=0 ; k<Main.getTripList().size() ; k++)
		{
			if(!round) {		
				
				if (Main.getTripList().get(k).getSource().equals(source) && Main.getTripList().get(k).getDestination().equals(Destination) && yearDate1 <= Main.getTripList().get(k).year && yearDate2 >= Main.getTripList().get(k).year){
					
					if(Main.getTripList().get(k).year == yearDate1) {
						if(Main.getTripList().get(k).month < monthDate1)
							break;
						else if(Main.getTripList().get(k).month == monthDate1)
							if(Main.getTripList().get(k).day < dayDate1)
								break;
					}
					
					if(Main.getTripList().get(k).year == yearDate2) {
						if(Main.getTripList().get(k).month > monthDate2)
							break;
						else if(Main.getTripList().get(k).month == monthDate2)
							if(Main.getTripList().get(k).day > dayDate2)
								break;
					}
					
					textArea.append(Main.getTripList().get(k).getTripCode() + " : " + Main.getTripList().get(k).getSource() + " To " + Main.getTripList().get(k).getDestination() + " On (" + Main.getTripList().get(k).day + " " + Main.getTripList().get(k).month + " " + Main.getTripList().get(k).year + ") - ");
					
					if(Main.getTripList().get(k).getTripFlavor() == 0)
						textArea.append(" (No Stops) ");
					else if(Main.getTripList().get(k).getTripFlavor() == 1)
						textArea.append(" (One Stop) ");
					else
						textArea.append(" (Multi Stops) ");
					
					textArea.append("For $" + Main.getTripList().get(k).getPrice() + " " + Main.getTripList().get(k).availableSeats + "/" + Main.getTripList().get(k).seats + " seats");
					
					if(Main.getTripList().get(k).driver == null) 
						textArea.append(" ~ No assigned driver yet. \n");
					else
						textArea.append(" ~ " + Main.getTripList().get(k).driver + " \n");
					
				}
			}
			else if(round) {
				
				if (((Main.getTripList().get(k).getSource().equals(source) && Main.getTripList().get(k).getDestination().equals(Destination)) || (Main.getTripList().get(k).getSource().equals(Destination) && Main.getTripList().get(k).getDestination().equals(source))) && yearDate1 <= Main.getTripList().get(k).year && yearDate2 >= Main.getTripList().get(k).year){
					
					if(Main.getTripList().get(k).year == yearDate1) {
						if(Main.getTripList().get(k).month < monthDate1)
							break;
						else if(Main.getTripList().get(k).month == monthDate1)
							if(Main.getTripList().get(k).day < dayDate1)
								break;
					}
					
					if(Main.getTripList().get(k).year == yearDate2) {
						if(Main.getTripList().get(k).month > monthDate2)
							break;
						else if(Main.getTripList().get(k).month == monthDate2)
							if(Main.getTripList().get(k).day > dayDate2)
								break;
					}
					
					textArea.append(Main.getTripList().get(k).getTripCode() + " : " + Main.getTripList().get(k).getSource() + " To " + Main.getTripList().get(k).getDestination() + " On (" + Main.getTripList().get(k).day + " " + Main.getTripList().get(k).month + " " + Main.getTripList().get(k).year + ") - ");
					
					if(Main.getTripList().get(k).getTripFlavor() == 0)
						textArea.append(" (No Stops) ");
					else if(Main.getTripList().get(k).getTripFlavor() == 1)
						textArea.append(" (One Stop) ");
					else
						textArea.append(" (Multi Stops) ");
					
					textArea.append("For $" + Main.getTripList().get(k).getPrice() + " " + Main.getTripList().get(k).availableSeats + "/" + Main.getTripList().get(k).seats + " seats");
					
					if(Main.getTripList().get(k).driver == null) 
						textArea.append(" ~ No assigned driver yet. \n");
					else
						textArea.append(" ~ " + Main.getTripList().get(k).driver + " \n");
					
				}
			}
		}
	}
}
