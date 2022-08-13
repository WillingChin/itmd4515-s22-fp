/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.web;

import edu.iit.sat.itmd515.xchen202.domain.GenericEntity;
import edu.iit.sat.itmd515.xchen202.security.domain.User;
import edu.iit.sat.itmd515.xchen202.service.GenericService;
import java.util.List;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 * author XCHEN202 param <T>
 * date 04-02-2022 01:02 version V1.0 Lab8 desc
 */
public abstract class GenericController<T> {

    private static final Logger LOG = Logger.getLogger(GenericController.class.getName());

    private GenericEntity form;

    private String folder;

    private String entityName;

    @Inject
    FacesContext facesContext;

    private boolean showSuccessMessage = false;

    private GenericService genericService;

    /**
     * Empty construct
     */
    public GenericController() {

    }

    // helper methods
    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public List<User> getFindAll() {
        return genericService.findAll();
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public boolean isShowSuccessMessage() {
        return showSuccessMessage;
    }

    /**
     * This is a setter which sets the name
     *
     * @param showSuccessMessage - the name to be set
     */
    public void setShowSuccessMessage(boolean showSuccessMessage) {
        this.showSuccessMessage = showSuccessMessage;
    }

    // accessors and mutators are still required for usermodel fields
    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public GenericService getGenericService() {
        return genericService;
    }

    /**
     * This is a setter which sets the name
     *
     * @param genericService - the name to be set
     */
    public void setGenericService(GenericService genericService) {
        this.genericService = genericService;
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
    public String getEntityName() {
        return this.entityName;
    }

    /**
     * This is a setter which sets the name
     *
     * @param entityName - the name to be set
     */
    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public GenericEntity getForm() {
        return this.form;
    }

    /**
     *
     * @param form
     */
    public void setForm(GenericEntity form) {
        this.form = form;
    }

    // action methods that prepare pages for form interaction
    // CRUD data operation: list, update, delete
    /**
     *
     * @param entity
     * @return
     */
    public String displayReadPage(GenericEntity entity) {
        // Step 1 = set the model
        this.form = entity;
        LOG.info("Inside readActionMethod with " + this.form.toString());

        return folder + entityName + "_info.xhtml";
    }

    /**
     *
     * @param entity
     * @return
     */
    public String displayUpdatePage(GenericEntity entity) {
        // Step 1 = set the model
        this.form = entity;
        LOG.info("Inside updateActionMethod with " + this.form.toString());

        return folder + entityName + "_update.xhtml";
    }

    /**
     *
     * @param entity
     * @return
     */
    public String displayDeletePage(GenericEntity entity) {
        this.form = entity;

        LOG.info("Inside deleteActionMethod with " + this.form.toString());

        return folder + entityName + "_delete.xhtml";
    }

    // action methods that handle button clicks and invoke the service layer
    // CRUD page route: list, update, delete
    // But i don't not sure, update contact method replace in edit will work?
    /**
     *
     * @return
     */
    public String executeCreateButtonClick() {
        LOG.info("executeCreateButtonClick method with " + this.form.toString());

        genericService.create(form);

        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", "New Form " + this.form + " has been created."));
        showSuccessMessage = true;
        return folder + entityName + "_list.xhtml";
    }

    /**
     *
     * @return
     */
    public String executeUpdateButtonClick() {
        LOG.info("executeUpdateButtonClick method with " + this.form.toString());
        genericService.update(form);

        return folder + entityName + "_list.xhtml?faces-redirect=true";
    }

    /**
     *
     * @return
     */
    public String executeDeleteButtonClick() {
        LOG.info("executeDeleteButtonClick method with " + this.form.toString());
        genericService.delete(form);

        return folder + entityName + "_list.xhtml?faces-redirect=true";
    }

    /**
     *
     * @param entity
     * @return
     */
    public String executeDeleteButtonClick(GenericEntity entity) {
        Object findForm = genericService.read(entity.getId());
        LOG.info("executeDeleteButtonClick method with " + this.form.toString());

        genericService.delete(findForm);

        return folder + entityName + "_list.xhtml?faces-redirect=true";
    }

    /**
     *
     * @param entity
     * @param close
     * @return
     */
    public String executeCreateButtonClick(GenericEntity entity, String close) {
        LOG.info("executeCreateButtonClick method with " + this.form.toString());

        genericService.create(entity);

        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", "New Form " + this.form + " has been created."));
        showSuccessMessage = true;

        return folder + entityName + "_list.xhtml?faces-redirect=true";
    }

    /**
     *
     * @param entity
     * @param close
     * @return
     */
    public String executeUpdateButtonClick(GenericEntity entity, String close) {
        LOG.info("executeUpdateButtonClick method with " + this.form.toString());
        genericService.update(entity);

        return folder + entityName + "_list.xhtml?faces-redirect=true";
    }

    /**
     *
     * @param entity
     * @param close
     * @return
     */
    public String executeDeleteButtonClick(GenericEntity entity, String close) {
        Object findForm = genericService.read(entity.getId());
        LOG.info("executeDeleteButtonClick method with " + this.form.toString());

        genericService.delete(findForm);
        return folder + entityName + "_list.xhtml?faces-redirect=true";
    }

}
