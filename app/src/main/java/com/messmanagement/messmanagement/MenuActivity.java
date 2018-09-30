package com.messmanagement.messmanagement;

import android.app.ProgressDialog;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
   ProgressDialog progressDialog;
   Button yes,maybe,no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        yes=(Button)findViewById(R.id.yes);
        no=(Button)findViewById(R.id.no);
        maybe=(Button)findViewById(R.id.maybe);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog=new ProgressDialog(MenuActivity.this);
                progressDialog.setTitle("Sending Respond...");
                progressDialog.setCancelable(false);
                progressDialog.show();

                no.setVisibility(View.GONE);
                maybe.setVisibility(View.GONE);
            }
        });
        progressDialog.cancel();
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog=new ProgressDialog(MenuActivity.this);
                progressDialog.setTitle("Sending Respond...");
                progressDialog.setCancelable(false);
                progressDialog.show();

                yes.setVisibility(View.GONE);
                maybe.setVisibility(View.GONE);
            }
        });
        progressDialog.cancel();

        maybe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog=new ProgressDialog(MenuActivity.this);
                progressDialog.setTitle("Sending Respond...");
                progressDialog.setCancelable(false);
                progressDialog.show();

                no.setVisibility(View.GONE);
                yes.setVisibility(View.GONE);
            }
        });
        progressDialog.cancel();

//
//        progressDialog=new ProgressDialog(MenuActivity.this);
//        progressDialog.setTitle("Loading..");
//        progressDialog.setCancelable(false);
//        progressDialog.show();


    }
}
