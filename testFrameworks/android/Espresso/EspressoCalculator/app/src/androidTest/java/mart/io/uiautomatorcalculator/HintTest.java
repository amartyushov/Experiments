package mart.io.uiautomatorcalculator;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.Matchers.anyOf;

public class HintTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void hint_isDisplayedInEditText(){
        String hintText = mActivityRule.getActivity().getResources().getString(R.string.input_field_1_hint);

        onView(withId(R.id.input_field_1)).check(matches(withHint(hintText)));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void hint_endsWith() {
        // This check will probably fail if the app is localized and the language is changed. Avoid
        // string literals in code!
        onView(withId(R.id.input_field_1)).check(matches(withHint(anyOf(
                endsWith("operand"), endsWith("operand")))));
    }


}
