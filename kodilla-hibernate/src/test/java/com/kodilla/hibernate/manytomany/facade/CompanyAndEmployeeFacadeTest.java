package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest

public class CompanyAndEmployeeFacadeTest {
    @Autowired
    CompanyAndEmployeeFacade companyAndEmployeeFacade;
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void testFindCompanyByNameFragment() {
        //Given
        Company company1 = new Company("ABC Company");
        Company company2 = new Company("the ABC group");
        Company company3 = new Company("DEF company");
        companyDao.save(company1);
        companyDao.save(company2);
        companyDao.save(company3);
        //When
        List<Company> foundCompanies1 = companyAndEmployeeFacade.findCompanyByNameFragment("comp");
        List<Company> foundCompanies2 = companyAndEmployeeFacade.findCompanyByNameFragment("abc");
        List<Company> foundCompanies3 = companyAndEmployeeFacade.findCompanyByNameFragment("zyx");
        //Then
        Assert.assertEquals(2, foundCompanies1.size());
        Assert.assertEquals(2, foundCompanies2.size());
        Assert.assertEquals(0, foundCompanies3.size());

        //CleanUp
        companyDao.delete(company1);
        companyDao.delete(company2);
        companyDao.delete(company3);
    }

    @Test
    public void testFindEmployeeByLastnameFragment() {
        //Given
        Employee employee1 = new Employee("John", "Smith");
        Employee employee2 = new Employee("Cristine", "Smither");
        Employee employee3 = new Employee("Gregory", "Track");
        employeeDao.save(employee1);
        employeeDao.save(employee2);
        employeeDao.save(employee3);

        //When
        List<Employee> foundEmployees1 = companyAndEmployeeFacade.findEmployeeByLastnameFragment("mit");
        List<Employee> foundEmployees2 = companyAndEmployeeFacade.findEmployeeByLastnameFragment("rac");
        List<Employee> foundEmployees3 = companyAndEmployeeFacade.findEmployeeByLastnameFragment("xyz");

        //Then
        Assert.assertEquals(2, foundEmployees1.size());
        Assert.assertEquals(1, foundEmployees2.size());
        Assert.assertEquals(0, foundEmployees3.size());

        //CleanUp
        employeeDao.delete(employee1);
        employeeDao.delete(employee2);
        employeeDao.delete(employee3);
    }
}