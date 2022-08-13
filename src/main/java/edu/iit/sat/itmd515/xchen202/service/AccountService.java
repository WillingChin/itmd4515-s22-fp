/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.service;

import edu.iit.sat.itmd515.xchen202.domain.Account;
import java.util.List;
import javax.ejb.Stateless;

/**
 * author XCHEN202 date 03-01-2022 13:07 version V1.0 Lab6 desc
 */
@Stateless
public class AccountService extends GenericService<Account> {

    /**
     * empty construct
     */
    public AccountService() {
        super(Account.class);
    }

    /**
     * find all data
     *
     * @return
     */
    @Override
    public List<Account> findAll() {
        return em.createNamedQuery("Account.findAll", Account.class).getResultList();
    }

}
