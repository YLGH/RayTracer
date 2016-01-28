package utility;

public class Color {
	public double r, g, b;

	public Color() {
		r = 0.0;
		g = 0.0;
		b = 0.0;
	}

	public Color(double r, double g, double b) {
		this.r = r;
		this.g = g;
		this.b = b;
		limit();
	}

	public void limit() {
		r = Math.min(1.0, r);
		g = Math.min(g, 1.0);
		b = Math.min(b, 1.0);

	}

	public Color(Color c) {
		r = c.r;
		g = c.g;
		b = c.b;
		limit();
	}

	public void add(Color color) {
		r = r + color.r;
		g += color.g;
		b += color.b;
	}

	public void divide(int scalar) {
		r /= scalar;
		g /= scalar;
		b /= scalar;
		limit();
	}

	public int toInteger() {
		return ((int) (r * 255) << 16) | ((int) (g * 255) << 8) | ((int) (b * 255));
	}

	public String toString() {
		return "(" + r + "," + g + "." + b + ")";
	}
}
