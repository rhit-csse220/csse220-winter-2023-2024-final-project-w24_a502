package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;


public class missile extends CollideableObject {

    private static final double MISSLE_SPEED_MODIFER = 1/3;
	private static final int MISSLE_SIZE = 30;
	private static final int MISSLE_LAUNCH_SPEED = 100;
	private int missleTimer=100;
	public missile(int x2, int y2, int velX2, int velY2) {
		super(GameViewer.WIDTH-MISSLE_SIZE, y2, 0, 0);
		
	}

	@Override
    public void drawOn(Graphics2D g2) {
		g2.translate( x,y);
		
		if(missleTimer>0) {
			g2.setColor(Color.YELLOW);
			
		}
		else {
			g2.setColor(Color.BLUE);
		}
		g2.fillRect(0, 0, MISSLE_SIZE, MISSLE_SIZE);
		
		g2.translate( -x,-y);
       
    }

    @Override
    public void overlap() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'overlap'");
    }

    @Override
    public void update() {
    	
    	if(missleTimer>0) {
    		velY=((Player.getPosY()-this.y)*MISSLE_SPEED_MODIFER);
    		missleTimer--;
    	}
    	else {
    		velY=(0);
    		velX=(-MISSLE_LAUNCH_SPEED);
    		missleTimer=0;
    	}
    	super.update();
    }
    
}
