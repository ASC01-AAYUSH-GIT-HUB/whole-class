package com.demo.polimorphismEx;

public class staticPolimorphismEx {
    public static void main(String[] args) {
        Movie m=null;
        m=new Movie();
        m.play();
        m.play("hindi");
    }
}
class Movie{
    public void play(){
        System.out.println("play movie");
    }
    public void play(String subtitles){
        System.out.println("play movie with sub-title:"+subtitles);
    }
}
