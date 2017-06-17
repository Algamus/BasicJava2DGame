import java.awt.Polygon;


public class Special {
	int gerisayım=0;//10sn ye ayarlancak
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
	public void setgerisayım(){
		if(gerisayım==0){
			remove=true;
		}else{
			gerisayım--;
		}
	}
	public void move(int interval) {
	    	
	    	velocityY+=gravity;
	    	
	        
	        y += velocityY;
	        if (y+height > s) { 
	        	y  =  s-height;
	        }
	        if(gerisayım/1000<5){
				gerisayım+=interval;
				
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
