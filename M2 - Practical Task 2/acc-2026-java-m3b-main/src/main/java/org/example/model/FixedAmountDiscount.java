package org.example.model;

public class FixedAmountDiscount extends Discount {
    // TODO
    // 'apply' formula: Math.max(0,originalAmount - amount)

    private final double amount;

    public FixedAmountDiscount(String code, double amount) {
        super(code);
        this.amount = amount;
    }

    @Override
    public double apply(double originalAmount) {
        return Math.max(0, originalAmount - amount);
    }

}
