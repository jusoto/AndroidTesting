package pintapp.pint.com.pint;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;
import org.mockito.Mock;

import pintapp.pint.com.pint.PintNetworking.ITokenProvider;
import pintapp.pint.com.pint.PintNetworking.JSONAdapter;

/**
 * Created by Juan on 10/17/2016.
 */
public class StubPintNetworkingFacade extends PintNetworkingFacade {

    @Mock
    private Context context;

    @Mock
    private ITokenProvider tokenProvider;

    private String email;
    private String password;

    public StubPintNetworkingFacade(Context context){
        this.context = context;
        email = "Xuejiao@gmail.com";
        password = "Xuejiao12345";
    }

    public void GetBloodDrivesByLocation(JSONAdapter jsonAdapter, ITokenProvider tokenProvider, String city, String state){
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject("{\"bloodDriveId\":1,\"title\":\"FIU-MMC Blood Drive\",\"description\":\"We need blood due to the high frequency of accidents in the area.\",\"startTime\":\"2015-09-23\",\"endTime\":\"2015-12-23\",\"address\":\"1234 FIU Way\"},{\"bloodDriveId\":2,\"title\":\"FIU-BBC Blood Drive\",\"description\":\"We need blood and we need it now.\",\"startTime\":\"2015-11-01\",\"endTime\":\"2015-11-30\",\"address\":\"1234 FIU Way\"},{\"bloodDriveId\":5,\"title\":\"Miami Children's Blood Drive\",\"description\":\"We need donations for children patients.\",\"startTime\":\"2016-10-07\",\"endTime\":\"2016-10-27\",\"address\":\"1234 Infinite Way\"}");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonAdapter.add(jsonObject);
    }

    public void GetBloodDrive(JSONAdapter jsonAdapter, ITokenProvider tokenProvider, long bdid){
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject("{\"bloodDriveId\":4,\"title\":\"Index Blood Drive\",\"description\":\"Due to a recent hurricane we are in need of blood.\",\"startTime\":\"2015-09-23\",\"endTime\":\"2015-12-23\",\"address\":\"Index Way\",\"numberOfDonors\":0,\"hospitalName\":\"Index Hospital\",\"coordinator\":null,\"X-AUTH-TOKEN\":\"\"}");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonAdapter.add(jsonObject);
    }

    public void GetUserNotifications(JSONAdapter jsonAdapter, ITokenProvider tokenProvider) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject("{\"hasSeen\":false,\"sentTime\":1473609167000,\"title\":\"Index Notification\",\"shortDescription\":\"Hurricane Devistation\",\"bloodDriveId\":4,\"bloodDriveTitle\":\"Index Blood Drive\",\"notificationId\":22},{\"hasSeen\":false,\"sentTime\":1473609167000,\"title\":\"Index Notification\",\"shortDescription\":\"We are collecting blood for thalassemia patients.\",\"bloodDriveId\":4,\"bloodDriveTitle\":\"Index Blood Drive\",\"notificationId\":25}");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonAdapter.add(jsonObject);
    }

}
