package dio_currency_conversion.service;

import dio_currency_conversion.dto.ConversionRequest;
import dio_currency_conversion.dto.ConversionResponse;

import java.util.List;
import java.util.Map;

public interface ConversionService {
    ConversionResponse convert(ConversionRequest request);
    Map<String, String> listAvailableCurrencies();
    List<ConversionResponse> listAll();
}