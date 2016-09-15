package drawing;
import javax.swing.*;
import java.awt.Graphics;

public class Reflection  extends JFrame {
// Liang listing 14.3

  public Reflection() {
    add(new DrawPanel());
  }

  public static void main(String[] args) {
    Reflection frame = new Reflection();
    frame.setTitle("RotateSquare");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1000, 700);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }

  class DrawPanel extends JPanel {
    S2 S = new S2(50,50,200,400);
    V2 A=new V2(2,2);
    V2 B=new V2(4,2);
    V2 C=new V2(3,4);

    
    
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      S.drawaxis(g);        
      S.drawTriangle(g, A, B, C);
      
      V2 y = new V2(0, 0);
      reflectTriangle(g, A, B, C, y);
      
      V2 y2 = new V2(0, 3);
      reflectTriangle(g, A, B, C, y2); 
      
      
      
    }
    
    void reflectTriangle(Graphics g, V2 A, V2 B, V2 C, V2 y){
    	
    	V2 Am = A.sub(y).inverse().add(y);
    	V2 Bm = B.sub(y).inverse().add(y);
    	V2 Cm = C.sub(y).inverse().add(y);
    	
    	S.drawTriangle(g, Am, Bm, Cm);
    	
    }
  }

}
