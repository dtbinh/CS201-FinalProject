package library;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

//A statically used class for loading image resources
//Ensures that images aren't loaded into memory more than necessary
public class ImageLibrary {
	private static Map<String, Image> imageMap;
	
	static{
		imageMap = new HashMap<String,Image>();
	}
	
	private ImageLibrary(){} //disable constructor
	
	//Gets the image if available already, otherwise the image is loaded and returned
	public static Image getImage(String directory) {
		Image img = imageMap.get(directory);
		if(img == null) {
			try { img = ImageIO.read(new File(directory)); }
			catch (IOException e) { System.out.println("Error reading image: " + e); return null; }
			imageMap.put(directory, img);
		}
		return img;
	}
	
	//Forced the image to be reloaded from file
	public static Image getImageReload(String directory) {
		Image img;
		try { img = ImageIO.read(new File(directory)); }
		catch (IOException e) { System.out.println("Error reading image: " + e); return null; }
		imageMap.put(directory, img);
		return img;
	}
	
	//Clears out all the images from the library
	public static void clearImages() {
		imageMap.clear();
	}
	
	public static Image getScaledImage(Image srcImg, int w, int h){
	    /*BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();

	    return resizedImg;*/
		
		Image newImage;
		newImage = srcImg.getScaledInstance(w, h, Image.SCALE_SMOOTH);
		return newImage;

	}
}