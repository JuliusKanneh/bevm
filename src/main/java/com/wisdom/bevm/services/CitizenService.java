package com.wisdom.bevm.services;

import com.wisdom.bevm.models.Citizen;
import com.wisdom.bevm.respositories.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitizenService {

    @Autowired
    private CitizenRepository citizenRepository;

    public Citizen add(Citizen citizen){
        return citizenRepository.save(citizen);
    }

    public List<Citizen> findAll(){
        return citizenRepository.findAll();
    }

    public void delete(Long id){
        citizenRepository.deleteById(id);
    }
    public Optional<Citizen> findById(Long id){
        return citizenRepository.findById(id);
    }

}
