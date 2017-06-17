import java.awt.Color;
import java.awt.Image;
import java.awt.Polygon;
import java.util.LinkedList;


public class Capa {
	ImageLooder L=new ImageLooder();
	Image capa;
	Image rope;
	Image ropefix;
	int Ammo=0;
	int AmmoType=0;//0 hic 1 single 2 double 3 fix
	LinkedList<Obje> objelistesi;
	int w;
	int h;
	int width;
	int height;
	boolean move1=false;
	boolean stop=false;
	boolean move2=false;
	boolean fixstop=false;
	int x1=0;
	int y1=0;
	int x2=0;
	int y2=0;
	int alt1=0;
	int alt2=0;
	
    
	int BorderSýnýr[];

    
    double velocityY=8.5;
    public Capa(){
    	loadCapaImages();
    	setImageSýze(ImageChecker.get(getC1Image(),0),ImageChecker.get(getC1Image(),1));
    }
    public void setSCapa(int[] s,LinkedList<Obje> o){
    	objelistesi=o;
    	BorderSýnýr=s;
    	
    	
    }
    public void fire(int Startx, int Starty,int t){
    	if(AmmoType==2){
    		if(!move1){
    			x1=Startx;
        		y1=Starty;
        		alt1=t;
        		move1=true;
    		}else if(!move2){
    			x2=Startx;
        		y2=Starty;
        		alt2=t;
        		move2=true;
    		}else{
    			
    		}
    	}else{
    		x1=Startx;
    		y1=Starty;
    		alt1=t;
    		move1=true;
    		
    	}
		Ammo--;
		
	}
    public boolean isCapaAllowed(int i,int g){//g hangi capa 1-1 2-2
    	for(int t=0;t<objelistesi.size();t++){
    		
    		if((objelistesi.get(t).getX()>=g&&objelistesi.get(t).getX()+objelistesi.get(t).getW()<=g+width)||(objelistesi.get(t).getX()<=g&&objelistesi.get(t).getX()+objelistesi.get(t).getW()>=g+width)||((g<=objelistesi.get(t).getX()&&g+width>objelistesi.get(t).getX())||(g<objelistesi.get(t).getX()+objelistesi.get(t).getW()&&g+width>=objelistesi.get(t).getX()+objelistesi.get(t).getW()))){
    			
        		if(objelistesi.get(t).getY()+objelistesi.get(t).getH()>i&&objelistesi.get(t).getY()<i){
        				objelistesi.remove(t);
        				fixstop=true;
        				return false;
        			}
        		}
    		
    		
    	}
    	if(i<BorderSýnýr[1]){
    		return false;
    	}
    	return true;
    	
    	
    }
    
    public void move() {
    	
    	if(move1){
    		if(isCapaAllowed(y1-1,x1)){
    			y1-=velocityY;
    			
    		}else{
    			if(AmmoType==3){
    				if(fixstop){
    					fixstop=false;
    					move1=false;
            			Ammo++;
    				}else{
    					stop=true;
    					move1=false;
    				}
    			}else{
    				move1=false;
        			Ammo++;
    			}
    			
    		}
    			
    	}
    	if(move2){
    		if(isCapaAllowed(y2-1,x2)){
    			y2-=velocityY;
    			
    		}else{
    			move2=false;
    			Ammo++;
    		}
    	}
    	
    }
    public void setAmmoType(int x){
		// 1 single 2double 3 fix
		if(x==1){
			Ammo=1;
			AmmoType=1;
		}else if(x==2){
			Ammo=2;
			AmmoType=2;
		}else if(x==3){
			Ammo=1;
			AmmoType=3;
		}else{
			
		}
	}
	public boolean fireIsAllowed(){
		if(Ammo>0){
			return true;
		}else{
			return false;
		}
	}
    public void loadCapaImages(){
    	capa=L.Loadimage("images/c1.PNG", Color.white);
    	rope=L.Loadimage("images/r1.PNG", Color.white);
    	ropefix=L.Loadimage("images/rx.PNG", Color.white);
    }
    public void setImageSýze(int w,int h){
    	width=w;
    	height=h;
    }
    public int getH(){
    	return height;
    }
    public int getW(){
    	return width;
    }
    
    public int getX1(){
    	
    	return x1;
    }
    public int getY1(){
    	
    	return y1;
    }
    public int getX2(){
    	
    	return x2;
    }
    public int getY2(){
    	
    	return y2;
    }
    public Polygon getBoundsCapa(int x){//x =1 ise xy1 2ise xy2 yu gonder
    	Polygon p=new Polygon();
    	if(x==1){//only xy1 den fix cýkýyor
    		if(stop){
    			p.addPoint(x1,y1);
         		p.addPoint(x1+width,y1);
         		p.addPoint(x1+width,y1+height);
         		p.addPoint(x1+width-6,y1+height);
         		p.addPoint(x1+width-6,alt1);
         		p.addPoint(x1+6,alt1);
         		p.addPoint(x1+width-6,alt1);
         		p.addPoint(x1+6,y1+height);
         		p.addPoint(x1,y1+height);
         		return p;
    		}else{
    			p.addPoint(x1,y1);
             	p.addPoint(x1+width,y1);
             	p.addPoint(x1+width,alt1);
             	p.addPoint(x1,alt1);
         		return p;
    		}
    	}else{
    		p.addPoint(x2,y2);
         	p.addPoint(x2+width,y2);
         	p.addPoint(x2+width,alt2);
         	p.addPoint(x2,alt2);
    		return p;
    	}
    	
    }
   
    public Image getC1Image(){
    	return capa;
    }
    public Image getR1Image(){
    	if(AmmoType==3 && stop){
    		return ropefix;
    	}
    	return rope;
    }
}
