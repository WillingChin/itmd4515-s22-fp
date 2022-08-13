/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.lab5.domain;


import edu.iit.sat.itmd515.xchen202.AbstractJPATest;
import edu.iit.sat.itmd515.xchen202.domain.Account;
import edu.iit.sat.itmd515.xchen202.domain.Payment;
import edu.iit.sat.itmd515.xchen202.domain.PaymentType;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


/**
 *
 * @ClassName: AccountJPARelationshipTest
 * @author: XINN_CHEN
 * @since: Dec 19, 2021 90:58:32
 */
public class AccountJPARelationshipTest extends AbstractJPATest {
    
    private Integer testAccountId = 15;
    
    /**
     * JPA test 1:M relationship
     * Account:Payment
     */
    @Test
    public void testBiDirectionalOneToManyAccountMachineRelationship(){
        //Client payment to buy two card.(year card, four month card)
        Account a = new Account();
        a.setUsername("Jack Li");
        a.setExpired(LocalDate.now());
        
        //Buy a card of one year.
        Payment p = new Payment();
        p.setMoney(1999);
        p.setType(PaymentType.Card);
        
        //Buy a card of one four month card.
        Payment p4 = new Payment();
        p4.setMoney(800);
        p4.setType(PaymentType.Card);
        
        
        //payment for year card
        LocalDate expired = a.getExpired();
        expired = expired.plusYears(1);
        a.setExpired(expired);
        //p.setAccount(a);
        
        
        //payment for four month card
        expired = expired.plusMonths(4);
        a.setExpired(expired);
        //p4.setAccount(a);
        
        
        // Ex 4 - Manage both sides of a bi-directional relationship!
        a.addPayment(p);
        a.addPayment(p4);
        
        
        tx.begin();
        em.persist(a);
        em.persist(p);
        em.persist(p4);
        tx.commit();
        
        
        // assert success
        assertNotNull(p.getAccount().getId());
        assertNotNull(p4.getAccount().getId());
        
        
        // clean up the test data
        tx.begin();
        em.remove(a);
        em.remove(p);
        em.remove(p4);
        tx.commit();
        
        
    }
    
    
}

