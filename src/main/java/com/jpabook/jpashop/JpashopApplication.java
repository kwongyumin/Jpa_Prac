package com.jpabook.jpashop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpashopApplication {

    public static void main(String[] args) {


        //lombok 테스트
//        Hello hello = new Hello();
//
//        hello.setData("데이터 주입");
//        String data = hello.getData();
//        System.out.println(data);

        SpringApplication.run(JpashopApplication.class, args);

    }


}
