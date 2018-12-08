package com.deva.employeeProducer.controller;

import com.deva.employeeProducer.model.Employee;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @GetMapping("/employee")
    @HystrixCommand(fallbackMethod = "getDataFallBack")
    public Employee firstPage() {

        System.out.println("Inside firstPage");

        Employee emp = new Employee();
        emp.setName("emp1");
        emp.setDesignation("manager");
        emp.setEmpId("1");
        emp.setSalary(3000);

        if(emp.getName().equalsIgnoreCase("emp1"))
            throw new RuntimeException();

        return emp;
    }

    public Employee getDataFallBack() {

        System.out.println("Inside fallback");

        Employee emp = new Employee();
        emp.setName("fallback-emp1");
        emp.setDesignation("fallback-manager");
        emp.setEmpId("fallback-1");
        emp.setSalary(3000);

        return emp;

    }

}
