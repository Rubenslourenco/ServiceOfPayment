package service;

public interface OnlinePaymentService {
	
	double paymentFee(double amount);
	double interes(double amount, int months);

}
