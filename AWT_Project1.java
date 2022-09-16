//	Creating a Basic Project for AWT- Linked List
package Test_GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;

class myFrame1 extends Frame
{
	LinkedList<String> obj = new LinkedList<>();
	TextArea ta;
	TextField tf;
	Button b1,b2,b3,b4,b5;
	Label l;
	
	Menu File,Sub;
	MenuItem Open,Save,Close,CloseAll;
	myFrame1()
	{
		super("Linked List");
		ta = new TextArea(20,45);
		tf = new TextField(50);
		b1 = new Button("Add");
		b2 = new Button("Delete");
		b3 = new Button("Insert Last");
		b4 = new Button("Search");
		b5 = new Button("Display");
		
		setLayout(new FlowLayout());
		
		File = new Menu("File");
		Open = new MenuItem("Open");
		Save = new MenuItem("Save");
		Close = new MenuItem("Close");
		CloseAll = new MenuItem("CloseAll");
		
		File.add(Open);
		File.add(Save);
		File.add(Close);
		File.add(CloseAll);
		
		MenuBar mb = new MenuBar();
		
		mb.add(File);
		setMenuBar(mb);
		
		repaint();
		
		add(ta);
		add(tf);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		ta.setBackground(Color.white);
		tf.setFont(new Font("Times New Roman",Font.PLAIN,10));
		b1.setFont(new Font("Times New Roman",Font.BOLD,10));
		b2.setFont(new Font("Times New Roman",Font.BOLD,10));
		b2.setForeground(Color.red);
		b3.setFont(new Font("Times New Roman",Font.BOLD,10));
		b4.setFont(new Font("Times New Roman",Font.BOLD,10));
		b5.setFont(new Font("Times New Roman",Font.BOLD,10));
		addWindowListener(new Closing());
		b1.addActionListener(new myAction());
		b2.addActionListener(new myAction());
		b3.addActionListener(new myAction());
		b4.addActionListener(new myAction());
		b5.addActionListener(new myAction());
	}
	public void Paint(Graphics g)
	{
		g.setFont(new Font("Times New Roman",Font.BOLD,30));
	}
	class myAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource()==b1)
			{
//				ta.setText("Enter The Number That You want to add");
//				String m = tf.getText();
//				obj.add(m);
//				ta.setText(tf.getText());
//				ta.setText(m+" added to The List");
//				ta.setText("Adding At Begin");
				ta.append(tf.getText()+" Has Been Added to Last \n");							//ta.append is for String.
				obj.add(tf.getText());
//				ta.setText(tf.getText());
			}
			else if(e.getSource()==b2)
			{
				obj.remove(obj.size()-1);
			}
			else if(e.getSource()==b3)
			{
				ta.append(tf.getText()+" Has been added to Last \n");
				obj.addLast(tf.getText());
			}
			else if(e.getSource()==b4)
			{
				int i=0;
				String m = tf.getText();
				for(int j=0 ; j<obj.size() ; j++)
				{
					if(tf.getText().equals(obj.get(j)))
					{
						ta.append(tf.getText()+" Has been  Found at Index "+j);
						i++;
						break;
					}
				}
				if(i==0)
				{
					ta.append("The "+tf.getText()+" is not Found.");
				}
			}
			else if(e.getSource()==b5)
			{
				if(obj.isEmpty())
				{
					ta.append("The List is Empty");
				}
				else
				{

					ta.setText("The Elements in the List are \n ");
					for(int i=0 ; i<obj.size() ; i++)
					{
//						ta.setText(obj.get(i)+"\n");
						ta.append(obj.get(i)+"\n");
					}
				}
			}
		}
		
	}
	class Closing extends WindowAdapter
	{
		public void windowClosing(WindowEvent e)
		{
			System.exit(0);
		}
	}
}
public class AWT_Project1 
{
	public static void main(String[] args) 
	{
		myFrame1 mf = new myFrame1();
		mf.setSize(400, 430);
		mf.setVisible(true);
	}
}
