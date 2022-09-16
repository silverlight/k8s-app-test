package com.example.remotecallb.web;

import com.example.remotecallb.api.BRemoteApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/remote-b")
public class WebControllerB implements BRemoteApi {

    @GetMapping("/test")
    public String helloWorld(){
        return "Hello World B!";
    }
}
