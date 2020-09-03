package MyGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Board extends JPanel {
	private JLabel heroL;
	
	static int x;
	static int y; 
	private Heroes hero,hero1;
	private int temp=1;
	
	private static final int ROWS = 10;
	private static final int COLUMNS = 10;
	private int xCoord = 0;
	private int yCoord = 0;
	private Tracker myT;

	private BufferedImage image;
	
	
	
	public Board(Tracker myT){

		try {
			image = ImageIO.read(new File("battle4.png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		this.myT=myT;
		
		
	}
	
	

	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);		
		setSize(700, 700);
		this.setBackground(new Color(0, 0, 200));
		this.setForeground(Color.LIGHT_GRAY);
		int sqSize = this.getHeight() / ROWS;
		g.drawImage(image, 0, 0, null);
		
		//σχεδιασμός πλέγματος του ταμπλού του παιχνιδιού
		for(int i=0; i<ROWS; i++){  //σάρωση γραμμών
			for(int j=0; j<COLUMNS; j++){  // σάρωση στηλών
			     int x = i * 70;
			     int y = j * 70;
				g.drawRect(x, y, 70, 70);
				
			}
		}
		
		//τοποθέτηση των ηρώων του User1 στο ταμπλό
		for(int i=0;i<myT.getHeroesCatalog(1).getSize();i++){
			
			Heroes aHero=myT.getHeroesCatalog(1).getHero(i);
	
			g.setColor(Color.BLUE);
			g.fillRect(aHero.getxcord()-30, aHero.getycord()-30, 60, 60);
			g.drawImage(aHero.getMyIcon().getImage(), aHero.getxcord()-25,aHero.getycord()-25 , 50, 50, this);

			
		}
		//τοποθέτηση των ηρώων του User2 στο ταμπλό
		for(int i=0;i<myT.getHeroesCatalog(2).getSize();i++){
			
			Heroes aHero=myT.getHeroesCatalog(2).getHero(i);
			g.setColor(Color.gray);
			g.fillRect(aHero.getxcord()-30, aHero.getycord()-30, 60, 60);
			
			g.drawImage(aHero.getMyIcon().getImage(), aHero.getxcord()-25,aHero.getycord()-25 , 50, 50, this);
		}
			
	}
	

	
	public void cliked(int x,int y,Heroes aHero){
	/*Μεταφορά της εικόνας του ήρωα στις νέες συνταταγμένες που έχει επιλέξει ο παίκτης.
	 * Αλλαγή δηλαδή των συντεταγμένων του ήρωα και επανασχεδιασμός του ταμπλού.
	 */
		
		boolean flag = true;	
			
		aHero.setXcord(x);
		aHero.setYcord(y);
		flag=false;
		this.repaint();				
	}
	
	
}