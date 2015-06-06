package com.debashis.volleysimplerequest;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView tView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tView = (TextView) findViewById(R.id.textView2);
        //String url = "http://www.google.com";
        String url="https://pdroid84clock.appspot.com/clock";
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringReq = new StringRequest(Request.Method.GET, url, 
        		new Response.Listener<String>() {

					@Override
					public void onResponse(String arg0) {
						// TODO Auto-generated method stub
						tView.setText("Response is: "+arg0.substring(0, 500));
					}
				},
				new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError arg0) {
						// TODO Auto-generated method stub
						tView.setText("Volly not working");
					}
				});
        queue.add(stringReq);
    }
}
