
import java.awt.Image;
import java.awt.Polygon;
import java.util.LinkedList;

public class Ball {
	ImageLooder L=new ImageLooder();
	LinkedList<Obje> objelistesi;
	LinkedList<Image> Ball=new LinkedList<Image>();
	int patlamazamanı=0;
	
	int width;
	int height;
    
	int Zorluk;
    int x;          
    int y;
    int zıplama;
    boolean goster=true;
    boolean zıplamaustu;
    boolean zıplamaaltı;
    double velocityX=3.5;   
    double velocityY=-(10.0);
    double gravity=0.2;
    
    int BorderSınır[];
    public Ball(){
    	
    }
    
    public void setImageSıze(int w,int h){
    	width=w;
    	height=h;
    }
    public void loadBallImages(){
    	
    }
    public void setZıplama(){
    	if(zıplama>y){
        	zıplamaustu=true;
        	zıplamaaltı=false;
        }else{
        	zıplamaustu=false;
        	zıplamaaltı=true;
        }
    }
    
    public void moveX(){
    	
    		
    		if (x+width > BorderSınır[2]) {
                x = BorderSınır[2]-width;   
                velocityX = -velocityX;  
            }
    	
    		
    		if (x < BorderSınır[0]) {          
                x = BorderSınır[0];            
                velocityX = -velocityX; 
                
            }
    	
    	
    }
    public void moveY(){
    	
    	if(y>zıplama){
        	zıplamaustu=false;
        }
        if (y<zıplama) { 
        	if(zıplamaustu){
        		if(y< BorderSınır[1]){
        			y=BorderSınır[1];
            		velocityY = 0.0;
        		}
        		//aalt ust chk
        	}else{
        		y=zıplama;
        		velocityY = 0.0;
        	}
        	
        } else if (y+height > BorderSınır[3]) { 
            y  =  BorderSınır[3]-height;
            if(zıplamaaltı){
            	velocityY=Math.sqrt((2*gravity)*(BorderSınır[3]-zıplama));
            	zıplamaaltı=false;
            }
            velocityY = -velocityY;
            
        }
        
    }
    public void move() {
    	
    	velocityY+=gravity;
    	
        x += velocityX;
        y += velocityY;     
        
       moveX();
       
       moveY();
       for(int t=0;t<objelistesi.size();t++){
			if((objelistesi.get(t).getX()>=x&&objelistesi.get(t).getX()+objelistesi.get(t).getW()<=x+width)||(objelistesi.get(t).getX()<=x&&objelistesi.get(t).getX()+objelistesi.get(t).getW()>=x+width)){
				if(objelistesi.get(t).getY()<(y+height)&&objelistesi.get(t).getY()>y){
					if(velocityY>=0){
							y=objelistesi.get(t).getY()-height;//top a b y
							if(zıplamaaltı){
								velocityY=Math.sqrt((2*gravity)*(BorderSınır[3]-zıplama));
								zıplamaaltı=false;
							}
							velocityY = -velocityY;  
					}
				}
				if(objelistesi.get(t).getY()+objelistesi.get(t).getH()>y&&objelistesi.get(t).getY()<y){//top y ba
					y=objelistesi.get(t).getY()+objelistesi.get(t).getH();
					velocityY = -velocityY;
					}
			}
			
			
			if((objelistesi.get(t).getY()<=y&&objelistesi.get(t).getY()+objelistesi.get(t).getH()>=y+height)||(objelistesi.get(t).getY()>=y&&objelistesi.get(t).getY()+objelistesi.get(t).getH()<=y+height)){
				if(objelistesi.get(t).getX()+objelistesi.get(t).getW()>x&&objelistesi.get(t).getX()<x){
				
						x=objelistesi.get(t).getX()+objelistesi.get(t).getW();
						velocityX = -velocityX;  //topsol osag
					
				}
				if(objelistesi.get(t).getX()<x+width&&objelistesi.get(t).getX()>x){
					
						x=objelistesi.get(t).getX()-width;
						velocityX = -velocityX;//topsag osol
					
					
				}
			}
			
		}
    }
    public int getH(){
    	return height;
    }
    public int getW(){
    	return width;
    }
    
    public int getX(){
    	
    	return x;
    }
    public int getY(){
    	
    	return y;
    }
    public Polygon getBounds(){
    	Polygon p=new Polygon();
		return p;
    	
    }
    public Image getImage(){
    	if(patlamazamanı==0 && goster){
    		return Ball.get(0);
    	}else{
    		patlamazamanı--;
    		if(patlamazamanı>15){
    			return Ball.get(1);
    		}else if(patlamazamanı>10){
    			return Ball.get(2);
    		}else if(patlamazamanı>5){
    			return Ball.get(3);
    		}else if(patlamazamanı>0){
    			return Ball.get(4);
    		}else{
    			//remove time
    			goster=false;
    			return null;
    		}
    		
    	}
    }

	

    
}