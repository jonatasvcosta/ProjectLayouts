package com.example.taqtile.quitanda;

/**
 * Created by taqtile on 1/13/16.
 */
public class Product {
    private String mName;
    private int mImgId;
    private boolean mClicked;
    public Product(String name, int id, boolean clicked){
        this.mName = name;
        this.mImgId = id;
        this.mClicked = clicked;
    }
    public String getName(){
        return mName;
    }
    public int getImgId(){
        return mImgId;
    }
    public boolean getClicked(){
        return mClicked;
    }
}
