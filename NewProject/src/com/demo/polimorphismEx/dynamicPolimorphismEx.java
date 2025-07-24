package com.demo.polimorphismEx;

import java.util.Random;

public class dynamicPolimorphismEx {
    public static void main(String[] args) {
        Random random = new Random();
        int a=random.nextInt(10);
        Movie1 m=null;
        if (a%2==0){
            m=new Movie1();
            m.play();
        }
    }
}
class Movie1{
    public void play(){
        System.out.println("play movie");
    }
    public void play(String subtitles){
        System.out.println("play movie with sub-title:"+subtitles);
    }
}
class Movie_4K extends Movie1{
    public void play(){
        System.out.println("play movie");
    }
    public void play(String subtitles){
        System.out.println("play movie with sub-title:"+subtitles);
    }
}