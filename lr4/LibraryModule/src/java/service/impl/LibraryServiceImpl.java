/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import domain.Library;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import service.LibraryService;

/**
 *
 * @author Freeroed
 */
@Stateless
public class LibraryServiceImpl implements LibraryService{
    
    @PersistenceContext(unitName = "LibraryModulePU")
    private EntityManager entityManager;

    @Override
    public List<Library> findAll() {
        List<Library> result = entityManager.createQuery("SELECT u FROM library u").getResultList();
        return result;
    }

    @Override
    public void create(Library library) {
        entityManager.persist(library);
    }

    @Override
    public void edit(Library library) {
        entityManager.merge(library);
    }

    @Override
    public void remove(Library library) {
        entityManager.remove(entityManager.merge(library));
    }

    @Override
    public Library find(int id) {
        return entityManager.find(Library.class, id);
    }
    
}
