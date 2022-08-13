/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.util;

import java.io.Serializable;

/**
 * Example from Web
 * author XCHEN202 date 04-18-2022 17:44 version V1.0 Lab6 desc
 */
public class Car implements Serializable {

    private static final long serialVersionUID = 4686946389675400929L;

    /**
     * id
     */
    public String id;

    /**
     * brand
     */
    public String brand;

    /**
     * year
     */
    public int year;

    /**
     * color
     */
    public String color;

    /**
     * price
     */
    public int price;

    /**
     * sold
     */
    public boolean sold;

    /**
     * Empty construct
     */
    public Car() {
    }

    /**
     * Full column construct
     *
     * @param id
     * @param brand
     * @param year
     * @param color
     */
    public Car(String id, String brand, int year, String color) {
        this.id = id;
        this.brand = brand;
        this.year = year;
        this.color = color;
    }

    /**
     *
     * @param id
     * @param brand
     * @param year
     * @param color
     * @param price
     * @param sold
     */
    public Car(String id, String brand, int year, String color, int price, boolean sold) {
        this.id = id;
        this.brand = brand;
        this.year = year;
        this.color = color;
        this.price = price;
        this.sold = sold;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * This is a setter which sets the name
     *
     * @param id - the name to be set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public String getBrand() {
        return brand;
    }

    /**
     * This is a setter which sets the name
     *
     * @param brand - the name to be set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public int getYear() {
        return year;
    }

    /**
     * This is a setter which sets the name
     *
     * @param year - the name to be set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public String getColor() {
        return color;
    }

    /**
     * This is a setter which sets the name
     *
     * @param color - the name to be set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public int getPrice() {
        return price;
    }

    /**
     * This is a setter which sets the name
     *
     * @param price - the name to be set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public boolean isSold() {
        return sold;
    }

    /**
     * This is a setter which sets the name
     *
     * @param sold - the name to be set
     */
    public void setSold(boolean sold) {
        this.sold = sold;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Car other = (Car) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }
}
