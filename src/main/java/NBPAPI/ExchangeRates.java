package NBPAPI;


import lombok.Data;

@Data
public class ExchangeRates {
    protected String table;
    protected String currency;
    protected Rates[] rates;


}
