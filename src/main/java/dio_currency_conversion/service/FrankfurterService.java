package dio_currency_conversion.service;

import dio_currency_conversion.model.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@FeignClient(name="frankfurter", url="https://api.frankfurter.dev/v1")
public interface FrankfurterService {

    @GetMapping("latest?base={base}&amount={amount}&symbols={target}")
    CurrencyConversion makeConversion(@PathVariable("base") String base,
                                      @PathVariable("amount") double amount,
                                      @PathVariable("target") String target);

    @GetMapping("/currencies")
    Map<String, String> availableCurrencies();
}
