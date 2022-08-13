/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Example from Web
 * author XCHEN202 date 04-17-2022 23:49 version V1.0 Lab10 desc edit page
 * choice entity
 * https://stackoverflow.com/questions/4734580/conversion-error-setting-value-for-null-converter-why-do-i-need-a-converter
 * https://code-examples.net/en/q/a5932d
 */
@FacesConverter(value = "SelectItemToEnableConverter")
public class SelectItemToEnableConverter implements Converter {

    /**
     * true or false convert to Enable & Disable
     *
     * @param ctx
     * @param comp
     * @param value
     * @return
     */
    @Override
    public Object getAsObject(FacesContext ctx, UIComponent comp, String value) {
        Object newValue = (Object) value;
        if (newValue instanceof Boolean) {
            Boolean booleanVal = (Boolean) newValue;
            if (booleanVal == true) {
                return "Enable";
            } else if (booleanVal == false) {
                return "Disable";
            }
        }
        if (newValue instanceof String) {
            if (value.equals("true")) {
                return "Enable";
            } else if (value.equals("false")) {
                return "Disable";
            }
        }
        return null;
    }

    /**
     * true or false convert to Enable & Disable
     *
     * @param ctx
     * @param comp
     * @param value
     * @return
     */
    @Override
    public String getAsString(FacesContext ctx, UIComponent comp, Object value) {
        try {
            Object newValue = (Object) value;
            if (newValue instanceof Boolean) {
                Boolean booleanVal = (Boolean) newValue;
                if (booleanVal == true) {
                    return "Enable";
                } else if (booleanVal == false) {
                    return "Disable";
                }
            }
            if (newValue instanceof String) {
                if (value.equals("true")) {
                    return "Enable";
                } else if (value.equals("false")) {
                    return "Disable";
                }
            }
            return null;
        } catch (Exception exception) {
            throw new ConverterException(exception);
        }
    }

}
