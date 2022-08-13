/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.web.user;

import edu.iit.sat.itmd515.xchen202.domain.Account;
import edu.iit.sat.itmd515.xchen202.domain.Machine;
import edu.iit.sat.itmd515.xchen202.domain.Treadmills;
import edu.iit.sat.itmd515.xchen202.web.LoginController;
import edu.iit.sat.itmd515.xchen202.service.AccountService;
import edu.iit.sat.itmd515.xchen202.service.MachineService;
import edu.iit.sat.itmd515.xchen202.service.TreadmillsService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * 
 * author XCHEN202
 * date 03-27-2022 21:18
 * version V1.0 Lab 7 - JSF
 * desc
 */
@Named
@RequestScoped
public class TreadmillsController {

    private static final Logger LOG = Logger.getLogger(TreadmillsController.class.getName());

    // represents the model I am working with on my view
    private Treadmills treadmills;

    @Inject
    FacesContext facesContext;

    @Inject
    private LoginController loginController;

    @EJB
    private TreadmillsService treadmillsService;

    @EJB
    private AccountService accountService;

    @EJB
    private MachineService machineService;

    private boolean showSuccessMessage = false;

    /**
     * Empty construct
     */
    public TreadmillsController() {
    }

    @PostConstruct
    private void postContruct() {
        LOG.info("postContruct of TreadmillsController...");
        // instance entity
        treadmills = new Treadmills();
    }

    // helper methods
    //f:selectItems load account data
    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public List<Account> getAllAccounts() {
        return accountService.findAll();
    }

    //f:selectItems load machine data
    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public List<Machine> getAllMachines() {
        return machineService.findAll();
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public List<Treadmills> getUserTreadmills() {
        List<Treadmills> list = treadmillsService.findUserTreadmills(loginController.getAuthenticatedUser());
        return list;
    }

    // action methods
    // the String return value is the page you want the user to navigate to when method returns
    /**
     * Forward to read page. It will binding a read button.
     *
     * @param t
     * @return
     */
    public String displayReadTreadmillsPage(Treadmills t) {
        // Step 1 = set the model
        this.treadmills = t;
        LOG.info("Inside readActionMethod with " + this.treadmills.toString());

        // Step 2 = render the appropriate view for the user to work with the model
        return "/user/treadmills_info.xhtml";

        // Step 3 = the user may click an action button or link to perform some
        // action on the model, which invokes another method in this controller
    }

    /**
     * Forward to update page. It will binding a update button.
     *
     * @param t
     * @return
     */
    public String displayUpdateTreadmillsPage(Treadmills t) {
        // Step 1 = set the model
        this.treadmills = t;
        LOG.info("Inside updateActionMethod with " + this.treadmills.toString());

        return "/user/treadmills_update.xhtml";
    }

    /**
     * Forward to delete page. It will binding a delete button.
     *
     * @param t
     * @return
     */
    public String displayDeleteTreadmillsPage(Treadmills t) {
        this.treadmills = t;

        LOG.info("Inside deleteActionMethod with " + this.treadmills.toString());

        return "/user/treadmills_delete.xhtml";
    }

    /**
     * Create method handler
     *
     * @return
     */
    public String executeCreateButtonClick() {
        LOG.info("executeCreateButtonClick method with " + this.treadmills.toString());

        treadmillsService.create(treadmills);

        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", "New Treadmills " + this.treadmills.getId() + " has been created."));
        showSuccessMessage = true;
        return "/user/treadmills_list.xhtml";

    }

    // action methods that prepare pages for user interaction
    // CRUD data operation: list, update, delete
    /**
     * Update method handler
     *
     * @return
     */
    public String executeUpdateButtonClick() {
        LOG.info("executeUpdateButtonClick method with " + this.treadmills.toString());
        Treadmills t = treadmillsService.read(treadmills.getId());
        t.setAccount(treadmills.getAccount());
        t.setMachine(treadmills.getMachine());
        t.setAltitude(treadmills.getAltitude());
        t.setMills(treadmills.getMills());
        t.setKcal(treadmills.getKcal());
        t.setStartDate(treadmills.getStartDate());
        t.setUseTime(treadmills.getUseTime());

        treadmillsService.update(t);

        return "/user/treadmills_list.xhtml?faces-redirect=true";
    }

    /**
     * Delete method handler
     *
     * @return
     */
    public String executeDeleteButtonClick() {
        LOG.info("executeDeleteButtonClick method with " + this.treadmills.toString());

        treadmillsService.delete(treadmills);

        return "/user/treadmills_list.xhtml?faces-redirect=true";
    }

    // accessors and mutators are still required for treadmillsmodel fields
    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public Treadmills getTreadmills() {
        return treadmills;
    }

    /**
     * This is a setter which sets the name
     *
     * @param treadmills - the name to be set
     */
    public void setTreadmills(Treadmills treadmills) {
        this.treadmills = treadmills;
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

}
