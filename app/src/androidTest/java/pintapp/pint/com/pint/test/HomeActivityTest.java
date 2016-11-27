package pintapp.pint.com.pint.test;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;
import com.robotium.solo.Timeout;

import pintapp.pint.com.pint.LoginActivity;


public class HomeActivityTest extends ActivityInstrumentationTestCase2<LoginActivity> {
  	private Solo solo;

  	public HomeActivityTest() {
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
        solo.waitForActivity(LoginActivity.class, 2000);
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
        Timeout.setSmallTimeout(10838);
        solo.clickOnView(solo.getView(pintapp.pint.com.pint.R.id.loginButtonLogin));
		//Wait for activity: 'pintapp.pint.com.pint.HomeActivity'
		assertTrue("pintapp.pint.com.pint.HomeActivity is not found!", solo.waitForActivity(pintapp.pint.com.pint.HomeActivity.class, 10000));
        //Wait for location update
        solo.sleep(7000);
        solo.goBack();
        assertFalse("pintapp.pint.com.pint.HomeActivity is not found!", solo.waitForActivity(pintapp.pint.com.pint.LoginActivity.class, 10000));
        //solo.setGPSMockLocation(37.42198, -122.085083, 40);
	}
}
