package tests;

import org.springframework.stereotype.Controller;


public class TestController {

    public String hello(String name){
        return String.format("Hello", name);
    }
}
