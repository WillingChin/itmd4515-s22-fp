/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.security.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * author XCHEN202 date 04-01-2022 23:29 version V1.0 Lab8 desc
 */
@Entity
@Table(name = "sec_group")
@NamedQuery(name = "Group.findAll", query = "select g from Group g")
public class Group {

    @Id
    private String groupName;
    private String groupDesc;

    @ManyToMany(mappedBy = "groups")
    private List<User> users = new ArrayList<>();

    /**
     * emtpy construct
     */
    public Group() {
    }

    /**
     * full column consutrct
     *
     * @param groupName
     * @param groupDesc
     */
    public Group(String groupName, String groupDesc) {
        this.groupName = groupName;
        this.groupDesc = groupDesc;
    }

    /**
     * Get the value of groupName
     *
     * @return the value of groupName
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * This is a setter which sets the name
     *
     * @param groupName - the name to be set
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * Get the value of groupName
     *
     * @return the value of groupDesc
     */
    public String getGroupDesc() {
        return groupDesc;
    }

    /**
     * This is a setter which sets the name
     *
     * @param groupDesc - the name to be set
     */
    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Group{" + "groupName=" + groupName + ", groupDesc=" + groupDesc + '}';
    }

    /**
     * Get the value of users
     *
     * @return the value of users
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * This is a setter which sets the name
     *
     * @param users - the name to be set
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }

}
