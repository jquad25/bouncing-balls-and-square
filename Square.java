import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Graphics2D;
/**
 * Square is the bouncer for a square shape to bounce around the screen.
 *
 * @author Ursula Jordan Aquadro
 * @version v1.0
 */
public class Square
{
    private Dimension screenSize;
    private Color color;
    private Point location;
    private int height;
    private int width;
    private int area;
    private Point speed;

    public Square(Dimension screenSize) {
        this.screenSize = screenSize;
        width = ((int)(Math.random()*20))+5;
	height = ((int)(Math.random()*20))+5;
        area = width * height;
        location = new Point(screenSize.width/2,screenSize.height/2);
        color = new Color((float)Math.random(),(float)Math.random(),(float)Math.random());
        speed = new Point(1 + ((int)(Math.random()*20)), 1 + ((int)(Math.random()*20)));
    }

    public int getArea() {
        return area;
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
        if ( (location.x < 0) || (location.x > screenSize.width) )
            speed.x = -speed.x;
        if ( (location.y < 0) || (location.y > screenSize.height) )
            speed.y = -speed.y;
    }

    public void paint(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fillRect(location.x, location.y, area, area);
    }
}
