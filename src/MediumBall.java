import java.awt.Color;
import java.awt.Polygon;
import java.util.LinkedList;


public class MediumBall extends Ball{
	int z�plamaseviyesi=150;
	public MediumBall(int Startx, int Starty, int Baslang�cYonu,int[] s,int zorluk,LinkedList<Obje> o) {
		BorderS�n�r=s;
		objelistesi=o;
		Zorluk=zorluk;
		loadBallImages();
		
		setImageS�ze(ImageChecker.get(Ball.get(0), 0),ImageChecker.get(Ball.get(0), 1));
        x = Startx;
        y = Starty;
        velocityX = velocityX*Zorluk*Baslang�cYonu;
        gravity = gravity*Zorluk;
        
        z�plama=z�plamaseviyesi;
        setZ�plama();
	}
	public void loadBallImages(){
    	Ball.add(L.Loadimage("images/Medium0.PNG", Color.green));
    	Ball.add(L.Loadimage("images/Medium1.PNG", Color.green));
    	Ball.add(L.Loadimage("images/Medium2.PNG", Color.green));
    	Ball.add(L.Loadimage("images/Medium3.PNG", Color.green));
    	Ball.add(L.Loadimage("images/Medium4.PNG", Color.green));
    }
	 public Polygon getBounds(){//override
		Polygon p=new Polygon();
		p.addPoint(x+0,y+26);
     	p.addPoint(x+3,y+16);
     	p.addPoint(x+8,y+7);
     	p.addPoint(x+19,y+2);
     	p.addPoint(x+31,y+0);
     	p.addPoint(x+45,y+2);
     	p.addPoint(x+55,y+8);
     	p.addPoint(x+61,y+16);
     	p.addPoint(x+63,y+26);
      	p.addPoint(x+61,y+37);
      	p.addPoint(x+55,y+45);
      	p.addPoint(x+44,y+50);
      	p.addPoint(x+31,y+52);
      	p.addPoint(x+16,y+49);
      	p.addPoint(x+7,y+44);
      	p.addPoint(x+3,y+36);
		return p;
		 
	 }
}
