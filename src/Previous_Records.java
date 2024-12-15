import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Previous_Records extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField Visitation_id;



	public static void main(String[] args) {



		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Previous_Records frame = new Previous_Records();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Previous_Records() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setBounds(100, 100, 756, 426); 
		setResizable(false);
		JPanel contentPane = new JPanel(); 
		contentPane.setBackground(new Color(54, 85, 142)); 
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); 
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Visitation_id = new JTextField();
		Visitation_id.setBounds(403, 46, 216, 34);
		Visitation_id.setText("Visitation id");
		Visitation_id.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 13));
		Visitation_id.setColumns(10);
		Visitation_id.setBackground(new Color(189, 193, 199));
		contentPane.add(Visitation_id);


		Visitation_id.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if(Visitation_id.getText().equals("Visitation id")) {
					Visitation_id.setText("");
					Visitation_id.setForeground(new Color(110, 120, 128));
				}
			}

			public void focusLost(FocusEvent e) {
				if(Visitation_id.getText().equals("")) {
					Visitation_id.setText("Visitation id");
					Visitation_id.setForeground(new Color(110, 120, 128));
				}
			}

		});


		JTable table = new JTable();


		JTextField Name = new JTextField();
		Name.setBounds(172, 46, 216, 34);
		Name.setToolTipText("");
		Name.setText("Name");
		Name.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 13));
		Name.setColumns(10);
		Name.setBackground(new Color(189, 193, 199));
		contentPane.add(Name);

		Name.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if(Name.getText().equals("Name")) {
					Name.setText("");
					Name.setForeground(new Color(110, 120, 128));
				}
			}

			public void focusLost(FocusEvent e) {
				if(Name.getText().equals("")) {
					Name.setText("Name");
					Name.setForeground(new Color(110, 120, 128));
				}
			}

		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 19, 743, 203);
		scrollPane.setViewportView(table);
		scrollPane.setVisible(false); // Initially invisible
		contentPane.add(scrollPane);



		JButton Search_button = new JButton("Search");
		Search_button.setBounds(345, 104, 117, 29);
		Search_button.setBackground(new Color(160, 182, 199));
		Search_button.setForeground(new Color(133, 221, 107));
		contentPane.add(Search_button);


		Search_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				if(Name.getText().isEmpty() || Name.getText().equals("firstName") ||
						Visitation_id.getText().isEmpty() || Visitation_id.getText().equals("randomID")) {

					JOptionPane.showMessageDialog(null, "Error: Please fill out all required fields.", "Error", JOptionPane.ERROR_MESSAGE);

				} else if (!Visitation_id.getText().matches("\\d{8}")) {

					JOptionPane.showMessageDialog(null, "Error: Visitation ID must be an 8-digit number.", "Error", JOptionPane.ERROR_MESSAGE);
					Visitation_id.setText("");
				} else {

					Name.setVisible(false);
					Visitation_id.setVisible(false);

					Name.setVisible(false);
					Visitation_id.setVisible(false);

					// Database connection and fetching data
					try (Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/macbook/Documents/Group_Project_Implementation/lib/patientInfo.db");
							PreparedStatement pst = conn.prepareStatement("SELECT * FROM patient WHERE firstname = ? AND randomID = ?")) {

						pst.setString(1, Name.getText());
						pst.setString(2, Visitation_id.getText());

						try (ResultSet rs = pst.executeQuery()) {
							table.setModel(buildTableModel(rs));
							scrollPane.setVisible(true);

						} 
					} catch (Exception ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null, "Error in database connection: " + ex.getMessage());

						Name.setVisible(true);
						Visitation_id.setVisible(true);

					}
				}
			}
			public static TableModel buildTableModel(ResultSet rs) throws SQLException {
				ResultSetMetaData metaData = rs.getMetaData();

				Vector<String> columnNames = new Vector<String>();
				int columnCount = metaData.getColumnCount();
				for (int column = 1; column <= columnCount; column++) {
					columnNames.add(metaData.getColumnName(column));
				}


				Vector<Vector<Object>> data = new Vector<Vector<Object>>();
				while (rs.next()) {
					Vector<Object> vector = new Vector<Object>();
					for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
						vector.add(rs.getObject(columnIndex));
					}
					data.add(vector);
				}

				return new DefaultTableModel(data, columnNames);
			}



		});

		JPanel bluepanel = new JPanel ();
		bluepanel.setBounds(159, 19, 475, 157);
		bluepanel.setBackground(new Color(61, 84, 138));
		contentPane.add(bluepanel);

		JButton Close_button = new JButton("Close");
		Close_button.setBounds(348, 324, 117, 29);
		contentPane.add(Close_button);


		Close_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {




				Home_page enter = new 	Home_page ();

				setVisible(false);

				enter.setVisible(true);

			}
		});



		JLabel backroundimage = new JLabel("");
		backroundimage.setBounds(0, 6, 755, 392);
		contentPane.add(backroundimage);
		backroundimage.setIcon(new ImageIcon("/Users/macbook/Documents/Group_Project_Implementation/img/home page.jpeg"));
	}
}
