package ihm;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class UserHome extends JFrame {

	//*******utilisé comme controle de version 
	//Si on ne déclare pas explicitement un serialVersionUID JVM le fera automatiquement
	//Serialization means you save the objects as bytes somewhere
	
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
    	//*******for controling the components***********
    	//***Swing processing is done in a thread called EDT (Event Dispatching Thread). 
    	//Therefore we would block the GUI if we would compute some long calculations in this thread
//The way to go here is to process our calculation in a different thread, so our GUI stays responsive 
    	
        EventQueue.invokeLater(new Runnable() {
            @Override
			public void run() {
                try {
                    UserHome frame = new UserHome();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public UserHome() {

    }

    /**
     * Create the frame.
     */
    public UserHome(String userChangedPWD) {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(450, 30, 1014, 1000);
        setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\DESKTOP\\book.png"));
        setResizable(true);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.CYAN);
        //******logout******
        JButton logoutButton = new JButton("Logout");
        logoutButton.setForeground(new Color(0, 0, 0));
        logoutButton.setBackground(UIManager.getColor("Button.disabledForeground"));
        logoutButton.setFont(new Font("Tahoma", Font.PLAIN, 39));
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

                obj.setTitle("Events Management");
                obj.setVisible(true);

            }
        });
        logoutButton.setBounds(247, 118, 491, 114);
        contentPane.add(logoutButton);
        //*****change password*****
        JButton changePwdButton = new JButton("Change-password\r\n");
        changePwdButton.setBackground(UIManager.getColor("Button.disabledForeground"));
        changePwdButton.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
            	//*****userChangedPWD is the new PWD*********
                ChangePassword CP = new ChangePassword(userChangedPWD);
                CP.setTitle("Change Password");
                CP.setVisible(true);

            }
        });
        changePwdButton.setFont(new Font("Tahoma", Font.PLAIN, 35));
        changePwdButton.setBounds(247, 250, 491, 114);
        contentPane.add(changePwdButton);
        
        
        //*********** events list btn*********
        JButton eventsListButton = new JButton("Events List\r\n");
        eventsListButton.setBackground(UIManager.getColor("Button.disabledForeground"));
        eventsListButton.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
            	dispose();
                
                EventsList eventsList = new EventsList();
                eventsList.setTitle("Events List");
                eventsList.setVisible(true);
               
            }
        });
        eventsListButton.setFont(new Font("Tahoma", Font.PLAIN, 35));
        eventsListButton.setBounds(247, 382, 491, 114);
        contentPane.add(eventsListButton);
        
        //*********archive list btn************
        
        JButton archiveListButton = new JButton("Archive List\r\n");
        archiveListButton.setBackground(UIManager.getColor("Button.disabledForeground"));
        archiveListButton.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
            	dispose();
                
            	Archive archiveList = new Archive();
            	archiveList.setTitle("Archive List");
            	archiveList.setVisible(true);

            }
        });
        archiveListButton.setFont(new Font("Tahoma", Font.PLAIN, 35));
        archiveListButton.setBounds(247, 514, 491, 114);
        contentPane.add(archiveListButton);
        
        
        //*************add event btn************
        
        JButton addEventButton = new JButton("Add Event\r\n");
        addEventButton.setBackground(UIManager.getColor("Button.disabledForeground"));
        addEventButton.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
            	dispose();
                
            	AddEvent addEvent = new AddEvent();
            	addEvent.setTitle("Add Event");
            	addEvent.setVisible(true);

            }
        });
        addEventButton.setFont(new Font("Tahoma", Font.PLAIN, 35));
        addEventButton.setBounds(247, 646, 491, 114);
        contentPane.add(addEventButton);
    }
    
}
