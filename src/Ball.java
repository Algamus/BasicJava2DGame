
import java.awt.Image;
import java.awt.Polygon;
import java.util.LinkedList;

public class Ball {
	ImageLooder L=new ImageLooder();
	LinkedList<Obje> objelistesi;
	LinkedList<Image> Ball=new LinkedList<Image>();
	int patlamazamaný=0;
	
	int width;
	int height;
    
	int Zorluk;
    int x;          
    int y;
    int zýplama;
    boolean goster=true;
    boolean zýplamaustu;
    boolean zýplamaaltý;
    double velocityX=3.5;   
    double velocityY=-(10.0);
    double gravity=0.2;
    
    int BorderSýnýr[];
    public Ball(){
    	
    }
    
    public void setImageSýze(int w,int h){
    	width=w;
    	height=h;
    }
    public void loadBallImages(){
    	
    }
    public void setZýplama(){
    	if(zýplama>y){
        	zýplamaustu=true;
        	zýplamaaltý=false;
        }else{
        	zýplamaustu=false;
        	zýplamaaltý=true;
        }
    }
    
    public void moveX(){
    	
    		
    		if (x+width > BorderSýnýr[2]) {
                x = BorderSýnýr[2]-width;   
                velocityX = -velocityX;  
            }
    	
    		
    		if (x < BorderSýnýr[0]) {          
                x = BorderSýnýr[0];            
                velocityX = -velocityX; 
                
            }
    	
    	
    }
    public void moveY(){
    	
    	if(y>zýplama){
        	zýplamaustu=false;
        }
        if (y<zýplama) { 
        	if(zýplamaustu){
        		if(y< BorderSýnýr[1]){
        			y=BorderSýnýr[1];
            		velocityY = 0.0;
        		}
        		//aalt ust chk
        	}else{
        		y=zýplama;
        		velocityY = 0.0;
        	}
        	
        } else if (y+height > BorderSýnýr[3]) { 
            y  =  BorderSýnýr[3]-height;
            if(zýplamaaltý){
            	velocityY=Math.sqrt((2*gravity)*(BorderSýnýr[3]-zýplama));
            	zýplamaaltý=false;
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
							if(zýplamaaltý){
								velocityY=Math.sqrt((2*gravity)*(BorderSýnýr[3]-zýplama));
								zýplamaaltý=false;
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
    	if(patlamazamaný==0 && goster){
    		return Ball.get(0);
    	}else{
    		patlamazamaný--;
    		if(patlamazamaný>15){
    			return Ball.get(1);
    		}else if(patlamazamaný>10){
    			return Ball.get(2);
    		}else if(patlamazamaný>5){
    			return Ball.get(3);
    		}else if(patlamazamaný>0){
    			return Ball.get(4);
    		}else{
    			//remove time
    			goster=false;
    			return null;
    		}
    		
    	}
    }

	

    
}