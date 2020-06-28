package jPanel;

import java.awt.EventQueue;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import com.toedter.calendar.JCalendar;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JRadioButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.PreparedStatement;
import com.toedter.calendar.*;


public class tt extends Welcome {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	 static JLabel l; 
	 private JLabel l_2;
	 private JButton btnNewButton;
	  

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tt window = new tt();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public tt() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 757, 427);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{89, 109, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{174, 23, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JCalendar calendar = new JCalendar();
		calendar.getDayChooser().getDayPanel().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		GridBagConstraints gbc_calendar = new GridBagConstraints();
		gbc_calendar.insets = new Insets(0, 0, 5, 5);
		gbc_calendar.fill = GridBagConstraints.BOTH;
		gbc_calendar.gridx = 1;
		gbc_calendar.gridy = 0;
		frame.getContentPane().add(calendar, gbc_calendar);
		
		
		l = new JLabel(); 
		  
        // add text to label 
		JLabel l_1=new JLabel("Le nom de votre événement:");
		
		GridBagConstraints gbc_l_1 = new GridBagConstraints();
		gbc_l_1.insets = new Insets(0, 0, 5, 5);
		gbc_l_1.gridx = 0;
		gbc_l_1.gridy = 2;
		frame.getContentPane().add(l_1, gbc_l_1);
		
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		frame.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		l_2 = new JLabel("Description de l'événement");
		GridBagConstraints gbc_l_2 = new GridBagConstraints();
		gbc_l_2.insets = new Insets(0, 0, 5, 5);
		gbc_l_2.anchor = GridBagConstraints.EAST;
		gbc_l_2.gridx = 0;
		gbc_l_2.gridy = 3;
		frame.getContentPane().add(l_2, gbc_l_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 3;
		frame.getContentPane().add(textField_1, gbc_textField_1);
       
       
       JButton a=new JButton("Ajouter l'évenement");
       a.addMouseListener(new MouseAdapter() {
    	   
       	@Override
       	public void mouseClicked(MouseEvent arg0) {
       		
       		//textField.setText("ddd");
       	 
       	}
       });
       GridBagConstraints gbc_a = new GridBagConstraints();
       gbc_a.insets = new Insets(0, 0, 5, 5);
       gbc_a.gridx = 1;
       gbc_a.gridy = 5;
       frame.getContentPane().add(a, gbc_a);
       
       btnNewButton = new JButton("Afficher tout les events");
       btnNewButton.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e) {
       		
       		Welcome Second = new Welcome();
       		Second.setVisible(true);
       	}
       });
       GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
       gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
       gbc_btnNewButton.gridx = 3;
       gbc_btnNewButton.gridy = 5;
       frame.getContentPane().add(btnNewButton, gbc_btnNewButton);
       
        a.addActionListener(new ActionListener(){  
      		public void actionPerformed(ActionEvent e){ 
      			
      			
      			//textField.setText("ddd");
      			//calendar.getDate(); 
      			//Date date = calendar.getDate().toInstant();  
      		    //SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
      		   // String strDate = formatter.format(date);  
      			//JOptionPane.showMessageDialog(null,calendar.getDate().toInstant(),"Ajout",1);
      			
      			
      			
      			  //String x = calendar.getDate().toInstant().toString();
      			try {
      	             PreparedStatement pst= Connexion.GetCon().prepareStatement("INSERT INTO events VALUES(?,?,?)");
      	             pst.clearParameters();
      	             pst.setString(1,textField.getText());
      	             pst.setString(2,textField_1.getText());
      	             pst.setString(3,calendar.getDate().toInstant().toString());
      	             pst.executeUpdate();
      	            
      	             /* Pop Up*/
      	            JOptionPane.showMessageDialog(null,"Evénement Bien Ajouté","Success",1);
      	         } catch (Exception e1) {
      	              System.err.println(e1.getMessage());
      	         }  }  
      		    });  
        frame.setVisible(true);
          
		
	
	}

}
