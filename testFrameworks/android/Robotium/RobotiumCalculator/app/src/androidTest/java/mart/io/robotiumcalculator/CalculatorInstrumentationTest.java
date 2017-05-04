package mart.io.robotiumcalculator;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.EditText;
import android.widget.TextView;

import com.robotium.solo.Solo;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class CalculatorInstrumentationTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    private Solo solo;

    @Before
    public void setUp() throws Exception {
        solo = new Solo(InstrumentationRegistry.getInstrumentation(),
                activityTestRule.getActivity());
    }

    @After
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    @Test
    public void testSum() throws Exception{
        EditText first_number = (EditText) solo.getView(R.id.txtFirstNumber);
        EditText second_number = (EditText) solo.getView(R.id.txtSecondNumber);
        TextView result = (TextView) solo.getView(R.id.resultText);

        solo.unlockScreen();
        solo.assertCurrentActivity("Expected MainActivity Activity", MainActivity.class);

        solo.enterText(first_number, String.valueOf("2"));
        solo.enterText(second_number, String.valueOf("3"));
        solo.clickOnButton("Get Result");
        assertTrue(solo.searchText("5.0")); // not nice
        assertThat(result.getText().toString(), is("5.0"));
    }
}
