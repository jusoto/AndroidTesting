package pintapp.pint.com.pint.test;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;
import com.robotium.solo.Timeout;

import pintapp.pint.com.pint.MainActivity;


public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
    private Solo solo;

    public MainActivityTest() {
        super(MainActivity.class);
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
        solo.waitForActivity(pintapp.pint.com.pint.MainActivity.class, 2000);
        //Click on Empty Text View
        solo.clickOnView(solo.getView(pintapp.pint.com.pint.R.id.loginTextEmail));
        //Set default small timeout to 27221 milliseconds
        Timeout.setSmallTimeout(27221);
        //Enter the text: 'Xueijao@gmail.com'
        solo.clearEditText((android.widget.EditText) solo.getView(pintapp.pint.com.pint.R.id.loginTextEmail));
        solo.enterText((android.widget.EditText) solo.getView(pintapp.pint.com.pint.R.id.loginTextEmail), "Xueijao@gmail.com");
        //Click on Empty Text View
        solo.clickOnView(solo.getView(pintapp.pint.com.pint.R.id.loginTextPassword));
        //Enter the text: 'Xueijao12345'
        solo.clearEditText((android.widget.EditText) solo.getView(pintapp.pint.com.pint.R.id.loginTextPassword));
        solo.enterText((android.widget.EditText) solo.getView(pintapp.pint.com.pint.R.id.loginTextPassword), "Xueijao12345");
        //Click on Login
        solo.clickOnView(solo.getView(pintapp.pint.com.pint.R.id.loginButtonLogin));
        //Click on Xueijao@gmail.com
        solo.clickOnView(solo.getView(pintapp.pint.com.pint.R.id.loginTextEmail));
        //Enter the text: 'Xuejiao@gmail.com'
        solo.clearEditText((android.widget.EditText) solo.getView(pintapp.pint.com.pint.R.id.loginTextEmail));
        solo.enterText((android.widget.EditText) solo.getView(pintapp.pint.com.pint.R.id.loginTextEmail), "Xuejiao@gmail.com");
        //Click on Login
        solo.clickOnView(solo.getView(pintapp.pint.com.pint.R.id.loginButtonLogin));
        //Click on Xueijao12345
        solo.clickOnView(solo.getView(pintapp.pint.com.pint.R.id.loginTextPassword));
        //Enter the text: 'Xuejiao12345'
        solo.clearEditText((android.widget.EditText) solo.getView(pintapp.pint.com.pint.R.id.loginTextPassword));
        solo.enterText((android.widget.EditText) solo.getView(pintapp.pint.com.pint.R.id.loginTextPassword), "Xuejiao12345");
        //Click on Login
        solo.clickOnView(solo.getView(pintapp.pint.com.pint.R.id.loginButtonLogin));
        //Wait for activity: 'pintapp.pint.com.pint.HomeActivity'
        assertTrue("pintapp.pint.com.pint.HomeActivity is not found!", solo.waitForActivity(pintapp.pint.com.pint.HomeActivity.class));
        //Click on FIU-MMC Blood Drive We need blood due to the high frequency of accidents in
        solo.clickInList(1, 0);
        //Wait for activity: 'pintapp.pint.com.pint.DetailedActivity'
        assertTrue("pintapp.pint.com.pint.DetailedActivity is not found!", solo.waitForActivity(pintapp.pint.com.pint.DetailedActivity.class));
        //Press menu back key
        solo.goBack();
        //Click on FIU-BBC Blood Drive We need blood and we need it now. 5 miles
        solo.clickInList(2, 0);
        //Wait for activity: 'pintapp.pint.com.pint.DetailedActivity'
        assertTrue("pintapp.pint.com.pint.DetailedActivity is not found!", solo.waitForActivity(pintapp.pint.com.pint.DetailedActivity.class));
        //Press menu back key
        solo.goBack();
        //Click on Miami Children's Blood Drive We need donations for children patients. 5 miles
        solo.clickInList(3, 0);
        //Wait for activity: 'pintapp.pint.com.pint.DetailedActivity'
        assertTrue("pintapp.pint.com.pint.DetailedActivity is not found!", solo.waitForActivity(pintapp.pint.com.pint.DetailedActivity.class));
        //Press menu back key
        solo.goBack();
        //Click on Notifications
        solo.clickOnText(java.util.regex.Pattern.quote("Notifications"));
        //Click on Index Notification Hurricane Devistation From: Index Blood Drive
        solo.clickInList(1, 1);
        //Wait for activity: 'pintapp.pint.com.pint.DetailedActivity'
        assertTrue("pintapp.pint.com.pint.DetailedActivity is not found!", solo.waitForActivity(pintapp.pint.com.pint.DetailedActivity.class));
        //Press menu back key
        solo.goBack();
        //Click on Index Notification We are collecting blood for thalassemia patients. From:
        solo.clickInList(2, 1);
        //Wait for activity: 'pintapp.pint.com.pint.DetailedActivity'
        assertTrue("pintapp.pint.com.pint.DetailedActivity is not found!", solo.waitForActivity(pintapp.pint.com.pint.DetailedActivity.class));
        //Press menu back key
        solo.goBack();
        //Click on ImageView
        solo.clickOnView(solo.getView(android.widget.ImageView.class, 0));
        //Click on Logout
        solo.clickInList(1, 0);
        //Wait for activity: 'pintapp.pint.com.pint.MainActivity'
        assertTrue("pintapp.pint.com.pint.MainActivity is not found!", solo.waitForActivity(pintapp.pint.com.pint.MainActivity.class));
    }
}
