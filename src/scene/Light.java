package scene;

import utility.Point3D;

public class Light {
	public Point3D location;
	public double I; //intensity
	
	public Light(Point3D location, double I) {
		this.location = location;
		this.I = I;
	}
	
}
