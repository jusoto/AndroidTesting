package pintapp.pint.com.pint.test;

import pintapp.pint.com.pint.MainActivity;
import com.robotium.solo.*;
import android.test.ActivityInstrumentationTestCase2;


public class LoginTest extends ActivityInstrumentationTestCase2<MainActivity> {
  	private Solo solo;
  	
  	public LoginTest() {
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

	}
}
