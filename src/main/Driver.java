package main;

import projection.Perspective;
import projection.Projection;
import sampling.JitteredSample;
import sampling.RegularSample;
import sampling.Sampler;
import scene.World;
import utility.Image;
import utility.Point3D;

/**
 * @author yingliu
 *
 */
public class Driver {
	public static World world;
	public static Image image;
	public static Tracer tracer;
	public static Sampler sampler;
	public static Projection projection;
	public static Point3D eye;

	public static void main(String[] args) {
		for (int i = 1; i <= 27; i++) {
			long start_time = System.nanoTime();
			world = new World(500, 500, 1.0, i);
			image = new Image("ShadowImage" + Integer.toString(i) + ".png");
			tracer = new Tracer();
			sampler = new JitteredSample(2);
			eye = new Point3D(-200.0, 200.0, 600.0);
			projection = new Perspective(eye, new Point3D(), 45.0);

			int height = world.viewplane.height;
			int width = world.viewplane.width;

			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					tracer.trace(x, y, true);
				}
			}
			image.write("PNG");
			long end_time = System.nanoTime();
			System.out.println((end_time - start_time) / 1E9F);
		}
	}
}
