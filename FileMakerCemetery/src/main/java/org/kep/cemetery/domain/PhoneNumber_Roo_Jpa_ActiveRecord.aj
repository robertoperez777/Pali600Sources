// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.kep.cemetery.domain;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.kep.cemetery.domain.PhoneNumber;
import org.springframework.transaction.annotation.Transactional;

privileged aspect PhoneNumber_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager PhoneNumber.entityManager;
    
    public static final List<String> PhoneNumber.fieldNames4OrderClauseFilter = java.util.Arrays.asList("phoneNumber");
    
    public static final EntityManager PhoneNumber.entityManager() {
        EntityManager em = new PhoneNumber().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long PhoneNumber.countPhoneNumbers() {
        return entityManager().createQuery("SELECT COUNT(o) FROM PhoneNumber o", Long.class).getSingleResult();
    }
    
    public static List<PhoneNumber> PhoneNumber.findAllPhoneNumbers() {
        return entityManager().createQuery("SELECT o FROM PhoneNumber o", PhoneNumber.class).getResultList();
    }
    
    public static List<PhoneNumber> PhoneNumber.findAllPhoneNumbers(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM PhoneNumber o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, PhoneNumber.class).getResultList();
    }
    
    public static PhoneNumber PhoneNumber.findPhoneNumber(Long id) {
        if (id == null) return null;
        return entityManager().find(PhoneNumber.class, id);
    }
    
    public static List<PhoneNumber> PhoneNumber.findPhoneNumberEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM PhoneNumber o", PhoneNumber.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<PhoneNumber> PhoneNumber.findPhoneNumberEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM PhoneNumber o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, PhoneNumber.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void PhoneNumber.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void PhoneNumber.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            PhoneNumber attached = PhoneNumber.findPhoneNumber(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void PhoneNumber.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void PhoneNumber.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public PhoneNumber PhoneNumber.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        PhoneNumber merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
