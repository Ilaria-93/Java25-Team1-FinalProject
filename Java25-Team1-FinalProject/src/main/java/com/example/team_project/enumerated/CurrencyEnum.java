package com.example.team_project.enumerated;

public enum CurrencyEnum {

    EURO("€"),
    DOLLAR("$"),
    POUND("£"),
    YEN("¥"),
    SWISS_FRANC("CHF"),
    CANADIAN_DOLLAR("C$"),
    AUSTRALIAN_DOLLAR("A$"),
    CHINESE_YUAN("¥"),
    INDIAN_RUPEE("₹"),
    RUSSIAN_RUBLE("₽");

    private final String symbol;

    CurrencyEnum(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
