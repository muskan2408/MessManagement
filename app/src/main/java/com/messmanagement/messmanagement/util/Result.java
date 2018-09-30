package com.messmanagement.messmanagement.util;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result implements Parcelable {
    @SerializedName("messname")
    @Expose
    private String messname;
    @SerializedName("ownername")
    @Expose
    private String owneranme;
    @SerializedName("mobileno")
    @Expose
    private String mobile;

    public String getMessname() {
        return messname;
    }

    public void setMessname(String messname) {
        this.messname = messname;
    }

    public String getOwneranme() {
        return owneranme;
    }

    public void setOwneranme(String owneranme) {
        this.owneranme = owneranme;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    protected Result(Parcel in) {
        messname = in.readString();
        owneranme = in.readString();
        mobile = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(messname);
        dest.writeString(owneranme);
        dest.writeString(mobile);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Result> CREATOR = new Creator<Result>() {
        @Override
        public Result createFromParcel(Parcel in) {
            return new Result(in);
        }

        @Override
        public Result[] newArray(int size) {
            return new Result[size];
        }
    };
}
