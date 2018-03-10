package endsem2;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
//import javax.swing.text.html.AccessibleHTML.TableElementInfo.TableAccessibleContext;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.awt.Color;

public class thirdframe extends JFrame implements ActionListener{

	JPanel contentPane;
	JTextField textField;
	JTextField textField_1;
	JTextField textField_2;
	JTextField textField_3;
	JTextField textField_4;
	JTextField textField_5;
	JTextField textField_6;
	JTextField textField_7;
	JButton btnSeeResult;
	JTable table;
	JButton btnSubmit;
	JLabel lblMinimumMarks;
	JTextField textField_8;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					thirdframe frame = new thirdframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public thirdframe() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblP = new JLabel("p1");
		lblP.setBounds(42, 38, 46, 28);
		contentPane.add(lblP);
		
		textField = new JTextField();
		textField.setBounds(114, 42, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblP_1 = new JLabel("p2");
		lblP_1.setBounds(260, 45, 46, 14);
		contentPane.add(lblP_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(338, 42, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblP_2 = new JLabel("p3");
		lblP_2.setBounds(42, 86, 46, 14);
		contentPane.add(lblP_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(114, 83, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblP_3 = new JLabel("p4");
		lblP_3.setBounds(260, 86, 46, 14);
		contentPane.add(lblP_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(338, 83, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblP_4 = new JLabel("p5");
		lblP_4.setBounds(42, 135, 46, 14);
		contentPane.add(lblP_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(114, 132, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblP_5 = new JLabel("p6");
		lblP_5.setBounds(260, 135, 46, 14);
		contentPane.add(lblP_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(338, 132, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblP_6 = new JLabel("p7");
		lblP_6.setBounds(42, 180, 46, 14);
		contentPane.add(lblP_6);
		
		textField_6 = new JTextField();
		textField_6.setBounds(114, 177, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblP_7 = new JLabel("p8");
		lblP_7.setBounds(260, 180, 46, 14);
		contentPane.add(lblP_7);
		
		textField_7 = new JTextField();
		textField_7.setBounds(338, 177, 86, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		btnSubmit = new JButton("save");
		btnSubmit.addActionListener(this);
			
		
		btnSubmit.setBounds(172, 227, 89, 23);
		contentPane.add(btnSubmit);
		
		btnSeeResult = new JButton("see result");
		btnSeeResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				show_results sr=new show_results();
				sr.setVisible(true);
			}
		});
		btnSeeResult.setBounds(300, 227, 89, 23);
		contentPane.add(btnSeeResult);
		
		lblMinimumMarks = new JLabel("minimum marks");
		lblMinimumMarks.setBounds(169, 11, 92, 14);
		contentPane.add(lblMinimumMarks);
		
		textField_8 = new JTextField();
		textField_8.setBounds(247, 8, 86, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
	}
	public void actionPerformed(ActionEvent e) {		
		JButton bs=(JButton)e.getSource();
		if(bs==btnSubmit)
		{
		try
		{
			//loads the driver
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/endsem2?user=root&password=shubhi");
			String query="insert into grade1 values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement st=cn.prepareStatement(query);
			st.setString(1,textField.getText());
			st.setInt(2,Integer.parseInt(textField_1.getText()));
			st.setInt(3,Integer.parseInt(textField_2.getText()));
			st.setInt(4,Integer.parseInt(textField_3.getText()));
			st.setInt(5,Integer.parseInt(textField_4.getText()));
			st.setInt(6,Integer.parseInt(textField_5.getText()));
			st.setInt(7,Integer.parseInt(textField_6.getText()));
			st.setInt(8,Integer.parseInt(textField_7.getText()));
			st.setInt(9,Integer.parseInt(lblMinimumMarks.getText()));
			
			st.executeUpdate();
			cn.close();
			JOptionPane.showMessageDialog(null, "data saved");
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");
			textField_5.setText("");
			textField_6.setText("");
			textField_7.setText("");
			lblMinimumMarks.setText("");
			
		}
		catch(Exception e1)
		{
			System.out.println(e1.getMessage());
		}
		}
		
}
}
