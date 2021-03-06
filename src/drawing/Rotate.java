package drawing;
import javax.swing.*;
import java.awt.Graphics;

public class Rotate  extends JFrame {
// Liang listing 14.3

  public Rotate() {
    add(new DrawPanel());
  }

  public static void main(String[] args) {
    Rotate frame = new Rotate();
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
    V2 C=new V2(4,4);
    V2 D=new V2(2,4);
    
    
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      S.drawaxis(g);
      S.drawSquare(g, A, B, C, D);
      rotateSquare(g, A, B, C, D, Math.PI/3);  
          

    }
    
    void rotateSquare(Graphics g, V2 A, V2 B, V2 C, V2 D, double phi){
    	
    	V2 R=A.add(B).add(C).add(D).div(4);
    	M2 M=new M2(Math.cos(phi), -Math.sin(phi),
    				Math.sin(phi),  Math.cos(phi));
    	
    	V2 Am=M.mul(A.sub(R)).add(R);
    	V2 Bm=M.mul(B.sub(R)).add(R);
    	V2 Cm=M.mul(C.sub(R)).add(R);
    	V2 Dm=M.mul(D.sub(R)).add(R);
   	
    	S.drawSquare(g, Am, Bm, Cm, Dm);
    }
  }

}
