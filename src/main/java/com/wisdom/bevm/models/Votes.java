package com.wisdom.bevm.models;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Votes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateVoted;

    @OneToOne
    @JoinColumn(
            name = "voter_id",
            insertable = false,
            updatable = false
    )
    private RegisteredVoter voter;
    private Long voter_id;

    @ManyToOne
    @JoinColumn(
            name = "candidate_id",
            insertable = false,
            updatable = false
    )
    private Candidate candidate;
    private Long candidate_id;

    public Votes() {
    }

    public Votes(Long id, Date dateVoted, RegisteredVoter voter, Long voter_id, Candidate candidate, Long candidate_id) {
        this.id = id;
        this.dateVoted = dateVoted;
        this.voter = voter;
        this.voter_id = voter_id;
        this.candidate = candidate;
        this.candidate_id = candidate_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateVoted() {
        return dateVoted;
    }

    public void setDateVoted(Date dateVoted) {
        this.dateVoted = dateVoted;
    }

    public RegisteredVoter getVoter() {
        return voter;
    }

    public void setVoter(RegisteredVoter voter) {
        this.voter = voter;
    }

    public Long getVoter_id() {
        return voter_id;
    }

    public void setVoter_id(Long voter_id) {
        this.voter_id = voter_id;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Long getCandidate_id() {
        return candidate_id;
    }

    public void setCandidate_id(Long candidate_id) {
        this.candidate_id = candidate_id;
    }

    @Override
    public String toString() {
        return "Votes{" +
                "id=" + id +
                ", dateVoted=" + dateVoted +
                ", voter=" + voter +
                ", voter_id=" + voter_id +
                ", candidate=" + candidate +
                ", candidate_id=" + candidate_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Votes votes = (Votes) o;
        return Objects.equals(id, votes.id) && Objects.equals(dateVoted, votes.dateVoted) && Objects.equals(voter, votes.voter) && Objects.equals(voter_id, votes.voter_id) && Objects.equals(candidate, votes.candidate) && Objects.equals(candidate_id, votes.candidate_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateVoted, voter, voter_id, candidate, candidate_id);
    }

}
