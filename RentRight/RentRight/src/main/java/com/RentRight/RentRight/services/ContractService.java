package com.RentRight.RentRight.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RentRight.RentRight.entities.Contract;
import com.RentRight.RentRight.repositories.ContractRepository;

import jakarta.transaction.Transactional;

@Service
public class ContractService {

    @Autowired
    private ContractRepository repository;

    @Transactional
    public Contract create(Contract contract){
        Contract contractCriado = repository.save(contract);
        return contractCriado;
    }

    public Contract read(Long id){
        return repository.findById(id).get();
    }

    public List<Contract> list(){
        List<Contract> contracts = (List<Contract>) repository.findAll();
        return contracts;
    }

    @Transactional
    public void delete(Long id){
        repository.deleteById(id);
    }

    @Transactional
    public Contract update(Contract contract){
        if(repository.existsById(contract.getId())){
            return repository.save(contract);
        }else{
            return null;
        }
    }
}
