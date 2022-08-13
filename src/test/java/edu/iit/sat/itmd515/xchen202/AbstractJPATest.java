/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202;


import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


/**
 *
 * @ClassName: AbstractJPATest
 * @author: XINN_CHEN
 * @since: Dec 18, 2021 15:58:01
 */
public class AbstractJPATest {

    /**
     * Connection database
     */
    protected static EntityManagerFactory emf;

    /**
     * Connection database tools
     */
    protected EntityManager em;

    /**
     * Entity Transation
     */
    protected EntityTransaction tx;

    /**
     * Create connection database
     */
    @BeforeAll
    public static void beforeAll() {
        emf = Persistence.createEntityManagerFactory("itmd4515testPU");
        // remember, anything we do in beforeAll, we likely need to account for in afterAll
    }
    
    /**
     * Junit5 method. save to using maybe next time will use
     */
    @BeforeEach
    public void beforeEach() {
        em = emf.createEntityManager();
        tx = em.getTransaction();
        
        // remember, anything we do in beforeEach, we likely need to account for in afterEach
    }
    
    /**
     * close connection database
     */
    @AfterEach
    public void afterEach() {
        
        em.close();
    }
    
    /**
     * close connection database
     */
    @AfterAll
    public static void afterAll() {
        emf.close();
    }
    
}
