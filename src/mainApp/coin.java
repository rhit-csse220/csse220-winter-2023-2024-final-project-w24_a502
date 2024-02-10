package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;

public class coin extends CollideableObject {
	private ImageIcon icon;
    private int height,width;
	

	//private final static int COIN_RADIUS=30;
	public coin(int x, int y,int velX,int velY) {
		
		super(x,y,0,0);

		icon=new ImageIcon("coin.png");
        height=icon.getIconHeight();
        width=icon.getIconHeight();

		if(this.y+height>GameViewer.getFloor()) {
			this.y=GameViewer.getFloor()-height;
		}
		if(this.y-height<GameViewer.getCeiling()) {
			this.y=GameViewer.getCeiling()+height;
		}//forces the coin to be between the ceiling and the floor.

		
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
		Rectangle2D rect = new Rectangle2D.Double(x, y, width, height);
		   return object.intersects(rect);
    	}
	@Override
	public ObjectType getType() {
		// TODO Auto-generated method stub
		return ObjectType.COIN;
	}
    
}
