package com.messmanagement.messmanagement;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.messmanagement.messmanagement.Retrofit.RetrofitInterface;
import com.messmanagement.messmanagement.util.Model;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignupMess extends AppCompatActivity {
TextInputEditText messname,ownername,email,mobileno,pass,confirmpass,collegename;
    Button signup;
    ProgressDialog progressDialog;

    private static Retrofit.Builder builder=new Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    public static Retrofit retrofit=builder.build();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_mess);
        collegename=(TextInputEditText)findViewById(R.id.collegename);
        messname=(TextInputEditText)findViewById(R.id.messname);
        ownername=(TextInputEditText)findViewById(R.id.ownername);
        email=(TextInputEditText)findViewById(R.id.emailid);
        mobileno=(TextInputEditText)findViewById(R.id.mobile);
        pass=(TextInputEditText)findViewById(R.id.password);
        confirmpass=(TextInputEditText)findViewById(R.id.confirmpassword);
        signup=(Button)findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                progressDialog=new ProgressDialog(SignUp.this);
//                progressDialog.setTitle("Creating Account");
//                progressDialog.setMessage("Please wait while we create your account");
//                progressDialog.setCancelable(false);
//                progressDialog.show();
                progressDialog=new ProgressDialog(SignupMess.this);
                progressDialog.setTitle("Creating Account");
                progressDialog.setMessage("Please wait while we create your account");
                progressDialog.setCancelable(false);
                progressDialog.show();
//                Intent i=new Intent(Register.this,Login.class);
//                startActivity(i);

                startRegister(
                        collegename.getEditableText().toString(),
                        messname.getEditableText().toString(),
                        ownername.getEditableText().toString(),
                        email.getEditableText().toString(),
                        mobileno.getEditableText().toString(),
                        pass.getEditableText().toString(),
                        confirmpass.getEditableText().toString()
                       );

            }
        });

    }

    private void startRegister(String collegename, String messname, String ownername, String email, String mobileno, String pass, String confirmpass) {
        if(collegename.isEmpty()){
            progressDialog.dismiss();
            this.collegename.setError("Name is required");
            this.collegename.requestFocus();
            return;
        }
        if(email.isEmpty()){
            progressDialog.dismiss();
            this.email.setError("Email is required");
            this.email.requestFocus();
            return;
        }
        if(messname.isEmpty()){
            progressDialog.dismiss();
            this.messname.setError("Email is required");
            this.messname.requestFocus();
            return;
        }
        if(ownername.isEmpty()){
            progressDialog.dismiss();
            this.ownername.setError("Email is required");
            this.ownername.requestFocus();
            return;
        }if(mobileno.isEmpty()){
            progressDialog.dismiss();
            this.mobileno.setError("Email is required");
            this.mobileno.requestFocus();
            return;
        }

        if(pass.isEmpty()){
            progressDialog.dismiss();
            this.pass.setError("password is required");
            this.pass.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            this.email.setError("Please enter a valid email");
            this.email.requestFocus();
            progressDialog.cancel();
            progressDialog.dismiss();
            return;
        }
        if(confirmpass.isEmpty()){
            progressDialog.dismiss();
            this. confirmpass.setError("confirmPassword is required");
            this.confirmpass.requestFocus();
            return;
        }
        if(pass.length()<6)
        {
            progressDialog.dismiss();
            this.pass.setError("password must be of 6 characters");
            this.pass.requestFocus();
            return;
        }
        if(!confirmpass.equals(pass))
        {

            progressDialog.dismiss();
            this.confirmpass.setError("password does not match");
            this.confirmpass.requestFocus();
            return;
        }
        if(mobileno.length()!=10)
        {
            progressDialog.dismiss();
            this.mobileno.setError("Enter valid mobile number");
            this.mobileno.requestFocus();
            return;
        }


        RetrofitInterface retrofitInterface=retrofit.create(RetrofitInterface.class);

        Call<Model> call=retrofitInterface.register(collegename,messname,ownername,mobileno,email,pass);
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                progressDialog.dismiss();
                Model model=response.body();
//                if(model.getMsg().equals("mobile number already exist")){
//                    new AlertDialog.Builder(SignUp.this).setTitle("Enter Another Mobile No.")
//                            .setMessage("Mobile number already exist")
//                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialogInterface, int i) {
//                                    Intent intent = new Intent(SignUp.this, MobileAuthActivity.class);
//                                    startActivity(intent);
//                                    finish();
//                                }
//                            }).show();
//
//                }
                if(model.getMsg().equals("user created")){
                    //  progressDialog.cancel();
                    new AlertDialog.Builder(SignupMess.this).setTitle("User Created Successfully")
                            .setMessage("Please Login to Continue")
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent=new Intent(SignupMess.this,SignIn.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }).show();
                }
                else
                {
                    // progressDialog.dismiss();
                    Toast.makeText(SignupMess.this, "Some Error occured, Please try Again After Some Time! ", Toast.LENGTH_SHORT).show();
                }}

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(SignupMess.this, "Error !!!!!!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
