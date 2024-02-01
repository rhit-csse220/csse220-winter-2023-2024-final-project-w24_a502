package mainApp;

import java.awt.Graphics2D;
import java.awt.geom.Dimension2D;

public class Player extends CollideableObject{
	private int gravity=5;
    public Player(int x2, int y2, int velX2, int velY2) {
		super(x2, y2, velX2, velY2);
		// TODO Auto-generated constructor stub
	}
    @Override
    public void update() {
    	
    	this.y+=velY;
    	if(velY>gravity) {
    		velY-=gravity;
    	}
    	else if(velY<=gravity) {
    		velY=0;
    	}
    	if(y<=GameViewer.getFloor()) {
    		y=GameViewer.getFloor();
    	}
    }
	@Override
    public void drawOn(Graphics2D g2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'drawOn'");
    }

    @Override
    public void overlap() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'overlap'");
    }
    
    //do actions when any key on key board is pressed
    public void goUp() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'action'");
    }
    public void goUp() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'action'");
    }
}
