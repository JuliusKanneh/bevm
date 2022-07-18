package com.wisdom.bevm;

import com.wisdom.bevm.models.Candidate;
import com.wisdom.bevm.respositories.CandidateRepository;
import com.wisdom.bevm.respositories.CitizenRepository;
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
public class TestCitizen {
    @Autowired
    private CitizenRepository citizenRepository;

    @Test
    public void countByNid(){
        Long nid = 1L;
        Long count = citizenRepository.countByNid(nid);
        assertThat(count).isGreaterThan(0);
    }
}
