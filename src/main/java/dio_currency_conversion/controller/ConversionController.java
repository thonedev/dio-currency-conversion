package dio_currency_conversion.controller;

import dio_currency_conversion.dto.ConversionRequest;
import dio_currency_conversion.dto.ConversionResponse;
import dio_currency_conversion.service.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("conversion")
public class ConversionController {

    private final ConversionService conversionService;

    public ConversionController(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @PostMapping
    public ResponseEntity<ConversionResponse> makeConversion(@RequestBody ConversionRequest request){
        return ResponseEntity.ok(conversionService.convert(request));
    }

    @GetMapping
    public ResponseEntity<List<ConversionResponse>> get(){
        return ResponseEntity.ok(conversionService.listAll());
    }

    @GetMapping("/availableCurrencies")
    public ResponseEntity<Map<String, String>> listAvailableCurrencies(){
        return ResponseEntity.ok(conversionService.listAvailableCurrencies());
    }
}
