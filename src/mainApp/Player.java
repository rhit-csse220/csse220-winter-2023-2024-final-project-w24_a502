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
	private boolean death=false;
	private static double posY,posX;
    private boolean isFlying;
    private ImageIcon icon;
    private int height,width;
    private int Invincible;
    
    public Player(int x2, int y2, double velX2, double velY2) {
		super(x2, y2, velX2, velY2);
        isFlying=false;
        
        icon=new ImageIcon("playerImage.png");
        
        
        height=icon.getIconHeight();
        
        width=icon.getIconHeight();
        
        life=3;

        Invincible=100;
        velX=0;   

    }
    @Override
    public void update() {
        if (life<1) {
            death=true;
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
        
        if(y<GameViewer.getCeiling()+height) {
    		y=GameViewer.getCeiling()+height;
            velY=0;
    	}
    	if(y>GameViewer.getFloor()-100) {
    		y=GameViewer.getFloor()-100;
            velY=0;
    	}

        if (x<0) {
            velX=0;
            changeLife(-1);
        }
        if (x!=500) {
            velX=-(x-500)/10;
        }

        
        
    	posY=y;
    	posX=x;
        
    }
	@Override
    public void drawOn(Graphics2D g2) {
		g2.translate(x,y);
		
		if(death) {
			//g2.setColor(Color.RED);
		}
		else {
            if (Invincible%20>10) {
                
            }else{
			    g2.drawImage(icon.getImage(),0,0,width, height, null);
            }
		}
		
		g2.translate( -x,-y);
		
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
   @Override
   boolean isOverLapping(Shape object) {
	// TODO Auto-generated method stub
	return false;
   }//not used.
	public Shape shape() {
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
            Invincible=100;
        }
    }
    public void stuck() {
        if (Invincible>0) {
            
        }else{
            velX=GameViewer.getGameSpeed();
        }
        
    }
}