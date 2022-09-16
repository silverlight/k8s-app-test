package com.example.remotecalla.web;

import com.example.remotecalla.AesDynamicProperty;
import com.example.remotecalla.AesEncryption;
import com.example.remotecalla.api.ARemoteApi;
import com.example.remotecallb.api.BRemoteApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/remote-a")
public class WebControllerA implements ARemoteApi {

    @Autowired
    private BRemoteApi bRemoteApi;

    @GetMapping("/test")
    public String helloWorld(){
        return "Hello World A!";
    }

    @GetMapping("/test-a")
    public String helloFeignCall(){
        return bRemoteApi.helloWorld();
    }

    public static void main(String[] args) throws Exception{
        AesEncryption aesEncryption = new AesEncryption();
        // pd加密，解密
        AesDynamicProperty.encryptKey="member@PDEjkIhSD";
        AesDynamicProperty.ivParameterSpecKey="member@OsmTdOWzd";
        System.out.println(aesEncryption.encryptData("83482664"));
        System.out.println(aesEncryption.decryptData("j/C4kL3GpiSvE9ydMf6uUA=="));
    }
}
