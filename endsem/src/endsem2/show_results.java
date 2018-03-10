package endsem2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JList;

public class show_results extends JFrame {
	JPanel contentPane;

JTextField textField;
private JLabel lblRollNumber;
private JLabel lblAttendance;
private JLabel lblApprovedleaves;
private JLabel lblTotalMarks;
private JTable table;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					show_results frame = new show_results();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public show_results() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setBounds(5, 5, 424, 20);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				fill(textField.getText());
			}
		});
		contentPane.setLayout(null);
		contentPane.add(textField);
		textField.setColumns(14);
		 table=new JTable(); 
		lblRollNumber = new JLabel("roll number");
		lblRollNumber.setBounds(15, 36, 62, 14);
		contentPane.add(lblRollNumber);
		
		lblAttendance = new JLabel("attendance");
		lblAttendance.setBounds(131, 31, 80, 14);
		contentPane.add(lblAttendance);
		
		lblApprovedleaves = new JLabel("approved_leaves");
		lblApprovedleaves.setBounds(243, 31, 78, 14);
		contentPane.add(lblApprovedleaves);
		
		lblTotalMarks = new JLabel("total marks");
		lblTotalMarks.setBounds(359, 36, 70, 14);
		contentPane.add(lblTotalMarks);
		
		table = new JTable();
		table.setBounds(25, 61, 404, 189);
		contentPane.add(table);
		
		fill();
	}
	void fill()
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/endsem2?user=root&password=shubhi");
		String str="select * from student2";
		PreparedStatement st=cn.prepareStatement(str);
		ResultSet rs=st.executeQuery();
	
		DefaultTableModel dc=new DefaultTableModel();
		dc.addColumn("rno");
		dc.addColumn("attendance");
		dc.addColumn("approved_list");
		dc.addColumn("total");
		while(rs.next())
		{
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(14));
			
			dc.addRow(new String[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(14)});
			
		}
		
		
		cn.close();
		table.setModel(dc);
	}
	
	catch(Exception e1)
	{
		JOptionPane.showMessageDialog(null, e1.getMessage());
	}
	}
	void fill(String mname)
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/endsem2?user=root&password=shubhi");
		String str="select * from student2 where rno like'"+mname+"%'";
		PreparedStatement st=cn.prepareStatement(str);
		ResultSet rs=st.executeQuery();
	
		DefaultTableModel dc=new DefaultTableModel();
		dc.addColumn("rno");
		dc.addColumn("attendance");
		dc.addColumn("approved_list");
		dc.addColumn("total");
		while(rs.next())
		{
			
			System.out.println(rs.getString(1));
			
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(14));
			dc.addRow(new String[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(14)});
		}
		
		
		table.setModel(dc);
		cn.close();
		
	}
	
	catch(Exception e1)
	{
		JOptionPane.showMessageDialog(null, e1.getMessage());
	}

	}
}
