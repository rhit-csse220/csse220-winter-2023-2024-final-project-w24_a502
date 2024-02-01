package mainApp;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class coin extends CollideableObject {
	private int x;
	private int y;
	private int GLOBAL_SPEED;
	private final static int COIN_RADIUS=30;
	public coin(int x, int y) {
		this.x=x;
		this.y=y;
	}
    @Override
    public void drawOn(Graphics2D g2) {
    	g2.translate(x, y);
    	Ellipse2D coin = new Ellipse2D.Double(x,y, COIN_RADIUS,COIN_RADIUS);
    	
        g2.fill(coin);
        g2.translate(-x,-y);
    }

    @Override
    public void overlap() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'overlap'");
    }

    @Override
    public void update(Dimension2D dim) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
