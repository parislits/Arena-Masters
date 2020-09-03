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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MyGame.UsersLoginJf.ButtonListener;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CreateAccountJf extends JFrame {
	private JPanel contentPane;
	private JFrame jframe;
	private UserCatalog aUserCatalog;
	private BufferedImage image;
	private JTextField UserTxt;
	private JTextField PassTxt;
	private JButton Music,Back,btnOk;
	private int temp = 1;
	private JLabel Error1;
	private HeroesCatalog aHeroCatalog;
	
	
	public CreateAccountJf(UserCatalog aUserCatalog) {
		this.aUserCatalog=aUserCatalog;
		this.aHeroCatalog=aHeroCatalog;
		
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
		
		JLabel CreateAcc = new JLabel("CREATE ACCOUNT");
		CreateAcc.setForeground(Color.YELLOW);
		CreateAcc.setFont(new Font("Lucida Handwriting", Font.PLAIN, 20));
		CreateAcc.setBackground(Color.WHITE);
		CreateAcc.setBounds(250, 130, 230, 30);
		jframe.getContentPane().add(CreateAcc);
		
		UserTxt = new JTextField();
		UserTxt.setForeground(Color.BLACK);
		UserTxt.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		UserTxt.setBounds(180, 240, 120, 20);
		jframe.getContentPane().add(UserTxt);
		UserTxt.setColumns(15);
		
		JLabel lblUser = new JLabel("UserName : ");
		lblUser.setForeground(Color.YELLOW);
		lblUser.setFont(new Font("Lucida Handwriting", Font.PLAIN, 15));
		lblUser.setBackground(Color.LIGHT_GRAY);
		lblUser.setBounds(80, 240, 120, 20);
		jframe.getContentPane().add(lblUser);
		
		JLabel lblPassword = new JLabel("PassWord : ");
		lblPassword.setForeground(Color.YELLOW);
		lblPassword.setFont(new Font("Lucida Handwriting", Font.PLAIN, 15));
		lblPassword.setBounds(415, 240, 120, 20);
		jframe.getContentPane().add(lblPassword);
		
		PassTxt = new JTextField();
		PassTxt.setForeground(Color.BLACK);
		PassTxt.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		PassTxt.setBounds(515, 240, 120, 20);
		jframe.getContentPane().add(PassTxt);
		PassTxt.setColumns(15);
		
		Back = new JButton("BACK");
		Back.setFont(new Font("Lucida Handwriting", Font.PLAIN, 15));
		Back.setBackground(Color.LIGHT_GRAY);
		Back.setBounds(10, 60, 95, 30);
		jframe.getContentPane().add(Back);
		
		btnOk = new JButton("OK");
		btnOk.setFont(new Font("Lucida Handwriting", Font.PLAIN, 15));
		btnOk.setBackground(Color.LIGHT_GRAY);
		btnOk.setBounds(315, 320, 80, 25);
		jframe.getContentPane().add(btnOk);
		
		ImageIcon a = new ImageIcon("Music.png");
		Music = new JButton(a);
		Music.setBackground(new Color(192, 192, 192));
		Music.setBounds(635, 60, 50, 30);
		jframe.getContentPane().add(Music);
		
		Error1 = new JLabel("");
		Error1.setForeground(Color.WHITE);
		Error1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		Error1.setBounds(80, 385, 250, 15);
		jframe.getContentPane().add(Error1);
		Error1.setVisible(true);
		
	
		
		JLabel picLabel = new JLabel(new ImageIcon(image));
		picLabel.setBounds(0, 0, 700, 500);
		jframe.getContentPane().add(picLabel);
		jframe.repaint();
		
		ButtonListener listener = new ButtonListener();
		Back.addActionListener(listener);
		btnOk.addActionListener(listener);
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
			String Name = UserTxt.getText();
			String Password = PassTxt.getText(); 
			
			if(e.getSource() == Back) {
				
				new MainMenuJf();
				jframe.dispose();
			  
			}	
			
			else if(e.getSource() == btnOk ){
				boolean flag;
				
				flag=aUserCatalog.searchUserWithName(Name);
				
				//αν βρεθεί User με το ίδιο όνομα δεν επιτρέπεται η δημιουργία λογαριασμού
				if(flag){
					Error1.setText("This username is already used!");
				}
				else{ 
				
					if(Password.length()<=6){
						Error1.setText("Too short password!");
					}
					else{
						aUserCatalog.add(new User(Name,Password));
						Error1.setText("Your account has been created succesfully! ");				
					}
				}

				for(int i=0;i<aUserCatalog.getSize();i++){
					User aUser=aUserCatalog.getUser(i);
					System.out.println(aUser.getName_Marks());
					
				}
				FilesAdministrator.writeUserToFile(aUserCatalog); //εγγραφή του νέου χρήστη στο υπάρχων αρχείο
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
