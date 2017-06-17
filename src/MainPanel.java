
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.Timer;



public class MainPanel extends JPanel{
	GobusInit g;
	Timer timer;
	
	 
	 
	public MainPanel(GobusInit g){
		this.setPreferredSize(new Dimension(766, 415));
		this.g=g;
		
	}
	
	
	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		if(g.GameMode){
			
				
		
			graphics.drawImage(g.BackgroundEp1, 0, 0, null);
			
			
			
			
			
			
			if(g.c.move1 || g.c.stop){
				graphics.drawImage(g.c.getC1Image(), g.c.getX1(), g.c.getY1(), this);
				graphics.drawImage(g.c.getR1Image(),g.c.getX1(),g.c.getY1()+g.c.getH(),g.c.getW(), g.c.alt1-(g.c.getY1()+g.c.getH()), this);
			
			}
			if(g.c.move2){
				graphics.drawImage(g.c.getC1Image(), g.c.getX2(), g.c.getY2(), this);
				graphics.drawImage(g.c.getR1Image(),g.c.getX2(),g.c.getY2()+g.c.getH(),g.c.getW(), g.c.alt2-(g.c.getY2()+g.c.getH()), this);
				
				
			}
			graphics.drawImage(g.Hero.getImage() , g.Hero.getX(), g.Hero.getY() , this);
			for(int i=0;i<g.balllist.size();i++){
				graphics.drawImage(g.balllist.get(i).getImage(), g.balllist.get(i).getX()	,g.balllist.get(i).getY(), this);
				
				
				
			}
			for(int i=0;i<g.speciallist.size();i++){
				if(g.speciallist.get(i) instanceof Single){
					graphics.drawImage(g.Single,g.speciallist.get(i).getX(),g.speciallist.get(i).getY(), this);
				}else if(g.speciallist.get(i) instanceof Double){
					graphics.drawImage(g.Double,g.speciallist.get(i).getX(),g.speciallist.get(i).getY(), this);
				}else if(g.speciallist.get(i) instanceof Fix){
					graphics.drawImage(g.Fix,g.speciallist.get(i).getX(),g.speciallist.get(i).getY(), this);
				}else if(g.speciallist.get(i) instanceof Bomb){
					graphics.drawImage(g.Bomb,g.speciallist.get(i).getX(),g.speciallist.get(i).getY(), this);
				}else if(g.speciallist.get(i) instanceof Hourglass){
					graphics.drawImage(g.Hourglass,g.speciallist.get(i).getX(),g.speciallist.get(i).getY(), this);
				}
			}
			
			for(int i=0;i<g.objelist.size();i++){
				graphics.drawImage(g.Block, g.objelist.get(i).getX(), g.objelist.get(i).getY(), g.objelist.get(i).getW(), g.objelist.get(i).getH(), this);
			
			}
			for(int i=0;i<g.patlakballlist.size();i++){
				graphics.drawImage(g.patlakballlist.get(i).getImage(), g.patlakballlist.get(i).getX()	,g.patlakballlist.get(i).getY(), this);
				
				
			
			}
			
			graphics.setColor(Color.white);
			graphics.setFont(g.font1);
			graphics.drawString("Týme : "+Integer.toString((g.sure-(int)(g.gecensure/1000))), 600, 50);
			graphics.drawImage(g.Border , 0, 0, this);
		}else{
			
			graphics.drawImage( g.Background, 0, 0, null);
		}
			
	}
	
	
}
