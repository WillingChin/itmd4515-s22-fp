/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.util;

import java.io.Serializable;
import java.util.Locale;
import java.util.Objects;

/**
 * Example from Web
 * author XCHEN202 date 04-18-2022 03:44 version V1.0 Lab6 desc SelectManyMenu
 * https://www.primefaces.org/showcase/ui/input/manyMenu.xhtml?jfwid=806af
 */
public class Country implements Serializable, Comparable<Country> {

    private int id;
    private String name;
    private String code;
    private Locale locale;
    private boolean rtl;

    /**
     * Empty construct
     */
    public Country() {
    }

    /**
     * Construct
     *
     * @param id
     * @param locale
     */
    public Country(int id, Locale locale) {
        this(id, locale.getDisplayCountry(), locale.getCountry().toLowerCase(), locale);
    }

    /**
     * Construct
     *
     * @param id
     * @param locale
     * @param rtl
     */
    public Country(int id, Locale locale, boolean rtl) {
        this(id, locale.getDisplayCountry(), locale.getCountry().toLowerCase(), locale);
        this.rtl = rtl;
    }

    /**
     * Construct
     *
     * @param id
     * @param name
     * @param code
     */
    public Country(int id, String name, String code) {
        this(id, name, code, null);
    }

    /**
     *
     * @param id
     * @param name
     * @param code
     * @param locale
     */
    public Country(int id, String name, String code, Locale locale) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.locale = locale;
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
     * @param id - the name to be set
     */
    public void setId(int id) {
        this.id = id;
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
    public String getCode() {
        return code;
    }

    /**
     * This is a setter which sets the name
     *
     * @param code - the name to be set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public Locale getLocale() {
        return locale;
    }

    /**
     * This is a setter which sets the name
     *
     * @param locale - the name to be set
     */
    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public String getLanguage() {
        return locale == null ? "en" : locale.getLanguage();
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public String getDisplayLanguage() {
        return locale == null ? "English" : locale.getDisplayLanguage();
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public boolean isRtl() {
        return rtl;
    }

    /**
     * This is a setter which sets the name
     *
     * @param rtl - the name to be set
     */
    public void setRtl(boolean rtl) {
        this.rtl = rtl;
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Country country = (Country) o;
        return id == country.id
                && Objects.equals(name, country.name)
                && Objects.equals(code, country.code);
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, code);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Country o) {
        return name.compareTo(o.name);
    }

}
