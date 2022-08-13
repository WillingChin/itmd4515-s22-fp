/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.web;

import java.util.logging.Logger;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletRequest;

/**
 * author XCHEN202 date 04-08-2022 15:44 version V1.0 Lab9 desc
 */
public class JSFPhaseListener implements PhaseListener {

    private static final Logger LOG = Logger.getLogger(JSFPhaseListener.class.getName());

    /**
     * Recording everything requested before
     *
     * @param event
     */
    @Override
    public void beforePhase(PhaseEvent event) {
        //get request url
        FacesContext context = event.getFacesContext();
        HttpServletRequest request = (HttpServletRequest) (context.getExternalContext().getRequest());
        UIViewRoot root = context.getViewRoot();

        if (event.getPhaseId() == PhaseId.RESTORE_VIEW) {
            LOG.info("=================================== NEW JSF REQUEST STARTING ========================");
        }

        LOG.info("BEFORE JSF PAHSE -------------- " + event.getPhaseId().toString());
    }

    /**
     * Recording everything requested after
     *
     * @param event
     */
    @Override
    public void afterPhase(PhaseEvent event) {
        LOG.info("AFTER JSF PAHSE -------------- " + event.getPhaseId().toString());

        if (event.getPhaseId() == PhaseId.RENDER_RESPONSE) {
            LOG.info("=================================== JSF REQUEST COMPLETED ========================");
        }

    }

    /**
     * Get phase id
     *
     * @return
     */
    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
//        return PhaseId.PROCESS_VALIDATIONS;
    }

}
