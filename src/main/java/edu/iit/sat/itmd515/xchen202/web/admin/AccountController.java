/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.web.admin;

import edu.iit.sat.itmd515.xchen202.domain.Account;
import edu.iit.sat.itmd515.xchen202.domain.Treadmills;
import edu.iit.sat.itmd515.xchen202.security.UserService;
import edu.iit.sat.itmd515.xchen202.security.domain.User;
import edu.iit.sat.itmd515.xchen202.service.AccountService;
import edu.iit.sat.itmd515.xchen202.service.TreadmillsService;
import edu.iit.sat.itmd515.xchen202.web.GenericController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.PrimeFaces;

/**
 * author XCHEN202 date 04-17-2022 21:18 version V1.0 Lab 10 - JSF desc
 */
@Named
@RequestScoped
public class AccountController extends GenericController<Account> {

    private static final Logger LOG = Logger.getLogger(AccountController.class.getName());

    @EJB
    private AccountService genericService;

    /**
     * emtpy construct
     */
    public AccountController() {

    }

    @PostConstruct
    private void postContruct() {
        this.setGenericService(genericService);
        this.LOG.info("postContruct of AccountController...");
        this.setFolder("/admin");
        this.setEntityName("/account");
        // instance entity
        this.setForm(new Account());
    }

}
