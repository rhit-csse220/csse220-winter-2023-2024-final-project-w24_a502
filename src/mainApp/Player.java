package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;

public class Player extends CollideableObject{
	private static final double MAX_SPEED = 50;
	private static final double thrustIncrement = 10;
	private int gravity=1;
	private boolean death=false;
	private static int posY;
    private boolean isFlying;

    public Player(int x2, int y2, int velX2, int velY2) {
		super(x2, y2, velX2, velY2);
        isFlying=false;
	}
    @Override
    public void update() {
        if (isFlying) {
            velY=-6;
        }else{
            velY+=gravity;
        }
        
    	
        this.y+=velY;
        if(y<=GameViewer.getCeiling()) {
    		y=GameViewer.getCeiling();
    	}
    	if(y>=GameViewer.getFloor()) {
    		y=GameViewer.getFloor();
    	}
    	posY=y;
        
        System.out.println(y);
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
		
		g2.translate( -x,-y);
		
    }

    @Override
    public void overlap() {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'overlap'");
    }
    
    //do actions when any key on key board is pressed

   public static int getPosY() {
	   return posY;
   }

   public void changeIsFlying(boolean b){
        isFlying=b;
        System.out.println(isFlying);
   }
}
