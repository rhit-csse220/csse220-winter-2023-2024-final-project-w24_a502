package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;

public class Player extends CollideableObject{
	private static final double MAX_SPEED = 6;
	private static final double thrustIncrement = 10;
	private double gravity=1;
    private static int life;
	private boolean dead=false;
	private static double posY,posX;
    private boolean isFlying;
    private ImageIcon icon;
    private int height,width;
    private int Invincible;
    
    public Player(int x2, int y2, double velX2, double velY2) {
		super(x2, y2, velX2, velY2);
        isFlying=false;
        
        icon=new ImageIcon("playerImage.png");
        
        
        height=(int) (icon.getIconHeight()*1.2);
        
        width=(int) (icon.getIconWidth()*1.2);
        
        life=5;

        Invincible=70;
        velX=0;   

    }
    public boolean isDead(){
        return dead;
    }
    @Override
    public void update() {
        if (life<1) {
            dead=true;
        }
        
        if (isFlying) {
            velY-=0.5;
            if (velY>MAX_SPEED) {
                velY=4;
            }
        }else{
            velY+=gravity*0.5;
        }
        if (Invincible>0) {
            Invincible--;
        }
        
        
    	this.y+=velY;
        this.x+=velX;
        
        if(y<GameViewer.getCeiling()+height+50) {
    		y=GameViewer.getCeiling()+height+50;
            velY=0;
    	}
    	if(y>GameViewer.getFloor()-150) {
    		y=GameViewer.getFloor()-150;
            velY=0;
    	}

        if (x<0) {
            velX=0;
            changeLife(-1);
        }
        if (x!=500) {
            velX=-(x-500)/100;
        }

        
        
    	posY=y;
    	posX=x;
        
    }
	@Override
    public void drawOn(Graphics2D g2) {
		g2.translate(x,y);
		
		if(dead) {
			//g2.setColor(Color.RED);
		}
		else {
            if (Invincible%20>10) {
                
            }else{
			    g2.drawImage(icon.getImage(),0,0,width, height, null);
			    
            }
		}
		
		g2.translate( -x,-y);
		//g2.draw(new Rectangle2D.Double(x, y, width, height));   
    }


    
    //do actions when any key on key board is pressed

    public static double getPosY() {
        return posY;
    }

    public void changeIsFlying(boolean b){
            isFlying=b;
    }
    
    public static double getPosX() {
        return posX;
    }
    public static int getLife(){
            return life;
    }
   
	public Rectangle2D shape() {
		return new Rectangle2D.Double(x, y, width, height);
	}
	@Override
	public ObjectType getType() {
		return ObjectType.PLAYER;
	}
    public void changeLife(int i) {
        if (Invincible>0) {
            return;
        }else{
            life+=i;
            Invincible=70;
        }
    }
    public void stuck(Barrier barrier) {
        if (Invincible>0) {
            
        }else{
        	int ySideMultiplier=1,xSideMultiplier=1;
        	double ang = barrier.getAngle();
        	if(y-x*Math.sin(ang)<barrier.y-barrier.x*Math.sin(ang)) {
        		ySideMultiplier=-1;
            }
//        	if(x<barrier.x) {
//        		xSideMultiplier=-1;
//        	}
        	
        	x+=5*Math.abs(Math.sin(ang+Math.PI/90.0))*ySideMultiplier;
        	y+=5*Math.abs(Math.cos(ang+Math.PI/90.0))*ySideMultiplier;
        	velY+=6 *Math.abs(Math.cos(ang+Math.PI/90.0))*ySideMultiplier;//should just disable thrust or gravity. maybe set the vel to 0 might work better.
        	if (Math.abs(ang)==Math.PI/2.0) {
               velX= GameViewer.getGameSpeed();
               x-=5*Math.abs(Math.sin(ang+Math.PI/90.0))*ySideMultiplier;
           }
        	if (Math.abs(ang)==0) {
                velY= 0;
                y-=5*Math.abs(Math.cos(ang+Math.PI/90.0))*ySideMultiplier;
            }
        	if(y<GameViewer.getCeiling()+height+50) {
        		y=GameViewer.getCeiling()+height+50;
        		velX= GameViewer.getGameSpeed();
                x-=5*Math.abs(Math.sin(ang+Math.PI/90.0))*ySideMultiplier;
        	}
        	if(y>GameViewer.getFloor()-150) {
        		y=GameViewer.getFloor()-150;
        		velX= GameViewer.getGameSpeed();
                x-=5*Math.abs(Math.sin(ang+Math.PI/90.0))*ySideMultiplier;
        	}
        	//        	velX+=Math.cos(ang)*xSideMultiplier;
        	//velY-=Math.sin(ang)*ySideMultiplier;
//            if (this.x<barrier.x) {
//                velX=GameViewer.getGameSpeed();
//            }
//            else 
//            	if (this.y>barrier.y) {
//                y+=1;
//                velY=+1;
//            }else{
//                y-=1;
//                velY=-1;
//            }
            
            // x-=(barrier.x+barrier.width/2-this.x)/10;
            // y-=(barrier.y-barrier.height/2-this.y)/10;
            //velX=GameViewer.getGameSpeed();
            
            
            
        }
       
    }
    @Override
    boolean isOverLapping(Rectangle2D object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isOverLapping'");
    }
}