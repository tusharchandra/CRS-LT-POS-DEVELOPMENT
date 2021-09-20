package com.lt.business;

import java.util.Scanner;

import com.lt.client.StudentMenu;
import com.lt.constants.PaymentMode;
import com.lt.dao.PaymentDAOImpl;
import com.lt.dao.PaymentDAOInterface;

public class PaymentImplService implements PaymentInterface {

	NotificationInterface ni = new NotificationImplService();
	PaymentDAOInterface daoPayment = new PaymentDAOImpl();


	@Override
	public void getPayment(int studentId, double fee)
	{
		System.out.println("<-----Choose Payment Mode-------->");
		System.out.println("1.Online"+"\n"+"2.Offline");
		Scanner in = new Scanner(System.in);
		int PaymentMode= in.nextInt();

		switch(PaymentMode)
		{
		case 1: System.out.println("Online:-");
		online(studentId, fee);                 
		break;

		case 2: System.out.println("Offline:-");
		offline();
		break;
		}
	}



	@Override
	public void online(int studentId, double fee) 
	{
		System.out.println("<-----Choose online Mode-------->");
		System.out.println("1.Debit card"+"\n"+"2.Credit card");
		Scanner in = new Scanner(System.in);
		int Mode= in.nextInt();
		PaymentMode mode = PaymentMode.getModeofPayment(Mode);
		switch(Mode)
		{
		case 1: System.out.println("Debit Card:-");
		System.out.println("Enter Debit cardNo.:");
		long CardNo= in.nextLong();
		System.out.println("Enter Debit Card Name.:");
		String Name= in.next();
		System.out.println("Enter Debit CVV.:");
		int CVV= in.nextInt();
		System.out.println("Enter Amount:");
		Double Amount= in.nextDouble();
		if((CardNo!=0 && String.valueOf(CardNo).length()==16) && (Name!= null) && (CVV!= 0)) 
		{

			try 
			{
				if(ni.sendNotification(studentId, mode, fee)) {
					System.out.println("payment Done Sucessfully......");
				}else {
					StudentMenu sm = new StudentMenu();
					sm.doPayment(studentId);
				}
				
			} 
			catch (Exception e) 
			{

				System.out.println(e.getMessage());
			}
		}
		else
		{
			System.out.println("Invalid Card Details, Please Retry");
		}
		break;

		case 2: System.out.println("Credit Card:-");
		System.out.println("Enter Credit cardNo.:");
		long CreditCardNo= in.nextLong();
		System.out.println("Enter Credit Card Name.:");
		String CreditName= in.next();
		System.out.println("Enter Credit CVV.:");
		int CreditCVV= in.nextInt();
		System.out.println("Enter Amount:");
		Double CreditAmount= in.nextDouble();

		if((CreditCardNo!=0 && String.valueOf(CreditCardNo).length()==16) && (CreditName!= null) && (CreditCVV!= 0)) 
		{
			try 
			{
				if(ni.sendNotification(studentId, mode, fee)) {
					System.out.println("payment Done Sucessfully......");
				}else {
					StudentMenu sm = new StudentMenu();
					sm.doPayment(studentId);
				}
				
			} 
			catch (Exception e) 
			{

				System.out.println(e.getMessage());
			}
		}
		else 
		{
			System.out.println("Invalid Card Details, Please Retry");

		}
		break;
		}
	}

	@Override
	public void offline() {
		System.out.println("Please pay cash  to Admin Office");

	}

	@Override
	public double calculateFee(int studentId) {
		return daoPayment.calculateFee(studentId);
	}




}
