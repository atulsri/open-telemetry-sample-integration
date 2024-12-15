package org.example.service;


import org.example.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    public Employee getEmployeeDetails() {
        Employee employee = new Employee();
        employee.setEmployeeId(4343333);
        employee.setEmployeeName("John doe");
        employee.setAddress("california");
        employee.setDepartment("D11");
        employee.setPhone("38383838");
        return employee;
    }
}
