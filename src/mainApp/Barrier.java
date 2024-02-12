package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;


public class Barrier  extends CollideableObject {

    private int theta;
    private int length;
    private boolean electrified;
	private ImageIcon icon;
    public int height,width;
	public Polygon collisionBox;
    public Barrier(int x2, int y2, int size, int theta, boolean electrified) {
		super(x2, y2, 0, 0);
		length=size;
		this.theta=theta;
		this.electrified=electrified;
		// if(this.y-this.length*Math.cos((this.theta*Math.PI)/180.0)<GameViewer.getCeiling()) {
		// 	this.y=(int) (GameViewer.getCeiling()+this.length*Math.cos((this.theta*Math.PI)/180.0));
		// }
		// if(this.y+this.length*Math.cos((this.theta*Math.PI)/180.0)>GameViewer.getFloor()) {
		// 	this.y=(int) (GameViewer.getFloor()-this.length*Math.cos((this.theta*Math.PI)/180.0));
		// }//forces the barrier to be with bounds of ceiling and floor

		if (electrified) {
			deathObject=true;
		}else{
			deathObject=false;
			this.theta=(theta/46)*90;
		}

		icon=new ImageIcon("electric barrier.png");
        height=(int) (icon.getIconHeight()*0.9);
        width=(int) (length*1.2);
		double cos=Math.cos((this.theta*Math.PI)/180);
		double sin=Math.sin((this.theta*Math.PI)/180);

		int[] Xs={	(int) x,
					(int)(width*cos+x),
					(int)(width*cos+height*sin+x),
					(int)(height*sin+x)
					};
		int[] Ys={	(int) y,
					(int)(width*sin+y),
					(int)(width*sin-height*cos+y),
					-(int)(height*cos)+(int)y
					};
		
		collisionBox=new Polygon(Xs, Ys, 4);
	}

	@Override
    public void drawOn(Graphics2D g2) {
		//System.out.println(x+"   "+y);
		
		
		g2.setColor(Color.green);
		g2.fill(collisionBox);

		g2.translate(x,y);
		g2.rotate((theta*Math.PI)/180);

		Rectangle2D rect = new Rectangle2D.Double(0,-height,width, height);
		if(electrified) {

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
		 double cos=Math.cos((theta*Math.PI)/180);
		double sin=Math.sin((theta*Math.PI)/180);

		int[] Xs={	(int) x,
					(int)(width*cos+x),
					(int)(width*cos+height*sin+x),
					(int)(height*sin+x)
					};
		int[] Ys={	(int) y,
					(int)(width*sin+y),
					(int)(width*sin-height*cos+y),
					-(int)(height*cos)+(int)y
					};
		
		collisionBox=new Polygon(Xs, Ys, 4);
     }

	@Override
	boolean isOverLapping(Rectangle2D object) {
		
		
		return collisionBox.intersects(object);
	}

	@Override
	public ObjectType getType() {
		return ObjectType.BARRIER;
	}

    
}
