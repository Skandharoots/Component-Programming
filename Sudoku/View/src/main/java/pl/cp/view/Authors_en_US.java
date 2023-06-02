package pl.cp.view;

import java.util.ListResourceBundle;

public class Authors_en_US extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return contents;
    }

    private final Object[][] contents = {
            { "labelOne.text", "Project Authors" },
            { "numberAuth1.text", "1" },
            { "numberAuth2.text", "2" },
            { "auth1.text", "Marek Kopania" },
            { "auth2.text", "Filip Krylecki" },
    };
}
