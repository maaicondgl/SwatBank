package br.com.maaicondgl.apirestfull.CodeChallengeSwat.Service;

import java.util.List;
import java.util.Optional;

import br.com.maaicondgl.apirestfull.CodeChallengeSwat.Exceptions.ResourceNotFoundException;
import br.com.maaicondgl.apirestfull.CodeChallengeSwat.Model.ClienteEntity;

public interface ClienteService {
    List<ClienteEntity> customerList();

    Optional<ClienteEntity> searchCustomer(String cpf);

    ClienteEntity createCustomer(ClienteEntity cliente);

    ClienteEntity updateCustomer(ClienteEntity cliente) throws ResourceNotFoundException;

    void deletarClientePorCpf(String cpf);
}
