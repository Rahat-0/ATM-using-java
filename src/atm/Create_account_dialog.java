package atm;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Create_account_dialog extends JFrame{
	
	Connection con = null;
	
	
	private Container c;
	private JLabel acc, pass, cpass, name, acctyp, interest, image;
	private JTextField ac,nam,ist;
	private JButton register, clear, retan;
	private JPasswordField pa,cpa;
	private ImageIcon img, icon, iregister, iclear, ireturn;
	private Font font;
	private JComboBox box;
	private String[]combo = {"Saving Account", "Credit Account", "Checking Account"};
	
	Create_account_dialog(){
		this.setTitle("Personal Account System--Create Account Dialog");
		this.setBounds(340,160,610,400);
		initial();
	}
	public void initial() {
		
		c = this.getContentPane(); 
		c.setLayout(null);
		c.setBackground(Color.LIGHT_GRAY);
		
		iregister = new ImageIcon(getClass().getResource("icons/create.png"));
		iclear = new ImageIcon(getClass().getResource("icons/reset.png"));
		ireturn = new ImageIcon(getClass().getResource("icons/relogin.png"));
		
		icon = new ImageIcon(getClass().getResource("icons/icon.png"));
		this.setIconImage(icon.getImage());
		
		img = new ImageIcon(getClass().getResource("icons/atm.png"));
		image = new JLabel("",img,JLabel.CENTER);
		image.setBounds(-10,-10,615,400);
		
		font = new Font("arial",Font.ITALIC,16);
		
		acc = new JLabel("Account ID:");
		acc.setBounds(80,30,190,30);
		acc.setFont(font);
		acc.setForeground(Color.CYAN);
		
		pass = new JLabel("Password(> 6 chars):");
		pass.setBounds(80,70,190,30);
		pass.setFont(font);
		pass.setForeground(Color.CYAN);
		
		cpass = new JLabel("Password Confirm:");
		cpass.setBounds(80,110,190,30);
		cpass.setFont(font);
		cpass.setForeground(Color.CYAN);
		
		name = new JLabel("Name:");
		name.setBounds(80,150,190,30);
		name.setFont(font);
		name.setForeground(Color.CYAN);
		
		acctyp = new JLabel("Account Type:");
		acctyp.setBounds(80,190,190,30);
		acctyp.setFont(font);
		acctyp.setForeground(Color.CYAN);
		
		interest = new JLabel("Interest Rate(%):");
		interest.setBounds(80,230,190,30);
		interest.setFont(font);
		interest.setForeground(Color.CYAN);
		
		//ac, pa,cp,nam,at,ist
		ac = new JTextField();
		ac.setBounds(280,30,190,30);
		ac.setEnabled(false);
		
		pa = new JPasswordField();
		pa.setBounds(280,70,190,30);
		pa.setEnabled(true);
		
		cpa = new JPasswordField();
		cpa.setBounds(280,110,190,30);
		
		nam = new JTextField();
		nam.setBounds(280,150,190,30);
		nam.setFont(font);
		
		box = new JComboBox(combo);
		box.setBounds(280,190,190,30);
		//at = new JTextField();
		//at.setBounds(280,190,190,30);
		
		ist = new JTextField();
		ist.setBounds(280,230,190,30);
		
		//register, clear, retan;
		
		register = new JButton("Register", iregister);
		register.setBounds(80,285,120,40);
		register.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent ex) {
			
				int lnth = 6;
				String pass = pa.getText();
				String cpas = cpa.getText();
				String name = nam.getText();
				String rate = ist.getText();
			if(pass.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Empty! insert password");
			}
			else if(pass.length() < lnth) {
				JOptionPane.showMessageDialog(null, "password length is invalid");
			}
			else if(cpas.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Empty! Insert confirm password");
			}
			else if(pass.matches(pass) != pass.matches(cpas)) {
				JOptionPane.showMessageDialog(null, "Passwords Do Not Match");
			}
			else if(name.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Empty! Insert your name");
			}
			else if(rate.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Empty! Insert interest rate");
			}else
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url ="jdbc:mysql://127.0.0.1/multiuserlogin";
					Connection con = DriverManager.getConnection(url,"root","");
					String Qurey = "INSERT INTO createform( password, name, account_type, interest_rate) VALUES ( ?, ?, ?, ?)";          
					PreparedStatement pst = con.prepareStatement(Qurey);
					
					//con = DriverManager.getConnection("jdbc:mysql://127.0.0.0.1/multiuserlogin","root", "");
				
					
					
					pst.setString(1, cpa.getText());
					pst.setString(2, nam.getText());
					pst.setString(3, (String) box.getSelectedItem());
					pst .setString(4, ist.getText());
					
					pst.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "account create successfully!");
					
				}catch(Exception p) {
					JOptionPane.showMessageDialog(null, p);
				}
				
			}

			
				
			

			
			
		});
			
		
		
		
		
		clear = new JButton("Clear", iclear);
		clear.setBounds(220,285,120,40);
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pa.setText("");
				cpa.setText("");
				nam.setText("");
				ac.setText("");
				ist.setText("");
				
			}
			
		});
		
		retan = new JButton("Return", ireturn);
		retan.setBounds(360,285,120,40);
		retan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent en) {
				
				dispose();
				Main_Dialog main = new Main_Dialog();
				main.setVisible(true);
				main.setResizable(false);
				main.changeButtonStatus1(true);

				
				
			}
			
		});
		
		
		c.add(acc);
		c.add(pass);
		c.add(cpass);
		c.add(name);
		c.add(acctyp);
		c.add(interest);
		c.add(ac);
		c.add(pa);
		c.add(cpa);
		c.add(nam);
		c.add(box);
		//c.add(at);
		c.add(ist);
		c.add(register);
		c.add(clear);
		c.add(retan);
		c.add(image);
		
		
		
	}

	public static void main(String[] args) {

		
		Create_account_dialog frame = new Create_account_dialog();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frame.setResizable(false);
	}

	
		
	}


