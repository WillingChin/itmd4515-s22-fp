/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.util;

import edu.iit.sat.itmd515.xchen202.security.GroupService;
import edu.iit.sat.itmd515.xchen202.security.domain.Group;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Example from Web
 * @author sas
 */
@FacesConverter(value = "groupConverter", managed = true)
public class GroupConverter implements Converter<Group> {

    @EJB
    GroupService groupSvc;

    /**
     * Get group entity by group name
     *
     * @param context
     * @param component
     * @param value
     * @return
     */
    @Override
    public Group getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }

        Group group = groupSvc.findGroupByName(value);
        return group;
    }

    /**
     * Get goup name
     *
     * @param context
     * @param component
     * @param value
     * @return
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Group value) {
        if (value == null) {
            return "";
        }
        return String.valueOf(value.getGroupName());
    }

}
