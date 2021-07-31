package atm;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Statical_analysis_dialog extends JFrame {
	
	private Container c;
	private JLabel acc, all, avrg, sav,chk,crdt,alldp,allcr, avrgdp,avrgcr,image;
	private JTextField ac,al,ag,sa,ck,cd,ald,alc,agd,agc;
	private JButton update, statistics, retan;
	private ImageIcon img, icon, iupdate, istatistics, ireturn ;
	private Font font;
	
	
	Statical_analysis_dialog(){
		this.setTitle("Personal Account System--Statistical Analysis Dialog");
		this.setBounds(340,160,610,400);
		components();
	}
	public void components() {
		
		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.LIGHT_GRAY);  
		
		iupdate = new ImageIcon(getClass().getResource("icons/login.png"));
		istatistics = new ImageIcon(getClass().getResource("icons/analysis.png"));
		ireturn = new ImageIcon(getClass().getResource("icons/relogin.png"));
		
		icon = new ImageIcon(getClass().getResource("icons/icon.png"));
		this.setIconImage(icon.getImage());
		
		font = new Font("arial",Font.ITALIC,14);
		
		img = new ImageIcon(getClass().getResource("icons/atm.png"));
		
		image = new JLabel("",img,JLabel.CENTER);
		image.setBounds(-10,-10,615,400);
		
		//jlabel acc, all, avrg, sav,chk,crdt,alldp,allcr, avrgdp,avrgcr;
		
		acc = new JLabel("Accunt Number:");
		acc.setBounds(10,30,120,30);
		acc.setForeground(Color.CYAN);
		acc.setFont(font);
		c.add(acc);
		
		all = new JLabel("All Balance:");
		all.setBounds(10,140,120,30);
		all.setForeground(Color.CYAN);
		all.setFont(font);
		c.add(all);
	
		avrg = new JLabel("Average Balance:");
		avrg.setBounds(10,220,120,30);
		avrg.setForeground(Color.CYAN);
		avrg.setFont(font);
		c.add(avrg);

		
		//jfield ac,al,ag,sa,ck,cd,ald,alc,agd,agc
		
		ac = new JTextField("0");
		ac.setBounds(130,30,120,25);
		ac.setEditable(false);
		
		al = new JTextField("0");
		al.setBounds(130,140,120,25);
		al.setEditable(false);
		
		ag = new JTextField("0");
		ag.setBounds(130,220,120,25);
		ag.setEditable(false);
		
		
		c.add(ac);
		c.add(al);
		c.add(ag);
		
		
		
		//jlabel sav,chk,crdt,alldp,allcr, avrgdp,avrgcr;

		sav = new JLabel("Saving Accuont:");
		sav.setBounds(280,10,120,30);
		sav.setForeground(Color.CYAN);
		sav.setFont(font);
		c.add(sav);

		chk = new JLabel("Checking Account:");
		chk.setBounds(280,45,120,30);
		chk.setForeground(Color.CYAN);
		chk.setFont(font);
		c.add(chk);

		crdt = new JLabel("Credit Account:");
		crdt.setBounds(280,80,120,30);
		crdt.setForeground(Color.CYAN);
		crdt.setFont(font);
		c.add(crdt);

		alldp = new JLabel("All Deposit:");
		alldp.setBounds(280,125,120,30);
		alldp.setForeground(Color.CYAN);
		alldp.setFont(font);
		c.add(alldp);

		allcr = new JLabel("All Credit:");
		allcr.setBounds(280,160,120,30);
		allcr.setForeground(Color.CYAN);
		allcr.setFont(font);
		c.add(allcr);

		avrgdp =  new JLabel("Average Deposit:");
		avrgdp.setBounds(280,205,120,30);
		avrgdp.setForeground(Color.CYAN);
		avrgdp.setFont(font);
		c.add(avrgdp);

		avrgcr = new JLabel("Average Credit:");
		avrgcr.setBounds(280,240,120,30);
		avrgcr.setForeground(Color.CYAN);
		avrgcr.setFont(font);
		c.add(avrgcr);

		//jfield sa,ck,cd,ald,alc,agd,agc
		
		sa = new JTextField("0");
		sa.setBounds(410,10,100,25);
		sa.setEnabled(false);
		
		ck = new JTextField("0");
		ck.setBounds(410,45,100,25);
		ck.setEnabled(false);

		cd = new JTextField("0");
		cd.setBounds(410,80,100,25);
		cd.setEnabled(false);
		
		ald = new JTextField("0");
		ald.setBounds(410,125,100,25);
		ald.setEnabled(false);

		alc = new JTextField("0");
		alc.setBounds(410,160,100,25);
		alc.setEnabled(false);
		
		agd = new JTextField("0");
		agd.setBounds(410,205,100,25);
		agd.setEnabled(false);
		
		agc = new JTextField("0");
		agc.setBounds(410,240,100,25);
		agc.setEnabled(false);

		c.add(sa);
		c.add(ck);
		c.add(cd);
		c.add(ald);
		c.add(alc);
		c.add(agd);
		c.add(agc);
		
		//JButton update, statistics, retan;
		
		update = new JButton("Update", iupdate);
		update.setBounds(40,300,125,40);
		
		statistics = new JButton("Statistics", istatistics);
		statistics.setBounds(220,300,125,40);
		
		retan = new JButton("Return", ireturn);
		retan.setBounds(400,300,125,40);
		retan.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Main_Dialog main = new Main_Dialog();
				main.setVisible(true);
				main.setResizable(false);
				main.changeButtonStatus1(true);
			}
		});
		
		c.add(update);
		c.add(statistics);
		c.add(retan);
		c.add(image);
	}

	public static void main(String[] args) {

		Statical_analysis_dialog frame = new Statical_analysis_dialog();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setResizable(false);
	
		
	}

}
