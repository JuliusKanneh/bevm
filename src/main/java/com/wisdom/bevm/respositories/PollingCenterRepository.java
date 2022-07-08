package com.wisdom.bevm.respositories;

import com.wisdom.bevm.models.Candidate;
import com.wisdom.bevm.models.PollingCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PollingCenterRepository extends JpaRepository<PollingCenter, Long> {

    @Query("SELECT pc FROM PollingCenter pc WHERE pc.supervisor_roll_no = :id")
    Optional<PollingCenter> findBySupervisor_roll_no(Long id);
    Optional<PollingCenter> findByAddress(String address);

}
