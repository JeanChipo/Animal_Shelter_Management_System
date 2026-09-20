package exception;

public class WrongDataFormat extends RuntimeException {
    public WrongDataFormat(String message) {
        super(message);
    }
}
