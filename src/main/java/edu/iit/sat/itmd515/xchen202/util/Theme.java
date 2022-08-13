/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.util;

/**
 * Example from Web
 * author XCHEN202 date 05-03-2022 20:27 version V1.0 Lab6 desc
 */
public class Theme {

    private int id;
    private String displayName;
    private String name;

    /**
     * Empty construct
     */
    public Theme() {
    }

    /**
     * Full column construct
     *
     * @param id
     * @param displayName
     * @param name
     */
    public Theme(int id, String displayName, String name) {
        this.id = id;
        this.displayName = displayName;
        this.name = name;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * This is a setter which sets the name
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * This is a setter which sets the name
     *
     * @param displayName
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
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
     *
     * @return
     */
    @Override
    public String toString() {
        return name;
    }
}
