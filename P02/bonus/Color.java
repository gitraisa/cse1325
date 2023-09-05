
enum Color {
	ORANGE(0xFFA500),
	PINK(0xFFC0CB),
	PURPLE(0x800080),
	MAGENTA(0xFF00FF);

	private int rgb;

	private Color(int rgb) {
		this.rgb = rgb;
	}

	public int getRgb() {
		return rgb;
	}


	public String toString() {
		return name() + " (RGB: 0x" + Integer.toHexString(rgb) + ")";
	}
}