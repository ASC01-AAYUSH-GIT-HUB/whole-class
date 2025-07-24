package com.demo.gallery;

public class Photograph {
    byte frameWidth;
    String name;
    String colorPhoto;
    String frameMaterial;

    void hang() {
        System.out.println("Hang on the wall");
    }

    void changeOrientation(String orientation) {

        System.out.println("orientation is changed to:" + orientation);
    }

    boolean illuminate() {
        System.out.println("Switched on!");
        return true;
    }

    void autograph(String sign) {
        System.out.println("Autograph on image:" + sign);
    }
}
