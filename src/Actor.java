import java.awt.Color;
import java.awt.Image;
import java.awt.Polygon;
import java.util.LinkedList;




public class Actor {
	ImageLooder L=new ImageLooder();
	LinkedList<Obje> objelistesi;

	LinkedList<Image> ActorR=new LinkedList<Image>();
	LinkedList<Image> ActorL=new LinkedList<Image>();

	
	Image life;
	
	int[] width;
	int[] height;
    
	int[] BorderSýnýr;

    int x=0;          
    int y=0;
    int sayacfire=0;
    int changerate=0;
    boolean look=true;//true sag false sol
    
    boolean fire=false;
    boolean move=false;
    boolean sol=false;
    boolean sag=false;
   
    int yon=0;//sol-1sag+1 yoksa 0
    public Actor(){
    	loadActorImages();
    	setImagesSýzes();
    }
    public void setSActor(int s[],LinkedList<Obje> o){
 
    	objelistesi=o;
    	BorderSýnýr=s;
  
    }
    public void setActor(int Startx, int Starty){
    	x = Startx;
        y = Starty-height[0];
    }
    public Polygon getBounds(){
    	Polygon p=new Polygon();
    	
    	if(sayacfire>0){
    		if(sayacfire>3){
    			if(look){
    				p.addPoint(x+4,y+63);
    		    	p.addPoint(x+4,y+11);
    		    	p.addPoint(x+15,y+0);
    		    	p.addPoint(x+37,y+0);
    		    	p.addPoint(x+44,y+8);
    		    	p.addPoint(x+49,y+30);
    		    	p.addPoint(x+55,y+63);
    			}else{
    				p.addPoint(x+8,y+63);
    		    	p.addPoint(x+14,y+30);
    		    	p.addPoint(x+19,y+7);
    		    	p.addPoint(x+25,y+3);
    		    	p.addPoint(x+49,y+3);
    		    	p.addPoint(x+60,y+13);
    		    	p.addPoint(x+60,y+63);
    			}
    			return p;
    		}else{
    			if(look){
    				p.addPoint(x+9,y+8);
    		    	p.addPoint(x+40,y+8);
    		    	p.addPoint(x+40,y+34);
    		    	p.addPoint(x+55,y+63);
    		    	p.addPoint(x+0,y+63);
    		    	p.addPoint(x+0,y+18);
    			}else{
    				p.addPoint(x+8,y+63);
    		    	p.addPoint(x+23,y+34);
    		    	p.addPoint(x+23,y+10);
    		    	p.addPoint(x+63,y+10);
    		    	p.addPoint(x+63,y+63);
    			}
    			return p;
    		}
    	}
    	if(look){
    		p.addPoint(x+14,y+0);
        	p.addPoint(x+36,y+0);
        	p.addPoint(x+63,y+16);
        	p.addPoint(x+63,y+37);
        	p.addPoint(x+49,y+37);
        	p.addPoint(x+49,y+63);
        	p.addPoint(x+3,y+63);
        	p.addPoint(x+3,y+12);
        	
    	}else{
    		p.addPoint(x+0,y+15);
        	p.addPoint(x+28,y+0);
        	p.addPoint(x+50,y+0);
        	p.addPoint(x+59,y+12);
        	p.addPoint(x+59,y+63);
        	p.addPoint(x+21,y+63);
        	p.addPoint(x+21,y+42);
        	p.addPoint(x+0,y+42);
    	}
		return p;
    	
    }
  /*  public void getPolygons(){
    	
    	//add mover
    	p1.addPoint(x+14,y+0);
    	p1.addPoint(x+36,y+0);
    	p1.addPoint(x+63,y+16);
    	p1.addPoint(x+63,y+37);
    	p1.addPoint(x+49,y+37);
    	p1.addPoint(x+49,y+63);
    	p1.addPoint(x+3,y+63);
    	p1.addPoint(x+3,y+12);
    	ActorRP.add(p1);
    	//addfirer
    
    	p2.addPoint(4,63);
    	p2.addPoint(4,11);
    	p2.addPoint(15,0);
    	p2.addPoint(37,0);
    	p2.addPoint(44,8);
    	p2.addPoint(49,30);
    	p2.addPoint(55,63);
    	ActorRP.add(p2);
    	//addfireandholer
    
    	p3.addPoint(9,8);
    	p3.addPoint(40,8);
    	p3.addPoint(40,34);
    	p3.addPoint(55,63);
    	p3.addPoint(0,63);
    	p3.addPoint(0,18);
    	ActorRP.add(p3);
    	//addmovel
    
    	p4.addPoint(0,15);
    	p4.addPoint(28,0);
    	p4.addPoint(50,0);
    	p4.addPoint(59,12);
    	p4.addPoint(59,63);
    	p4.addPoint(21,63);
    	p4.addPoint(21,42);
    	p4.addPoint(0,42);
    	ActorLP.add(p4);
    	//addfirel
  
    	p5.addPoint(8,63);
    	p5.addPoint(14,30);
    	p5.addPoint(19,7);
    	p5.addPoint(25,3);
    	p5.addPoint(49,3);
    	p5.addPoint(60,13);
    	p5.addPoint(60,63);
    	ActorLP.add(p5);
    	//addfireandholel
  
    	p6.addPoint(8,63);
    	p6.addPoint(23,34);
    	p6.addPoint(23,10);
    	p6.addPoint(63,10);
    	p6.addPoint(63,63);
    	ActorLP.add(p6);
    	
    }*/
    public void loadActorImages(){
    	ActorR.add(L.Loadimage("images/Actormove0.PNG", Color.green));//0
    	ActorR.add(L.Loadimage("images/Actormove1.PNG", Color.green));//1
    	ActorR.add(L.Loadimage("images/Actormove2.PNG", Color.green));//2
    	ActorR.add(L.Loadimage("images/Actormove3.PNG", Color.green));//3
    	ActorR.add(L.Loadimage("images/Actormove4.PNG", Color.green));//4
    	ActorR.add(L.Loadimage("images/ActorfireR.PNG", Color.green));//5
    	ActorR.add(L.Loadimage("images/ActorfireintheholeR.PNG", Color.green));//6
    	ActorR.add(L.Loadimage("images/Actorfallright.PNG", Color.green));//7
    	
    	ActorL.add(L.Loadimage("images/Actormove-0.PNG", Color.green));//0
    	ActorL.add(L.Loadimage("images/Actormove-1.PNG", Color.green));//1
    	ActorL.add(L.Loadimage("images/Actormove-2.PNG", Color.green));//2
    	ActorL.add(L.Loadimage("images/Actormove-3.PNG", Color.green));//3
    	ActorL.add(L.Loadimage("images/Actormove-4.PNG", Color.green));//4
    	ActorL.add(L.Loadimage("images/ActorfireL.PNG", Color.green));//5
    	ActorL.add(L.Loadimage("images/ActorfireintheholeL.PNG", Color.green));//6
    	ActorL.add(L.Loadimage("images/Actorfallleft.PNG", Color.green));//7
    	
    	life=L.Loadimage("images/Actorlifeicon.PNG", Color.green);
    	
    }
    public void setImagesSýzes(){
    	width=new int[ActorR.size()+ActorL.size()];
    	height=new int[ActorR.size()+ActorL.size()];
    	for(int i=0;i<ActorR.size()+ActorL.size();i++){
    		if(i<ActorR.size()){
    			width[i]=ImageChecker.get(ActorR.get(i),0);
            	height[i]=ImageChecker.get(ActorR.get(i),1);
    		}else{
    			width[i]=ImageChecker.get(ActorL.get(i-ActorR.size()),0);
    			height[i]=ImageChecker.get(ActorL.get(i-ActorR.size()),1);
    		}
    	}
    }
    public boolean isActorAlowed(int i,boolean LR){//left true right false  
    	if(LR){//sol check
    		for(int t=0;t<objelistesi.size();t++){
    			if((objelistesi.get(t).getY()<y&&objelistesi.get(t).getY()+objelistesi.get(t).getH()>y)||(objelistesi.get(t).getY()>y&&objelistesi.get(t).getY()<y+height[(look?changerate/2:(changerate/2)+ActorR.size())])){
    				if(objelistesi.get(t).getX()+objelistesi.get(t).getW()>i&&objelistesi.get(t).getX()<i){
    				x=objelistesi.get(t).getX()+objelistesi.get(t).getW();
    				return false;
    			}
    			}
    		}
    		if(i<BorderSýnýr[0]){
    			x=BorderSýnýr[0];
    			return false;
    		}
   
    	}else{//sag check
    		for(int t=0;t<objelistesi.size();t++){
    			if((objelistesi.get(t).getY()<y&&objelistesi.get(t).getY()+objelistesi.get(t).getH()>y)||(objelistesi.get(t).getY()>y&&objelistesi.get(t).getY()<y+height[(look?changerate/2:(changerate/2)+ActorR.size())])){
    				if(objelistesi.get(t).getX()<(i+width[(look?changerate/2:(changerate/2)+ActorR.size())])&&objelistesi.get(t).getX()+objelistesi.get(t).getW()>i+width[(look?changerate/2:(changerate/2)+ActorR.size())]){
    				x=objelistesi.get(t).getX()-width[(look?changerate/2:(changerate/2)+ActorR.size())];
    				return false;
    			}
    			}
    		}
    		if(i>BorderSýnýr[2]-width[(look?changerate/2:(changerate/2)+ActorR.size())]){
    			x=BorderSýnýr[2]-width[(look?changerate/2:(changerate/2)+ActorR.size())];
    			return false;
    		}
    	}
    	return true;
   
	}
    
