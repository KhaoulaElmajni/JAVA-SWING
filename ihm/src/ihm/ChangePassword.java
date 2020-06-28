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
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ChangePassword extends JFrame {

	
	//*******utilisé comme controle de version 
	//Si on ne déclare pas explicitement un serialVersionUID JVM le fera automatiquement
	//Serialization means you save the objects as bytes somewhere
	
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JLabel lblEnterNewPassword;

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

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ChangePassword(String name) {
        setBounds(450, 360, 1024, 234);
        setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\DESKTOP\\book.png"));
        setBackground(Color.CYAN);
        
//********gestionnaire de de répartition*****
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 34));
        textField.setBounds(373, 35, 609, 67);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton enter = new JButton("Enter");
        enter.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {

                String pstr = textField.getText();
                try {
                    System.out.println("update password name " + name);
                    System.out.println("update password");

                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ihm-java-swing",
                        "khaoula", "khaoula");
                  //une instruction SQL est précompilée et stockée dans un objet PreparedStatement 
                    //Cet objet peut ensuite être utilisé pour exécuter 
                    //efficacement cette instruction plusieurs fois
                    PreparedStatement st = con
                        .prepareStatement("Update user set password=? where name=?");

                    st.setString(1, pstr);
                    st.setString(2, name);
                    st.executeUpdate();
                    JOptionPane.showMessageDialog(enter, "Password has been successfully changed");

                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }

            }
        });
        enter.setFont(new Font("Tahoma", Font.PLAIN, 29));
        enter.setBackground(new Color(240, 240, 240));
        enter.setBounds(438, 127, 170, 59);
        contentPane.add(enter);

        lblEnterNewPassword = new JLabel("Enter New Password :");
        lblEnterNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblEnterNewPassword.setBounds(45, 37, 326, 67);
        contentPane.add(lblEnterNewPassword);
    }
}
