public class TestLine {
	public static void main(String[] args) {
		Line line1 = new Line(Color.ORANGE, 0, 0, 3, 4);
		Line line2 = new Line(Color.PINK, 1, 2, 5, 7);
		Line line3 = new Line(Color.PURPLE, -1, -1, 2, 2);
		Line line4 = new Line(Color.MAGENTA, 3, 3, 9, 9);

		System.out.println(line1);
		System.out.println(line2);
		System.out.println(line3);
		System.out.println(line4);
	}
}