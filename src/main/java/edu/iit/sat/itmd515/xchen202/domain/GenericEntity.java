/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.domain;

import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * author XCHEN202 date 03-01-2022 12:27 version V1.0 Lab6 desc
 */
@MappedSuperclass
public class GenericEntity {

    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    private LocalDateTime createdTimestamp;
    private LocalDateTime updatedTimestamp;
    private String createdBy;
    private String updatedBy;

    @PrePersist
    private void generateCreatedTimestamp() {
        createdTimestamp = LocalDateTime.now();
    }

    @PreUpdate
    private void generateUpdatedTimestamp() {
        updatedTimestamp = LocalDateTime.now();
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * This is a setter which sets the name
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GenericEntity other = (GenericEntity) obj;

        // can not compare if EITHER database generated ID is null, return false
        if ((this.id == null) || (other.id == null)) {
            return false;
        }

        return Objects.equals(this.id, other.id);
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public LocalDateTime getCreatedTimestamp() {
        return createdTimestamp;
    }

    /**
     * This is a setter which sets the name
     *
     * @param createdTimestamp
     */
    public void setCreatedTimestamp(LocalDateTime createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public LocalDateTime getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    /**
     * This is a setter which sets the name
     *
     * @param updatedTimestamp
     */
    public void setUpdatedTimestamp(LocalDateTime updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * This is a getter which gets the name
     *
     * @param updatedBy
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * This is a getter which gets the name
     *
     * @return
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * This is a getter which gets the name
     *
     * @param createdBy
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

}
