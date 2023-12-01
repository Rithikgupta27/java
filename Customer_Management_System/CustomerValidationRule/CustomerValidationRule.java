package CustomerValidationRule;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import customer.Customer;
import customer.ServicePlan;
import customerEceptionHandling.customerExceptionHandling;

public class CustomerValidationRule {
static Scanner sc1=new Scanner(System.in);
	public static String checkDupEmail(String newEmail ,List<Customer> customer) throws customerExceptionHandling{
		if(customer.contains(newEmail)) {
			throw new customerExceptionHandling("this Email already have an account ");
		}
		return newEmail;
	}
	
	public static LocalDate validateAndParse(String dob )throws customerExceptionHandling {
		LocalDate temp = LocalDate.parse(dob);
		LocalDate limit = LocalDate.of(2005, 10, 23);
		if(temp.isAfter(limit)) {
			throw new customerExceptionHandling("below 18 year");
		}
		return temp;
	}
	
	public static boolean checkRegAmt(int regAmt) throws customerExceptionHandling{
		if(regAmt<500) {
			throw new customerExceptionHandling(" registrstion amounnt less than 500");
		}else if(regAmt >500) {
			System.out.println("registration succesfull");
		}		
			return true;
	}
	
	
	public static ServicePlan validateAndParsePlan(String plan,int  regAmt) throws IllegalArgumentException, customerExceptionHandling {
		String plan1=plan.toUpperCase();
		ServicePlan temp=ServicePlan.valueOf(plan1);
		if(temp.getPlan()== regAmt) {
		return temp;
		}
		throw new customerExceptionHandling("registration amount invalid");
		}
	
	public static Customer validateAllInput(int nId,String fName,String lName,String nEmail,String nPassword,
			int regAmt,String dob,List<Customer> customer)throws customerExceptionHandling
	{  
	
		checkDupEmail(nEmail, customer);
		LocalDate db=validateAndParse(dob);
		checkRegAmt(regAmt);
		System.out.println("Select your plan\n");
		System.out.println("silver-1000\ngold-2000 \nplatinum-3000\ndiamond-4000 ");
		System.out.println("Enter plan:");
//		String pl=checkPlan(sc1.nextInt());
		ServicePlan plan1= validateAndParsePlan(sc1.next(),regAmt);
		Customer c1=new Customer(plan1,nId,fName,lName,nEmail,nPassword,regAmt,db);
		return c1;
	}		

public static int checkEmail(String nEmail,List<Customer> customer) throws customerExceptionHandling {
	Customer temp = new Customer(nEmail);
	int index = customer.indexOf(temp);
	System.out.println("checking email......."  + index);
	{
		if(index==-1) {
			throw new customerExceptionHandling("email not found");
		}
	return index;
	}
}

public static Customer checkPassword(String nPassword,int index,List<Customer> customer)throws customerExceptionHandling {
	Customer temp=customer.get(index);
	if(temp.getPassword()==nPassword) {
		return temp;
	}
	throw new customerExceptionHandling("password invalid");
	
}
	
	
public static Customer signIn(String nEmail,String nPassword,List<Customer> customer) throws customerExceptionHandling {
	int index=checkEmail(nEmail, customer);
	Customer temp=checkPassword(nPassword,index,customer);
	
	return temp;
	
}

}