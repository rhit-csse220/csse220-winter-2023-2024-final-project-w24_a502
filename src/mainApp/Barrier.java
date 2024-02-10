package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;


public class Barrier  extends CollideableObject {

    private int theta;
    private int length;
    private boolean electrified;
	private ImageIcon icon;
    private int height,width;
    public Barrier(int x2, int y2, int size, int theta, boolean electrified) {
		super(x2, y2, 0, 0);
		length=size;
		this.theta=theta;
		this.electrified=electrified;
		if(this.y-this.length*Math.cos((this.theta*Math.PI)/180.0)<GameViewer.getCeiling()) {
			this.y=(int) (GameViewer.getCeiling()+this.length*Math.cos((this.theta*Math.PI)/180.0));
		}
		if(this.y+this.length*Math.cos((this.theta*Math.PI)/180.0)>GameViewer.getFloor()) {
			this.y=(int) (GameViewer.getFloor()-this.length*Math.cos((this.theta*Math.PI)/180.0));
		}//forces the barrier to be with bounds of ceiling and floor

		icon=new ImageIcon("electric barrier.png");
        height=icon.getIconHeight();
        width=icon.getIconHeight();
		
	}

	@Override
    public void drawOn(Graphics2D g2) {
		//System.out.println(x+"   "+y);
		g2.translate(x,y);
		
		g2.rotate((theta*Math.PI)/180);
		Rectangle2D rect = new Rectangle2D.Double(-length/2, -30, length, 60);
		if(electrified) {
			//g2.setColor(Color.yellow);
			g2.drawImage(icon.getImage(),0,-height,width, height, null);
		}
		else {
			g2.setColor(Color.RED);
			g2.fill(rect);
		}
		
		
		g2.rotate((-theta*Math.PI)/180);
		g2.setColor(Color.black);
		g2.translate( -x,-y);
		}



     @Override
     public void update() {
         super.update();
     }

	@Override
	boolean isOverLapping(Shape object) {
		// TODO Auto-generated method stub
		Rectangle2D rect = new Rectangle2D.Double(-length/2, -30, length, 60);
		return object.contains(rect);
	}

	@Override
	public ObjectType getType() {
		// TODO Auto-generated method stub
		return ObjectType.BARRIER;
	}
    
}
