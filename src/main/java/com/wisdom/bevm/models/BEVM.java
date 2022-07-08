package com.wisdom.bevm.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class BEVM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bevm_id")
    private Long bevmId;

    private String status;
    private int capacity; //300
    private int securityLevel; //1-5[3]

    //station_id
    @ManyToOne
    @JoinColumn(
            name = "pollingCenterId",
            insertable = false,
            updatable = false
    )
    private PollingCenter pollingCenter;
    private Long pollingCenterId;

    public BEVM(String status, int capacity, int securityLevel, PollingCenter pollingCenter, Long pollingCenterId) {
        this.status = status;
        this.capacity = capacity;
        this.securityLevel = securityLevel;
        this.pollingCenter = pollingCenter;
        this.pollingCenterId = pollingCenterId;
    }

    public BEVM() {
    }

    public Long getBevmId() {
        return bevmId;
    }

    public void setBevmId(Long bevmId) {
        this.bevmId = bevmId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(int securityLevel) {
        this.securityLevel = securityLevel;
    }

    public PollingCenter getPollingCenter() {
        return pollingCenter;
    }

    public void setPollingCenter(PollingCenter pollingCenter) {
        this.pollingCenter = pollingCenter;
    }

    public Long getPollingCenterId() {
        return pollingCenterId;
    }

    public void setPollingCenterId(Long pollingCenterId) {
        this.pollingCenterId = pollingCenterId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BEVM bevm = (BEVM) o;
        return capacity == bevm.capacity && securityLevel == bevm.securityLevel && Objects.equals(bevmId, bevm.bevmId) && Objects.equals(status, bevm.status) && Objects.equals(pollingCenter, bevm.pollingCenter) && Objects.equals(pollingCenterId, bevm.pollingCenterId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bevmId, status, capacity, securityLevel, pollingCenter, pollingCenterId);
    }

    @Override
    public String toString() {
        return "BEVM{" +
                "bevmId=" + bevmId +
                ", status='" + status + '\'' +
                ", capacity=" + capacity +
                ", securityLevel=" + securityLevel +
                ", pollingCenter=" + pollingCenter +
                ", pollingCenterId=" + pollingCenterId +
                '}';
    }
}
