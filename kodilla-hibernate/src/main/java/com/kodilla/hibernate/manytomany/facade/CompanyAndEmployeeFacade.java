package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyAndEmployeeFacade {
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;

    public List<Company> findCompanyByNameFragment(String fragment) {
        return companyDao.findByNameFragment("%" + fragment + "%");
    }

    public List<Employee> findEmployeeByLastnameFragment(String fragment) {
        return employeeDao.findEmployeeByLastnameFragment("%" + fragment + "%");
    }
}
