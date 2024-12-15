import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Previous_details extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField Visitin_number_field;
	private JTextField Medical_problem_field;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Previous_details frame = new Previous_details();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Previous_details() {setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	setBounds(100, 100, 755, 426); 
	JPanel contentPane = new JPanel(); 
	contentPane.setBackground(new Color(54, 85, 142)); 
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); 
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	Visitin_number_field = new JTextField();
	Visitin_number_field.setBackground(new Color(188, 199, 203));
	Visitin_number_field.setBounds(214, 80, 179, 36);
	contentPane.add(Visitin_number_field);
	Visitin_number_field.setColumns(10);
	
	Medical_problem_field = new JTextField();
	Medical_problem_field.setColumns(10);
	Medical_problem_field.setBackground(new Color(188, 199, 203));
	Medical_problem_field.setBounds(214, 142, 179, 36);
	contentPane.add(Medical_problem_field);

	JLabel backroundimage = new JLabel("");
	backroundimage.setBounds(0, 6, 755, 392);
	contentPane.add(backroundimage);
	backroundimage.setIcon(new ImageIcon("/Users/macbook/Documents/Group_Project_Implementation/img/Backroundforall.jpg"));
	}

}
