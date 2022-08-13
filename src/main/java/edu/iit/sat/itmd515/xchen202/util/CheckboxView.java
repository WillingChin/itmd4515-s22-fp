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
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import javax.inject.Named;
import org.primefaces.event.UnselectEvent;

/**
 * Example from Web
 * author XCHEN202 date 05-03-2022 22:03 version V1.0 Lab6 desc
 * SelectCheckboxMenu
 * https://www.primefaces.org/showcase/ui/input/checkboxMenu.xhtml?jfwid=806af
 */
@Named
@RequestScoped
public class CheckboxView {

    private String[] selectedConsoles;
    private String[] selectedConsoles2;
    private String[] selectedCities;
    private String[] selectedCities2;
    private List<String> cities;
    private List<SelectItem> cars;
    private String[] selectedCars;

    /**
     * Initial variable
     */
    @PostConstruct
    public void init() {
        cities = new ArrayList<String>();
        cities.add("Miami");
        cities.add("London");
        cities.add("Paris");
        cities.add("Istanbul");
        cities.add("Berlin");
        cities.add("Barcelona");
        cities.add("Rome");
        cities.add("Brasilia");
        cities.add("Amsterdam");

        cars = new ArrayList<>();
        SelectItemGroup germanCars = new SelectItemGroup("German Cars");
        germanCars.setSelectItems(new SelectItem[]{
            new SelectItem("BMW", "BMW"),
            new SelectItem("Mercedes", "Mercedes"),
            new SelectItem("Volkswagen", "Volkswagen")
        });

        SelectItemGroup americanCars = new SelectItemGroup("American Cars");
        americanCars.setSelectItems(new SelectItem[]{
            new SelectItem("Chrysler", "Chrysler"),
            new SelectItem("GM", "GM"),
            new SelectItem("Ford", "Ford")
        });

        cars.add(germanCars);
        cars.add(americanCars);
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public String[] getSelectedConsoles() {
        return selectedConsoles;
    }

    /**
     * This is a setter which sets the name
     *
     * @param selectedConsoles - the name to be set
     */
    public void setSelectedConsoles(String[] selectedConsoles) {
        this.selectedConsoles = selectedConsoles;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public String[] getSelectedCities() {
        return selectedCities;
    }

    /**
     * This is a setter which sets the name
     *
     * @param selectedCities - the name to be set
     */
    public void setSelectedCities(String[] selectedCities) {
        this.selectedCities = selectedCities;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public String[] getSelectedCities2() {
        selectedCities2 = new String[3];
        selectedCities2[0] = ("Rome");
        selectedCities2[1] = ("London");
        selectedCities2[2] = ("Paris");
        return selectedCities2;
    }

    /**
     * This is a setter which sets the name
     *
     * @param selectedCities2 - the name to be set
     */
    public void setSelectedCities2(String[] selectedCities2) {
//        this.selectedCities2 = new String[2];
//        this.selectedCities2[0] = ("Miami");
//        this.selectedCities2[1] = ("London");
        this.selectedCities2 = selectedCities2;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public String[] getSelectedConsoles2() {
        return selectedConsoles2;
    }

    /**
     * This is a setter which sets the name
     *
     * @param selectedConsoles2 - the name to be set
     */
    public void setSelectedConsoles2(String[] selectedConsoles2) {
        this.selectedConsoles2 = selectedConsoles2;
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
     * This is a getter which gets the name
     *
     * @return
     */
    public List<SelectItem> getCars() {
        return cars;
    }

    /**
     * This is a setter which sets the name
     *
     * @param cars - the name to be set
     */
    public void setCars(List<SelectItem> cars) {
        this.cars = cars;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public String[] getSelectedCars() {
        return selectedCars;
    }

    /**
     * This is a getter which gets the name
     *
     * @param selectedCars
     */
    public void setSelectedCars(String[] selectedCars) {
        this.selectedCars = selectedCars;
    }

    /**
     * CheckboxView itemUnsSelect
     *
     * @param event
     */
    public void onItemUnselect(UnselectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();

        FacesMessage msg = new FacesMessage();
        msg.setSummary("Item unselected: " + event.getObject().toString());
        msg.setSeverity(FacesMessage.SEVERITY_INFO);

        context.addMessage(null, msg);
    }
}
