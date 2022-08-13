/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.domain;

/**
 *
 * ClassName: MachineType author: XINN_CHEN since: Dec 14, 2021 11:58:01 PM
 */
public enum MachineType {
    /**
     * CHEAP
     */
    CHEAP("CHEAP"),
    /**
     * EXPENSIVE
     */
    EXPENSIVE("EXPENSIVE");

    private String label;

    private MachineType(String label) {
        this.label = label;
    }

    /**
     * Get the value of label
     *
     * @return the value of label
     */
    public String getLabel() {
        return label;
    }
}
