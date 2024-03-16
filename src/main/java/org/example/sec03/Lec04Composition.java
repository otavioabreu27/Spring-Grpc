package org.example.sec03;

import com.example.generated.sec03.Address;
import com.example.generated.sec03.School;
import com.example.generated.sec03.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec04Composition {

    public static final Logger log = LoggerFactory.getLogger(Lec04Composition.class);

    public static void main(String[] args) {
        // create student
        var address = Address.newBuilder()
                .setStreet("123 main st")
                .setCity("atlanta")
                .setState("georgia")
                .build();

        var student = Student.newBuilder()
                .setName("sam")
                .setAddress(address)
                .build();

        var school = School.newBuilder()
                .setId(1)
                .setName("school")
                .setAddress(address.toBuilder().setStreet("school street"))
                .build();

        log.info("school: {}", school);
        log.info("student: {}", student);
    }
}
