package mainApp;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Dimension2D;
import java.awt.geom.Rectangle2D;

public abstract class CollideableObject {

    public double x,y;
    public double velX,velY,angle;
    
    public boolean deathObject;
    public abstract ObjectType getType();
    

    public CollideableObject(int x2, double d, double velX2, double velY2) {
		this.x=x2;
		this.y=d;
		this.velX=velX2;
		this.velY=velY2;
	}
	public abstract void drawOn(Graphics2D g2);
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
    	return(x<-1000) ;//returns true if object is 1000 pixels off the screen to the left
    	
    }
    abstract boolean isOverLapping(Rectangle2D object);
    public boolean isDeath() {
    	return deathObject;
    }
}
