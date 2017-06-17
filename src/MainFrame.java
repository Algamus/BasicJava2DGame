

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.Timer;











public class MainFrame extends JFrame implements ActionListener,KeyListener{
	
	GobusInit g= new GobusInit();
	MainPanel mainpanel = new MainPanel(g);
	SubPanel subpanel = new SubPanel(g);
	Menubar menu = new Menubar();
	BorderLayout layout = new BorderLayout();
	Timer timer;
	
	CollisonDetectionBallvsActor collisondetectionballvsactor;
	CollisonDetectionBallvsC	collisondetectionballvsc;
	CollisonDetectionSvsA	collisondetectionsvsa;
	public MainFrame(){
		super("Pang Arcade");
		setLayout( layout);
		setJMenuBar(menu.menubar);
		addlisteners();
		add(mainpanel,BorderLayout.CENTER);
		add(subpanel,BorderLayout.SOUTH);
		CreateGui();
		timer= new Timer(g.interval, new TimerAction());//java.swing.timer içinde
		
	}
	public void CreateGui(){
		
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setSize( 766, 600);
		setResizable(false);
		pack();
        setVisible( true );
	}
	public void addlisteners(){
		menu.cikis.addActionListener(this);
		menu.yeni.addActionListener(this);
		menu.kayitli.addActionListener(this);
		menu.novice.addActionListener(this);
		menu.intermediate.addActionListener(this);
		menu.advanced.addActionListener(this);
		menu.about.addActionListener(this);
		addKeyListener(this);
	}
	public void loadthegame(int x){
		g.loadthegame(x);
		setAnimation(true);
		
	}
	public void loadlobi(){
		setAnimation(false);
		g.unloadthegame();
		g.loadlobi();
		
	}
	public void restart(){
		setAnimation(false);
		g.unloadthegame();
		g.loadthegame(g.Episode);
		setAnimation(true);
		
		
	}
	public void nextthegame(){
		setAnimation(false);
		g.unloadthegame();
		if(g.Episode>4){
			loadlobi();
		}else{
			g.Episode++;
			g.loadthegame(g.Episode);
			setAnimation(true);
		}
	}
	public void setAnimation(boolean turnOnOff) {
        if (turnOnOff) {
            timer.start();
            ( collisondetectionballvsc= new CollisonDetectionBallvsC()).execute();
            ( collisondetectionsvsa= new CollisonDetectionSvsA()).execute();
            ( collisondetectionballvsactor= new CollisonDetectionBallvsActor()).execute();
        } else {
            timer.stop();
            collisondetectionballvsc.cancel(true);
            collisondetectionballvsactor.cancel(true);
            collisondetectionsvsa.cancel(true);
            collisondetectionballvsc = null;
            collisondetectionballvsactor = null;
            collisondetectionsvsa=null;
        }
   
        g.Collusion=!(turnOnOff);
    }
	private class CollisonDetectionSvsA extends SwingWorker<Void, Object> {
		@Override
		protected Void doInBackground() {
			while (!isCancelled()) {
				for(int i=0;i<g.speciallist.size();i++){
					 if(g.DoesPolygonIntersectPolygon(g.Hero.getBounds(),g.speciallist.get(i).getBounds())){
						 
						 if(g.speciallist.get(i) instanceof Single){
								g.c.setAmmoType(1);
								g.speciallist.get(i).remove=true;
							}else if(g.speciallist.get(i) instanceof Double){
								g.c.setAmmoType(2);
								g.speciallist.get(i).remove=true;
							}else if(g.speciallist.get(i) instanceof Fix){
								g.c.setAmmoType(3);
								g.speciallist.get(i).remove=true;
							}else if(g.speciallist.get(i) instanceof Bomb){
								g.bomb();
								g.speciallist.get(i).remove=true;
								g.Score+=500;
							}else if(g.speciallist.get(i) instanceof Hourglass){
								g.starthourglass();
								g.speciallist.get(i).remove=true;
								g.Score+=200;
							}
	    			 }
					 if(g.speciallist.get(i).remove){
							g.speciallist.remove(g.speciallist.get(i));
					}
					
				}
			}
			
			return null;
		}
	}
	private class CollisonDetectionBallvsC extends SwingWorker<Void, Object> {

