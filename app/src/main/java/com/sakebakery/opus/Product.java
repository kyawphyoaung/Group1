package com.sakebakery.opus;

import android.graphics.drawable.Drawable;

public class Product {

    public String title;
    public Drawable productImage;
    public String flavor;
    public String description;
    public int price;
    public String icing;
    public boolean selected;
    public String side;
    public String filling;

    public Product(String title, Drawable productImage,String flavor,
                   String description,
                   int price, String icing, String side, String filling) {
        this.title = title;
        this.productImage = productImage;
        this.flavor=flavor;
        this.description = description;
        this.price = price;
        this.icing = icing;
        this.side = side;
        this.filling =  filling;

    }

}