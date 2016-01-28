package utility;

public class Ray {
	public Point3D origin;
	public Vector3D direction;

	public Ray(Point3D origin, Vector3D direction) {
		this.origin = origin;
		direction.normalize();
		this.direction = direction;
	}
	
	public Ray(Point3D origin, Point3D end) {
		this.origin = origin;
		this.direction = end.sub_vec(origin);
		this.direction.normalize();
	}

	public Point3D hitPoint(double t) {
		Point3D p = new Point3D(origin.x + direction.x * t, origin.y + direction.y * t, origin.z + direction.z * t);
		return p;
	}

}
