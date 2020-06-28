package jPanel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JEditorPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
public class Welcome extends JFrame {

	private JFrame frameX;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome window = new Welcome();
					window.frameX.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Welcome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameX = new JFrame();
		frameX.setBounds(100, 100, 673, 409);
		frameX.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnAfficher = new JButton("Afficher");
		btnAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

	             try {
	            Statement st = Connexion.GetCon().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	            ResultSet rs =st.executeQuery("SELECT * FROM events");
	            
	            Vector<String> titre= new Vector<String>();
	        titre.add("Nom Events");
	        titre.add("Description");
	        titre.add("Date");
	        
	        
	        Vector<Vector<Object>> matrice = new Vector<Vector<Object>>();
	        
	        while (rs.next()) {
	           // Contact C=new Contact(rs.getString("CIN"),rs.getString("NOM"),rs.getString("TEL"),rs.getString("PRENOM"));
	            Vector<Object> V= new Vector<Object>();
	        
	            V.add(rs.getString("nom"));
	            V.add(rs.getString("description"));
	            V.add(rs.getString("dateEvent"));
	           
	            
	            matrice.add(V);
	        
	        table.setModel(new javax.swing.table.DefaultTableModel(matrice,titre));
	            
	        }
	        
	       
	        } catch (Exception e) {
	            System.err.println(e.getMessage());
	        }
		        
		       
			}
		});
		
		table = new JTable();
		GroupLayout groupLayout = new GroupLayout(frameX.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 657, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(243, Short.MAX_VALUE)
					.addComponent(btnAfficher, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
					.addGap(225))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(table, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
					.addComponent(btnAfficher, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addGap(86))
		);
		frameX.getContentPane().setLayout(groupLayout);
		
		
		
		
	      
		
		
	}

}
