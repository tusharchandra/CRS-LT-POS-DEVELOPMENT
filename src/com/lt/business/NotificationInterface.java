package com.lt.business;

import com.lt.constants.PaymentMode;

public interface NotificationInterface {

	public String getNotify();

	public boolean sendNotification(int studentId, PaymentMode mode, double fee);
	
}
