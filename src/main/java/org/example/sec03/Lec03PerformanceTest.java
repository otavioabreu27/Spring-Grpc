package org.example.sec03;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.InvalidProtocolBufferException;
import org.example.generated.sec03.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Lec03PerformanceTest {
    private static final Logger log = LoggerFactory.getLogger(Lec03PerformanceTest.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
        var protoPerson = Person.newBuilder()
                .setLastName("sam")
                .setAge(21)
                .setEmail("otavio.abreu96@gmail.com")
                .setEmployed(true)
                .setSalary(3000.34)
                .setBankAccountNumber(1234231312)
                .setBalance(-10000)
                .build();

        var jsonPerson = new PersonJson(
                "sam",
                21,
                "otavio.abreu96@gmail.com",
                true,
                3000.24,
                1234231312,
                -10000);

        json(jsonPerson);
        proto(protoPerson);

//        for (int i = 0; i < 5; i++) {
//            runTest("json", () -> json(jsonPerson));
//            runTest("proto", () -> proto(protoPerson));
//        }
    }

    private static void proto(Person person){
        try {
            var bytes = person.toByteArray();
            log.info("proto bytes length: {}", person.toByteArray().length);
            Person.parseFrom(bytes);
        } catch (InvalidProtocolBufferException e) {
            throw new RuntimeException(e);
        }
    }

    private static void json(PersonJson person){
        try {
            var bytes = mapper.writeValueAsBytes(person);
            log.info("json bytes length: {}", bytes.length);
            mapper.readValue(bytes, PersonJson.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void runTest(String testName, Runnable runnable){
        var start = System.currentTimeMillis();

        for (int i = 0; i < 500_000; i++) {
            runnable.run();
        }

        var end = System.currentTimeMillis();
        log.info("time taken for {} - {}ms", testName, (end - start));
    }
}
