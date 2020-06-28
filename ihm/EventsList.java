package ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ihm.UserLogin;

public class EventsList extends JFrame implements ActionListener,ItemListener{
	JButton updateButton;
	JButton deleteButton;
	JButton archivateButton;

    static JTable mysTable;
    JTable table;
  
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	 public EventsList (){
		 setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		 
		 setBounds(450, 190, 1014, 597);
	        setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\DESKTOP\\book.png"));
	        setTitle("Events List");
		 setResizable(true);
		 contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);
	        
	        
	       
	          this.setLayout(new FlowLayout());
	          
	        
	        //----------------affichage------------------
	        mysTable = new JTable();
	          JScrollPane myPanel = new JScrollPane(mysTable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	                                                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

	          mysTable.setPreferredScrollableViewportSize(new Dimension(500,70));
	        
	          try {
	              Class.forName("com.mysql.jdbc.Driver");
	              System.out.println("Driver loading success!");
	              String url = "jdbc:mysql://localhost:3306/ihm-java-swing";
	              String name = "khaoula";
	              String password = "khaoula";

	              try {
	                  java.sql.Connection con = DriverManager.getConnection(url, name, password);
	                  System.out.println("Connected.");
	                  String col[] = {"Name","Description", "place", "date"};

	                  DefaultTableModel tableModel = new DefaultTableModel(col, 0);
	                                                            
	                   table = new JTable(tableModel);
	                  
	                  table.setBounds(30, 40, 1014, 20);                 
	                  JScrollPane sp = new JScrollPane(table); 
	                  FillTable(con,table, "select  name,description , place, date from events where isarchived='false'");
	                  
	                  this.add(sp);
	                  this.setVisible(true);
	                 
	              } catch (SQLException e) {
	                  e.printStackTrace();
	              }   
	          } catch (ClassNotFoundException e) {
	              e.printStackTrace();
	          } 
	        
	        
	        
	        //----------logout button ----------
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
	                    obj.setTitle("Events Managemt");
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
	        
	        //------return button
	        
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
	        
	        
          //------delete button--------
	        
	        deleteButton = new JButton("Delete");
	        deleteButton.setForeground(new Color(0, 0, 0));
	        deleteButton.setBackground(UIManager.getColor("Button.disabledForeground"));
	        deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
	        deleteButton.addActionListener(new ActionListener() {
	            @Override
				public void actionPerformed(ActionEvent e) {
	                
	            
	            }
	        });
	        deleteButton.setBounds(540, 460, 120, 50);
	        contentPane.add(deleteButton);
	        
             //------Archived button--------
	        
	        archivateButton = new JButton("Archivate");
	        archivateButton.setForeground(new Color(0, 0, 0));
	        archivateButton.setBackground(UIManager.getColor("Button.disabledForeground"));
	        archivateButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
	        archivateButton.addActionListener(new ActionListener() {
	            @Override
				public void actionPerformed(ActionEvent e) {
	                
	            

	            }
	        });
	        archivateButton.setBounds(380, 460, 140, 50);
	        contentPane.add(archivateButton);
	        
              //------update button--------
	        
	         updateButton = new JButton("Update");
	        updateButton.setForeground(new Color(0, 0, 0));
	        updateButton.setBackground(UIManager.getColor("Button.disabledForeground"));
	        updateButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
	        updateButton.addActionListener(new ActionListener() {
	            @Override
				public void actionPerformed(ActionEvent e) {
	                
	            

	            }
	        });
	        updateButton.setBounds(220, 460, 120, 50);
	        contentPane.add(updateButton);
	        
	        
	        deleteButton.addActionListener(this);
	        updateButton.addActionListener(this);
	        archivateButton.addActionListener(this);
	}
	 public static  void FillTable(java.sql.Connection con, JTable table, String Query)
	    {
	        try
	        {
	            //CreateConnection();
	        	java.sql.Statement stat = ((java.sql.Connection) con).createStatement();
	            ResultSet rs = stat.executeQuery(Query);
	           

	            //To remove previously added rows
	            while(table.getRowCount() > 0) 
	            {
	                ((DefaultTableModel) table.getModel()).removeRow(0);
	               
	            }
	            
	            int columns = rs.getMetaData().getColumnCount();
	           
	            while(rs.next())
	            {  
	                Object[] row = new Object[columns];
	                for (int i = 1; i <= columns; i++)
	                {  
	                    row[i - 1] = rs.getObject(i);
	                    System.out.println( rs.getObject(i));
	                }
	                ((DefaultTableModel) table.getModel()).insertRow(rs.getRow()-1,row);
	            }

	            rs.close();
	            stat.close();
	            con.close();
	        }
	        catch( SQLException e)
	        {
	        }
	    }
	 
	 
	 public void actionPerformed(ActionEvent arg0) {
			
			int selct=table.getSelectedRow();
			
			String selcttitre=(String) table.getModel().getValueAt(selct,0);
			String selctdescription=(String) table.getModel().getValueAt(selct,1);
			String selctplace=(String) table.getModel().getValueAt(selct,2);
			java.sql.Date selctdate= (java.sql.Date) table.getModel().getValueAt(selct,3);
		
			if(arg0.getSource()== updateButton) {
	
			
				Modifier modifier=new Modifier(selcttitre,selctdate,selctdescription,selctplace);
				
			}else if(arg0.getSource()== deleteButton){
				
				 try {
		              Class.forName("com.mysql.jdbc.Driver");
		              String url = "jdbc:mysql://localhost:3306/ihm-java-swing";
		              String name = "khaoula";
		              String password = "khaoula";
		              
		              java.sql.Connection con = DriverManager.getConnection(url, name, password);
		              String query ="delete from events where name = '"+selcttitre +"' and description ='"+selctdescription+"' and place = '"+selctplace +"' and date='"+selctdate +"' " ;
		              PreparedStatement preparedStmt = con.prepareStatement(query);
		              
		              preparedStmt.executeUpdate();
		              
		              con.close();
		              dispose();
		              EventsList eventList = new EventsList();
		              eventList.setVisible(true);
		              
		             
				 }
				 catch(Exception e) {
					 System.err.println("Got an exception! ");
				      System.err.println(e.getMessage());
				 }
				 
			}else if(arg0.getSource()== archivateButton){
				 try {
		              Class.forName("com.mysql.jdbc.Driver");
		              String url = "jdbc:mysql://localhost:3306/ihm-java-swing";
		              String name = "khaoula";
		              String password = "khaoula";
		             
		              java.sql.Connection con = DriverManager.getConnection(url, name, password);
		              String query ="Update events set isarchived=true where name = '"+selcttitre +"'and description = '"+selctdescription+"'and place = '"+selctplace +"' and date='"+selctdate +"'" ;
		              PreparedStatement preparedStmt = con.prepareStatement(query);
		              
		              preparedStmt.executeUpdate();
		              
		              con.close(); 

		              dispose();
		              EventsList eventList = new EventsList();
		              eventList.setVisible(true);
		              
				 }
				 catch(Exception e) {
					 System.err.println("Got an exception! ");
				      System.err.println(e.getMessage());
				 }
			}
		}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	    
	    
	  
	    
	    
	    
	    
	    
	    
	    
	    
	    
	 
}
