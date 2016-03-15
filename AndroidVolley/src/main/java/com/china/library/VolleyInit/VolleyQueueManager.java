package com.china.library.VolleyInit;

import android.content.Context;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


/**
 *
 * Created by xiaao on 4/9/15. Project ChinaPay
 */
public class VolleyQueueManager {

    public static final String TAG = "ChinaComVolleyManager";

    public static VolleyQueueManager instance;
    private RequestQueue requestQueue;

    public static synchronized VolleyQueueManager getInstance() {
        if (instance == null) {
            synchronized (VolleyQueueManager.class) {
                if (instance == null) {
                    instance = new VolleyQueueManager();
                }
            }
        }
        return instance;
    }

    private VolleyQueueManager() {
    }


    public void initRequestQueue(Context context) {
        requestQueue = Volley.newRequestQueue(context);
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        requestQueue.add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        requestQueue.add(req);
    }


    public void cancelPendingRequests(Object tag) {
        if (requestQueue != null) {
            requestQueue.cancelAll(tag);
        }
    }
}
