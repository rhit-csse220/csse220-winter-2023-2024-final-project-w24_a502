package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;


public abstract class missile extends CollideableObject {

  
	protected static final int MISSLE_SIZE = 30;
	public missile(int x2, double d, int velX2, int velY2) {
		super(GameViewer.WIDTH-MISSLE_SIZE, d, 0, 0);
		
	}

//	@Override
//    public void drawOn(Graphics2D g2) {
//		
////		g2.translate( x,y);
////		
////		if(missleTimer>0) {
////			g2.setColor(Color.YELLOW);
////			
////		}
////		else {
////			g2.setColor(Color.BLUE);
////		}
////		g2.fillRect(0, 0, MISSLE_SIZE, MISSLE_SIZE);
////		
////		g2.translate( -x,-y);
//       
//    }

//    @Override
//    public void overlap() {
//        // TODO Auto-generated method stub
//        throw new UnsupportedOperationException("Unimplemented method 'overlap'");
//    }
	@Override
	public void update() {
		super.update();
	}
    
    
}
