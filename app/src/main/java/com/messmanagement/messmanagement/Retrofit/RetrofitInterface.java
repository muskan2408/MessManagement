package com.messmanagement.messmanagement.Retrofit;



import com.messmanagement.messmanagement.util.Model;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface RetrofitInterface {


    @FormUrlEncoded
    @POST("/users/signup2")
    Call<Model> register(@Field(value = "collegeName") String collegename,
            @Field(value = "messName") String messname,
                         @Field(value = "ownerName") String ownername,
                         @Field(value = "mobile") String mobile,
                         @Field(value = "email") String email,
                         @Field(value = "password") String password);

    @FormUrlEncoded
    @POST("/users/signup1")
    Call<Model> registerstudent(@Field(value = "collegeName") String collegename,
                         @Field(value = "name") String name,
                         @Field(value = "mobile") String mobile,
                         @Field(value = "email") String email,
                         @Field(value = "password") String password);



    @FormUrlEncoded
    @POST("/users/login1")
    Call<Model> login1(@Field(value = "email") String email, @Field(value = "password") String pin);

    @FormUrlEncoded
    @POST("/users/login2")
    Call<Model> login2(@Field(value = "email") String email, @Field(value = "password") String pin);
    @FormUrlEncoded
    @POST("/users/upload")
    Call<Model> upload(@Field(value = "list") ArrayList<String> list, @Header("authorization") String token);

}
