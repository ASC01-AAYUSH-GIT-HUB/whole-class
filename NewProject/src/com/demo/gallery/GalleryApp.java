package com.demo.gallery;

class GalleryApp {
    public static void main(String args[]) {
        System.out.println("Welcome to workDen Gallery");

        Photograph hdimage;
        //create a referance then instance
        hdimage = new Photograph();
//        access the class
        //set the name
        hdimage.name = "tree_image";
        System.out.println("Name of the image: " + hdimage.name);
        hdimage.hang();
        hdimage.changeOrientation("Landscape");
        boolean isilluminated = hdimage.illuminate();
        if (isilluminated) {
            System.out.println("Image is illuminated");
        }
        hdimage.autograph("Aayush");

    }
}