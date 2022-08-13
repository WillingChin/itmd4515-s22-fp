/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.domain;

/**
 *
 * author sas691
 */
public enum EnableType {
    /**
     * Select comonpent data: Enable
     */
    Enable("Enable", true),
    /**
     * Select component data: Dsiable
     */
    Dsiable("Dsiable", false);

    private String label;

    private Boolean value;

    private EnableType(String label, Boolean value) {
        this.label = label;
        this.value = value;
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
