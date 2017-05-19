package mart.io.uiautomatorcalculator;

import android.support.test.filters.SdkSuppress;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class BasicTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void simpleOperation(){
        onView(withId(R.id.input_field_1))
                .perform(typeText("50"), closeSoftKeyboard());
        onView(withId(R.id.input_field_2))
                .perform(typeText("5"), closeSoftKeyboard());
        onView(withId(R.id.button_1))
                .perform(click());

        onView(withId(R.id.result_field_2)).check(matches(withText("250.0")));
    }
}
