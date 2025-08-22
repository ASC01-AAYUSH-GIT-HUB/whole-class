package org.demo.java21.m2steamapienhancements;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class ModernSteamApiDemo {
    public static void main(String[] args) {
        List<Transaction> transactions= Arrays.asList(
            new Transaction("T1", BigDecimal.valueOf(100)),
            new Transaction("T2", BigDecimal.valueOf(200)),
            new Transaction("T3", BigDecimal.valueOf(300))
        );
        System.out.println("==============small transaction=============");
//        transactions.stream().takeWhile(t->t.getAmount().compareTo(BigDecimal.valueOf(400))<0).forEach(System.out::println);
        Predicate<Transaction> predicatewithconcreteimplementation=new MyPredicateImplementation();
        boolean status=predicatewithconcreteimplementation.test(new Transaction("T4",BigDecimal.valueOf(400.43)));


    }
}
class MyPredicateImplementation implements Predicate<Transaction>{
    public boolean test(Transaction transaction){
        return transaction.getAmount().compareTo(BigDecimal.valueOf(400))<0;
    }


}
class Transaction{
    private final String id;
    private final BigDecimal amount;

    public Transaction(String id, BigDecimal amount) {
        this.id = id;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String toString(){
        return "Transaction{"+
                "amount="+amount+
                ", id='"+id+'\''+
                '}';
    }
}
