package ihm;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.text.SimpleDateFormat;
import com.toedter.calendar.JDateChooser;
public class Modifier extends  JFrame implements ActionListener,ItemListener {
	
	//*******utilisé comme controle de version 
	//Si on ne déclare pas explicitement un serialVersionUID JVM le fera automatiquement
	//Serialization means you save the objects as bytes somewhere
	
	private static final long serialVersionUID = 1L;
	//public  Object request;
    JButton Modifier;
    JFrame frame;
    JTextField eventname;
    JTextField description;
    JTextField Place;
    JLabel lblname;
    JLabel lbldescription;
    JLabel lblplace;
    JLabel lbldate;
    private JDateChooser dateChooser;
    String selectname;
    String selectdescription;
    java.sql.Date selectdate;
    String Selectplace;
    
	public Modifier(String selectname,java.sql.Date selectdate, String selectdescription ,String Selectplace) {
		this.selectname=selectname;
		this.Selectplace=Selectplace;
		this.selectdate=selectdate;
		this.selectdescription = selectdescription;
		     frame = new JFrame("Events Management");
		     frame.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\DESKTOP\\book.png"));

                 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 frame.setLayout(new GridLayout(5,2));
                 frame.setBackground(Color.CYAN);
                 frame.setBounds(450, 190, 500, 597);;
               eventname =new JTextField(selectname);
                eventname.setSize(10,10);
                description =new JTextField(selectname);
                description.setSize(10,10);
                 Place =new JTextField(selectdescription);
                
         		lblname =new JLabel("Event Name");
        		lbldescription =new JLabel("Event Description");
        		lblplace =new JLabel("Place");
        		lbldate =new JLabel("Date");
        		 Modifier=new JButton("Modifier");
        		 dateChooser = new JDateChooser();
        		 dateChooser.setDateFormatString("yyyy-MM-dd");
        		 dateChooser.getDateFormatString();
        		 dateChooser.setDate(selectdate);
        		 Modifier.setSize( 30, 20);
        		 
                frame.add(lblname);
                frame.add(eventname);
                frame.add(lblplace);
                frame.add(Place);
                frame.add(lbldate);
                frame.add(dateChooser);
               frame.add(lbldescription);
               frame.add(description);
                
                 frame.add(Modifier);
                 frame.setVisible(true);
                
                 Modifier.addActionListener(this);
                 
                
               
		
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
	
		
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
	              
	              String query ="Update events set name='"+ eventname.getText()+"', description='"+description.getText()+"' ,place='"+Place.getText()+"', date='"+ sdf.format(dateChooser.getDate())+"' where name = '"+selectname +"'"
	              		+ " and description = '"+selectdescription+"' and place = '"+Selectplace +"' and date='"+selectdate +"'" ;
	            //une instruction SQL est précompilée et stockée dans un objet PreparedStatement. 
	                //Cet objet peut ensuite être utilisé pour exécuter 
	                //efficacement cette instruction plusieurs fois
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


