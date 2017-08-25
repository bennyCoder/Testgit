package com.example.android.system;

import android.media.Image;



public class Items {


  //  private Image itemsPhotos;
//  private int itemsPhotos;
    private String discription;

    public Items()
 {



 }

public  Items(String discription)
{
   // this.itemsPhotos  = itemsPhotos;
        this.discription = discription;
}
//public int getItemsPhotos(){return itemsPhotos;}
   // public void setItemsPhotos(int itemsPhotos){this.itemsPhotos = itemsPhotos;}

    public String getDiscription(){return discription;}
    public void setDiscription(String discription){this.discription = discription;}
}
