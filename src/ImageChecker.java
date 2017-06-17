import java.awt.Image;
import java.awt.image.PixelGrabber;

//by gokhangobus
public class ImageChecker {
	public static int get(Image image,int i){
		PixelGrabber grabber = new PixelGrabber(image,0, 0, -1, -1, false);
	 
		try {
			grabber.grabPixels();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// grabber throws zorunlu ekliyor
		if(i==0){
			return grabber.getWidth();
		}else{
			return grabber.getHeight();

		}
	}
}
