package ihm;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;


public class AddEvent extends JFrame{

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JDateChooser dateChooser;
	private JTextField eventName;
	private JTextField eventDescription;
	private JTextField eventPlace;
	public AddEvent ()
	 {
		 setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		 
		 setBounds(450, 190, 1014, 597);
	        setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\DESKTOP\\book.png"));
	        setTitle("Add Event");
		 setResizable(true);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);
	        //-----eventName----
	        eventName = new JTextField();
	        eventName.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        eventName.setBounds(470, 30, 500, 68);
	        contentPane.add(eventName);
	        eventName.setColumns(10);
	      //---------label event name---
	        JLabel lblEventName = new JLabel("Event Name");
	        lblEventName.setBackground(Color.BLACK);
	        lblEventName.setForeground(Color.BLACK);
	        lblEventName.setFont(new Font("Tahoma", Font.PLAIN, 31));
	        lblEventName.setBounds(210, 30, 500, 68);
	        contentPane.add(lblEventName);
	        
	      //-----event description----
	        eventDescription = new JTextField();
	        eventDescription.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        eventDescription.setBounds(470, 110, 500, 68);
	        contentPane.add(eventDescription);
	        eventDescription.setColumns(10);
	      //---------label event description---
	        JLabel lblEventDescription = new JLabel("Event Description");
	        lblEventDescription.setBackground(Color.BLACK);
	        lblEventDescription.setForeground(Color.BLACK);
	        lblEventDescription.setFont(new Font("Tahoma", Font.PLAIN, 31));
	        lblEventDescription.setBounds(210, 110, 500, 68);
	        contentPane.add(lblEventDescription);
	        
	      //-----event place----
	        eventPlace = new JTextField();
	        eventPlace.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        eventPlace.setBounds(470, 190, 500, 68);
	        contentPane.add(eventPlace);
	        eventPlace.setColumns(10);
	        //---------label event place---
	        JLabel lblEventPLace = new JLabel("Event Place");
	        lblEventPLace.setBackground(Color.BLACK);
	        lblEventPLace.setForeground(Color.BLACK);
	        lblEventPLace.setFont(new Font("Tahoma", Font.PLAIN, 31));
	        lblEventPLace.setBounds(210, 190, 500, 68);
	        contentPane.add(lblEventPLace);
	        
	        //---------calendar----------------
	        
	        dateChooser = new JDateChooser();
	        dateChooser.setFont(new Font("Tahoma",Font.PLAIN, 20));
	        dateChooser.setBounds(470, 270, 500, 68);
	        contentPane.add(dateChooser);
	        dateChooser.setDateFormatString("yyyy-MM-dd");
	      //---------label event place---
	        JLabel lblCalendar = new JLabel("Date and Time");
	        lblCalendar.setBackground(Color.BLACK);
	        lblCalendar.setForeground(Color.BLACK);
	        lblCalendar.setFont(new Font("Tahoma", Font.PLAIN, 31));
	        lblCalendar.setBounds(210, 270, 500, 68);
	        contentPane.add(lblCalendar);
	    
	        
	        //-----logout button----
	        JButton logoutButton = new JButton("Logout");
	        logoutButton.setForeground(new Color(0, 0, 0));
	        logoutButton.setBackground(UIManager.getColor("Button.disabledForeground"));
	        logoutButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
	        logoutButton.addActionListener(new ActionListener() {
	            @Override
				public void actionPerformed(ActionEvent e) {
	                int a = JOptionPane.showConfirmDialog(logoutButton, "Are you sure?");
	                // JOptionPane.setRootFrame(null);
	                if (a == JOptionPane.YES_OPTION) {
	                    dispose();
	                    UserLogin obj = null;
						try {
							obj = new UserLogin();
						} catch (UnsupportedLookAndFeelException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	                    obj.setTitle("User-Login");
	                    obj.setVisible(true);
	                }
	                
	                dispose();
	                UserLogin obj = null;
					try {
						obj = new UserLogin();
					} catch (UnsupportedLookAndFeelException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

	                obj.setTitle("User-Login");
	                obj.setVisible(true);

	            }
	        });
	        logoutButton.setBounds(860, 460, 120, 50);
	        contentPane.add(logoutButton);
	        
//------return button---------
	        
	        JButton returnButton = new JButton("Return");
	        returnButton.setForeground(new Color(0, 0, 0));
	        returnButton.setBackground(UIManager.getColor("Button.disabledForeground"));
	        returnButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
	        returnButton.addActionListener(new ActionListener() {
	            @Override
				public void actionPerformed(ActionEvent e) {
	                
	                
	                dispose();
	                UserHome ah = new UserHome(UserLogin.username);
                    ah.setTitle("Welcome");
                    ah.setVisible(true);
                    
                   

	            }
	        });
	        returnButton.setBounds(700, 460, 120, 50);
	        contentPane.add(returnButton);
	        
        //------add button---------
	        
	        JButton addButton = new JButton("Add");
	        addButton.setForeground(new Color(0, 0, 0));
	        addButton.setBackground(UIManager.getColor("Button.disabledForeground"));
	        addButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
	        addButton.addActionListener(new ActionListener() {
	            @Override
				public void actionPerformed(ActionEvent e) { 
	            	
	            	 String eventname = eventName.getText();
	                  String eventDesc = eventDescription.getText();
	                  String eventplace = eventPlace.getText();
	                  DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	                  String eventDate = df.format(dateChooser.getDate());
                   
	                  try {
	                	  
	                      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ihm-java-swing",
	                          "khaoula", "khaoula");

	                      java.sql.Statement st = connection.createStatement();
	                      
	                      String query = "INSERT INTO events (name, description,place,isarchived, date) VALUES ( "
	                      		+ "'"+eventname+"','"+eventDesc+"','"+eventplace+"',"+"false ,'"+eventDate+"')";
	                      st =  connection.createStatement();
	                       st.executeUpdate(query);
	                      JOptionPane.showMessageDialog(null, "The Event has been added successfully");
	                      
	                  } catch (SQLException sqlException) {
	                      sqlException.printStackTrace();
	                  }
	                  
	                  eventName.setText("");
	                  eventDescription.setText("");
	                  eventPlace.setText("");
	                  

	            }
	        });
	        addButton.setBounds(540, 460, 120, 50);
	        contentPane.add(addButton);
	}
}
