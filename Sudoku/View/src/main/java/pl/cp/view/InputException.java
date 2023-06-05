package pl.cp.view;

import java.io.IOException;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class InputException extends IOException {

    private static ResourceBundle messages;

    public static String INPUT_FAIL = "input.error";

    public static String ENG_FAIL = "input.engswitch";

    public static String POL_FAIL = "input.polswitch";

    public static String AUTH_FAIL = "input.authswitch";

    public static String MEN_FAIL = "input.menuswitch";

    public static String BOR_FAIL = "input.boardswitch";

    public static String APP_FAIL = "input.appfail";


    public static void setBundle() {
        messages = ResourceBundle.getBundle("pl.cp.exceptions.Input", HelloController.activeLocale);
    }


    public InputException(String message, Throwable cause) {
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
