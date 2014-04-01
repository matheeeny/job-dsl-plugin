package javaposse.jobdsl.plugin;

public class ExtensionPointException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExtensionPointException() {
        super();
    }

    public ExtensionPointException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ExtensionPointException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExtensionPointException(String message) {
        super(message);
    }

    public ExtensionPointException(Throwable cause) {
        super(cause);
    }

}
