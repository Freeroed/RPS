/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Library;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Freeroed
 */
@Stateless
public class LibraryFacade extends AbstractFacade<Library> {

    @PersistenceContext(unitName = "newLbrProjectPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LibraryFacade() {
        super(Library.class);
    }
    
}
