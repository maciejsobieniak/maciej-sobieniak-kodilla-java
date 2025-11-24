package com.kodilla.hibernate.invoice.dao;


import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Autowired
    private ProductDao productDao;

    @Test
    void testInvoiceDaoSave() {
        //Given
        Invoice invoice = new Invoice("2024/06/01");
        Product product1 = new Product("Product 1");
        Product product2 = new Product("Product 2");

        productDao.save(product1);
        productDao.save(product2);

        int idProduct1 = product1.getId();
        int idProduct2 = product2.getId();

        Item item1 = new Item(product1, new BigDecimal(1232), 150, new BigDecimal(1075));
        Item item2 = new Item(product2, new BigDecimal(12323), 211, new BigDecimal(1111));
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        item1.setInvoice(invoice);
        item2.setInvoice(invoice);

        //When
        invoiceDao.save(invoice);
        int id = invoice.getId();

        //Then
        assertNotEquals(0, id);
        assertEquals(2, invoice.getItems().size());

        //CleanUp
        invoiceDao.deleteById(id);
        productDao.deleteById(idProduct1);
        productDao.deleteById(idProduct2);

    }
}
