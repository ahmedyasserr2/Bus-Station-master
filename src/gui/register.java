package gui;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Users.Driver;
import Users.Manager;
import Users.Passenger;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class register extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField firstNameField;
	private JTextField emailField;
	private JTextField usernameField;
	private JTextField lastNameField;
	private JTextField passField1;
	private JTextField passField2;
	
	public String firstName;
	public String lastName;
	public String pass1;
	public String pass2;
	public String email;
	public boolean isEmpty;
	private JTextField ageField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	/**
	 * Create the frame.
	 */
	public register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 536);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		firstNameField = new JTextField();
		firstNameField.setBounds(51, 51, 132, 30);
		contentPane.add(firstNameField);
		firstNameField.setColumns(10);
		
		JLabel fNameLabel = new JLabel("First Name");
		fNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fNameLabel.setBounds(51, 25, 103, 24);
		contentPane.add(fNameLabel);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(51, 113, 300, 30);
		contentPane.add(emailField);
		
		JLabel emailLabel = new JLabel("E-mail");
		emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		emailLabel.setBounds(51, 87, 103, 24);
		contentPane.add(emailLabel);
		
		usernameField = new JTextField();
		usernameField.setColumns(10);
		usernameField.setBounds(51, 182, 214, 30);
		contentPane.add(usernameField);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(51, 156, 103, 24);
		contentPane.add(lblUsername);
		
		lastNameField = new JTextField();
		lastNameField.setColumns(10);
		lastNameField.setBounds(219, 51, 132, 30);
		contentPane.add(lastNameField);
		
		JLabel lNameLabel = new JLabel("Last Name");
		lNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lNameLabel.setBounds(219, 25, 103, 24);
		contentPane.add(lNameLabel);
		
		passField1 = new JTextField();
		passField1.setToolTipText("");
		passField1.setColumns(10);
		passField1.setBounds(51, 243, 300, 30);
		contentPane.add(passField1);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(51, 217, 103, 24);
		contentPane.add(lblPassword);
		
		passField2 = new JTextField();
		passField2.setColumns(10);
		passField2.setBounds(51, 307, 300, 30);
		contentPane.add(passField2);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConfirmPassword.setBounds(51, 281, 132, 24);
		contentPane.add(lblConfirmPassword);
		
		JLabel ageLabel = new JLabel("Age");
		ageLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ageLabel.setBounds(304, 156, 47, 24);
		contentPane.add(ageLabel);
		
		ageField = new JTextField();
		ageField.setColumns(10);
		ageField.setBounds(304, 182, 47, 30);
		contentPane.add(ageField);
		
		JButton registerButton = new JButton("Register");
		registerButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		registerButton.setBounds(254, 438, 97, 30);
		contentPane.add(registerButton);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.frame.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		backButton.setBounds(51, 438, 65, 30);
		contentPane.add(backButton);
		
		JRadioButton passengerButton = new JRadioButton("Passenger");
		buttonGroup.add(passengerButton);
		passengerButton.setBackground(SystemColor.activeCaption);
		passengerButton.setBounds(56, 346, 127, 25);
		contentPane.add(passengerButton);
		
		JRadioButton managerButton = new JRadioButton("Manager");
		buttonGroup.add(managerButton);
		managerButton.setBackground(SystemColor.activeCaption);
		managerButton.setBounds(56, 374, 127, 25);
		contentPane.add(managerButton);
		
		JRadioButton driverButton = new JRadioButton("Driver");
		buttonGroup.add(driverButton);
		driverButton.setBackground(SystemColor.activeCaption);
		driverButton.setBounds(56, 404, 127, 25);
		contentPane.add(driverButton);
		
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				isEmpty = false;
				
				if(firstNameField.getText().isEmpty()) {
					isEmpty = true;
					firstNameField.setForeground(Color.RED);
					fNameLabel.setForeground(Color.RED);
				} else {
					firstNameField.setForeground(Color.BLACK);
					fNameLabel.setForeground(Color.BLACK);
				}


				if(lastNameField.getText().isEmpty()) {
					isEmpty = true;
					lastNameField.setForeground(Color.RED);
					lNameLabel.setForeground(Color.RED);
				} else {
					lastNameField.setForeground(Color.BLACK);
					lNameLabel.setForeground(Color.BLACK);
				}

				
				if(emailField.getText().isEmpty()) {
					isEmpty = true;
					emailField.setForeground(Color.RED);
					emailLabel.setForeground(Color.RED);
				} else {
					emailField.setForeground(Color.BLACK);
					emailLabel.setForeground(Color.BLACK);
				}

				
				if(usernameField.getText().isEmpty()) {
					isEmpty = true;
					usernameField.setForeground(Color.RED);
					lblUsername.setForeground(Color.RED);
				} else {
					usernameField.setForeground(Color.BLACK);
					lblUsername.setForeground(Color.BLACK);

				}
				
				if(ageField.getText().isEmpty()) {
					isEmpty = true;
					ageField.setForeground(Color.RED);
					ageLabel.setForeground(Color.RED);
				} else {
					ageField.setForeground(Color.BLACK);
					ageLabel.setForeground(Color.BLACK);
				}

				
				if(passField1.getText().isEmpty() || passField2.getText().isEmpty() || !(passField1.getText().equals(passField2.getText()))) {
					isEmpty = true;
					passField1.setForeground(Color.RED);
					passField2.setForeground(Color.RED);
					lblPassword.setForeground(Color.RED);
					lblConfirmPassword.setForeground(Color.RED);

				} else {
					passField1.setForeground(Color.BLACK);
					passField2.setForeground(Color.BLACK);
					lblPassword.setForeground(Color.BLACK);
					lblConfirmPassword.setForeground(Color.BLACK);
				}
				
				if(isEmpty) {
					return;
				}
				
				else {
					
					if(driverButton.isSelected()) {
						Driver driverTemp = new Driver();
						if(driverTemp.check(usernameField.getText()) || driverTemp.checkMail(emailField.getText())) {
							JOptionPane.showMessageDialog(null, "Username or Email already used.");
							return;
						}
						
						Driver driver = new Driver();
						driver.fName = firstNameField.getText();
						driver.lName = lastNameField.getText();
						driver.setUsername(usernameField.getText());
						driver.setPassword(passField1.getText());
						driver.age = Integer.parseInt(ageField.getText());
						driver.setEmail(emailField.getText());
						driver.numOfTrips = 0;
						driver.setRating(0);
						
						System.out.println("Driver Registered");
						
						Main.getdriversList().add(driver);
						Main.writeToFileDriversList();
						
						login.frame.setVisible(true);
						setVisible(false);
						dispose();
						
					}
					
					else if ( passengerButton.isSelected() ) {
						Passenger passengerTemp = new Passenger();
						if(passengerTemp.check(usernameField.getText()) || passengerTemp.checkMail(emailField.getText())) {
							JOptionPane.showMessageDialog(null, "Username or Email already used.");
							return;
						}
						
						Passenger passenger = new Passenger();
						passenger.fName = firstNameField.getText();
						passenger.lName = lastNameField.getText();
						passenger.setUsername(usernameField.getText());
						passenger.setPassword(passField1.getText());
						passenger.setEmail(emailField.getText());
						passenger.age = Integer.parseInt(ageField.getText());
						
						System.out.println("Passenger Registered");
						
						Main.getPassengersList().add(passenger);
						Main.writeToFilePassengersList();
						
						login.frame.setVisible(true);
						setVisible(false);
						dispose();
					}
					
					else if (managerButton.isSelected()) {
						Manager managerTemp = new Manager();
						if(managerTemp.check(usernameField.getText()) || managerTemp.checkMail(emailField.getText())) {
							JOptionPane.showMessageDialog(null, "Username or Email already used.");
							return;
						}
						
						Manager manager = new Manager();
						manager.fName = firstNameField.getText();
						manager.lName = lastNameField.getText();
						manager.setUsername(usernameField.getText());
						manager.setPassword(passField1.getText());
						manager.setEmail(emailField.getText());
						manager.age = Integer.parseInt(ageField.getText());
						
						System.out.println("Manager Registered");
						
						Main.getmanagersList().add(manager);
						Main.writeToFileManagersList();
						
						login.frame.setVisible(true);
						setVisible(false);
						dispose();
					}
					else
						JOptionPane.showMessageDialog(null,"No field checked");
				}				
			}
		});
	}
}
