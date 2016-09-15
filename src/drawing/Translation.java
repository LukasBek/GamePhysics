package drawing;
import javax.swing.*;
import java.awt.Graphics;

public class Translation  extends JFrame {
	// Liang listing 14.3

	public Translation() {
		add(new DrawPanel());
	}

	public static void main(String[] args) {
		Translation frame = new Translation();
		frame.setTitle("Translate Triangle");
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

			//The vektor to translate the triangle with
			V2 V = new V2(-1, 1);
			translateTriangle(g, A, B, C, V);


		}

		void translateTriangle(Graphics g, V2 A, V2 B, V2 C, V2 V){

			V2 Am = A.add(V);
			V2 Bm = B.add(V);
			V2 Cm = C.add(V);

			S.drawTriangle(g, Am, Bm, Cm);
		}
	}

}
