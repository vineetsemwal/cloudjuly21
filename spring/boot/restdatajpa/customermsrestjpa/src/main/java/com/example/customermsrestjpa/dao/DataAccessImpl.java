package com.example.customermsrestjpa.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public class DataAccessImpl implements IDataAccess{

    @Autowired
    private EntityManager em;


    @Override
    public List allData(String entityName) {
        Query query = em.createQuery("from " + entityName);
        List list = query.getResultList();
       return list;
    }


}
