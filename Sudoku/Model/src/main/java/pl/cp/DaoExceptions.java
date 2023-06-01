package pl.cp;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class DaoExceptions extends RuntimeException {

    private static final ResourceBundle exceptions;

    static {
        Locale locale = Locale.getDefault(Locale.Category.DISPLAY);
        exceptions = ResourceBundle.getBundle("exceptions.Dao", locale);
    }
    public DaoExceptions(String message) {
        super(message);
    }

    public DaoExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public static String getDaoMessage(String key) {
        return exceptions.getString(key);
    }
}
