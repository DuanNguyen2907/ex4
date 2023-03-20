package com.sapo.edu.demo.classes;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BidvAtm implements Atm{

    @Value("${atm.name}")
    private String name;


    @Value("${atm.price}")
    private BigDecimal moneyAtm;


    @Autowired
    private Printer printer;

    @Override
    public void withDraw(Customer customer, BigDecimal amount) {
        if (amount == null || amount.compareTo(new BigDecimal(0)) < 0) {
            printer.printMessage("Amount is invalid");
            printer.loggingMessageFile("Amount is invalid");
            return;
        }
        if (customer.getBalance().compareTo(amount) < 0) {
            printer.printMessage("Insufficient Balance");
            printer.loggingMessageFile("Insufficient Balance");
            return;
        }
        if (amount.compareTo(moneyAtm) >= 0) {
            printer.printMessage("ATM is out of money");
            printer.loggingMessageFile("ATM is out of money");
            return;
        }

        BigDecimal currentBalance = customer.getBalance();
        customer.setBalance(currentBalance.subtract(amount));
        moneyAtm = moneyAtm.subtract(amount);
        printer.printMessage("Withdraw success!!!!!!");
        printer.loggingMessageFile("Withdraw success: -"+ amount);
    }


    @Override
    public void printCurrentMoney() {
        printer.printMessage("Current ATM is " + name);
        printer.printMessage("Current ATM money is " + moneyAtm.toString());
        printer.loggingMessageFile("Current ATM is " + name);
        printer.loggingMessageFile("Current ATM money is " + moneyAtm.toString());
    }

    @Override
    public void deposit(Customer customer, BigDecimal amount) {
        if (amount == null || amount.compareTo(new BigDecimal(0)) <= 0) {
            printer.printMessage("Amount is invalid");
            printer.loggingMessageFile("Amount is invalid");
            return;
        }

        BigDecimal currentBalance = customer.getBalance();
        customer.setBalance(currentBalance.add(amount));
        moneyAtm = moneyAtm.add(amount);
        printer.printMessage("Deposit success!!!!!!");
        printer.loggingMessageFile("Deposit success: +"+ amount);
    }

    @Override
    public void displayCustomerInfo(Customer customer) {
        printer.printCustomer(customer);
    }
}
