package com.sapo.edu.demo;

import com.sapo.edu.demo.classes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private ApplicationContext context;

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		Customer customer = new Customer();

		Atm bidvAtm = context.getBean(Atm.class);



		int index = 1;
		BigDecimal depositMoney;
		BigDecimal withDrawMoney;
		while(index != 0){
//			menu
			System.out.println("Options: ");
			System.out.println("1: Display your account.");
			System.out.println("2: Check ATM Info.");
			System.out.println("3: Deposit money.");
			System.out.println("4: Withdraw money.");
			System.out.println("0: Exit.");
			System.out.println("Enter your choice: ");
			if (scanner.hasNext()) {
				index = scanner.nextInt();
			}
			switch (index) {
				case 1:
					System.out.println("==========================================================");
					bidvAtm.displayCustomerInfo(customer);
                    System.out.println("==========================================================");
					break;
				case 2:
					System.out.println("==========================================================");
					bidvAtm.printCurrentMoney();
                    System.out.println("==========================================================");
					break;
				case 3:
					System.out.println("==========================================================");
					System.out.println("The amount you want to send:");
					depositMoney = scanner.nextBigDecimal();
					bidvAtm.deposit(customer,depositMoney);
                    System.out.println("==========================================================");
					break;
				case 4:
					System.out.println("==========================================================");
					System.out.println("The amount you want to withdraw:");
					withDrawMoney = scanner.nextBigDecimal();
					bidvAtm.withDraw(customer,withDrawMoney);
                    System.out.println("==========================================================");
					break;
			}
		}

	}
}
