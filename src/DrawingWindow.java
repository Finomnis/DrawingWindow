package org.finomnis.common.graphics;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class DrawingWindow {
	
	private class GraphComponent extends JComponent{

		public GraphComponent(){
			this.width = 200;
			this.height = 200;
			this.pixelSize = 1;
		}
		
		
		@Override
		public
		Dimension getPreferredSize(){
			return new Dimension(width,height);
		}
		
		private int width, height;
		private int pixelSize;
		
		private static final long serialVersionUID = 1L;
		
		private Lock l = new ReentrantLock();
		
		private BufferedImage internalRenderBuffer;
		
		@Override
		public void paintComponent(Graphics g){
			
			l.lock();
			try{
				g.drawImage(internalRenderBuffer, 0, 0, this);
			} finally {
				l.unlock();
			}
			
		}

		public boolean displayRenderBuffer(BufferedImage buffer) {
			boolean needsPack = false;
			l.lock();
			try{
				if(internalRenderBuffer == null){
					internalRenderBuffer = new BufferedImage(buffer.getWidth() * pixelSize, buffer.getHeight() * pixelSize, BufferedImage.TYPE_INT_RGB);
				} else {
					if(internalRenderBuffer.getHeight() != buffer.getHeight() * pixelSize || internalRenderBuffer.getWidth() != buffer.getWidth() * pixelSize){
						internalRenderBuffer = new BufferedImage(buffer.getWidth() * pixelSize, buffer.getHeight() * pixelSize, BufferedImage.TYPE_INT_RGB);
					}
				}
				Graphics2D g = internalRenderBuffer.createGraphics();
				g.drawRenderedImage(buffer, AffineTransform.getScaleInstance(pixelSize, pixelSize));
				g.dispose();
				if(width != internalRenderBuffer.getWidth() || height != internalRenderBuffer.getHeight()){
					this.width = internalRenderBuffer.getWidth();
					this.height = internalRenderBuffer.getHeight();
					needsPack = true;
				}
			} finally {
				l.unlock();
			}
			return needsPack;
		}
	
		public void setPixelSize(int size){
		    this.pixelSize = size;
		}
		
	}
	
	private GraphComponent graphComponent;
	private JFrame window;
	
	private BufferedImage renderBuffer;
	
	public DrawingWindow(String name, int width, int height){
	    this(name, width, height, 1);
	}
	    
	public DrawingWindow(String name, int width, int height, int pixelSize){
		
		renderBuffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		try {
			SwingUtilities.invokeAndWait(new Runnable(){
				public void run(){
					// Create Window
					window = new JFrame();
					window.setTitle(name);
					
					// Create Graph
					graphComponent = new GraphComponent();
					graphComponent.setPixelSize(pixelSize);
					graphComponent.displayRenderBuffer(renderBuffer);
					window.add(graphComponent,BorderLayout.CENTER);
					
					window.setResizable(false);
					window.pack();
					
					// Display
					window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					window.setLocationRelativeTo(null);
					window.setVisible(true);

				};
			});
		} catch (Exception e) {
			throw new RuntimeException(e);
		};
		
	}
	
	public Graphics2D createGraphics(){
		return renderBuffer.createGraphics();
	}
	
	public void setRGB(int x, int y, int rgb){
	    renderBuffer.setRGB(x,y,rgb);
	}
	
	public void clear(){
		Graphics2D g = renderBuffer.createGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, renderBuffer.getWidth(), renderBuffer.getHeight());
		g.dispose();
	}
	
	public void resize(int width, int height){
		renderBuffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	}
	
	public int getWidth(){
	    return renderBuffer.getWidth();
	}
	
	public int getHeight(){
	    return renderBuffer.getHeight();
	}
	
	public void display(){
		if(graphComponent.displayRenderBuffer(renderBuffer)){
			window.pack();
			window.setLocationRelativeTo(null);
		}		
		graphComponent.repaint();
	}
	
	public void close(){
		window.setVisible(false);
		window.dispose();
	}
	
	public void addMouseListener(MouseListener listener){
	    graphComponent.addMouseListener(listener);
	}
	
	public void removeMouseListener(MouseListener listener){
	    graphComponent.removeMouseListener(listener);
	}
	
	public void addMouseMotionListener(MouseMotionListener listener){
	    graphComponent.addMouseMotionListener(listener);
	}
	
	public void removeMouseMotionListener(MouseMotionListener listener){
	    graphComponent.removeMouseMotionListener(listener);
	}
	
	public void setPixelSize(int size){
	    graphComponent.setPixelSize(size);
	    display();
	}
}
