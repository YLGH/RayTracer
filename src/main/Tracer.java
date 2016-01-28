package main;

import geometry.GeometricObject;
import scene.Light;
import utility.Color;
import utility.Point2D;
import utility.Point3D;
import utility.Ray;

public class Tracer {

	public void trace(int x, int y, boolean shadow) {
		int width = Driver.world.viewplane.width;
		int height = Driver.world.viewplane.height;
		int samples = Driver.sampler.samples;

		Color color = new Color();

		for (int row = 0; row < samples; row++) {
			for (int col = 0; col < samples; col++) {
				Point2D point = Driver.sampler.sample(row, col, x, y);
				Ray ray = Driver.projection.createRay(point);
				ray.direction.normalize();
				double min_T = Double.MAX_VALUE;
				boolean firstHit = false;
				Color tempColor = new Color(Driver.world.background);
				for (GeometricObject gObject : Driver.world.objects) {
					double t = gObject.hit(ray);
					if (t != 0.0) {
						firstHit = true;
						if (t < min_T) {
							min_T = t;
							Point3D hitPoint = ray.hitPoint(t);
							// shading effects
							boolean intersect = false;
							for (Light light : Driver.world.lights) {
								Ray ray_shad = new Ray(hitPoint, light.location);
								if (shadow) {
									for (GeometricObject gObject2 : Driver.world.objects) {
										if (gObject2 != gObject) {
											if (gObject2.hit(ray_shad) != 0.0) {
												intersect = true;
												break;
											}
										}
									}
									if (!intersect)
										tempColor = gObject.getColor(hitPoint, light);
									else {
										tempColor = gObject.getColorNoLight();
									}
								} else {
									tempColor = gObject.getColor(hitPoint, light);
								}
							}

						}
					}
				}

				if (firstHit)
					color.add(tempColor);
				else {
					color.add(Driver.world.background);
				}
			}
		}
		color.divide(samples * samples);
		Driver.image.buffer.setRGB(width - x - 1, height - y - 1, color.toInteger());
	}
}
