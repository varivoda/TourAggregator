package model;

import java.math.BigDecimal;

/**
 * Created by ivan on 02.04.16.
 */
public class Money {

    private java.math.BigDecimal value;
    private String currencyCode;

    public Money() {
    }

    public Money(java.math.BigDecimal value, String currencyCode) {
        this.value = value;
        this.currencyCode = currencyCode;
    }

    public java.math.BigDecimal getValue() {
        return value;
    }

    public void setValue(java.math.BigDecimal value) {
        this.value = value;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
