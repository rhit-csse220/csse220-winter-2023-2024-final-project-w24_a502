package mainApp;

import java.awt.Graphics2D;
import java.awt.geom.Dimension2D;

public class Player extends CollideableObject{

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
        velY=1;
    }

    public void update(Dimension2D dim){
        x += velX;
        y += velY;
        if (x > dim.getWidth() || x < 0) {
            x = (int) Math.min(Math.max(x, 0), dim.getWidth());
            velX = -velX;
        }
        if (y > dim.getHeight() || y < 0) {
            velY = -velY;
            y = (int) Math.min(Math.max(y, 0), dim.getHeight());
        }
        velY=0;
    }

}
