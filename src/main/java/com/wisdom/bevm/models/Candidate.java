package com.wisdom.bevm.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidate_id")
    private Long candidateId;

    @Column(name = "full_name")
    private String fullName;
    private String photo;

    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<Votes> votes;

    public Candidate(Long candidateId, String fullName, String photo, List<Votes> votes) {
        this.candidateId = candidateId;
        this.fullName = fullName;
        this.photo = photo;
        this.votes = votes;
    }

    public void setVotes(List<Votes> votes) {
        this.votes = votes;
    }

    public Candidate(String fullName, String photo) {
        this.fullName = fullName;
        this.photo = photo;
    }

    public Candidate() {
    }

    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<Votes> getVotes() {
        return votes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return Objects.equals(candidateId, candidate.candidateId) && Objects.equals(fullName, candidate.fullName) && Objects.equals(photo, candidate.photo) && Objects.equals(votes, candidate.votes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidateId, fullName, photo, votes);
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "candidateId=" + candidateId +
                ", fullName='" + fullName + '\'' +
                ", photo='" + photo + '\'' +
                ", votes=" + votes +
                '}';
    }
}
