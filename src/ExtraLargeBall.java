import java.awt.Color;
import java.awt.Polygon;
import java.util.LinkedList;


public class ExtraLargeBall extends Ball{
	
	
	int zýplamaseviyesi=50;
	public ExtraLargeBall(int Startx, int Starty, int BaslangýcYonu,int[] s,int zorluk,LinkedList<Obje> o) {
		objelistesi=o;
		BorderSýnýr=s;
		Zorluk=zorluk;
		loadBallImages();
		
		setImageSýze(ImageChecker.get(Ball.get(0), 0),ImageChecker.get(Ball.get(0), 1));
        x = Startx;
        y = Starty;
        velocityX = velocityX*Zorluk*BaslangýcYonu;
        gravity = gravity*Zorluk;
        
        zýplama=zýplamaseviyesi;
        setZýplama();
	}
	public void loadBallImages(){
    	Ball.add(L.Loadimage("images/ExtraLarge0.PNG", Color.green));
    	Ball.add(L.Loadimage("images/ExtraLarge1.PNG", Color.green));
    	Ball.add(L.Loadimage("images/ExtraLarge2.PNG", Color.green));
    	Ball.add(L.Loadimage("images/ExtraLarge3.PNG", Color.green));
    	Ball.add(L.Loadimage("images/ExtraLarge4.PNG", Color.green));
    }
	 public Polygon getBounds(){//override
		Polygon p=new Polygon();
		p.addPoint(x+64,y+0);
     	p.addPoint(x+88,y+4);
     	p.addPoint(x+109,y+16);
     	p.addPoint(x+122,y+31);
     	p.addPoint(x+127,y+52);
     	p.addPoint(x+122,y+74);
     	p.addPoint(x+110,y+90);
     	p.addPoint(x+90,y+102);
     	p.addPoint(x+64,y+105);
      	p.addPoint(x+40,y+102);
      	p.addPoint(x+18,y+91);
      	p.addPoint(x+5,y+74);
      	p.addPoint(x+0,y+52);
      	p.addPoint(x+7,y+29);
      	p.addPoint(x+19,y+14);
      	p.addPoint(x+36,y+4);
		return p;
		 
	 }
	
	

}
