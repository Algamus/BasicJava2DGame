
import java.awt.Image;
import java.awt.Polygon;
import java.util.LinkedList;

public class Ball {
	ImageLooder L=new ImageLooder();
	LinkedList<Obje> objelistesi;
	LinkedList<Image> Ball=new LinkedList<Image>();
	int patlamazaman�=0;
	
	int width;
	int height;
    
	int Zorluk;
    int x;          
    int y;
    int z�plama;
    boolean goster=true;
    boolean z�plamaustu;
    boolean z�plamaalt�;
    double velocityX=3.5;   
    double velocityY=-(10.0);
    double gravity=0.2;
    
    int BorderS�n�r[];
    public Ball(){
    	
    }
    
    public void setImageS�ze(int w,int h){
    	width=w;
    	height=h;
    }
    public void loadBallImages(){
    	
    }
    public void setZ�plama(){
    	if(z�plama>y){
        	z�plamaustu=true;
        	z�plamaalt�=false;
        }else{
        	z�plamaustu=false;
        	z�plamaalt�=true;
        }
    }
    
    public void moveX(){
    	
    		
    		if (x+width > BorderS�n�r[2]) {
                x = BorderS�n�r[2]-width;   
                velocityX = -velocityX;  
            }
    	
    		
    		if (x < BorderS�n�r[0]) {          
                x = BorderS�n�r[0];            
                velocityX = -velocityX; 
                
            }
    	
    	
    }
    public void moveY(){
    	
    	if(y>z�plama){
        	z�plamaustu=false;
        }
        if (y<z�plama) { 
        	if(z�plamaustu){
        		if(y< BorderS�n�r[1]){
        			y=BorderS�n�r[1];
            		velocityY = 0.0;
        		}
        		//aalt ust chk
        	}else{
        		y=z�plama;
        		velocityY = 0.0;
        	}
        	
        } else if (y+height > BorderS�n�r[3]) { 
            y  =  BorderS�n�r[3]-height;
            if(z�plamaalt�){
            	velocityY=Math.sqrt((2*gravity)*(BorderS�n�r[3]-z�plama));
            	z�plamaalt�=false;
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
							if(z�plamaalt�){
								velocityY=Math.sqrt((2*gravity)*(BorderS�n�r[3]-z�plama));
								z�plamaalt�=false;
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
    	if(patlamazaman�==0 && goster){
    		return Ball.get(0);
    	}else{
    		patlamazaman�--;
    		if(patlamazaman�>15){
    			return Ball.get(1);
    		}else if(patlamazaman�>10){
    			return Ball.get(2);
    		}else if(patlamazaman�>5){
    			return Ball.get(3);
    		}else if(patlamazaman�>0){
    			return Ball.get(4);
    		}else{
    			//remove time
    			goster=false;
    			return null;
    		}
    		
    	}
    }

	

    
}