package br.com.maaicondgl.apirestfull.CodeChallengeSwat.Facade;

import java.util.List;

import br.com.maaicondgl.apirestfull.CodeChallengeSwat.Exceptions.ResourceNotFoundException;
import br.com.maaicondgl.apirestfull.CodeChallengeSwat.Model.ContaBancariaEntity;
import br.com.maaicondgl.apirestfull.CodeChallengeSwat.Service.ContaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContaBancariaFacadeImpl implements ContaBancariaFacade{

    @Autowired
    private final ContaBancariaService contaBancariaService;

    @Autowired
    public ContaBancariaFacadeImpl(ContaBancariaService contaBancariaService) {
        this.contaBancariaService = contaBancariaService;
    }

    @Override
    public List<ContaBancariaEntity> listAccount() {
        return contaBancariaService.listAccount();
    }

    @Override
    public ContaBancariaEntity ConsultationAccount(String numConta, String numAgencia) {
        return contaBancariaService.ConsultationAccount(numConta, numAgencia);
    }

    @Override
    public ContaBancariaEntity accountChange(ContaBancariaEntity contaBancaria) {
        return contaBancariaService.accountChange(contaBancaria);
    }

    @Override
    public ContaBancariaEntity registerAccount(ContaBancariaEntity contaBancaria) {
        return contaBancariaService.registerAccount(contaBancaria);
    }

    @Override
    public void deleteContaById(Long idConta) {
        contaBancariaService.deleteContaById(idConta);
    }

    @Override
    public ContaBancariaEntity sacarChequeEspecial(String numConta, double valor) throws ResourceNotFoundException {
        return contaBancariaService.sacarChequeEspecial(numConta, valor);
    }
}
