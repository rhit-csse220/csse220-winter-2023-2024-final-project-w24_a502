package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class coin extends CollideableObject {
	private int x;
	private int y;

	private final static int COIN_RADIUS=30;
	public coin(int x, int y,int velX,int velY) {
		super(x,y,velX,velY);
		if(this.y+COIN_RADIUS>GameViewer.getFloor()) {
			this.y=GameViewer.getFloor()-COIN_RADIUS;
		}
		if(this.y-COIN_RADIUS<GameViewer.getCeiling()) {
			this.y=GameViewer.getCeiling()+COIN_RADIUS;
		}//forces the coin to be between the ceiling and the floor.
	}
    @Override
    public void drawOn(Graphics2D g2) {
    	g2.translate(x, y);
    	Ellipse2D coin = new Ellipse2D.Double(0,0, COIN_RADIUS,COIN_RADIUS);
    	g2.setColor(Color.black);
        g2.fill(coin);
        g2.translate(-x,-y);
    }

    @Override
    public void overlap() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'overlap'");
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        super.update();
    }
    
}
