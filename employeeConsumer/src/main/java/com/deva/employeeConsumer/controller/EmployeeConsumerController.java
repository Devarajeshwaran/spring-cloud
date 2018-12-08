package com.deva.employeeConsumer.controller;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

public class EmployeeConsumerController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    public void getEmployee() throws RestClientException, IOException {

        ServiceInstance serviceInstance=loadBalancerClient.choose("employee-producer");

        System.out.println(serviceInstance.getUri());

        String baseUrl=serviceInstance.getUri().toString();

        baseUrl = baseUrl + "/employee";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response=null;
        try{
            response=restTemplate.exchange(baseUrl,
                    HttpMethod.GET, getHeaders(),String.class);
        }catch (Exception ex)
        {
            System.out.println(ex);
        }
        System.out.println(response.getBody());
    }

    private static HttpEntity<?> getHeaders() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        return new HttpEntity<Object>(headers);
    }
}
