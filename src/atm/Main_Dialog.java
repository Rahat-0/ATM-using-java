package atm;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class Main_Dialog extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Container c;
	private JLabel welcome, image;
	private JButton create, analysis, query;
	private JButton deposit;
	private JButton withdraw;
	private JButton transfer;
	private JButton relogin;
	private Font font;	
	private Cursor cr;
	private ImageIcon img, icon, icreate, ianalysis, iquery, ideposit, iwithdraw, itransfer, irelogin;
	
	
	
	public Main_Dialog(){
		this.setTitle("Personal Account System--Main Dialog");
		this.setBounds(340,160,610,400);
		maindialog();
		
	}
	public void maindialog() {
		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.LIGHT_GRAY);
		
		//whole font property here
		font = new Font("arial",Font.ITALIC,16 );
		cr = new Cursor(Cursor.HAND_CURSOR);
		
		//icon and image property start from here
		icreate = new ImageIcon(getClass().getResource("icons/create.png"));
		ianalysis = new ImageIcon(getClass().getResource("icons/analysis.png"));
		iquery = new ImageIcon(getClass().getResource("icons/query.png"));
		ideposit = new ImageIcon(getClass().getResource("icons/deposit.png"));
		iwithdraw = new ImageIcon(getClass().getResource("icons/withdrawal.png"));
		itransfer = new ImageIcon(getClass().getResource("icons/transfer.png"));
		irelogin = new ImageIcon(getClass().getResource("icons/relogin.png"));
		
		
		icon = new ImageIcon(getClass().getResource("icons/icon.png"));
		this.setIconImage(icon.getImage());
		
		img = new ImageIcon(getClass().getResource("icons/atm.png"));
		image = new JLabel("",img,JLabel.CENTER);
		image.setBounds(-10,-10,615,400);
		
		// driv JLabel as a driver String 
		
		
		
		
		
		//whole button creation start from here
		welcome = new JLabel();
		welcome.setText(" welcome to visit the RAHAT BANKING SYSTEM");
		welcome.setBounds(60,10,400,30);
		welcome.setFont(font);
		welcome.setForeground(Color.white);
		
		create = new JButton("Create Account", icreate);
		create.setBounds(70,70,190,40);
		create.setCursor(cr);
		create.setEnabled(false);
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				
				dispose();
				Create_account_dialog frame = new Create_account_dialog();
				frame.setVisible(true);
				frame.setResizable(false);
			}
			
		});
		
		analysis = new JButton("Statistical analysis", ianalysis);
		analysis.setBounds(70,150,190,40);
		analysis.setCursor(cr);
		analysis.setEnabled(false);
		analysis.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evn) {
				dispose();
				Statical_analysis_dialog frame = new Statical_analysis_dialog();
				frame.setVisible(true);
				frame.setResizable(false);
			}
		});
		
		query = new JButton("Accounts Qurey", iquery);
		query.setBounds(70,230,190,40);
		query.setCursor(cr);
		query.setEnabled(false);
		query.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evn) {
				dispose();
				Query_dialog frame = new Query_dialog();
				frame.setVisible(true);
				frame.setResizable(false);
			}
		});
		
		deposit = new JButton("Deposit Money", ideposit);
		deposit.setBounds(320,70,190,40);
		deposit.setCursor(cr);
		deposit.setEnabled(false);
	
		deposit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evn) {
				dispose();
				DepositDialog framei = new DepositDialog();
				framei.setVisible(true);
				framei.setResizable(false);
				
				
			}
		});
		
		withdraw = new JButton("Withdraw Money", iwithdraw);
		withdraw.setBounds(320,150,190,40);
		withdraw.setCursor(cr);
		withdraw.setEnabled(false);
		withdraw.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evn) {
				dispose();
				WithdrawMoney frame = new WithdrawMoney();
				frame.setVisible(true);
				frame.setResizable(false);
			}
		});
		
		transfer = new JButton("Transfer Money", itransfer);
		transfer.setBounds(320,230,190,40);
		transfer.setCursor(cr);
		transfer.setEnabled(false);
		transfer.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evn) {
				dispose();
				TransferDialog frame = new TransferDialog();
				frame.setVisible(true);
				frame.setResizable(false);
			}
		});
		
		relogin = new JButton("Re-login", irelogin);
		relogin.setBounds(465,1,130,40);
		relogin.setCursor(cr);
		relogin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Login frame = new Login();
				frame.setVisible(true);
				frame.setResizable(false);
			}
		});
		
		//button create end here.
		
		
		//property add to constructor, constructor declare as c.
		c.add(welcome);
		c.add(create);
		c.add(analysis);
		c.add(query);
		c.add(deposit);
		c.add(withdraw);
		c.add(transfer);
		c.add(relogin);
		c.add(image);
		
		
		
		
		
		
		
		
		
	}
	
	
	//changing button status for calling another class with conditions.
	
	public void changeButtonStatus(boolean flag) {
		deposit.setEnabled(flag);
		withdraw.setEnabled(flag);
		transfer.setEnabled(flag);
		
		
	}
	public void changeButtonStatus1(boolean fla) {
		query.setEnabled(fla);
		analysis.setEnabled(fla);
		create.setEnabled(fla);
		
		
	}

	//this is the main method for this class.
	public static void main(String[] args) {
		
		Main_Dialog main = new Main_Dialog();
		
		main.setVisible(true);
		main.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		main.setResizable(false);
		
		
		
	}

}
