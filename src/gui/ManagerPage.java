package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import System.Bus.busType;
import Users.Manager;

import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.TextArea;
import java.awt.Color;
import java.awt.Font;

public class ManagerPage {
	
	private static final long serialVersionUID = 1L;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerPage window = new ManagerPage();
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
	public ManagerPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 869, 547);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel nameLabel = new JLabel(Main.getmanagersList().get(Manager.i).fName + " " + Main.getmanagersList().get(Manager.i).lName);
		nameLabel.setForeground(SystemColor.text);
		nameLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nameLabel.setBounds(192, 13, 399, 35);
		frame.getContentPane().add(nameLabel);
		
		TextArea textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setBackground(Color.WHITE);
		textArea.setBounds(192, 105, 649, 370);
		frame.getContentPane().add(textArea);
		
		JLabel emailLabel = new JLabel(Main.getmanagersList().get(Manager.i).getEmail());
		emailLabel.setForeground(SystemColor.text);
		emailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		emailLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		emailLabel.setBounds(192, 57, 421, 35);
		frame.getContentPane().add(emailLabel);
		
		JButton viewClientsButton = new JButton("View Clients");
		viewClientsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(null);
				int k;
				for(k=0 ; k<Main.getPassengersList().size() ; k++)
				{
					textArea.append("(" + (k+1) + ") " + Main.getPassengersList().get(k).fName + " " +  Main.getPassengersList().get(k).lName + " - " +  Main.getPassengersList().get(k).getUsername() + " - " + Main.getPassengersList().get(k).getEmail() + " (" +  Main.getPassengersList().get(k).age + " years) - " +  Main.getPassengersList().get(k).numOfTrips + " Trips\n");
				}
			}
		});
		viewClientsButton.setBounds(32, 200, 125, 35);
		frame.getContentPane().add(viewClientsButton);
		
		JButton viewTripsButton = new JButton("View Trips");
		viewTripsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText(null);
				int k;
				for(k=0 ; k<Main.getTripList().size() ; k++)
				{
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
		});
		viewTripsButton.setBounds(32, 296, 125, 35);
		frame.getContentPane().add(viewTripsButton);
		
		JButton assignDriversButton = new JButton("Assign Drivers");
		assignDriversButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int x,y;
				
				String code = JOptionPane.showInputDialog(" Please enter Trip Code");
				if(code == null)
					return;
				
				int trip = Integer.parseInt(code);
				for(x=0 ; x<Main.getTripList().size() ; x++) {
					if (Main.getTripList().get(x).getTripCode() == trip)
						break;
				}
				if(x == Main.getTripList().size()) {
					JOptionPane.showMessageDialog(null, "Inavailable Trip Code");
					return;
				}
				
				
				String driver = JOptionPane.showInputDialog(" Please enter Driver Username");
				for(y=0 ; y<Main.getdriversList().size() ; y++) {
					if(Main.getdriversList().get(y).getUsername().equals(driver))
						break;
				}
				if(y == Main.getdriversList().size()) {
					JOptionPane.showMessageDialog(null, "Inavailable Driver Name");
					return;
				}
				
				Main.getTripList().get(x).driver = Main.getdriversList().get(y).getUsername();
				Main.getdriversList().get(y).numOfTrips++;
				Main.save();
				
			}
		});
		assignDriversButton.setBounds(32, 153, 125, 35);
		frame.getContentPane().add(assignDriversButton);
		
		JButton signOutButton = new JButton("Signout");
		signOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login Login = new login();
				Login.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		signOutButton.setBounds(32, 440, 125, 35);
		frame.getContentPane().add(signOutButton);
		
		JButton addButton = new JButton("Add Trips");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTrip.main(null);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		addButton.setBounds(32, 105, 125, 35);
		frame.getContentPane().add(addButton);
		
		JButton deleteTrips = new JButton("Delete Trips");
		deleteTrips.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code = JOptionPane.showInputDialog("Please enter trip Code");
				if(code == null)
					return;
				int k,t,q,r;
				for (k=0 ; k < Main.getTripList().size(); k++) {
					if (Main.getTripList().get(k).getTripCode() == Integer.parseInt(code)) {
						
						for(t=0 ; t<Main.getdriversList().size() ; t++) {
							if(Main.getdriversList().get(t).getUsername().equals(Main.getTripList().get(k).driver)) {
								Main.getdriversList().get(t).numOfTrips--;
								break;
							}
						}
						
						for(q=0 ; q<Main.getTicketList().size() ; q++) {
							if(Main.getTicketList().get(q).getTripCode() == (Main.getTripList().get(k).getTripCode())){
								for(r=0 ; r< Main.getPassengersList().size() ; r++) {
									if(Main.getPassengersList().get(r).getUsername().equals(Main.getTicketList().get(q).getClientName())){
										Main.getPassengersList().get(r).setDeleted(true);
										Main.getPassengersList().get(r).numOfTrips--;
									}
								}
								Main.getTicketList().remove(q);
							}
						}
						
						Main.getTripList().remove(k);
						Main.save();
						JOptionPane.showMessageDialog(null, "Trip Deleted Successfully");
						textArea.setText(null);
						return;
					}
				}
				JOptionPane.showMessageDialog(null, "Invalid Trip Code");

			}
		});
		deleteTrips.setBounds(32, 392, 125, 35);
		frame.getContentPane().add(deleteTrips);
		
		JButton busButton = new JButton("View Busses");
		busButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(null);
				int k;
				for(k=0 ; k<Main.getBusList().size() ; k++)
				{
					textArea.append(Main.getBusList().get(k).getBusCode() + " : " + Main.getBusList().get(k).getNumOfSeats() + " Seats");
					if(Main.getBusList().get(k).getType() == busType.BUS)
						textArea.append(" - Bus.\n");
					else if (Main.getBusList().get(k).getType() == busType.MINIBUS)
						textArea.append(" - MiniBus.\n");
					else 
						textArea.append(" - Limousine. \n");
				}
			}
		});
		busButton.setBounds(32, 344, 125, 35);
		frame.getContentPane().add(busButton);
		
		JButton driversButton = new JButton("View Drivers");
		driversButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(null);
				int k;
				for(k=0 ; k<Main.getdriversList().size() ; k++)
				{
					textArea.append("(" + (k+1) + ") " +  Main.getdriversList().get(k).fName + " " + Main.getdriversList().get(k).lName + " - " + Main.getdriversList().get(k).getUsername() + " - " + Main.getdriversList().get(k).getEmail() + " (Rating: " + Main.getdriversList().get(k).getRating()+ "/5) - [" + Main.getdriversList().get(k).numOfTrips +  " Trips] \n");
				}
			}
		});
		driversButton.setBounds(32, 248, 125, 35);
		frame.getContentPane().add(driversButton);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setBounds(32, 13, 148, 35);
		frame.getContentPane().add(lblName);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmail.setBounds(32, 57, 148, 35);
		frame.getContentPane().add(lblEmail);
	}
}
