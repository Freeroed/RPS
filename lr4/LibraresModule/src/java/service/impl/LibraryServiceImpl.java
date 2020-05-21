/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import domain.Library;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import service.LibraryService;

/**
 *
 * @author Freeroed
 */
@Stateless
public class LibraryServiceImpl implements LibraryService{
    
    @PersistenceContext(unitName = "LibraresModulePU")
    private EntityManager entityManager;
    
    @Resource
    private SessionContext sessionContext;

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

    @Override
    public void throwException(Library library) throws EJBException{
        entityManager.persist(library);
        throw new EJBException();
    }

    @Override
    public void rollBack(Library library) {
        entityManager.persist(library);
        sessionContext.setRollbackOnly();
    }

    @Override
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public void noTransact(Library library) {
        entityManager.persist(library);
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void newTransact(Library library) {
        entityManager.persist(library);
    }
    
    
    
}
