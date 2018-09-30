package com.messmanagement.messmanagement;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Button;
import android.widget.Toast;

import com.messmanagement.messmanagement.Retrofit.RetrofitInterface;
import com.messmanagement.messmanagement.util.Model;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UploadMenu extends AppCompatActivity {
      Switch moongdal,daltadka,tuardal,chanadal,rajma,sevcurry,aloosabji,paneergravy,vegbiryani,plainrice,jeerarice,nonverbiryani
              ,plainroti,stuffedparatha,tandoorinaan,alooparatha,eggcurry,curry,chickencurry,fishfry,greensalid,grainsalid,tomatosoup,soup,masalapapad
              ,kurkure,papad,masalawaffers,gulabjamun,moonghalwa,icecream,sweets;
      Button upload;
      ProgressDialog progressDialog;
    private static Retrofit.Builder builder=new Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    public static Retrofit retrofit=builder.build();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_menu);

        moongdal=(Switch)findViewById(R.id.moongdal);
        daltadka=(Switch)findViewById(R.id.daltadka);
        tuardal=(Switch)findViewById(R.id.tuardal);
        chanadal=(Switch)findViewById(R.id.chanadal);
        rajma=(Switch)findViewById(R.id.Rajmaa);
        sevcurry=(Switch)findViewById(R.id.sevcurry);
        aloosabji=(Switch)findViewById(R.id.AlooSabji);
        paneergravy=(Switch)findViewById(R.id.Paneer);
        vegbiryani=(Switch)findViewById(R.id.biryani);
        plainrice=(Switch)findViewById(R.id.Plainrice);
        jeerarice=(Switch)findViewById(R.id.jeererice);
        nonverbiryani=(Switch)findViewById(R.id.nonvegbiryani);
        plainroti=(Switch)findViewById(R.id.Plainroti);
        stuffedparatha=(Switch)findViewById(R.id.stuffedparatha);
        tandoorinaan=(Switch)findViewById(R.id.TandoriNaan);
        alooparatha=(Switch)findViewById(R.id.Alooparatha);
        eggcurry=(Switch)findViewById(R.id.eggcurry);
        curry=(Switch)findViewById(R.id.curry);
        chickencurry=(Switch)findViewById(R.id.Chicken);
        fishfry=(Switch)findViewById(R.id.Fish);
        greensalid=(Switch)findViewById(R.id.GreenSalid);
        grainsalid=(Switch)findViewById(R.id.grainssalid);
        tomatosoup=(Switch)findViewById(R.id.tomatosoup);
        soup=(Switch)findViewById(R.id.Soup);
        masalapapad=(Switch)findViewById(R.id.Masalapapad);
        kurkure=(Switch)findViewById(R.id.kurkure);
        papad=(Switch)findViewById(R.id.papad);
        masalawaffers=(Switch)findViewById(R.id.masalawaffers);
        gulabjamun=(Switch)findViewById(R.id.gulabjamun);
        moonghalwa=(Switch)findViewById(R.id.moonghalwa);
        icecream=(Switch)findViewById(R.id.icecream);
        sweets=(Switch)findViewById(R.id.sweets);

        upload=(Button)findViewById(R.id.upload);

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog=new ProgressDialog(UploadMenu.this);
                progressDialog.setTitle("Loading...");
                progressDialog.setCancelable(false);
                progressDialog.show();
                ArrayList<String> list = new ArrayList<String>();

                if(moongdal.isChecked())
                {
                    list.add("Moong Dal");
                }
                if(daltadka.isChecked())
                {
                    list.add("Dal Tadka");
                }if(tuardal.isChecked())
                {
                    list.add("Tuar Dal");
                }if(chanadal.isChecked())
                {
                    list.add("Chana Dal");
                }if(rajma.isChecked())
                {
                    list.add("Rajma");
                }
                if(sevcurry.isChecked())
                {
                    list.add("Sev Curry ");
                }if(aloosabji.isChecked())
                {
                    list.add("Aloo Sabji");
                }if(paneergravy.isChecked())
                {
                    list.add("Paneer Sabji");
                }if(vegbiryani.isChecked())
                {
                    list.add("Veg Biryani");
                }if(plainrice.isChecked())
                {
                    list.add("Plain Rice");
                }if(jeerarice.isChecked())
                {
                    list.add("Jeera Rice");
                }if(nonverbiryani.isChecked())
                {
                    list.add("Nonveg Biryani");
                }if(plainroti.isChecked())
                {
                    list.add("Plain Roti");
                }if(stuffedparatha.isChecked())
                {
                    list.add("Stuffed Paratha");
                }if(tandoorinaan.isChecked())
                {
                    list.add("Tandoori Naan");
                }if(alooparatha.isChecked())
                {
                    list.add("Aloo Paratha ");
                }if(eggcurry.isChecked())
                {
                    list.add("Egg Curry");
                }if(curry.isChecked())
                {
                    list.add("Curry");
                }if(chickencurry.isChecked())
                {
                    list.add("Chicken Curry");
                }if(fishfry.isChecked())
                {
                    list.add("Fish Fry");
                }if(greensalid.isChecked())
                {
                    list.add("Green Salid");
                }if(grainsalid.isChecked())
                {
                    list.add("Grain Salid");
                }if(tomatosoup.isChecked())
                {
                    list.add("Tomato Soup");
                }if(soup.isChecked())
                {
                    list.add("Soup");
                }if(masalapapad.isChecked())
                {
                    list.add("Masala Papad");
                }
                if(kurkure.isChecked())
                {
                    list.add("Kurkure");
                }if(papad.isChecked())
                {
                    list.add("Papad");
                }if(masalawaffers.isChecked())
                {
                    list.add("Masala Waffers");
                }if(gulabjamun.isChecked())
                {
                    list.add("Gulab Jamun");
                }if(moonghalwa.isChecked())
                {
                    list.add("Moong Dal Halwa");
                }if(icecream.isChecked())
                {
                    list.add("icecream");
                }if(sweets.isChecked())
                {
                    list.add("Sweets");
                }

                startuploading(list);
            }
        });



    }

    private void startuploading(ArrayList<String> list) {
        RetrofitInterface retrofitInterface=retrofit.create(RetrofitInterface.class);
        Intent i=getIntent();
        String token=i.getStringExtra("token");
        Call<Model> call=retrofitInterface.upload(list,token);
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
                if(model.getMsg().equals("uploaded")){
                    //  progressDialog.cancel();
//                    new AlertDialog.Builder(UploadMenu.this).setTitle("User Created Successfully")
//                            .setMessage("Please Login to Continue")
//                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialogInterface, int i) {
//                                    Intent intent=new Intent(UploadMenu.this,SignIn.class);
//                                    startActivity(intent);
//                                    finish();
//                                }
//                            }).show();
                    Toast.makeText(UploadMenu.this,"Menu uploaded successfully",Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(UploadMenu.this,MainActivity.class);
                    startActivity(i);
                }
                else
                {
                    // progressDialog.dismiss();
                    Toast.makeText(UploadMenu.this, "Some Error occured, Please try Again After Some Time! ", Toast.LENGTH_SHORT).show();
                }}

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(UploadMenu.this, "Error !!!!!!", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
