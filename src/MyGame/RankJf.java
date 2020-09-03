package MyGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.imageio.ImageIO;
import javax.sound.sampled.Clip;
import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import MyGame.SelectHeroJf.ButtonListener;

import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JEditorPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollBar;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import java.awt.Scrollbar;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class RankJf extends JFrame {

	private UserCatalog aUserCatalog;
	private JFrame jframe;
	private JPanel contentPane;
	private BufferedImage image;
	private JButton Back;
	private JButton Music;
	private JTextField txt;
	private JList list;
	private JTable table;
	private static int CHAR_DELTA = 2000; //χρονος σε μιλισεκοντ για την αναζητηση
	private String m_key; // αλφαρηθμητικο που παιρνει το προγραμμα οταν πληκτρολογει ο χρηστης
	private long m_time;
	private JScrollPane scrollPane;
	private DefaultListModel<String> listModel;
	private int temp =1 ;
	

	public RankJf(UserCatalog aUserCatalog){
	this.aUserCatalog=aUserCatalog;
	
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
	
	jframe.getContentPane().setLayout(null);
	
	ImageIcon a = new ImageIcon("Music.png");
	
	txt = new JTextField();
	txt.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent evt) {
			char Name = (char) evt.getKeyChar();
			
			 //αν ο χρηστης δεν αναζητησει χαρακτηρα ή ψηφιο δεν επιστρεφει τιποτα
		    if (!Character.isLetterOrDigit(Name)) {
		        return;
		    }
		  
		    // "διαγραφει" αυτο που εχει αναζητησει ο χρηστης αν περασουν 2 δευτερολεπτα
		    if (m_time+CHAR_DELTA < System.currentTimeMillis()) {
		        m_key = "";
		    }
		  
		    m_time = System.currentTimeMillis(); // παιρνει τον χρονο απο το ρολοι του συστηματος
		    m_key += Character.toLowerCase(Name);
		    
		    
			for (int i=0; i < list.getModel().getSize(); i++) {
		        String str = ((String)list.getModel().getElementAt(i)).toLowerCase();
		        if (str.startsWith(m_key)) {
		            list.setSelectedIndex(i);     //παιρνει την θεση του αλφαρηθμιτικου που αναζητησες απο τη λιστα
		            list.ensureIndexIsVisible(i); //εμφανιζει στη λιστα το αλφαρηθμιτικο που αναζητησες
		            break;
		        }
			}
		}
	});
	txt.setBackground(Color.WHITE);
	txt.setBounds(569, 103, 116, 22);
	jframe.getContentPane().add(txt);
	txt.setColumns(10);
	
	//ταξινομηση
	Collections.sort(aUserCatalog.getAllUser());
	listModel = new DefaultListModel();
	
	for(int i=0;i<aUserCatalog.getSize();i++){
		listModel.addElement(aUserCatalog.getUser(i).getName_Marks());
  	
	}
	
	JPanel panel = new JPanel();
	panel.setBounds(175, 136, 423, 316);
	jframe.getContentPane().add(panel);
	panel.setLayout(new BorderLayout(0, 0));
	
	//δημιουργια λιστας
	list = new JList();
	panel.add(list);
	
	list.setSelectedIndices(new int[] {10});
	list.setModel(listModel);
	list.setSelectedIndex(10);
	list.setFont(new Font("Lucida Handwriting", Font.PLAIN, 23));
	list.setBackground(Color.LIGHT_GRAY);
	
	JScrollPane scrollPane_1 = new JScrollPane(list);
	panel.add(scrollPane_1);
	list.setVisible(true);


	Music = new JButton(a);
	Music.setBackground(new Color(192, 192, 192));
	Music.setBounds(635, 60, 50, 30);
	jframe.getContentPane().add(Music);
	
	
    Back = new JButton("BACK");
	Back.setBackground(new Color(192, 192, 192));
	Back.setFont(new Font("Lucida Handwriting", Font.PLAIN, 16));
	Back.setBounds(10, 60, 95, 30);
	jframe.getContentPane().add(Back);
	
	
	JLabel picLabel = new JLabel(new ImageIcon(image));
	picLabel.setBounds(0, 0, 694, 465);
	jframe.getContentPane().add(picLabel);
	
	jframe.repaint();
	ButtonListener listener = new ButtonListener();
	Music.addActionListener(listener);
	Back.addActionListener(listener);
	jframe.setBounds(100, 100, 700, 500);
	jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jframe.setVisible(true);
	contentPane.setVisible(true);
	}   
	
	
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(image, 0, 0, null);
	}
class ButtonListener implements ActionListener  {
		

		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == Music){
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
				
				new MainMenuJf();
				jframe.dispose();
			  
			}	
}}

}
