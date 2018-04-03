package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    InvoiceDao invoiceDao;

    @Test
    public void testSaveInvoice() {
        // Given
        Product product1 = new Product("name of product 1");
        Product product2 = new Product("name of product 2");
        Item item1 = new Item(product1, new BigDecimal(25), 4);
        Item item2 = new Item(product1, new BigDecimal(20), 10);
        Item item3 = new Item(product2, new BigDecimal(30), 1);
        Invoice invoice = new Invoice("12345");
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);


        // When
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();

        // Then
        Assert.assertNotEquals(0, invoiceId);
//        Assert.assertEquals(2, product1.getItems().size()); // ??

        // CleanUp
        try {
//            invoiceDao.delete(invoiceId);
        } catch (Exception e) {
            // do nothing
        }
    }

    @Test
    public void testFindByNumber() {
        // Given
        Product product1 = new Product("name of product 1");
        Product product2 = new Product("name of product 2");
        Item item1 = new Item(product1, new BigDecimal(25), 4);
        Item item2 = new Item(product1, new BigDecimal(20), 10);
        Item item3 = new Item(product2, new BigDecimal(30), 1);
        Invoice invoice = new Invoice("12345");
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);

        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();

        // When
        List<Invoice> invoices = invoiceDao.findByNumber("12345");

        // Then
        Assert.assertEquals(1, invoices.size());

        // CleanUp
        try {
//            invoiceDao.delete(invoiceId);
        } catch (Exception e) {
            // do nothing
        }
    }

}