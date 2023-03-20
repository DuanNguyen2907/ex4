package com.sapo.edu.demo.classes;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("aws")
public class PrinterConsole implements Printer{

    @Override
    public void loggingMessageFile(String massage) {

    }

    @Override
    public void printCustomer(Customer customer) {
    }

    @Override
    public void printMessage(String message) {

    }
}
