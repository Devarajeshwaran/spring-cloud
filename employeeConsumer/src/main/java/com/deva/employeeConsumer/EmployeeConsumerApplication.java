package com.deva.employeeConsumer;

import java.io.IOException;

import com.deva.employeeConsumer.controller.EmployeeConsumerController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;

@SpringBootApplication
public class EmployeeConsumerApplication {

    public static void main(String[] args) throws RestClientException, IOException {
        ApplicationContext ctx = SpringApplication.run(
                EmployeeConsumerApplication.class, args);

        EmployeeConsumerController consumerControllerClient=ctx.getBean(EmployeeConsumerController.class);
        System.out.println(consumerControllerClient);
//        consumerControllerClient.getEmployee();
        for(int i=0;i<100;i++)
            consumerControllerClient.getEmployee();

    }

    @Bean
    public  EmployeeConsumerController  employeeConsumerController()
    {
        return  new EmployeeConsumerController();
    }
}
