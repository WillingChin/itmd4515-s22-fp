/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.security;

import com.mysql.cj.Session;
import edu.iit.sat.itmd515.xchen202.domain.GenericEntity;
import edu.iit.sat.itmd515.xchen202.domain.Treadmills;
import edu.iit.sat.itmd515.xchen202.security.domain.Group;
import edu.iit.sat.itmd515.xchen202.security.domain.User;
import edu.iit.sat.itmd515.xchen202.service.GenericService;
import java.sql.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

/**
 * author XCHEN202 date 04-02-2022 01:11 version V1.0 Lab8 desc
 */
@Stateless
public class UserService extends GenericService<User> {

    @Inject
    private Pbkdf2PasswordHash hash;

    /**
     * connection database tools
     */
    @PersistenceContext(name = "itmd4515PU")
    protected EntityManager em;

    /**
     * emtpy construct
     */
    public UserService() {
        super(User.class);
    }

    /**
     * find all data
     *
     * @return
     */
    @Override
    public List<User> findAll() {
        return em.createNamedQuery("User.findAll", User.class).getResultList();
    }

    /**
     * craete user encoding user password
     *
     * @param entity
     */
    public void createUser(User entity) {
        entity.setPassword(hash.generate(entity.getPassword().toCharArray()));

        em.persist(entity);
    }

    /**
     * update user
     *
     * @param user
     * @param groups - maintain user 1:M relationship
     */
    public void updateUser(User user, String[] groups) {
        List<Group> groupList = user.getGroups();
        for (int i = 0; i < groups.length; i++) {
            String groupName = groups[i];
            TypedQuery<Group> query = em.createQuery("select g from Group g where g.groupName = :groupName ", Group.class);
            query.setParameter("groupName", groupName);
            Group result = query.getSingleResult();
            if (result != null) {
                groupList.add(result);
            }
        }

        user.setGroups(groupList);
        em.merge(user);

        User result = this.read(user.getUsername());
        result.setEnabled(user.getEnabled());
        result.setGroups(groupList);
        em.merge(result);

    }

}
