package pl.cp.view;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class NoMethodException extends NoSuchMethodException {

    private static ResourceBundle messages;

    public static String METHOD_NULL = "method.null";


    public static void setBundle() {
        messages = ResourceBundle
                .getBundle("pl.cp.exceptions.NoMethod", HelloController.activeLocale);
    }

    public NoMethodException(String message) {
        super(message);
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
