package pintapp.pint.com.pint.test;

import pintapp.pint.com.pint.LoginActivity;
import pintapp.pint.com.pint.MainActivity;
import com.robotium.solo.*;
import android.test.ActivityInstrumentationTestCase2;


public class LoginTest extends ActivityInstrumentationTestCase2<LoginActivity> {
  	private Solo solo;
  	
  	public LoginTest() {
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
	}
}
