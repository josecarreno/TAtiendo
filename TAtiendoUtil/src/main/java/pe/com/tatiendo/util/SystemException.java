package pe.com.tatiendo.util;

public class SystemException extends Exception{

    public SystemException() {
    }

    public SystemException(String message) {
        super(message);
    }

    public SystemException(Throwable cause) {
        super(cause);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
}
