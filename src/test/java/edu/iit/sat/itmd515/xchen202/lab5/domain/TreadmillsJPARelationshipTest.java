/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.lab5.domain;


import edu.iit.sat.itmd515.xchen202.AbstractJPATest;
import edu.iit.sat.itmd515.xchen202.domain.Account;
import edu.iit.sat.itmd515.xchen202.domain.Machine;
import edu.iit.sat.itmd515.xchen202.domain.MachineType;
import edu.iit.sat.itmd515.xchen202.domain.Treadmills;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


/**
 *
 * @ClassName: TreadmillsJPARelationshipTest
 * @author: XINN_CHEN
 * @since: Dec 21, 2021 01:58:32
 */
public class TreadmillsJPARelationshipTest extends AbstractJPATest {
    
    private Integer testAccountId = 12;
    
    /**
     * JPA test 1:M relationship
     * Machine:Treadmills
     */
    @Test
    public void testBiDirectionalOneToManyAccountMachineRelationship(){
        Account a = new Account();
        a.setUsername("Test Name");
        a.setExpired(LocalDate.now().plusYears(1));
        
        Machine m = new Machine();
        m.setName("（2019）Supreme Edition");
        m.setOperationDesk("LED Red screen");
        m.setPower("3.0HP");
        m.setSpeed("1.0-10 Gear");
        m.setSize("1100*510mm");
        m.setWeight("38/45kg");
        m.setMachineType(MachineType.EXPENSIVE);
        m.setPrice(1999);
        
        Treadmills t = new Treadmills();
        t.setAltitude(0);
        t.setKcal(900);
        t.setMills(8);
        t.setStartDate(LocalDate.now());
        t.setUseTime("00:45:00");
        
        // Ex 4 - Manage both sides of a bi-directional relationship!
        t.setAccount(a);
        t.setMachine(m);
        
        
        tx.begin();
        em.persist(a);
        em.persist(m);
        em.persist(t);
        tx.commit();
        
        
        // assert success
        assertNotNull(t.getAccount().getId());
        assertNotNull(t.getMachine().getId());
        
        
        // clean up the test data
        tx.begin();
        t.setAccount(null);
        t.setMachine(null);
        em.remove(a);
        em.remove(m);
        em.remove(t);
        tx.commit();
    }
    
    
}

