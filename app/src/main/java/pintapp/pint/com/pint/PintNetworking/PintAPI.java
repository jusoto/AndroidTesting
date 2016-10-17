package pintapp.pint.com.pint.PintNetworking;

import pintapp.pint.com.pint.R;

/**
 * Created by gregoryjean-baptiste on 11/28/15.
 */
public class PintAPI {


    public static String SERVER_IP = "http://10.109.55.248:8080";

    public static final String GET_BLOODDRIVES_BY_LOCATION =
            SERVER_IP + "/api/donor/getBloodDrivesByLocation";

    public static final String GET_USER_NOTIFICATIONS = SERVER_IP + "/api/donor/getUserNotifications";

    public static final String GET_BLOODDRIVE_USER_NOTIFICATIONS = SERVER_IP + "/api/donor/getBloodDriveUserNotifications";

    public static final String GET_BLOODDRIVE = SERVER_IP + "/api/donor/getBloodDrive";

    public String url;
    public JSONAdapter jsonAdapter;
    public ITokenProvider tokenProvider;

    public PintAPI(JSONAdapter jsonAdapter, ITokenProvider tokenProvider) {
        this.jsonAdapter = jsonAdapter;
        this.tokenProvider = tokenProvider;
    }
}
