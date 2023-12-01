package util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static customer.ServicePlan.*;
import customer.Customer;

public class CustomerUtil {

	public static List<Customer> populate(){
		List<Customer> popu1 =new ArrayList<>();
//		ServicePlan plan, int id, String firstName, String lastName, String email, String password,int registrationAmount, LocalDate dob
		popu1.add(new Customer(DIAMOND,101,"ROBIN","SHEK","xyz","12345",4000,LocalDate.parse("2002-10-23")));
		popu1.add(new Customer(GOLD,104,"anjali","sharma","xyz1","12345",2000,LocalDate.parse("2002-10-24")));
		popu1.add(new Customer(SILVER,103,"deepak","jain","xyz2","12345",1000,LocalDate.parse("2002-10-25")));	
		popu1.add(new Customer(DIAMOND,102,"Raj","Shrivas","xyz3","12345",4000,LocalDate.parse("2002-10-26")));	
	
	return popu1;
			}
	
	
}
