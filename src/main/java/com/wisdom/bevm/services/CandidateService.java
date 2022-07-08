package com.wisdom.bevm.services;

import com.wisdom.bevm.models.Candidate;
import com.wisdom.bevm.respositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public Candidate add(Candidate candidate){
        return candidateRepository.save(candidate);
    }

    public List<Candidate> findAll(){
        return candidateRepository.findAll();
    }

    public void delete(Long id){
        candidateRepository.deleteById(id);
    }
    public Optional<Candidate> findById(Long id){
        return candidateRepository.findById(id);
    }
}
