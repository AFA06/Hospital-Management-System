import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class New_Medical_Problem extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField Descriptions_blank;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					New_Medical_Problem frame = new New_Medical_Problem();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public New_Medical_Problem() {


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setBounds(100, 100, 755, 426); 
		setResizable(false);
		JPanel contentPane = new JPanel(); 
		contentPane.setBackground(new Color(54, 85, 142)); 
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); 
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Descriptions_blank = new JTextField();
		Descriptions_blank.setFont(new Font("Charter", Font.BOLD, 13));
		Descriptions_blank.setColumns(10);
		Descriptions_blank.setBackground(new Color(190, 193, 198));
		Descriptions_blank.setBounds(28, 120, 214, 34);
		contentPane.add(Descriptions_blank);

		Descriptions_blank.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if(Descriptions_blank.getText().equals("")) {
					Descriptions_blank.setText("");
					Descriptions_blank.setForeground(new Color(110, 120, 128));
				}
			}

			public void focusLost(FocusEvent e) {
				if(Descriptions_blank.getText().equals("")) {
					Descriptions_blank.setText("");
					Descriptions_blank.setForeground(new Color(110, 120, 128));
				}
			}

		});


		JLabel Description_text = new JLabel("Give Description");
		Description_text.setForeground(new Color(127, 235, 245));
		Description_text.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 13));
		Description_text.setBackground(new Color(244, 247, 255));
		Description_text.setBounds(30, 109, 189, 16);
		contentPane.add(Description_text);



		JLabel Specialty_text = new JLabel("Type Specialty");
		Specialty_text.setForeground(new Color(127, 235, 245));
		Specialty_text.setBackground(new Color(244, 247, 255));
		Specialty_text.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 13));
		Specialty_text.setBounds(30, 37, 189, 16);
		contentPane.add(Specialty_text);

		JTextField speciality_blank = new JTextField();
		speciality_blank.setFont(new Font("Charter", Font.BOLD, 13));
		speciality_blank.setColumns(10);
		speciality_blank.setBackground(new Color(189, 193, 199));
		speciality_blank.setBounds(28, 50, 214, 34);
		contentPane.add(speciality_blank);


		// here we adding to textfield a focus listener(gain and lost) 

		speciality_blank.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if(speciality_blank.getText().equals("")) {
					speciality_blank.setText("");
					speciality_blank.setForeground(new Color(110, 120, 128));
				}
			}

			public void focusLost(FocusEvent e) {
				if(speciality_blank.getText().equals("")) {
					speciality_blank.setText("");
					speciality_blank.setForeground(new Color(110, 120, 128));
				}
			}

		});


		JButton ADD_button = new JButton("ADD");
		ADD_button.setRolloverEnabled(true);
		ADD_button.setBackground(new Color(53, 251, 33));
		ADD_button.setForeground(new Color(0, 0, 0));
		ADD_button.setBounds(81, 205, 117, 29);
		contentPane.add(ADD_button);

		// adding link for two pages for this add button 

		ADD_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!speciality_blank.getText().trim().isEmpty() && !	Descriptions_blank.getText().trim().isEmpty()) {
					saveData(	speciality_blank.getText(), Descriptions_blank.getText());

					Personal_Details enter = new Personal_Details();
					setVisible(false); 
					enter.setVisible(true); 
				} else {
					JOptionPane.showMessageDialog(null, "Please fill in all fields before proceeding.", "Missing Information", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		
		
	
		
		
		
		JLabel backroundImage = new JLabel("");
		backroundImage.setBounds(0, 6, 755, 392);
		contentPane.add(backroundImage);
		backroundImage.setIcon(new ImageIcon("/Users/macbook/Documents/Group_Project_Implementation/img/home page.jpeg"));
	}

	private void saveData(String description, String specialty) {
		String filePath = "/Users/macbook/Documents/Group_Project_Implementation/src/assets/New_Medical_Problems_.csv";

		try (FileWriter fw = new FileWriter(filePath, true);
				PrintWriter pw = new PrintWriter(fw)) {
			pw.println(description + "," + specialty);
			JOptionPane.showMessageDialog(null, "Data saved successfully.");
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error saving data: " + e.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}







