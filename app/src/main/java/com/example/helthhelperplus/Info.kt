package com.example.helthhelperplus


import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable
import java.text.SimpleDateFormat
import android.graphics.Bitmap as Bitmap


class Info(
           val blood: String,
           val height: String,
           val weight: String,
           var allergy: String,
           val chronicDisease: String,
           val lastDisease: String,
           val doctor: String,
           val dr: String,
           val name: String
): Serializable, Parcelable {



    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }



    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(blood)
        parcel.writeString(height)
        parcel.writeString(weight)
        parcel.writeString(allergy)
        parcel.writeString(chronicDisease)
        parcel.writeString(lastDisease)
        parcel.writeString(doctor)
        parcel.writeString(dr)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Info> {
        override fun createFromParcel(parcel: Parcel): Info {
            return Info(parcel)
        }

        override fun newArray(size: Int): Array<Info?> {
            return arrayOfNulls(size)
        }
    }

}