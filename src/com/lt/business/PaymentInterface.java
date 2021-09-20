package com.lt.business;

public interface PaymentInterface {

	

		public void getPayment(int studentId, double fee);//mode,scanner
		public void online(int studentId, double fee);
		public void offline();
		public double calculateFee(int studentId);

	}



