package br.com.maaicondgl.apirestfull.CodeChallengeSwat.Service;

import br.com.maaicondgl.apirestfull.CodeChallengeSwat.Exceptions.ResourceNotFoundException;
import br.com.maaicondgl.apirestfull.CodeChallengeSwat.Model.ContaBancariaEntity;

import java.util.List;

public interface ContaBancariaService {

    List<ContaBancariaEntity> listAccount();

    ContaBancariaEntity ConsultationAccount(String numConta, String numAgencia);

    ContaBancariaEntity accountChange(ContaBancariaEntity contaBancaria);

    ContaBancariaEntity registerAccount(ContaBancariaEntity contaBancaria);

    void deleteContaById(Long idConta);

    ContaBancariaEntity sacarChequeEspecial(String numConta, double valor) throws ResourceNotFoundException;
}

