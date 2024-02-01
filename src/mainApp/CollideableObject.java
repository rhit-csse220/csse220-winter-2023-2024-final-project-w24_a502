package mainApp;

import java.awt.Graphics2D;

public abstract class CollideableObject {

    public int x,y;
    public double velX,velY,angle;
    public double moveSpeed;
    public boolean deathObject;



    

    public CollideableObject(int x2, int y2, int velX2, int velY2) {
		this.x=x2;
		this.y=y2;
		this.velX=velX2;
		this.velY=velY2;
	}
	public abstract void drawOn(Graphics2D g2);
    public abstract void overlap();
    public void update() {
    	this.x+=GameViewer.getGameSpeed()+velX;
    	this.y+=GameViewer.getGameSpeed()+velY;
    }

}
