package br.com.maaicondgl.apirestfull.CodeChallengeSwat.Facade;

import java.util.List;
import java.util.Optional;

import br.com.maaicondgl.apirestfull.CodeChallengeSwat.Exceptions.ResourceNotFoundException;

import br.com.maaicondgl.apirestfull.CodeChallengeSwat.Model.ContaBancariaEntity;
import org.springframework.stereotype.Component;

@Component
public interface ContaBancariaFacade {

    List<ContaBancariaEntity> listAccount();

    ContaBancariaEntity ConsultationAccount(String numConta, String numAgencia);

    ContaBancariaEntity accountChange(ContaBancariaEntity contaBancaria);

    ContaBancariaEntity registerAccount(ContaBancariaEntity contaBancaria);

    void deleteContaById(Long idConta);

    ContaBancariaEntity sacarChequeEspecial(String numConta, double valor) throws ResourceNotFoundException;
}
