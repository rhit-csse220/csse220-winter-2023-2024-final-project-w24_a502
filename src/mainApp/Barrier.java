package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

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

		if (electrified) {
			deathObject=true;
		}else{
			deathObject=false;
		}
		icon=new ImageIcon("electric barrier.png");
        height=icon.getIconHeight();
        width=icon.getIconWidth();

		// int[] Xs={0,};
		// int[] Ys={0,};
		
		// Polygon polygon=new Polygon(Xs, Ys, 4);
	}

	@Override
    public void drawOn(Graphics2D g2) {
		//System.out.println(x+"   "+y);
		g2.translate(x,y);
		
		g2.rotate((theta*Math.PI)/180);
		Rectangle2D rect = new Rectangle2D.Double(-length/2.0, -30, length, 60);
		if(electrified) {
			//g2.setColor(Color.yellow);
			g2.drawImage(icon.getImage(),(int)(0-width/2.0),(int)(-height/2.0),width, height, null);
		}
		else {
			g2.setColor(Color.RED);
			g2.fill(rect);
		}
		
		
		g2.rotate((-theta*Math.PI)/180);
		g2.setColor(Color.black);
		g2.translate( -x,-y);
//shows where detection occurs
		{
			ArrayList<Double> xpts=new ArrayList<>();
			ArrayList<Double> ypts=new ArrayList<>();
			for(int i =0; i<8;i++) {
				xpts.add(-length/2.0+i*2*length/7.0);
			}
			for(int i =0; i<4;i++) {
				ypts.add(-30+i*60.0/3.0);
			}
			//System.out.print(xpts.get(0));
			for(int i =0;i<32;i++) {
				double xPt = xpts.get(i/8);
				double yPt = ypts.get(i%4);
				double alterX= xPt*Math.cos(theta*Math.PI/180.0)-yPt*Math.sin(theta*Math.PI/180.0);
				double alterY= xPt*Math.sin(theta*Math.PI/180.0)+yPt*Math.cos(theta*Math.PI/180.0);
				g2.drawOval((int)(x+alterX),(int) (y+alterY), 5, 5);
			}
		}
// shows points of detection
	}



     @Override
     public void update() {
         super.update();
     }

	@Override
	boolean isOverLapping(Shape object) {
		ArrayList<Double> xpts=new ArrayList<>();
		ArrayList<Double> ypts=new ArrayList<>();
		double xPt,yPt,alterX,alterY;
		for(int i =0; i<8;i++) {
			xpts.add(-length/2.0+i*2*length/7.0);
		}
		for(int i =0; i<4;i++) {
			ypts.add(-30+i*60.0/3.0);
		}		
		for(int i =0;i<32;i++) {
			xPt = xpts.get(i/8);
			yPt = ypts.get(i%4);
			alterX= xPt*Math.cos(theta*Math.PI/180.0)-yPt*Math.sin(theta*Math.PI/180.0);
			alterY= xPt*Math.sin(theta*Math.PI/180.0)+yPt*Math.cos(theta*Math.PI/180.0);
			if(object.contains(x+alterX, y+alterY))
				return true;
		}
		return false;
//		Rectangle2D rect = new Rectangle2D.Double(x, y, width, height);
		
//		Polygon rect = new Polygon(x4, y4, 4);
//		return object.intersects(rect);
//		return object.;
	}

	@Override
	public ObjectType getType() {
		return ObjectType.BARRIER;
	}

    
}
