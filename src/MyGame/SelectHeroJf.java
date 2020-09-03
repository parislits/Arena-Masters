package MyGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SelectHeroJf extends JFrame {

	private JPanel contentPane;
	private HeroesCatalog foulHeroesCatalog;
	private UserCatalog aUserCatalog;
	private JFrame jframe;
	private JButton Hero1,Hero2,Hero3,Hero4,Hero5,Hero6,Hero7,Hero8,Hero9,Hero10;
	private JLabel Hero1P1;
	private JLabel Hero2P1;
	private JLabel Hero3P1;
	private JLabel Hero4P1;
	private JLabel Hero5P1;
	private JLabel Hero1P2;
	private JLabel Hero2P2;
	private JLabel Hero3P2;
	private JLabel Hero4P2;
	private JLabel Hero5P2;
	private JButton StartGame;
	private BufferedImage image;
	private static boolean flag;
	private static int i,j;
	private JButton Back;
	private JButton Music;
	private int temp = 1;
	private User user1,user2;
	private HeroesCatalog cat1,cat2,finalCat1,finalCat2;
	private JLabel playerTurn;
	
	public SelectHeroJf(UserCatalog aUserCatalog,HeroesCatalog foulHeroesCatalog,User user1,User user2) {
		this.foulHeroesCatalog=foulHeroesCatalog;
		this.aUserCatalog=aUserCatalog;
		this.user1=user1;
		this.user2=user2;
		cat1=new HeroesCatalog(5);
		cat2=new HeroesCatalog(5);
		i=0;
		j=0;
		flag=true;

		setResizable(false);
		jframe = new JFrame();
		jframe.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		jframe.getContentPane().setLayout(null);

		try {
			image = ImageIO.read(new File("Blue.png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		String User1S =user1.getName();
		JLabel Player1L = new JLabel(User1S);
		Player1L.setForeground(Color.WHITE);
		Player1L.setFont(new Font("Lucida Handwriting", Font.PLAIN, 15));
		Player1L.setBounds(75, 40, 120, 20);
		jframe.getContentPane().add(Player1L);
		
		String User2S =user2.getName();
		
		JLabel Player2L = new JLabel(User2S);
		Player2L.setForeground(Color.WHITE);
		Player2L.setFont(new Font("Lucida Handwriting", Font.PLAIN, 15));
		Player2L.setBounds(510, 40, 120, 15);
		jframe.getContentPane().add(Player2L);
		
		Hero1P1 = new JLabel();
		Hero1P1.setBounds(10, 60, 70, 70);
		jframe.getContentPane().add(Hero1P1);
		
		
		Hero2P1 = new JLabel();
		Hero2P1.setBounds(90, 60, 70, 70);
		jframe.getContentPane().add(Hero2P1);
		
		
		Hero3P1 = new JLabel();
		Hero3P1.setBounds(170, 60, 70, 70);
		jframe.getContentPane().add(Hero3P1);
		
		 Hero4P1 = new JLabel();
		Hero4P1.setBounds(40, 150, 70, 70);
		jframe.getContentPane().add(Hero4P1);
		
		 Hero5P1 = new JLabel();
		Hero5P1.setBounds(120, 150, 70, 70);
		jframe.getContentPane().add(Hero5P1);
		
		Hero1P2 = new JLabel();
		Hero1P2.setBounds(440, 60, 70, 70);
		jframe.getContentPane().add(Hero1P2);
		
		Hero2P2 = new JLabel();
		Hero2P2.setBounds(520, 60, 70, 70);
		jframe.getContentPane().add(Hero2P2);
		
		Hero3P2 = new JLabel();
		Hero3P2.setBounds(600, 60, 70, 70);
		jframe.getContentPane().add(Hero3P2);
		
		Hero4P2 = new JLabel();
		Hero4P2.setBounds(476, 150, 70, 70);
		jframe.getContentPane().add(Hero4P2);
		
		Hero5P2 = new JLabel();
		Hero5P2.setBounds(556, 150, 70, 70);
		jframe.getContentPane().add(Hero5P2);
		
		
		StartGame = new JButton("START GAME");
		StartGame.setBounds(564, 430, 120, 30);
		jframe.getContentPane().add(StartGame);
		
		ImageIcon icon =foulHeroesCatalog.getHero(0).getMyIcon();
			
		Hero1 = new JButton(icon);
		Hero1.setBounds(99, 300, 70, 70);				
		jframe.getContentPane().add(Hero1);			
		//Με δεξί κλικ εμφανίζεται παράθυρο στο οποίο αναγράφονται τα χαρακτηριστικά του συγκεκριμένου ήρωα 		
		Hero1.addMouseListener(new MouseAdapter() {	
		public void mouseClicked(MouseEvent arg0) {
			if (arg0.getButton() == 3) { 
				Heroes aHero=foulHeroesCatalog.getHero(0);
				JFrame heroStaticF=new JFrame();
				heroStaticF.setVisible(true);
				heroStaticF.setBounds(0, 0, 300, 400);
				heroStaticF.add(new HeroStaticsJf(aHero));
							
		        Hero1.getModel().setPressed(false);}
			}
		});				
		ImageIcon icon1 =foulHeroesCatalog.getHero(1).getMyIcon();
		
		Hero2 = new JButton(icon1);
		Hero2.setBounds(198, 300, 70, 70);
		jframe.getContentPane().add(Hero2);	
		Hero2.addMouseListener(new MouseAdapter() {	
		public void mouseClicked(MouseEvent arg0) {
			if (arg0.getButton() == 3) { 
				Heroes aHero=foulHeroesCatalog.getHero(1);
				JFrame heroStaticF=new JFrame();
				heroStaticF.setVisible(true);
				heroStaticF.setBounds(0, 0, 300, 400);
				heroStaticF.add(new HeroStaticsJf(aHero));
							
		        Hero2.getModel().setPressed(false);}
			}
		});		
		ImageIcon icon2 =foulHeroesCatalog.getHero(2).getMyIcon();
			
		Hero3 = new JButton(icon2);
		Hero3.setBounds(297, 300, 70, 70);
		jframe.getContentPane().add(Hero3);	
		Hero3.addMouseListener(new MouseAdapter() {	
		public void mouseClicked(MouseEvent arg0) {
			if (arg0.getButton() == 3) { 
				Heroes aHero=foulHeroesCatalog.getHero(2);
				JFrame heroStaticF=new JFrame();
				heroStaticF.setVisible(true);
				heroStaticF.setBounds(0, 0, 300, 400);
				heroStaticF.add(new HeroStaticsJf(aHero));
				Hero3.getModel().setPressed(false);}
			}
		});
		ImageIcon icon3 =foulHeroesCatalog.getHero(3).getMyIcon();
				
		Hero4 = new JButton(icon3);
		Hero4.setBounds(394, 300, 70, 70);
		jframe.getContentPane().add(Hero4);	
		Hero4.addMouseListener(new MouseAdapter() {	
		public void mouseClicked(MouseEvent arg0) {
			if (arg0.getButton() == 3) { 
				Heroes aHero=foulHeroesCatalog.getHero(3);
				JFrame heroStaticF=new JFrame();
				heroStaticF.setVisible(true);
				heroStaticF.setBounds(0, 0, 300, 400);
				heroStaticF.add(new HeroStaticsJf(aHero));
				Hero4.getModel().setPressed(false);}
			}
		});	
		ImageIcon icon4 =foulHeroesCatalog.getHero(4).getMyIcon();
				
		Hero5 = new JButton(icon4);
		Hero5.setBounds(494, 300, 70, 70);
		jframe.getContentPane().add(Hero5);
		Hero5.addMouseListener(new MouseAdapter() {	
		public void mouseClicked(MouseEvent arg0) {
			if (arg0.getButton() == 3) { 
				Heroes aHero=foulHeroesCatalog.getHero(4);
				JFrame heroStaticF=new JFrame();
				heroStaticF.setVisible(true);
				heroStaticF.setBounds(0, 0, 300, 400);
				heroStaticF.add(new HeroStaticsJf(aHero));
				Hero5.getModel().setPressed(false);}
			}
		});
		ImageIcon icon5 =foulHeroesCatalog.getHero(5).getMyIcon();
				
		Hero6 = new JButton(icon5);
		Hero6.setBounds(600, 300, 70, 70);
		jframe.getContentPane().add(Hero6);
		Hero6.addMouseListener(new MouseAdapter() {	
		public void mouseClicked(MouseEvent arg0) {
			if (arg0.getButton() == 3) { 
				Heroes aHero=foulHeroesCatalog.getHero(5);
				JFrame heroStaticF=new JFrame();
				heroStaticF.setVisible(true);
				heroStaticF.setBounds(0, 0, 300, 400);
				heroStaticF.add(new HeroStaticsJf(aHero));
				Hero6.getModel().setPressed(false);}
			}
		});
		ImageIcon icon6 =foulHeroesCatalog.getHero(6).getMyIcon();
				
		Hero7 = new JButton(icon6);
		Hero7.setBounds(0, 381, 70, 70);
		jframe.getContentPane().add(Hero7);
		Hero7.addMouseListener(new MouseAdapter() {	
		public void mouseClicked(MouseEvent arg0) {
			if (arg0.getButton() == 3) { 
				Heroes aHero=foulHeroesCatalog.getHero(6);
				JFrame heroStaticF=new JFrame();
				heroStaticF.setVisible(true);
				heroStaticF.setBounds(0, 0, 300, 400);
				heroStaticF.add(new HeroStaticsJf(aHero));
				Hero7.getModel().setPressed(false);}
			}
		});
		ImageIcon icon7 =foulHeroesCatalog.getHero(7).getMyIcon();
				
		Hero8 = new JButton(icon7);
		Hero8.setBounds(99, 381, 70, 70);
		jframe.getContentPane().add(Hero8);
		Hero8.addMouseListener(new MouseAdapter() {	
		public void mouseClicked(MouseEvent arg0) {
			if (arg0.getButton() == 3) { 
				Heroes aHero=foulHeroesCatalog.getHero(7);
				JFrame heroStaticF=new JFrame();
				heroStaticF.setVisible(true);
				heroStaticF.setBounds(0, 0, 300, 400);
				heroStaticF.add(new HeroStaticsJf(aHero));
				Hero8.getModel().setPressed(false);}
			}
		});
		ImageIcon icon8 =foulHeroesCatalog.getHero(8).getMyIcon();
				
		Hero9 = new JButton(icon8);
		Hero9.setBounds(198, 381, 70, 70);
		jframe.getContentPane().add(Hero9);	
		Hero9.addMouseListener(new MouseAdapter() {	
		public void mouseClicked(MouseEvent arg0) {
			if (arg0.getButton() == 3) { 
				Heroes aHero=foulHeroesCatalog.getHero(8);
				JFrame heroStaticF=new JFrame();
				heroStaticF.setVisible(true);
				heroStaticF.setBounds(0, 0, 300, 400);
				heroStaticF.add(new HeroStaticsJf(aHero));
				Hero9.getModel().setPressed(false);}
			}
		});
		
		ImageIcon icon9 =foulHeroesCatalog.getHero(9).getMyIcon();		
		Hero10 = new JButton(icon9);
		Hero10.setBounds(0, 300, 70, 70);
		jframe.getContentPane().add(Hero10);
		Hero10.addMouseListener(new MouseAdapter() {	
		public void mouseClicked(MouseEvent arg0) {
			if (arg0.getButton() == 3) { 
				Heroes aHero=foulHeroesCatalog.getHero(9);
				JFrame heroStaticF=new JFrame();
				heroStaticF.setVisible(true);
				heroStaticF.setBounds(0, 0, 300, 400);
				heroStaticF.add(new HeroStaticsJf(aHero));
				Hero10.getModel().setPressed(false);}
			}
		});
		
		playerTurn = new JLabel();
		playerTurn.setForeground(Color.WHITE);
		playerTurn.setFont(new Font("Lucida Handwriting", Font.PLAIN, 15));
		playerTurn.setBounds(250, 200, 200, 15);
		jframe.getContentPane().add(playerTurn);

				
		Back = new JButton("BACK");
		Back.setBackground(Color.LIGHT_GRAY);
		Back.setForeground(Color.BLACK);
		Back.setFont(new Font("Lucida Handwriting", Font.PLAIN, 15));
		Back.setBounds(10, 11, 89, 23);
		jframe.getContentPane().add(Back);
				
		ImageIcon a = new ImageIcon("Music.png");
		Music = new JButton(a);
		Music.setBackground(new Color(192, 192, 192));
		Music.setBounds(635, 11, 50, 30);
		jframe.getContentPane().add(Music);
				
		JLabel picLabel = new JLabel(new ImageIcon(image));
		picLabel.setBounds(0, 0, 700, 500);
		jframe.getContentPane().add(picLabel);
		jframe.repaint();

	
		
		ButtonListener listener = new ButtonListener();
		Hero1.addActionListener(listener);
		Hero2.addActionListener(listener);
		Hero3.addActionListener(listener);
		Hero4.addActionListener(listener);
		Hero5.addActionListener(listener);
		Hero6.addActionListener(listener);
		Hero7.addActionListener(listener);
		Hero8.addActionListener(listener);
		Hero9.addActionListener(listener);
		Hero10.addActionListener(listener);
		StartGame.addActionListener(listener);
		Music.addActionListener(listener);
		Back.addActionListener(listener);
		
		
		
		jframe.setBounds(100, 100, 700, 500);
		jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jframe.setVisible(true);
		contentPane.setVisible(true);
}
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(image, 0, 0, null);
	}
	
class ButtonListener implements ActionListener  {
		
	

		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == Hero1||e.getSource() == Hero2||e.getSource() == Hero3||e.getSource() == Hero4||e.getSource() == Hero5||
					e.getSource() == Hero6||e.getSource() == Hero7||e.getSource() == Hero8||e.getSource() == Hero9||e.getSource() == Hero10) {
				
				//Ελέγχει ποιο από όλα τα κουμπια/εικόνες έχει επιλεγεί και κάνοντας εγχωρεί τον ήρωα στη μεταβλητή aHero
				Heroes aHero=foulHeroesCatalog.checkForHeroWhithIcon(((ImageIcon) ((JButton)e.getSource()) .getIcon()));
				ImageIcon icon=aHero.getMyIcon();

				//αν το flag είναι true σημαίνει ότι επιλέγει ο 1ος παίκτης αλλιώς επιλέγει ο 2ος
				if(flag){
					playerTurn.setText(user2.getName()+" is choosing");
					
					//ελέγχει αν έχει επιλεγεί ήδη ο ήρωας σε προηγούμενη επιλογή του ίδιου παίκτη 
					//αν δεν έχει επιλεγεί τότε εμφανίζεται η εικόνα του ήρωα, που επιλέγεται ,σε κάθε επόμενη θέση και εγχωρείται ο ήρωας στον κατάλογο των ηρώων του κάθε παίκτη
					if(!cat1.foundIn(aHero)){
						flag=false;
						if(i==0){		
							Hero1P1.setIcon(icon);
							i++;
						}
						else if(i==1){
							Hero2P1.setIcon(icon);
							i++;
						}
						else if(i==2){
							Hero3P1.setIcon(icon);
							i++;
						}
						else if(i==3){
							Hero4P1.setIcon(icon);
							i++;
						}	
						else if(i==4){
							Hero5P1.setIcon(icon);
							i++;					
						}				
						cat1.addHero(aHero);
					}
				}
				else{					
					playerTurn.setText(user1.getName()+" is choosing");
					if(!cat2.foundIn(aHero)){
						flag=true;
						if(j==0){
							Hero1P2.setIcon(icon);
							j++;
						}
						else if(j==1){
							Hero2P2.setIcon(icon);
							j++;
						}
						else if(j==2){
							Hero3P2.setIcon(icon);
							j++;
						}
						else if(j==3){
							Hero4P2.setIcon(icon);
							j++;
						}
						else if(j==4){
							Hero5P2.setIcon(icon);
							j++;
						}
					
						cat2.addHero(aHero);
						
					}
				}
				
			}
			
			
			else if(e.getSource() == StartGame){
				finalCat1=new HeroesCatalog(5);
				finalCat2=new HeroesCatalog(5);
				boolean flag=true;
				
				//Τρέχει τον πίνακα με τους επιλεγμένους ήρωες του 1ου παίκτη 
				for(int i=0;i<5;i++){
					
					Heroes ahero=cat1.getHero(i);
					//αν σε κάποια θέση αυτού του πίνακα δε βρεθεί ήρωας η μεταβλητή flag γίνεται false και βγαίνει από το βρόγχο
					if(ahero==null){
						flag=false;	
						break;
					}		
					//δημιουργεί ένα αντίγραφο του συγκεκριμένου ήρωα και εγχωρεί αυτό στον τελικό κατάλογο του 1ου παίκτη
					finalCat1.addHero(i,new Heroes(ahero.getName(), ahero.getMyIcon(), ahero.getDamage(), ahero.getHealth(), ahero.getRange(),
							ahero.getSpel1().getName(),ahero.getSpel2().getName(),ahero.getSpel3().getName(),ahero.getSpeed(), ahero.getInitiative()));				
				}
				//αν ο 1ος κατάλογος είχε 5 ήρωες τρέχει τον κατάλογο με τους επιλεγμένους ήρωες του 2ου παίκτη
				for(int i=0;i<5&&flag;i++){
					
					Heroes ahero=cat2.getHero(i);
					if(ahero==null){
						flag=false;
						break;
					}
				
					finalCat2.addHero(i,new Heroes(ahero.getName(), ahero.getMyIcon(), ahero.getDamage(), ahero.getHealth(), ahero.getRange(),
							ahero.getSpel1().getName(),ahero.getSpel2().getName(),ahero.getSpel3().getName(),ahero.getSpeed(), ahero.getInitiative()));
				}
				
				//εφόσον και οι 2 παίκτες έχουν επιλέξει ακριβώς 5 ήρωες ανοίγει το παράθυρο του παιχνιδιού
				if(flag){
					jframe.dispose();
					Tracker myT=new Tracker(finalCat1, finalCat2,user1,user2);
					
				}
				else
					JOptionPane.showMessageDialog(null,"Sorry... The game can't start,you have to pick 5 heroes!");
			}
			
			else if(e.getSource() == Music){
				Clip play = (new Music()).getClip();
				
				if(temp==1){
				play.stop();
				temp=0;
				}
				else{
				temp=1;
				(new Music()).start();
				}
				
			}
			else if(e.getSource() == Back) {
				
				i=0;
				j=0;
				new UsersLoginJf(aUserCatalog, foulHeroesCatalog );
				jframe.dispose();
			  
			}	
			
			
		}}
	
	
}
