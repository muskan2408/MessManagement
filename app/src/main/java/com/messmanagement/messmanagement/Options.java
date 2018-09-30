package com.messmanagement.messmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Options extends AppCompatActivity {
Button signinmess,signinstudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        signinmess=(Button)findViewById(R.id.signinmess);
        signinstudent=(Button)findViewById(R.id.signinstudent);
        signinmess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Options.this,SignIn.class);
                startActivity(i);
            }
        });
        signinstudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Options.this,SignInStudent.class);
                startActivity(i);
            }
        });
    }
}
