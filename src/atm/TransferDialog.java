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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TransferDialog extends JFrame{
	
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	
	private Container c;
	private JLabel acc, name, acctyp, balance, money, target, image;
	private JTextField ac,nam,actp, balanc,mny,trnsfr;
	private JButton transfers,  retan;
	private ImageIcon img, icon, itransfer, ireturn;
	private Font font;
	
	TransferDialog(){
		this.setTitle("Personal Account System--DepositDialog");
		this.setBounds(340,160,610,400);
		initial();
	}
	public void initial() {
		
		c = this.getContentPane(); 
		c.setLayout(null);
		c.setBackground(Color.LIGHT_GRAY);
		
		itransfer = new ImageIcon(getClass().getResource("icons/transfer.png"));
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
		
		target = new JLabel("Target Accout ID:");
		target.setBounds(80,230,190,30);
		target.setFont(font);
		target.setForeground(Color.CYAN);
		
		
		//ac, pa,cp,nam,at,ist
		ac = new JTextField();
		ac.setBounds(280,30,190,30);
		ac.setEditable(true);
		ac.setBackground(Color.LIGHT_GRAY);
		
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
		balanc.setEditable(false);
		balanc.setBackground(Color.LIGHT_GRAY);
		
		
		mny = new JTextField();
		mny.setBounds(280,190,190,30);
		
		trnsfr = new JTextField();
		trnsfr.setBounds(280,230,190,30);
		
		//at = new JTextField();
		//at.setBounds(280,190,190,30);
		
		
		//register, clear, retan;
		
		transfers = new JButton("Transfer", itransfer);
		transfers.setBounds(80,285,120,40);
		transfers.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ex) {
			
				String moneys = mny.getText();
				String targets = trnsfr.getText();
				//ResultSet rs = null;
				String nm = "Name";
				String atp = "account_type";
				String balnc = "balance";
				
				
				if(moneys.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Empty! insert money");
				}
				else if(targets.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Empty! insert the existing ID");
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
					
					
						JOptionPane.showMessageDialog(null, "transfered successful!");
						
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
		c.add(target);
		c.add(trnsfr);
		
		
		c.add(transfers);
		
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

		
		TransferDialog frame = new TransferDialog();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setResizable(false);
	}

	
		
	}


