package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

public class Speed_Missle extends missile {
	public Speed_Missle(int x2,int y) {
		super(x2-30, y, 0, 0);
		// TODO Auto-generated constructor stub
	}
	public ObjectType getType() {
		return ObjectType.MISSLE;
	}
	private static final int MISSLE_SIZE = 15;
	private static final double MISSLE_SPEED_MULTIPLIER = 2;
	private int missleTimer=150;
	private boolean warning=true;
	
	
	@Override
	public void update() {
		
    	if(missleTimer>0) {
    		velX=0;
    		velY=0;
    		missleTimer--;
    	}
    	else {
    		velY=0;
    		velX=(MISSLE_SPEED_MULTIPLIER*GameViewer.getGameSpeed());
    		//missleTimer=0;
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
				g2.drawImage(icon.getImage(),0,0,width, height, null);
			}
			
			
			g2.translate( -x,-y);
	     
	  }
	




}
