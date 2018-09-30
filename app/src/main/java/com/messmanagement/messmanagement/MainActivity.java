package com.messmanagement.messmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    CardView uploadmenu,viewreport,addnotice,urgentnotice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uploadmenu=(CardView)findViewById(R.id.upload);
        viewreport=(CardView)findViewById(R.id.report);
        addnotice=(CardView)findViewById(R.id.addnotice);
        urgentnotice=(CardView)findViewById(R.id.urgent);
        Intent intent=getIntent();
        final String token=intent.getStringExtra("token");
        uploadmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,UploadMenu.class);
                i.putExtra("token",token);
                startActivity(i);
            }
        });
        viewreport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,ViewReport.class);
                i.putExtra("token",token);
                startActivity(i);
            }
        });
        addnotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,AddNotice.class);
                i.putExtra("token",token);
                startActivity(i);
            }
        });


    }
}
