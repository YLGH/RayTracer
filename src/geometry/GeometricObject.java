package geometry;

import main.Driver;
import scene.Light;
import utility.Color;
import utility.LightingCoeff;
import utility.Point3D;
import utility.Ray;
import utility.Vector3D;

public abstract class GeometricObject {

	public LightingCoeff k_d;
	public LightingCoeff k_s;
	public LightingCoeff amb;

	public abstract double hit(Ray ray);

	public abstract Vector3D getNormal(Point3D point);

	public GeometricObject(LightingCoeff k_d, LightingCoeff k_s, LightingCoeff amb) {
		this.k_d = k_d;
		this.k_s = k_s;
		this.amb = amb;
	}

	public Color getColorNoLight() {
		return new Color(amb.r, amb.g, amb.b);
	}
	public Color getColor(Point3D point, Light light) {
		Vector3D n = getNormal(point);

		// Initialize with ambiance
		double new_r = amb.r;
		double new_g = amb.g;
		double new_b = amb.b;

			Vector3D l = light.location.sub_vec(point);
			l.normalize();
			n.normalize();

			// Perform Diffuse Reflection
			double diffuse = Math.max(0.0, n.dot(l));
			new_r += k_d.r * light.I * diffuse;
			new_g += k_d.g * light.I * diffuse;
			new_b += k_d.b * light.I * diffuse;

			// Perform Spectral Reflection
			Vector3D v = Driver.eye.sub_vec(point);
			v.normalize();
			Vector3D h = v.add(l);
			h.normalize();

			double spectral = Math.max(0.0, Math.pow(n.dot(h), 3));
			new_r += k_s.r * light.I * spectral;
			new_g += k_s.g * light.I * spectral;
			new_b += k_s.b * light.I * spectral;

		return new Color(new_r, new_g, new_b);
	}

}
