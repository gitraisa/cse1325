public class InvalidRuntimeException extends ArithmeticException {
	public InvalidRuntimeException() {
		super();
	}

	public InvalidRuntimeException(String s) {
		super(s);
	}

	public InvalidRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidRuntimeException(String title, int runtime) {
		super(title + " has invalid runtime " + runtime);
	}
}