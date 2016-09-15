package drawing;

public class V2 {
	double x,y;

	V2(double x,double y){
		this.x=x;
		this.y=y;
	}

	V2 add(V2 v){
		return new V2(x+v.x,y+v.y);
	}

	double length(V2 v){
		return Math.sqrt(x*x+y*y);
	}
	
	double dotProduct(V2 v){
		return x*v.x+y*v.y;
	}
	
	V2 inverse(){
		return new V2(x*1, y*-1);
	}
	
	void angleWithAnotherVector(){
		
	}
	
//	unitVector(){
//		
//	}
//	
//	equal(){
//		
//	}
	
    V2 sub(V2 v){
        return new V2(x-v.x,y-v.y);
    }

      V2 mul(double d){
        return new V2(x*d,y*d);
    }

      V2 div(double d){
        return new V2(x/d,y/d);
    }
}