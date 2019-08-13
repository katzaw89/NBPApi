package NBPAPI;

import lombok.Data;


@Data
public class Rates {

    protected String no;
    protected String effectiveDate;
    protected Double bid;
    protected Double ask;


}