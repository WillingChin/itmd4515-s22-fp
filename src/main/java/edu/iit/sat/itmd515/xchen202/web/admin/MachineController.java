/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.web.admin;

import edu.iit.sat.itmd515.xchen202.domain.Machine;
import edu.iit.sat.itmd515.xchen202.domain.MachineType;
import edu.iit.sat.itmd515.xchen202.domain.Treadmills;
import edu.iit.sat.itmd515.xchen202.service.MachineService;
import edu.iit.sat.itmd515.xchen202.service.TreadmillsService;
import edu.iit.sat.itmd515.xchen202.web.GenericController;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * author XCHEN202 date 04-17-2022 21:18 version V1.0 Lab 10 - JSF desc
 */
@Named
@RequestScoped
public class MachineController extends GenericController<Machine> {

    private static final Logger LOG = Logger.getLogger(MachineController.class.getName());

    @EJB
    private MachineService genericService;

    @EJB
    private TreadmillsService treadmillsService;

    /**
     * emtpy construct
     */
    public MachineController() {

    }

    @PostConstruct
    private void postContruct() {
        this.setGenericService(genericService);
        this.LOG.info("postContruct of MachineController...");
        this.setFolder("/admin");
        this.setEntityName("/machine");
        // instance entity
        this.setForm(new Machine());
    }

    // helper methods
    /**
     *
     * @return
     */
    public MachineType[] getAllMachineTypes() {
        return MachineType.values();
    }

    /**
     *
     * @param machine
     * @return
     */
    public Integer existsRelation(Machine machine) {
        List<Treadmills> list = treadmillsService.findMachineTreadmills(machine.getId());

        return list.size();
    }

}
