/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.util;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 * Example from Web
 * author XCHEN202 date 04-18-2022 03:40 version V1.0 Lab6 desc OrderList
 * https://www.primefaces.org/showcase/ui/data/orderList.xhtml?jfwid=806af
 */
@Named
@RequestScoped
public class OrderListView {

    @Inject
    private CountryService service;

    private List<String> cities;
    private List<Country> countries;

    /**
     * Initial variable
     */
    @PostConstruct
    public void init() {
        //Cities
        cities = new ArrayList<>();
        cities.add("San Francisco");
        cities.add("London");
        cities.add("Paris");
        cities.add("Istanbul");
        cities.add("Berlin");
        cities.add("Barcelona");
        cities.add("Rome");

        //Countrys
        countries = service.getCountries().subList(0, 10);
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public CountryService getService() {
        return service;
    }

    /**
     * This is a setter which sets the name
     *
     * @param service - the name to be set
     */
    public void setService(CountryService service) {
        this.service = service;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public List<String> getCities() {
        return cities;
    }

    /**
     * This is a setter which sets the name
     *
     * @param cities - the name to be set
     */
    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public List<Country> getCountries() {
        return countries;
    }

    /**
     * This is a setter which sets the name
     *
     * @param countries - the name to be set
     */
    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    /**
     * OrderList select method
     *
     * @param event
     */
    public void onSelect(SelectEvent<Country> event) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Selected", event.getObject().getName()));
    }

    /**
     * OrderList unselect method
     *
     * @param event
     */
    public void onUnselect(UnselectEvent<Country> event) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Unselected", event.getObject().getName()));
    }

    /**
     * OrderList reorder method
     */
    public void onReorder() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "List Reordered", null));
    }

}
