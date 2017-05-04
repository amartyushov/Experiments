package mart.io.robotiumcalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowIntent;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.robolectric.Shadows.shadowOf;


@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP_MR1)
@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    private Activity activity;

    @Before
    public void setup() {
        activity = Robolectric.buildActivity(MainActivity.class).create().get();
    }


    @Test
    public void validateTextViewContent() {
        TextView textView = (TextView) activity.findViewById(R.id.text_view);
        assertNotNull("TextView is null", textView);
        assertTrue("TextView's text does not match.", "Hello Robolectric!".equals(textView.getText().toString()));
    }

    @Test
    public void validateButtonClick() {
        Button button = (Button) activity.findViewById(R.id.button_simple);
        button.performClick();

        ShadowActivity shadowActivity = shadowOf(activity);

        /**
         * Robolectric intercepts the loading of Android classes during testing.
         * That’s why instance of shadow activity delegates to the application
         * and return the next Intent on the started activities stack.
         */
        Intent startedIntent = shadowActivity.getNextStartedActivity();

        ShadowIntent shadowIntent = shadowOf(startedIntent);
        assertThat(shadowIntent.getIntentClass().getName(), equalTo(HomeActivity.class.getName()));
    }
}