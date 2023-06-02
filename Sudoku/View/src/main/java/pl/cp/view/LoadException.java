package pl.cp.view;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import pl.cp.DaoExceptions;

public class LoadException extends DaoExceptions {

    private static final ResourceBundle messages;

    public static final String LOADER_FAIL = "loader.fail";

    public static final String READER_FAIL = "reader.fail";


    static {
        messages = ResourceBundle.getBundle("pl.cp.exceptions.Load", HelloController.activeLocale);
    }

    public LoadException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getLocalizedMessage() {
        String message;
        try {
            //Exception message is a key
            message = messages.getString(getMessage());
        } catch (MissingResourceException mre) {
            message = "No resource for " + getMessage() + "key";
        }
        return message;
    }
}
