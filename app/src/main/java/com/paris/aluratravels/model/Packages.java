package com.paris.aluratravels.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.math.BigDecimal;

public class Packages implements Parcelable {

    private final String city;
    private final String image;
    private final int days;
    private final BigDecimal price;

    public Packages(String city, String image, int days, BigDecimal price) {
        this.city = city;
        this.image = image;
        this.days = days;
        this.price = price;
    }


    private Packages(Parcel in) {
        city = in.readString();
        image = in.readString();
        days = in.readInt();
        price =  new BigDecimal(in.readString());
    }

    public static final Creator<Packages> CREATOR = new Creator<Packages>() {
        @Override
        public Packages createFromParcel(Parcel in) {
            return new Packages(in);
        }

        @Override
        public Packages[] newArray(int size) {
            return new Packages[size];
        }
    };

    public String getCity() {
        return city;
    }

    public String getImage() {
        return image;
    }

    public int getDays() {
        return days;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(city);
        dest.writeString(image);
        dest.writeInt(days);
        dest.writeString(price.toPlainString());
    }
}