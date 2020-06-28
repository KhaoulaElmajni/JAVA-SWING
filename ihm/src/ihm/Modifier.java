package ihm;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.*;
import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.sql.Date;
import com.toedter.calendar.JDateChooser;
public class Modifier extends  JFrame implements ActionListener,ItemListener {
	
	private static final long serialVersionUID = 1L;
	//public  Object request;
    JButton Modifier;
    JFrame frame;
    JTextField eventname;
    JTextField description;
    JTextField Place;
    JLabel lblname;
    JLabel lbldescription;
    JLabel place;
    JLabel date;
    private JDateChooser dateChooser;
    String selecttitre;
    String selectdescription;
    java.sql.Date selctdate;
    String Selectplace;
    
	public Modifier(String selecttitre,java.sql.Date selctdate, String selctdescription ,String Selectplace) {
		this.selecttitre=selecttitre;
		this.Selectplace=Selectplace;
		this.selctdate=selctdate;
		this.selectdescription = selctdescription;
		     frame = new JFrame("event");
                 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 frame.setLayout(new GridLayout(4,2));
                 frame.setSize(500,500);
               eventname =new JTextField(selecttitre);
                eventname.setSize(10,10);
                description =new JTextField(selecttitre);
                description.setSize(10,10);
                 Place =new JTextField(selectdescription);
                
         		lblname =new JLabel("Event Name");
        		lbldescription =new JLabel("Event Description");
        		place =new JLabel("Place");
        		date =new JLabel("Date");
        		 Modifier=new JButton("Modifier");
        		 dateChooser = new JDateChooser();
        		 dateChooser.setDateFormatString("yyyy-MM-dd");
        		 dateChooser.getDateFormatString();
        		 dateChooser.setDate(selctdate);
        		 Modifier.setSize( 30, 20);
        		 
                frame.add(lblname);
                frame.add(eventname);
                frame.add(place);
                frame.add(Place);
                frame.add(date);
               // frame.add(Date);
                frame.add(dateChooser);
                 frame.add(Modifier);
                 frame.setVisible(true);
                
                 Modifier.addActionListener(this);
                 
                
               
		
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("hello");
		if(arg0.getSource()==Modifier) {
			
			 try {
	              Class.forName("com.mysql.jdbc.Driver");
	              String url = "jdbc:mysql://localhost:3306/ihm-java-swing";
	              String name = "khaoula";
	              String password = "khaoula";
	           
	              SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	              System.out.println(sdf.format(dateChooser.getDate()));
	              java.sql.Connection con = DriverManager.getConnection(url, name, password);
	              String query ="Update events set name='"+ eventname.getText()+"', description='"+description.getText()+"' ,place='"+Place.getText()+"', date='"+ sdf.format(dateChooser.getDate())+"' where name = '"+selecttitre +"'"
	              		+ " and description = '"+selectdescription+"' and place = '"+Selectplace +"' and date='"+selctdate +"'" ;
	              PreparedStatement preparedStmt = con.prepareStatement(query);
	              
	              preparedStmt.executeUpdate();
	              
	              con.close(); 
	              EventsList eventsList=new EventsList();
			 }
			 catch(Exception e) {
				 System.err.println("Got an exception! ");
			      System.err.println(e.getMessage());
			 }
			 
		}
		}
	

}


