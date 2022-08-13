/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;

/**
 *
 * ClassName: Machine author: XINN_CHEN since: Dec 20, 2021 23:58:01
 */
@Entity
@NamedQuery(name = "Machine.findAll", query = "select m from Machine m order by m.id desc")
public class Machine extends GenericEntity {

    @Size(min = 1, max = 200)
    @Column(nullable = false, unique = false, name = "name", length = 200)
    private String name;

    private String operationDesk;

    private String power;

    private String speed;

    private String size;

    private String weight;

    private double price;

    @Enumerated(EnumType.STRING)
    private MachineType type;

    @ManyToMany(mappedBy = "machines")
    private List<Account> accounts = new ArrayList<>();

    /**
     * Get the value of MachineType
     *
     * @return the value of MachineType
     */
    public MachineType getMachineType() {
        return type;
    }

    /**
     * This is a setter which sets the name
     *
     * @param type - the name to be set
     */
    public void setMachineType(MachineType type) {
        this.type = type;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * This is a setter which sets the name
     *
     * @param name - the name to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public String getOperationDesk() {
        return operationDesk;
    }

    /**
     * This is a setter which sets the name
     *
     * @param operationDesk - the name to be set
     */
    public void setOperationDesk(String operationDesk) {
        this.operationDesk = operationDesk;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public String getPower() {
        return power;
    }

    /**
     * This is a setter which sets the name
     *
     * @param power - the name to be set
     */
    public void setPower(String power) {
        this.power = power;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public String getSpeed() {
        return speed;
    }

    /**
     * This is a setter which sets the name
     *
     * @param speed - the name to be set
     */
    public void setSpeed(String speed) {
        this.speed = speed;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public String getSize() {
        return size;
    }

    /**
     * This is a setter which sets the name
     *
     * @param size - the name to be set
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public String getWeight() {
        return weight;
    }

    /**
     * This is a setter which sets the name
     *
     * @param weight - the name to be set
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     * This is a setter which sets the name
     *
     * @param price - the name to be set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     *
     * @return
     */
    public List<Account> getAccounts() {
        return accounts;
    }

    /**
     * This is a setter which sets the name
     *
     * @param accounts - the name to be set
     */
    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    /**
     * empty construct
     */
    public Machine() {
    }

    /**
     *
     * @param name
     */
    public Machine(String name) {
        this.name = name;
    }

    // full-arg constructor minus the db generated id
    /**
     *
     * @param id
     * @param name
     * @param operationDesk
     * @param power
     * @param speed
     * @param size
     * @param weight
     * @param price
     */
    public Machine(Long id, String name, String operationDesk, String power, String speed, String size, String weight, double price) {
        this.id = id;
        this.name = name;
        this.operationDesk = operationDesk;
        this.power = power;
        this.speed = speed;
        this.size = size;
        this.weight = weight;
        this.price = price;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Machine{" + "id=" + id + ", name=" + name + "}'";
    }

}
