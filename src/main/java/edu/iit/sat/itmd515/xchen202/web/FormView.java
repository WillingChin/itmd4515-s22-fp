/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.web;

/**
 * author XCHEN202 date 04-18-2022 17:43 version V1.0 Lab6 desc
 */
import edu.iit.sat.itmd515.xchen202.domain.GenericEntity;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.PrimeFaces;

/**
 * GenericController partner Dialog open controller.
 *
 * @author HASEE
 */
@ManagedBean(name = "formView")
@SessionScoped
public class FormView implements Serializable {

    private static final long serialVersionUID = -8897214602403269855L;

    private GenericEntity form;

    private String folder;

    private String entityName;

    private String dialogName;

    private String header = null;

    //CRUD opeartion flag
    private Boolean readonly = true;

    private String operation;

    private Object action;

    /**
     * Do something inital
     */
    @PostConstruct
    public void init() {
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public GenericEntity getForm() {
        return form;
    }

    /**
     * This is a setter which sets the name
     *
     * @param form - the name to be set
     */
    public void setForm(GenericEntity form) {
        this.form = form;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public String getFolder() {
        return this.folder;
    }

    /**
     * This is a setter which sets the name
     *
     * @param folder - the name to be set
     */
    public void setFolder(String folder) {
        this.folder = folder;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public String getDialogName() {
        return dialogName;
    }

    /**
     * This is a setter which sets the name
     *
     * @param dialogName - the name to be set
     */
    public void setDialogName(String dialogName) {
        this.dialogName = dialogName;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public String getHeader() {
        return header;
    }

    /**
     *
     * @param header
     */
    public void setHeader(String header) {
        this.header = header;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public String getEntityName() {
        return this.entityName;
    }

    /**
     *
     * @param entityName
     */
    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public Boolean getReadonly() {
        return readonly;
    }

    /**
     *
     * @param readonly
     */
    public void setReadonly(Boolean readonly) {
        this.readonly = readonly;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public String getOperation() {
        return operation;
    }

    /**
     *
     * @param operation
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /**
     * This is a setter which sets the name
     *
     * @param action - the name to be set
     */
    public void setAction(Object action) {
        this.action = action;
    }

    /**
     * Open dialog
     */
    public void viewForm() {
        Map<String, Object> options = new HashMap<String, Object>();
        options.put("resizable", true);
        options.put("modal", true);
        options.put("draggable", true);
        options.put("headerElement", "customheader");
        String dialog = "_dialog";
        if (dialogName != null && !dialogName.isEmpty()) {
            dialog = this.dialogName;
        }

        PrimeFaces.current().dialog().openDynamic(this.folder + this.entityName + dialog, options, null);
    }

    /**
     * Open dialog
     *
     * @param param
     */
    public void viewForm(String param) {
        Map<String, Object> options = new HashMap<String, Object>();
        options.put("resizable", true);
        options.put("modal", true);
        options.put("draggable", true);
        options.put("headerElement", "customheader");
        //json param set
        if (param != null && !param.isEmpty()) {
            String laoutSize = "";// analyze by param(json convert)
            if (laoutSize.equals("small")) {

            } else if (laoutSize.equals("large")) {

            } else if (laoutSize.equals("big")) {
                options.put("contentHeight", "100%");
                options.put("contentWidth", "90%");
                options.put("height", "90vh");
                options.put("width", "80%");
            }
        }

        String dialog = "_dialog";
        if (dialogName != null && !dialogName.isEmpty()) {
            dialog = this.dialogName;
        }

        PrimeFaces.current().dialog().openDynamic(this.folder + this.entityName + dialog, options, null);
    }

    /**
     * Close all current dialog
     */
    public void close() {
        PrimeFaces.current().dialog().closeDynamic(null);
    }

    /**
     * Close current dialog
     */
    public void doSomethingAndCloseDialog() {
        String dialog = "_dialog";
        if (dialogName != null && !dialogName.isEmpty()) {
            dialog = this.dialogName;
        }
        PrimeFaces.current().dialog().closeDynamic(this.folder + this.entityName + dialog);
    }

}
