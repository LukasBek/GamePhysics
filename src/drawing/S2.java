package drawing;

import java.awt.Graphics;

public class S2 {

    V2 O;
    M2 S;
    M2 F;
    M2 T;
    
    S2(double sx,double sy,double ox,double oy){
        O = new V2(ox,oy);
        S = new M2(sx,0,0,sy);
        F = new M2(1,0,0,-1);
        T = S.mul(F);
    }
    
    void drawpoint(Graphics g, V2 v){
       V2 vp= transform(v);
       g.fillOval((int)vp.x, (int)vp.y, 2, 2);       
    }
    
    void drawline(Graphics g,V2 v1,V2 v2){
        V2 vp1 = transform(v1);
        V2 vp2 = transform(v2);
        g.drawLine((int)vp1.x, (int)vp1.y, 
                   (int)vp2.x, (int)vp2.y);
    }
    
    void drawaxis(Graphics g){
        drawline(g,new V2(0,0), new V2(0,1));
        drawline(g,new V2(0,0), new V2(1,0));                
    }

    V2 transform(V2 p){
        return T.mul(p).add(O);
    }
    
//    drawEclipse(){
//    	
//    }
//    
    void drawSquare(Graphics g, V2 A, V2 B, V2 C, V2 D){
    	drawline(g, A, B);
        drawline(g, B, C);
        drawline(g, C, D);
        drawline(g, D, A);
    }
    
    void drawTriangle(Graphics g, V2 A, V2 B, V2 C){
    	drawline(g, A, B);
    	drawline(g, B, C);
        drawline(g, C, A);
    }
//    
//    drawGrid(){
//    	
//    }
//    
//    insertImagi(){
//    	
//    }
}