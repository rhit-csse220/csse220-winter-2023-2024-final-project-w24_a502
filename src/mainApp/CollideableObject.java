package mainApp;

import java.awt.Graphics2D;
import java.awt.geom.Dimension2D;

public abstract class CollideableObject {

    public double x,y;
    public double velX,velY,angle;
    public double moveSpeed;
    public boolean deathObject;



    

    public CollideableObject(int x2, double d, double velX2, double velY2) {
		this.x=x2;
		this.y=d;
		this.velX=velX2;
		this.velY=velY2;
	}
	public abstract void drawOn(Graphics2D g2);
    public abstract void overlap();
    public void update() {
    	this.x+=GameViewer.getGameSpeed()+velX;
    	this.y+=velY;
    	if(y<=GameViewer.getCeiling()) {
    		y=GameViewer.getCeiling();
    		velY=0;
    	}
    	if(y>=GameViewer.getFloor()) {
    		y=GameViewer.getFloor();
    		velY=0;
    	}
    }
    public boolean isOffScreen() {
    	return(x<-600) ;//returns true if object is 600 pixels off the screen to the left
    	
    }

}
