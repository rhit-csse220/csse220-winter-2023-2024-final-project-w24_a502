package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

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
			//this.theta=(theta/46)*90;
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

		Rectangle2D rect = new Rectangle2D.Double(-width/2.0,-height/2,width, height);
		if(electrified) {

			g2.drawImage(icon.getImage(),(int)(-width/2.0),-height/2,width, height, null);
		}
		else {
			g2.setColor(Color.RED);
			g2.fill(rect);
		}
		
		
		g2.rotate((-theta*Math.PI)/180);
		g2.setColor(Color.black);
		g2.translate( -x,-y);
		g2.setColor(Color.green);
		g2.fill(collisionBox);
		g2.setColor(Color.black);
//		ArrayList<Double> xpts=new ArrayList<>();
//		ArrayList<Double> ypts=new ArrayList<>();
//				
//		double xPt,yPt,alterX,alterY;
//		double objectMinSide=25;
//		for(int i =0; i<(int)(this.length/objectMinSide);i++) {
//			xpts.add(-length/2.0+i*2*length/(this.length/objectMinSide-1));
//		}
//		// takes 8 points along the x axis for detection
//		for(int i =0; i<(int)(this.height/objectMinSide);i++) {
//			ypts.add(-height/2+2*i*height/(this.height/objectMinSide-1));
//		}		
//		// takes 4 points along the x axis for detection		
//	for(int i =0; i<(int)(this.length/objectMinSide);i++) {
//	
//	// takes 8 points along the x axis for detection
//		for(int j =0; i<(int)(this.height/objectMinSide);i++) {
//			xPt = xpts.get(i);
//			yPt = ypts.get(j);
//
//			//matrix rotation
//			alterX= xPt*Math.cos(theta*Math.PI/180.0)-yPt*Math.sin(theta*Math.PI/180.0);
//			alterY= xPt*Math.sin(theta*Math.PI/180.0)+yPt*Math.cos(theta*Math.PI/180.0);
//			g2.drawOval((int)(x+alterX),(int)( y+alterY),5,5);
//			}
	}
//	for(int i =0;i<(int)(this.height*this.length/(objectMinSide*objectMinSide));i++) {
//		xPt = xpts.get(i/(int)(this.length/objectMinSide));
//		yPt = ypts.get(i%(int)(this.height/objectMinSide));
//
//		//matrix rotation
//		alterX= xPt*Math.cos(theta*Math.PI/180.0)-yPt*Math.sin(theta*Math.PI/180.0);
//		alterY= xPt*Math.sin(theta*Math.PI/180.0)+yPt*Math.cos(theta*Math.PI/180.0);
//		//detection
//			g2.drawOval((int)(x+alterX),(int)( y+alterY),5,5);
//		}
		
	
//	  	}



     @Override
     public void update() {
         super.update();
		 double cos=Math.cos((theta*Math.PI)/180);
		double sin=Math.sin((theta*Math.PI)/180);
		ArrayList<Double> xpts=new ArrayList<>();
		ArrayList<Double> ypts=new ArrayList<>();
		int[] Xs=new int[4];
		int[] Ys=new int[4];
		for(int i =0;i<4;i++) {
			xpts.add(length*(((i+1)/2)%2)-length/2.0);
			ypts.add(height*(i/2)-height/2.0);
			//matrix rotation
			
		}
		for(int i =0;i<4;i++) {
			Xs[i]= (int)(xpts.get(i)*cos-ypts.get(i)*sin+x);
			Ys[i]= (int)(xpts.get(i)*sin+ypts.get(i)*cos+y);
			
			//matrix rotation
			
		}
		collisionBox=new Polygon(Xs, Ys, 4);
     }

	@Override
	boolean isOverLapping(Rectangle2D object) {
		
//		ArrayList<Double> xpts=new ArrayList<>();
//		ArrayList<Double> ypts=new ArrayList<>();
//				
//		double xPt,yPt,alterX,alterY;
//		double objectMinSide=Math.min(object.getHeight(),object.getWidth())/2.0;
//			for(int i =0; i<(int)(this.length/objectMinSide);i++) {
//				xpts.add(-length/2.0+i*length/(this.length/objectMinSide-1));
//			}
//			// takes 8 points along the x axis for detection
//		for(int i =0; i<(int)(this.height/objectMinSide);i++) {
//			ypts.add(-height/2+i*height/(this.height/objectMinSide-1));
//			}		
//			// takes 4 points along the x axis for detection		
//		for(int i =0;i<(int)(this.height*this.length/(objectMinSide*objectMinSide));i++) {
//			xPt = xpts.get(i/(int)(this.length/objectMinSide));
//			yPt = ypts.get(i%(int)(this.height/objectMinSide));
//
//			//matrix rotation
//			alterX= xPt*Math.cos(theta*Math.PI/180.0)-yPt*Math.sin(theta*Math.PI/180.0);
//			alterY= xPt*Math.sin(theta*Math.PI/180.0)+yPt*Math.cos(theta*Math.PI/180.0);
//			//detection
//			if(object.contains(x+alterX, y+alterY))
//				return true;
//		}
//		return false;
		if(collisionBox.intersects(object)&&!electrified) {
          			int dummy = 0;
		}
		return collisionBox.intersects(object);
	}
	@Override
	public ObjectType getType() {
		return ObjectType.BARRIER;
	}

	public double getAngle() {
		// TODO Auto-generated method stub
		return (this.theta*Math.PI)/180.0;
	}
	public Polygon getColision() {
		return collisionBox;
	}
    
}
