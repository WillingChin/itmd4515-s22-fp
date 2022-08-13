/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.web.admin;

import edu.iit.sat.itmd515.xchen202.security.GroupService;
import edu.iit.sat.itmd515.xchen202.security.UserService;
import edu.iit.sat.itmd515.xchen202.security.domain.Group;
import edu.iit.sat.itmd515.xchen202.security.domain.User;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

/**
 * author XCHEN202
 * date 04-17-2022 21:18
 * version V1.0 Lab 10 - JSF
 * desc
 */
@Named
@RequestScoped
public class UserController {

    private static final Logger LOG = Logger.getLogger(UserController.class.getName());

    @Inject
    private Pbkdf2PasswordHash hash;

    // represents the model I am working with on my view
    private User user;

    private String[] groupValues;

    private String newPassword;

    private String confirmPassword;

    @Inject
    FacesContext facesContext;

    @EJB
    private UserService userService;

    @EJB
    private GroupService grouppService;

    private boolean showSuccessMessage = false;

    /**
     * emtpy construct
     */
    public UserController() {
    }

    @PostConstruct
    private void postContruct() {
        LOG.info("postContruct of UserController...");
        // instance entity
        user = new User();
    }

    // helper methods
    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public List<Group> getAllGroups() {
        return grouppService.findAll();
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public String[] getAllGroupsStr() {
        List<Group> result = grouppService.findAll();
        String[] str = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            str[i] = result.get(i).getGroupName();
        }
        return str;
    }

    /**
     *
     * @return
     */
    public String[] getGroupValues() {
        return this.groupValues;
    }

    /**
     *
     * @param groupValues
     */
    public void setGroupValues(String[] groupValues) {
        this.groupValues = groupValues;
    }

    // action methods
    // the String return value is the page you want the user to navigate to when method returns
    /**
     *
     * @return
     */
    public String saveUser() {
        LOG.info("saveUser method with " + this.user.toString());
        //save entity. Account & Machine use SelectItemToEntityConverter to load data.
        userService.create(user);

        LOG.info("saveUser method after service invoked with " + this.user.toString());

        return "info.xhtml";
    }

    // action methods that prepare pages for user interaction
    // CRUD data operation: list, update, delete
    /**
     *
     * @param p
     * @return
     */
    public String displayReadPage(User p) {
        // Step 1 = set the model
        this.user = p;
        //p:selectCheckboxMenu to use
        groupValues = new String[user.getGroups().size()];
        List<Group> groups = user.getGroups();
        for (int i = 0; i < groups.size(); i++) {
            groupValues[i] = groups.get(i).getGroupName();
        }
        LOG.info("Inside readActionMethod with " + this.user.toString());

        return "/admin/user_info.xhtml";
    }

    /**
     *
     * @param p
     * @return
     */
    public String displayUpdatePage(User p) {
        // Step 1 = set the model
        this.user = p;
        //p:selectCheckboxMenu to use
        groupValues = new String[user.getGroups().size()];
        List<Group> groups = user.getGroups();
        for (int i = 0; i < groups.size(); i++) {
            groupValues[i] = groups.get(i).getGroupName();
        }
        LOG.info("Inside updateActionMethod with " + this.user.toString());
        this.user.setPassword(null);
        return "/admin/user_update.xhtml";
    }

    /**
     *
     * @param p
     * @return
     */
    public String displayUpdatePasswordPage(User p) {
        // Step 1 = set the model
        this.user = p;
        //p:selectCheckboxMenu to use
        groupValues = new String[user.getGroups().size()];
        List<Group> groups = user.getGroups();
        for (int i = 0; i < groups.size(); i++) {
            groupValues[i] = groups.get(i).getGroupName();
        }
        LOG.info("Inside updateActionMethod with " + this.user.toString());

        return "/admin/user_update.xhtml";
    }

    /**
     *
     * @param t
     * @return
     */
    public String displayDeletePage(User t) {
        this.user = t;
        //p:selectCheckboxMenu to use
        groupValues = new String[user.getGroups().size()];
        List<Group> groups = user.getGroups();
        for (int i = 0; i < groups.size(); i++) {
            groupValues[i] = groups.get(i).getGroupName();
        }
        LOG.info("Inside deleteActionMethod with " + this.user.toString());

        return "/admin/user_delete.xhtml";
    }

    // action methods that handle button clicks and invoke the service layer
    // CRUD page route: list, update, delete
    // But i don't not sure, update contact method replace in edit will work?
    /**
     *
     * @return
     */
    public String executeCreateButtonClick() {
        LOG.info("executeCreateButtonClick method with " + this.user.toString());

        if (!user.getPassword().equals(confirmPassword) || confirmPassword.isEmpty()) {
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fail!", "Confirm the password is wrong!"));
            showSuccessMessage = true;
            return "/admin/user_create.xhtml";
        }

        userService.createUser(user);

        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", "New User " + this.user.getUsername() + " has been created."));
        showSuccessMessage = true;
        return "/admin/user_list.xhtml";
    }

    /**
     *
     * @return
     */
    public String executeUpdateButtonClick() {
        LOG.info("executeUpdateButtonClick method with " + this.user.toString());
        LOG.info("executeUpdateButtonClick method with update password" + this.user.toString());
        User result = userService.read(user.getUsername());
        String oldPassword = hash.generate(user.getPassword().toCharArray());
        if (!this.user.getPassword().isEmpty() && !this.getNewPassword().isEmpty() && !this.getConfirmPassword().isEmpty()) {
            if (!result.getPassword().equals(oldPassword)) {
                facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fail!", "old password is wrong!"));
                showSuccessMessage = true;
                return "/admin/user_update.xhtml";
            }
            if (!oldPassword.equals(confirmPassword)) {
                facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fail!", "new password is wrong!"));
                showSuccessMessage = true;
                return "/admin/user_update.xhtml";
            }
            user.setPassword(newPassword);
        }
        String[] groups = this.getGroupValues();
        userService.updateUser(user, groups);

        return "/admin/user_list.xhtml?faces-redirect=true";
    }

    /**
     *
     * @return
     */
    public String executeDeleteButtonClick() {
        LOG.info("executeDeleteButtonClick method with " + this.user.toString());

        userService.delete(user);

        return "/admin/user_list.xhtml?faces-redirect=true";
    }

    // accessors and mutators are still required for usermodel fields
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

    /**
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

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public String getNewPassword() {
        return newPassword;
    }

    /**
     * This is a setter which sets the name
     *
     * @param newPassword - the name to be set
     */
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    /**
     *
     * @return
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * This is a setter which sets the name
     *
     * @param confirmPassword - the name to be set
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

}
