package com.deva.employeeProducer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {

    private String empId;
    private String name;
    private String designation;
    private double Salary;
}
