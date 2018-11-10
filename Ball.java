import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Graphics2D;

public class Ball {
    private Dimension screenSize;
    private Color color;
    private Point location;
    private int radius;
    private int diameter;
    private Point speed;

    public Ball(Dimension screenSize) {
        this.screenSize = screenSize;
        radius = ((int)(Math.random()*40))+10;
        diameter = radius * 2;
        location = new Point(screenSize.width/2,screenSize.height/2);
        color = new Color((float)Math.random(),(float)Math.random(),(float)Math.random());
        speed = new Point(1 + ((int)(Math.random()*20)), 1 + ((int)(Math.random()*20)));
    }

    public int getDiameter() {
        return diameter;
    }

    public Color getColor() {
        return color;
    }

    public Point getLocation() {
        return location;
    }

    public Point getSpeed() {
        return speed;
    }

    public void move() {
        location.setLocation(location.x+speed.x,location.y+speed.y);
        if ( (location.x < 0) || (location.x > screenSize.width-diameter) )
            speed.x = -speed.x;
        if ( (location.y < 0) || (location.y > screenSize.height-diameter) )
            speed.y = -speed.y;
    }

    public void paint(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fillOval(location.x, location.y, diameter, diameter);
    }
}