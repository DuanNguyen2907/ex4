package com.sapo.edu.demo.classes;


import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Profile("local")
@Component
public class PrinterFile implements Printer{

    private static final Logger logger = LoggerFactory.getLogger(PrinterFile.class);

    @Override
    public void loggingMessageFile(String message) {
        logger.info(message);
    }

    @Override
    public void printCustomer(Customer customer) {
        System.out.println("CustomerId: " + customer.getAcctNo());
        System.out.println("Balance: " + customer.getBalance().toString());
        logger.info("CustomerId: " + customer.getAcctNo());
        logger.info("Balance: " + customer.getBalance().toString());
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }
}
