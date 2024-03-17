package org.example.sec03;

import org.example.generated.sec03.Credentials;
import org.example.generated.sec03.Email;
import org.example.generated.sec03.Phone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec08Oneof {
    private static final Logger log = LoggerFactory.getLogger(Lec08Oneof.class);

    public static void main(String[] args) {
        var email = Email.newBuilder().setAddress("teste@gmail.com").setPassword("1234").build();
        var phone = Phone.newBuilder().setNumber(1234).setCode(12).build();

//        login(Credentials.newBuilder().setEmail(email).build());
//        login(Credentials.newBuilder().setPhone(phone).build());
        login(Credentials.newBuilder().setEmail(email).setPhone(phone).build());
    }

    private static void login(Credentials credentials) {
        switch (credentials.getLoginTypeCase()) {
            case EMAIL -> log.info("email -> {}", credentials.getEmail());
            case PHONE -> log.info("phone -> {}", credentials.getPhone());
        }
    }
}
