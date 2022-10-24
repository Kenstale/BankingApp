package com.example.BankingApp.embedable;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;
import javax.validation.constraints.Positive;
import javax.validation.constraints.NotNull;

public class Money {
    private Currency currency;
    private static final Currency EUR = Currency.getInstance("EUR");
    private static final RoundingMode DEFAULT_ROUNDING = RoundingMode.HALF_EVEN;

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @NotNull(message = "Amount required")
    @Positive(message = "Amount can't be negative")
    private BigDecimal amount;

    public Money(BigDecimal amount, Currency currency, RoundingMode rounding){
        this.currency = currency;
        setAmount(amount.setScale(currency.getDefaultFractionDigits(), rounding));
    }

    //contructor para especificar amount y currency usa el DEFAULT_ROUNDING
    public Money(BigDecimal amount, Currency currency){this(amount, currency, DEFAULT_ROUNDING);}

    //constuctor para definir amount que usa el RoundingMode por defecto y currency EUR
    public Money(BigDecimal amount){this(amount, EUR, DEFAULT_ROUNDING);}

    public BigDecimal increaseAmount(Money money){
        setAmount(this.amount.add(money.amount));
        return this.amount;
    }
    public BigDecimal increaseAmount(BigDecimal addAmount){
        setAmount(this.amount.add(addAmount));
        return this.amount;
    }

    public BigDecimal decreaseAmount(BigDecimal addAmount){
        setAmount(this.amount.subtract(addAmount));
        return this.amount;
    }
    private void setAmount(BigDecimal setScale) {
    }

    public String toString() {
        return getCurrency().getSymbol() + " " + getAmount();
    }
}
