package geometry;

import utility.Color;
import utility.LightingCoeff;
import utility.Point3D;
import utility.Ray;
import utility.Vector3D;

public class Plane extends GeometricObject {
	Point3D point;
	Vector3D normal;

	/*
	 * Given a point on the plane as well as the normal The locus of the plane
	 * is the set of all points such that (p - o) dot n = 0
	 */

	public Plane(Point3D point, Vector3D normal, LightingCoeff k_d, LightingCoeff k_s, LightingCoeff amb) {
		super(k_d, k_s, amb);
		this.point = new Point3D(point);
		normal.normalize();
		this.normal = new Vector3D(normal);
	}

	@Override
	public double hit(Ray ray) {
		/*
		 * (o + td - a) * n = 0 o*n + t(d*n) - a*n = 0 t(d*n) + (o-a)*n = 0
		 * t(d*n) = (a-o)*n t = (a-o)*n/d*n
		 */
		double t = point.sub(ray.origin).dot(normal) / (ray.direction.dot(normal));

		if (t > 10E-10)
			return t;
		else
			return 0.0;
	}

	@Override
	public Vector3D getNormal(Point3D point) {
		return normal;
	}

}
