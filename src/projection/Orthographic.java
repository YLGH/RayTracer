package projection;

import main.Driver;
import utility.Point2D;
import utility.Point3D;
import utility.Ray;
import utility.Vector3D;

public class Orthographic extends Projection {

	@Override
	public Ray createRay(Point2D point) {
		double pixelSize = Driver.world.viewplane.size;
		return new Ray(new Point3D(pixelSize * point.x, pixelSize * point.y, 100.0), new Vector3D(0.0, 0.0, -1.0));
	}
}
