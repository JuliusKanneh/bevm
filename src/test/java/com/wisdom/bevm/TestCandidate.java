package com.wisdom.bevm;

import com.wisdom.bevm.models.Candidate;
import com.wisdom.bevm.services.CandidateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class TestCandidate {
    @Autowired
    private CandidateService candidateService;

    @Autowired
    private Candidate candidate1;

    @Test
    public void testCandidateAdd(){
        candidate1 = new Candidate("Julius", "some string");
        Candidate savedCandidate = candidateService.add(candidate1);
        assertThat(savedCandidate).isNotNull();
    }
}
