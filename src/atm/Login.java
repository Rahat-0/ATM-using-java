package atm;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import atm.Main_Dialog;

public class Login extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	
	private Container c;
	private JLabel id, pass ,image;
	public JTextField uf;
	private JPasswordField pf;
	private JRadioButton customer, clerk;
	private ButtonGroup bg;
	private JButton login, reset;
	private ImageIcon img, icon, ilogin, ireset;
	private Font font;
	private Cursor cr;
	

	
	Login(){
		setBounds(340,160,610,400);
		
		component(); //this is contractor.
	}
	private void component() {
		
		c = this.getContentPane(); // c is container object.
		c.setLayout(null);
		c.setBackground(Color.LIGHT_GRAY);
		
		font = new Font("arial",Font.ITALIC,16);
		cr = new Cursor(Cursor.HAND_CURSOR);
		
		ilogin = new ImageIcon(getClass().getResource("icons/login.png"));
		ireset = new ImageIcon(getClass().getResource("icons/reset.png"));
		
		icon = new ImageIcon(getClass().getResource("icons/icon.png"));
		this.setIconImage(icon.getImage());
		
		img = new ImageIcon(getClass().getResource("icons/atm.png"));
		
		image = new JLabel("",img,JLabel.CENTER);
		image.setBounds(-10,-10,615,400);
		
		id = new JLabel();
		id.setText("Account ID:");
		id.setBounds(140,50,100,30);
		id.setForeground(Color.CYAN);
		id.setFont(font);
		
		pass = new JLabel();
		pass.setText("Password:");
		pass.setBounds(140,100,100,30);
		pass.setForeground(Color.CYAN);
		pass.setFont(font);
		
		uf = new JTextField("admin@rahat");
		uf.setBounds(250,50,190,30);
		uf.setFont(font);
		
		
		pf = new JPasswordField("123456");
		pf.setBounds(250,100,190,30);
		pf.setFont(font);
		
		bg = new ButtonGroup();
		
		customer = new JRadioButton("customer");
		customer.setBounds(170,160,100,20);
		customer.setBackground(null);
		customer.setOpaque(false);
		customer.setBackground(new Color(0,0,0,0));
		customer.setForeground(Color.white);
		c.add(customer);
		
		clerk = new JRadioButton("clerk",true);
		clerk.setBounds(280,160,100,20);
		clerk.setBackground( new Color(0,0,0,0));
		clerk.setOpaque(false);
		clerk.setForeground(Color.white);
		c.add(clerk);
		
		bg.add(customer);
		bg.add(clerk);
		
		
		login = new JButton("Login", ilogin);
		login.setForeground(Color.blue);
		login.setBounds(160,210,120,40);
		login.setCursor(cr);
		
		
			
			
			
			
	
		
		
		
	/*	   login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent he) {
				
				String s = uf.getText();
				String p = pf.getText();
				
				if(s.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Empty! Input your ID");
				}
				else if(p.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Empty! Input your Password");
				}
				else {
				

					
				if(s.equals("rahat") && p.equals("1234")) {
					
					dispose();
					Main_Dialog main = new Main_Dialog();
					main.setVisible(true);
					main.setResizable(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "invalid user or password!");
				}	
			
			}
			}});
		
	*/		 
				
				
				
			
		
		
		
		
		
		
		reset = new JButton("Reset", ireset);
		reset.setForeground(Color.blue);
		reset.setBounds(310,210,120,40);
		reset.setCursor(cr);
		reset.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				uf.setText("");
				pf.setText("");
				
			}
		});
		
		
		c.add(id);
		c.add(pass);
		c.add(uf);
		c.add(pf);
		c.add(login);
		c.add(reset);
		c.add(image);
		
		login.addActionListener(this);
		
		
	}
		
	
@SuppressWarnings("deprecation")
public void actionPerformed(ActionEvent evt) {
	
	
	//public void changeButtonStatus(boolean flag) {
	//	deposit.setEnabled(flag);
		
	//}
	String user = uf.getText();
	//DepositDialog framei= new DepositDialog();
	//framei.ac.setText(user);
	//framei.ac.setVisible(true);
	
	String pass = pf.getText();
	
	if(user.isEmpty()) {
		
		
		JOptionPane.showMessageDialog(null, "Empty! Input your ID");
		
	}
	else if(pass.isEmpty()) {
		
		JOptionPane.showMessageDialog(null, "Empty! Input your password");
		
	}
	
//	for offline login
	
	else if(user.equals("admin@rahat") && pass.equals("123456")){
		
		
		if(customer.isSelected()) {
			
			dispose();
			Main_Dialog main = new Main_Dialog();
			main.setVisible(true);
			main.setResizable(false);
			main.changeButtonStatus(true);
			}
			else {
				dispose();
				Main_Dialog main = new Main_Dialog();
				main.setVisible(true);
				main.setResizable(false);
				main.changeButtonStatus1(true);
			}
		JOptionPane.showMessageDialog(null, "successfully offline login here");
	}
	else {
		
	
//	database start from here
	
	try {
		
		//SELECT * FROM `multiuserlogin`(`name`, `password`) VALUES ('[value-1]','[value-2]')
		//SELECT * FROM `createform` WHERE 1
		
		//database start from here
		String query = "SELECT * FROM `createform` WHERE ID=? and password =?";
		con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/multiuserlogin", "root", "");
		pst = con.prepareStatement(query);
		pst.setString(1, uf.getText());
		pst.setString(2, pf.getText());
		//pst.setString(3, String.valueOf());
		rs = pst.executeQuery();
		
		if(rs.next()) {
			if(customer.isSelected()) {
			
			dispose();
			Main_Dialog main = new Main_Dialog();
			main.setVisible(true);
			main.setResizable(false);
			main.changeButtonStatus(true);
			}
			else {
				dispose();
				Main_Dialog main = new Main_Dialog();
				main.setVisible(true);
				main.setResizable(false);
				main.changeButtonStatus1(true);
			}
			
			
			JOptionPane.showMessageDialog(null, "successfully login here");
		}else {
			JOptionPane.showMessageDialog(null, "ID or PIN incorrect! try again.");
		}
		
	}
	catch(Exception ex) {
		
		JOptionPane.showMessageDialog(null, "connection failed! please login offline or check your connection."+ ex.getMessage() );
	}
	}

}
	
		
	
	
	
	public static void main(String[] args) {
		
		Login fram = new Login();
		
		fram.setVisible(true);
		fram.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fram.setTitle("Login Dialog");
		fram.setResizable(false);
		
		
	}

}
