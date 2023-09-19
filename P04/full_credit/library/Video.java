package library;
import java.time.LocalDate;

public class Video extends Publication {
	private int runtime;

	public Video(String title, String author, int copyright, int runtime) {
		super(title, author, copyright);

		if (runtime <= 0) {
			throw new InvalidRuntimeException(title, runtime);
		}
		
		this.runtime = runtime;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("Runtime: ").append(runtime).append(" minutes\n");
		return sb.toString();
	}
}