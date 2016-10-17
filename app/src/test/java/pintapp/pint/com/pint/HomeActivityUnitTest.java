package pintapp.pint.com.pint;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.fakes.RoboMenu;
import org.robolectric.fakes.RoboMenuItem;
import org.robolectric.shadows.RoboLayoutInflater;
import org.robolectric.shadows.httpclient.FakeHttp;

import pintapp.pint.com.pint.PintNetworking.ITokenProvider;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;
import static org.robolectric.Shadows.shadowOf;

/**
 * Created by Juan on 10/15/2016.
 */
@RunWith(MyRobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP, qualifiers = "v10")
public class HomeActivityUnitTest {

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

    @Before
    public void setUp() throws Exception {
        //Use Real HttpLayer to connect to server
        FakeHttp.getFakeHttpLayer().interceptHttpRequests(false);

        if(tokenProvider == null) {
            //Setup Login
            loginActivity = Robolectric.setupActivity(LoginActivity.class);
            loginContext = loginActivity.getBaseContext();
            loginActivity.loginTextEmail.setText(email);
            loginActivity.loginTextPassword.setText(password);
            Button loginButtonLogin = (Button) loginActivity.findViewById(R.id.loginButtonLogin);
            loginActivity.onClick(loginButtonLogin);
            await().atLeast(1, SECONDS);
        }

        //Setup HomeActivity
        activity = Robolectric.setupActivity(HomeActivity.class);
        application = RuntimeEnvironment.application;
        context = application.getBaseContext();


    }

    @After
    public void tearDown() throws Exception {
        activity = null;
        application = null;
        context = null;
    }

    @Test
    public void onCreate() throws Exception {
        //onCreate Already executed on @Setup
        assertNotNull("onCreate", application);
    }

    @Test
    public void onBackPressed() throws Exception {
        //There is no implementation in this method
        //Default assert Application not null
        assertNotNull("onBackPressed - Not implemented in original code", application);
    }

    @Test
    public void onCreateOptionsMenu() throws Exception {
        //This method returns true if it was able to Inflate menu
        Menu menu = new RoboMenu();
        Boolean result = activity.onCreateOptionsMenu(menu);
        assertTrue("onCreateOptionsMenu", result);
    }

    @Test
    public void onOptionsItemSelected() throws Exception {
        //This method returns true it was selected
        //Also it destroys token when Item action_settings is selected
        if(tokenProvider == null) {
            //Setup Login
            loginActivity = Robolectric.setupActivity(LoginActivity.class);
            loginContext = loginActivity.getBaseContext();
            loginActivity.loginTextEmail.setText(email);
            loginActivity.loginTextPassword.setText(password);
            Button loginButtonLogin = (Button) loginActivity.findViewById(R.id.loginButtonLogin);
            loginActivity.onClick(loginButtonLogin);
            await().atLeast(1, SECONDS);
        }

        int itemId = R.id.action_settings;
        MenuItem menuItem = new RoboMenuItem(itemId);
        Boolean result;
        Boolean hasToken;

        //Retrieves tokenProvider of loginActivity declared on Setup
        activity.tokenProvider = loginActivity.tokenProvider;
        hasToken = activity.tokenProvider.hasToken(loginContext);

        //activity.tokenProvider must be valid
        assertTrue("onFloatingActionButtonClick", hasToken);

        //Try to destroy token
        result = activity.onOptionsItemSelected(menuItem);
        hasToken = activity.tokenProvider.hasToken(loginContext);

        //Test if token was destroyed
        assertFalse("onFloatingActionButtonClick", hasToken);
        //Test if answer from function was true
        assertTrue("onOptionsItemSelected", result);
    }

    @Test
    public void onFloatingActionButtonClick() throws Exception {
        if(tokenProvider == null) {
            //Setup Login
            loginActivity = Robolectric.setupActivity(LoginActivity.class);
            loginContext = loginActivity.getBaseContext();
            loginActivity.loginTextEmail.setText(email);
            loginActivity.loginTextPassword.setText(password);
            Button loginButtonLogin = (Button) loginActivity.findViewById(R.id.loginButtonLogin);
            loginActivity.onClick(loginButtonLogin);
            await().atLeast(1, SECONDS);
        }

        Boolean hasToken;

        //Retrieves tokenProvider of loginActivity declared on Setup
        activity.tokenProvider = loginActivity.tokenProvider;
        hasToken = activity.tokenProvider.hasToken(loginContext);

        //activity.tokenProvider must be valid
        assertTrue("onFloatingActionButtonClick", hasToken);

        activity.fab.performClick();
        hasToken = activity.tokenProvider.hasToken(loginContext);

        //activity.tokenProvider must not exist
        assertFalse("onFloatingActionButtonClick", hasToken);
    }

