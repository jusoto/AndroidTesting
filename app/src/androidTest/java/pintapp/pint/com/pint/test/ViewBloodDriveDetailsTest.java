package pintapp.pint.com.pint.test;

import pintapp.pint.com.pint.MainActivity;
import com.robotium.solo.*;
import android.test.ActivityInstrumentationTestCase2;


public class ViewBloodDriveDetailsTest extends ActivityInstrumentationTestCase2<MainActivity> {
  	private Solo solo;
  	
  	public ViewBloodDriveDetailsTest() {
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
        //Wait for activity: 'pintapp.pint.com.pint.HomeActivity'
		assertTrue("pintapp.pint.com.pint.HomeActivity is not found!", solo.waitForActivity(pintapp.pint.com.pint.HomeActivity.class));
        //Set default small timeout to 37881 milliseconds
		Timeout.setSmallTimeout(37881);
        //Click on FIU-MMC Blood Drive We need blood due to the high frequency of accidents in
		solo.clickInList(1, 0);
        //Wait for activity: 'pintapp.pint.com.pint.DetailedActivity'
		assertTrue("pintapp.pint.com.pint.DetailedActivity is not found!", solo.waitForActivity(pintapp.pint.com.pint.DetailedActivity.class));
	}
}
