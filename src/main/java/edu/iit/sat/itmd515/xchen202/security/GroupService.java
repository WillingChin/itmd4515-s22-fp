/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.security;

import edu.iit.sat.itmd515.xchen202.security.domain.Group;
import edu.iit.sat.itmd515.xchen202.service.GenericService;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 * author XCHEN202 ate 04-02-2022 01:11 version V1.0 Lab8 desc
 */
@Stateless
public class GroupService extends GenericService<Group> {

    /**
     * empty construct
     */
    public GroupService() {
        super(Group.class);
    }

    /**
     * find all data
     *
     * @return
     */
    @Override
    public List<Group> findAll() {
        return em.createNamedQuery("Group.findAll", Group.class).getResultList();
    }

    /**
     * find data by name
     *
     * @param groupName - search condition
     * @return
     */
    public Group findGroupByName(String groupName) {
        TypedQuery<Group> query = em.createQuery("select g from Group g where g.groupName = :groupName ", Group.class);
        query.setParameter("groupName", groupName);
        Group result = query.getSingleResult();
        return result;
    }

}
