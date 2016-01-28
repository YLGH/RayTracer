package projection;

import utility.Point2D;
import utility.Point3D;
import utility.Ray;
import utility.Vector3D;

public abstract class Projection {

	public Point3D eye;
	// Shoot out to the look at
	public Point3D lookat;
	public double distance;
	public Vector3D u, v, w;

	public abstract Ray createRay(Point2D point);

	public void compute_uvw() {
		w = eye.sub_vec(lookat);
		w.normalize();

		Vector3D up = new Vector3D(0.00424, 1.0, 0.00764);

		u = up.cross(w);
		up.normalize();

		v = w.cross(u);
		v.normalize();
	}

}
