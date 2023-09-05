
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

	private String colorText(String text, int rgb) {
		return "\u001B[38;2;" + ((rgb >> 16) & 0xFF) + ";" + ((rgb >> 8) & 0xFF) + ";" + (rgb & 0xff) + "m" + text + "\u001B[0m";
	}


	public String toString() {
		return name() + " (RGB: 0x" + Integer.toHexString(rgb) + ")";
	}
}