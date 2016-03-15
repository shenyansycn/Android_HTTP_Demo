package com.example.shenyan.http_demo;

import android.app.Application;

import com.china.library.VolleyInit.VolleyQueueManager;

/**
 * Created by shenyan on 2015/8/27. Project Http_Demo
 */
public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        VolleyQueueManager.getInstance().initRequestQueue(this);
    }
}
