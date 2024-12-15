import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Next_of_Kin extends JFrame {

	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {

		EventQueue.invokeLater(() -> {
			try {
				Next_of_Kin frame = new Next_of_Kin();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();

			}
		});
	}


	public Next_of_Kin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setBounds(100, 100, 755, 419); 
		setResizable(false);
		JPanel contentPane = new JPanel(); 
		contentPane.setBackground(new Color(54, 85, 142)); 
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); 
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel Patient_id_label = new JLabel("Patient ID :");
		Patient_id_label.setForeground(new Color(5, 5, 5));
		Patient_id_label.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
		Patient_id_label.setBounds(67, 106, 97, 16);
		contentPane.add(Patient_id_label);

		JTextField Patient_ID = new JTextField();
		Patient_ID.setText("ID Number");
		Patient_ID.setFont(new Font("Charter", Font.BOLD, 13));
		Patient_ID.setColumns(10);
		Patient_ID.setBackground(new Color(189, 193, 199));
		Patient_ID.setBounds(161, 99, 192, 34);
		contentPane.add(Patient_ID);

		Patient_ID.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if(Patient_ID.getText().equals("ID Number")) {
					Patient_ID.setText("");
					Patient_ID.setForeground(new Color(110, 120, 128));
				}
			}

			public void focusLost(FocusEvent e) {
				if(Patient_ID.getText().equals("")) {
					Patient_ID.setText("ID Number");
					Patient_ID.setForeground(new Color(110, 120, 128));
				}
			}

		});


		JTextField First_Name = new JTextField();
		First_Name.setFont(new Font("Charter", Font.BOLD, 13));
		First_Name.setBackground(new Color(189, 193, 199));
		First_Name.setText("First Name");
		First_Name.setBounds(57, 148, 142, 34);
		contentPane.add(First_Name);
		First_Name.setColumns(10);

		First_Name.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if(First_Name.getText().equals("First Name")) {
					First_Name.setText("");
					First_Name.setForeground(new Color(110, 120, 128));
				}
			}

			public void focusLost(FocusEvent e) {
				if(First_Name.getText().equals("")) {
					First_Name.setText("First Name");
					First_Name.setForeground(new Color(110, 120, 128));
				}
			}

		});


		JTextField Surname = new JTextField();
		Surname.setFont(new Font("Charter", Font.BOLD, 13));
		Surname.setText("Surname");
		Surname.setColumns(10);
		Surname.setBackground(new Color(189, 193, 199));
		Surname.setBounds(211, 148, 142, 34);
		contentPane.add(Surname);

		Surname.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if(Surname.getText().equals("Surname")) {
					Surname.setText("");
					Surname.setForeground(new Color(110, 120, 128));
				}
			}

			public void focusLost(FocusEvent e) {
				if(Surname.getText().equals("")) {
					Surname.setText("Surname");
					Surname.setForeground(new Color(110, 120, 128));
				}
			}

		});

		JTextField Date_of_birth = new JTextField();
		Date_of_birth.setText("Date of birth");
		Date_of_birth.setFont(new Font("Charter", Font.BOLD, 13));
		Date_of_birth.setColumns(10);
		Date_of_birth.setBackground(new Color(189, 193, 199));
		Date_of_birth.setBounds(57, 205, 142, 34);
		contentPane.add(Date_of_birth);

		Date_of_birth.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				
				if(Date_of_birth.getText().equals("Date of birth")) {
					Date_of_birth.setText("");
					Date_of_birth.setForeground(new Color(110, 120, 128));
				}
			}

			public void focusLost(FocusEvent e) {
				if(Date_of_birth.getText().equals("")) {
					Date_of_birth.setText("Date of birth");
					Date_of_birth.setForeground(new Color(110, 120, 128));
					} else {

						SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
						format.setLenient(false); 
						try {
							format.parse(Date_of_birth.getText());

						} catch (ParseException pe) {

							JOptionPane.showMessageDialog(null, "Please enter the date in MM/dd/yyyy format.", "Invalid Date Format", JOptionPane.ERROR_MESSAGE);
							Date_of_birth.setText("Date of birth");
							Date_of_birth.setForeground(new Color(110, 120, 128));
						}}
				
			}});
		JTextField Phone_number = new JTextField();
		Phone_number.setText("Phone number");
		Phone_number.setFont(new Font("Charter", Font.BOLD, 13));
		Phone_number.setColumns(10);
		Phone_number.setBackground(new Color(189, 193, 199));
		Phone_number.setBounds(211, 205, 142, 34);
		contentPane.add(Phone_number);

		Phone_number.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if(Phone_number.getText().equals("Phone number")) {
					Phone_number.setText("");
					Phone_number.setForeground(new Color(110, 120, 128));
				}
			}

			public void focusLost(FocusEvent e) {
				if(Phone_number.getText().equals("")) {
					Phone_number.setText("Phone number");
					Phone_number.setForeground(new Color(110, 120, 128));
				}
			}

		});

		JTextField Email = new JTextField();
		Email.setText("Email");
		Email.setFont(new Font("Charter", Font.BOLD, 13));
		Email.setColumns(10);
		Email.setBackground(new Color(189, 193, 199));
		Email.setBounds(57, 260, 142, 34);
		contentPane.add(Email);

		Email.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if(Email.getText().equals("Email")) {
					Email.setText("");
					Email.setForeground(new Color(110, 120, 128));
				}
			}

			public void focusLost(FocusEvent e) {
				if(Email.getText().equals("")) {
					Email.setText("Email");
					Email.setForeground(new Color(110, 120, 128));
				}
			}

		});



		JTextField House_number = new JTextField();
		House_number.setText("House number");
		House_number.setFont(new Font("Charter", Font.BOLD, 13));
		House_number.setColumns(10);
		House_number.setBackground(new Color(189, 193, 199));
		House_number.setBounds(211, 260, 142, 34);
		contentPane.add(House_number);

		House_number.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if(House_number.getText().equals("House number")) {
					House_number.setText("");
					House_number.setForeground(new Color(110, 120, 128));
				}
			}

			public void focusLost(FocusEvent e) {
				if(House_number.getText().equals("")) {
					House_number.setText("House number");
					House_number.setForeground(new Color(110, 120, 128));
				}
			}

		});

		JTextField Street_Name = new JTextField();
		Street_Name.setText("Street Name");
		Street_Name.setFont(new Font("Charter", Font.BOLD, 13));
		Street_Name.setColumns(10);
		Street_Name.setBackground(new Color(189, 193, 199));
		Street_Name.setBounds(384, 148, 300, 34);
		contentPane.add(Street_Name);
		Street_Name.addFocusListener(new FocusAdapter() {

			public void focusGained(FocusEvent e) {
				if(Street_Name.getText().equals("Street Name")) {
					Street_Name.setText("");
					Street_Name.setForeground(new Color(110, 120, 128));
				}
			}

			public void focusLost(FocusEvent e) {
				if(Street_Name.getText().equals("")) {
					Street_Name.setText("Street Name");
					Street_Name.setForeground(new Color(110, 120, 128));
				}
			}

		});

		JTextField City = new JTextField();
		City.setText("City");
		City.setFont(new Font("Charter", Font.BOLD, 13));
		City.setColumns(10);
		City.setBackground(new Color(189, 193, 199));
		City.setBounds(384, 205, 300, 34);
		contentPane.add(City);

		City.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if(City.getText().equals("City")) {
					City.setText("");
					City.setForeground(new Color(110, 120, 128));
				}
			}

			public void focusLost(FocusEvent e) {
				if(City.getText().equals("")) {
					City.setText("City");
					City.setForeground(new Color(110, 120, 128));
				}
			}

		});

		JTextField Postal_Code = new JTextField();
		Postal_Code.setText("Postal Code");
		Postal_Code.setFont(new Font("Charter", Font.BOLD, 13));
		Postal_Code.setColumns(10);
		Postal_Code.setBackground(new Color(189, 193, 199));
		Postal_Code.setBounds(384, 260, 300, 34);
		contentPane.add(Postal_Code);

		Postal_Code.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if(Postal_Code.getText().equals("Postal Code")) {
					Postal_Code.setText("");
					Postal_Code.setForeground(new Color(110, 120, 128));
				}
			}

			public void focusLost(FocusEvent e) {
				if(Postal_Code.getText().equals("")) {
					Postal_Code.setText("Postal Code");
					Postal_Code.setForeground(new Color(110, 120, 128));
				}
			}

		});

		JButton Confirm_button = new JButton("Confirm");
		Confirm_button.setBackground(new Color(160, 182, 199));
		Confirm_button.setForeground(new Color(0, 0, 0));
		Confirm_button.setBounds(331, 351, 117, 29);
		contentPane.add(Confirm_button);

		JLabel backroundImage = new JLabel("");
		backroundImage.setIcon(new ImageIcon("/Users/macbook/Documents/Group_Project_Implementation/img/special for next of kin _resized.png"));
		backroundImage.setBounds(0, 6, 755, 385);
		contentPane.add(backroundImage);

		// Adding a pop up message box to confirm button 
		Confirm_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// here we are cheaking if any of the text fields are empty or contain their placeholder text

				if

				(Patient_ID.getText().isEmpty() || Patient_ID.getText().equals("ID Number") ||
						First_Name.getText().isEmpty() || First_Name.getText().equals("First Name") ||

						Surname.getText().isEmpty() || Surname.getText().equals("Surname") ||

						Date_of_birth.getText().isEmpty() || Date_of_birth.getText().equals("Date of birth") ||

						Email.getText().isEmpty() || Email.getText().equals("Email") ||

						House_number.getText().isEmpty() || House_number.getText().equals("House number") ||

						City.getText().isEmpty() || City.getText().equals("City") ||

						Postal_Code.getText().isEmpty() || Postal_Code.getText().equals("Postal Code") ||

						Street_Name.getText().isEmpty() || Street_Name.getText().equals("Street Name") ||

						Phone_number.getText().isEmpty() || Phone_number.getText().equals("Phone Number")) {

					// Show an error message if any field is not properly filled out

					JOptionPane.showMessageDialog(null, "Error: Please fill out all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
				} else {


					String insertt = "INSERT INTO nextofkin (idNumber, firstName, lastName, dateofbirth, phonenumber, email, housenumber, streetname, city, postalcode) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
					try (Connection connect = Database.databaseConn(); PreparedStatement prepare = connect.prepareStatement(insertt)) {
						prepare.setString(1, Patient_ID.getText());
						prepare.setString(2, First_Name.getText());
						prepare.setString(3, Surname.getText());
						prepare.setString(4, Date_of_birth.getText());
						prepare.setString(5, Phone_number.getText());
						prepare.setString(6, Email.getText());
						prepare.setString(7, House_number.getText());
						prepare.setString(8, Street_Name.getText());
						prepare.setString(9, City.getText());
						prepare.setString(10, Postal_Code.getText());
						prepare.executeUpdate();

						// Show success message with random number and check for user response
						int option = JOptionPane.showConfirmDialog(null, "Data saved successfully. " + ". Click OK to go to the homepage.", "Success", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

						if (option == JOptionPane.OK_OPTION) {


							Home_page enter = new Home_page(); 


							setVisible(false); 


							enter.setVisible(true); 
						}

					} catch (SQLException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Error saving data: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);



					}
				}
			}
		}); }	
}


