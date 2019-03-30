package regex;

/**
 *
 * @author alexkovacs
 */

public class RegexException extends Exception {

    public RegexException() {
    }

    public RegexException(String message) {
        super(message);
    }

    public RegexException(String message, Throwable cause) {
        super(message, cause);
    }

    public RegexException(Throwable cause) {
        super(cause);
    }

    public RegexException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

   
    
}
