import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Polygon;
import java.util.LinkedList;
import java.util.Random;






public class GobusInit {
	boolean GameMode=false;
	boolean Collusion=false;
	boolean hourglass=false;
	int Episode=0;
	int Score=0000;
	int hourglasssayac=0;
	int Zorluk=2;
	int interval  = 40;
	int sure=90;
	double gecensure=0;
	String sures;
	Font font1 = new Font("TimesRoman", Font.BOLD, 27);
	Font font2 = new Font("TimesRoman", Font.BOLD, 20);
	Random rnd = new Random();
    ImageLooder L=new ImageLooder();
	Image Background;
	Image SubBackground;
	Image BackgroundEp1;
	Image BackgroundEp2;
	Image BackgroundEp3;
	Image BackgroundEp4;
	Image Border;
	Image Block;
	Image Bomb;
	Image Hourglass;
	Image Single;
	Image Double;
	Image Fix;
	
	LinkedList<Ball> patlakballlist=new LinkedList<Ball>();
	LinkedList<Special> speciallist=new LinkedList<Special>();
	
	
	
	int BorderS�n�r[]= { 16 , 15 , 752 , 401 } ;//sol,ust,sag,alt
	int S�n�rSol=16;
	int S�n�rSag=752;
	int S�n�rUst=15;
	int S�n�rAlt=401;
	LinkedList<Ball> balllist=new LinkedList<Ball>();
	Capa c=new Capa();
	LinkedList<Obje> objelist=new LinkedList<Obje>();
	
	int ActorLife=3;
	Actor Hero=new Actor();
	
	public GobusInit(){
		loadImages();
		loadlobi();
		
	}
	public void loadthegame(int g){
		Episode=g;
		Hero.setSActor(BorderS�n�r,objelist);
		c.setSCapa(BorderS�n�r,objelist);
		c.setAmmoType(1);
		sure=90;
		hourglass=false;
		hourglasssayac=0;
		gecensure=0;
		if(Episode==1){
			episode1();
		}else if(Episode==2){
			episode2();
		}else if(Episode==3){
			episode3();
		}else if(Episode==4){
			episode4();
		}else{
			
		}

		GameMode=true;
	}
	public void loadlobi(){
		
		ActorLife=0;
		GameMode=false;
	}	
	
	public void unloadthegame(){
		GameMode=false;
		balllist.removeAll(balllist);
		patlakballlist.removeAll(patlakballlist);
		speciallist.removeAll(speciallist);
		objelist.removeAll(objelist);
		
		
	}
	public void episode1(){
		objelist.add(new Obje(200, 190, 75, 20));
		objelist.add(new Obje(400, 190, 75, 20));
		objelist.add(new Obje(600, 190, 75, 20));
		
		
		balllist.add(new ExtraLargeBall(20,20,1,BorderS�n�r,2,objelist));
		Hero.setActor((BorderS�n�r[2]-BorderS�n�r[0])/2,BorderS�n�r[3]);
	}public void episode2(){
		balllist.add(new ExtraLargeBall(400,45,1,BorderS�n�r,1,objelist));
		Hero.setActor((BorderS�n�r[2]-BorderS�n�r[0])/2,BorderS�n�r[3]);
	}public void episode3(){
		objelist.add(new Obje(100, 75, 20, 200));
		objelist.add(new Obje(200, 190, 200, 20));
		objelist.add(new Obje(600, 75, 20, 200));
		
		balllist.add(new ExtraLargeBall(400,45,-1,BorderS�n�r,2,objelist));
		balllist.add(new ExtraLargeBall(400,45,1,BorderS�n�r,2,objelist));
		Hero.setActor((BorderS�n�r[2]-BorderS�n�r[0])/2,BorderS�n�r[3]);
	}public void episode4(){
		objelist.add(new Obje(100, 75, 50, 50));
		objelist.add(new Obje(200, 190, 50, 50));
		objelist.add(new Obje(600, 75, 50, 50));
		objelist.add(new Obje(300, 75, 50, 50));
		objelist.add(new Obje(400, 190, 50, 50));
		objelist.add(new Obje(500, 75, 50, 50));
		
		balllist.add(new LargeBall(20,45,1,BorderS�n�r,2,objelist));
		balllist.add(new ExtraLargeBall(400,45,-1,BorderS�n�r,2,objelist));
		balllist.add(new ExtraLargeBall(400,45,1,BorderS�n�r,2,objelist));
		Hero.setActor((BorderS�n�r[2]-BorderS�n�r[0])/2,BorderS�n�r[3]);
	}
	public void loadImages(){
		Background=L.Loadimage("images/black.PNG");
		BackgroundEp1=L.Loadimage("images/pic.PNG");
		Border=L.Loadimage("images/border.PNG", Color.white);
		SubBackground=L.Loadimage("images/backgroundsubpanel.PNG");
		Block=L.Loadimage("images/Block.PNG");
		Bomb=L.Loadimage("images/bomb.PNG", Color.white);
		Hourglass=L.Loadimage("images/hourglass.PNG", Color.white);
		Single=L.Loadimage("images/single.PNG", Color.white);
		Double=L.Loadimage("images/double.PNG", Color.white);
		Fix=L.Loadimage("images/fixed.PNG", Color.white);
	}
	
