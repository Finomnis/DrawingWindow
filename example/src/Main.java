import java.awt.Color;
import java.awt.Graphics2D;

import org.finomnis.common.DrawingWindow;

public class Main {

    public static void main(String[] args) {
        
        // Create window
        DrawingWindow window = new DrawingWindow("Example Window", 600, 400);
        
        int i = 0;
        while(true){

            // Clear frame
            window.clear();
            
            // Rendering function
            {
                // Get graphics context
                Graphics2D g2d = window.createGraphics();
                
                // Draw line
                g2d.setColor(Color.GREEN);
                g2d.drawLine(i,0,i,window.getHeight()-1);

                
                // Dispose graphics content
                g2d.dispose();
            }
                
            // Show (= pageflip)
            window.display();
            
            // Update function
            {
                // Move line
                i++;
                if(i >= window.getWidth()){
                    i = 0;
                }
            }
            
            // Wait
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        
    }

}