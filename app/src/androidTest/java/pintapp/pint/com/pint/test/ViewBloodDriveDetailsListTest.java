package pintapp.pint.com.pint.test;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;
import com.robotium.solo.Timeout;

import pintapp.pint.com.pint.DetailedActivity;
import pintapp.pint.com.pint.HomeActivity;
import pintapp.pint.com.pint.LoginActivity;
import pintapp.pint.com.pint.R;


public class ViewBloodDriveDetailsListTest extends ActivityInstrumentationTestCase2<LoginActivity> {
  	private Solo solo;

  	public ViewBloodDriveDetailsListTest() {
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
        solo.clickOnView(solo.getView(R.id.loginTextEmail));
        //Enter the text: 'Xuejiao@gmail.com'
        solo.clearEditText((android.widget.EditText) solo.getView(R.id.loginTextEmail));
        solo.enterText((android.widget.EditText) solo.getView(R.id.loginTextEmail), "bpate005@fiu.edu");
        //Click on Xueijao12345
        solo.clickOnView(solo.getView(R.id.loginTextPassword));
        //Enter the text: 'Xuejiao12345'
        solo.clearEditText((android.widget.EditText) solo.getView(R.id.loginTextPassword));
        solo.enterText((android.widget.EditText) solo.getView(R.id.loginTextPassword), "bruPINT#111");
        //Click on Login
        solo.clickOnView(solo.getView(R.id.loginButtonLogin));
        //Wait for activity: 'pintapp.pint.com.pint.MainActivity'
		assertTrue("pintapp.pint.com.pint.HomeActivity is not found!", solo.waitForActivity(HomeActivity.class));
        //Set default small timeout to 37881 milliseconds
		Timeout.setSmallTimeout(37881);
        //Click on FIU-MMC Blood Drive We need blood due to the high frequency of accidents in
		solo.clickInList(1, 0);
        //Wait for activity: 'pintapp.pint.com.pint.DetailedActivity'
		assertTrue("pintapp.pint.com.pint.DetailedActivity is not found!", solo.waitForActivity(DetailedActivity.class));
		//solo.clickOnView(solo.getView(R.id.detailList));
		solo.clickInList(6);
		//Wait for activity: 'pintapp.pint.com.pint.DetailedActivity'
		assertTrue("pintapp.pint.com.pint.DetailedActivity is not found!", solo.waitForActivity(DetailedActivity.class));

	}
}
