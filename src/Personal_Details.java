import java.awt.Color;
import java.awt.Cursor;
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
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import java.io.BufferedReader;
import java.io.FileReader;

public class Personal_Details extends JFrame {


	private static final long serialVersionUID = 1L;
	private JTextField First_Name;
	private JTextField Surname;
	private JTextField Date_of_birth;
	private JTextField Email;
	private JTextField House_number;
	private JTextField City;
	private JTextField Postal_Code;
	private JTextField Street_Name;
	private JTextField Phone_Number;
	private JComboBox<String> comboBox;
	protected CharSequence dob;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Personal_Details frame = new Personal_Details();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Personal_Details() {



		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setBounds(100, 100, 755, 426); 
		setResizable(false);
		JPanel contentPane = new JPanel(); 
		contentPane.setBackground(new Color(54, 85, 142)); 
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); 
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JRadioButton Yes_button = new JRadioButton("Yes");
		Yes_button.setBackground(new Color(192, 0, 17));
		Yes_button.setBounds(311, 265, 68, 23);
		contentPane.add(Yes_button);


		JRadioButton No_button = new JRadioButton("No");
		No_button.setBackground(new Color(19, 195, 0));
		No_button.setBounds(418, 265, 68, 23);
		contentPane.add(No_button);

		// Here we are adding yes or no button to chose either yes or no
		ButtonGroup disabilityGroup = new ButtonGroup ();
		disabilityGroup.add(Yes_button);
		disabilityGroup.add(No_button);


