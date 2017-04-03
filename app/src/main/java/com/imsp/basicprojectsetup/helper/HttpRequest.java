package com.imsp.basicprojectsetup.helper;

/**
 * Created by SP on 03-04-2017.
 */
import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import android.util.Log;
import android.webkit.CookieManager;
import com.android.volley.NetworkResponse;
import com.android.volley.RequestTickle;
import com.android.volley.Response;
import com.android.volley.VolleyLog;
import com.android.volley.error.AuthFailureError;
import com.android.volley.error.TimeoutError;
import com.android.volley.error.VolleyError;
import com.android.volley.request.StringRequest;
import com.android.volley.toolbox.VolleyTickle;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.CookieStore;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by paras.sampat on 7/15/2016.
 */
 /*
 * Class Usage   :   Used to remember which tab was user on in the last visit
 */
public class HttpRequest {
    static InputStream is = null;
    //    static JSONObject jObj = null;
//    static String json = "";
    //=====================
    String responseString = "";
    private static final String TAG = "HTTPRequest";
    private static final String PROTOCOL_CHARSET = "utf-8";
    public static final String PROTOCOL_CONTENT_TYPE =
            String.format("application/json; charset=%s", PROTOCOL_CHARSET);
    //    private RequestQueue mRequestQueue;
    //=======================
    private Context context;
    public HttpRequest(Context context) {
        this.context = context;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        VolleyLog.DEBUG = true;
//        mRequestQueue = getRequestQueue();
    }
    public String getJsonFromUrl(int methodType, final String url, final String jsonObject) {
        RequestTickle mRequestQueue = VolleyTickle.newRequestTickle(context);
        StringRequest request = new StringRequest(methodType, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Log.i("http response","/////////////*************------------------- + " + s);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.i("testing ", "error : " + volleyError.toString());
                if (volleyError.getClass().equals(TimeoutError.class)) {
                }
            }
        }) {
            @Override
            public String getBodyContentType() {
                return PROTOCOL_CONTENT_TYPE;
            }
            @Override
            public byte[] getBody() throws AuthFailureError {
                return jsonObject.getBytes();
            }
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                HashMap<String, String> map = new HashMap<>();
//                Log.i(TAG, "headers : " + map.toString());
//                return map;
//            }
            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                Log.i(getClass().getSimpleName(),"*************///////////////**************** : " + response.headers.get("Cookie"));
                return super.parseNetworkResponse(response);
            }
        };
        mRequestQueue.add(request);
        NetworkResponse response = mRequestQueue.start();
        Log.i(getClass().getSimpleName(), " headers response ---------------- : " + response.headers.toString());
        Log.i(getClass().getSimpleName(), " headers response cookie ---------------- : " + response.headers.get("Set-Cookie"));
        Log.i(getClass().getSimpleName(), " headers response cookie ---------------- : " + response.headers.get("remember-me"));
        try {
            responseString = new String(response.data, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Log.i(TAG, responseString);
        return responseString;
    }
}
