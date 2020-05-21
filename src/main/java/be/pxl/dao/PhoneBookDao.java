package be.pxl.dao;

import be.pxl.domain.PhoneBookEntry;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PhoneBookDao {
    private EntityManager entityManager;

    public PhoneBookDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public PhoneBookEntry createEntry(PhoneBookEntry entry) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entry);
        transaction.commit();
        return entry;
    }
}
