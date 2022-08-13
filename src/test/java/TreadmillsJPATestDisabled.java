

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import edu.iit.sat.itmd515.xchen202.AbstractJPATest;
import edu.iit.sat.itmd515.xchen202.domain.Account;
import edu.iit.sat.itmd515.xchen202.domain.Machine;
import edu.iit.sat.itmd515.xchen202.domain.MachineType;
import edu.iit.sat.itmd515.xchen202.domain.Treadmills;
import java.time.LocalDate;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


/**
 *
 * @ClassName: TreadmillsJPATestDisabled
 * @author: XINN_CHEN
 * @since: Dec 18, 2021 15:58:01
 */
public class TreadmillsJPATestDisabled extends AbstractJPATest {
    
    private static final Logger LOG = Logger.getLogger(TreadmillsJPATestDisabled.class.getName());
    
    /**
     * Test create entity.
     */
    @Test
    public void create() {
        // create an entity
        Treadmills test = new Treadmills();
        test.setKcal(20);
        test.setUseTime("1:35:55");
        
        
        Account a = new Account();
        a.setUsername("Test Name");
        a.setExpired(LocalDate.now().plusYears(1));
        
        
        Machine p = new Machine();
        p.setName("（2019）Supreme Edition");
        p.setOperationDesk("LED Red screen");
        p.setPower("3.0HP");
        p.setSpeed("1.0-10 Gear");
        p.setSize("1100*510mm");
        p.setWeight("38/45kg");
        p.setMachineType(MachineType.EXPENSIVE);
        p.setPrice(1999);
        
        
        test.setAccount(a);
        test.setMachine(p);
        
        
        tx.begin();
        em.persist(a);
        em.persist(p);
        em.persist(test);
        tx.commit();
        // assert successful creation by reading it back
//        assertNotNull(test.getId());
        // cleanup
    }
    
    /**
     * Test read entity
     */
    @Test
    public void read() {
        Treadmills test
                = em.createQuery("select p from Treadmills p where p.useTime = '1:35:55' ", Treadmills.class).getSingleResult();
        assertNotNull(test);
        String data = test.getUseTime();
        assertEquals("1:35:55", data);
    }
    
    /**
     * Test update
     */
    @Test
    public void update() {
        // we can work with the beforeEach test data, just DO NOT modify any fields that might be used in afterEach to query the entity for cleanup
        // (or if you do, revert the change before exiting the method)
        // (why?  so that your afterEach doesn't fail... try it and see)
        Treadmills test
                = em.createQuery("select p from Treadmills p where  p.useTime = '1:35:55' ", Treadmills.class).getSingleResult();
        
        // make an update and write it to the database
        tx.begin();
        test.setKcal(900);
        tx.commit();
        
        // read it back from the database
        Treadmills readBackFromDatabaseToVerifyChange
                = em.createQuery("select p from Treadmills p where  p.useTime = '1:35:55' ", Treadmills.class).getSingleResult();
        
        LOG.info("update test case: " + readBackFromDatabaseToVerifyChange.toString());
        
        // assert change was successful
        assertEquals(900, readBackFromDatabaseToVerifyChange.getKcal());
    }
    
    /**
     * Test delete entity
     */
    @Test
    public void delete() {
        // create a new entity and write it to the database
        Treadmills test = new Treadmills();
        test.setKcal(300);
        test.setAccount(new Account());
        test.setMachine(new Machine("test machcine"));
        tx.begin();
        em.persist(test.getAccount());
        em.persist(test.getMachine());
        em.persist(test);
        tx.commit();
        
        
        // assert persist was successful
        assertNotNull(test.getId());
        LOG.info("test delete: " + test.toString());
        
        
        // delete it
        tx.begin();
        em.remove(test.getAccount());
        em.remove(test.getMachine());
        em.remove(test);
        tx.commit();
        
        LOG.info("test delete: " + test.toString());
        
        // assert delete was successful
        // we can use em.find here, because we actually know the PK id value
        Treadmills checkIfTreadmillsDeleted = em.find(Treadmills.class, test.getId());
        assertNull(checkIfTreadmillsDeleted);
    }
    
    
}

