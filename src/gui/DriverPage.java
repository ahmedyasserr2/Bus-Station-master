package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import Users.Driver;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;

public class DriverPage {
	
	private static final long serialVersionUID = 1L;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DriverPage window = new DriverPage();
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
	public DriverPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 473, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setBounds(22, 71, 91, 23);
		frame.getContentPane().add(lblName);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login Login = new login();
				Login.frame.setVisible(true);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnLogOut.setBounds(346, 217, 97, 23);
		frame.getContentPane().add(btnLogOut);
		
		JLabel lblDriverAccount = new JLabel("Driver Account");
		lblDriverAccount.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDriverAccount.setBounds(151, 13, 165, 37);
		frame.getContentPane().add(lblDriverAccount);
		
		JLabel lblRating = new JLabel("Rating:");
		lblRating.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRating.setBounds(22, 145, 91, 23);
		frame.getContentPane().add(lblRating);
		
		JLabel nameLabel = new JLabel(Main.getdriversList().get(Driver.i).fName + " " + Main.getdriversList().get(Driver.i).lName );
		nameLabel.setForeground(SystemColor.text);
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nameLabel.setBounds(125, 71, 203, 23);
		frame.getContentPane().add(nameLabel);
		
		JLabel RatingLabel = new JLabel(Float.toString(Main.getdriversList().get(Driver.i).getRating()));
		RatingLabel.setForeground(Color.WHITE);
		RatingLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		RatingLabel.setBounds(125, 145, 203, 23);
		frame.getContentPane().add(RatingLabel);
		
		JButton btnViewAssignedTrips = new JButton("Trips\r\n");
		btnViewAssignedTrips.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				driverTrips.main(null);
				frame.setVisible(false);			
			}
		});
		btnViewAssignedTrips.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnViewAssignedTrips.setBackground(UIManager.getColor("Button.background"));
		btnViewAssignedTrips.setBounds(346, 71, 97, 132);
		frame.getContentPane().add(btnViewAssignedTrips);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(22, 109, 91, 23);
		frame.getContentPane().add(lblUsername);
		
		JLabel usernamelbl = new JLabel(Main.getdriversList().get(Driver.i).getUsername());
		usernamelbl.setForeground(Color.WHITE);
		usernamelbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		usernamelbl.setBounds(125, 109, 203, 23);
		frame.getContentPane().add(usernamelbl);
		
		JLabel label_2 = new JLabel(Integer.toString(Main.getdriversList().get(Driver.i).numOfTrips));
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_2.setBounds(125, 180, 203, 23);
		frame.getContentPane().add(label_2);
		
		JLabel lblNbOfTrips = new JLabel("Trips:");
		lblNbOfTrips.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNbOfTrips.setBounds(22, 180, 91, 23);
		frame.getContentPane().add(lblNbOfTrips);
	}
}
