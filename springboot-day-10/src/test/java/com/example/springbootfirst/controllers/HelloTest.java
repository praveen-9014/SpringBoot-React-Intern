package com.example.springbootfirst.controllers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloTest {
    @Test
    public void tesHelloTest(){
        Hello hello = new Hello();
        String str = hello.helloTest();
        System.out.println(str);
        assertEquals("Hello test", str);
    }
}
