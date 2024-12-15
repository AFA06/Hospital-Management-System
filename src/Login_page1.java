import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class Login_page1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel Main_backround;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {


				try {
					Login_page1 frame = new Login_page1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Login_page1() { 

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setBounds(100, 100, 755, 426); 
		setResizable(false);
		Main_backround = new JPanel(); 
		Main_backround.setBackground(new Color(54, 85, 142)); 
		Main_backround.setBorder(new EmptyBorder(5, 5, 5, 5)); 
		setContentPane(Main_backround); 
		Main_backround.setLayout(null);




		JTextField Username = new JTextField();
		Username.setText("Username");

		// here we adding a focus listener 
		Username.addFocusListener(new FocusAdapter() {

			// this code for  gain and lost focus 
			//If the field is empthy it  should show "Username" , if not typet word .
			public void focusGained(FocusEvent e) {
				if(Username.getText().equals("Username")) {
					Username.setText("");
					Username.setForeground(new Color(110, 120, 128));
				}
			}

			public void focusLost(FocusEvent e) {
				if(Username.getText().equals("")) {
					Username.setText("Username");
					Username.setForeground(new Color(110, 120, 128));
				}
			}

		});



		Username.setHorizontalAlignment(SwingConstants.LEFT);
		Username.setBackground(new Color(163, 163, 163)); 
		Username.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 16)); 
		Username.setBounds(374, 193, 298, 37); 
		Main_backround.add(Username); 
		Username.setColumns(10); 



		JPasswordField pwdPassword = new JPasswordField("Password");
		pwdPassword.setHorizontalAlignment(SwingConstants.LEFT);
		pwdPassword.setEchoChar((char)0);
		pwdPassword.setBackground(new Color(163, 163, 163)); 
		pwdPassword.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 16)); 
		pwdPassword.setColumns(10); 
		pwdPassword.setBounds(374, 252, 298, 37); 
		Main_backround.add(pwdPassword);

		pwdPassword.addFocusListener(new FocusAdapter() {

			public void focusGained(FocusEvent e) {
				JPasswordField source = (JPasswordField) e.getSource();
				String pass = new String(source.getPassword());
				if(pass.equals("Password")) {
					source.setText("");
					source.setEchoChar('•');
					source.setForeground(new Color(110, 120, 128));
				}
			}
			public void focusLost(FocusEvent e) {
				JPasswordField source = (JPasswordField) e.getSource();
				if (source.getPassword().length == 0) {
					source.setEchoChar((char)0);
					source.setText("Password");
					source.setForeground(new Color(110, 120, 128));
				}
			}
		});



		JLabel MainLogin = new JLabel("Login"); 
		MainLogin.setForeground(new Color(54, 85, 142)); 
		MainLogin.setFont(new Font("Adobe Heiti Std R", Font.BOLD, 32)); 
		MainLogin.setBounds(468, 129, 103, 65); 
		Main_backround.add(MainLogin); 

		JButton Login_button = new JButton("Login");
		Login_button.setFocusTraversalPolicyProvider(true);
		Login_button.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		Login_button.setForeground(new Color(61, 84, 138));
		Login_button.setBackground(new Color(27, 255, 42));
		Login_button.setBounds(374, 328, 298, 29);
		Main_backround.add(Login_button);

		// This code provides patient from login page to the next page which was home page 

		Login_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = new String(pwdPassword.getPassword());
				String username = Username.getText();

				// This function checks if username is text only letters and optionally spaces, no numbers allowed
				if (!username.matches("[A-Za-z ]+")) {
					JOptionPane.showMessageDialog(null, "Error: Username must contain only letters.", "Login Error", JOptionPane.ERROR_MESSAGE);
					// Focus back to the username field for correction
					Username.requestFocus();
					return; 
				}

				// This code checks if the password is exactly 8 digits and contains only numbers
				if (password.matches("\\d{8}")) {
					// Password is an 8-digit number, proceed with login
					Home_page enter = new Home_page();
					setVisible(false);
					enter.setVisible(true);
				} else if (!password.matches("\\d+")) { 
					// If the password contains non-digit characters, shows error message 
					JOptionPane.showMessageDialog(null, "Error: Please fill out all required fields.", "Login Error", JOptionPane.ERROR_MESSAGE);
					Login_page1 Login_page=new Login_page1();
					Login_page.setVisible(true);
					dispose();
					pwdPassword.setText(""); 
				} else {
					// If Password is not 8 digits, show general error message
					JOptionPane.showMessageDialog(null, "Error: Password must be an 8-digit number.", "Login Error", JOptionPane.ERROR_MESSAGE);
					pwdPassword.setText(""); 

					// after error message, page will update every time for new page 
					Login_page1 Login_page = new Login_page1();
					Login_page.setVisible(true);
					dispose();
				}
			}
		});


		ImageIcon img = new ImageIcon(this.getClass().getResource("/healthcare.png"));
		JPanel White_login = new JPanel(); 
		White_login.setBackground(new Color(255, 255, 255)); 
		White_login.setBounds(284, 11, 445, 365); 

		Main_backround.add(White_login);

		JLabel lblNewLabel = new JLabel((String) null);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		White_login.add(lblNewLabel);
		lblNewLabel.setIcon(img);

		JLabel Hospital_icon = new JLabel("");
		Hospital_icon.setIcon(new ImageIcon("/Users/macbook/Documents/Group_Project_Implementation/img/hospital.png"));
		Hospital_icon.setBounds(45, 67, 147, 146);
		Main_backround.add(Hospital_icon);

		JLabel Welcome = new JLabel("Welcome"); 
		Welcome.setFont(new Font("Tahoma", Font.BOLD, 20)); 
		Welcome.setForeground(new Color(255, 255, 255)); 
		Welcome.setBounds(77, 220, 103, 25); 
		Main_backround.add(Welcome);



	}
}