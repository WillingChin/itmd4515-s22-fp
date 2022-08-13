/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.config;

import javax.annotation.security.DeclareRoles;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;

/**
 * author XCHEN202 date 04-02-2022 00:03 version V1.0 Lab8 desc
 */
@Named
@ApplicationScoped
@DeclareRoles({SecurityConfig.ADMIN_ROLE, SecurityConfig.COACH_ROLE, SecurityConfig.USER_ROLE, SecurityConfig.GUEST_ROLE})
@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "java:app/jdbc/itmd4515DS",
        callerQuery = "select PASSWORD from sec_user where USERNAME = ?",
        groupsQuery = "select GROUPNAME from sec_user_groups where USERNAME = ?"
)
@CustomFormAuthenticationMechanismDefinition(
        loginToContinue = @LoginToContinue(loginPage = "/login.xhtml", errorPage = "/error.xhtml")
)
public class SecurityConfig {

    /**
     * System role: ADMIN_ROLE This role could maintain account, machine,
     */
    public static final String ADMIN_ROLE = "ADMIN_ROLE";
    /**
     * System role: COACH_ROLE
     */
    public static final String COACH_ROLE = "COACH_ROLE";
    /**
     * System role: USER_ROLE
     */
    public static final String USER_ROLE = "USER_ROLE";
    /**
     * System role: GUEST_ROLE
     */
    public static final String GUEST_ROLE = "GUEST_ROLE";
}
