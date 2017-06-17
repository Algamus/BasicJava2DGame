
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public  class Menubar {
	JMenuBar menubar;
	
	JMenu oyun;
	JMenu yardim;
	JMenu ayarlar;
	
	JMenuItem kayitli;
	JMenuItem yeni;
	JMenuItem cikis;
	
	JMenuItem gecmis;
	JMenuItem highscore;
	JMenuItem novice;
	JMenuItem intermediate;
	JMenuItem advanced;
	
	JMenuItem about;
		public Menubar(){
			menubar = new JMenuBar();//menu bar ekleme
		
			oyun = new JMenu("Game");
			menubar.add(oyun);
			kayitli = new JMenuItem("Register");
			oyun.add(kayitli);
			yeni = new JMenuItem("New");
			oyun.add(yeni);
			cikis = new JMenuItem("çikis");
			oyun.add(cikis);
			ayarlar = new JMenu("Options");
			menubar.add(ayarlar);
			gecmis = new JMenuItem("History");
			ayarlar.add(gecmis);
			highscore = new JMenuItem("High Score");
			ayarlar.add(highscore);
			novice = new JMenuItem("Novice");
			ayarlar.add(novice);
			intermediate = new JMenuItem("Intermediate");
			ayarlar.add(intermediate);
			advanced = new JMenuItem("Advanced");
			ayarlar.add(advanced);
			yardim = new JMenu("Help");
			menubar.add(yardim);
			about = new JMenuItem("About");
			yardim.add(about);
		
		}

	
}
