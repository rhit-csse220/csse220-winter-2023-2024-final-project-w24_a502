package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;

public class TrackingMissile extends missile {

	public TrackingMissile(int x2) {
		super(x2-MISSLE_SIZE, Player.getPosY(), 0, 0);
		// TODO Auto-generated constructor stub
	}
	private static final int MISSLE_SIZE = 30;
	private static final double MISSLE_SPEED_MODIFER = 0.65;
	private int missleTimer=500;

	@Override
	public void update() {
		
    	if(missleTimer>0) {
    		velX=-GameViewer.getGameSpeed();
    		velY=((Player.getPosY()-this.y)*MISSLE_SPEED_MODIFER);
    		missleTimer--;
    	}
    	else {
    		velY=((Player.getPosY()-this.y));
    		velX=((Player.getPosX()-this.x));
    		double speedNorm=Math.sqrt(velX*velX+velY*velY);
    		double gameSpeed= GameViewer.getGameSpeed();
    		velY=-gameSpeed*velY/speedNorm*MISSLE_SPEED_MODIFER;
    		velX=-gameSpeed*velX/speedNorm*MISSLE_SPEED_MODIFER;
    		missleTimer=0;
    	}
    	this.x+=GameViewer.getGameSpeed()+velX;
    	
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
			g2.setColor(Color.YELLOW);
			
		}
		else {
			g2.setColor(Color.BLUE);
		}
		g2.fillRect(0, 0, MISSLE_SIZE, MISSLE_SIZE);
		
		g2.translate( -x,-y);
     
  }

	@Override
	public void overlap() {
		return;
	}

	@Override
	boolean isOverLapping(Shape object) {
		// TODO Auto-generated method stub
		return object.contains((int)(x-MISSLE_SIZE),(int)(y-MISSLE_SIZE), 2*MISSLE_SIZE, 2*MISSLE_SIZE);
	}

	@Override
	public ObjectType getType() {
		// TODO Auto-generated method stub
		return null;
	}

}
