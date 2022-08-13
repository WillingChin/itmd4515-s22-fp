/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.util;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Example from Web
 * author XCHEN202 date 05-03-2022 20:26 version V1.0 Lab6 desc
 */
@Named
@RequestScoped
public class ThemeService {

    private List<Theme> themes;

    /**
     * Initial themes data.
     */
    @PostConstruct
    public void init() {
        themes = new ArrayList<>();
        themes.add(new Theme(0, "Nova-Light", "nova-light"));
        themes.add(new Theme(1, "Nova-Dark", "nova-dark"));
        themes.add(new Theme(2, "Nova-Colored", "nova-colored"));
        themes.add(new Theme(3, "Luna-Blue", "luna-blue"));
        themes.add(new Theme(4, "Luna-Amber", "luna-amber"));
        themes.add(new Theme(5, "Luna-Green", "luna-green"));
        themes.add(new Theme(6, "Luna-Pink", "luna-pink"));
        themes.add(new Theme(7, "Omega", "omega"));
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public List<Theme> getThemes() {
        return themes;
    }
}