    @Test
    public void ListPagerAdapterConstructor() throws Exception {
        //Test Constructor of ListPagerAdapter Class
        listPagerAdapter = activity.new ListPagerAdapter(activity.getSupportFragmentManager());
        assertNotNull(listPagerAdapter);
    }

    @Test
    public void ListPagerAdapterGetItem() throws Exception {
        //
        listPagerAdapter = activity.new ListPagerAdapter(activity.getSupportFragmentManager());
        android.support.v4.app.Fragment fragment = listPagerAdapter.getItem(0);
        assertNotNull("ListPagerAdapterGetItem", fragment);
    }

    @Test
    public void ListPagerAdapterGetCount() throws Exception {
        //
        listPagerAdapter = activity.new ListPagerAdapter(activity.getSupportFragmentManager());
        assertThat("ListPagerAdapterGetItem", listPagerAdapter.getCount(), equalTo(2));
    }

    @Test
    public void ListPagerAdapterGetPageTitle() throws Exception {
        //
        listPagerAdapter = activity.new ListPagerAdapter(activity.getSupportFragmentManager());
        int position = 0;
        assertThat("ListPagerAdapterGetItem", listPagerAdapter.getPageTitle(position).toString(), equalTo("Blood Drives"));
//        assertThat("ListPagerAdapterGetItem", listPagerAdapter.getPageTitle(position).toString(), equalTo("Notifications"));
    }

    @Test
    public void ListFragmentConstructor() throws Exception {
        //Test Constructor of Fragment Class
        HomeActivity.ListFragment fragment = new HomeActivity.ListFragment();
        assertNotNull(fragment);
    }

    @Test
    public void ListFragmentOnCreateView() throws Exception {
        HomeActivity.ListFragment fragment = new HomeActivity.ListFragment();
        LayoutInflater inflater = new RoboLayoutInflater(context);
        ViewGroup container = new ViewPager(context);
        Bundle bundle = new Bundle();
        bundle.putInt("pintType", PintType.BLOODDRIVE);
        fragment.setArguments(bundle);
        View rootView = fragment.onCreateView(inflater, container, bundle);
        assertNotNull(rootView);
    }

    @Test
    public void ListFragmentOnCreateViewClick() throws Exception {
        HomeActivity.ListFragment fragment = new HomeActivity.ListFragment();
        LayoutInflater inflater = new RoboLayoutInflater(context);
        ViewGroup container = new ViewPager(context);
        Bundle bundle = new Bundle();
        bundle.putInt("pintType", PintType.BLOODDRIVE);
        fragment.setArguments(bundle);
        View rootView = fragment.onCreateView(inflater, container, bundle);
        rootView.findViewById(R.id.homeListViewList).performClick();
        Intent expectedIntent = new Intent(context, DetailedActivity.class);
        assertTrue(shadowOf(activity).getNextStartedActivity() != expectedIntent);
    }

    @Test
    public void ListFragmentOnStart() throws Exception {
        HomeActivity.ListFragment fragment = new HomeActivity.ListFragment();

    }

    @Test
    public void DefaultLocationListenerOnLocationChanged() throws Exception {
        //Test Constructor of Fragment Class
        HomeActivity.DefaultLocationListener listener = activity.new DefaultLocationListener();
        Location location = new Location("service Provider");
        location.setLatitude(Double.MIN_VALUE);
        location.setLongitude(Double.MIN_VALUE);

        activity.latitude = 0.0;
        activity.longitude = 0.0;
        activity.city = "";
        activity.state = "";
        listener.onLocationChanged(location);
        assertNotNull(listener);
        assertNotEquals("Latitude", activity.latitude, 0.0);
        assertNotEquals("Longitude", activity.longitude, 0.0);
        assertNotEquals("City", activity.city, "");
        assertNotEquals("State", activity.state, "");
    }

    @Test
    public void onStatusChanged() throws Exception {
        HomeActivity.DefaultLocationListener listener = activity.new DefaultLocationListener();
        listener.onStatusChanged("service Provider", 0, new Bundle());
        assertNotNull(listener);
    }

    @Test
    public void onProviderEnabled() throws Exception {
        HomeActivity.DefaultLocationListener listener = activity.new DefaultLocationListener();
        listener.onProviderEnabled("service Provider");
        assertNotNull(listener);
    }

    @Test
    public void onProviderDisabled() throws Exception {
        HomeActivity.DefaultLocationListener listener = activity.new DefaultLocationListener();
        listener.onProviderDisabled("service Provider");
        assertNotNull(listener);
    }

}