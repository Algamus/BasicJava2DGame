import java.awt.Color;
import java.awt.Polygon;
import java.util.LinkedList;


public class SmallBall extends Ball{
	int zýplamaseviyesi=200;
	public SmallBall(int Startx, int Starty, int BaslangýcYonu,int[] s,int zorluk,LinkedList<Obje> o) {
		BorderSýnýr=s;
		objelistesi=o;
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
    	Ball.add(L.Loadimage("images/Small0.PNG", Color.green));
    	Ball.add(L.Loadimage("images/Small1.PNG", Color.green));
    	Ball.add(L.Loadimage("images/Small2.PNG", Color.green));
    	Ball.add(L.Loadimage("images/Small3.PNG", Color.green));
    	Ball.add(L.Loadimage("images/Small4.PNG", Color.green));
    }
	 public Polygon getBounds(){//override
		Polygon p=new Polygon();
		p.addPoint(x+0,y+13);
     	p.addPoint(x+1,y+8);
     	p.addPoint(x+4,y+4);
     	p.addPoint(x+9,y+1);
     	p.addPoint(x+16,y+0);
     	p.addPoint(x+23,y+1);
     	p.addPoint(x+27,y+4);
     	p.addPoint(x+30,y+8);
     	p.addPoint(x+31,y+13);
      	p.addPoint(x+30,y+20);
      	p.addPoint(x+27,y+23);
      	p.addPoint(x+23,y+26);
      	p.addPoint(x+16,y+27);
      	p.addPoint(x+9,y+26);
      	p.addPoint(x+5,y+23);
      	p.addPoint(x+2,y+19);
		return p;
		 
	 }
}
