package utility;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.Driver;

public class Image {

	public BufferedImage buffer;
	public File image;

	public Image(String filename) {
		image = new File(filename);
		int width = Driver.world.viewplane.width;
		int height = Driver.world.viewplane.height;
		buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	}
	
	public void write(String filetype) {
		try {
			ImageIO.write(buffer, filetype, image);
		} catch (IOException e) {
			System.err.println("Could not write image");
			System.exit(1);
		}
	}

}
