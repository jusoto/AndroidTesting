package pintapp.pint.com.pint;

import android.app.Application;
import android.content.Context;
import android.location.LocationListener;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.Button;

import org.json.JSONObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.httpclient.FakeHttp;

import java.util.ArrayList;

import pintapp.pint.com.pint.PintNetworking.DefaultTokenProvider;
import pintapp.pint.com.pint.PintNetworking.ITokenProvider;
import pintapp.pint.com.pint.PintNetworking.JSONAdapter;

import static java.util.concurrent.TimeUnit.SECONDS;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static org.awaitility.Awaitility.await;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by Juan on 10/17/2016.
 */

@RunWith(MyRobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP, qualifiers = "v10")
public class SubsystemTest {

    private LoginActivity loginActivity;
    private Context loginContext;
    private HomeActivity activity;
    private Application application;
    private Context context;
    private ITokenProvider tokenProvider;
    public LocationListener mLocationListener = null;
    public double latitude;
    public double longitude;
    public String city;
    public String state;
    public ViewPager mViewPager;
    public HomeActivity.ListPagerAdapter listPagerAdapter;
    public String[] tabs = {"Blood Drives", "Notifications"};
    private String email = "Xuejiao@gmail.com";
    private String password = "Xuejiao12345";
    StubPintNetworkingFacade stub;

    @Before
    public void setUp() throws Exception {

        //Use Fake HttpLayer to connect to server
        FakeHttp.getFakeHttpLayer().interceptHttpRequests(true);
        doLogin();

        //Setup HomeActivity
        activity = Robolectric.setupActivity(HomeActivity.class);
        application = RuntimeEnvironment.application;
        context = application.getBaseContext();

        stub = new StubPintNetworkingFacade(context);

    }

    @After
    public void tearDown() throws Exception {
        stub = null;
        activity = null;
        application = null;
        context = null;
    }

    private void doLogin(){
        if(tokenProvider == null) {
            //Setup Login
            loginActivity = Robolectric.setupActivity(LoginActivity.class);
            loginContext = loginActivity.getBaseContext();
            loginActivity.loginTextEmail.setText(email);
            loginActivity.loginTextPassword.setText(password);
            Button loginButtonLogin = (Button) loginActivity.findViewById(R.id.loginButtonLogin);
            loginActivity.onClick(loginButtonLogin);
        }
        tokenProvider = loginActivity.tokenProvider;
    }

    private void doLogout(){
        tokenProvider.destroyEmail(loginContext);
        tokenProvider.destroyToken(loginContext);
    }

    @Test
    public void Login() throws Exception {
        await().atLeast(3, SECONDS);
        if(tokenProvider.hasToken(loginContext))
            assertTrue(tokenProvider.hasToken(loginContext));
        else
            assertFalse(tokenProvider.hasToken(loginContext));
    }

    @Test
    public void Logout() throws Exception {
        doLogout();
        assertFalse(tokenProvider.hasToken(loginContext));
    }

    @Test
    public void ViewLocalBloodDrives() throws Exception {
        ArrayList<JSONObject> pintObjects = new ArrayList<JSONObject>();
        int pintType = PintType.BLOODDRIVE;
        JSONAdapter jsonAdapter = new JSONAdapter(context, pintObjects, pintType);
        JSONAdapter expectedJsonAdapter = new JSONAdapter(context, pintObjects, pintType);
        String city = "Miami";
        String state = "FL";
        JSONObject jsonObject = new JSONObject("{\"bloodDriveId\":1,\"title\":\"FIU-MMC Blood Drive\",\"description\":\"We need blood due to the high frequency of accidents in the area.\",\"startTime\":\"2015-09-23\",\"endTime\":\"2015-12-23\",\"address\":\"1234 FIU Way\"},{\"bloodDriveId\":2,\"title\":\"FIU-BBC Blood Drive\",\"description\":\"We need blood and we need it now.\",\"startTime\":\"2015-11-01\",\"endTime\":\"2015-11-30\",\"address\":\"1234 FIU Way\"},{\"bloodDriveId\":5,\"title\":\"Miami Children's Blood Drive\",\"description\":\"We need donations for children patients.\",\"startTime\":\"2016-10-07\",\"endTime\":\"2016-10-27\",\"address\":\"1234 Infinite Way\"}");
        expectedJsonAdapter.add(jsonObject);

        tokenProvider = loginActivity.tokenProvider;
        stub.GetBloodDrivesByLocation(jsonAdapter, tokenProvider, city, state);

        assertTrue(jsonAdapter.getClass() == expectedJsonAdapter.getClass());
    }

    @Test
    public void ViewBloodDriveDetails() throws Exception {
        ArrayList<JSONObject> pintObjects = new ArrayList<JSONObject>();
        int pintType = PintType.BLOODDRIVE;
        JSONAdapter jsonAdapter = new JSONAdapter(context, pintObjects, pintType);
        JSONAdapter expectedJsonAdapter = new JSONAdapter(context, pintObjects, pintType);
        int bloodDriveId = 4;
        JSONObject jsonObject = new JSONObject("{\"bloodDriveId\":4,\"title\":\"Index Blood Drive\",\"description\":\"Due to a recent hurricane we are in need of blood.\",\"startTime\":\"2015-09-23\",\"endTime\":\"2015-12-23\",\"address\":\"Index Way\",\"numberOfDonors\":0,\"hospitalName\":\"Index Hospital\",\"coordinator\":null,\"X-AUTH-TOKEN\":\"\"}");
        expectedJsonAdapter.add(jsonObject);

        tokenProvider = loginActivity.tokenProvider;
        stub.GetBloodDrive(jsonAdapter, tokenProvider, bloodDriveId);

        assertTrue(jsonAdapter.getClass() == expectedJsonAdapter.getClass());
    }

    @Test
    public void ViewNotifications() throws Exception {
        ArrayList<JSONObject> pintObjects = new ArrayList<JSONObject>();
        int pintType = PintType.BLOODDRIVE;
        JSONAdapter jsonAdapter = new JSONAdapter(context, pintObjects, pintType);
        JSONAdapter expectedJsonAdapter = new JSONAdapter(context, pintObjects, pintType);
        JSONObject jsonObject = new JSONObject("{\"hasSeen\":false,\"sentTime\":1473609167000,\"title\":\"Index Notification\",\"shortDescription\":\"Hurricane Devistation\",\"bloodDriveId\":4,\"bloodDriveTitle\":\"Index Blood Drive\",\"notificationId\":22},{\"hasSeen\":false,\"sentTime\":1473609167000,\"title\":\"Index Notification\",\"shortDescription\":\"We are collecting blood for thalassemia patients.\",\"bloodDriveId\":4,\"bloodDriveTitle\":\"Index Blood Drive\",\"notificationId\":25}");
        expectedJsonAdapter.add(jsonObject);

        tokenProvider = loginActivity.tokenProvider;
        stub.GetUserNotifications(jsonAdapter, tokenProvider);

        assertTrue(jsonAdapter.getClass() == expectedJsonAdapter.getClass());
    }

}
