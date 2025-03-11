package dio_currency_conversion.service;

import dio_currency_conversion.model.Client;

public interface ClientService {
    Iterable<Client> findAll();

    void add(Client client);
}
