package pintapp.pint.com.pint.test;

import pintapp.pint.com.pint.*;
import pintapp.pint.com.pint.R;

import com.robotium.solo.*;
import android.test.ActivityInstrumentationTestCase2;


public class ViewBloodDriveDetailsTest extends ActivityInstrumentationTestCase2<LoginActivity> {
  	private Solo solo;
  	
  	public ViewBloodDriveDetailsTest() {
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
        //Wait for activity: 'pintapp.pint.com.pint.MainActivity'
		assertTrue("pintapp.pint.com.pint.HomeActivity is not found!", solo.waitForActivity(pintapp.pint.com.pint.HomeActivity.class));
        //Set default small timeout to 37881 milliseconds
		Timeout.setSmallTimeout(37881);
        //Click on FIU-MMC Blood Drive We need blood due to the high frequency of accidents in
		solo.clickInList(1, 0);
        //Wait for activity: 'pintapp.pint.com.pint.DetailedActivity'
		assertTrue("pintapp.pint.com.pint.DetailedActivity is not found!", solo.waitForActivity(pintapp.pint.com.pint.DetailedActivity.class));
        solo.clickOnView(solo.getView(pintapp.pint.com.pint.R.id.fab));
		//Click on FIU-MMC Blood Drive We need blood due to the high frequency of accidents in
        solo.waitForActivity(pintapp.pint.com.pint.DetailedActivity.class, 2000);
		solo.clickOnView(solo.getView(R.id.detailList));
		//Wait for activity: 'pintapp.pint.com.pint.DetailedActivity'
		assertTrue("pintapp.pint.com.pint.DetailedActivity is not found!", solo.waitForActivity(pintapp.pint.com.pint.DetailedActivity.class));

	}
}
