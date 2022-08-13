/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.security.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * author XCHEN202 date 04-01-2022 23:28 version V1.0 Lab8 desc
 */
@Entity
@Table(name = "sec_user")
@NamedQuery(name = "User.findAll", query = "select u from User u")
//@EntityListeners(UserListener.class)
public class User {

    @Id
    @NotBlank(message = "Without a username, how can I assert that you are who you say you are?")
    private String username;
    @NotBlank(message = "Password is required for entry")
    private String password;
    private Boolean enabled;

    @ManyToMany
    @JoinTable(name = "sec_user_groups",
            joinColumns = @JoinColumn(name = "USERNAME"),
            inverseJoinColumns = @JoinColumn(name = "GROUPNAME"))
    private List<Group> groups = new ArrayList<>();

    /**
     * 1:1 add the name
     *
     * @param g
     */
    public void addGroup(Group g) {
        if (!this.groups.contains(g)) {
            this.groups.add(g);
        }
        if (!g.getUsers().contains(this)) {
            g.getUsers().add(this);
        }
    }

    /**
     * 1:1 remove the name
     *
     * @param g
     */
    public void removeGroup(Group g) {
        if (this.groups.contains(g)) {
            this.groups.remove(g);
        }
        if (g.getUsers().contains(this)) {
            g.getUsers().remove(this);
        }
    }

    /**
     * empty construct
     */
    public User() {
    }

    /**
     * full column construct
     *
     * @param username
     * @param password
     * @param enabled
     */
    public User(String username, String password, Boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    /**
     * Get the value of username
     *
     * @return the value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * This is a setter which sets the name
     *
     * @param username - the name to be set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * This is a setter which sets the name
     *
     * @param password - the name to be set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * This is a setter which sets the name
     *
     * @param enabled - the name to be set
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "User{" + "username=" + username + ", password=" + password + ", enabled=" + enabled + '}';
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public List<Group> getGroups() {
        return groups;
    }

    /**
     * This is a setter which sets the name
     *
     * @param groups - the name to be set
     */
    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

}
