package CustomerTester;

import static CustomerValidationRule.CustomerValidationRule.checkEmail;
import static CustomerValidationRule.CustomerValidationRule.signIn;
import static CustomerValidationRule.CustomerValidationRule.validateAllInput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import customer.Customer;
import util.CustomerUtil;
import util.Customercomp;

public class Tester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			List<Customer> customers = new ArrayList<>();

			boolean exit = false;

			while (!exit) {
				System.out.println("press 1 for Sing up\n press 2 for Sing in \n press 3 for PasswordChange  "
						+ "\n press 4 for unsubscribe \n press 5 for display all customer \n press 6 for populate \n press 7 for sorting \npress 8 for sorting by name \npress 9 for remove how have id less than  or equal 103 \n press 0 Exit");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter customer id(int) ,first name, last name (string),"
								+ "email(string),password(string),registrationAmount(double),dob(LocalDate)");
						Customer c1 = validateAllInput(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.next(),
								sc.nextInt(), sc.next(), customers);
						customers.add(c1);
						break;
					case 2:
						System.out.println("enter email,enter password");
						Customer c2 = signIn(sc.next(), sc.next(), customers);

						break;
					case 3:
						System.out.println("enter email,enter password");
						Customer c3 = signIn(sc.nextLine(), sc.nextLine(), customers);
						System.out.println("enter new password");
						c3.setPassword(sc.next());
						break;
					case 4:
						int index = checkEmail(sc.next(), customers);
						customers.remove(index);
						System.out.println("customer Unsubscribe");
						break;
					case 5:
						if (customers == null) {
							System.out.println("nothing to show");
						} else {
							for (Customer arr : customers)
								System.out.println(arr);
						}
						break;
					case 6:
						customers = CustomerUtil.populate();
						System.out.println("populate  done");
						break;
					case 7:
						Collections.sort(customers);
						for (Customer arr : customers) {
							System.out.println(arr);
						}
						break;
					case 8:
//	        		 for(Customer itr1:customers) {
//	        			System.out.println(itr1.getFirstName().toLowerCase());
//	        		 }
						Collections.sort(customers, new Customercomp());
						for (Customer itr : customers) {
							System.out.println(itr);
						}
						break;
					case 9:
						Iterator<Customer> itr = customers.iterator();
						while (itr.hasNext()) {
							itr.next();
							if (itr.next().getId() <= 103) {
								System.out.println("remove id ");
								itr.remove();
							}
							System.out.println(customers);
						}
						break;
					case 0:
						exit = true;
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Invalid exception");
				}
			}
		}

	}
}
