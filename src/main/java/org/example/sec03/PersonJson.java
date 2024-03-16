package org.example.sec03;

public record PersonJson(
        String lastName,
        int age,
        String email,
        boolean employed,
        double salary,
        long bankAccountNumber,
        int balance) {
}
