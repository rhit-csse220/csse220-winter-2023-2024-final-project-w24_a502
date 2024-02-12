package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

public class TrackingMissile extends missile {

	public TrackingMissile(int x2) {
		super(x2-30, Player.getPosY(), 0, 0);
		// TODO Auto-generated constructor stub
	}
	private static final int MISSLE_SIZE = 30;
	private static final double MISSLE_SPEED_MODIFER = 0.65;
	private int missleTimer=150;

	@Override
	public void update() {
		
    	if(missleTimer>50) {
    		velX=0;
    		velY=((Player.getPosY()-this.y)*0.1);
    		missleTimer--;
    	}else if (missleTimer>0) {
			velX=0;
    		velY=0;
    		missleTimer--;
		}else {
    		velY=0;
    		velX=(2*GameViewer.getGameSpeed());
    	}
    	this.x+=velX;
    	
    	this.y+=velY;
    	

    	
	}

	@Override
  public void drawOn(Graphics2D g2) {
		
		g2.translate( x,y);
		
		if(missleTimer>50) {
			if(missleTimer%20>10) {
				g2.setColor(Color.YELLOW);
			}
			else {
				g2.setColor(Color.RED);
			}
			g2.fillRect(0, 0, 100, height);
		}else if (missleTimer>0) {
			g2.setColor(Color.RED);
			
			g2.fillRect(0, 0, 100, height);
		}
		else {
			g2.setColor(Color.BLUE);
			g2.drawImage(icon.getImage(),0,0,width, height, null);
		}
		
		
		g2.translate( -x,-y);
     
  }




	

}
