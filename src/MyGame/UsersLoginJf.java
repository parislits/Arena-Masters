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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class UsersLoginJf extends JFrame {
	private JPanel contentPane;
	private JFrame jframe;
	private HeroesCatalog fullHeroesCatalog;
	private UserCatalog aUserCatalog;
	private BufferedImage image;
	private JTextField UserNameTxt1;
	private JTextField UserNameTxt2;
	private JPasswordField passwordTxt1;
	private JPasswordField passwordTxt2;
	private JButton Back,StartGame,Music;
	private int temp = 1 ;
	private JLabel Error;
	private boolean er=false;
	private User user1;
	private User user2;
	
	
	public UsersLoginJf(UserCatalog aUserCatalog,HeroesCatalog fullHeroesCatalog) {
		this.fullHeroesCatalog=fullHeroesCatalog;
		this.aUserCatalog=aUserCatalog;
		
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
		
		
		
		JLabel Player1 = new JLabel("Player 1");
		Player1.setForeground(Color.BLUE);
		Player1.setBackground(Color.LIGHT_GRAY);
		Player1.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 25));
		Player1.setBounds(90, 130, 90, 30);
		jframe.getContentPane().add(Player1);
		
		JLabel Player2 = new JLabel("Player 2");
		Player2.setForeground(new Color(220, 20, 60));
		Player2.setBackground(Color.LIGHT_GRAY);
		Player2.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 25));
		Player2.setBounds(430, 130, 90, 30);
		jframe.getContentPane().add(Player2);
		
		ImageIcon a = new ImageIcon("Music.png");
		Music = new JButton(a);
		Music.setBackground(new Color(192, 192, 192));
		Music.setBounds(635, 60, 50, 30);
		jframe.getContentPane().add(Music);
		
		
		
		Back = new JButton("BACK");
		Back.setBackground(new Color(192, 192, 192));
		Back.setFont(new Font("Lucida Handwriting", Font.PLAIN, 16));
		Back.setBounds(10, 60, 95, 30);
		jframe.getContentPane().add(Back);
		
		JLabel UserName1 = new JLabel("UserName :");
		UserName1.setBackground(Color.LIGHT_GRAY);
		UserName1.setForeground(Color.BLUE);
		UserName1.setFont(new Font("Lucida Handwriting", Font.PLAIN, 15));
		UserName1.setBounds(10, 190, 120, 25);
		jframe.getContentPane().add(UserName1);
		
		UserNameTxt1 = new JTextField();
		UserNameTxt1.setForeground(Color.BLUE);
		UserNameTxt1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		UserNameTxt1.setBackground(Color.WHITE);
		UserNameTxt1.setBounds(120, 190, 120, 25);
		jframe.getContentPane().add(UserNameTxt1);
		UserNameTxt1.setColumns(15);
		
		JLabel UserName2 = new JLabel("UserName :");
		UserName2.setForeground(new Color(220, 20, 60));
		UserName2.setFont(new Font("Lucida Handwriting", Font.PLAIN, 15));
		UserName2.setBackground(Color.LIGHT_GRAY);
		UserName2.setBounds(350, 190, 120, 25);
		jframe.getContentPane().add(UserName2);
		
		UserNameTxt2 = new JTextField();
		UserNameTxt2.setForeground(new Color(220, 20, 60));
		UserNameTxt2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		UserNameTxt2.setBackground(Color.WHITE);
		UserNameTxt2.setBounds(460, 190, 120, 25);
		jframe.getContentPane().add(UserNameTxt2);
		UserNameTxt2.setColumns(15);
		
		JLabel Password1 = new JLabel("PassWord :");
		Password1.setForeground(Color.BLUE);
		Password1.setFont(new Font("Lucida Handwriting", Font.PLAIN, 15));
		Password1.setBackground(Color.LIGHT_GRAY);
		Password1.setBounds(10, 240, 120, 25);
		jframe.getContentPane().add(Password1);
		
		JLabel Password2 = new JLabel("Password :");
		Password2.setForeground(new Color(220, 20, 60));
		Password2.setFont(new Font("Lucida Handwriting", Font.PLAIN, 15));
		Password2.setBackground(Color.LIGHT_GRAY);
		Password2.setBounds(350, 240, 120, 25);
		jframe.getContentPane().add(Password2);
		
		passwordTxt1 = new JPasswordField();
		passwordTxt1.setForeground(Color.BLUE);
		passwordTxt1.setBackground(Color.WHITE);
		passwordTxt1.setBounds(120, 240, 120, 25);
		jframe.getContentPane().add(passwordTxt1);
		
		passwordTxt2 = new JPasswordField();
		passwordTxt2.setForeground(new Color(220, 20, 60));
		passwordTxt2.setBackground(Color.WHITE);
		passwordTxt2.setBounds(460, 240, 120, 25);
		jframe.getContentPane().add(passwordTxt2);
		
		StartGame = new JButton("START GAME");
		StartGame.setFont(new Font("Lucida Handwriting", Font.PLAIN, 15));
		StartGame.setBackground(Color.LIGHT_GRAY);
		StartGame.setBounds(499, 400, 140, 25);
		jframe.getContentPane().add(StartGame);
		
		Error = new JLabel("Username or Password is wrong!");
		Error.setForeground(Color.WHITE);
		Error.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		Error.setBackground(Color.WHITE);
		Error.setBounds(90, 400, 250, 20);
		jframe.getContentPane().add(Error);
		Error.setVisible(false);
		
		JLabel picLabel = new JLabel(new ImageIcon(image));
		picLabel.setBounds(0, 0, 700, 500);
		jframe.getContentPane().add(picLabel);
		jframe.repaint();
		ButtonListener listener = new ButtonListener();
		Back.addActionListener(listener);
		StartGame.addActionListener(listener);
		Music.addActionListener(listener);
		
		
		
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
			
			//αποθήκευση ,στις παρακάτω μεταβλητές , τα συμπληρωμένα στοιχεία
			String name1 = UserNameTxt1.getText();
			String password1 = passwordTxt1.getText();
			String name2 = UserNameTxt2.getText();
			String password2 = passwordTxt2.getText(); 
			
			if(e.getSource() == Back) {
				new MainMenuJf();
				jframe.dispose();
			}
			else if(e.getSource() == StartGame){
				
	
				user1= aUserCatalog.searchUserWithData(name1, password1);	
				user2= aUserCatalog.searchUserWithData(name2, password2);
			
				//εφόσον βρεθούν οι χρήστες ανοίγει η επόμενη οθόνη
				if(user1!=null && user2!=null){
					new SelectHeroJf(aUserCatalog, fullHeroesCatalog, user1, user2);
					jframe.dispose();
				}
				
				else{ 
					Error.setVisible(true);										
				}

				
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
				
			}
		}
	
	
}

