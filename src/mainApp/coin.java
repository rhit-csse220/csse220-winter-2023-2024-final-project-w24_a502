package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.ImageIcon;

public class coin extends CollideableObject {
	private ImageIcon icon;
    private int height,width;
	

	private final static int COIN_RADIUS=30;
	public coin(int x, int y,int velX,int velY) {
		super(x,y,0,0);
		if(this.y+COIN_RADIUS>GameViewer.getFloor()) {
			this.y=GameViewer.getFloor()-COIN_RADIUS;
		}
		if(this.y-COIN_RADIUS<GameViewer.getCeiling()) {
			this.y=GameViewer.getCeiling()+COIN_RADIUS;
		}//forces the coin to be between the ceiling and the floor.

		icon=new ImageIcon("coin.png");
        height=icon.getIconHeight();
        width=icon.getIconHeight();
	}
    @Override
    public void drawOn(Graphics2D g2) {
    	g2.translate(x, y);
    	g2.drawImage(icon.getImage(),0,0,width, height, null);

        g2.translate(-x,-y);
    }

   

    @Override
    public void update() {
        super.update();
    }
	@Override
	boolean isOverLapping(Shape object) {
		   return object.contains(x, y, COIN_RADIUS, COIN_RADIUS);
    	}
	@Override
	public ObjectType getType() {
		// TODO Auto-generated method stub
		return null;
	}
    
}
