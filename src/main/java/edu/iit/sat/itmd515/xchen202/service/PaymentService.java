/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.service;

import edu.iit.sat.itmd515.xchen202.domain.Payment;
import java.util.List;
import javax.ejb.Stateless;

/**
 * author XCHEN202 date 03-01-2022 13:17 version V1.0 Lab6 desc
 */
@Stateless
public class PaymentService extends GenericService<Payment> {

    /**
     * empty construct inherit a generic type-read method will use the super
     * class information.
     */
    public PaymentService() {
        super(Payment.class);
    }

    /**
     * find all data
     *
     * @return
     */
    @Override
    public List<Payment> findAll() {
        return em.createNamedQuery("Payment.findAll", Payment.class).getResultList();
    }

}
