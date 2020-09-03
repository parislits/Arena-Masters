package MyGame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.Clip;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class MainMenuJf extends JFrame {

	private JPanel contentPane;
	private BufferedImage image;
	private JFrame jframe;
	private HeroesCatalog foulHeroesCatalog;
	private UserCatalog aUserCatalog;
	private JButton Rank,Newgame,Exit,CreateP;
	private JButton Music;
	private int temp = 1;
	private static boolean i=true;
	
	
	
	public MainMenuJf() {
		
		this.foulHeroesCatalog=FilesAdministrator.readsHeroesOfFile();
		this.aUserCatalog=FilesAdministrator.readsUsersOfFile();
		

		
		
		
		setResizable(false);
		jframe = new JFrame();
		jframe.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		try {
			image = ImageIO.read(new File("Background.png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		jframe.getContentPane().setLayout(null);
		
		//Δημιουργία των Jbutton
		Newgame = new JButton("NEW GAME");
		Newgame.setBackground(new Color(192, 192, 192));
		Newgame.setFont(new Font("Lucida Handwriting", Font.PLAIN, 15));
		Newgame.setBounds(240, 130, 230, 40);
		jframe.getContentPane().add(Newgame);
		
		Rank = new JButton("RANK");
		Rank.setBackground(new Color(192, 192, 192));
		Rank.setFont(new Font("Lucida Handwriting", Font.PLAIN, 15));
		Rank.setBounds(240, 210, 230, 40);
		jframe.getContentPane().add(Rank);
		
		CreateP = new JButton("CREATE PROFILE");
		CreateP.setBackground(new Color(192, 192, 192));
		CreateP.setFont(new Font("Lucida Handwriting", Font.PLAIN, 15));
		CreateP.setBounds(240, 290, 230, 40);
		jframe.getContentPane().add(CreateP);
		
		Exit = new JButton("EXIT");
		Exit.setBackground(new Color(192, 192, 192));
		Exit.setFont(new Font("Lucida Handwriting", Font.PLAIN, 15));
		Exit.setBounds(240, 370, 230, 40);
	
		ImageIcon a = new ImageIcon("Music.png");
		Music = new JButton(a);
		Music.setBounds(635, 60, 49, 28);
		jframe.getContentPane().add(Music);
		
		ButtonListener listener = new ButtonListener();
		Exit.addActionListener(listener);
		CreateP.addActionListener(listener);
		Newgame.addActionListener(listener);
		Rank.addActionListener(listener);
		Music.addActionListener(listener);
		
		jframe.getContentPane().add(Exit);
		JLabel picLabel = new JLabel(new ImageIcon(image));
		picLabel.setBounds(0, 0, 700, 500);
		jframe.getContentPane().add(picLabel);
		
		jframe.repaint();
		
		jframe.setBounds(100, 100, 700, 500);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setVisible(true);
		contentPane.setVisible(true);
		if(i==true)
		(new Music()).start();
		i=false;
		
	
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(image, 0, 0, null);
	}
	
	class ButtonListener implements ActionListener  {
		
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == Newgame) {
			  
				new UsersLoginJf(aUserCatalog,foulHeroesCatalog);
				jframe.dispose();
			  
			}	
			else if(e.getSource() == Rank){
				
				new RankJf(aUserCatalog);
				jframe.dispose();
				
			}
			else if(e.getSource() == CreateP){
				new CreateAccountJf(aUserCatalog);
				jframe.dispose();
		
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
			else{ System.exit(0); }
		}
}

}
