package org.example.sec02;

import org.example.generated.sec02.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProtoDemo {
    public static final Logger log = LoggerFactory.getLogger(ProtoDemo.class);

    public static void main(String[] args) {
        // create person1
        var person1 = createPerson("Otavio", 21);

        // create person2
        var person2 = createPerson("Pedro", 22);

        /*
            compare
            log.info("equals {}",  person1.equals(person2));
            log.info("== {}",  (person1 == person2));
        */

        var person3 = person1.toBuilder().setName("teste").build();

        var person4 = person1.toBuilder().clearName().build();
        log.info("person4: {}", person4);

    }

    private static Person createPerson(String name, int age) {
        return Person.newBuilder()
                .setName(name)
                .setAge(age)
                .build();
    }
}
