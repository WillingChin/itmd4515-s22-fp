/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.web;

import edu.iit.sat.itmd515.xchen202.domain.Treadmills;
import edu.iit.sat.itmd515.xchen202.service.TreadmillsService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.SecurityContext;

/**
 * author XCHEN202 date 04-12-2022 12:12 desc Dashboar
 */
@Named
@RequestScoped
public class DashboardController {

    private static final Logger LOG = Logger.getLogger(DashboardController.class.getName());

    private String today;

    @Inject
    FacesContext facesContext;
    @Inject
    SecurityContext securityContext;

    @EJB
    private TreadmillsService treadmillsService;

    /**
     * Empty construct
     */
    public DashboardController() {
    }

    @PostConstruct
    private void postConstruct() {
        LOG.info("Inside DashboardController postConstruct");
        today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM"));
    }

    // helper methods
    /**
     * Get current login user
     *
     * @return
     */
    public String getAuthenticatedUser() {
        return facesContext.getExternalContext().getRemoteUser();
    }

    //helpers
    /**
     * The home page uses a daily ranking list
     *
     * @return
     */
    public List<Treadmills> getRankingList() {
        List<Treadmills> list = treadmillsService.rankingList();
        return list;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public String getToday() {
        return today;
    }

}
