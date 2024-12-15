import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home_page extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JPanel First_JPanel;
	private JPanel Second_JPanel;
	private JPanel Third_JPanel;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home_page frame = new Home_page();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Home_page() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 755, 426);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(54, 85, 142));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton Personal_Details_button = new JButton("Personal Details");
		Personal_Details_button.setBackground(new Color(102, 130, 180));
		Personal_Details_button.setFont(new Font("Helvetica", Font.BOLD, 16));
		Personal_Details_button.setBounds(59, 256, 163, 29);
		contentPane.add(Personal_Details_button);

		Personal_Details_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Implementation of switching to Personal_Details page

				Personal_Details enter = new Personal_Details ();
				setVisible(false);

				enter.setVisible(true);
			}
		});
		


		First_JPanel = new JPanel(null);
		First_JPanel.setBackground(new Color(254, 255, 255));
		First_JPanel.setBounds(59, 71, 163, 225);
		contentPane.add(First_JPanel);

		JLabel Personal_icon = new JLabel("");
		Personal_icon.setIcon(new ImageIcon("/Users/macbook/Documents/Group_Project_Implementation/img/personal.png"));
		Personal_icon.setBounds(6, 6, 151, 177);
		First_JPanel.add(Personal_icon);


		Second_JPanel = new JPanel(null);
		Second_JPanel.setBackground(new Color(254, 255, 255));
		Second_JPanel.setBounds(284, 71, 163, 225);
		contentPane.add(Second_JPanel);
		
				JButton Next_of_Kin_button = new JButton("Next of Kin");
				Next_of_Kin_button.setBounds(0, 190, 163, 29);
				Second_JPanel.add(Next_of_Kin_button);
				Next_of_Kin_button.setFont(new Font("Helvetica", Font.BOLD, 16));
				Next_of_Kin_button.setBackground(new Color(102, 130, 180));
				
						JLabel next_of_kin_icon = new JLabel("");
						next_of_kin_icon.setBounds(0, 6, 151, 177);
						Second_JPanel.add(next_of_kin_icon);
						next_of_kin_icon.setIcon(new ImageIcon("/Users/macbook/Documents/Group_Project_Implementation/img/next_of_kin.png"));
				
						Next_of_Kin_button.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
				
								// Implementation of switching to Next_of_Kin page
				
								Next_of_Kin enter = new Next_of_Kin ();
								setVisible(false);
				
								enter.setVisible(true); }
				
				
						});


		Third_JPanel = new JPanel();
		Third_JPanel.setBackground(new Color(254, 255, 255));
		Third_JPanel.setBounds(523, 71, 163, 225);
		contentPane.add(Third_JPanel);
		Third_JPanel.setLayout(null);
		
				JButton Previous_Records_button = new JButton("Previous Records");
				Previous_Records_button.setBounds(0, 190, 163, 29);
				Third_JPanel.add(Previous_Records_button);
				Previous_Records_button.setFont(new Font("Helvetica", Font.BOLD, 16));
				Previous_Records_button.setBackground(new Color(102, 130, 180));
						
								JLabel Previous_icon = new JLabel("");
								Previous_icon.setBounds(6, 1, 151, 177);
								Third_JPanel.add(Previous_icon);
								Previous_icon.setIcon(new ImageIcon("/Users/macbook/Documents/medical.png"));
				
						Previous_Records_button.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// Implementation of switching to Previous_Records page
				
								Previous_Records enter = new Previous_Records  ();
								setVisible(false);
				
								enter.setVisible(true);
							}
						});

		// Background image
		JLabel backgroundimage = new JLabel(new ImageIcon("/Users/macbook/Documents/Group_Project_Implementation/img/photo_2024-02-29 02.28.52.jpeg"));
		backgroundimage.setBounds(0, 0, 755, 409);
		contentPane.add(backgroundimage);
	}
}
