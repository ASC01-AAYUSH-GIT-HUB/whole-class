package org.demo.diamondOperation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Demonstrates the use of the diamond operator (<>) and type inference in Java collections and generics.
 * Highlights improvements introduced in Java 7+ for cleaner and more maintainable code.
 */
public class DiamondOperator {
    public static void main(String[] args) {
        System.out.println("===== Diamond Operator Demo =====");

        // Prior to Java 7, type parameters had to be explicitly specified on both sides:
        // Map<String, Transection> transectionMap = new HashMap<String, Transection>();

        // Since Java 7, the diamond operator (<>) enables type inference on the right-hand side:
        Map<String, List<Transection>> transectionMap = new HashMap<>();

        // Populating the map with currency keys and corresponding transaction lists
        transectionMap.put("Rupee", new ArrayList<>());
        transectionMap.put("USD", new ArrayList<>());

        // Before Java 9, anonymous classes required explicit type parameters:
        // TransectionProcess<Transection> legacyProcess = new TransectionProcess<Transection>() { ... };

        // Modern approach using the diamond operator for anonymous class instantiation
        TransectionProcess<Transection> legacyProcess = new TransectionProcess<>() {
            @Override
            public void process(Transection transection) {
                System.err.println("Processed transaction: " + transection);
            }
        };

        // Adding sample transactions
        transectionMap.get("Rupee").add(new Transection("1", BigDecimal.valueOf(100.4)));
        transectionMap.get("Rupee").add(new Transection("2", BigDecimal.valueOf(900.45)));
        transectionMap.get("USD").add(new Transection("1", BigDecimal.valueOf(10.4)));

        // Filtering and processing transactions with amount > 500 using two different comparison approaches

        // Approach 1: Convert amount to Float for comparison (not recommended for precision)
        transectionMap.get("Rupee").stream()
            .filter(transection -> Float.valueOf(transection.amount().toString()) > 500f)
            .forEach(legacyProcess::process);

        // Approach 2: Use BigDecimal's compareTo for precise numeric comparison (preferred)
        transectionMap.get("Rupee").stream()
            .filter(transection -> transection.amount().compareTo(BigDecimal.valueOf(500f)) > 0)
            .forEach(legacyProcess::process);

        // Both approaches filter and process transactions with amount greater than 500.
    }
}

/**
 * Immutable record representing a transaction with an ID and amount.
 * The record automatically provides implementations for toString, equals, and hashCode.
 */
record Transection(String id, BigDecimal amount) {}

/**
 * Functional interface for processing transactions.
 * @param <T> the type of transaction to process
 */
interface TransectionProcess<T> {
    void process(T transection);
}