		this.comboBox = new JComboBox<String>();
		Border originalBorder6 = comboBox.getBorder();
		Border paddingBorder6 = new EmptyBorder(0, 19, 0, 0); 
		Border combinedBorder6 = new CompoundBorder(originalBorder6, paddingBorder6);
		comboBox.setBorder(combinedBorder6);
		comboBox.setForeground(new Color(105, 116, 124));
		comboBox.setName("");
		comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		comboBox.setBackground(new Color(169, 172, 176));
		comboBox.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 23));
		comboBox.setEditable(true);
		comboBox.setBounds(196, 35, 480, 23);
		contentPane.add(comboBox);





		JTextField editorComponent = (JTextField) comboBox.getEditor().getEditorComponent();
		editorComponent.setForeground(Color.GRAY); 

		editorComponent.addFocusListener(new FocusAdapter() {

			public void focusGained(FocusEvent e) {
				if (comboBox.getSelectedIndex() == 0) {
					comboBox.setSelectedItem(null); 
					editorComponent.setForeground(Color.GRAY); 
				}
			}


			public void focusLost(FocusEvent e) {
				if (comboBox.getSelectedItem() == null || comboBox.getSelectedIndex() == -1) {
					comboBox.setSelectedIndex(0); 
					editorComponent.setForeground(Color.GRAY); 
				}
			}
		});

		loadProblems();

		JButton ADD_button = new JButton("ADD");
		ADD_button.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 13));
		ADD_button.setForeground(new Color(0, 0, 0));
		ADD_button.setBounds(682, 30, 56, 28);
		contentPane.add(ADD_button);

		//here we are linking two pages together 
		ADD_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				New_Medical_Problem enter = new New_Medical_Problem ();
				setVisible(false);

				enter.setVisible(true); }
		} );

		JLabel Select_Disability = new JLabel("Select Disability");
		Select_Disability.setFont(new Font("Georgia", Font.BOLD, 13));
		Select_Disability.setBounds(335, 237, 189, 16);
		contentPane.add(Select_Disability);

		JLabel Select_Medical_Problem = new JLabel("Select Medical Problem");
		Select_Medical_Problem.setForeground(new Color(244, 247, 255));
		Select_Medical_Problem.setBackground(new Color(244, 247, 255));
		Select_Medical_Problem.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 13));
		Select_Medical_Problem.setBounds(49, 42, 189, 16);
		contentPane.add(Select_Medical_Problem);








		Street_Name = new JTextField();
		Street_Name.setText("Street Name");
		Street_Name.setFont(new Font("Charter", Font.BOLD, 13));
		Street_Name.setColumns(10);
		Street_Name.setBackground(new Color(189, 193, 199));
		Street_Name.setBounds(443, 91, 216, 34);
		contentPane.add(Street_Name);




		// here we are making text deleted automatically

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

		Postal_Code = new JTextField();
		Postal_Code.setText("Postal Code");
		Postal_Code.setFont(new Font("Charter", Font.BOLD, 13));
		Postal_Code.setColumns(10);
		Postal_Code.setBackground(new Color(189, 193, 199));
		Postal_Code.setBounds(443, 191, 216, 34);
		contentPane.add(Postal_Code);

		// here we are making text deleted automatically
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

		City = new JTextField();
		City.setText("City");
		City.setFont(new Font("Charter", Font.BOLD, 13));
		City.setColumns(10);
		City.setBackground(new Color(189, 193, 199));
		City.setBounds(443, 145, 216, 34);
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






		House_number = new JTextField();
		House_number.setText("House number");
		House_number.setFont(new Font("Charter", Font.BOLD, 13));
		House_number.setColumns(10);
		House_number.setBackground(new Color(189, 193, 199));
		House_number.setBounds(216, 191, 142, 34);
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



		Email = new JTextField();
		Email.setText("Email");
		Email.setFont(new Font("Charter", Font.BOLD, 13));
		Email.setColumns(10);
		Email.setBackground(new Color(189, 193, 199));
		Email.setBounds(49, 191, 142, 34);
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


		Date_of_birth = new JFormattedTextField();
		Date_of_birth.setText("Date of birth");
		Date_of_birth.setFont(new Font("Charter", Font.BOLD, 13));
		Date_of_birth.setColumns(10);
		Date_of_birth.setBackground(new Color(189, 193, 199));
		Date_of_birth.setBounds(49, 145, 142, 34);
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


		Surname = new JTextField();
		Surname.setFont(new Font("Charter", Font.BOLD, 13));
		Surname.setText("Surname");
		Surname.setColumns(10);
		Surname.setBackground(new Color(189, 193, 199));
		Surname.setBounds(216, 91, 142, 34);
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

		First_Name = new JTextField();
		First_Name.setFont(new Font("Charter", Font.BOLD, 13));
		First_Name.setBackground(new Color(189, 193, 199));
		First_Name.setText("First Name");
		First_Name.setBounds(49, 91, 142, 34);
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

		Phone_Number = new JTextField();
		Phone_Number.setText("Phone Number");
		Phone_Number.setFont(new Font("Charter", Font.BOLD, 13));
		Phone_Number.setColumns(10);
		Phone_Number.setBackground(new Color(189, 193, 199));
		Phone_Number.setBounds(216, 145, 142, 34);
		contentPane.add(Phone_Number);

		Phone_Number.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if(Phone_Number.getText().equals("Phone Number")) {
					Phone_Number.setText("");
					Phone_Number.setForeground(new Color(110, 120, 128));
				}
			}

			public void focusLost(FocusEvent e) {
				if(Phone_Number.getText().equals("")) {
					Phone_Number.setText("Phone Number");
					Phone_Number.setForeground(new Color(110, 120, 128));
				}
			}

		});



		JButton Confirm_button = new JButton("Confirm");
		Confirm_button.setBackground(new Color(102, 217, 150));
		Confirm_button.setForeground(new Color(0, 0, 0));
		Confirm_button.setBounds(337, 313, 117, 29);
		contentPane.add(Confirm_button);

		JLabel Backraund_image = new JLabel("");
		Backraund_image.setIcon(new ImageIcon("/Users/macbook/Documents/Group_Project_Implementation/img/special for next of kin _resized.png"));
		Backraund_image.setBounds(0, 0, 755, 398);
		contentPane.add(Backraund_image);


		Confirm_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
		        
		        


				// Check if any text fields are empty or contain their placeholder texts
				if (First_Name.getText().isEmpty() || First_Name.getText().equals("First Name") ||
						Surname.getText().isEmpty() || Surname.getText().equals("Surname") ||
						Date_of_birth.getText().isEmpty() || Date_of_birth.getText().equals("Date of birth") ||
						Email.getText().isEmpty() || Email.getText().equals("Email") ||
						House_number.getText().isEmpty() || House_number.getText().equals("House number") ||
						City.getText().isEmpty() || City.getText().equals("City") ||
						Postal_Code.getText().isEmpty() || Postal_Code.getText().equals("Postal Code") ||
						Street_Name.getText().isEmpty() || Street_Name.getText().equals("Street Name") ||
						Phone_Number.getText().isEmpty() || Phone_Number.getText().equals("Phone Number")) {

				
					JOptionPane.showMessageDialog(null, "Error: Please fill out all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					
					 String dateOfBirth = Date_of_birth.getText();
				        int age = calculateAge(dateOfBirth);
				        if (age == -1) { // Assuming calculateAge returns -1 for invalid dates
				            return; // Stop further execution if date format is wrong
				        }
					


					

		            String message = "Your age is: " + age + ". ";
		            
		            if (age >= 70) {
		                message += "Becouse of you are above 70, you will be provided a free meal once you visit the hospital.";
		                
		            } else if (age >= 13 && age < 18) {
		                message += "Becouse of you are below 18 , ensure you are accompanied by an adult.";
		                
		            } else if (age < 13) {
		                message += "Becouse of you are below 13, ensure you are assigned a doctor who is paediatrically specialised.";
		                
		            }
		            JOptionPane.showMessageDialog(null, message, "Age Information", JOptionPane.INFORMATION_MESSAGE);
					
					
				
					Random random = new Random();

				
					int randomNumber = 10000000 + random.nextInt(90000000); 
				
					// Attempt to save data to the database
					String insertt = "INSERT INTO patient (firstName, lastName, dateofbirth, phonenumber, email, housenumber, streetname, city, postalcode, disability,randomID, medical) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					try (Connection connect = Database.databaseConn(); PreparedStatement prepare = connect.prepareStatement(insertt)) {
						prepare.setString(1, First_Name.getText());
						prepare.setString(2, Surname.getText());
						prepare.setString(3, Date_of_birth.getText());
						prepare.setString(4, Phone_Number.getText());
						prepare.setString(5, Email.getText());
						prepare.setString(6, House_number.getText());
						prepare.setString(7, Street_Name.getText());
						prepare.setString(8, City.getText());
						prepare.setString(9, Postal_Code.getText());
						String disabilityStatus = Yes_button.isSelected() ? "Yes" : "No";
						prepare.setString(10, disabilityStatus);
						prepare.setInt(11, randomNumber);    
						prepare.setString(12,(String) comboBox.getSelectedItem());

						prepare.executeUpdate();

						
						int option = JOptionPane.showConfirmDialog(null, "Data saved successfully. Your Visiting ID: " + randomNumber  + ". Click OK to go to the homepage", "Success", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

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
			 protected int calculateAge(String dateOfBirth) {
			        try {
			            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			            LocalDate dob = LocalDate.parse(dateOfBirth, formatter);
			            LocalDate currentDate = LocalDate.now();
			            Period period = Period.between(dob, currentDate);
			            return period.getYears();
			        } catch (Exception e) {
			            JOptionPane.showMessageDialog(null, "Invalid date format. Please use MM/dd/yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
			            return -1; 
			        }
			    }
			});

			
				
	
	}
			
	
		
	


	private void loadProblems() {
		String path = "/Users/macbook/Documents/Group_Project_Implementation/src/assets/New_Medical_Problems_.csv";
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;

			br.readLine();
			while ((line = br.readLine()) != null) {

				String[] values = line.split(";"); 
				if (values.length > 0) {
					String name = values[0];
					comboBox.addItem(name);
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}





		JLabel backroundimage = new JLabel("");
		backroundimage.setBounds(0, 6, 755, 392);
		backroundimage.setIcon(new ImageIcon("/Users/macbook/Documents/Backroundforall.jpg"));	
	}
}
