package org.example.payment;

import org.example.model.PaymentResult;

public class CryptoPayment extends PaymentMethod {
    private final String walletAddress;

    public CryptoPayment(String walletAddress) {
        super("Crypto");
        this.walletAddress = walletAddress;
    }

    @Override
    public PaymentResult processPayment(double amount) {
        return new PaymentResult(true, "Paid " + amount + " using Crypto");
    }
}
