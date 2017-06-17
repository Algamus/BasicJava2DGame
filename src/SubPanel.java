
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;


public class SubPanel extends JPanel{
	GobusInit g;
	public SubPanel(GobusInit g){
		this.setPreferredSize(new Dimension(766, 100));
		this.g=g;
	}
	@Override//
	
	protected void paintComponent(Graphics graphics) {
		graphics.setColor(Color.white);
		
		graphics.drawImage(g.SubBackground, 0, 0, null);
		 if(g.GameMode){
			 if(g.c.AmmoType==1){
				 graphics.drawImage(g.Single, 700,50, this);
			 }else if(g.c.AmmoType==2){
				 graphics.drawImage(g.Double, 700,50, this);
			 }else if(g.c.AmmoType==3){
				 graphics.drawImage(g.Fix, 700,50, this);
			 }else{
				 
			}
			for(int i=0;i<=g.ActorLife;i++){
				if(i<g.ActorLife){
					 graphics.drawImage(g.Hero.life, 0+16*i,5, this);
				}else{
					graphics.setFont(g.font2);
					graphics.drawString(Integer.toString(g.ActorLife), 0+16*i, 20);
				}
				
				
			}
			graphics.setFont(g.font1);
			graphics.drawString("Score : "+Integer.toString(g.Score), 0, 50);
		 }
		
	}
}
