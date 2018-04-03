package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductDaoTestSuite {

    @Autowired
    ProductDao productDao;

    @Test
    public void testSaveProduct() {
        //Given
        Product product = new Product("name of product 1");

        // When
        productDao.save(product);
        int productId = product.getId();

        // Then
        Assert.assertNotEquals(0, productId);

        // CleanUp
       // productDao.delete(productId);
    }
}