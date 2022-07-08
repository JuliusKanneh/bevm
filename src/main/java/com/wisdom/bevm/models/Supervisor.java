package com.wisdom.bevm.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Supervisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roll_no;

    @Temporal(TemporalType.DATE)
    private Date dateAssigned;

    @JsonIgnore
    @OneToOne
    @JoinColumn(
            name = "nid",
            insertable = false,
            updatable = false
    )
    private Citizen citizen;
    private Long nid;

    @OneToOne(mappedBy = "supervisor")
    private PollingCenter pollingCenter;

    public Supervisor() {
    }

    public Supervisor(Long roll_no, Date dateAssigned, Citizen citizen, Long nid, PollingCenter pollingCenter) {
        this.roll_no = roll_no;
        this.dateAssigned = dateAssigned;
        this.citizen = citizen;
        this.nid = nid;
        this.pollingCenter = pollingCenter;
    }

    public Long getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(Long roll_no) {
        this.roll_no = roll_no;
    }

    public Date getDateAssigned() {
        return dateAssigned;
    }

    public void setDateAssigned(Date dateAssigned) {
        this.dateAssigned = dateAssigned;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

    public Long getNid() {
        return nid;
    }

    public void setNid(Long nid) {
        this.nid = nid;
    }

    public PollingCenter getPollingCenter() {
        return pollingCenter;
    }

    public void setPollingCenter(PollingCenter pollingCenter) {
        this.pollingCenter = pollingCenter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supervisor that = (Supervisor) o;
        return Objects.equals(roll_no, that.roll_no) && Objects.equals(dateAssigned, that.dateAssigned) && Objects.equals(citizen, that.citizen) && Objects.equals(nid, that.nid) && Objects.equals(pollingCenter, that.pollingCenter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roll_no, dateAssigned, citizen, nid, pollingCenter);
    }

    @Override
    public String toString() {
        return "Supervisor{" +
                "roll_no=" + roll_no +
                ", dateAssigned=" + dateAssigned +
                ", citizen=" + citizen +
                ", nid=" + nid +
                ", pollingCenter=" + pollingCenter +
                '}';
    }

}
