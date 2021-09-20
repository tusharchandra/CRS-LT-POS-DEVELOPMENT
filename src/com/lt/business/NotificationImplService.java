package com.lt.business;

import com.lt.constants.PaymentMode;
import com.lt.dao.PaymentDAOImpl;
import com.lt.dao.PaymentDAOInterface;

public class NotificationImplService implements NotificationInterface
{
	PaymentDAOInterface daoPayment = new PaymentDAOImpl();
	
	@Override
	public String getNotify() 
	{
		return  "Payment Successful";
	}

	@Override
	public boolean sendNotification(int studentId, PaymentMode mode, double fee) {
		if(daoPayment.payment(studentId, mode, fee)) {
			return true;
		}
		return false;
		
	}

}
