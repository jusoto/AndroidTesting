package pintapp.pint.com.pint.test;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;
import com.robotium.solo.Timeout;

import pintapp.pint.com.pint.LoginActivity;
import pintapp.pint.com.pint.PintNetworking.DefaultTokenProvider;


public class LoginR01Test extends ActivityInstrumentationTestCase2<LoginActivity> {
  	private Solo solo;
    //private ExtSolo solo = new ExtSolo(getInstrumentation(), getActivity(), this.getClass().getCanonicalName(), getName());

  	public LoginR01Test() {
		super(LoginActivity.class);
  	}

  	public void setUp() throws Exception {
        super.setUp();
		solo = new Solo(getInstrumentation());
        //solo = new ExtSolo(getInstrumentation(), getActivity(), this.getClass().getCanonicalName(), getName());
		getActivity();
        DefaultTokenProvider.SERVER_IP = "http://localhost:8080";
  	}

   	@Override
   	public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
        DefaultTokenProvider.SERVER_IP = "http://192.168.18.1:8080";
  	}

	public void testRun() {
        //Wait for activity: 'pintapp.pint.com.pint.MainActivity'
        solo.waitForActivity(LoginActivity.class, 2000);
        //Click on Empty Text View
        solo.clickOnView(solo.getView(pintapp.pint.com.pint.R.id.loginTextEmail));
        //Enter the text: 'Xueijao@gmail.com'
        solo.clearEditText((android.widget.EditText) solo.getView(pintapp.pint.com.pint.R.id.loginTextEmail));
        solo.enterText((android.widget.EditText) solo.getView(pintapp.pint.com.pint.R.id.loginTextEmail), "user");
        //Click on Empty Text View
        solo.clickOnView(solo.getView(pintapp.pint.com.pint.R.id.loginTextPassword));
        //Enter the text: 'Xueijao12345'
        solo.clearEditText((android.widget.EditText) solo.getView(pintapp.pint.com.pint.R.id.loginTextPassword));
        solo.enterText((android.widget.EditText) solo.getView(pintapp.pint.com.pint.R.id.loginTextPassword), "pass");
        //Click on Login
        Timeout.setSmallTimeout(2000);
        solo.clickOnView(solo.getView(pintapp.pint.com.pint.R.id.loginButtonLogin));
		//Wait for activity: 'pintapp.pint.com.pint.HomeActivity'
		assertFalse("pintapp.pint.com.pint.HomeActivity is not found!", solo.waitForActivity(pintapp.pint.com.pint.HomeActivity.class));
	}
}
