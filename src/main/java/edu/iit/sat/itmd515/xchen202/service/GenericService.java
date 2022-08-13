/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.service;

import edu.iit.sat.itmd515.xchen202.domain.GenericEntity;
import edu.iit.sat.itmd515.xchen202.web.LoginController;
import java.time.LocalDateTime;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * author XCHEN202 param <T>
 * date 03-01-2022 13:05 version V1.0 Lab6 desc
 */
public abstract class GenericService<T> {

    /**
     * connection database tools
     */
    @PersistenceContext(name = "itmd4515PU")
    protected EntityManager em;

    @Inject
    FacesContext facesContext;

    @Inject
    private LoginController loginController;

    /**
     * entity class
     */
    protected final Class<T> entityClass;

    /**
     * read method used make sure search which class
     *
     * @param entityClass
     */
    public GenericService(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    // CRUD ops
    /**
     * * if a user was login. than will record create user and create
     * timestamp.
     *
     * @param entity
     */
    public void create(T entity) {
        if (entity instanceof GenericEntity) {
            FacesContext contenxt = FacesContext.getCurrentInstance();
            if (contenxt != null) {
                String username = facesContext.getExternalContext().getRemoteUser();
                GenericEntity genericEntity = (GenericEntity) entity;
                genericEntity.setCreatedBy(username);
                genericEntity.setCreatedTimestamp(LocalDateTime.now());
            }
        }
        em.persist(entity);
    }

    /**
     * em.fnd user by @Id annotation
     *
     * @param id
     * @return
     */
    public T read(java.io.Serializable id) {
        return em.find(entityClass, id);
    }

    /**
     * update T if a user was login. than will record update user and update
     * timestamp.
     *
     * @param entity
     */
    public void update(T entity) {
        if (entity instanceof GenericEntity) {
            FacesContext contenxt = FacesContext.getCurrentInstance();
            if (contenxt != null) {
                String username = facesContext.getExternalContext().getRemoteUser();
                GenericEntity genericEntity = (GenericEntity) entity;
                genericEntity.setUpdatedBy(username);
                genericEntity.setUpdatedTimestamp(LocalDateTime.now());
            }
        }
        em.merge(entity);
    }

    /**
     * em.remove the T
     *
     * @param entity
     */
    public void delete(T entity) {
        em.remove(em.merge(entity));
    }

    /**
     * find all data
     *
     * @return
     */
    abstract public List<T> findAll();

}