	public void bomb(){//dynamite *bom ayn� sey
		int i=0;
		while(i<balllist.size()){
			if(balllist.get(i) instanceof ExtraLargeBall){
				
				balllist.add(new LargeBall(balllist.get(i).getX()-32,balllist.get(i).getY()+13,-1,BorderS�n�r,2,objelist));//dwm
				
				balllist.add(new LargeBall(balllist.get(i).getX()+64,balllist.get(i).getY()+13,1,BorderS�n�r,2,objelist));//dwm
			}else if(balllist.get(i) instanceof LargeBall){
				
				balllist.add(new MediumBall(balllist.get(i).getX()-16,balllist.get(i).getY()+13,-1,BorderS�n�r,2,objelist));//dwm
				
				balllist.add(new MediumBall(balllist.get(i).getX()+48,balllist.get(i).getY()+13,1,BorderS�n�r,2,objelist));//dwm
			}else if(balllist.get(i) instanceof MediumBall){
				
				balllist.add(new SmallBall(balllist.get(i).getX(),balllist.get(i).getY()+12,-1,BorderS�n�r,2,objelist));//dwm
				
				balllist.add(new SmallBall(balllist.get(i).getX()+32,balllist.get(i).getY()+12,1,BorderS�n�r,2,objelist));//dwm
			}
			if(!(balllist.get(i) instanceof SmallBall)){
				balllist.get(i).patlamazaman�=20;
				patlakballlist.add(balllist.get(i));
				balllist.remove(balllist.get(i));
			}
			
			if(i<balllist.size()){
				if(balllist.get(i) instanceof SmallBall ){
					i++;
				}
			}
			
		}
	}
	public void createSpecial(Ball b){
		int generator=rnd.nextInt(11);
		if(generator==10){
			speciallist.add(new Single(b.getX()-32,b.getY()+13,BorderS�n�r[3]));
		}else if(generator==8){
			speciallist.add(new Double(b.getX()-32,b.getY()+13,BorderS�n�r[3]));
		}else if(generator==6){
			speciallist.add(new Fix(b.getX()-32,b.getY()+13,BorderS�n�r[3]));
		}else if(generator==4){
			speciallist.add(new Bomb(b.getX()-32,b.getY()+13,BorderS�n�r[3]));
		}else if(generator==2){
			speciallist.add(new Hourglass(b.getX()-32,b.getY()+13,BorderS�n�r[3]));
		}else{
			
		}
		
	}
	public void ballpatlatma(Ball b){//s�n�r d�s�patlamaya gerekkalmad� gibi
		if(b instanceof ExtraLargeBall){
			
			balllist.add(new LargeBall(b.getX()-32,b.getY()+13,-1,BorderS�n�r,b.Zorluk,objelist));//dwm
			balllist.add(new LargeBall(b.getX()+64,b.getY()+13,1,BorderS�n�r,b.Zorluk,objelist));//dwm
			Score+=100;
		}else if(b instanceof LargeBall){
			balllist.add(new MediumBall(b.getX()-16,b.getY()+13,-1,BorderS�n�r,b.Zorluk,objelist));//dwm
			balllist.add(new MediumBall(b.getX()+48,b.getY()+13,1,BorderS�n�r,b.Zorluk,objelist));//dwm
			Score+=200;
		}else if(b instanceof MediumBall){
			balllist.add(new SmallBall(b.getX(),b.getY()+12,-1,BorderS�n�r,b.Zorluk,objelist));//dwm
			balllist.add(new SmallBall(b.getX()+32,b.getY()+12,1,BorderS�n�r,b.Zorluk,objelist));//dwm
			Score+=400;
		}else{
			Score+=700;
			//small
		}
		createSpecial(b);
		b.patlamazaman�=20;
		patlakballlist.add(b);
		balllist.remove(b);
	}
	public void setZorluk(int x){
		Zorluk=x;
	}
	public void starthourglass(){
		hourglass=true;
	}
	public void hourglass(){
		
		if(hourglasssayac/1000<10){
			hourglasssayac+=interval;
		}else{
			hourglass=false;
			hourglasssayac=0;
		}
		
	}
	 
	public  boolean DoesPolygonIntersectPolygon(Polygon p1,Polygon p2)//her resmin yapay polygonlar� haz�rlancak
    {	
        Point p;
        for(int i = 0; i < p2.npoints;i++)
        {
            p = new Point(p2.xpoints[i],p2.ypoints[i]);
            if(p1.contains(p))
                return true;
        }
        for(int i = 0; i < p1.npoints;i++)
        {
            p = new Point(p1.xpoints[i],p1.ypoints[i]);
            if(p2.contains(p))
                return true;
        }
        return false;
    }
	
	
	
	
}
	