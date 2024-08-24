package com.example.MakersSharkAssesment.repository;

import com.example.MakersSharkAssesment.model.Supplier;
import com.example.MakersSharkAssesment.utility.UtilityClass;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class SupplierRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Supplier> findSuppliersByLocationNatureOfBusinessAndManufacturingProcesses(String location, String natureOfBusiness, String manufacturingProcesses) {
        String countSql;
        int threshold = 10;
        int page = 0; // make constants class for this
        int size = 2;
        try {
            countSql = UtilityClass.getSql("CountSupplierQuery.sql", "COUNT");
            System.out.println("Loaded SQL Query: " + countSql);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load SQL from file", e);
        }
        Query countQuery = entityManager.createNativeQuery(countSql);
        countQuery.setParameter("location", location);
        countQuery.setParameter("natureOfBusiness", natureOfBusiness);
        countQuery.setParameter("manufacturingProcesses", manufacturingProcesses);

        long totalResults = ((Number) countQuery.getSingleResult()).longValue();

        String sql;
        try {
            sql = UtilityClass.getSql("SupplierQueries.sql", "SELECT");
            System.out.println("Loaded SQL Query: " + sql);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load SQL from file", e);
        }

        Query query = entityManager.createNativeQuery(sql, Supplier.class);
        query.setParameter("location", location);
        query.setParameter("natureOfBusiness", natureOfBusiness);
        query.setParameter("manufacturingProcesses", manufacturingProcesses);

        if (totalResults > threshold) {
            query.setFirstResult(page * size);
            query.setMaxResults(size);
        }
        return query.getResultList();
    }
}
