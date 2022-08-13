/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.service;

import edu.iit.sat.itmd515.xchen202.domain.Machine;
import java.util.List;
import javax.ejb.Stateless;

/**
 * author XCHEN202 date 03-02-2022 00:23 version V1.0 Lab6 desc
 */
@Stateless
public class MachineService extends GenericService<Machine> {

    /**
     * empty construct inherit a generic type-read method will use the super
     * class information.
     */
    public MachineService() {
        super(Machine.class);
    }

    /**
     * find all data
     *
     * @return
     */
    @Override
    public List<Machine> findAll() {
        return em.createNamedQuery("Machine.findAll", Machine.class).getResultList();
    }

}
