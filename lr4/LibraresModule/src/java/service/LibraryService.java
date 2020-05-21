/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Library;
import java.util.List;

/**
 *
 * @author Freeroed
 */
public interface LibraryService {
    public List<Library> findAll();
    
    public void create(Library library);
    
    public void edit(Library library);
    
    public void remove(Library library);
    
    public Library find(int id);
    
    public void throwException(Library library);
    
    public void rollBack(Library library);
    
    public void noTransact(Library library);
    
    public void newTransact(Library library);
}
