package br.com.maaicondgl.apirestfull.CodeChallengeSwat.Service;

import java.util.List;
import java.util.Optional;

import br.com.maaicondgl.apirestfull.CodeChallengeSwat.Exceptions.ResourceNotFoundException;
import br.com.maaicondgl.apirestfull.CodeChallengeSwat.Model.ClienteEntity;
import br.com.maaicondgl.apirestfull.CodeChallengeSwat.Model.ContaBancariaEntity;
import br.com.maaicondgl.apirestfull.CodeChallengeSwat.Repository.ClienteRepository;
import br.com.maaicondgl.apirestfull.CodeChallengeSwat.Repository.ContaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ContaBancariaServiceImpl contaBancariaService;

    @Autowired
    private ContaBancariaRepository contaBancariaRepository;

    public List<ClienteEntity> customerList(){
        return clienteRepository.findAll();
    }

    public Optional<ClienteEntity> searchCustomer(String cpf) {
        return clienteRepository.findById(cpf);
    }

    public ClienteEntity createCustomer(ClienteEntity cliente) {
        // Obtém a conta bancária associada ao cliente
        ContaBancariaEntity contaBancaria = cliente.getContaBancaria();

        // Verifica se a conta bancária está associada ao cliente
        if (contaBancaria != null && contaBancaria.getIdConta() != null) {
            // Obtém a conta bancária do banco de dados usando o ID fornecido
            Optional<ContaBancariaEntity> contaBancariaOptional = contaBancariaRepository.findById(contaBancaria.getIdConta());

            // Verifica se a conta bancária existe no banco de dados
            if (contaBancariaOptional.isPresent()) {
                // Se a conta bancária existir, associe-a ao cliente
                cliente.setContaBancaria(contaBancariaOptional.get());
            }
        }

        // Salva o cliente no banco de dados
        return clienteRepository.save(cliente);
    }

    public ClienteEntity updateCustomer(ClienteEntity cliente) throws ResourceNotFoundException {

        ContaBancariaEntity conta= contaBancariaService.accountChange(cliente.getContaBancaria());

        cliente.setContaBancaria(conta);
        return clienteRepository.save(cliente);
    }

    public void deletarClientePorCpf(String cpf) {
        clienteRepository.deleteByCpf(cpf);
    }
}
