/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.util;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.MoveEvent;

/**
 * Example from Web
 * ialogViewHandler use this java file. author XCHEN202 date 04-18-2022 05:58
 * version V1.0 Lab6 desc
 */
@Named
@RequestScoped
public class DialogView {

    /**
     * DialogViewHandler
     *
     * @param event
     */
    public void handleClose(CloseEvent event) {
        addMessage(event.getComponent().getId() + " closed", "So you don't like nature?");
    }

    /**
     * DialogViewHandler
     *
     * @param event
     */
    public void handleMove(MoveEvent event) {
        addMessage(event.getComponent().getId() + " moved", "Left: " + event.getLeft() + ", Top: " + event.getTop());
    }

    /**
     * DialogViewHandler
     */
    public void destroyWorld() {
        addMessage("System Error", "Please try again later.");
    }

    /**
     * DialogViewHandler
     *
     * @param summary
     * @param detail
     */
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
