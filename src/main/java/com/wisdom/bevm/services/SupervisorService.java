package com.wisdom.bevm.services;

import com.wisdom.bevm.models.Supervisor;
import com.wisdom.bevm.respositories.SupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupervisorService {

    @Autowired
    private SupervisorRepository supervisorRepository;

    public Supervisor add(Supervisor supervisor){
        return supervisorRepository.save(supervisor);
    }

    public List<Supervisor> findAll(){
        return supervisorRepository.findAll();
    }

    public void delete(Long id){
        supervisorRepository.deleteById(id);
    }

    public Optional<Supervisor> findById(Long id){
        return supervisorRepository.findById(id);
    }
}
