package mainApp;

import java.awt.Graphics2D;

public abstract class CollideableObject {

    public int x,y;
    public double velX,velY,moveSpeed,angle;
    public boolean deathObject;

    public abstract void drawOn(Graphics2D g2);
    public abstract void overlap();

}
