package model;

import java.math.BigDecimal;

/**
 * Created by ivan on 02.04.16.
 */
public class Money {

    private BigDecimal value;
    private String currencyCode;

    public Money() {
    }

    public Money(BigDecimal value, String currencyCode) {
        this.value = value;
        this.currencyCode = currencyCode;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
