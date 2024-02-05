package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;

public class Speed_Missle extends missile {
	public Speed_Missle(int x2) {
		super(x2-MISSLE_SIZE, Player.getPosY(), 0, 0);
		// TODO Auto-generated constructor stub
	}

	private static final int MISSLE_SIZE = 15;
	private static final double MISSLE_SPEED_MULTIPLIER = 2.5;
	private int missleTimer=50;
	private boolean warning=true;
	
	
	@Override
	public void update() {
		
    	if(missleTimer>0) {
    		velX=0;
    		velY=0        ;
    		missleTimer--;
    	}
    	else {
    		velY=0;
    		velX=(MISSLE_SPEED_MULTIPLIER*GameViewer.getGameSpeed());
    		missleTimer=0;
    	}
    	this.x+=velX;
    	
    	this.y+=velY;
    	
    	if(y<=GameViewer.getCeiling()) {
    		velY=0;
    		y=GameViewer.getCeiling();
    	}
    	if(y>=GameViewer.getFloor()) {
    		y=GameViewer.getFloor();
    		velY=0;
    	}
    	
	}
	@Override
	 public void drawOn(Graphics2D g2) {
			
			g2.translate( x,y);
			
			if(missleTimer>0) {
				warning=!warning;
				if(warning) {
					g2.setColor(Color.YELLOW);
				}
				else {
					g2.setColor(Color.RED);
				}
				g2.fillRect((int)(-MISSLE_SIZE),(int)(-MISSLE_SIZE), 2*MISSLE_SIZE, 2*MISSLE_SIZE);
			}
			else {
				g2.setColor(Color.PINK);
				g2.fillRect(0, 0, MISSLE_SIZE, MISSLE_SIZE);
			}
			
			
			g2.translate( -x,-y);
	     
	  }
	

	@Override
	public void overlap() {
		// TODO Auto-generated method stub

	}

}
