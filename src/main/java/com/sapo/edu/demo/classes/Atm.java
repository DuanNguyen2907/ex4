package com.sapo.edu.demo.classes;


import java.io.IOException;
import java.math.BigDecimal;


public interface Atm {
    void withDraw(Customer customer, BigDecimal amount) throws IOException;


    void printCurrentMoney() throws IOException;

    void deposit(Customer customer, BigDecimal amount) throws IOException;

    void displayCustomerInfo(Customer customer);
}
