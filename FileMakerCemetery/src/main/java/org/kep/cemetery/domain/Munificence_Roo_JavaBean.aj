// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.kep.cemetery.domain;

import java.math.BigDecimal;
import java.util.Date;
import org.kep.cemetery.domain.Munificence;

privileged aspect Munificence_Roo_JavaBean {
    
    public String Munificence.getPurpose() {
        return this.purpose;
    }
    
    public void Munificence.setPurpose(String purpose) {
        this.purpose = purpose;
    }
    
    public BigDecimal Munificence.getAmount() {
        return this.amount;
    }
    
    public void Munificence.setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    
    public Date Munificence.getYearOfMunificence() {
        return this.yearOfMunificence;
    }
    
    public void Munificence.setYearOfMunificence(Date yearOfMunificence) {
        this.yearOfMunificence = yearOfMunificence;
    }
    
    public String Munificence.getDescription() {
        return this.description;
    }
    
    public void Munificence.setDescription(String description) {
        this.description = description;
    }
    
}
