package com.example.shenyan.http_demo;

import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.china.library.Request.GsonRequest;
import com.china.library.VolleyInit.VolleyQueueManager;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(onClickListener);
        findViewById(R.id.button1).setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button:
                    //            StringRequest stringRequest = new StringRequest(Request.Method.GET, url, listener, errorListener);
                    //            VolleyQueueManager.getInstance().addToRequestQueue(stringRequest);
                    String url = "http://192.168.23.142:9898/appFeedback?key10=value10&key11=value11&key12=value12";
                    ArrayMap<String, String> arrayMap = new ArrayMap<>();
                    arrayMap.put("key1", "value1");
                    arrayMap.put("key2", "value2");
                    arrayMap.put("key3", "value3");
                    GsonRequest gsonRequest = new GsonRequest(Request.Method.GET, url, arrayMap, ResponeBean.class, listener, errorListener);
                    VolleyQueueManager.getInstance().addToRequestQueue(gsonRequest);
                    break;
                case R.id.button1:
                    String url1 = "http://192.168.23.142:9898/appFeedback";

                    //            StringRequest stringRequest = new StringRequest(Request.Method.GET, url, listener, errorListener);
                    //            VolleyQueueManager.getInstance().addToRequestQueue(stringRequest);
                    ArrayMap<String, String> arrayMap1 = new ArrayMap<>();
                    arrayMap1.put("key1", "value1");
                    arrayMap1.put("key2", "value2");
                    arrayMap1.put("key3", "value3");
                    GsonRequest gsonRequest1 = new GsonRequest(Request.Method.POST, url1, arrayMap1, ResponeBean.class, listener, errorListener);
                    VolleyQueueManager.getInstance().addToRequestQueue(gsonRequest1);
                    break;
            }

        }
    };
    private Response.Listener<ResponeBean> listener = new Response.Listener<ResponeBean>() {
        @Override
        public void onResponse(ResponeBean response) {
            Log.i(TAG, "onResponse " + response);
            Log.i(TAG, "onResponse state = " + response.getState());
            Log.i(TAG, "onResponse message = " + response.getMessage());
        }
    };
    private Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.i(TAG, "onErrorResponse " + error.getMessage());
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
