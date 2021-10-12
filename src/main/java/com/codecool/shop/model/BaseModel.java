package com.codecool.shop.model;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class BaseModel {

    protected int id;
    protected String name;
    protected String description;
//    private BufferedImage img;
//    private int imgNumber;
//    ArrayList<BufferedImage> imgs = new ArrayList<>();

    public BaseModel(String name) {
        this.name = name;
    }

    public BaseModel(String name, String description) {
        this.name = name;
        this.description = description;
//        this.imgNumber = img;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public BufferedImage getImg() {
//        return img;
//    }
//
//    public void setImg(BufferedImage img) {
//        this.img = img;
//    }
//
//    public ArrayList<BufferedImage> getImgs() {
//        return imgs;
//    }
//
//    public void imgSelector(int number){
//        try {
//            img = ImageIO.read(new File("product_"+number+".jpg"));
//            imgs.add(img);
//        } catch (IOException e) {
//        }
//    }
//    public void setUpImgs(){
//        for(int i=0; i<4;i++){
//            imgSelector(i);
//        }
//    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (Field field : this.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value = null;
            try {
                value = field.get(this);
                if (value != null) {
                    sb.append(field.getName() + ":" + value + ",");
                }
            } catch (IllegalAccessException e) {

            }
        }
        return sb.toString();
    }

}
