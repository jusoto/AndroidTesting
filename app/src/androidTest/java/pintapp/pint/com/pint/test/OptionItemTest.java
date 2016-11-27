package pintapp.pint.com.pint.test;

import android.test.ActivityInstrumentationTestCase2;
import android.view.Menu;

import com.robotium.solo.Solo;

import pintapp.pint.com.pint.*;
import pintapp.pint.com.pint.R;

/**
 * Created by Juan on 11/14/2016.
 */

public class OptionItemTest extends ActivityInstrumentationTestCase2<LoginActivity> {
    private Solo solo;

    public OptionItemTest() {
        super(LoginActivity.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation());
        getActivity();
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
    }

    public void testRun() {
        //Wait for activity: 'pintapp.pint.com.pint.MainActivity'
        solo.waitForActivity(pintapp.pint.com.pint.LoginActivity.class, 2000);
        //Click on Empty Text View
        solo.clickOnView(solo.getView(pintapp.pint.com.pint.R.id.loginTextEmail));
        //Enter the text: 'Xueijao@gmail.com'
        solo.clearEditText((android.widget.EditText) solo.getView(pintapp.pint.com.pint.R.id.loginTextEmail));
        solo.enterText((android.widget.EditText) solo.getView(pintapp.pint.com.pint.R.id.loginTextEmail), "Xuejiao@gmail.com");
        //Click on Empty Text View
        solo.clickOnView(solo.getView(pintapp.pint.com.pint.R.id.loginTextPassword));
        //Enter the text: 'Xueijao12345'
        solo.clearEditText((android.widget.EditText) solo.getView(pintapp.pint.com.pint.R.id.loginTextPassword));
        solo.enterText((android.widget.EditText) solo.getView(pintapp.pint.com.pint.R.id.loginTextPassword), "Xuejiao12345");
        //Click on Login
        solo.clickOnView(solo.getView(pintapp.pint.com.pint.R.id.loginButtonLogin));
        //Wait for activity: 'pintapp.pint.com.pint.HomeActivity'
        assertTrue("pintapp.pint.com.pint.HomeActivity is not found!", solo.waitForActivity(pintapp.pint.com.pint.HomeActivity.class));
        solo.clickOnMenuItem("Logout");
        assertTrue("pintapp.pint.com.pintLoginActivity is not found!", solo.waitForActivity(pintapp.pint.com.pint.LoginActivity.class));
        //Wait for activity: 'pintapp.pint.com.pint.MainActivity'
        solo.waitForActivity(pintapp.pint.com.pint.LoginActivity.class, 2000);
        //Click on Empty Text View
        solo.clickOnView(solo.getView(pintapp.pint.com.pint.R.id.loginTextEmail));
        //Enter the text: 'Xueijao@gmail.com'
        solo.clearEditText((android.widget.EditText) solo.getView(pintapp.pint.com.pint.R.id.loginTextEmail));
        solo.enterText((android.widget.EditText) solo.getView(pintapp.pint.com.pint.R.id.loginTextEmail), "Xuejiao@gmail.com");
        //Click on Empty Text View
        solo.clickOnView(solo.getView(pintapp.pint.com.pint.R.id.loginTextPassword));
        //Enter the text: 'Xueijao12345'
        solo.clearEditText((android.widget.EditText) solo.getView(pintapp.pint.com.pint.R.id.loginTextPassword));
        solo.enterText((android.widget.EditText) solo.getView(pintapp.pint.com.pint.R.id.loginTextPassword), "Xuejiao12345");
        //Click on Login
        solo.clickOnView(solo.getView(pintapp.pint.com.pint.R.id.loginButtonLogin));
        //Wait for activity: 'pintapp.pint.com.pint.HomeActivity'
        assertTrue("pintapp.pint.com.pint.HomeActivity is not found!", solo.waitForActivity(pintapp.pint.com.pint.HomeActivity.class));
        solo.pressMenuItem(0);
        //solo.clickOnMenuItem("action_settings");
        //solo.clickOnMenuItem("test_action");
        assertTrue("pintapp.pint.com.pintLoginActivity is not found!", solo.waitForActivity(pintapp.pint.com.pint.LoginActivity.class));

    }
}
