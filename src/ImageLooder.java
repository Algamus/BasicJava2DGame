import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import javax.swing.ImageIcon;


public class ImageLooder {
	Image i;
	public  Image Loadimage(String name){
		
		return new ImageIcon(getClass().getResource(name)).getImage();
		
	}
	public Image Loadimage(String name,final Color color){
		
		i=new ImageIcon(getClass().getResource(name)).getImage();
		return makeColorTransparent(i, color);
		
	}
	public Image makeColorTransparent(Image im, final Color color) {
		ImageFilter filter = new RGBImageFilter() {
		// the color we are looking for... Alpha bits are set to opaque
		public int markerRGB = color.getRGB() | 0xFF000000;

		public final int filterRGB(int x, int y, int rgb) {
		if ( ( rgb | 0xFF000000 ) == markerRGB ) {
		// Mark the alpha bits as zero - transparent
			return 0x00FFFFFF & rgb;
		}else{
		    // nothing to do
			return rgb;
		}
		}
	}; 

	ImageProducer ip = new FilteredImageSource(im.getSource(), filter);
	
	Image image=Toolkit.getDefaultToolkit().createImage(ip);
	
	return image;
	
	}
}

