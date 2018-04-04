package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest

public class EmployeeDaoTestSuite {
    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void testRetrievingEmployeesWithLastnameEquals() {
        // Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee elizabethSmith = new Employee("Elizabeth", "Smith");
        Employee johnKovalsky = new Employee("John", "Kovalsky");

        employeeDao.save(johnSmith);
        employeeDao.save(elizabethSmith);
        employeeDao.save(johnKovalsky);

        // When
        List<Employee> retrievedEmployees = employeeDao.retrieveEmployeesWithLastnameEquals("Smith");

        // Then
        Assert.assertEquals(2, retrievedEmployees.size());

        // CleanUp
        employeeDao.delete(johnSmith);
        employeeDao.delete(elizabethSmith);
        employeeDao.delete(johnKovalsky);
    }
}