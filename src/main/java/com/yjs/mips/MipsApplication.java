package com.yjs.mips;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class MipsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MipsApplication.class, args);
    }

}