    public void moves(){
    	if(fire){
    		fire=false;
    		sayacfire=7;
    	}else if(sayacfire>0 && !fire){
    		//es gecme
    		
    	}else{
    		
    		if(sag&&sol){
    			changerate=0;
    		}else if(sag){
    			setActorRight();
    		}else if(sol){
    			setActorLeft();
    		}else{
    			changerate=0;
    		}
    	}
    }
    
    public void setYon(int x){
    	yon=x;
    }
    public void ctrChangeRate(){
    	changerate=(changerate>8)?0:changerate;
    }
    public void setActorLeft(){
 
    	
    		if(isActorAlowed(x-1,true)){
    			look=false;
    			
					changerate++;
					ctrChangeRate();
	    			x-=width[(look?changerate/2:(changerate/2)+ActorR.size())]/5;
	    		
    		}
    	
    		
    	
		
	}
	public void setActorRight(){
		
		
			if(isActorAlowed(x+1,false)){
				look=true;
				
					changerate++;
					ctrChangeRate();
	    			x+=width[(look?changerate/2:(changerate/2)+ActorR.size())]/5;
	    	
    			
    		}
		
    		
    	
    		
	}
	public Image getImage(){
		if(sayacfire>0){
			sayacfire--;
			return ((sayacfire>3)?((look)?((ActorR.get(5))):(ActorL.get(5))):((look)?((ActorR.get(6))):(ActorL.get(6))));
		}else{
		ctrChangeRate();
		return ((look)?(ActorR.get(changerate/2)):(ActorL.get(changerate/2)));
		}
	}	
	public int getH(){
		return height[(look?changerate/2:(changerate/2)+ActorR.size())];
	}
	public int getW(){
		return width[(look?changerate/2:(changerate/2)+ActorR.size())];
	}
	
	
    public int getX(){
    	
    	return x;
    }
    public int getY(){
    	
    	return y;
    }
    
}
