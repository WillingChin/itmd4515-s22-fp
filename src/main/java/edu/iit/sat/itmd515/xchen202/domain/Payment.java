/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 *
 * ClassName: Payment author: XINN_CHEN since: Dec 20, 2021 23:58:01 PM
 */
@Entity
@NamedQuery(name = "Payment.findAll", query = "select p from Payment p")
public class Payment extends GenericEntity {

    // Uni-directional relationship between Account (owner) and Payment
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    private double money;

    private PaymentType type;

    /**
     * empty construct
     */
    public Payment() {
    }

    /**
     *
     * @param account
     * @param money
     * @param type
     */
    public Payment(Account account, double money, PaymentType type) {
        this.account = account;
        this.money = money;
        this.type = type;
    }

    /**
     * This is a getter which gets the name
     *
     * @return the value of id
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id - the name to be set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Set the value of id
     *
     * @param account new value of id
     */
    public void setAccount(Account account) {
        this.account = account;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public double getMoney() {
        return money;
    }

    /**
     * Set the value of id
     *
     * @param money new value of id
     */
    public void setMoney(double money) {
        this.money = money;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public PaymentType getType() {
        return type;
    }

    /**
     * Set the value of id
     *
     * @param type - the name to be set
     */
    public void setType(PaymentType type) {
        this.type = type;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Payment{" + "id=" + id + ", money=" + money + ", paymentType=" + type + '}';
    }

}
