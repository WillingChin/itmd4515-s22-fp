/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.util;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Example from Web
 * author XCHEN202 date 05-03-2022 20:31 version V1.0 Lab6 desc
 */
@Named
@FacesConverter(value = "themeConverter", managed = true)
public class ThemeConverter implements Converter<Theme> {

    @Inject
    private ThemeService themeService;

    /**
     * Get a Theme entity by value
     *
     * @param context
     * @param component
     * @param value
     * @return
     */
    @Override
    public Theme getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.trim().length() > 0) {
            try {
                return themeService.getThemes().get(Integer.parseInt(value));
            } catch (NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        } else {
            return null;
        }
    }

    /**
     * Get id by Theme
     *
     * @param context
     * @param component
     * @param value
     * @return
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Theme value) {
        if (value != null) {
            return String.valueOf(value.getId());
        } else {
            return null;
        }
    }
}
