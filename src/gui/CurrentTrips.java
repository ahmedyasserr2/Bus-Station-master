package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

import Users.Passenger;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;

public class CurrentTrips {
	
	private static final long serialVersionUID = 1L;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CurrentTrips window = new CurrentTrips();
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
	public CurrentTrips() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 620, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		int i;
		for(i=0 ; i<Main.getPassengersList().size() ; i++) {
			/*if (Passenger.bookedTrip(i))
				list.add("Trip Code: " + Integer.toString(Main.getTicketList().get(i).getTripCode()), list);*/
		}
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CustomerPage.main(null);
				frame.setVisible(false);
			}
		});
		back.setBounds(20, 204, 113, 36);
		frame.getContentPane().add(back);
		
		JButton cancelTrip = new JButton("Cancel A Trip");
		cancelTrip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code = JOptionPane.showInputDialog("Please enter trip Code");
				if(code == null)
					return;
				int k,l;
				for (k=0 ; k < Main.getTicketList().size(); k++) {
					if (Main.getTicketList().get(k).getTripCode() == Integer.parseInt(code)) {
						
						Main.getTicketList().remove(k);
						Main.getPassengersList().get(Passenger.i).numOfTrips--;
						for (l=0 ; l < Main.getTripList().size(); l++) {
							if (Main.getTripList().get(l).getTripCode() == Integer.parseInt(code)) {
								Main.getTripList().get(l).availableSeats++;
								break;
							}
						}
						
						Main.save();
						JOptionPane.showMessageDialog(null, "Trip Cancelled Successfully");
						return;
					}
				}
				
				JOptionPane.showMessageDialog(null, "Invalid Trip Code");
				
			}
		});
		cancelTrip.setBounds(20, 155, 113, 36);
		frame.getContentPane().add(cancelTrip);
		
		TextArea textArea = new TextArea();
		textArea.setBackground(SystemColor.text);
		textArea.setEditable(false);
		textArea.setBounds(160, 13, 432, 227);
		frame.getContentPane().add(textArea);
		
		JLabel label = new JLabel("Book A Trip");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(20, 13, 106, 39);
		frame.getContentPane().add(label);
		
		int m,n;
		for(m=0 ; m < Main.getTicketList().size() ; m ++) {
			if(Main.getTicketList().get(m).getClientName().equals(Main.getPassengersList().get(Passenger.i).getUsername())){
				for(n=0 ; n<Main.getTripList().size() ; n ++) {
					if(Main.getTripList().get(n).getTripCode() == Main.getTicketList().get(m).getTripCode()) {
						textArea.append(Main.getTripList().get(n).getTripCode() + " : " + Main.getTripList().get(n).getSource() + " To " + Main.getTripList().get(n).getDestination() + " On (" + Main.getTripList().get(n).day + " " + Main.getTripList().get(n).month + " " + Main.getTripList().get(n).year + ") - ");
						
						if(Main.getTripList().get(n).getTripFlavor() == 0)
							textArea.append(" (No Stops) ");
						else if(Main.getTripList().get(n).getTripFlavor() == 1)
							textArea.append(" (One Stop) ");
						else
							textArea.append(" (Multi Stops) ");
						
						textArea.append("For $" + Main.getTripList().get(n).getPrice() + " ");
						
						if(Main.getTripList().get(n).driver == null) 
							textArea.append(" ~ No assigned driver yet. \n");
						else
							textArea.append(" ~ " + Main.getTripList().get(n).driver + " \n");
						
					}
				}
			}
		}
	}
}
