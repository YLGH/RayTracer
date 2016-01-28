package utility;

import java.util.Random;

public class LightingCoeff {
	public double r;
	public double g;
	public double b;

	public LightingCoeff(String type) {
		Random rand = new Random();
		switch(type) {
		case "AMB": 
			r = .5;
			g = .5;
			b = .5;
			break;
		case "SPEC":
			r = .5;
			g = .5;
			b = .5;
			break;
		case "DIFF":
			r = rand.nextDouble();
			g = rand.nextDouble();
			b = rand.nextDouble();
			break;
		}
	}

	public LightingCoeff(double r, double g, double b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}

}
