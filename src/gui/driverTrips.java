package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.TextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import Users.Driver;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class driverTrips {
	
	private static final long serialVersionUID = 1L;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					driverTrips window = new driverTrips();
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
	public driverTrips() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 654, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DriverPage.main(null);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnBack.setBounds(12, 215, 97, 25);
		frame.getContentPane().add(btnBack);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(115, 51, 509, 189);
		frame.getContentPane().add(textArea);
		
		JLabel lblMyTrips = new JLabel("My Trips");
		lblMyTrips.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMyTrips.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMyTrips.setBounds(309, 13, 315, 25);
		frame.getContentPane().add(lblMyTrips);
		
		int k;
		for (k=0 ; k < Main.getTripList().size(); k++) {
			if (Main.getTripList().get(k).driver ==null) {
				;
			}
			
			else if (Main.getTripList().get(k).driver.equals(Main.getdriversList().get(Driver.i).getUsername())) {
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
