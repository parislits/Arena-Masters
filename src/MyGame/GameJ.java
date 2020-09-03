package MyGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class GameJ extends JFrame {
	
	private JPanel contentPane; //�� �������� panel ��� ���������� 
	private JPanel botPanel; //�� panel ��� ����� ����������� �� JButtons
	private JButton moveB,spell1,spell2,spell3,endTurnB;
	private Board board; //Panel �� ����� �������������� ���� ����� Board.java ��� ������������ ��� contentPane
	private HeroStaticsJf heroStaticsP; /*Panel �� ����� �������������� ���� ����� HeroStatics.Java ��� �������� �� �������� ���� ���� 
											������������ ��� contentPane �� �� �������� ��� ���� ��� �������� ���� ���� */
	private HeroesList myHeroesList;//Panel ��� �������������� ���� ����� HeroesList.java ������������ ��� contentPane ��� ��������	����� ���� ����� ��� ����� ��������� ��� �� ��������								
	
	private int mOrS=0; //��������������� ��� ��� ������ ��� �������� ��� ����� � ����� �� ���� ���� (0=move, 1=spell)
	private boolean doMove =false; //������������ ��� ������� MyMouseListener ��� �� ����� move � �������
	private boolean doSpel=false;//������������ ��� ������� MyMouseListener ��� �� ����� spell � �������
	private JScrollPane fullScroll;
	private Tracker myT;
	
	private JTextArea consoleL; //��������������� ��� ������� ���� ����� ������������ �� �������� ������� �� ��� ��������, ���� ���� �������
	private Spell asSpell; //��������� ���������
	private Image image;
	
	

	public GameJ(Tracker myT) {
		this.myT=myT;
		
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(1000, 1000));
		myHeroesList=new HeroesList(myT);
		myHeroesList.setBounds(0, 800, 1000, 150);
		
		contentPane.setBackground(new Color(165, 42, 42));
		contentPane.add(myHeroesList);
		
		contentPane.setLayout(null);
		image = Toolkit.getDefaultToolkit().createImage("heropanel.png");
	    
		
		board= new Board(myT);
		board.setBounds(0,0,700,700);
		contentPane.add(board);
	
		heroStaticsP=new HeroStaticsJf(myT.getCurrentHero());
		heroStaticsP.setBounds(750,0,450,550);
		contentPane.add(heroStaticsP);

		
		botPanel=new JPanel();
		
		botPanel.setBounds(0, 700, 700, 100);
		botPanel.setBackground(new Color(165, 42, 42));
		contentPane.add(botPanel);
		botPanel.setLayout(null);
		
		moveB=new JButton("�ove");
		moveB.setBounds(50	,50, 90, 50);
		botPanel.add(moveB);
		
	
	
		spell1=new JButton(myT.getCurrentHero().getSpel1().getName());
		spell1.setBounds(150, 50, 120, 50);
		botPanel.add(spell1);
		
		spell2=new JButton(myT.getCurrentHero().getSpel2().getName());
		spell2.setBounds(280, 50, 120, 50);
		botPanel.add(spell2);
		
		spell3=new JButton(myT.getCurrentHero().getSpel3().getName());
		spell3.setBounds(410, 50, 120, 50);
		botPanel.add(spell3);
		
		endTurnB=new JButton("endTurn");
		endTurnB.setBounds(540, 50, 120, 50);
		botPanel.add(endTurnB);
		
		consoleL=new JTextArea();
		consoleL.setBounds(750,550,450,200);
		consoleL.setFont(new Font("Century",  Font.ITALIC, 15));
		consoleL.setForeground(Color.LIGHT_GRAY);
		consoleL.setBackground(new Color(165, 42, 42));
		consoleL.disable();
		contentPane.add(consoleL);
		consoleL.setText(myT.getCurrentPlayerName()+"'s turn");
		
		ButtonListener mBL =new ButtonListener();
		moveB.addActionListener(mBL);
		endTurnB.addActionListener(mBL);
		spell1.addActionListener(mBL);
		spell2.addActionListener(mBL);
		spell3.addActionListener(mBL);
		
		myMouseListener ml = new myMouseListener();
		board.addMouseListener(ml);
		

		fullScroll=new JScrollPane(contentPane, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    	this.getContentPane().add(fullScroll);
		this.setModalExclusionType(null);
		this.setVisible(true);
		
		this.setTitle("ChessBoard");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setBounds(200, 0, 1100	, 700);
	}
	
	
	class ButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==moveB){
				
				if( mOrS!=0) 
					consoleL.setText(consoleL.getText()+"\n you can't move now");
				else if(mOrS==0) {
					//������ ������ �� ����� move, �������������� � �������� MyMouseListener
					consoleL.setText(consoleL.getText()+"\n  click onto the board to move");
					doMove=true;
				}
			}
			else if(e.getSource()==endTurnB){
			
				consoleL.setText("");
				int gameFinish;		
				mOrS=0;
				gameFinish=myT.endTurn();
				//������ �� �������� ��� ���� �����������, ���������������� �������� �� contentPane
				if(gameFinish==0){
					consoleL.setText(myT.getCurrentPlayerName()+"'s turn");
					contentPane.remove(heroStaticsP);
					heroStaticsP=new HeroStaticsJf(myT.getCurrentHero());
					heroStaticsP.setBounds(750,0,300,500);
					contentPane.add(heroStaticsP);
				
					contentPane.remove(botPanel);
				
					botPanel.remove(spell1);
					spell1.setText(myT.getCurrentHero().getSpel1().getName());
					spell1.setBounds(150, 50, 120, 50);
				
					botPanel.add(spell1);
				
					botPanel.remove(spell2);
					spell2.setText(myT.getCurrentHero().getSpel2().getName());
					spell2.setBounds(280, 50, 120, 50);
					botPanel.add(spell2);
					spell3.setText(myT.getCurrentHero().getSpel3().getName());
					spell3.setBounds(410, 50, 120, 50);
				
					botPanel.add(spell3);
					contentPane.add(botPanel);
				
					contentPane.remove(myHeroesList);
					myHeroesList=new HeroesList(myT);
					myHeroesList.setBounds(0, 800, 1000, 150);
					contentPane.add(myHeroesList);
			
					contentPane.repaint();
				}
				
			}
			else if ((e.getSource()==spell1 ||e.getSource()==spell2||e.getSource()==spell3)){
				//������� ��� �� �� ����������� �� ����� ������ spell
				if(mOrS!=1)
					consoleL.setText(consoleL.getText()+"\n you can't use spell now");
				else{
					
					Heroes aHero=myT.getCurrentHero();

					 asSpell=Spell.searchSpell(((JButton) e.getSource()).getText());
					
					//�� 5 ����������� ���� ��� Spell-������� ��� �� ����� ��� ���������� ��� ����������� Spell 
					if(asSpell.getTo()==3){
						consoleL.setText(consoleL.getText()+"\n Choose a hero to apply your spell on him");
						doSpel=true; //�������������� � �������� MyMouseListener ���� ��������� ��� spell
					}
					else if(asSpell.getTo()==2){
						consoleL.setText(consoleL.getText()+"\n You did 7 damage to all enemies Heroes!");
						
						//������� ��� �� ����� ������� ������������ �� spell �� ����� �� ���������� ���� �������� ����� 
						if(myT.getCurrentPlayer()==1)
							asSpell.doSpelltoOneTeam(myT.getHeroesCatalog(2));
						else if(myT.getCurrentPlayer()==2)
							asSpell.doSpelltoOneTeam(myT.getHeroesCatalog(1));
						mOrS=2;
						
					}
					else if(asSpell.getTo()==1){
						
						consoleL.setText(consoleL.getText()+"\n you healed your team!");
						
						//������� ��� �� ����� ������� ������������ �� spell �� ����� �� ���������� ���� ����� ���
						if(myT.getCurrentPlayer()==1)
							asSpell.doSpelltoOneTeam(myT.getHeroesCatalog(1));
						else if(myT.getCurrentPlayer()==2)
							asSpell.doSpelltoOneTeam(myT.getHeroesCatalog(2));
						mOrS=2;
					}
					else if(asSpell.getTo()==4)
						doSpel=true;
					else if(asSpell.getTo()==0){
						asSpell.doSpelltoMe(myT.getCurrentHero());
						mOrS=2;
					}
				}
				contentPane.remove(myHeroesList);
				myHeroesList=new HeroesList(myT);
				myHeroesList.setBounds(0, 800, 1000, 150);
				contentPane.add(myHeroesList);
				contentPane.repaint();
				
			}		
		}
	}
		
	

	class myMouseListener implements MouseListener {
		
		public void mouseClicked(MouseEvent arg0) {}

		public void mouseEntered(MouseEvent arg0) {}

		public void mouseExited(MouseEvent arg0) {}

		public void mousePressed(MouseEvent arg0) {

			int x = arg0.getX();
			int y = arg0.getY();

			
			if(arg0.getModifiers()==4){
				
				
				x=x-x%70+35;/*�� ������������� ����� �������� �� ������ ��� ���� �������, ��� ����� ������������ � ���� �����, �� ������ ����������� ���� ���� ���� ��� ��������*/
				y=y-y%70+35; /* �� ���� ��� ����� �� ���� ����� ��������������� ��� �� ���� �������� ������ ������������� */			
				
				Heroes aHero;
				aHero=myT.getHeroesCatalog(0).checkForHero(x, y);
				if(aHero!=null){
					
					JFrame heroStaticF=new JFrame();
					heroStaticF.setVisible(true);
					heroStaticF.setBounds(x, y, 400, 500);
					heroStaticF.add(new HeroStaticsJf(aHero));
				}
						
			}
			if(x<700 && y<700 && arg0.getModifiers()==16){
				x=x-x%70+35;			
				y=y-y%70+35;
				
				Heroes aHero;
				aHero=myT.getHeroesCatalog(0).checkForHero(x, y);
				//������� ��� �� �� ���� ������������� � �������� MyMouseListener ��� �� move, ��� �� �� �� ���������� ����� ����� ��� �������
				//��� MoveRange ��� ��� �� �� ������� ����� ����� ��� ����������� �����
				if( doMove&& mOrS==0&&myT.getCurrentHero().inMoveRange(x, y)&& aHero==null){	
					board.cliked(x, y,myT.getCurrentHero());			
					mOrS=1;
					doMove =false;
					consoleL.setText(consoleL.getText()+"\n choose one of your spells for use");
				}
				//������� ��� �� �� ���� ������������� � �������� MyMouseListener ��� �� spell
				else if(doSpel&& mOrS==1){
					//������� ��� �� ���� ��������� spell ����� �� ���������� 
					if(asSpell.getTo()==3){
						
						aHero=myT.getHeroesCatalog(0).checkForHero(x, y);
						
						//������� ��� �� �� ������� ����� ��� ���������� �����
						if(aHero!=null ){
							boolean spellDoing;
							spellDoing=asSpell.doSpellto1(myT.getCurrentHero(),aHero,x,y);
							
							//������� ��� �� �� ���������������� �� ���������� spell � ���
							if(!spellDoing)
								consoleL.setText(consoleL.getText()+"\n this hero is out of your range");
							else if(spellDoing){				
								consoleL.setText(consoleL.getText()+"\n your spell has do to "+aHero.getName());
								doSpel=false;
								mOrS=2;
							}
							
						}			
					}
					else if(asSpell.getTo()==4){
						aHero=myT.getHeroesCatalog(0).checkForHero(x, y);
							
						if(aHero!=null)
							asSpell.doSpellForNextRound(myT.getCurrentHero(), aHero, myT);
							
						doSpel=false;
						mOrS=2;
						
					}
				}		
			} 
		}//�������� ������� �������
		

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}

	}//�������� ������ �������
	
	public void setConsoleL(String aString){
		consoleL.setText(aString);	
	}
	public void setMOrC(int mOrC){
		this.mOrS=mOrC;
	}

}
