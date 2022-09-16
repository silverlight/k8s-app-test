package com.example.remotecallb.api;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(url = "127.0.0.1:18081/remote-b")
public interface BRemoteApi {

    String helloWorld();
}