		@Override
		protected Void doInBackground() throws InterruptedException  {
			while (g.balllist.size()!=0) {//ballsize0olunc bitcek
				for(int i=0;i<g.balllist.size();i++){
					
					if(g.c.move1 || g.c.stop){
						if(g.DoesPolygonIntersectPolygon(g.c.getBoundsCapa(1),g.balllist.get(i).getBounds())){
							//ball patlatma
							g.ballpatlatma(g.balllist.get(i));
							g.c.move1=false;
							g.c.stop=false;
							g.c.Ammo++;
						}
						
					}
	    			if(g.c.move2){
	    				if(!(i>=g.balllist.size())){//arýza check//eger burde sýfýr kaldýysa error onluyoruz :D
							if(g.DoesPolygonIntersectPolygon(g.c.getBoundsCapa(2),g.balllist.get(i).getBounds())){
								//ballpatlatma
								g.ballpatlatma(g.balllist.get(i));
								g.c.move2=false;
								g.c.Ammo++;
							}
		    			}else{
		    				break;
		    			}
	    			}
	    			
	    		 }
			}
			//next episode
			nextthegame();
			return null;
		}
		
	}
	private class CollisonDetectionBallvsActor extends SwingWorker<Void, Object> {
	    @Override
	    public Void doInBackground() {
	    	 while (!g.Collusion) {//is canceld eklenicek
	    		 for(int i=0;i<g.balllist.size();i++){
	    			 
	    			 if(g.DoesPolygonIntersectPolygon(g.Hero.getBounds(),g.balllist.get(i).getBounds())){
	    				 g.Collusion=true;
	    				 g.ActorLife--;
	    				 
	    			 }
	    		 }
	    		
	    	 }
	    	 
	    	 if(g.ActorLife==0){
	    	 
	    		 loadlobi();//game over
	    	 }else{
	    		 restart();
	    	 }
	    	 return null;
	     
	    }
	    
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String whichkey=e.getActionCommand();
		if(whichkey.compareTo("çikis")==0){
			System.exit(0);
		}else if(whichkey.compareTo("Register")==0){
			//pop up login screen
			loadlobi();
			repaint();
		}else if(whichkey.compareTo("New")==0){
			g.unloadthegame();
			g.ActorLife=3;
			loadthegame(1);
			repaint();
		}else if(whichkey.compareTo("Novice")==0){
			loadlobi();
			g.unloadthegame();
			g.ActorLife=3;
			loadthegame(2);
			repaint();
		}else if(whichkey.compareTo("Intermediate")==0){
			loadlobi();
			g.unloadthegame();
			g.ActorLife=3;
			loadthegame(3);
			repaint();
		}else if(whichkey.compareTo("Advanced")==0){
			loadlobi();
			g.unloadthegame();
			g.ActorLife=3;
			loadthegame(4);
			repaint();
		}else if(whichkey.compareTo("About")==0){
			JOptionPane.showMessageDialog(this, "   The Developer\n   Gökhan Göbüþ\n   280702020\n   gokhangobus@hotmail.com", "About",JOptionPane.PLAIN_MESSAGE );
		}
		
	}
	@Override
	public void keyPressed(KeyEvent event) {
		// TODO Auto-generated method stub
		String whichkey=KeyEvent.getKeyText(event.getKeyCode());
		if(whichkey.compareTo("Right")==0){
			g.Hero.sag=true;
			//g.Hero.setYon(1);
			
		}else if(whichkey.compareTo("Left")==0){
			//g.Hero.setYon(-1);
			g.Hero.sol=true;
			
		}else{
			
		}
		if(whichkey.compareTo("Space")==0){
			if(g.c.fireIsAllowed()){
				g.Hero.fire=true;
				g.c.fire(g.Hero.getX()+29/*(g.Hero.getW()/2)*/,g.Hero.getY(),g.Hero.getY()+g.Hero.getH());//sag30-35-sol28-33
			}
		}
		
		
	}
	
	@Override
	public void keyReleased(KeyEvent event) {
		
			
		
		// TODO Auto-generated method stub
		String whichkey=KeyEvent.getKeyText(event.getKeyCode());
		if(whichkey.compareTo("Right")==0){
			//g.Hero.setYon(0);
			g.Hero.sag=false;
			
			
		}else if(whichkey.compareTo("Left")==0){
			//g.Hero.setYon(0);
			g.Hero.sol=false;
			
			
		}else{
			
		}
		
		
	}
	@Override
	public void keyTyped(KeyEvent event) {
		String whichkey=KeyEvent.getKeyText(event.getKeyCode());
		// TODO Auto-generated method stub
		if(whichkey.compareTo("Right")==0){
			//g.Hero.setYon(0);
			g.Hero.sag=false;
			
		}else if(whichkey.compareTo("Left")==0){
			//g.Hero.setYon(0);
			g.Hero.sag=false;
			
		}
	}
	
	class TimerAction implements ActionListener {
		public TimerAction() {
		}
		public void actionPerformed(ActionEvent event) {
			if(g.GameMode){
				if((g.gecensure/1000)>90){
					//game over
					g.ActorLife--;
					if(g.ActorLife>0){
						restart();
					}else{
						loadlobi();
					}
				}
				if(!g.hourglass){
					for(int i=0;i<g.balllist.size();i++){
				
						g.balllist.get(i).move();
					
					}
				}else{
					
					g.hourglass();
				}
				for(int i=0;i<g.patlakballlist.size();i++){
					if(g.patlakballlist.get(i).patlamazamaný==0){
						g.patlakballlist.remove(g.patlakballlist.get(i));
					}
						
				}
				for(int i=0;i<g.speciallist.size();i++){
					g.speciallist.get(i).move(g.interval);
				}
				g.Hero.moves();
				g.c.move();
				
			}
				g.gecensure+=g.interval;
				repaint();
			}
			

        }
}

	


