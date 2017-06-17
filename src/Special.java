import java.awt.Polygon;


public class Special {
	int gerisay�m=0;//10sn ye ayarlancak
	boolean remove=false;
	int x;
	int y;
	int s;
	int width;
	int height;
	double velocityY=0.0;
	double gravity=0.2;
	public Special(){
	
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getW(){
		return width;
	}
	public int getH(){
		return height;
	}
	public void setgerisay�m(){
		if(gerisay�m==0){
			remove=true;
		}else{
			gerisay�m--;
		}
	}
	public void move(int interval) {
	    	
	    	velocityY+=gravity;
	    	
	        
	        y += velocityY;
	        if (y+height > s) { 
	        	y  =  s-height;
	        }
	        if(gerisay�m/1000<5){
				gerisay�m+=interval;
				
			}else{
				remove=true;
			}
	}
	public Polygon getBounds(){
		Polygon p=new Polygon();
		p.addPoint(x,y);
		p.addPoint(x+width, y);
		p.addPoint(x+width, y+height);
		p.addPoint(x, y+height);
		return p;
	}
}
