package com.cleo.interview_preparation;

import reactor.core.publisher.Mono;

public class Person {

    public static void main(String[] args) {
        Mono.just("Deven")
                .map(String::toUpperCase)
                .map(cn->cn+" is a good boy")
                .subscribe(System.out::println);
    }
}
