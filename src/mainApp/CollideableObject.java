package mainApp;

import java.awt.Graphics2D;
import java.awt.geom.Dimension2D;

public abstract class CollideableObject {

    public int x,y;
    public double velX,velY,angle;
    public double moveSpeed;
    public boolean deathObject;



    

    public abstract void drawOn(Graphics2D g2);
    public abstract void overlap();
    public abstract void update(Dimension2D dim);

}
