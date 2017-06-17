import java.awt.Color;
import java.awt.Polygon;
import java.util.LinkedList;


public class LargeBall extends Ball{
	int zýplamaseviyesi=100;
	public LargeBall(int Startx, int Starty, int BaslangýcYonu,int[] s,int zorluk,LinkedList<Obje> o) {
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
    	Ball.add(L.Loadimage("images/Large0.PNG", Color.green));
    	Ball.add(L.Loadimage("images/Large1.PNG", Color.green));
    	Ball.add(L.Loadimage("images/Large2.PNG", Color.green));
    	Ball.add(L.Loadimage("images/Large3.PNG", Color.green));
    	Ball.add(L.Loadimage("images/Large4.PNG", Color.green));
    }
	 public Polygon getBounds(){//override
		Polygon p=new Polygon();
		p.addPoint(x+0,y+40);
     	p.addPoint(x+5,y+23);
     	p.addPoint(x+13,y+12);
     	p.addPoint(x+29,y+3);
     	p.addPoint(x+48,y+0);
     	p.addPoint(x+78,y+8);
     	p.addPoint(x+90,y+22);
     	p.addPoint(x+95,y+40);
     	p.addPoint(x+91,y+56);
      	p.addPoint(x+82,y+67);
      	p.addPoint(x+68,y+76);
      	p.addPoint(x+48,y+79);
      	p.addPoint(x+20,y+72);
      	p.addPoint(x+6,y+60);
		return p;
		 
	 }
}
