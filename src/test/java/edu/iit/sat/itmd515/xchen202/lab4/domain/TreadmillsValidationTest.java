/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.lab4.domain;

import edu.iit.sat.itmd515.xchen202.AbstractJPATest;
import edu.iit.sat.itmd515.xchen202.domain.Account;
import edu.iit.sat.itmd515.xchen202.domain.Machine;
import edu.iit.sat.itmd515.xchen202.domain.Treadmills;
import java.util.Locale;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Instructor Example
 * @author XCHEN202
 * @date   03-01-2022 12:50 
 * @version V1.0 Lab6
 * @desc    
 */
public class TreadmillsValidationTest extends AbstractJPATest {
    
    private static Validator validator;
    
    /**
     * Before the junit5 test prepared work
     * seting Validator message language
     */
    @BeforeAll
    public static void beforeAll(){
        Locale.setDefault(Locale.ENGLISH);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    /**
     * Junit5 method. save to using maybe next time will use
     */
    @AfterEach
    public void afterEach(){
        
    }
    
    /**
     * Junit5 method. save to using maybe next time will use
     */
    @BeforeEach
    public void beforeEach(){
        
    }
    
    //test methods execute test cases, and we assert pass/fail
    // rainy day test case - meaning we expect validation to fail, but
    // because we assert in a way that we expect failure, the test case passes

    /**
     * Validation Treadmills entity annotation
     */
    @Test
    public void testInvalidStaffEmailValidationShouldFail() {
        Treadmills test = new Treadmills();
        test.setKcal(6000);
        test.setUseTime("1:30:15");
        
        
        Set<ConstraintViolation<Treadmills>> violations = validator.validate(test);
        for(ConstraintViolation<Treadmills> validation : violations){
            System.out.println(validation.toString());
        }
        
        
        assertEquals(3, violations.size());
        System.err.println("getMessage(): " + violations.iterator().next().getMessage());
        //assertEquals("must not be null", violations.iterator().next().getMessage());
        //new test message change by 03-01-2022 12:50 
//        assertEquals("must be less than or equal to 5000", violations.iterator().next().getMessage());
    }
    
    /**
     * Test Validation error size.
     */
    @Test
    public void validStaffValidationShouldPass() {
        Treadmills test = new Treadmills();
        test.setKcal(1200);
        test.setUseTime("1:30:15");
        Account a = new Account();
        test.setAccount(a);
        
        
        Machine m = new Machine();
        test.setMachine(m);
        
        
        Set<ConstraintViolation<Treadmills>> violations = validator.validate(test);
        for(ConstraintViolation<Treadmills> validation : violations){
            System.out.println(validation.toString());
        }
        
        
        assertEquals(0, violations.size());
        System.err.println("violations.isEmpty(): " + violations.isEmpty());
        assertTrue(violations.isEmpty());
    }
    
    /**
     * Junit5 method. save to using maybe next time will use
     */
    @AfterAll
    public static void afterAll(){
        
    }
    
    
}
