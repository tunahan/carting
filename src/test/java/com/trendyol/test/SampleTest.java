package com.trendyol.test;

import com.trendyol.domain.product.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SampleTest {

    static Logger log = LogManager.getLogger(SampleTest.class);

    @BeforeAll
    static void setup() {
        //initiating all the dependicies
    }

    @BeforeEach
    void init() {
        log.info("---");
    }

    @Test
    void firstTest()
    {
        assertTrue(1==1);
//        assertEquals(25,5,"not 25");
    }
    @Test
    void creatingProductTest()
    {
        Product product = new Product();
    }


}
