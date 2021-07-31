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
import java.sql.Statement;
import java.sql.Time;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Query_dialog extends JFrame{
	
	Connection con = null;
	PreparedStatement pst = null;
	
	private Container c;
	private JLabel name, min, after, max, before, format, image ;
	private JTextField nam,minid,aftr,maxid,befor;
	private JButton query, retan;
//	private JTextArea area;
	private Font font, f;
	private ImageIcon img, icon, iquery, ireturn;
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scroll;
	private String[] col= {"ID","Name","Create Time", "Balance"};
	private String[] row = new String[4];
	//private String[][] raws = {				
			
			//{"21","rahat","2/2/1212","324$"},
			//{"27","faysal","2/2/1212","224$"},
			//{"24","mamun","2/2/1212","234$"},	
	//};
	
	Query_dialog(){
		this.setTitle("Personal Account System--Query Dialog");
		this.setBounds(340,160,610,400);
		component();
	}
	public void component() {
		
		c = this.getContentPane(); 
		c.setLayout(null);
		c.setBackground(Color.LIGHT_GRAY);
		
		iquery = new ImageIcon(getClass().getResource("icons/query.png"));
		ireturn = new ImageIcon(getClass().getResource("icons/relogin.png"));
		
		icon = new ImageIcon(getClass().getResource("icons/icon.png"));
		this.setIconImage(icon.getImage());
		
		img = new ImageIcon(getClass().getResource("icons/atm.png"));
		image = new JLabel(img,JLabel.CENTER);
		image.setBounds(-10,-10,615,400);
		
		f = new Font("times new roman",Font.CENTER_BASELINE,14);
		font = new Font("arial",Font.ITALIC,16);
		
	//JLabel name, min, after, max, before, format;
		name = new JLabel("Name:");
		name.setBounds(10,10,100,30);
		name.setFont(font);
		name.setForeground(Color.CYAN);
		
		min = new JLabel("min ID:");
		min.setBounds(10,50,100,30);
		min.setFont(font);
		min.setForeground(Color.CYAN);

		after = new JLabel("after:");
		after.setBounds(10,90,100,30);
		after.setFont(font);
		after.setForeground(Color.CYAN);
		
		max = new JLabel("max ID:");
		max.setBounds(220,50,100,30);
		max.setFont(font);
		max.setForeground(Color.CYAN);
			
		before = new JLabel("Before:");
		before.setBounds(220,90,100,30);
		before.setFont(font);
		before.setForeground(Color.CYAN);
					
		format = new JLabel("(Format Example:2021-03-29)");
		format.setBounds(100,130,300,30);
		format.setFont(font);
		format.setForeground(Color.MAGENTA);
		
	//JTextField nam,minid,aftr,maxid,befor;
		nam = new JTextField();
		nam.setBounds(100,10,110,30);
		nam.setFont(font);
		
		minid = new JTextField();
		minid.setBounds(100,50,110,30);
		minid.setFont(font);
		
		aftr = new JTextField();
		aftr.setBounds(100,90,110,30);
		aftr.setFont(font);
		
		maxid = new JTextField();
		maxid.setBounds(300,50,110,30);
		maxid.setFont(font);
		
		befor = new JTextField();
		befor.setBounds(300,90,110,30);
		befor.setFont(font);
		
	//JButton query, retan;
		
		query = new JButton("Query", iquery);
		query.setBounds(450,10,110,40);
		query.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
					
					
				try {
					
					
					//Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/multiuserlogin", "root", "");
					Statement pst = con.createStatement();
					
					String sql = "select * from createform";
					ResultSet rs = pst.executeQuery(sql);
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					
					while(rs.next()){
						
						model.addRow(new String[] {rs.getString(1),rs.getString(3),rs.getString(7),rs.getString(6)});
						
						
						
				
						
					
					}
					
					
					con.close();
					
					
				}
				catch(Exception ep) {
					
					JOptionPane.showMessageDialog(null, ep);
				}
				
	
			}
		});
		
		retan = new JButton("Return", ireturn);
		retan.setBounds(450,80,110,40);
		retan.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Main_Dialog main = new Main_Dialog();
				main.setVisible(true);
				main.setResizable(false);
				main.changeButtonStatus1(true);
			}
		});
		
	//JTextField  id, Name, create, balance;
		
		
		table = new JTable();
		table.setOpaque(true);
		table.setForeground(Color.MAGENTA);
		table.setFont(f);
		table.setEnabled(false);
		
		//table.setCellSelectionEnabled(true);
		
		model = new DefaultTableModel();
		model.setColumnIdentifiers(col);
		table.setModel(model);
		
		
		scroll = new JScrollPane(table);
		scroll.setAlignmentX(CENTER_ALIGNMENT);
		scroll.setBounds(20,175,550,160);
		
		
		
		
		c.add(scroll);
	/*	
		id = new JTextField("ID");
		id.setBounds(19,175,137,20);
		id.setFont(f);
		id.setOpaque(true);
		id.setBackground(Color.CYAN);
		id.setHorizontalAlignment(JTextField.CENTER);
		id.setEditable(false);
		
		Name = new JTextField("Name");
		Name.setBounds(156,175,137,20);
		Name.setFont(f);
		Name.setOpaque(true);
		Name.setBackground(Color.CYAN);
		Name.setHorizontalAlignment(JTextField.CENTER);
		Name.setEditable(false);
		
		create = new JTextField("Create Time");
		create.setBounds(294,175,138,20);
		create.setFont(f);
		create.setOpaque(true);
		create.setBackground(Color.CYAN);
		create.setHorizontalAlignment(JTextField.CENTER);
		create.setEditable(false);
		
		balance = new JTextField("Balance");
		balance.setBounds(433,175,137,20);
		balance.setFont(f);
		balance.setOpaque(true);
		balance.setBackground(Color.CYAN);
		balance.setHorizontalAlignment(JTextField.CENTER);
		balance.setEditable(false);
		
	//JTextArea area;	
		
		area = new JTextArea();
		area.setBounds(20,190,550,160);
		area.setEditable(false);
											*/
		
		c.add(name);
		c.add(min);
		c.add(after);
		c.add(max);
		c.add(before);
		c.add(format);
	/*	c.add(id);
		c.add(Name);
		c.add(create);
		c.add(balance);		*/
				
		c.add(nam);
		c.add(minid);
		c.add(aftr);
		c.add(maxid);
		c.add(befor);
		
		c.add(query);
		c.add(retan);
		
		//c.add(area);
		c.add(image);
	}
	public static void main(String[] args) {
		Query_dialog frame = new Query_dialog();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		
		
	}

}
