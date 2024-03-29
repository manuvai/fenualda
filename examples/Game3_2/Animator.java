package tests.Game3_2;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Animator {
	
	ArrayList<BufferedImage> frames;
	
	BufferedImage sprite;

	private volatile boolean running = false;
	
	private long previousTime, speed;
	private int frameAtPause, currentFrame;
	
	public Animator(ArrayList<BufferedImage> frames){
		this.frames=frames;
	}
	
	public void setSpeed(long speed){
		this.speed = speed;
	}
	
	public void update(long time){
		if (running){
			if (time - previousTime >= speed){
				//update the animation
				currentFrame++;
				try{
					sprite = frames.get(currentFrame);
				}catch(IndexOutOfBoundsException e){
					currentFrame = 0;
					sprite = frames.get(currentFrame);
				}
				previousTime = time;
			}
		}
	}
	
	public void play(){
		running = true;
		previousTime = 0;
		frameAtPause = 0;
		currentFrame = 0;
	}
	public void stop(){
		running = false;
		previousTime = 0;
		frameAtPause = 0;
		currentFrame = 0;
	}
	public void pause(){
		frameAtPause = currentFrame;
		running = false;
	}
	public void resume(){
		currentFrame = frameAtPause;
		running = true;
		
	}
}
