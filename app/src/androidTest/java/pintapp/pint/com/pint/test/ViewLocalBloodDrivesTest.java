package pintapp.pint.com.pint.test;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;
import com.robotium.solo.Timeout;

import pintapp.pint.com.pint.LoginActivity;


public class ViewLocalBloodDrivesTest extends ActivityInstrumentationTestCase2<LoginActivity> {
  	private Solo solo;

  	public ViewLocalBloodDrivesTest() {
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
        solo.waitForActivity(pintapp.pint.com.pint.MainActivity.class, 2000);
        //Click on Empty Text View
        solo.clickOnView(solo.getView(pintapp.pint.com.pint.R.id.loginTextEmail));
        //Enter the text: 'Xuejiao@gmail.com'
        solo.clearEditText((android.widget.EditText) solo.getView(pintapp.pint.com.pint.R.id.loginTextEmail));
        solo.enterText((android.widget.EditText) solo.getView(pintapp.pint.com.pint.R.id.loginTextEmail), "Xuejiao@gmail.com");
        //Click on Xueijao12345
        solo.clickOnView(solo.getView(pintapp.pint.com.pint.R.id.loginTextPassword));
        //Enter the text: 'Xuejiao12345'
        solo.clearEditText((android.widget.EditText) solo.getView(pintapp.pint.com.pint.R.id.loginTextPassword));
        solo.enterText((android.widget.EditText) solo.getView(pintapp.pint.com.pint.R.id.loginTextPassword), "Xuejiao12345");
        //Click on Login
        solo.clickOnView(solo.getView(pintapp.pint.com.pint.R.id.loginButtonLogin));
        //Wait for activity: 'pintapp.pint.com.pint.HomeActivity'
        assertTrue("pintapp.pint.com.pint.HomeActivity is not found!", solo.waitForActivity(pintapp.pint.com.pint.HomeActivity.class));

    }
}
