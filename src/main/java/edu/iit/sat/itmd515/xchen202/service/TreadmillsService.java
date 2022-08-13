/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.service;

import edu.iit.sat.itmd515.xchen202.domain.Treadmills;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NamedQuery;
import javax.persistence.TypedQuery;

/**
 * author XCHEN202 date 03-02-2022 00:23 version V1.0 Lab6 desc
 */
@Stateless
public class TreadmillsService extends GenericService<Treadmills> {

    /**
     * Empty construct Inherit a generic type-read method will use the super
     * class information.
     */
    public TreadmillsService() {
        super(Treadmills.class);
    }

    /**
     * Find all data
     *
     * @return
     */
    @Override
    public List<Treadmills> findAll() {
        return em.createNamedQuery("Treadmills.findAll", Treadmills.class).getResultList();
    }

    /**
     * Find all data by accountId
     *
     * @param accountId
     * @return
     */
    public List<Treadmills> findAll(java.io.Serializable accountId) {
        if (accountId == null) {
            return new ArrayList<Treadmills>();
        }
        TypedQuery<Treadmills> query = em.createNamedQuery("Treadmills.findAllById", Treadmills.class);
        query.setParameter("accountId", accountId);
        List<Treadmills> list = query.getResultList();
        return list;
    }

    //Get a ranking list of today.
    /**
     * The home page uses a daily ranking list
     *
     * @return
     */
    public List<Treadmills> rankingList() {
        StringBuffer sql = new StringBuffer("select t from Treadmills t ");
        sql.append("where t.startDate = :startDate ");
        sql.append("order by t.mills desc ");

        TypedQuery<Treadmills> query = em.createQuery(sql.toString(), Treadmills.class);
        query.setParameter("startDate", LocalDate.now());
        query.setMaxResults(10);
        List<Treadmills> list = query.getResultList();
        return list;
    }

    /**
     * Find user use treadmills record.
     *
     * @param username
     * @return
     */
    public List<Treadmills> findUserTreadmills(String username) {
        StringBuffer sql = new StringBuffer("select t from Treadmills t ");
        if (!username.isEmpty()) {
            sql.append("where t.createdBy = :useruame ");
        }
        sql.append("order by t.id desc ");
        TypedQuery<Treadmills> query = em.createQuery(sql.toString(), Treadmills.class);
        if (!username.isEmpty()) {
            query.setParameter("useruame", username);
        }
        List<Treadmills> list = query.getResultList();
        return list;
    }

    /**
     *
     * @param machineId
     * @return
     */
    public List<Treadmills> findMachineTreadmills(java.io.Serializable machineId) {
        StringBuffer sql = new StringBuffer("select t from Treadmills t ");
        if (machineId != null) {
            sql.append("where t.machine.id = :machineId ");
        }
        sql.append("order by t.id desc ");
        TypedQuery<Treadmills> query = em.createQuery(sql.toString(), Treadmills.class);
        if (machineId != null) {
            query.setParameter("machineId", machineId);
        }
        List<Treadmills> list = query.getResultList();
        return list;
    }

}
