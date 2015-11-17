package com.example.acer.fabfresh;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

//import android.support.v7.app.ActionBarActivity;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       final RequestQueue queue = Volley.newRequestQueue(this);
        final TextView mTextView = (TextView) findViewById(R.id.textView);
        final TextView mTextView1 = (TextView) findViewById(R.id.textView3);
        final EditText mEditTText=(EditText)findViewById(R.id.editText2);
        final EditText mEditTText1=(EditText)findViewById(R.id.editText2);
        final Button mButton=(Button)findViewById(R.id.button);
mButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        //String url =mEditTText.getText().toString();
String url="https://api.github.com/repos";
        url=url+"/"+mEditTText.getText().toString()+"/"+mEditTText1.getText().toString()+"/issues";
       //mTextView.setText(url);
        StringRequest strRequest = new StringRequest(Request.Method.GET,url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                           mTextView1.setText("Issues: "+ response);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextView1.setText("Error");
            }
        });
        queue.add(strRequest);
    }
});






// Add the request to the RequestQueue.




    }


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
