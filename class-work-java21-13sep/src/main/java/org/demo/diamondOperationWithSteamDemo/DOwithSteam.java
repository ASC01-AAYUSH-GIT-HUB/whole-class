package org.demo.diamondOperationWithSteamDemo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

class Payment{
    private String id;
    private BigDecimal amount;
    private LocalDateTime timeStamp;

    public Payment(String id, BigDecimal amount, LocalDateTime timeStamp) {
        this.id = id;
        this.amount = amount;
        this.timeStamp = timeStamp;
    }
    public String getId() {
        return id;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    @Override
    public String toString(){
        return "payment{id='"+id+"', amount="+amount+", time stamp="+timeStamp+"}";
    }
}


public class DOwithSteam {
    public static void main(String[] args) {
        List<Payment> payments=new ArrayList<>();
        payments.add(new Payment("P01",BigDecimal.valueOf(1029.32),LocalDateTime.now().minusDays(1)));
        payments.add(new Payment("P02",BigDecimal.valueOf(1027.32),LocalDateTime.now().minusDays(2)));
        payments.add(new Payment("P03",BigDecimal.valueOf(1031.32),LocalDateTime.now().minusDays(0)));
        Comparator<Payment> paymentComparator=new Comparator<Payment>() {
            @Override
            public int compare(Payment o1, Payment o2) {
                return o1.getAmount().compareTo(o2.getAmount());
            }
        };
        Map<String,List<Payment>> paymentListMap=new TreeMap<>();
        for(Payment p:payments){
            String dayinweek=p.getTimeStamp().getDayOfWeek().toString();
            if(!paymentListMap.containsKey(dayinweek)){
                paymentListMap.put(dayinweek,new ArrayList<>());
            }
            paymentListMap.get(dayinweek).add(p);
        }
        payments.sort(paymentComparator);

    }
}
