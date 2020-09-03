package MyGame;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Music extends Thread{
	    	
        private static boolean flag = true;
		private static Clip play = null;
		private static FloatControl volume;
		public AudioInputStream audioInputStream;
        private static int temp=0;
        public void run() {
        	//’νοιγμα αρχείου μουσικής
              try {
            File in = new File("Kalimba2.wav");
            audioInputStream = AudioSystem.getAudioInputStream(in);
            play = AudioSystem.getClip();
            play.open(audioInputStream);
            volume = (FloatControl) play.getControl(FloatControl.Type.MASTER_GAIN);
            volume.setValue(1.0f); 
              	play.setFramePosition(0);
              	play.loop(Clip.LOOP_CONTINUOUSLY);
              	
              	} catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        } 
              
   
        
        }
        
       public int getTemp(){
       return temp;
       }
       public Clip getClip(){
		return play;
		}
        
        }
    
