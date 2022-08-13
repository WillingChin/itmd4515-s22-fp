/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.util;

/**
 * author XCHEN202 date 04-18-2022 17:43 version V1.0 Lab6 desc
 */
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.primefaces.PrimeFaces;

/**
 *
 * Example from Web
 * @author HASEE
 */
@ManagedBean(name = "dtSelectionView")
@SessionScoped
public class SelectionView implements Serializable {

    private static final long serialVersionUID = -8897214602403269855L;

    private List<Car> cars;
    private Car selectedCar;

    @ManagedProperty("#{carService}")
    private CarService service;

    /**
     * Initial variables
     */
    @PostConstruct
    public void init() {
        service = new CarService();
        cars = service.createCars(20);
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public List<Car> getCars() {
        return cars;
    }

    /**
     *
     * @param service
     */
    public void setService(CarService service) {
        this.service = service;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public Car getSelectedCar() {
        return selectedCar;
    }

    /**
     *
     * @param selectedCar
     */
    public void setSelectedCar(Car selectedCar) {
        this.selectedCar = selectedCar;
    }

    /**
     * Open dialog view.
     */
    public void viewCar() {
        Map<String, Object> options = new HashMap<String, Object>();
        options.put("resizable", true);
        options.put("modal", true);
        options.put("draggable", true);
        options.put("headerElement", "customheader");

        PrimeFaces.current().dialog().openDynamic("car-dialog", options, null);
    }
}
