package utils;

import android.graphics.Bitmap;

/**
 * Created by Lucky on 3/25/2017.
 */

public class AddContainer {
    private String mTitle;
    private String mPrice;
    private String mLocation;
    private String mDescription;
    private Bitmap mPicture;

    public AddContainer(String tit, String pri, String loc, String des, Bitmap pic) {
        this.mTitle = tit;
        this.mPrice = pri;
        this.mLocation = loc;
        this.mDescription = des;
        this.mPicture = pic;
    }

    public String[] getTitles(){
        return new String[]{mTitle};
    }
    public String[] getPrices(){
        return new String[]{mPrice};
    }
    public String[] getLocations(){
        return new String[]{mLocation};
    }
    public String[] getDescriptions(){
        return new String[]{mDescription};
    }
    public Bitmap[] getPictures(){
        return new Bitmap[]{mPicture};
    }
    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setPrice(String price) {
        this.mPrice = price;
    }

    public String getPrice() {
        return mPrice;
    }

    public void setLocation(String location) {
        this.mLocation = location;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setPicture(Bitmap pic) {
        this.mPicture = pic;
    }

    public Bitmap getPicture() {
        return mPicture;
    }

}
