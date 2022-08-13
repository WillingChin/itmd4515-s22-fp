package edu.iit.sat.itmd515.xchen202.util;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/*
 * Example from Web
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * author XCHEN202 date 05-03-2022 20:26 version V1.0 Lab6 desc SelectManyMenu
 * https://www.primefaces.org/showcase/ui/input/manyMenu.xhtml?jfwid=806af
 */
@Named
@ViewScoped
public class SelectManyView {

    private List<String> selectedOptions;
    private List<String> selectedOptions2;
    private List<Theme> selectedThemes;
    private List<Theme> selectedThemes2;
    private List<Theme> themes;

    @Inject
    private ThemeService service;

    /**
     * Inintial variable
     */
    @PostConstruct
    public void init() {
        themes = service.getThemes();
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public List<Theme> getThemes() {
        return themes;
    }

    /**
     * This is a setter which sets the name
     *
     * @param service - the name to be set
     */
    public void setService(ThemeService service) {
        this.service = service;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public List<String> getSelectedOptions() {
        return selectedOptions;
    }

    /**
     * This is a setter which sets the name
     *
     * @param selectedOptions - the name to be set
     */
    public void setSelectedOptions(List<String> selectedOptions) {
        this.selectedOptions = selectedOptions;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public List<Theme> getSelectedThemes() {
        selectedThemes = new ArrayList<>();
        selectedThemes.add(new Theme(0, "Nova-Light", "nova-light"));
        selectedThemes.add(new Theme(1, "Nova-Dark", "nova-dark"));
        return selectedThemes;
    }

    /**
     * This is a setter which sets the name
     *
     * @param selectedThemes - the name to be set
     */
    public void setSelectedThemes(List<Theme> selectedThemes) {
        this.selectedThemes = selectedThemes;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public List<String> getSelectedOptions2() {
        return selectedOptions2;
    }

    /**
     * This is a setter which sets the name
     *
     * @param selectedOptions2 - the name to be set
     */
    public void setSelectedOptions2(List<String> selectedOptions2) {
        this.selectedOptions2 = selectedOptions2;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public List<Theme> getSelectedThemes2() {
        return selectedThemes2;
    }

    /**
     * This is a setter which sets the name
     *
     * @param selectedThemes2 - the name to be set
     */
    public void setSelectedThemes2(List<Theme> selectedThemes2) {
        this.selectedThemes2 = selectedThemes2;
    }
}
