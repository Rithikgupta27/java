package util;

import java.util.Comparator;

import customer.Customer;

public class Customercomp implements Comparator<Customer>{

	@Override
	public int compare(Customer c1,Customer c2) {
		int value= c1.getFirstName().compareTo(c2.getFirstName());
		if(value==0) 
			c1.getLastName().compareTo(c2.getLastName());
		
		return value;
	}

}
