package com.messmanagement.messmanagement;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.messmanagement.messmanagement.Retrofit.RetrofitInterface;
import com.messmanagement.messmanagement.util.Model;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignIn extends AppCompatActivity {
Button signin;
        TextView createaccount;
        TextInputEditText email,password;
        ProgressDialog progressDialog;
        Model model;
String token;
    private static Retrofit.Builder builder=new Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());
    Gson gson = new GsonBuilder().setLenient().create();
    OkHttpClient client = new OkHttpClient();
    public static Retrofit retrofit=builder.build();
    RetrofitInterface retrofitInterface=retrofit.create(RetrofitInterface.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        createaccount=(TextView) findViewById(R.id.signup);
        email=(TextInputEditText)findViewById(R.id.email);
        password=(TextInputEditText)findViewById(R.id.password);
        signin=(Button)findViewById(R.id.signin);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog=new ProgressDialog(SignIn.this);
                progressDialog.setTitle("Log In");
                progressDialog.setMessage("Please wait while we check your credentials");
                progressDialog.setCancelable(false);
                progressDialog.show();
                String emailid=email.getEditableText().toString();
                String Spassword=password.getEditableText().toString();
                startLogin(emailid,Spassword);
            }
        });
        createaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SignIn.this,SignupMess.class);
                startActivity(i);
            }
        });
    }

    private void startLogin(String emailid, String spassword) {
        if(emailid.isEmpty()){
            progressDialog.dismiss();
            email.setError("Mobile is required");
            email.requestFocus();
            return;
        }
        if(spassword.length()<6)
        {
            progressDialog.dismiss();
            password.setError("pin atleast of 6 characters");
            password.requestFocus();
            return;
        }

        Call<Model> call=retrofitInterface.login2(emailid,spassword);

        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, retrofit2.Response<Model> response) {

                progressDialog.dismiss();
                model=response.body();

//             Log.d("check",String.valueOf(model.getSuccess()));
                if(model.getMsg()!=null&& model.getMsg().equals("wrong password"))
                {
                    progressDialog.cancel();
                    Log.e("TAG", "response 33: " + new Gson().toJson(response.body()));
                    password.setError("Incorrect Pin");
                    password.requestFocus();
                    return ;
                }

                if(model.getMsg()!=null&&model.getMsg().equals("user with email does not exist"))
                {
                    progressDialog.cancel();
                    email.setError("Invalid Email");
                    email.requestFocus();
                    return;
                }
                boolean check=false;
                check= model.getSuccess();
                Log.d("check",String.valueOf(check));


                if(check){
                    progressDialog.cancel();
                    Toast.makeText(SignIn.this, "Signin Successful", Toast.LENGTH_SHORT).show();
                    // session.createLoginSession(mobile, pin,model.getToken());

                  token=model.getToken();
                    //  Log.e(TAG,token);
                    Intent i=new Intent(SignIn.this,MainActivity.class);
                    // i.putExtra("allvalues", model);
                      i.putExtra("token",token);
//                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                    finish();
                }
                else
                {
                    Toast.makeText(SignIn.this, "Some Error occured, Please try Again After Some Time! ", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

                Toast.makeText(SignIn.this,t.getMessage(),Toast.LENGTH_SHORT).show();
                Log.e("TAG", "error: " + t);
                progressDialog.cancel();
            }
        });


    }
}
