package dio_currency_conversion.service.impl;

import dio_currency_conversion.model.Client;
import dio_currency_conversion.repository.ClientRepository;
import dio_currency_conversion.service.ClientService;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public void add(Client client) {
        clientRepository.save(client);
    }
}
