/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Author;
import domain.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.AuthorService;
import service.BookService;

/**
 *
 * @author Freeroed
 */
public class CreateBook extends HttpServlet {
    
    @EJB
    AuthorService authorService;
    
    @EJB
    BookService bookService;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateBook</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateBook at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Author> authors = authorService.findAll();
            request.setAttribute("authors", authors);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/CreateBook.jsp");
            requestDispatcher.forward(request, response);
        } catch (IOException | ServletException e) { 
            throw new ServletException(e.getMessage()); 
        }  

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Book book = new Book();
        book.setName(request.getParameter("name"));
        book.setGenre(request.getParameter("genre"));
        Author author = authorService.find(Integer.parseInt(request.getParameter("author")));
        book.setAuthorId(author);
        bookService.create(book);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);

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
