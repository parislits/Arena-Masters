package MyGame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class HeroesList extends JPanel {
	private JLabel nameL;
	private JLabel imageL;
	private JLabel lblHealth;

	public HeroesList(Tracker myT){
		setLayout(null);
		this.setBackground(new Color(0, 0, 200));
		this.setForeground(Color.LIGHT_GRAY);
		
		//Δημιουργεί και συμπληρώνει ένα Panel για κάθε ήρωα με το όνομα του, την εικόνα του και το Heath του και το εκχωρεί στο κεντρικό Panel
		for(int i=0;i<myT.getHeroesCatalog(0).getSize();i++){
			
			JPanel aHeroPanel=new JPanel();
			
			Heroes aHero=myT.getHeroesCatalog(0).getHero(i);
			aHeroPanel.setLayout(null);

			nameL = new JLabel(aHero.getName());
			nameL.setBounds(0, 0, 100, 50);	
			nameL.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 20));
			nameL.setForeground(Color.LIGHT_GRAY);
			nameL.setBackground(new Color(0, 0, 102));
			nameL.setHorizontalAlignment(SwingConstants.CENTER);
			aHeroPanel.add(nameL);

			
			imageL = new JLabel(aHero.getMyIcon());
			imageL.setBounds(15, 50, 70, 70);
			aHeroPanel.add(imageL);
			
			lblHealth = new JLabel("life: "+ aHero.getHealth());
			lblHealth.setBounds(15, 130, 100, 20);
			lblHealth.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 20));
			lblHealth.setForeground(Color.LIGHT_GRAY);
			lblHealth.setBackground(new Color(0, 0, 102));
			lblHealth.setHorizontalAlignment(SwingConstants.LEFT);
			aHeroPanel.add(lblHealth);
			
			
			
			aHeroPanel.setBounds(i*100,0,100,200);
			//ελέγχει ποιος παίκτης χειρίζεται τον κάθε ήρωα, ώστε να μπει το κατάλληλο χρώμα
			if(myT.getHeroesCatalog(1).foundIn(aHero))
				aHeroPanel.setBackground(Color.BLUE);
			else if(myT.getHeroesCatalog(2).foundIn(aHero))
				aHeroPanel.setBackground(Color.gray);
			add(aHeroPanel);
		}
	}
	
}
