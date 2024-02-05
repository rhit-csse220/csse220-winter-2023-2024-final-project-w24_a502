package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class Player extends CollideableObject{
	private static final double MAX_SPEED = 6;
	private static final double thrustIncrement = 10;
	private double gravity=1;
	private boolean death=false;
	private static double posY;
    private boolean isFlying;
    private ImageIcon icon;
    private int height,width;

    public Player(int x2, int y2, double velX2, double velY2) {
		super(x2, y2, velX2, velY2);
        isFlying=false;
        
        icon=new ImageIcon("playerImage.png");
        
        
        height=icon.getIconHeight();
        
        width=icon.getIconHeight();
        
        







    }
    @Override
    public void update() {
        
        if (isFlying) {
            velY-=0.5;
            if (velY>MAX_SPEED) {
                velY=4;
            }
        }else{
            velY+=gravity*0.5;
        }
        
        
    	
        this.y+=velY;
        if(y<GameViewer.getCeiling()) {
    		y=GameViewer.getCeiling();
            velY=0;
    	}
    	if(y>GameViewer.getFloor()-60) {
    		y=GameViewer.getFloor()-60;
            velY=0;
    	}
    	posY=y;
        
    }
	@Override
    public void drawOn(Graphics2D g2) {
		g2.translate(x,y);
		
		if(death) {
			g2.setColor(Color.RED);
            

		}
		else {
			g2.setColor(Color.BLUE);
            
		}
		g2.fillRect(0, 0, 80, 20);
		g2.drawImage(icon.getImage(),0,-height,width, height, null);
		g2.translate( -x,-y);
		
    }

    @Override
    public void overlap() {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'overlap'");
    }
    
    //do actions when any key on key board is pressed

   public static double getPosY() {
	   return posY;
   }

   public void changeIsFlying(boolean b){
        isFlying=b;
   }
}
