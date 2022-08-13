/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.web;

import edu.iit.sat.itmd515.xchen202.security.domain.User;
import edu.iit.sat.itmd515.xchen202.config.SecurityConfig;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * author XCHEN202 date 04-02-2022 12:12 version V1.0 Lab8 desc
 */
@Named
@RequestScoped
public class LoginController {

    private static final Logger LOG = Logger.getLogger(LoginController.class.getName());

    private User user;

    @Inject
    FacesContext facesContext;

    @Inject
    SecurityContext securityContext;

    /**
     * Empty construct
     */
    public LoginController() {
    }

    @PostConstruct
    private void postConstruct() {
        LOG.info("Inside LoginController postConstruct");
        user = new User();
    }

    // helper methods
    /**
     * Get login current user name
     *
     * @return
     */
    public String getAuthenticatedUser() {
        return facesContext.getExternalContext().getRemoteUser();
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public boolean isAdminRole() {
        return securityContext.isCallerInRole(SecurityConfig.ADMIN_ROLE);
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public boolean isCoachRole() {
        return securityContext.isCallerInRole(SecurityConfig.COACH_ROLE);
    }
    //same name, rename

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public boolean isUserRole() {
        return securityContext.isCallerInRole(SecurityConfig.USER_ROLE);
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public boolean isGuestRole() {
        return securityContext.isCallerInRole(SecurityConfig.GUEST_ROLE);
    }

    // action methods
    /**
     * Login method
     *
     * @return
     */
    public String doLogin() {
        LOG.info("Inside LoginController.doLogin()");

        Credential cred = new UsernamePasswordCredential(
                this.user.getUsername(),
                new Password(this.user.getPassword())
        );

        AuthenticationStatus status = securityContext.authenticate(
                (HttpServletRequest) facesContext.getExternalContext().getRequest(),
                (HttpServletResponse) facesContext.getExternalContext().getResponse(),
                AuthenticationParameters.withParams().credential(cred)
        );

        LOG.info("AuthenticationStatus is " + status.toString());

        switch (status) {
            case SEND_CONTINUE:
                LOG.info(status.toString());
                break;
            case SEND_FAILURE:
                LOG.info(status.toString());
                return "/error.xhtml";
            case SUCCESS:
                LOG.info(status.toString());
                break;
            case NOT_DONE:
                LOG.info(status.toString());
                return "/error.xhtml";
        }
        return "/index.xhtml?faces-redirect=true";
    }

    /**
     * Logout user
     *
     * @return
     */
    public String doLogout() {

        try {
            HttpServletRequest request
                    = (HttpServletRequest) facesContext.getExternalContext().getRequest();

            request.logout();

        } catch (ServletException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }

        return "/login.xhtml?faces-redirect=true";

    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public User getUser() {
        return user;
    }

    /**
     * This is a setter which sets the name
     *
     * @param user - the name to be set
     */
    public void setUser(User user) {
        this.user = user;
    }

}
