import java.awt.Color;
import java.awt.Graphics2D;

import org.finomnis.common.graphics.DrawingWindow;

public class Main {

    public static void main(String[] args) {
        
        // Create window
        DrawingWindow window = new DrawingWindow("Example Window", 400, 300);
        window.setPixelSize(2);
        
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

                // Draw surrounding square
                g2d.setColor(Color.RED);
                g2d.drawRect(0, 0, 399, 299);
                
                // Dispose graphics content
                g2d.dispose();
            }
                
            // Show (= pageflip)
            window.display();
            
            // TEST resizing capability
            if(i == window.getWidth() - 1 && window.getWidth() == 400){
                window.resize(600,400);
            }

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
