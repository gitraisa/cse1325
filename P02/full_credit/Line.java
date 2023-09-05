class Line {
	private Color color;
	private int x1, y1, x2, y2;

	public Line(Color color, int x1, int y1, int x2, int y2) {
		this.color = color;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	public double length() {
		return Math.sqrt(Math.pow(x1 - x2, 2.0) + Math.pow(y1 - y2, 2.0));
	}

	public String toString() {
		return color + "(" + x1 + "," +y1 + ") - (" + x2 + "," + y2 + "), has Length: " + length();
	}
}