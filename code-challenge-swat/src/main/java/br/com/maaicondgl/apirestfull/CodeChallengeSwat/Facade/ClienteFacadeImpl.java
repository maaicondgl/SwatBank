package br.com.maaicondgl.apirestfull.CodeChallengeSwat.Facade;

import java.util.List;
import java.util.Optional;

import br.com.maaicondgl.apirestfull.CodeChallengeSwat.Exceptions.ResourceNotFoundException;
import br.com.maaicondgl.apirestfull.CodeChallengeSwat.Model.ClienteEntity;
import br.com.maaicondgl.apirestfull.CodeChallengeSwat.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteFacadeImpl implements ClienteFacade {
    @Autowired
    private final ClienteService clienteService;

    @Autowired
    public ClienteFacadeImpl(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Override
    public List<ClienteEntity> customerList() {
        return clienteService.customerList();
    }

    @Override
    public Optional<ClienteEntity> searchCustomer(String cpf) {
        return clienteService.searchCustomer(cpf);
    }

    @Override
    public ClienteEntity createCustomer(ClienteEntity cliente) {
        return clienteService.createCustomer(cliente);
    }

    @Override
    public ClienteEntity updateCustomer(ClienteEntity cliente) throws ResourceNotFoundException {
        return clienteService.updateCustomer(cliente);
    }

    @Override
    public void deletarClientePorCpf(String cpf) {
        clienteService.deletarClientePorCpf(cpf);
    }
}
