package org.donut.donutProblemLogic;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Solution {
    public static void main(String[] args) {
        List<Donut> donuts= Arrays.asList(
                new Donut(50,"chocolate"),
                new Donut(80,"venial"),
                new Donut(90,"Sprinkle"),
                new Donut(80,"abs")
        );

        System.out.println("==============Donuts under 100================");
        Predicate<Donut> donutPredicate=new DonutRules();
//        boolean status=donutPredicate.test(new Donut(85,"haha"));
//        System.out.println(status);
        donuts.stream().filter(donutPredicate::test).map(donut->donut.getType()).forEach(System.out::println);

//        donuts.stream().takeWhile(donut-> donutPredicate.test(donut)).forEach(System.out::println);

    }

}
class Donut{
    private float price;
    private String type;
    private static float gst=18;

    public Donut(float price, String type) {
        this.price = price;
        this.type = type;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public static float getGst() {
        return gst;
    }
    public static void setGst(float gst) {
        Donut.gst = gst;
    }

    public BigDecimal TotalCost(){
        return BigDecimal.valueOf(price+(gst*price/100));
    }
    public String toString(){
        return type + " (" + TotalCost() + " Rs)";
    }
}
class DonutRules implements Predicate<Donut>{
    @Override
    public boolean test(Donut donut) {
        return donut.TotalCost().compareTo(BigDecimal.valueOf(100)) < 0;
    }
}
