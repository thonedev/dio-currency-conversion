package dio_currency_conversion.dto;

import java.time.LocalDate;

public record ConversionResponse (
    double amountBase,
    String base,
    double amountTarget,
    String target,
    LocalDate date,
    String name){}
