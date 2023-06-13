package pl.cp.view;

import java.util.MissingResourceException;
import java.util.ResourceBundle;
import pl.cp.DaoExceptions;

public class LoadException extends DaoExceptions {

    private static ResourceBundle messages;

    public static String LOADER_FAIL = "loader.fail";

    public static String READER_FAIL = "reader.fail";

    public static String LOADERDB_FAIL = "loaderdb.fail";

    public static String READERDB_FAIL = "readerdb.fail";

    public static void setBundle() {
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
