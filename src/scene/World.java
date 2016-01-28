package scene;

import java.util.ArrayList;
import java.util.Random;

import geometry.GeometricObject;
import geometry.Plane;
import geometry.Sphere;
import utility.Color;
import utility.LightingCoeff;
import utility.Point3D;
import utility.Vector3D;

public class World {

	public ViewPlane viewplane;
	public ArrayList<GeometricObject> objects;
	public ArrayList<Light> lights;
	public Color background;

	public World(int width, int height, double size, int sphereLimit) {
		viewplane = new ViewPlane(width, height, size);
		background = new Color(1.0F, 1.0F, 1.0F);
		objects = new ArrayList<GeometricObject>();
		lights = new ArrayList<Light>();
		
		/*objects.add(new Plane(new Point3D(-0.0,-200.0,-0.0),
						new Vector3D(0.1,3,0.1),
						new LightingCoeff("DIFF"),
						new LightingCoeff("SPEC"),
						new LightingCoeff("AMB")
				));*/
		
		int numSphere = 0;
		for (int x = -1; x <= 1; x++) {
			for (int y = -1; y <= 1; y++) {
				for (int z = -1; z <= 1; z++) {
					if(numSphere == sphereLimit) break;
					numSphere++;
					
					Point3D center = new Point3D(100 * x, 100 * y, 100 * z);
				
					LightingCoeff k_d = new LightingCoeff("DIFF");
					LightingCoeff k_s = new LightingCoeff("SPEC");
					LightingCoeff k_a = new LightingCoeff("AMB");
					objects.add(new Sphere(center, 50.0, k_d, k_s, k_a));
				}
			}
		}
		
		lights.add(new Light(new Point3D(200.0, 200.0, 300.0), 0.7));

	}
}
