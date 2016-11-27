package pintapp.pint.com.pint;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONObject;

import java.util.List;
import pintapp.pint.com.pint.PintNetworking.DefaultPintAPI;
import pintapp.pint.com.pint.PintNetworking.DefaultTokenProvider;
import pintapp.pint.com.pint.PintNetworking.ITokenProvider;
import pintapp.pint.com.pint.PintNetworking.JSONAdapter;
import pintapp.pint.com.pint.PintNetworking.UserNotificationComparator;

/**
 * Created by Juan on 10/17/2016.
 */

public class PintNetworkingFacade {

    DefaultPintAPI pintAPI;

    public PintNetworkingFacade(){
        pintAPI = new DefaultPintAPI();
    }

    //UserNotificationComparator
    public int compare(JSONObject lhs, JSONObject rhs) {
        UserNotificationComparator comparator = new UserNotificationComparator();
        return comparator.compare(lhs, rhs);
    }

    //JSONAdapter
    public JSONObject getItem(Context context, List<JSONObject> objects, int pintType, int position){
        JSONAdapter jsonAdapter = new JSONAdapter(context, objects, pintType);
        return jsonAdapter.getItem(position);
    }

    //JSONAdapter
    public View getView(Context context, List<JSONObject> objects, int pintType, int position, View convertView, ViewGroup parent) {
        JSONAdapter jsonAdapter = new JSONAdapter(context, objects, pintType);
        return jsonAdapter.getView(position, convertView, parent);
    }

    //DefaultTokenProvider
    public boolean hasToken(Context context) {
        DefaultTokenProvider tokenProvider = new DefaultTokenProvider(context);
        return tokenProvider.hasToken(context);
    }

    //DefaultTokenProvider
    public String getToken(Context context) {
        DefaultTokenProvider tokenProvider = new DefaultTokenProvider(context);
        return tokenProvider.getToken(context);
    }

    //DefaultTokenProvider
    public void fetchToken(final String email, String password, final PintRequest pintRequest, Context context) {
        DefaultTokenProvider tokenProvider = new DefaultTokenProvider(context);
        tokenProvider.fetchToken(email, password, pintRequest);
    }

    //DefaultTokenProvider
    public void setToken(String token, Context context) {
        DefaultTokenProvider tokenProvider = new DefaultTokenProvider(context);
        tokenProvider.setToken(token, context);
    }

    //DefaultTokenProvider
    public void destroyToken(Context context) {
        DefaultTokenProvider tokenProvider = new DefaultTokenProvider(context);
        tokenProvider.destroyToken(context);
    }

    //DefaultTokenProvider
    public String getEmail(Context context) {
        DefaultTokenProvider tokenProvider = new DefaultTokenProvider(context);
        return tokenProvider.getEmail(context);
    }

    //DefaultTokenProvider
    public void setEmail(String email, Context context) {
        DefaultTokenProvider tokenProvider = new DefaultTokenProvider(context);
        tokenProvider.setEmail(email, context);
    }

    //DefaultTokenProvider
    public void destroyEmail(Context context) {
        DefaultTokenProvider tokenProvider = new DefaultTokenProvider(context);
        tokenProvider.destroyEmail(context);
    }
    
    //DefaultPintAPI
    public void GetBloodDrivesByLocation(JSONAdapter jsonAdapter, ITokenProvider tokenProvider, String city, String state) {
        pintAPI.GetBloodDrivesByLocation(jsonAdapter, tokenProvider, city, state);
    }

    //DefaultPintAPI
    public void GetUserNotifications(JSONAdapter jsonAdapter, ITokenProvider tokenProvider) {
        pintAPI.GetUserNotifications(jsonAdapter, tokenProvider);
    }

    //DefaultPintAPI
    public void GetBloodDriveUserNotifications(JSONAdapter jsonAdapter, ITokenProvider tokenProvider, long bdid) {
        pintAPI.GetBloodDriveUserNotifications(jsonAdapter, tokenProvider, bdid);
    }

    //DefaultPintAPI
    public void GetBloodDrive(JSONAdapter jsonAdapter, ITokenProvider tokenProvider, long bdid) {
        pintAPI.GetBloodDrive(jsonAdapter, tokenProvider, bdid);
    }

    //DefaultPintAPI
    public void execute() {
        pintAPI.execute();
    }

    //DefaultPintAPI
    public void executeOne() {
        pintAPI.executeOne();
    }

}
