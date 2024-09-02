package main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	
	Clip clip; //module to open audio files
	URL soundURL[] = new URL[1];
	
	public Sound() {
		soundURL[0] = getClass().getResource("/sfx/eatsfx.wav");
	}
	
	public void setFile(int i) {
		try {
			
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);
			
		}catch(Exception e){
			
		}
	}
	
	public void play() {
		
		clip.start();
	}
}
