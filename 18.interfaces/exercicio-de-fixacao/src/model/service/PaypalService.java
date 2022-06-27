package model.service;

public class PaypalService implements OnlinePaymentService {
    
    @Override
    public double paymentFee(Double amount) {
        return amount * 0.02;
    }

    @Override
    public double interest(Double amount, Integer months) {
        amount += amount*((double)months/100);
        amount += paymentFee(amount);

        return amount;
    }
}
