package drawing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;

public class geomitry {

	public static void main(String[] args) {
		
		LineComponent lC = new LineComponent(50, 50);
		
			lC.addLine();
		JOptionPane.showMessageDialog(null, lC);
	}

}

class LineComponent extends JComponent {
	
	ArrayList<Line2D.Double> lines;
	Random random;
	
	 LineComponent(int width, int height) {
	        super();
	        setPreferredSize(new Dimension(width,height));
	        lines = new ArrayList<Line2D.Double>();
	        random = new Random();
	    }
	
	  public void addLine() {
	        int width = (int)getPreferredSize().getWidth();
	        int height = (int)getPreferredSize().getHeight();
	        Line2D.Double line = new Line2D.Double(
	        	2,
	        	1,
	        	1000,
	        	1000
	            );
	        lines.add(line);
	        repaint();
	  }
	
	  public void paintComponent(Graphics g) {
	        g.setColor(Color.white);
	        g.fillRect(0, 0, getWidth(), getHeight());
	        Dimension d = getPreferredSize();
	        g.setColor(Color.black);
	        for (Line2D.Double line : lines) {
	            g.drawLine(
	                (int)line.getX1(),
	                (int)line.getY1(),
	                (int)line.getX2(),
	                (int)line.getY2()
	                );
	        }
	    }
}