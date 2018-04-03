package com.kodilla.hibernate.invoice.dao;


import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemDaoTestSuite {

    @Autowired
    private ItemDao itemDao;

    @Test
    public void testSaveItem() {
        // Given
        Product product1 = new Product("name of product 1");
        Product product2 = new Product("name of product 2");

        Item item1 = new Item(product1, new BigDecimal(25), 3);

        // When
        itemDao.save(item1);
        int item1Id = item1.getId();

        // Then
        Assert.assertNotEquals(0, item1Id);

        // CleanUp
//        itemDao.delete(item1Id);
    }
}
