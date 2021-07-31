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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;

public class DepositDialog extends JFrame{
	
	private static final long serialVersionUID = 1L;


	Connection con = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	
	
	
	private Container c;
	private JLabel acc, name, acctyp, balance, money, image;
	public  JTextField ac, nam,mny,actp,balanc;
	private JButton deposit, retan;
	private ImageIcon img, icon, ideposit, ireturn;
	private Font font;
	public String driv;
	
	DepositDialog(){
		this.setTitle("Personal Account System--DepositDialog");
		this.setBounds(340,160,610,400);
		initial();
	}
	public void initial() {
		
		c = this.getContentPane(); 
		c.setLayout(null);
		c.setBackground(Color.LIGHT_GRAY);
		
		ideposit = new ImageIcon(getClass().getResource("icons/deposit.png"));
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
		
		name = new JLabel("name");
		name.setBounds(80,70,190,30);
		name.setFont(font);
		name.setForeground(Color.CYAN);
		
		acctyp = new JLabel("Account Type:");
		acctyp.setBounds(80,110,190,30);
		acctyp.setFont(font);
		acctyp.setForeground(Color.CYAN);
		
		balance = new JLabel("Balance:");
		balance.setBounds(80,150,190,30);
		balance.setFont(font);
		balance.setForeground(Color.CYAN);
		
		money = new JLabel(" Money:");
		money.setBounds(80,190,190,30);
		money.setFont(font);
		money.setForeground(Color.CYAN);
		
		
		
		//ac, pa,cp,nam,at,ist
		//Login fram = new Login();
	//	driv = fram.uf.getText();
		
	
		
		ac = new JTextField();
		ac.getText();
		ac.setBounds(280,30,190,30);
		ac.setBackground(Color.LIGHT_GRAY);
//		ac.setEnabled(false);
		
		
	//	main.driv.setBounds(280,30,190,30);
		//main.driv.setEditable(false);
	
		
		
		nam = new JTextField();
		nam.setBounds(280,70,190,30);
		nam.setEditable(false);
		nam.setBackground(Color.LIGHT_GRAY);
		
		actp = new JTextField();
		actp.setBounds(280,110,190,30);
		actp.setEditable(false);
		actp.setBackground(Color.LIGHT_GRAY);
		
		balanc = new JTextField();
		balanc.setBounds(280,150,190,30);
		balanc.setFont(font);
		balanc.setEditable(false);
		balanc.setBackground(Color.LIGHT_GRAY);
		
		mny = new JTextField();
		mny.setBounds(280,190,190,30);
		
		
		//at = new JTextField();
		//at.setBounds(280,190,190,30);
		
		
		//register, clear, retan;
		
		deposit = new JButton("Deposit", ideposit);
		deposit.setBounds(80,285,120,40);
		deposit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ex) {
			
				String moneys = mny.getText();
				//ResultSet rs = null;
//				String nm = "Name";
//				String atp = "account_type";
//				String balnc = "balance";
//				
//				
				if(moneys.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Empty! insert money");
				}
				else {
					rs = find(ac.getText());
					try {
						if(rs.next()) {
							nam.setText(rs.getString("Name"));
							actp.setText(rs.getString("account_type"));
							balanc.setText(rs.getString("balance"));
						}
					
					
				
				
				
				//	Connection con = DriverManager.getConnection(url,"root","");
				//	String Qurey = "select * from createform";          
					
					
					//con = DriverManager.getConnection("jdbc:mysql://127.0.0.0.1/multiuserlogin","root", "");
				
					
					
					//pst .setString(1, mny.toString());
					
					//pst.executeUpdate();
					
					
						JOptionPane.showMessageDialog(null, "inserted successfullly!");
						
					}catch(Exception p) {
						JOptionPane.showMessageDialog(null, p);
				}
				
			}

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
				main.changeButtonStatus(true);
				
			}
			
		});
		
		
		c.add(acc);
		
		c.add(balance);
		c.add(name);
		c.add(acctyp);
		c.add(money);
		c.add(ac);
		c.add(actp);
		c.add(balanc);
		c.add(nam);
		c.add(mny);
		
		
		c.add(deposit);
		
		c.add(retan);
		c.add(image);
		
		
		
	}
	public ResultSet find(String s ) {
		
		try {
			String url ="jdbc:mysql://127.0.0.1/multiuserlogin";
			con = DriverManager.getConnection(url,"root","");
			pst = con.prepareStatement("select * from createform where ID = ?");
			pst.setString(1, s);
			rs = pst.executeQuery();
			
		}catch(Exception es) {
			JOptionPane.showMessageDialog(null, es.getMessage());
		}
		//Class.forName("com.mysql.cj.jdbc.Driver");
		
		return rs;
		
		
	}

	public static void main(String[] args) {

		
		DepositDialog framei = new DepositDialog();
		framei.setVisible(true);
		framei.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		framei.setResizable(false);
	}

	
		
	}


