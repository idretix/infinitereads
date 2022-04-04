package com.example.infinitereads.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            UserRepository repository){
        return args->{
/*           Users user1 = new Users(
                    "U1",
                    "P1",
                    "e1@e.com"
            );
            Users user2 = new Users(
                    "U2",
                    "P2",
                    "e2@e.com"
            );
            repository.saveAll(List.of(user1,user2));*/
        };
    }
}
