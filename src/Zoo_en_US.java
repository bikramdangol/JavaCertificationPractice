import java.util.ListResourceBundle;

/**
 * Created by bikra on 12/17/2019 8:01 PM.
 */
public class Zoo_en_US extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {

        return new Object[][]{
                {"hello", "Hello"},
                {"open", "The zoo is open by bundle."},
        };
    }
}
