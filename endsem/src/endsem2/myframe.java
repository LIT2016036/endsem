package endsem2;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class myframe extends JFrame implements ActionListener{
thirdframe tf;
static JFrame f;
static Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
static TextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
static JButton b,b1;
int count=0;
int total=0;
public myframe() {
	f=new JFrame("enter details");
	f.getContentPane().setBackground(Color.PINK);
	b=new JButton("submit");
	b1=new JButton("Save");
	b1.addActionListener(this);
	b.addActionListener(this);
	this.setBackground(Color.cyan);
	f.getContentPane().setLayout(null);
	l1= new Label("roll number");
	l2= new Label("attendance");
	l3= new Label("approved leaves");
	l4= new Label("first assignment marks");
	l5=new Label("enter marks");
	l6=new Label("second assignment");
	l7=new Label("third assignment");
	l8=new Label("fourth assignment");
	l9=new Label("fifth assignment");
	l10=new Label("midsem1");
	l11=new Label("medsem2");
	l12=new Label("endsem1");
	l13=new Label("endsem2");
	t1=new TextField();
	t2=new TextField();
	t3=new TextField();
	t4=new TextField();
	t5=new TextField();
	t6=new TextField();
	t7=new TextField();
	t8=new TextField();
	t9=new TextField();
	t11=new TextField();
	t12=new TextField();
	tf=new thirdframe();
	t10=new TextField();
	l1.setBounds(30, 40, 90, 30);
	l2.setBounds(30, 100, 90, 30);
	l3.setBounds(30, 150, 90, 30);
	l4.setBounds(30, 270, 90, 30);
	l5.setBounds(60, 210, 90, 30);
	l6.setBounds(30, 320, 90, 30);
	l7.setBounds(220, 270, 90, 30);
	l8.setBounds(220, 320, 90, 30);
	l9.setBounds(30, 390, 90, 30);
	l10.setBounds(30, 420, 90, 30);
	l11.setBounds(30, 450, 90, 30);
	l12.setBounds(220, 380, 90, 30);
	l13.setBounds(220, 430, 90, 30);
	f.getContentPane().add(t1);
	f.getContentPane().add(t2);
	f.getContentPane().add(t3);
	f.getContentPane().add(t4);
	f.getContentPane().add(t5);
	f.getContentPane().add(t6);
	f.getContentPane().add(t7);
	f.getContentPane().add(t8);
	f.getContentPane().add(t9);
	f.getContentPane().add(t10);
	f.getContentPane().add(t11);
	f.getContentPane().add(t12);
	t1.setBounds(130, 40, 90, 30);//rollnumber
	t2.setBounds(130, 100, 90, 30);//attendance
	t3.setBounds(130, 150, 90, 30);//approved leaves
	t4.setBounds(130, 270, 90, 30);//first assignment
	t5.setBounds(130, 320, 90, 30);
	t6.setBounds(330, 270, 90, 30);
	t7.setBounds(330, 320, 90, 30);
	t8.setBounds(130, 390, 90, 30);
	t9.setBounds(130, 420, 90, 30);
	t10.setBounds(130, 460, 90, 30);
	t11.setBounds(310, 380, 90, 30);
	t12.setBounds(310, 430, 90, 30);
	f.getContentPane().add(l1);
	f.getContentPane().add(l2);
	f.getContentPane().add(l3);
	f.getContentPane().add(l4);
	f.getContentPane().add(l5);
	f.getContentPane().add(l6);
	f.getContentPane().add(l7);
	f.getContentPane().add(l8);
	f.getContentPane().add(l9);
	f.getContentPane().add(l10);
	f.getContentPane().add(l11);
	f.getContentPane().add(l12);
	f.getContentPane().add(l13);
	f.getContentPane().add(b);
	f.getContentPane().add(b1);
	b.setBounds(80,510,80,40);
	b1.setBounds(200,510,80,40);
	f.setVisible(true);
	f.setSize(500, 500);
	f.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e)
		{
			f.dispose();
		}
	});
}
public void actionPerformed(ActionEvent e)
{
	JButton bs=(JButton) e.getSource();
	if(bs==b)
	{
	thirdframe t=new thirdframe();
	t.setVisible(true);
	}
	else
	{
		
	
		
		try
		{
			//loads the driver
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/endsem2?user=root&password=shubhi");
			String query="insert into student2 values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement st=cn.prepareStatement(query);			
			st.setString(1,t1.getText());
			int x1=Integer.parseInt(t2.getText());
			st.setInt(2,x1);
			int x2=Integer.parseInt(t3.getText());
			st.setInt(3,x2);
			int x3=Integer.parseInt(t4.getText());
			st.setInt(4,x3);
			int x4=Integer.parseInt(t5.getText());
			st.setInt(5,x4);
			int x5=Integer.parseInt(t6.getText());
			st.setInt(6,x5);
			int x6=Integer.parseInt(t7.getText());
			st.setInt(7,x6);
			int x7=Integer.parseInt(t8.getText());
			st.setInt(8,x7);
			int x8=Integer.parseInt(t9.getText());
			st.setInt(9,x8);
			int x9=Integer.parseInt(t10.getText());
			st.setInt(10,x9);
			int x10=Integer.parseInt(t11.getText());
			st.setInt(11,x10);
			int x11=Integer.parseInt(t12.getText());
			st.setInt(12,x11);
			count++;
			
			total=x3+x4+x5+x6+x7+x8+x9+x10+x11;
			/*if(total<Integer.parseInt(tf.lblMinimumMarks.getText()))
			{
				st.setString(15,"f");
			}
			else
				st.setString(15,"p");*/
			st.setInt(13, count);
			st.setInt(14, total);
			st.executeUpdate();
			cn.close();
			
		
			JOptionPane.showMessageDialog(null, "data saved");
		t1.setText("");
		t2.setText("");
		t3.setText("");
		t4.setText("");
		t5.setText("");
		t6.setText("");
		t7.setText("");
		t8.setText("");
		t9.setText("");
		t10.setText("");
		t11.setText("");
		t12.setText("");
		}
		catch(Exception e1)
		{
			System.out.println(e1.getMessage());
		}

		
	}
}
public static void main(String ar[])
{
	myframe f=new myframe();
}
}
