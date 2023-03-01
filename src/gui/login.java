package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import Users.Driver;
import Users.Manager;
import Users.Passenger;
import java.awt.SystemColor;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

public class login extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static JFrame frame;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private ButtonGroup bg= new ButtonGroup();

	/**
	 * Create the application.
	 */
	
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 601, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		usernameLabel.setBounds(326, 51, 88, 23);
		frame.getContentPane().add(usernameLabel);
		
		usernameField = new JTextField();
		usernameField.setBounds(326, 75, 200, 30);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		JButton loginButton = new JButton("Login");
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		loginButton.setBounds(326, 234, 200, 30);
		frame.getContentPane().add(loginButton);
		
		JLabel passLabel = new JLabel("Password");
		passLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passLabel.setBounds(326, 140, 88, 23);
		frame.getContentPane().add(passLabel);
		
		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						register frameReg = new register();
						frameReg.setVisible(true);
						frame.setVisible(false);
					} catch (Exception e2) {
						e2.printStackTrace();
					}
			}
		});
		registerButton.setBounds(381, 277, 97, 25);
		frame.getContentPane().add(registerButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(326, 163, 200, 30);
		frame.getContentPane().add(passwordField);
		
		JRadioButton passengerButton = new JRadioButton("Client");
		passengerButton.setBackground(SystemColor.activeCaption);
		passengerButton.setBounds(27, 223, 109, 23);
		frame.getContentPane().add(passengerButton);
		
		JRadioButton driverButton = new JRadioButton("Driver");
		driverButton.setBackground(SystemColor.activeCaption);
		driverButton.setBounds(27, 251, 109, 23);
		frame.getContentPane().add(driverButton);
		
		JRadioButton managerButton = new JRadioButton("Manager");
		managerButton.setBackground(SystemColor.activeCaption);
		managerButton.setBounds(27, 279, 109, 23);
		frame.getContentPane().add(managerButton);
		
		bg.add(passengerButton);
		bg.add(driverButton);
		bg.add(managerButton);
		

		
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(driverButton.isSelected()) {
					Driver driver = new Driver();
					if(driver.login(usernameField.getText(), new String(passwordField.getPassword()))) {
						DriverPage.main(null);
						frame.setVisible(false);
					}
					else
						JOptionPane.showMessageDialog(null, "Wrong Username or Password");
				}
				
				else if ( passengerButton.isSelected() ) {
					Passenger passenger = new Passenger();
					if(passenger.login(usernameField.getText(), new String(passwordField.getPassword()))) {
						if(Main.getPassengersList().get(Passenger.i).isDeleted()) {
							JOptionPane.showMessageDialog(null, "A trip you booked was deleted, please review your trips.");
							Main.getPassengersList().get(Passenger.i).setDeleted(false);
						}
						CustomerPage.main(null);
						frame.setVisible(false);
					}
					else
						JOptionPane.showMessageDialog(null, "Wrong Username or Password");
				}
				
				else if (managerButton.isSelected()) {
					Manager manager = new Manager();
					if(manager.login(usernameField.getText(), new String(passwordField.getPassword()))) {
						ManagerPage.main(null);
						frame.setVisible(false);
					}
					else
						JOptionPane.showMessageDialog(null, "Wrong Username or Password");
				}
				else
					JOptionPane.showMessageDialog(null, "No field checked");
			}
		}
		);
		
		Image img = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		
		JLabel imgLabel = new JLabel("");
		imgLabel.setIcon(new ImageIcon(img.getScaledInstance(246, 162, Image.SCALE_DEFAULT)));
		imgLabel.setBounds(27, 51, 246, 162);
		frame.getContentPane().add(imgLabel);
	}
}
