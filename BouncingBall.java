import java.awt.*;
import javax.swing.*;
/**
 * BouncingBall produces a panel with one ball bouncing off the edges.
 * 
 * It uses a single instance of the Ball class to provide the bouncer.
 */
public class BouncingBall extends JPanel {
    private final Dimension SIZE = new Dimension(800,600); // Panel size
    private final int UPDATE_RATE = 30; // Number of refreshes per second
    private Ball ball; // The beautiful bouncing ball
    private Square square; //The pretty square
    private Thread ballThread; // Ball animation thread
    private Thread squareThread; // Square animation thread
    
    /** 
     * Constructor sets up the panel and starts its animation thread 
     */
    public BouncingBall() {
        setPreferredSize(SIZE); // Set panel size
        ball = new Ball(SIZE); // Create a Ball object
        square = new Square(SIZE); // Create a Square object
        // Start the ball bouncing (in its own animation thread)
        ballThread = new Thread() {
                public void run() {
                    while (true) { // Execute one update step
                        // Calculate the balls' new positions
                        ball.move();
                        // Refresh the display
                        repaint(); // Callback paintComponent()
                        // Delay so the animation's not too fast
                        try {
                            Thread.sleep(1000 / UPDATE_RATE);  // milliseconds
                        } catch (InterruptedException ex) { }
                    }
                }
            };
        ballThread.start();  // Start the animation
        
        //Start the square bouncing (in its own animation thread)
        squareThread = new Thread() {
                public void run() {
                    while (true) { // Execute one update step
                        // Calculate the square's new positions
                        square.move();
                        // Refresh the display
                        repaint(); // Callback paintComponent()
                        // Delay so the animation's not too fast
                        try {
                            Thread.sleep(800 / UPDATE_RATE);  // milliseconds
                        } catch (InterruptedException ex) { }
                    }
                }
            };
            squareThread.start();  // Start the animation
    }

    /** 
     * Override the JPanel paintComponent method with our drawing of a ball and a square
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);    // Paint background
        Graphics2D g2d= (Graphics2D) g;
        // Draw the box's background
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // Draw the ball
        ball.paint(g2d);
        square.paint(g2d);
    }   
}

