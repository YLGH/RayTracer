package geometry;

import utility.Color;
import utility.LightingCoeff;
import utility.Point3D;
import utility.Ray;
import utility.Vector3D;

public class Sphere extends GeometricObject {

	public Point3D center;
	public double radius;

	public Sphere(Point3D center, double radius, LightingCoeff k_d, LightingCoeff k_s, LightingCoeff amb) {
		super(k_d, k_s, amb);
		this.center = new Point3D(center);
		this.radius = radius;
	}

	@Override
	public double hit(Ray ray) {
		/*
		 * (p-c)*(p-c) = r^2 (o+td-c)*(o+td-c) -r^2= 0 (td+o-c)(td+o-c) - r^2 =
		 * 0 (d*d)t + 2((o-c)*d)t + (o-c)*(o-c)-r^2 = 0
		 */

		Point3D o = ray.origin;
		Vector3D d = ray.direction;
		d.normalize();

		double a = d.dot(d);
		double b = 2 * ((o.sub(center)).dot(d));
		double c = (o.sub(center)).dot(o.sub(center)) - radius * radius;

		double disc = b * b - 4 * a * c;
		if (disc < 0) {
			return 0.0; // did not hit
		}

		double t = ((-b) - Math.sqrt(disc)) / (2 * a);
		if (t > 10E-9)
			return t;
		else
			return 0.0; // No intersection

	}

	@Override
	public Vector3D getNormal(Point3D point) {
		Vector3D n = point.sub_vec(center);
		n.normalize();
		return n;
	}

}
