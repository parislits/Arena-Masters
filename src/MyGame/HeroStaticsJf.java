package MyGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JTextArea;

public class HeroStaticsJf extends JPanel {
	private JLabel nameL;
	private JLabel imageL;
	private JLabel lblHealth;

	private JLabel lblDamage;

	private JLabel lblRange;
	private JLabel lbSpeed;
	private JLabel lbInisiative;
	Heroes aHero;
	private JLabel lbSpell;
	private JLabel lbSpell2;
	private JLabel lbSpell3;
	private BufferedImage image;
	private JTextArea textArea;
	
	

	public HeroStaticsJf(Heroes aHero) {
		this.aHero=aHero;
		
		setLayout(null);
		
		
		this.setForeground(Color.LIGHT_GRAY);
		
		try {
			image = ImageIO.read(new File("heropanel.png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		nameL = new JLabel(aHero.getName());
		nameL.setBounds(50, 30, 200, 50);	
		nameL.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 30));
		nameL.setForeground(Color.LIGHT_GRAY);
		
		nameL.setHorizontalAlignment(SwingConstants.LEFT);
		add(nameL);
		
		imageL = new JLabel(aHero.getMyIcon());
		imageL.setBounds(70, 80, 70, 70);
		
		add(imageL);
		
		lblHealth = new JLabel("Health: "+ aHero.getHealth());
		lblHealth.setBounds(50, 160, 200, 30);
		lblHealth.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 20));
		lblHealth.setForeground(Color.LIGHT_GRAY);
		lblHealth.setBackground(new Color(0, 0, 102));
		lblHealth.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblHealth);
		

		
		JLabel lblDamage = new JLabel("Damage: "+aHero.getDamage());
		lblDamage.setBounds(50, 190, 200, 30);
		lblDamage.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 20));
		lblDamage.setForeground(Color.LIGHT_GRAY);
		lblDamage.setBackground(new Color(0, 0, 102));
		lblDamage.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblDamage);

		
		lblRange = new JLabel("Range: "+aHero.getRange());
		lblRange.setBounds(50, 220, 200, 30);
		lblRange.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 20));
		lblRange.setForeground(Color.LIGHT_GRAY);
		lblRange.setBackground(new Color(0, 0, 102));
		lblRange.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblRange);
		
		lbSpeed = new JLabel("Speed: "+aHero.getSpeed());
		lbSpeed.setBounds(50, 250, 200, 30);
		lbSpeed.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 20));
		lbSpeed.setForeground(Color.LIGHT_GRAY);
		lbSpeed.setBackground(new Color(0, 0, 102));
		lbSpeed.setHorizontalAlignment(SwingConstants.LEFT);
		add(lbSpeed);
		
		
		lbInisiative = new JLabel("Inisitive: "+aHero.getInitiative());
		lbInisiative.setBounds(50, 280, 200, 30);
		lbInisiative.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 20));
		lbInisiative.setForeground(Color.LIGHT_GRAY);
		lbInisiative.setBackground(new Color(0, 0, 102));
		lbInisiative.setHorizontalAlignment(SwingConstants.LEFT);
		add(lbInisiative);
		
		lbSpell = new JLabel("<html>Spell: "+ aHero.getSpel1().getName() + "<br>" + aHero.getSpel1().getInfo() + "</html>");
		lbSpell.setBounds(50, 310, 700, 60);
		lbSpell.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 20));
		lbSpell.setForeground(Color.LIGHT_GRAY);
		lbSpell.setBackground(new Color(0, 0, 102));
		lbSpell.setHorizontalAlignment(SwingConstants.LEFT);
		add(lbSpell);
		
		lbSpell2 = new JLabel("<html>Spell: "+ aHero.getSpel2().getName() + "<br>" + aHero.getSpel2().getInfo() + "</html>");
		lbSpell2.setBounds(50, 370, 700, 60);
		lbSpell2.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 20));
		lbSpell2.setForeground(Color.LIGHT_GRAY);
		lbSpell2.setBackground(new Color(0, 0, 102));
		lbSpell2.setHorizontalAlignment(SwingConstants.LEFT);
		add(lbSpell2);
		
		lbSpell3 = new JLabel("<html>Spell: "+ aHero.getSpel3().getName() + "<br>" + aHero.getSpel3().getInfo() + "</html>");
		lbSpell3.setBounds(50, 430, 700, 60);
		lbSpell3.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 20));
		lbSpell3.setForeground(Color.LIGHT_GRAY);
		lbSpell3.setBackground(new Color(0, 0, 102));
		lbSpell3.setHorizontalAlignment(SwingConstants.LEFT);
		add(lbSpell3);
		
		
		

	}
	protected void paintComponent(Graphics g) {

	    super.paintComponent(g);
	        g.drawImage(image, 0, 0, null);
	}
}
