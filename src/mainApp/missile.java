package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;


public abstract class missile extends CollideableObject {

	public ImageIcon icon;
    public int height,width;
	
	public missile(int x2, double d, int velX2, int velY2) {
		super(x2, d, 0, 0);
		icon=new ImageIcon("missile.png");
        
        
        height=icon.getIconHeight();
        width=icon.getIconWidth();
	}
	@Override
	public void update() {
		super.update();
	}
	@Override
	public ObjectType getType() {
		return ObjectType.MISSLE;
	}
	@Override
	boolean isOverLapping(Rectangle2D object)  {
		return object.intersects(new Rectangle2D.Double(x, y, width, height));
	}
    
    
}
