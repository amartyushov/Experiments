package io.mart;

import com.sun.glass.ui.Size;

import java.awt.*;

import static java.awt.Color.*;

public class Equals_transitivity_violation {
}

class Point {
	private final int x;
	private final int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Point)) return false;
		Point p = (Point) obj;
		return p.x == x && p.y==y;
	}
}

// if you want to extend this class

class ColorPoint extends Point{
	private final Color color;

	public ColorPoint(int x, int y, Color color) {
		super(x, y);
		this.color = color;
	}

	// violates symmetry
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ColorPoint)) return false;
		return super.equals(obj) && ((ColorPoint)obj).color == color; // diff results comparing point and colorpoint
	}

	public static void main(String[] args) {
		Point p = new Point(1,2);
		ColorPoint cp = new ColorPoint(1,2, BLACK);
		p.equals(cp); // is true
		cp.equals(p); // is false
	}
}

//This is a proper way! Composition over inheritance
class SizePoint {
	private final Point point;
	private final Size size;

	public SizePoint(int x, int y, Size size) {
		this.point = new Point(x,y);
		this.size = size;
	}

	public Point asPoint() {
		return point;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof SizePoint)) return false;
		SizePoint sp = (SizePoint) obj;
		return sp.point.equals(point) && sp.size.equals(size);
	}
}
