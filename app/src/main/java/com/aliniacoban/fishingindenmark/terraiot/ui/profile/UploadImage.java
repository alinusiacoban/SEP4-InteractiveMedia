package com.aliniacoban.fishingindenmark.terraiot.ui.profile;


/////////////////////////////////////
//                                //
//Whole class is written by Alin  //
//                                //
////////////////////////////////////
public class UploadImage {

    private String mImageUrl;

    public UploadImage(){
        //empty constructor needed
    }

    public UploadImage(String mImageUrl)
    {
        this.mImageUrl=mImageUrl;
    }

    public String getmImageUrl(){
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl)
    {
        this.mImageUrl = mImageUrl;
    }
}
