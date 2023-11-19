package com.RentRight.RentRight.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.RentRight.RentRight.dto.ContractInputDTO;
import com.RentRight.RentRight.dto.ContractOutputDTO;
import com.RentRight.RentRight.entities.Contract;
import com.RentRight.RentRight.repositories.ContractRepository;

import jakarta.transaction.Transactional;

@Service
public class ContractService {

    @Autowired
    private ContractRepository repository;

    @Transactional
    public ContractOutputDTO create(ContractInputDTO dto){
        Contract contractCriado = repository.save(converterDtoParaEntidade(dto));
        return converterEntidadeParaDTO(contractCriado);
    }

    public ContractOutputDTO converterEntidadeParaDTO(Contract contract){
        ContractOutputDTO dtoSaida = new ContractOutputDTO();
        dtoSaida.setId(contract.getId());
        dtoSaida.setStartDate(contract.getStartDate());
        dtoSaida.setEndDate(contract.getEndDate());
        return dtoSaida;
    }

    public Contract converterDtoParaEntidade(ContractInputDTO dto){
        Contract contract = new Contract();
        contract.setId(contract.getId());
        contract.setStartDate(contract.getStartDate());
        contract.setEndDate(contract.getEndDate());
        return contract;
    }
 

    public ContractOutputDTO read(Long id){
        Contract contract = repository.findById(id).get();
        return converterEntidadeParaDTO(contract);
    }


    public List<Contract> list(Pageable page){
        List<Contract> contracts = (List<Contract>) repository.findAll();
        return contracts;
    }

    @Transactional
    public void delete(Long id){
        repository.deleteById(id);
    }

    @Transactional
    public ContractOutputDTO update(ContractInputDTO contract){
        if(contract.getId() == null){
            contract.setId(99l);
        }
        if(repository.existsById(contract.getId())){
            Contract contractUpdate = repository.save(converterDtoParaEntidade(contract));
            return converterEntidadeParaDTO(contractUpdate);
        }else{
            return null;
        }
    }

}