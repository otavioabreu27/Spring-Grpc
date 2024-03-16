package org.example.sec03;

import org.example.generated.sec03.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Lec02Serialization {
    private static final Logger log = LoggerFactory.getLogger(Lec02Serialization.class);
    private static final Path PATH = Path.of("person.out");

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

        try {
            serialize(person);
            log.info("{}", deserialize());
            log.info("equals: {}", person.equals(deserialize()));
            log.info("bytes length: {}", person.toByteArray().length);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void serialize(Person person) throws IOException {
        try(var stream = Files.newOutputStream(PATH)) {
            person.writeTo(stream);
        }
    }

    public static Person deserialize() throws IOException {
        try(var stream = Files.newInputStream(PATH)) {
            return Person.parseFrom(stream);
        }
    }
}
