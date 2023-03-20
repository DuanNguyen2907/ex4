package com.sapo.edu.demo.classes;

import java.math.BigDecimal;
import java.util.Scanner;

public class Customer {
    private String acctNo;
    private String pin;
    private BigDecimal balance;

    public Customer() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your account number: ");
        this.acctNo = scanner.nextLine();

        System.out.print("Enter your PIN: ");
        this.pin = scanner.nextLine();

        System.out.print("Enter your initial balance: ");
        this.balance = scanner.nextBigDecimal();
    }

    public Customer(String accountNo,String pin,BigDecimal balance) {
        this.acctNo = accountNo;
        this.pin = pin;
        this.balance = balance;
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
