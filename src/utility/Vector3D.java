package utility;

public class Vector3D {
	public double x, y, z;

	public Vector3D() {
		x = 0.0;
		y = 0.0;
		z = 0.0;
		;
	}

	public Vector3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vector3D(Vector3D other) {
		x = other.x;
		y = other.y;
		z = other.z;
	}

	public Vector3D add(Vector3D vector) {
		return new Vector3D(x + vector.x, y + vector.y, z + vector.z);
	}

	public Vector3D sub(Vector3D vector) {
		return new Vector3D(x - vector.x, y - vector.y, z - vector.z);
	}

	public double dot(Vector3D v) {
		return x * v.x + y * v.y + z * v.z;
	}

	public double dot(Point3D point) {
		return x * point.x + y * point.y + z * point.z;
	}

	public double mag2() {
		return x * x + y * y + z * z;
	}

	public Vector3D mult(double scalar) {
		return new Vector3D(x*scalar, y*scalar, z*scalar);
	}

	public void normalize() {
		double mag = Math.sqrt(mag2());
		
		x /= mag;
		y /= mag;
		z /= mag;

	}

	public Vector3D cross(Vector3D v) {
		return new Vector3D((y * v.z - z * v.y), -(x * v.z - z * v.x), (x * v.y - y * v.x));
	}
}
