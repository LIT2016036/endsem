package endsem2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class frame extends Frame {
Frame f;
Label label;
frame()
{
	f=new Frame();
	
	label = new Label("enter number of students");
	label.setBounds(143, 68, 136, 22);
	this.setLayout(null);
	this.add(label);
	TextField textField = new TextField();
	textField.setBounds(167, 107, 75, 22);
	this.add(textField);
	this.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e)
		{
			dispose();
		}
	});
		
	this.setVisible(true);
	this.setSize(400, 400);
}
public static void main(String ar[])
{
	frame f=new frame();
}
}
