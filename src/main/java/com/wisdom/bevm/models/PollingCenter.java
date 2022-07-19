package com.wisdom.bevm.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class PollingCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pollingCenterId;

    private String location;

    private String description;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(
            name = "supervisorRollNo",
            insertable = false,
            updatable = false
    )
    private Supervisor supervisor;
    private Long supervisorRollNo;

    @OneToMany(mappedBy = "pollingCenter")
    private List<BEVM> bevms;

    @OneToMany(mappedBy = "pollingCenter")
    private List<RegisteredVoter> registeredVoters;

    public PollingCenter(Long pollingCenterId, String location, String description, Supervisor supervisor, Long supervisorRollNo, List<BEVM> bevms, List<RegisteredVoter> registeredVoters) {
        this.pollingCenterId = pollingCenterId;
        this.location = location;
        this.description = description;
        this.supervisor = supervisor;
        this.supervisorRollNo = supervisorRollNo;
        this.bevms = bevms;
        this.registeredVoters = registeredVoters;
    }

    public PollingCenter() {
    }

    public Long getPollingCenterId() {
        return pollingCenterId;
    }

    public void setPollingCenterId(Long pollingCenterId) {
        this.pollingCenterId = pollingCenterId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public Long getSupervisorRollNo() {
        return supervisorRollNo;
    }

    public void setSupervisorRollNo(Long supervisorRollNo) {
        this.supervisorRollNo = supervisorRollNo;
    }

    public List<BEVM> getBevms() {
        return bevms;
    }

    public void setBevms(List<BEVM> bevms) {
        this.bevms = bevms;
    }

    public List<RegisteredVoter> getRegisteredVoters() {
        return registeredVoters;
    }

    public void setRegisteredVoters(List<RegisteredVoter> registeredVoters) {
        this.registeredVoters = registeredVoters;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PollingCenter{" +
                "pollingCenterId=" + pollingCenterId +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", supervisor=" + supervisor +
                ", supervisorRollNo=" + supervisorRollNo +
                ", bevms=" + bevms +
                ", registeredVoters=" + registeredVoters +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PollingCenter that = (PollingCenter) o;
        return Objects.equals(pollingCenterId, that.pollingCenterId) && Objects.equals(location, that.location) && Objects.equals(description, that.description) && Objects.equals(supervisor, that.supervisor) && Objects.equals(supervisorRollNo, that.supervisorRollNo) && Objects.equals(bevms, that.bevms) && Objects.equals(registeredVoters, that.registeredVoters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pollingCenterId, location, description, supervisor, supervisorRollNo, bevms, registeredVoters);
    }
}
