/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.lab5.domain;


import edu.iit.sat.itmd515.xchen202.AbstractJPATest;
import edu.iit.sat.itmd515.xchen202.domain.Account;
import edu.iit.sat.itmd515.xchen202.domain.Machine;
import edu.iit.sat.itmd515.xchen202.domain.MachineType;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


/**
 *
 * @ClassName: PetJPARelationshipTest
 * @author: XINN_CHEN
 * @since: Dec 19, 2021 09:58:32
 */
public class MachineJPARelationshipTest extends AbstractJPATest {
    
    private Integer testAccountId = 12;
    
    /**
     * JPA test 1:M relationship
     * Account:Machine
     */
    @Test
    public void testBiDirectionalOneToManyAccountMachineRelationship(){
        Account o = new Account();
        o.setUsername("Test Name");
        o.setExpired(LocalDate.now().plusYears(1));
        
        
        Machine p = new Machine();
        p.setName("（2019）Supreme Edition");
        p.setOperationDesk("LED Red screen");
        p.setPower("3.0HP");
        p.setSpeed("1.0-10 Gear");
        p.setSize("1100*510mm");
        p.setWeight("38/45kg");
        p.setMachineType(MachineType.EXPENSIVE);
        p.setPrice(1999);
        
        Machine p1 = new Machine();
        p1.setName("（2019）Deluxe Edition");
        p1.setOperationDesk("LED Red screen");
        p1.setPower("3.0HP");
        p1.setSpeed("1.0-8 Gear");
        p1.setSize("1100*490mm");
        p1.setWeight("35/40kg");
        p1.setMachineType(MachineType.CHEAP);
        p1.setPrice(1799);
        
        // Ex 1 - If we define an ORM relationship, but make no effort to
        // manage that relationship in our code, JPA does NOT do it for us.
        // IN class, we saw this by persisting two related entities without
        // managing the relationships.  What happened?
        
        // Ex 2 - In a bidirectional relationship, we have both owning and inverse
        // sides to the relationship.  What happens if we update the inverse side
        // but NOT the owning side.  Remember, the owning side controls the db
        // update
//        p.getAccounts().add(o);
        
        // Ex 3 - In a bidirectional relationship, what happens if we only
        // update the owning side, and not the inverse side.
//        o.getMachines().add(p);
        
        // Ex 4 - Manage both sides of a bi-directional relationship!
            o.getMachines().add(p);
            p.getAccounts().add(o);
        //o.addMachine(p);
        
        
        tx.begin();
        em.persist(o);
        em.persist(p);
        em.persist(p1);
        tx.commit();
        
        
        // For Ex 3 and Ex 4, let's check the persistence context and see what we can see...
        System.out.println("Navigate the relationship from the owning side: " + o.getMachines().toString());
        System.out.println("Navigate the relationship from the inverse side: " + p.getAccounts().toString());
        
        // assert success
        assertTrue(o.getMachines().size() == 1);
        assertTrue(p.getAccounts().size() == 1);
        
        // clean up the test data
        tx.begin();
        o.removeMachine(p);
        o.removeMachine(p1);
        em.remove(p);
        em.remove(o);
        tx.commit();
    }
    
}

