package org.example.sec03;

import org.example.generated.sec03.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec01Scalar {
    private static final Logger log = LoggerFactory.getLogger(Lec01Scalar.class);

    public static void main(String[] args) {
        var person = Person.newBuilder()
                .setLastName("sam")
                .setAge(21)
                .setEmail("otavio.abreu96@gmail.com")
                .setEmployed(true)
                .setSalary(3000.34)
                .setBankAccountNumber(1234231312)
                .setBalance(-10000)
                .build();

        log.info("{}", person);
    }
}
