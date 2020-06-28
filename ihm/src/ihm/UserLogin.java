package ihm;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel;

@SuppressWarnings("deprecation")
public class UserLogin extends JFrame {

	//*******utilisé comme controle de version 
	//Si on ne déclare pas explicitement un serialVersionUID JVM le fera automatiquement
	//Serialization means you save the objects as bytes somewhere
    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JPanel contentPane;

    public static String username;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
			public void run() {
                try {
                    UserLogin login = new UserLogin();
                    login.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     * @throws UnsupportedLookAndFeelException 
     */
    public UserLogin() throws UnsupportedLookAndFeelException {
    	//*******for the design******
    	UIManager.setLookAndFeel(new NimbusLookAndFeel());
    	//*******for the click on exit the process end********
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //*******for the place in the screen (x,y,width,heigth)
        setBounds(450, 190, 1014, 597);
        //******title of the window****
        setTitle("Events Managemant");
        //********** icon image ********
        setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\DESKTOP\\book.png"));
        //*******giving the permission of resizing the window********
        setResizable(true);
        //********adding a container of type contentPane*********
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //*********login label********
        JLabel loginLbl = new JLabel("Login");
        loginLbl.setForeground(Color.BLACK);
        loginLbl.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        loginLbl.setBounds(423, 13, 273, 93);
        contentPane.add(loginLbl);

        //********login input******
        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        textField.setBounds(481, 170, 281, 68);
        contentPane.add(textField);
        textField.setColumns(10);

        //*********pwd input ************
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(481, 286, 281, 68);
        contentPane.add(passwordField);

        //********username lbl******
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBackground(Color.BLACK);
        lblUsername.setForeground(Color.BLACK);
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblUsername.setBounds(250, 166, 193, 52);
        contentPane.add(lblUsername);

        //************pwd lbl******
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setBackground(Color.CYAN);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblPassword.setBounds(250, 286, 193, 52);
        contentPane.add(lblPassword);

        //*******login btn********
        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        loginButton.setBounds(545, 392, 162, 73);
        loginButton.addActionListener(new ActionListener() {

        	//*********overriding of actionPerformed fct to manage the login process********
            @Override
			public void actionPerformed(ActionEvent e) {
              final String userName = textField.getText();
              //*********** for the return btn to the UserHome********//
              username = userName;
              
                String password = passwordField.getText();
                try {
                	//**************the cnx with the SQL DATABASE**********
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ihm-java-swing",
                        "khaoula", "khaoula");

                    //une instruction SQL est précompilée et stockée dans un objet PreparedStatement. 
                    //Cet objet peut ensuite être utilisé pour exécuter 
                    //efficacement cette instruction plusieurs fois.
                    PreparedStatement st = connection
                        .prepareStatement("Select name, password from user where name=? and password=?");

                    //******set the parameter to thr java string value & the driver convert it to a varchar or long
                    //*****varchar value when it sends it to DB
                    st.setString(1, userName);
     
                    st.setString(2, password);
                    //****table of data from the DB result, generated by executing a query
                    //****the rs cursor pointing before the first row
                    ResultSet rs = st.executeQuery();
                    //****The next method moves thecursor to the next row
                    if (rs.next()) {
                    	//***** destroy & undisplay the login frame
                        dispose();
                        UserHome home = new UserHome(userName);
                        home.setTitle("Welcome");
                        home.setVisible(true);
                        //*******show a message dialog in case of success login
                        JOptionPane.showMessageDialog(loginButton, "You have successfully logged in");
                    } else {
                    	//*******show a message dialog in case of failed login
                        JOptionPane.showMessageDialog(loginButton, "Wrong Username & Password");
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });

        contentPane.add(loginButton);

       
   
    }
}