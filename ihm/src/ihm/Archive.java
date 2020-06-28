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

public class Archive extends JFrame implements ActionListener,ItemListener{
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	

    static JTable mysTable;
    JButton desarchiveButton;
    JButton delete;
   
    JTable table;
	
	 public Archive ()
		 {
			 setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			 
			 setBounds(450, 190, 500, 597);
			 setResizable(true);
		        setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\DESKTOP\\book.png"));
		        setTitle("Archive List");
		        contentPane = new JPanel();
		        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		        setContentPane(contentPane);
		        contentPane.setLayout(null);
		        contentPane.setBackground(Color.CYAN);
		        
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
		                FillTable(con,table, "select  name,description, place, date from events where isarchived=true");
		                this.add(sp);
		                this.setVisible(true);
		               
		            } catch (SQLException e) {
		                e.printStackTrace();
		            }   
		        } catch (ClassNotFoundException e) {
		            e.printStackTrace();
		        } 
		        
		        
		        
		        
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
		      //------desarchive button--------
		        
		       desarchiveButton = new JButton("Desarchivate");
		        desarchiveButton.setForeground(new Color(0, 0, 0));
		        desarchiveButton.setBackground(UIManager.getColor("Button.disabledForeground"));
		        desarchiveButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		        desarchiveButton.addActionListener(new ActionListener() {
		            @Override
					public void actionPerformed(ActionEvent e) {
		                
		            

		            }
		        });
		        desarchiveButton.setBounds(500, 460, 170, 50);
		        contentPane.add(desarchiveButton);
		        
		        
		        
		      //------delete button--------
		        
		        delete = new JButton("Delete");
		        delete.setForeground(new Color(0, 0, 0));
		        delete.setBackground(UIManager.getColor("Button.disabledForeground"));
		        delete.setFont(new Font("Tahoma", Font.PLAIN, 24));
		        delete.addActionListener(new ActionListener() {
			            @Override
						public void actionPerformed(ActionEvent e) {
			                
			            

			            }
			        });
		        delete.setBounds(300, 460, 220, 50);
			        contentPane.add(delete);
			        
			        
			        desarchiveButton.addActionListener(this);
			        delete.addActionListener(this);
			        
		}
	 
	 
	 
	 
	 public static  void FillTable(java.sql.Connection conn, JTable table, String Query)
	 {
	     try
	     {
	         //CreateConnection();
	         java.sql.Statement stat = conn.createStatement();
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
	         conn.close();
	     }
	     catch( SQLException e)
	     {
	     }
	 }




	




	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	public void actionPerformed(ActionEvent arg0) {
		int selct=table.getSelectedRow();
		String selcttitre=(String) table.getModel().getValueAt(selct,0);
		String selctdescription=(String) table.getModel().getValueAt(selct,1);
		String selctplace=(String) table.getModel().getValueAt(selct,2);
		java.sql.Date selctdate= (java.sql.Date) table.getModel().getValueAt(selct,3);
		if(arg0.getSource()==desarchiveButton) {
			try {
	            Class.forName("com.mysql.jdbc.Driver");
	            String url = "jdbc:mysql://localhost:3306/ihm-java-swing";
	            String name = "khaoula";
	            String password = "khaoula";
	         
	            java.sql.Connection con = DriverManager.getConnection(url, name, password);
	            String query ="Update events set isarchived=false where name = '"+selcttitre +"' and description ='"+selctdescription+ "' and place = '"+selctplace +"' and date='"+selctdate +"'" ;
	            PreparedStatement preparedStmt = con.prepareStatement(query);
	        
	            preparedStmt.executeUpdate();
	            
	            con.close(); 
	            
	            dispose();
	            Archive archive = new Archive();
	            archive.setVisible(true);
	          
			 }
			 catch(Exception e) {
				 System.err.println("Got an exception! ");
			      System.err.println(e.getMessage());
			 }
			
		}else if(arg0.getSource()==delete) {
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
	              Archive archive = new Archive();
	              archive.setVisible(true);
	              
	             
			 }
			 catch(Exception e) {
				 System.err.println("Got an exception! ");
			      System.err.println(e.getMessage());
			 }
		}
		
	}
	 
	 
	
}
