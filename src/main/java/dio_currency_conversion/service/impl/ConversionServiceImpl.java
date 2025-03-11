package dio_currency_conversion.service.impl;

import dio_currency_conversion.dto.ConversionRequest;
import dio_currency_conversion.dto.ConversionResponse;
import dio_currency_conversion.model.Client;
import dio_currency_conversion.repository.CurrencyConversionRepository;
import dio_currency_conversion.service.ClientService;
import dio_currency_conversion.service.ConversionService;
import dio_currency_conversion.service.FrankfurterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ConversionServiceImpl implements ConversionService {

    private ClientService clientService;
    private CurrencyConversionRepository currencyConversionRepository;
    private FrankfurterService frankfurterService;

    @Autowired
    public ConversionServiceImpl(ClientService clientService,
                                 CurrencyConversionRepository currencyConversionRepository,
                                 FrankfurterService frankfurterService) {
        this.clientService = clientService;
        this.currencyConversionRepository = currencyConversionRepository;
        this.frankfurterService = frankfurterService;
    }

    @Override
    public ConversionResponse convert(ConversionRequest request) {
        var conversion = frankfurterService.makeConversion(request.getBase(), request.getAmount(), request.getTarget());

        conversion.setAmount(request.getAmount());
        conversion.setTarget(request.getTarget());
        conversion.setTargetAmount(conversion.getRates().get(request.getTarget()));


        currencyConversionRepository.save(conversion);
        var client = new Client();
        client.setName(request.getName());
        client.setCurrencyConversion(conversion);
        clientService.add(client);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(conversion.getDate(), formatter);

        return new ConversionResponse(
                request.getAmount(),
                request.getBase(),
                conversion.getTargetAmount(),
                request.getTarget(),
                date,
                client.getName());
    }

    @Override
    public Map<String, String> listAvailableCurrencies() {
        return frankfurterService.availableCurrencies();
    }

    @Override
    public List<ConversionResponse> listAll() {
        var clientsConversions = clientService.findAll();
        List<ConversionResponse> conversions = new ArrayList<>();
        clientsConversions.forEach(c -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(c.getCurrencyConversion().getDate(), formatter);

            conversions.add(new ConversionResponse(
                    c.getCurrencyConversion().getAmount(),
                    c.getCurrencyConversion().getBase(),
                    c.getCurrencyConversion().getTargetAmount(),
                    c.getCurrencyConversion().getTarget(),
                    date,
                    c.getName()));
        });

        return conversions;
    }


}
