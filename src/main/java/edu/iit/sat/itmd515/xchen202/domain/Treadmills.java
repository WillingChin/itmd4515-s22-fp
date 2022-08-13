/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.domain;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

/**
 *
 * ClassName: Treadmills author: XINN_CHEN since: Dec 14, 2021 11:58:01 PM
 */
@Entity
@NamedQuery(name = "Treadmills.findAll", query = "select t from Treadmills t")
//When I try to get Account object id. It’s empty! The method “postConstruct“ does not store data in MySql?
//https://stackoverflow.com/c/itmd4515-spring-2022/questions/161
@NamedQuery(name = "Treadmills.findAllById", query = "select t from Treadmills t where t.account.id = :accountId ")
public class Treadmills extends GenericEntity {

    @ManyToOne
    @JoinColumn(name = "account_id")
    @NotNull
    private Account account;//0 is mean guest

    @ManyToOne
    @JoinColumn(name = "machine_id")
    @NotNull
    private Machine machine;

    private Integer mills;

    @Column(name = "use_time")
    private String useTime;

    private Integer altitude;

    @Max(5000)
    @Min(1)
    private Integer kcal;

    @PastOrPresent
    @Column(name = "start_date")
    private LocalDate startDate;//machine use time.

//    private List<Machine> machines = new ArrayList<>();
    /**
     * Get the value of kcal
     *
     * @return the value of kcal
     */
    public Integer getKcal() {
        return kcal;
    }

    /**
     * Get the value of startDate
     *
     * @return the value of startDate
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Set the value of startDate
     *
     * @param startDate new value of startDate
     */
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * Set the value of kcal
     *
     * @param kcal new value of kcal
     */
    public void setKcal(Integer kcal) {
        this.kcal = kcal;
    }

    /**
     * Get the value of altitude
     *
     * @return the value of altitude
     */
    public Integer getAltitude() {
        return altitude;
    }

    /**
     * Set the value of altitude
     *
     * @param altitude new value of altitude
     */
    public void setAltitude(Integer altitude) {
        this.altitude = altitude;
    }

    /**
     * Get the value of useTime
     *
     * @return the value of useTime
     */
    public String getUseTime() {
        return useTime;
    }

    /**
     * Set the value of useTime
     *
     * @param useTime new value of useTime
     */
    public void setUseTime(String useTime) {
        this.useTime = useTime;
    }

    /**
     * Get the value of mills
     *
     * @return the value of mills
     */
    public Integer getMills() {
        return mills;
    }

    /**
     * Set the value of mills
     *
     * @param mills new value of mills
     */
    public void setMills(Integer mills) {
        this.mills = mills;
    }

    /**
     *
     * @return
     */
    public Account getAccount() {
        return account;
    }

    /**
     *
     * @param account
     */
    public void setAccount(Account account) {
        this.account = account;
    }

    /**
     *
     * @return
     */
    public Machine getMachine() {
        return machine;
    }

    /**
     *
     * @param machine
     */
    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    /**
     * empty construct
     */
    public Treadmills() {
    }

    // full-arg constructor minus the db generated id
    /**
     *
     * @param mills
     * @param useTime
     * @param altitude
     * @param kcal
     * @param startDate
     */
    public Treadmills(Integer mills, String useTime, Integer altitude, Integer kcal, LocalDate startDate) {
        this.mills = mills;
        this.useTime = useTime;
        this.altitude = altitude;
        this.kcal = kcal;
        this.startDate = startDate;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Treadmills{" + "id=" + id + ", mills=" + mills + ", useTime=" + useTime + ", Kcal=" + kcal + ", Account=" + account + ", Machine=" + machine + "}";
    }

}
