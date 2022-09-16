package com.example.remotecalla.api;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient
public interface ARemoteApi {

    String helloWorld();
}
