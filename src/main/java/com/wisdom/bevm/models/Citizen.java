package com.wisdom.bevm.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nid;

    private String firstname;
    private String lastname;

    @Temporal(TemporalType.DATE)
    private Date dob;

    private String address;
    private String phone;
    private String photo;

    private String finger_print_id;

    @OneToOne(mappedBy = "citizen")
    private Supervisor supervisor;

    public Citizen(Long nid, String firstname, String lastname, Date dob, String address, String phone, String photo, String finger_print_id, Supervisor supervisor) {
        this.nid = nid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.photo = photo;
        this.finger_print_id = finger_print_id;
        this.supervisor = supervisor;
    }

    public Citizen() {
    }

    public Long getNid() {
        return nid;
    }

    public void setNid(Long nid) {
        this.nid = nid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getFinger_print_id() {
        return finger_print_id;
    }

    public void setFinger_print_id(String finger_print_id) {
        this.finger_print_id = finger_print_id;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "nid=" + nid +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dob=" + dob +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", photo='" + photo + '\'' +
                ", finger_print_id='" + finger_print_id + '\'' +
                ", supervisor=" + supervisor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Citizen citizen = (Citizen) o;
        return Objects.equals(nid, citizen.nid) && Objects.equals(firstname, citizen.firstname) && Objects.equals(lastname, citizen.lastname) && Objects.equals(dob, citizen.dob) && Objects.equals(address, citizen.address) && Objects.equals(phone, citizen.phone) && Objects.equals(photo, citizen.photo) && Objects.equals(finger_print_id, citizen.finger_print_id) && Objects.equals(supervisor, citizen.supervisor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nid, firstname, lastname, dob, address, phone, photo, finger_print_id, supervisor);
    }
}
