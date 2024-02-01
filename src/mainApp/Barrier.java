package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;


public class Barrier  extends CollideableObject {

    private int theta;
    private int length;
    private boolean electrified;
    public Barrier(int x2, int y2, int size, int theta, boolean electrified) {
		super(x2, y2, 0, 0);
		this.theta=theta;
		this.electrified=electrified;
		// TODO Auto-generated constructor stub
	}

	@Override
    public void drawOn(Graphics2D g2) {
		
		g2.translate( x,y);
		g2.rotate((theta*Math.PI)/180);
		if(electrified) {
			g2.setColor(Color.YELLOW);
		}
		else {
			g2.setColor(Color.BLACK);
		}
		g2.fillRect(0, 0, length, 20);
		g2.rotate((-theta*Math.PI)/180);
		g2.translate( -x,-y);
		}

    @Override
    public void overlap() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'overlap'");
    }

    @Override
    public void update() {
        super.update();
    }
    
}
