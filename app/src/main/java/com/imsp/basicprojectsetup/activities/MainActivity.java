package com.imsp.basicprojectsetup.activities;

import android.content.Context;
import android.os.Handler;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.GsonRequest;
import com.google.gson.Gson;
import com.imsp.basicprojectsetup.R;
import com.imsp.basicprojectsetup.helper.HttpRequest;
import com.imsp.basicprojectsetup.models.response.JsonValidatorResponse;
import com.imsp.basicprojectsetup.views.SPProgressDialog;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button) findViewById(R.id.show_dialog)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final SPProgressDialog dialog = new SPProgressDialog(MainActivity.this);
                dialog.showDialog();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                      dialog.dismissDialog();
                    }
                },3000);
            }
        });

    }

}