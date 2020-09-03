package MyGame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MyGame.UsersLoginJf.ButtonListener;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class VictoryJf extends JFrame {

	private JPanel contentPane;
	private JFrame jframe;
	private BufferedImage image;
	private JButton PlayAgain;
	private User aUser;


	
	
	public VictoryJf(User aUser) {
		this.aUser=aUser;
		setResizable(false);
		jframe = new JFrame();
		jframe.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		try {
			image = ImageIO.read(new File("Background.png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		Clip play = (new Music()).getClip();
		play.stop();
		JLabel lblVictory = new JLabel("VICTORY");
		lblVictory.setForeground(new Color(240, 230, 140));
		lblVictory.setFont(new Font("Wide Latin", Font.PLAIN, 56));
		lblVictory.setBounds(87, 87, 497, 100);
		jframe.getContentPane().add(lblVictory);
		
		String name = aUser.getName();
		
		JLabel user = new JLabel(name);
		user.setForeground(new Color(240, 230, 140));
		user.setFont(new Font("Wide Latin", Font.PLAIN, 50));
		user.setBounds(230, 221, 348, 53);
		jframe.getContentPane().add(user);
		
		PlayAgain = new JButton("PLAY AGAIN?");
		PlayAgain.setBackground(Color.LIGHT_GRAY);
		PlayAgain.setForeground(Color.BLACK);
		PlayAgain.setFont(new Font("Lucida Handwriting", Font.PLAIN, 16));
		PlayAgain.setBounds(263, 346, 149, 45);
		jframe.getContentPane().add(PlayAgain);
		
		JLabel picLabel = new JLabel(new ImageIcon(image));
		picLabel.setBounds(0, 0, 700, 500);
		jframe.getContentPane().add(picLabel);
		
		jframe.repaint();
		
		ButtonListener listener = new ButtonListener();
		PlayAgain.addActionListener(listener);
	

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
		
		if(e.getSource() == PlayAgain) {
			new MainMenuJf();
			jframe.dispose();
	}
		
	}
	}
	
}
