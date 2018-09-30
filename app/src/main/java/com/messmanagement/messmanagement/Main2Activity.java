package com.messmanagement.messmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
Button mess1,mess2,mess3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mess1=(Button)findViewById(R.id.mess1button);
        mess2=(Button)findViewById(R.id.mess2button);
        mess3=(Button)findViewById(R.id.mess3button);
        Intent intent=getIntent();
        final String token=intent.getStringExtra("token");
        mess1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Main2Activity.this,MenuActivity.class);
                i.putExtra("token",token);

                startActivity(i);
            }
        });
        mess2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Main2Activity.this,MenuActivity.class);
                i.putExtra("token",token);

                startActivity(i);
            }
        });
        mess3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Main2Activity.this,MenuActivity.class);
                i.putExtra("token",token);
                startActivity(i);
            }
        });


    }
}
