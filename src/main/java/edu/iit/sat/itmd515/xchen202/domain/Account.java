/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * ClassName: Account author: XINN_CHEN since: Dec 18, 2021 11:58:01
 */
@Entity
@NamedQuery(name = "Account.findAll", query = "select a from Account a")
public class Account extends GenericEntity {

    private String username;

    private LocalDate expired;

    /**
     * Bi-directional M:M relationship between ACCOUNT (owning) and MACHINE
     * (inverse)
     *
     */
    @ManyToMany
    @JoinTable(
            name = "ACCOUNT_MACHINE",
            joinColumns = @JoinColumn(name = "ACCOUNT_ID"),
            inverseJoinColumns = @JoinColumn(name = "MACHINE_ID")
    )
    private List<Machine> machines = new ArrayList<>();

    // helper methods for relationships
    /**
     * M:M add mahine to list
     *
     * @param p
     */
    public void addMachine(Machine p) {
        if (!this.getMachines().contains(p)) {
            this.getMachines().add(p);
        }
        if (!p.getAccounts().contains(this)) {
            p.getAccounts().add(this);
        }
    }

    /**
     * M:M remove mahine to list
     *
     * @param p
     */
    public void removeMachine(Machine p) {
        if (this.getMachines().contains(p)) {
            this.getMachines().remove(p);
        }
        if (p.getAccounts().contains(this)) {
            p.getAccounts().remove(this);
        }
    }

    // Bi-directional 1:M relationship between Account (owning) and Payment (inverse)
    @OneToMany
    @JoinColumn(name = "ACCOUNT_ID")
    private List<Payment> payments = new ArrayList<>();

    // helper methods for relationships
    /**
     * 1:M add payment to list
     *
     * @param p
     */
    public void addPayment(Payment p) {
        if (!this.getPayments().contains(p)) {
            this.getPayments().add(p);
        }
        p.setAccount(this);
    }

    /**
     * 1:M remove payment to list
     *
     * @param p
     */
    public void removePayment(Payment p) {
        if (this.getPayments().contains(p)) {
            this.getPayments().remove(p);
        }
        p.setAccount(null);
    }

    // Bi-directional 1:M relationship between Account (owning) and Treadmills (inverse)
    @OneToMany
    @JoinColumn(name = "ACCOUNT_ID")
    private List<Treadmills> treadmilles = new ArrayList<>();

    // helper methods for relationships
    /**
     * 1:M add the name
     *
     * @param p
     */
    public void addTreadmills(Treadmills p) {
        if (!this.getTreadmilles().contains(p)) {
            this.getTreadmilles().add(p);
        }
        p.setAccount(this);
    }

    /**
     * 1:M remove the name
     *
     * @param p
     */
    public void removeTreadmills(Treadmills p) {
        if (this.getTreadmilles().contains(p)) {
            this.getTreadmilles().remove(p);
        }
        p.setAccount(null);
    }

    /**
     * empty construct
     */
    public Account() {

    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * This is a setter which sets the name
     *
     * @param username - the name to be set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public LocalDate getExpired() {
        return expired;
    }

    /**
     * This is a setter which sets the name
     *
     * @param expired
     */
    public void setExpired(LocalDate expired) {
        this.expired = expired;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public List<Machine> getMachines() {
        return machines;
    }

    /**
     * This is a setter which sets the name
     *
     * @param machines
     */
    public void setMachines(List<Machine> machines) {
        this.machines = machines;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public List<Payment> getPayments() {
        return payments;
    }

    /**
     * This is a setter which sets the name
     *
     * @param payments
     */
    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    /**
     *
     * @return
     */
    public List<Treadmills> getTreadmilles() {
        return treadmilles;
    }

    /**
     * This is a setter which sets the name
     *
     * @param treadmilles - the name to be set
     */
    public void setTreadmilles(List<Treadmills> treadmilles) {
        this.treadmilles = treadmilles;
    }

    /**
     * Console output information
     *
     * @return
     */
    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", username=" + username + ", machines=" + machines + '}';
    }

}
