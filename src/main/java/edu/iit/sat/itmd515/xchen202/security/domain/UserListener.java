/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.security.domain;

import javax.inject.Inject;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

/**
 * author XCHEN202 date 04-02-2022 01:20 version V1.0 Lab8 desc
 */
public class UserListener {

    @Inject
    private Pbkdf2PasswordHash hash;

    @PrePersist
    @PreUpdate
    private void prePersistAndUpdate(User u) {
        // hash the password
        u.setPassword(hash.generate(u.getPassword().toCharArray()));
    }

}
