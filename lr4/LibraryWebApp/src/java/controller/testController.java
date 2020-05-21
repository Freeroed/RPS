/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Author;
import domain.Book;
import domain.Library;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.TransactionService;

/**
 *
 * @author Freeroed
 */
public class testController extends HttpServlet {
    
    @EJB
    private TransactionService transactionService;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    public void successTransact(){
        Library library = new Library();
        library.setName("Censral Success");
        library.setCountBooks(460);
        library.setAddress("Mira 19");
        
        Author author = new Author();
        author.setFio("Success author");
        author.setCountry("Success country");
        
        Book book = new Book();
        book.setName("Success book");
        book.setGenre("Comedy");
        Author tempAuthor = new Author();
        tempAuthor.setId(3);
        book.setAuthor(tempAuthor);
        transactionService.successTransact(book, library, author);
    }
    
    public void rollBackTransact(){
        Library library = new Library();
        library.setName("Censral rollback");
        library.setCountBooks(460);
        library.setAddress("Mira 19");
        
        Author author = new Author();
        author.setFio("Rollback author");
        author.setCountry("Rollback country");
        
        Book book = new Book();
        book.setName("Rollback book");
        book.setGenre("Roman");
        Author tempAuthor = new Author();
        tempAuthor.setId(1);
        book.setAuthor(tempAuthor);
        transactionService.rollBackTrasact(book, library, author);
    }
    
    public void throwEcxeptionTransact(){
        Library library = new Library();
        library.setName("Censral exception");
        library.setCountBooks(460);
        library.setAddress("Mira 19");
        
        Author author = new Author();
        author.setFio("Exception author");
        author.setCountry("Exception country");
        
        Book book = new Book();
        book.setName("Exception book");
        book.setGenre("Roman");
        Author tempAuthor = new Author();
        tempAuthor.setId(1);
        book.setAuthor(tempAuthor);
        transactionService.throwException(book, library, author);
    }
    
    public void noTransactRollback(){
        Library library = new Library();
        library.setName("Censral exception");
        library.setCountBooks(460);
        library.setAddress("Mira 19");
        
        Author author = new Author();
        author.setFio("Exception author");
        author.setCountry("Exception country");
        
        Book book = new Book();
        book.setName("Exception book");
        book.setGenre("Roman");
        Author tempAuthor = new Author();
        tempAuthor.setId(1);
        book.setAuthor(tempAuthor);
        transactionService.rollBackTrasact(book, library, author);
    }
    
    public void newTransact() {
        Library library = new Library();
        library.setName("Censral new Transact");
        library.setCountBooks(460);
        library.setAddress("Mira 19");
        
        Book book = new Book();
        book.setName("Exception book");
        book.setGenre("Roman");
        Author tempAuthor = new Author();
        tempAuthor.setId(1);
        book.setAuthor(tempAuthor);
        
        transactionService.newTransaction(book, library);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet testController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet testController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String test = request.getParameter("test");
        switch(test) {
            case"success":
                successTransact();
                break;
            case"rollback":
                rollBackTransact();
            case"Exception":
                throwEcxeptionTransact();
            case"NoTransact":
                noTransactRollback();
            case"NewTransact":
                newTransact();
                
         processRequest(request, response);       
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
