package util;

import java.util.Comparator;

import customer.Customer;

public class CustomerComparator implements Comparator<Customer> {

	@Override
	public int compare(Customer c1,Customer c2) {
		if(c1.getId()>c2.getId()) {
			return -1;
			
		}
		if(c2.getId()>c1.getId())
			return 1;
	return 0;
	
}}
