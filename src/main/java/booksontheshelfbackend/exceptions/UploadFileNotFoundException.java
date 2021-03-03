package booksontheshelfbackend.exceptions;

public class UploadFileNotFoundException extends RuntimeException{

    public UploadFileNotFoundException(String message) {
        super(message);
    }

    public UploadFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}